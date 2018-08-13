package com.ywgroup.iecloud.jms.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author lanmeiniu@outlook.com
 * @version V1.0.0
 * Description 消费者
 * @date 2018/08/13 14:57
 */
public class AppConsumer {


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
        // 创建消费者,是目标地址
        MessageConsumer messageConsumer = session.createConsumer(destination);
        // 监听消费信息
        messageConsumer.setMessageListener(new MessageListener() {
            // onMessage方法会回调我们接受到的消息内容
            @Override
            public void onMessage(Message message) {
                // 类型转换
                TextMessage textMessage = (TextMessage) message;
                // 接收消息
                try {
                    System.out.println("开始接收消息了 [" + textMessage.getText() + "]" + "\n");
                } catch (JMSException e) {
                    e.printStackTrace();
                }

            }
        });


        // 关闭连接
        //connection.close();
    }
}
