package com.ecej;

import javax.jms.*;
import java.util.Enumeration;

/**
 * ${Description}
 *
 * @author mijp
 * @date 2018/7/12 16:52
 */
public class JMSQueueConsumerService {

    public static void main(String[]args){

        Connection connection = null;

        try {
            connection = JMSActiveMQConfig.getConnection();
            Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);

            //创建目的地
            Destination destination = session.createQueue("myron");
            //创建接受者
            MessageConsumer consumer =  session.createConsumer(destination);

            while (true) {
                TextMessage textMessage = (TextMessage) consumer.receive();

                Enumeration enumeration = textMessage.getPropertyNames();
                Enumeration enumeration1 = connection.getMetaData().getJMSXPropertyNames();
                
                while (enumeration1.hasMoreElements()) {
                    String name = (String)enumeration1.nextElement();
                    System.out.println("JMSProperty:key:" +name );
                }
                while(enumeration.hasMoreElements()) {
                    String name = enumeration.nextElement().toString();
                    System.out.println("key:" +name + ", value:" + textMessage.getStringProperty(name));
                }
                System.out.println("收到消息：" + textMessage.getText());
            }

        } catch (JMSException e) {
            e.printStackTrace();
        }


    }
}
