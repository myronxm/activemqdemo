package com.myrom.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ${Description}
 *
 * @author mijp
 * @date 2018/6/4 19:57
 */
public class ServerDemo1 {

    /**
     * 双向通信，接受流 与 发送流
     * @param args
     */
    public static void main(String[]args){
        ServerSocket serverSocket = null;

        try {
            //创建监听端口
            serverSocket = new ServerSocket(8080);
            Socket socket = serverSocket.accept();

            //接收数据
            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter os = new PrintWriter(socket.getOutputStream());

            //输入流
            BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Client:" + is.readLine());

            String line = sin.readLine();
            while (!line.equals("bye")){
                os.println(line);
                os.flush();
                System.out.println("Service:" + line);
                System.out.println("Client:" + is.readLine());
                line = sin.readLine();
            }
            os.close();
            is.close();
            sin.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
