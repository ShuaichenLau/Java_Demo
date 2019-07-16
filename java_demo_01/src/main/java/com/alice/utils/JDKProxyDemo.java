package com.alice.utils;

import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

/**
 * 静态代理
 * jdk实现
 */
public class JDKProxyDemo implements InvocationHandler {

    private Object target;

    public JDKProxyDemo(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object target, Method method, Object[] objects) throws Throwable {
        System.out.println("com.alice.utils.JDKProxyDemo.invoke == 1");
        Object invoke = method.invoke(target, objects);
        System.out.println("com.alice.utils.JDKProxyDemo.invoke == 2");
        return invoke;
    }
}
