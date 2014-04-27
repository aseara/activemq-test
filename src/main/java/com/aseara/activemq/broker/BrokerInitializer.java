package com.aseara.activemq.broker;

import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created with IntelliJ IDEA.
 * User: aseara
 * Date: 2014/4/27
 * Time: 16:27
 */

@Component
public class BrokerInitializer {

    @Value("${activemq.broker}")
    private String brokerUrl;

    private BrokerService broker;

    @SuppressWarnings("unused")
    @PostConstruct
    private void init() {
        try {
            broker = BrokerFactory.createBroker("broker:" + brokerUrl);
            broker.setDataDirectory("target/activemq-data");
            broker.start();
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    @SuppressWarnings("unused")
    @PreDestroy
    private void destroy() {
        try {
            broker.stop();
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }
}
