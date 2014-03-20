package com.aseara.activemq.listener;

/**
 * Created with IntelliJ IDEA.
 * User: aseara
 * Date: 14-3-20
 * Time: 下午6:02
 */

public class ResponseListener {

    public void getResponseMessage(String message) {
        System.out.println("接收到发送到responseQueue的一个文本消息，内容是：" + message);
    }
}
