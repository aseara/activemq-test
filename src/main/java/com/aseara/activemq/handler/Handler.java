package com.aseara.activemq.handler;

import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: aseara
 * Date: 2014/4/27
 * Time: 17:02
 */
@Component
public class Handler {

    public void handle(final String message) {
        Thread currentThread = Thread.currentThread();
        String msgPass = message + ", handler: " + currentThread.getName();
        //System.out.println(msgPass+"---------------start");
        try{
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(msgPass+"---------------end");
    }
}
