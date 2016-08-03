package com.raremile.training.p2p.sender;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class SenderImpl implements Sender {

	private ConnectionFactory connectionFactory = null;
	private Connection connection = null;
	private Session session = null;
	private Destination destination = null;
	private MessageProducer messageProducer = null;
	private TextMessage textMessage = null;

	public void sendMessage(String message) throws JMSException {
		// Assign a new instance of connectionFactory
		connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);

		// create a connection from the connectionFactory and start it
		connection = connectionFactory.createConnection();
		connection.start();

		// create a session from the connection
		session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		// create a queue to hold messages
		destination = session.createQueue("MessageQueue");

		// create a producer for the current session
		messageProducer = session.createProducer(destination);

		// create a text message using the current session & set its text to
		// given message
		textMessage = session.createTextMessage();
		textMessage.setText(message);

		// send the message using producer
		messageProducer.send(textMessage);

	}

}
