package com.aseara.activemq;

import com.aseara.activemq.broker.BrokerInitializer;
import com.aseara.activemq.service.ProducerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.Destination;

/**
 * Created with IntelliJ IDEA.
 * User: aseara
 * Date: 14-3-20
 * Time: 下午2:08
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:activemq.xml"})
public class ProducerConsumerTest {

    @SuppressWarnings("unused")
    @Autowired
    private BrokerInitializer brokerInitializer;

    @Autowired
    private ProducerService producer;
    @Autowired
    @Qualifier("queueDestination")
    private Destination destination;

    @Test
    public void testSend() throws Exception{
        for (int i = 0; i < 20; i++) {
            producer.sendMessage(destination, "你好，消费者！这是来自生产者的消息：" + (i+1));
        }
    }

}