package com.myrom.rpc.zk;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

/**
 * ${Description}
 *
 * @author mijp
 * @date 2018/6/26 16:24
 */
public class ZookeeperServer implements IRegister{


    private CuratorFramework curatorFramework;

    public ZookeeperServer() {

        if(curatorFramework == null) {


        //初始化zk连接
       curatorFramework = CuratorFrameworkFactory.builder()
               .connectString(ZKConfig.CONNNECTION_STR)
               .sessionTimeoutMs(4000).retryPolicy(new ExponentialBackoffRetry(1000, 3))
               .build();
       curatorFramework.start();
        }
    }


    /**
      * 获取节点内容
      *
      * @param path
      * @return
      * @author mijp
      * @since 2018/6/26 16:41
      */
    public String getPathValue(String path) throws Exception {
            return new String(curatorFramework.getData().forPath("/" + path));
    }


    @Override
    public void register(String serviceName, String serviceAddress) throws Exception {
        String registerPath = ZKConfig.ZK_REGISTER_PATH + "/" + serviceName;

        //判断节点是否存在 不存在则进行注册
        if (curatorFramework.checkExists().forPath(registerPath) == null) {
            curatorFramework.create().creatingParentContainersIfNeeded().withMode(CreateMode.PERSISTENT)
                    .forPath(registerPath);
        }

        String addressPath = registerPath + "/" + serviceAddress;
        String rsNode = curatorFramework.create().creatingParentContainersIfNeeded().withMode(CreateMode.EPHEMERAL).forPath(addressPath, "0".getBytes());

        System.out.println("服务注册成功：" + rsNode);
    }
}
