package com.myrom.controller.demo;

import java.lang.reflect.InvocationTargetException;

/**
 * ${Description}
 *
 * @author mijp
 * @date 2018/5/18 14:27
 */
public class AnnotationTest {

    public static void main(String[]args){


        try {
            Class<?> clazz = Class.forName("com.myrom.controller.demo.Annotation");
            Object object = clazz.newInstance();
            clazz.getMethod("say", String.class).invoke(object, "myron");

            System.out.println(clazz.isAnnotationPresent(Myron.class));

            Myron annotation = clazz.getAnnotation(Myron.class);
            System.out.println(annotation.name());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


}
