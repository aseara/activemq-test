package com.aseara.activemq.listener;

import com.aseara.activemq.handler.HandlerScheduler;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * User: aseara
 * Date: 14-3-20
 * Time: 下午2:57
 */
public class ConsumerMessageListener {

    @Autowired
    private HandlerScheduler scheduler;

    public void onMessage(String message) {
        String passMsg = message + ", msgListener: " + Thread.currentThread().getName();
        scheduler.schedule(passMsg);
    }
}