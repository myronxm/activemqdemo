package com.myrom.rpc.server;

import com.myrom.rpc.zk.ZookeeperServer;

/**
 * ${Description}
 *
 * @author mijp
 * @date 2018/6/30 11:11
 */
public class LBServerDemo2 {

    public static void main(String[]args) throws Exception {
        Hello hello2 = new HelloImpl1();
        RpcServer rpcServer = new RpcServer(new ZookeeperServer(), "127.0.0.1:8081");
        rpcServer.bind(hello2);
        rpcServer.publisher();
        System.out.println("服务发布完成！");
    }
}
