package com.myrom.controller.serializable;

import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;

import java.io.*;

/**
 * ${Description}
 *
 * @author mijp
 * @date 2018/6/9 16:53
 */
public class Person implements Cloneable , Serializable {

    private String name;

    private Email email;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", email=" + email.getContent() +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    @Override
    protected Person clone() throws CloneNotSupportedException{
        return (Person) super.clone();
    }

    public Person deepClone() throws IOException, ClassNotFoundException {

        //序列化
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(bos);
        objectOutputStream.writeObject(this);

        //反序列化
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        return (Person) objectInputStream.readObject();


    }
}
