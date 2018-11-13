package com.myrom.controller.demo;

/**
 * ${Description}
 *
 * @author mijp
 * @date 2018/5/18 14:27
 */
@Myron(name = "myron")
public class Annotation {

    public void say(String name) {
        System.out.println("哈哈哈哈，我就是这么屌！ " + name);
    }
}
