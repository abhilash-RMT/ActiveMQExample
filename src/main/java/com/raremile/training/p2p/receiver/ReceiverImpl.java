package com.raremile.training.p2p.receiver;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class ReceiverImpl implements Receiver {

	private ConnectionFactory connectionFactory = null;
	private Connection connection = null;
	private Session session = null;
	private Destination destination = null;
	private MessageConsumer messageConsumer = null;
	private TextMessage textMessage = null;

	public TextMessage receiveMessage() throws JMSException {
		// Assign a new instance of connectionFactory
		connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);

		// create a connection from the connectionFactory and start it
		connection = connectionFactory.createConnection();
		connection.start();

		// create a session from the connection
		session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		// create a queue to hold messages
		destination = session.createQueue("MessageQueue");

		// create a consumer for the current session
		messageConsumer = session.createConsumer(destination);

		// receive the message using consumer & return it
		textMessage = (TextMessage) messageConsumer.receive();

		return textMessage;
	}

}
