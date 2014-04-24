package com.aseara.activemq.converter;

import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: aseara
 * Date: 14-3-21
 * Time: 下午2:52
 */
public class EmailMessageConverter implements MessageConverter {
    @Override
    public Message toMessage(Object object, Session session)
            throws JMSException, MessageConversionException {
        return session.createObjectMessage((Serializable)object);
    }

    @Override
    public Object fromMessage(Message message)
            throws JMSException, MessageConversionException {
        ObjectMessage objMsg = (ObjectMessage)message;
        return objMsg.getObject();
    }
}
