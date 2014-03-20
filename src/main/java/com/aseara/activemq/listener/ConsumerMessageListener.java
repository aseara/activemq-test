package com.aseara.activemq.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created with IntelliJ IDEA.
 * User: aseara
 * Date: 14-3-20
 * Time: 下午2:57
 */
public class ConsumerMessageListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        TextMessage textMsg = (TextMessage)message;
        System.out.println("接收到一个纯文本消息。");

        try {
            System.out.println("消息内容是：" + textMsg.getText());
        } catch (JMSException je) {
            je.printStackTrace();
        }

    }
}
