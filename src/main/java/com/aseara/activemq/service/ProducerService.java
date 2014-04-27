package com.aseara.activemq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;

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

    public void sendMessage(Destination destination, final String message) {

        System.out.println("---------------生产者发送消息-----------------");
        System.out.println("---------------生产者发了一个消息：" + message);

        jmsTemplate.send(destination, session -> session.createTextMessage(message));

    }

}
