package ru.tutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.ObjectMessage;


@Component
public class MessageSender {

    @Autowired
    JmsTemplate jmsTemplate;

    public void sentMsg(final Product product){

        jmsTemplate.send(session -> {
            ObjectMessage objectMessage = session.createObjectMessage(product);
            return objectMessage;
        });

    }

}
