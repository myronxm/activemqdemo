package com.ecej;

import javax.jms.JMSException;

/**
 * ${Description}
 *
 * @author mijp
 * @date 2018/7/13 14:07
 */
public class main {

    public static void main(String[]args) throws JMSException {
        System.out.println(JMSActiveMQConfig.getConnection());
    }
}
