package com.myrom.rpc.client.zk.LoadBanlance;

import java.util.List;

/**
 * ${Description}
 *
 * @author mijp
 * @date 2018/7/4 19:33
 */
public interface LoadBanlance {

    String selectHost(List<String> addresses);
}
