package com.ywgroup.iecloud.jms.queue;

import org.apache.activemq.ActiveMQConnectionFactory;


import javax.jms.*;


/**
 * @author lanmeiniu@outlook.com
 * @version V1.0.0
 * Description 消息的提供者，向消息中间件发送消息的
 * @date 2018/08/13 09:45
 *
 * Attention: 运行AppProducer主程序，再运行2次AppConsumer，这两个AppConsumer接收的消息是均匀分布的
 */
public class AppProducer {

    /**
     * 指定active的服务器地址,61616是activeMQ默认的端口
     */
    private static final String URL = "tcp://192.168.1.8:61616";
    /**
     * 队列的名称
     */
    private static final String QUEUE_NAME = "queue_test";

    public static void main(String[] args) throws JMSException {
        // 创建connectionFactory,是有服务商提供,传入服务器连接地址
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(URL);
        // 创建连接
        Connection connection = connectionFactory.createConnection();
        // 启动物理连接
        connection.start();
        // 创建会话  (true or false 表示是否支持事务,AUTO_ACKNOWLEDGE为自动确认，客户端发送和接收消息不需要做额外的工作,)
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        // 创建目的地
        Destination destination = session.createQueue(QUEUE_NAME);
        // 创建生产者,是目标地址
        MessageProducer messageProducer = session.createProducer(destination);
        // 循环的向目标地址发送消息
        for (int i = 0;i< 100 ;i++) {
            // 创建消息,输入自己消息的内容
            TextMessage textMessage = session.createTextMessage("test" + i);
            // 创建信息的生产者,由于已经指定了目的地，所以直接传入消息即可
            messageProducer.send(textMessage);
            System.out.println("消息发送成功啦~~,消息内容：" + textMessage.getText());
        }

        // 关闭连接
        connection.close();


    }
}
