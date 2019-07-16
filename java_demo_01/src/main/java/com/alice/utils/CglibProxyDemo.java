package com.alice.utils;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 动态代理
 * cglib实现
 */
public class CglibProxyDemo implements MethodInterceptor {

    private Object target;

    public CglibProxyDemo(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object target, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("com.alice.utils.JDKProxyDemo.invoke == 1");
        Object invoke = methodProxy.invokeSuper(target, objects);
        System.out.println("com.alice.utils.JDKProxyDemo.invoke == 2");
        return invoke;
    }
}
