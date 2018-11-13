package com.myrom.rpc.server;

import com.myrom.rpc.client.RpcRequest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.Map;

/**
 * ${Description}
 *
 * @author mijp
 * @date 2018/6/23 14:57
 */
public class ProcessorHandler implements Runnable{

    //服务端发布的 服务
    private Map<String, Object> hello;
    private Socket socket;

    public ProcessorHandler(Map<String, Object> hello, Socket socket) {
        this.hello = hello;
        this.socket = socket;
    }

    @Override
    public void run() {
        ObjectInputStream inputStream = null;
        try {
            inputStream = new ObjectInputStream(socket.getInputStream());
            RpcRequest request = (RpcRequest) inputStream.readObject();
            Object result = invoke(request);

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(result);
            objectOutputStream.flush();
            objectOutputStream.close();
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Object invoke(RpcRequest request) {
        Object[] args = request.getParameters();
        Class<?>[] types = new Class[args.length];
        for (int i = 0; i < args.length; i++) {
            types[i] = args[i].getClass();
        }

        try {
            Object service = hello.get(request.getClassName());
            Method method = service.getClass().getMethod(request.getMethodName(), types);
            return method.invoke(service, args);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
