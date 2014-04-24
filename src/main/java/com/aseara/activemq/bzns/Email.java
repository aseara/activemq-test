package com.aseara.activemq.bzns;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: aseara
 * Date: 14-3-21
 * Time: 上午10:01
 */
public class Email implements Serializable {
    private static final long serialVersionUID = 1L;

    public Email() {}

    public Email(String receiver, String title, String content) {
        this.receiver = receiver;
        this.title = title;
        this.content = content;
    }

    private String receiver;
    private String title;
    private String content;

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Email [receiver=" + receiver + ", title=" + title + ", content=" + content + "]";
    }
}
