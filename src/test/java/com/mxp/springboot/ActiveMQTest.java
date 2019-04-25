package com.mxp.springboot;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * EMAIL menxipeng@gmail.com
 * AUTHOR:menxipeng
 * DATE: 2019/4/3
 * TIME: 17:36
 */
public class ActiveMQTest {
    private static ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("admin",
            "admin", "tcp://192.168.1.88:61616");
    public static void main(String[] args) {

        // Connection ：JMS 客户端到JMS Provider 的连接
        try {
            final Connection connection = connectionFactory.createConnection();
            connection.setClientID("anpei"); //持久订阅需要设置这个。
            connection.start();
            int INDIVIDUAL_ACK_TYPE = 4;
            // Session： 一个发送或接收消息的线程
            final Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
            // Destination ：消息的目的地;消息送谁那获取.
            Topic topic = session.createTopic("test");// 创建topic

            // 消费者，消息接收者
            //    MessageConsumer consumer1 = session.createConsumer(destination); 普通订阅
            MessageConsumer consumer1 = session.createDurableSubscriber(topic,"anpei");//持久化订阅

            consumer1.setMessageListener(new MessageListener() {

                @Override
                public void onMessage(Message msg) {

                    try {

                        TextMessage message = (TextMessage) msg;
                        System.out.println("AAAAAAAAA收到消息： " + message.getText());                         //    JmsUtils.commitIfNecessary(session);
                        session.commit();


                    } catch (JMSException e) {
                        e.printStackTrace();
                    }

                }
            });

                /*// 再来一个消费者，消息接收者
                MessageConsumer consumer2 = session.createConsumer(destination);

                consumer2.setMessageListener(new MessageListener() {
                    @Override
                    public void onMessage(Message msg) {

                        try {

                            TextMessage message = (TextMessage) msg;
                            System.out.println("BBBBBBBBB收到消息： " + message.getText());
                            JmsUtils.commitIfNecessary(session);
                          //  session.commit();
                        } catch (JMSException e) {
                            e.printStackTrace();
                        }

                    }
                });*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
