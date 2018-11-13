package com.myrom.controller.demo;


import java.lang.annotation.*;

/**
 * ${Description}
 *
 * @author mijp
 * @date 2018/5/18 14:23
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Myron {

    String name();

}
