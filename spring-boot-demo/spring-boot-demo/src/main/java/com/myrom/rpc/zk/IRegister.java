package com.myrom.rpc.zk;

/**
 * ${Description}
 *
 * @author mijp
 * @date 2018/6/28 17:07
 */
public interface IRegister {

    /**
      *
      *
      * @param serviceName
      * @param serviceAddress
      * @return
      * @author mijp
      * @since 2018/6/28 17:08
      */
    void register(String serviceName, String serviceAddress) throws Exception;
}
