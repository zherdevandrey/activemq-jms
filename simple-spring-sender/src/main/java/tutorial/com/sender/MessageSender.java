package tutorial.com.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
import tutorial.com.model.Product;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

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
