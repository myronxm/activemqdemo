package com.myrom.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * ${Description}
 *
 * @author mijp
 * @date 2018/6/14 14:47
 */
public class RmiServerTest {
    public static void main(String[] args) {
        try {
            IHelloService iHelloService = new IHelloServiceImpl();
            LocateRegistry.createRegistry(1099);
            Naming.rebind("rmi://127.0.0.1/Hello", iHelloService);
            System.out.println("服务启动成功");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}