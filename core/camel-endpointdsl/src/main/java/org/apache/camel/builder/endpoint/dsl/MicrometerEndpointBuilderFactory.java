/*
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
package org.apache.camel.builder.endpoint.dsl;

import javax.annotation.Generated;
import org.apache.camel.builder.EndpointConsumerBuilder;
import org.apache.camel.builder.EndpointProducerBuilder;
import org.apache.camel.builder.endpoint.AbstractEndpointBuilder;

/**
 * To collect various metrics directly from Camel routes using the Micrometer
 * library.
 * 
 * Generated by camel-package-maven-plugin - do not edit this file!
 */
@Generated("org.apache.camel.maven.packaging.EndpointDslMojo")
public interface MicrometerEndpointBuilderFactory {


    /**
     * Builder for endpoint for the Micrometer component.
     */
    public interface MicrometerEndpointBuilder
            extends
                EndpointProducerBuilder {
        default AdvancedMicrometerEndpointBuilder advanced() {
            return (AdvancedMicrometerEndpointBuilder) this;
        }
        /**
         * Action expression when using timer type.
         * 
         * The option is a: <code>java.lang.String</code> type.
         * 
         * Group: producer
         */
        default MicrometerEndpointBuilder action(String action) {
            doSetProperty("action", action);
            return this;
        }
        /**
         * Decrement value expression when using counter type.
         * 
         * The option is a: <code>java.lang.String</code> type.
         * 
         * Group: producer
         */
        default MicrometerEndpointBuilder decrement(String decrement) {
            doSetProperty("decrement", decrement);
            return this;
        }
        /**
         * Increment value expression when using counter type.
         * 
         * The option is a: <code>java.lang.String</code> type.
         * 
         * Group: producer
         */
        default MicrometerEndpointBuilder increment(String increment) {
            doSetProperty("increment", increment);
            return this;
        }
        /**
         * Whether the producer should be started lazy (on the first message).
         * By starting lazy you can use this to allow CamelContext and routes to
         * startup in situations where a producer may otherwise fail during
         * starting and cause the route to fail being started. By deferring this
         * startup to be lazy then the startup failure can be handled during
         * routing messages via Camel's routing error handlers. Beware that when
         * the first message is processed then creating and starting the
         * producer may take a little time and prolong the total processing time
         * of the processing.
         * 
         * The option is a: <code>boolean</code> type.
         * 
         * Group: producer
         */
        default MicrometerEndpointBuilder lazyStartProducer(
                boolean lazyStartProducer) {
            doSetProperty("lazyStartProducer", lazyStartProducer);
            return this;
        }
        /**
         * Whether the producer should be started lazy (on the first message).
         * By starting lazy you can use this to allow CamelContext and routes to
         * startup in situations where a producer may otherwise fail during
         * starting and cause the route to fail being started. By deferring this
         * startup to be lazy then the startup failure can be handled during
         * routing messages via Camel's routing error handlers. Beware that when
         * the first message is processed then creating and starting the
         * producer may take a little time and prolong the total processing time
         * of the processing.
         * 
         * The option will be converted to a <code>boolean</code> type.
         * 
         * Group: producer
         */
        default MicrometerEndpointBuilder lazyStartProducer(
                String lazyStartProducer) {
            doSetProperty("lazyStartProducer", lazyStartProducer);
            return this;
        }
        /**
         * Value expression when using histogram type.
         * 
         * The option is a: <code>java.lang.String</code> type.
         * 
         * Group: producer
         */
        default MicrometerEndpointBuilder value(String value) {
            doSetProperty("value", value);
            return this;
        }
    }

    /**
     * Advanced builder for endpoint for the Micrometer component.
     */
    public interface AdvancedMicrometerEndpointBuilder
            extends
                EndpointProducerBuilder {
        default MicrometerEndpointBuilder basic() {
            return (MicrometerEndpointBuilder) this;
        }
        /**
         * Whether the endpoint should use basic property binding (Camel 2.x) or
         * the newer property binding with additional capabilities.
         * 
         * The option is a: <code>boolean</code> type.
         * 
         * Group: advanced
         */
        default AdvancedMicrometerEndpointBuilder basicPropertyBinding(
                boolean basicPropertyBinding) {
            doSetProperty("basicPropertyBinding", basicPropertyBinding);
            return this;
        }
        /**
         * Whether the endpoint should use basic property binding (Camel 2.x) or
         * the newer property binding with additional capabilities.
         * 
         * The option will be converted to a <code>boolean</code> type.
         * 
         * Group: advanced
         */
        default AdvancedMicrometerEndpointBuilder basicPropertyBinding(
                String basicPropertyBinding) {
            doSetProperty("basicPropertyBinding", basicPropertyBinding);
            return this;
        }
        /**
         * Sets whether synchronous processing should be strictly used, or Camel
         * is allowed to use asynchronous processing (if supported).
         * 
         * The option is a: <code>boolean</code> type.
         * 
         * Group: advanced
         */
        default AdvancedMicrometerEndpointBuilder synchronous(
                boolean synchronous) {
            doSetProperty("synchronous", synchronous);
            return this;
        }
        /**
         * Sets whether synchronous processing should be strictly used, or Camel
         * is allowed to use asynchronous processing (if supported).
         * 
         * The option will be converted to a <code>boolean</code> type.
         * 
         * Group: advanced
         */
        default AdvancedMicrometerEndpointBuilder synchronous(String synchronous) {
            doSetProperty("synchronous", synchronous);
            return this;
        }
    }
    /**
     * Micrometer (camel-micrometer)
     * To collect various metrics directly from Camel routes using the
     * Micrometer library.
     * 
     * Category: monitoring
     * Since: 2.22
     * Maven coordinates: org.apache.camel:camel-micrometer
     * 
     * Syntax: <code>micrometer:metricsType:metricsName</code>
     * 
     * Path parameter: metricsType (required)
     * Type of metrics
     * 
     * Path parameter: metricsName (required)
     * Name of metrics
     * 
     * Path parameter: tags
     * Tags of metrics
     */
    default MicrometerEndpointBuilder micrometer(String path) {
        class MicrometerEndpointBuilderImpl extends AbstractEndpointBuilder implements MicrometerEndpointBuilder, AdvancedMicrometerEndpointBuilder {
            public MicrometerEndpointBuilderImpl(String path) {
                super("micrometer", path);
            }
        }
        return new MicrometerEndpointBuilderImpl(path);
    }
}