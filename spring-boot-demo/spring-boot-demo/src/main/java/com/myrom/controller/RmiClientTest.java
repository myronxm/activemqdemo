package com.myrom.controller;

import com.myrom.rmi.IHelloService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * ${Description}
 *
 * @author mijp
 * @date 2018/6/14 14:53
 */
public class RmiClientTest {
    public static void main(String[]args) {


        try {
            IHelloService iHelloService = (IHelloService) Naming.lookup("rmi://127.0.0.1/Hello");
            System.out.println(iHelloService.hello("Myron"));
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
