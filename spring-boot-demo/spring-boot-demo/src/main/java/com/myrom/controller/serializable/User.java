package com.myrom.controller.serializable;

import java.io.Serializable;

/**
 * ${Description}
 *
 * @author mijp
 * @date 2018/6/9 16:32
 */
public class User implements Serializable {


    private String name;
    private int age;
    public static int count = 5;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
