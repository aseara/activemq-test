package com.aseara.activemq.listener;

import org.springframework.jms.listener.SessionAwareMessageListener;

import javax.jms.*;

/**
 * Created with IntelliJ IDEA.
 * User: aseara
 * Date: 14-3-20
 * Time: 下午5:13
 */
public class ConsumerSessionAwareMessageListener implements SessionAwareMessageListener {

    private Destination destination;

    @Override
    public void onMessage(Message message, Session session) throws JMSException {
        TextMessage textMsg = (TextMessage)message;
        System.out.println("接收到一个纯文本消息。");

        try {
            System.out.println("消息内容是：" + textMsg.getText());
        } catch (JMSException je) {
            je.printStackTrace();
        }

        MessageProducer producer = session.createProducer(destination);
        Message msg = session.createTextMessage("ConsumerSessionAwareMessageListener。。。");

        producer.send(msg);
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }
}
