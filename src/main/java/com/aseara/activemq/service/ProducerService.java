package com.aseara.activemq.service;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.*;

/**
 * Created with IntelliJ IDEA.
 * User: aseara
 * Date: 14-3-20
 * Time: 下午2:02
 */

@Component
public class ProducerService {

    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    @Qualifier("responseDestination")
    private Destination responseDestination;


    public void sendMessage(Destination destination, final String message) {

        System.out.println("---------------生产者发送消息-----------------");
        System.out.println("---------------生产者发了一个消息：" + message);

        jmsTemplate.send(destination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMsg = session.createTextMessage(message);
                textMsg.setJMSReplyTo(responseDestination);
                return textMsg;
            }
        });

    }

}
