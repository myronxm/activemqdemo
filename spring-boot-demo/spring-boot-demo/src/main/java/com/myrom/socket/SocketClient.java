package com.myrom.socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * ${Description}
 *
 * @author mijp
 * @date 2018/6/4 18:58
 */
public class SocketClient {

    public static void main(String[]args){
        Socket socket = null;

        try {
            socket = new Socket("127.0.0.1", 8080);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Hello");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(socket!=null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
