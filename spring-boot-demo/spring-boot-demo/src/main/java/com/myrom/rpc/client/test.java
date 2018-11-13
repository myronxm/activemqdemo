package com.myrom.rpc.client;

import com.myrom.rpc.server.Hello;
import com.myrom.rpc.server.HelloImpl1;

/**
 * ${Description}
 *
 * @author mijp
 * @date 2018/6/28 14:18
 */
public class test {
    
    public static void main(String[]args){

        Hello hello = new HelloImpl1();
        System.out.println(hello.getClass().getInterfaces().getClass().getName());
    }
}
