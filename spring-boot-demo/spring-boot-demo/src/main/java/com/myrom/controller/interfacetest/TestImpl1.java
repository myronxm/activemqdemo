package com.myrom.controller.interfacetest;

/**
 * ${Description}
 *
 * @author mijp
 * @date 2018/6/22 16:12
 */
public class TestImpl1 implements TestInterface {
    @Override
    public String say(String hello) {
        System.out.println("impl1:" + hello);
        return null;
    }
}
