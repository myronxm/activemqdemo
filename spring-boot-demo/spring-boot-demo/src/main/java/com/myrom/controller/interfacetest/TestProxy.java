package com.myrom.controller.interfacetest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ${Description}
 *
 * @author mijp
 * @date 2018/6/22 16:15
 */
public class TestProxy implements InvocationHandler {

    private TestInterface testInterface;


    public Object instance(TestInterface test){
        testInterface = test;
        Class<?> clazz = testInterface.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        method.invoke(testInterface, args);
        return null;
    }
}
