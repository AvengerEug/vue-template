package com.eugene.sso.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ConstructDynamicProxy<T> {

    // 被代理对象
    private T t;

    // 代理对象
    private InvocationHandler invocationHandler;

    public ConstructDynamicProxy(T t, InvocationHandler invocationHandler) {
        this.t = t;
        this.invocationHandler = invocationHandler;
    }

    public T getProxy() {
        return (T) Proxy.newProxyInstance(t.getClass().getClassLoader(), t.getClass().getInterfaces(), invocationHandler);
    }
}
