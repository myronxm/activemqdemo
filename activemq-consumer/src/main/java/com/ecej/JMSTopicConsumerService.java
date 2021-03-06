package com.ecej;

import javax.jms.*;
import java.util.Enumeration;

/**
 *  持久化topic 接受消息，需要定义clientId
 *  持久化只支持  pub/sub    不支持p2p
 *
 * @author mijp
 * @date 2018/7/12 16:52
 */
public class JMSTopicConsumerService {

    public static void main(String[]args){

        Connection connection = null;

        try {
            connection = JMSActiveMQConfig.getConnection();
            connection.setClientID("myronId");
            connection.start();

            Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);

            //创建topic
            Topic topic = session.createTopic("myronTopic");
            MessageConsumer consumer =  session.createDurableSubscriber(topic, "myronId");

            while (true) {

                //接受消息
                TextMessage textMessage = (TextMessage) consumer.receive();

                Enumeration enumeration = textMessage.getPropertyNames();
                Enumeration enumeration1 = connection.getMetaData().getJMSXPropertyNames();

                //接受 JMS参数
                while (enumeration1.hasMoreElements()) {
                    String name = (String)enumeration1.nextElement();
                    System.out.println("JMSProperty:key:" +name );
                }

                //接受自定义参数
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
