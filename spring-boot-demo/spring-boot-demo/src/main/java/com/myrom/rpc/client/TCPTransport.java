package com.myrom.rpc.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * socket管理
 *
 * @author mijp
 * @date 2018/6/23 15:09
 */
public class TCPTransport {

    private String host;
    private int port;

    public TCPTransport(String host, int port) {
        this.host = host;
        this.port = port;
    }

    private Socket newSocket() {
        System.out.println("创建新的连接....");
        Socket socket = null;
        try {
        return  socket = new Socket(host, port);
        } catch (Exception e) {
            throw new RuntimeException("创建连接失败！");
        }
    }

    public Object send(RpcRequest request) {

        Socket socket = null;
        try {
            socket = newSocket();

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(request);
            objectOutputStream.flush();

            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            Object result = objectInputStream.readObject();
            objectInputStream.close();
            objectOutputStream.close();
            return result;
        } catch (Exception e) {
            throw new RuntimeException("发起远程异常@");
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
