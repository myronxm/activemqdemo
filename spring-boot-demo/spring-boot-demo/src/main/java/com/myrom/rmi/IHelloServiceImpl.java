package com.myrom.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * ${Description}
 *
 * @author mijp
 * @date 2018/6/14 14:47
 */
public class IHelloServiceImpl extends UnicastRemoteObject implements IHelloService {

    protected IHelloServiceImpl() throws RemoteException {
    }

    @Override
    public String hello(String name) throws RemoteException {
        return "Hello, " + name;
    }
}
