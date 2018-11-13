package com.myrom.controller.serializable;

/**
 * ${Description}
 *
 * @author mijp
 * @date 2018/6/9 16:33
 */
public class Demo {
    
    
    public static void main(String[]args){
        ISerializer iSerializer = new JavaSerializer();
        User user = new User();
        user.setAge(12);
        user.setName("xiaomi");
        byte[] seralByte = iSerializer.serialize(user);

        
        User dUser = iSerializer.deserialize(seralByte, User.class);
        System.out.println();
        
        
    }
}
