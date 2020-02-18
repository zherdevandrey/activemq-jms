package tutorial.com.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;
import tutorial.com.model.Product;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@Component
public class MessageListenerApp implements MessageListener {

    @Autowired
    MessageConverter messageConverter;

    public void onMessage(Message message) {
        try {
            Product product = (Product)messageConverter.fromMessage(message);

            System.out.println("product name " + product.getName());
            System.out.println("product name " + product.getPrice());

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
