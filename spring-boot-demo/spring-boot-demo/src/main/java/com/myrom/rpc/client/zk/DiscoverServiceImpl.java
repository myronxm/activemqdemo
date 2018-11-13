package com.myrom.rpc.client.zk;

import com.myrom.rpc.client.zk.LoadBanlance.LoadBanlance;
import com.myrom.rpc.client.zk.LoadBanlance.RandomLoadBanlance;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.ArrayList;
import java.util.List;

import static com.myrom.rpc.client.zk.ZKConfig.ZK_REGISTER_PATH;

/**
 * ${Description}
 *
 * @author mijp
 * @date 2018/6/30 11:35
 */
public class DiscoverServiceImpl implements DiscoverService{

    List<String> paths = new ArrayList<>();

    private CuratorFramework curatorFramework;

    public DiscoverServiceImpl() {
        curatorFramework=CuratorFrameworkFactory.builder().
                connectString(ZK_REGISTER_PATH).
                sessionTimeoutMs(4000).
                retryPolicy(new ExponentialBackoffRetry(1000,
                        10)).build();
        curatorFramework.start();
    }


    @Override
    public String discover(String serviceName) {
        String path  = ZK_REGISTER_PATH + "/" + serviceName;

        try {
            paths = curatorFramework.getChildren().forPath(path);

            //动态发现服务节点变化
            registerWatcher(path);

            //负载均衡算法获取服务地址
            LoadBanlance loadBanlance = new RandomLoadBanlance();
            return loadBanlance.selectHost(paths);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    /**
      * 监听服务节点变换，获取最新的服务地址
      * 子节点的增加、修改、删除的事件监听
      * @param path
      * @return 
      * @author mijp
      * @since 2018/7/4 19:26
      */
    private void registerWatcher(String path) {

        PathChildrenCache childrenCache = new PathChildrenCache(curatorFramework, path, true);

        PathChildrenCacheListener pathChildrenCacheListener = new PathChildrenCacheListener() {

            @Override
            public void childEvent(CuratorFramework curatorFramework, PathChildrenCacheEvent pathChildrenCacheEvent) throws Exception {
                    paths = curatorFramework.getChildren().forPath(path);
            }
        };
        childrenCache.getListenable().addListener(pathChildrenCacheListener);
        try {
            childrenCache.start();
        } catch (Exception e) {
            throw new RuntimeException("注册PatchChild Watcher 异常"+e);
        }
    }
}
