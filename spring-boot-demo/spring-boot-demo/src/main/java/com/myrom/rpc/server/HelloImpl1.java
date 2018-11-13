package com.myrom.rpc.server;

import com.myrom.rpc.anno.RpcAnnotation;

/**
 * ${Description}
 *
 * @author mijp
 * @date 2018/6/28 17:02
 */
@RpcAnnotation(Hello.class)
public class HelloImpl1 implements Hello {
    @Override
    public String sayHello(String name) {
        return "HelloImpl1:"  + name;
    }
}
