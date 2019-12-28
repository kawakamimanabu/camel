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
package org.apache.camel.impl.engine;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;

import org.apache.camel.RuntimeCamelException;
import org.apache.camel.spi.ClassResolver;
import org.apache.camel.spi.FactoryFinder;
import org.apache.camel.support.ObjectHelper;
import org.apache.camel.util.IOHelper;

/**
 * Default factory finder.
 */
public class DefaultFactoryFinder implements FactoryFinder {

    private final ConcurrentMap<String, Class<?>> classMap = new ConcurrentHashMap<>();
    private final ClassResolver classResolver;
    private final String path;

    public DefaultFactoryFinder(ClassResolver classResolver, String resourcePath) {
        this.classResolver = classResolver;
        this.path = resourcePath;
    }

    @Override
    public String getResourcePath() {
        return path;
    }

    @Override
    public Optional<Object> newInstance(String key) {
        return Optional.ofNullable(doNewInstance(key, null));
    }

    @Override
    public <T> Optional<T> newInstance(String key, Class<T> type) {
        Object obj = doNewInstance(key, null);
        return Optional.ofNullable(type.cast(obj));
    }

    @Override
    public Optional<Class<?>> findClass(String key) {
        return findClass(key, null);
    }

    @Override
    public Optional<Class<?>> findClass(String key, String propertyPrefix) {
        final String prefix = propertyPrefix != null ? propertyPrefix : "";
        final String classKey = prefix + key;

        Class<?> clazz = addToClassMap(classKey, () -> {
            Properties prop = doFindFactoryProperties(key);
            if (prop != null) {
                return doNewInstance(prop, prefix, true).orElse(null);
            } else {
                return null;
            }
        });
        return Optional.ofNullable(clazz);
    }

    @Override
    public Optional<Class<?>> findClass(String key, String propertyPrefix, Class<?> clazz) {
        // Just ignore clazz which is only useful for OSGiFactoryFinder
        return findClass(key, propertyPrefix);
    }

    @Override
    public Optional<Class<?>> findOptionalClass(String key, String propertyPrefix) {
        final String prefix = propertyPrefix != null ? propertyPrefix : "";
        final String classKey = prefix + key;

        Class<?> clazz = addToClassMap(classKey, () -> {
            Properties prop = doFindFactoryProperties(key);
            if (prop != null) {
                return doNewInstance(prop, prefix, false).orElse(null);
            } else {
                return null;
            }
        });
        return Optional.ofNullable(clazz);
    }

    private Object doNewInstance(String key, String propertyPrefix) {
        Optional<Class<?>> clazz = findClass(key, propertyPrefix);
        return clazz.map(ObjectHelper::newInstance).orElse(null);
    }

    private Optional<Class<?>> doNewInstance(Properties properties, String propertyPrefix, boolean mandatory) throws IOException {
        String className = properties.getProperty(propertyPrefix + "class");
        if (className == null && mandatory) {
            throw new IOException("Expected property is missing: " + propertyPrefix + "class");
        } else if (className == null) {
            return Optional.empty();
        }

        Class<?> clazz = classResolver.resolveClass(className);
        return Optional.ofNullable(clazz);
    }

    private Properties doFindFactoryProperties(String key) throws IOException {
        String uri = path + key;

        InputStream in = classResolver.loadResourceAsStream(uri);
        if (in == null) {
            return null;
        }

        // lets load the file
        BufferedInputStream reader = null;
        try {
            reader = IOHelper.buffered(in);
            Properties properties = new Properties();
            properties.load(reader);
            return properties;
        } finally {
            IOHelper.close(reader, key, null);
            IOHelper.close(in, key, null);
        }
    }

    /*
     * This is a wrapper function to deal with exceptions in lambdas: the exception
     * is wrapped by a runtime exception (WrappedRuntimeException) which we catch
     * later on with the only purpose to re-throw the original exception.
     */
    protected Class<?> addToClassMap(String key, ClassSupplier mappingFunction) {
        return classMap.computeIfAbsent(key, new Function<String, Class<?>>() {
            @Override
            public Class<?> apply(String classKey) {
                try {
                    return mappingFunction.get();
                } catch (Exception e) {
                    throw RuntimeCamelException.wrapRuntimeException(e);
                }
            }
        });
    }

    @FunctionalInterface
    protected interface ClassSupplier {
        Class<?> get() throws Exception;
    }

}
