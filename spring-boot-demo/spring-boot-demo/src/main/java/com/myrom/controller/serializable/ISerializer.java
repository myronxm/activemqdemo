package com.myrom.controller.serializable;

/**
 * ${Description}
 *
 * @author mijp
 * @date 2018/6/9 16:26
 */
public interface ISerializer {

    /**
      * 序列化
      *
      * @param obj 序列化对象
      * @return
      * @author mijp
      * @since 2018/6/9 16:27
      */
    <T> byte[] serialize(T obj);

    /**
      * 反序列化
      *
      * @param
      * @return
      * @author mijp
      * @since 2018/6/9 16:28
      */
    <T> T deserialize(byte[] data, Class<T> clazz);

}
