package com.alice.beanCache;

import org.springframework.beans.BeansException;

/**
 * Spring解决循环依赖的诀窍就在于singletonFactories这个三级cache。这个cache的类型是ObjectFactory
 * @param <T>
 */
public interface ObjectFactory<T> {
    T getObject() throws BeansException;
}
