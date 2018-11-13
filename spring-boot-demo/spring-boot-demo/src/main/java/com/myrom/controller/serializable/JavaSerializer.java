package com.myrom.controller.serializable;

import java.io.*;

/**
 * ${Description}
 *
 * @author mijp
 * @date 2018/6/9 16:28
 */
public class JavaSerializer implements ISerializer{

    /**
      * 序列化
      *
      * @param
      * @return
      * @author mijp
      * @since 2018/6/9 16:32
      */
    @Override
    public <T> byte[] serialize(T obj) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    /**
      * 反序列化
      *
      * @param
      * @return
      * @author mijp
      * @since 2018/6/9 16:32
      */
    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);

        try {
            ObjectInput objectInput = new ObjectInputStream(byteArrayInputStream);
            try {
                return (T) objectInput.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }
}
