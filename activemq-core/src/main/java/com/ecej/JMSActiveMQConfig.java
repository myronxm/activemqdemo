package com.ecej;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;

/**
 * ${Description}
 *
 * @author mijp
 * @date 2018/7/13 13:59
 */
public class JMSActiveMQConfig {

    public static Connection connection = null;

    public JMSActiveMQConfig() throws JMSException {
        init();
    }

    private static void init() throws JMSException {
        if(connection == null) {

            //建立connection连接
            ConnectionFactory connectionFactory =
                    new ActiveMQConnectionFactory("tcp://192.168.232.131:61616");

            connection = connectionFactory.createConnection();
        }
    }

    public static Connection getConnection() throws JMSException {
        init();
        return connection;
    }
}
