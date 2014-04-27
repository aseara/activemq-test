package com.aseara.activemq.listener;

/**
 * Created with IntelliJ IDEA.
 * User: aseara
 * Date: 14-3-20
 * Time: 下午2:57
 */
public class ConsumerMessageListener {

    public void onMessage(String message) {
        System.out.println(
                "接收到一个纯文本消息。\n" +
                "消息内容是：" + message
        );
    }
}