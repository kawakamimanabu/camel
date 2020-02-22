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
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.EndpointConsumerBuilder;
import org.apache.camel.builder.EndpointProducerBuilder;
import org.apache.camel.builder.endpoint.AbstractEndpointBuilder;

/**
 * The controlbus component provides easy management of Camel applications based
 * on the Control Bus EIP pattern.
 * 
 * Generated by camel-package-maven-plugin - do not edit this file!
 */
@Generated("org.apache.camel.maven.packaging.EndpointDslMojo")
public interface ControlBusEndpointBuilderFactory {


    /**
     * Builder for endpoint for the Control Bus component.
     */
    public interface ControlBusEndpointBuilder
            extends
                EndpointProducerBuilder {
        default AdvancedControlBusEndpointBuilder advanced() {
            return (AdvancedControlBusEndpointBuilder) this;
        }
        /**
         * To denote an action that can be either: start, stop, or status. To
         * either start or stop a route, or to get the status of the route as
         * output in the message body. You can use suspend and resume from Camel
         * 2.11.1 onwards to either suspend or resume a route. And from Camel
         * 2.11.1 onwards you can use stats to get performance statics returned
         * in XML format; the routeId option can be used to define which route
         * to get the performance stats for, if routeId is not defined, then you
         * get statistics for the entire CamelContext. The restart action will
         * restart the route.
         * 
         * The option is a: <code>java.lang.String</code> type.
         * 
         * Group: producer
         */
        default ControlBusEndpointBuilder action(String action) {
            doSetProperty("action", action);
            return this;
        }
        /**
         * Whether to execute the control bus task asynchronously. Important: If
         * this option is enabled, then any result from the task is not set on
         * the Exchange. This is only possible if executing tasks synchronously.
         * 
         * The option is a: <code>boolean</code> type.
         * 
         * Group: producer
         */
        default ControlBusEndpointBuilder async(boolean async) {
            doSetProperty("async", async);
            return this;
        }
        /**
         * Whether to execute the control bus task asynchronously. Important: If
         * this option is enabled, then any result from the task is not set on
         * the Exchange. This is only possible if executing tasks synchronously.
         * 
         * The option will be converted to a <code>boolean</code> type.
         * 
         * Group: producer
         */
        default ControlBusEndpointBuilder async(String async) {
            doSetProperty("async", async);
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
        default ControlBusEndpointBuilder lazyStartProducer(
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
        default ControlBusEndpointBuilder lazyStartProducer(
                String lazyStartProducer) {
            doSetProperty("lazyStartProducer", lazyStartProducer);
            return this;
        }
        /**
         * Logging level used for logging when task is done, or if any
         * exceptions occurred during processing the task.
         * 
         * The option is a: <code>org.apache.camel.LoggingLevel</code> type.
         * 
         * Group: producer
         */
        default ControlBusEndpointBuilder loggingLevel(LoggingLevel loggingLevel) {
            doSetProperty("loggingLevel", loggingLevel);
            return this;
        }
        /**
         * Logging level used for logging when task is done, or if any
         * exceptions occurred during processing the task.
         * 
         * The option will be converted to a
         * <code>org.apache.camel.LoggingLevel</code> type.
         * 
         * Group: producer
         */
        default ControlBusEndpointBuilder loggingLevel(String loggingLevel) {
            doSetProperty("loggingLevel", loggingLevel);
            return this;
        }
        /**
         * The delay in millis to use when restarting a route.
         * 
         * The option is a: <code>int</code> type.
         * 
         * Group: producer
         */
        default ControlBusEndpointBuilder restartDelay(int restartDelay) {
            doSetProperty("restartDelay", restartDelay);
            return this;
        }
        /**
         * The delay in millis to use when restarting a route.
         * 
         * The option will be converted to a <code>int</code> type.
         * 
         * Group: producer
         */
        default ControlBusEndpointBuilder restartDelay(String restartDelay) {
            doSetProperty("restartDelay", restartDelay);
            return this;
        }
        /**
         * To specify a route by its id. The special keyword current indicates
         * the current route.
         * 
         * The option is a: <code>java.lang.String</code> type.
         * 
         * Group: producer
         */
        default ControlBusEndpointBuilder routeId(String routeId) {
            doSetProperty("routeId", routeId);
            return this;
        }
    }

    /**
     * Advanced builder for endpoint for the Control Bus component.
     */
    public interface AdvancedControlBusEndpointBuilder
            extends
                EndpointProducerBuilder {
        default ControlBusEndpointBuilder basic() {
            return (ControlBusEndpointBuilder) this;
        }
        /**
         * Whether the endpoint should use basic property binding (Camel 2.x) or
         * the newer property binding with additional capabilities.
         * 
         * The option is a: <code>boolean</code> type.
         * 
         * Group: advanced
         */
        default AdvancedControlBusEndpointBuilder basicPropertyBinding(
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
        default AdvancedControlBusEndpointBuilder basicPropertyBinding(
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
        default AdvancedControlBusEndpointBuilder synchronous(
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
        default AdvancedControlBusEndpointBuilder synchronous(String synchronous) {
            doSetProperty("synchronous", synchronous);
            return this;
        }
    }
    /**
     * Control Bus (camel-controlbus)
     * The controlbus component provides easy management of Camel applications
     * based on the Control Bus EIP pattern.
     * 
     * Category: core,monitoring
     * Since: 2.11
     * Maven coordinates: org.apache.camel:camel-controlbus
     * 
     * Syntax: <code>controlbus:command:language</code>
     * 
     * Path parameter: command (required)
     * Command can be either route or language
     * The value can be one of: route, language
     * 
     * Path parameter: language
     * Allows you to specify the name of a Language to use for evaluating the
     * message body. If there is any result from the evaluation, then the result
     * is put in the message body.
     * The value can be one of: bean, constant, el, exchangeProperty, file,
     * groovy, header, jsonpath, mvel, ognl, ref, simple, spel, sql, terser,
     * tokenize, xpath, xquery, xtokenize
     */
    default ControlBusEndpointBuilder controlbus(String path) {
        class ControlBusEndpointBuilderImpl extends AbstractEndpointBuilder implements ControlBusEndpointBuilder, AdvancedControlBusEndpointBuilder {
            public ControlBusEndpointBuilderImpl(String path) {
                super("controlbus", path);
            }
        }
        return new ControlBusEndpointBuilderImpl(path);
    }
}