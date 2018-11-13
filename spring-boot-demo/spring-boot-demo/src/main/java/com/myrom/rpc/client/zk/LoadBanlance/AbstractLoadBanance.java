package com.myrom.rpc.client.zk.LoadBanlance;

import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * ${Description}
 *
 * @author mijp
 * @date 2018/7/4 19:42
 */
public abstract class AbstractLoadBanance implements LoadBanlance {

    @Override
    public String selectHost(List<String> addresses)  {
        if(CollectionUtils.isEmpty(addresses)) {
            return null;
        }

        if(addresses.size() == 1) {
            return addresses.get(0);
        }
        return doselect(addresses);
    }

    protected abstract String doselect(List<String> addresses);
}
