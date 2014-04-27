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
        System.out.println(message );
    }
}
