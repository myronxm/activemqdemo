package com.myrom.rpc.client;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * ${Description}
 *
 * @author mijp
 * @date 2018/6/23 15:05
 */
public class RemoteInvocationHandler implements InvocationHandler {

    private String host;
    private int port;

    public RemoteInvocationHandler(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        RpcRequest request = new RpcRequest();
        request.setClassName(proxy.getClass().getName());
        request.setMethodName(method.getName());
        request.setParameters(args);
        TCPTransport tcpTransport = new TCPTransport(this.host, this.port);
        return tcpTransport.send(request);
    }
}
