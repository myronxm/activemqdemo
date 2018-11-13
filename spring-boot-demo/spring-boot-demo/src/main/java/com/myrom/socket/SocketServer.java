package com.myrom.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ${Description}
 *
 * @author mijp
 * @date 2018/6/4 18:57
 */
public class SocketServer {


    public static void main(String[]args){

        ServerSocket socketServer = null;
        BufferedReader bufferedReader = null;

        try {

            //创建监听端口
            socketServer = new ServerSocket(8080);

            //接收
            Socket socket = socketServer.accept();

            //读取输出
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(bufferedReader.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bufferedReader !=null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socketServer !=null) {
                try {
                    socketServer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
