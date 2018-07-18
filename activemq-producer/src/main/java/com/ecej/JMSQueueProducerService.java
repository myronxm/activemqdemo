package com.ecej;

import javax.jms.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * activemq producer service
 *
 * @author mijp
 * @date 2018/7/12 16:37
 */
public class JMSQueueProducerService {

    public static void main(String[]args) throws IOException {

        Connection connection = null;

        try {

            //获取连接
            connection = JMSActiveMQConfig.getConnection();

            //创建session
            Session session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);

            //创建目的地
            Destination destination = session.createQueue("myron");

            //创建发送者
            MessageProducer producer = session.createProducer(destination);

            //消息持久化 & 不持久化配置
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            producer.setDeliveryMode(DeliveryMode.PERSISTENT);

            BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));

            String line = "";
            while(!(line = sin.readLine()).equals("bye")) {

                //创建需要发送的消息
                TextMessage message = session.createTextMessage(line);
                message.setStringProperty("Myron", "Hello");
                producer.send(message);
            }
            sin.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }


}
