package com.myrom.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * ${Description}
 *
 * @author mijp
 * @date 2018/6/14 14:46
 */
public interface IHelloService extends Remote {

    String hello(String name) throws RemoteException;
}
