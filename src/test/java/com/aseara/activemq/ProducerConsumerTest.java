package com.aseara.activemq;

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
@ContextConfiguration(locations = {"/activemq.xml"})
public class ProducerConsumerTest {

    @Autowired
    private ProducerService producer;
    @Autowired
    @Qualifier("queueDestination")
    private Destination destination;
    @Autowired
    @Qualifier("sessionAwareDestination")
    private Destination sessionAwareDestination;
    @Autowired
    @Qualifier("adapterDestination")
    private Destination adapterDestination;


    @Test
    public void testSend() {
        for (int i = 0; i < 2; i++) {
            producer.sendMessage(destination, "你好，消费者！这是来自生产者的消息：" + (i+1));
        }
    }

    @Test
    public void testSessionAwareMessageListener() {
        producer.sendMessage(sessionAwareDestination, "测试SessionAwareMessageListener");
    }

    @Test
    public void testMessageListenerAdapter() {
        producer.sendMessage(adapterDestination, "测试MessageListenerAdapter");
    }

}
