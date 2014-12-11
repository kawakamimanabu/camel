/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.component.jetty.jettyproducer;

import org.apache.camel.Exchange;
import org.apache.camel.ExchangeTimedOutException;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jetty.BaseJettyTest;
import org.junit.Test;

/**
 * @version 
 */
public class JettyHttpProducerTimeoutTest extends BaseJettyTest {

    private String url = "jetty://http://0.0.0.0:" + getPort() + "/timeout?httpClient.timeout=2000";

    @Test
    public void testTimeout() throws Exception {
        // these tests does not run well on Windows
        if (isPlatform("windows")) {
            return;
        }

        // give Jetty time to startup properly
        Thread.sleep(1000);
        final MyInputStream is = new MyInputStream("Content".getBytes());

        Exchange reply = template.request(url, new Processor() {
            @Override
            public void process(Exchange exchange) throws Exception {
                exchange.getIn().setBody(is);
            }
        });
        Exception e = reply.getException();
        assertNotNull("Should have thrown an exception", e);
        ExchangeTimedOutException cause = assertThrowable(ExchangeTimedOutException.class, e);
        assertEquals(2000, cause.getTimeout());
        assertTrue("The input stream should be closed", is.isClosed());
    }

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from(url).delay(5000).transform(constant("Bye World"));
            }
        };
    }
    
    
}