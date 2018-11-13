package com.myrom.controller.interfacetest;

/**
 * ${Description}
 *
 * @author mijp
 * @date 2018/6/22 16:14
 */
public class TestMain {

    public static void main(String[]args){

        try {
            TestInterface aa = (TestInterface) TestProxy.class.newInstance().instance(new TestImpl1());
            aa.say("myron");

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
