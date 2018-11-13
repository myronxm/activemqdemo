package com.myrom.rpc.server;

import com.myrom.rpc.zk.ZookeeperServer;

/**
 * ${Description}
 *
 * @author mijp
 * @date 2018/6/23 15:32
 */
public class ServerDemo {

    public static void main(String[]args) throws Exception {

        Hello hello1 = new HelloImpl1();
        Hello hello2 = new HelloImpl2();
        RpcServer rpcServer = new RpcServer(new ZookeeperServer(), "127.0.0.1:8080");
        rpcServer.bind(hello1, hello2);
        rpcServer.publisher();
        System.out.println("服务发布完成！");
    }
}
