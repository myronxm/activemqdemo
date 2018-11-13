package com.myrom.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * ${Description}
 *
 * @author mijp
 * @date 2018/6/4 20:06
 */
public class ClientDemo1 {

    public static void main(String[]args){

        try {
            Socket socket = new Socket("127.0.0.1", 8080);
            BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter os = new PrintWriter(socket.getOutputStream());
            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = sin.readLine();
            while(!line.equals("bye")) {
                os.println(line);
                os.flush();
                System.out.println("Client:" + line);
                System.out.println("Server:" + is.readLine());
                line = sin.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
