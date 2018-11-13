package com.myrom.rpc.client.zk.LoadBanlance;

import java.util.List;
import java.util.Random;

/**
 * ${Description}
 *
 * @author mijp
 * @date 2018/7/4 19:45
 */
public class RandomLoadBanlance extends AbstractLoadBanance {

    @Override
    protected String doselect(List<String> addresses) {
        Random random = new Random();
        return addresses.get(random.nextInt(addresses.size()));
    }
}
