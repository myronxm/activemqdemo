package com.myrom.rpc.server;

import com.myrom.rpc.anno.RpcAnnotation;

/**
 * ${Description}
 *
 * @author mijp
 * @date 2018/6/28 17:03
 */
@RpcAnnotation(Hello.class)
public class HelloImpl2 implements Hello{
    @Override
    public String sayHello(String name) {
        return null;
    }
}
