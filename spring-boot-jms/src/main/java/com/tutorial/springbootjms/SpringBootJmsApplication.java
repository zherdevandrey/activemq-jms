package com.tutorial.springbootjms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
@EnableJms
public class SpringBootJmsApplication {

    private static final String MESSAGE_QUEUE = "message_queue";

    public static void main(String[] args)
    {
        // Launch the application
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootJmsApplication.class, args);

        // Get JMS template bean reference
        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);

        Product product = new Product();
        product.setProductId(100);
        product.setName("Laptop");
        product.setQuantity(10);


        while (true) {
            // Send a message
            System.out.println("Sending a product.");
            jmsTemplate.convertAndSend(MESSAGE_QUEUE, product);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
