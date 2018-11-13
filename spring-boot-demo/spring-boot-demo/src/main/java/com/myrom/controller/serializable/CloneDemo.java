package com.myrom.controller.serializable;

import java.io.IOException;

/**
 * ${Description}
 *
 * @author mijp
 * @date 2018/6/9 16:57
 */
public class CloneDemo {

    public static void main(String[]args) throws IOException, ClassNotFoundException {
        Email email = new Email();
        email.setContent("今天要来加班");

        Person person1 = new Person();
        person1.setEmail(email);
        person1.setName("xiaomi");

        Person person2 = person1.deepClone();
        person2.setName("myron");
        person2.getEmail().setContent("加班取消@");
        System.out.println(person1);
        System.out.println(person2);

    }
}
