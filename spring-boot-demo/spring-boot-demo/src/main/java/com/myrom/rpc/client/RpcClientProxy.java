package com.myrom.rpc.client;


import com.myrom.rpc.client.zk.DiscoverService;

import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Random;

/**
 * 客户端动态代理
 *
 * @author mijp
 * @date 2018/6/23 15:02
 */
public class RpcClientProxy {

    private DiscoverService discoverService;

    public RpcClientProxy(DiscoverService discoverService) {
        this.discoverService = discoverService;
    }

    public  <T> T clientProxy(final Class<T> interfaces) throws Exception {

        //从注册中心获取地址信息 zookeeper
        String address = discoverService.discover(interfaces.getName());

        //做负载均衡
        return (T) Proxy.newProxyInstance(interfaces.getClassLoader(),
                new Class[]{interfaces}, new RemoteInvocationHandler(address.split(":")[0],
                        Integer.valueOf(address.split(":")[1])));
    }

    public String randomAddress(List<String> address) {
        Random ra =new Random();
        return address.get(ra.nextInt(address.size()));
    }
}
