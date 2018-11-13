package com.myrom.rpc.client;

import java.io.Serializable;

/**
 * 远程连接请求参数
 * 传输对象
 * @author mijp
 * @date 2018/6/23 15:00
 */
public class RpcRequest implements Serializable {

    private static final long serialVersionUID = 8148005018975310786L;
    private String className;
    private String methodName;
    private Object[] parameters;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }
}
