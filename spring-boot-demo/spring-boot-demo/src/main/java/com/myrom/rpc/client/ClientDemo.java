package com.myrom.rpc.client;

import com.myrom.rpc.client.zk.DiscoverService;
import com.myrom.rpc.client.zk.DiscoverServiceImpl;
import com.myrom.rpc.server.Hello;

/**
 * ${Description}
 *
 * @author mijp
 * @date 2018/6/23 14:52
 */
public class ClientDemo {
    public static void main(String[]args) throws Exception {

        DiscoverService discoverService = new DiscoverServiceImpl();

        RpcClientProxy proxy = new RpcClientProxy(discoverService);

        for(int i=0; i<10;i++) {
            Hello hello1 = proxy.clientProxy(Hello.class);
            System.out.println("调用返回：----------------" + hello1.sayHello("myron"));
        }
    }
}
