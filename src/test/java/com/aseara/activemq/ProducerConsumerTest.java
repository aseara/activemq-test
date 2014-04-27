package com.aseara.activemq;

import com.aseara.activemq.service.ProducerService;
import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.Destination;
import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: aseara
 * Date: 14-3-20
 * Time: 下午2:08
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:activemq.xml"})
public class ProducerConsumerTest {

    @Value("${activemq.broker}")
    private String brokerUrl;

    @Autowired
    private ProducerService producer;
    @Autowired
    @Qualifier("queueDestination")
    private Destination destination;

    private BrokerService broker;

    @Before
    public void before() throws Exception {
        broker = BrokerFactory.createBroker("broker:" + brokerUrl);
        broker.setDataDirectory("target/activemq-data");
        File dataFile = broker.getDataDirectoryFile();
        System.out.println("dataFilePath: " + dataFile.getCanonicalPath());
        broker.start();
    }

    @Test
    public void testSend() throws Exception{
        for (int i = 0; i < 2; i++) {
            producer.sendMessage(destination, "你好，消费者！这是来自生产者的消息：" + (i+1));
        }
    }

    @After
    public void after() throws Exception{
        broker.stop();
    }

}