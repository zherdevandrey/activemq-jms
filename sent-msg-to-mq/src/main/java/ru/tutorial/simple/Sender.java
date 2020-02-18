package ru.tutorial.simple;

import org.apache.activemq.*;

import javax.jms.*;

public class Sender {

    private final static String url = ActiveMQConnection.DEFAULT_BROKER_URL;

    private static String queName = "MESSAGE_QUEUE";

    public static void main(String[] args) throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        //CREATE NON TRANSACTIONAL SESSION
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue(queName);
        MessageProducer producer = session.createProducer(destination);
        TextMessage message = session.createTextMessage("java tutorial msg");
        producer.send(message);
        connection.close();
    }
}
