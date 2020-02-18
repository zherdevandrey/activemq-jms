package ru.tutorial;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;

import javax.jms.JMSException;
import javax.jms.Message;

//@Component
public class MessageReceiver {

   // @Autowired
    JmsTemplate jmsTemplate;

   // @Autowired
    MessageConverter messageConverter;

    public Product receive() throws JMSException {
        Message message = jmsTemplate.receive();
        Product product = (Product)messageConverter.fromMessage(message);
        return product;
    }

}
