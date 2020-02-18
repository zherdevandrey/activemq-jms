package ru.tutorial.simple;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Receiver {

    private final static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
    private static String queName = "MESSAGE_QUEUE";

    public static void main(String[] args) throws JMSException {

        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue(queName);
        MessageConsumer consumer = session.createConsumer(destination);
        Message message = consumer.receive();
        if (message instanceof TextMessage){
            TextMessage textMessage = (TextMessage) message;
            System.out.println(textMessage.toString());
        }
    }
}
