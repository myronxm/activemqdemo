package com.myrom.rpc.server;

import com.myrom.rpc.anno.RpcAnnotation;
import com.myrom.rpc.zk.ZookeeperServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ${Description}
 *
 * @author mijp
 * @date 2018/6/23 14:54
 */
public class RpcServer {

    private final ExecutorService executorService = Executors.newCachedThreadPool();

    private static Map<String, Object> serviceMap = new HashMap();

    private ZookeeperServer registerCenter;

    private String serviceAddress;

    public RpcServer(ZookeeperServer registerCenter, String serviceAddress) {
        this.registerCenter = registerCenter;
        this.serviceAddress = serviceAddress;
    }

    /**
      *
      *
      * @param obj 绑定服务
      * @return
      * @author mijp
      * @since 2018/6/28 17:28
      */
    public void bind(Object... obj) {
        for(Object object : obj) {
            RpcAnnotation annotation = object.getClass().getAnnotation(RpcAnnotation.class);
            String serviceName = annotation.value().getName();
            String version = annotation.version();
            if(!"".equals(version)) {
                serviceName = serviceName + "_" + version;
            }
            serviceMap.put(serviceName, object);
        }
    }
    /**
      *
      * 发布服务
     *
      * @param
      * @return
      * @author mijp
      * @since 2018/6/23 14:55
      */
    public void publisher() throws Exception {

        String[] address =serviceAddress.split(":");

        //注册服务
        for (String value: serviceMap.keySet()) {
            registerCenter.register(value, serviceAddress);
        }

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(Integer.parseInt(address[1]));

            while (true) {
                Socket socket = serverSocket.accept();
                executorService.execute(new ProcessorHandler(serviceMap, socket));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(serverSocket!= null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
