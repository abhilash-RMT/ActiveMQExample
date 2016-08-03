package com.raremile.training.handler;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import com.raremile.training.receiver.Receiver;
import com.raremile.training.receiver.ReceiverImpl;
import com.raremile.training.sender.Sender;
import com.raremile.training.sender.SenderImpl;

public class ChatHandler {

	private String message;
	private Sender sender;
	private Receiver receiver;
	private TextMessage textMessage;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void startChatting() {
		System.out.println("Welcome to JMS RMT Chat...");

		try {
			sender = new SenderImpl();
			setMessage("Hello from Sender..");
			sender.sendMessage(message);

			receiver = new ReceiverImpl();
			textMessage = receiver.receiveMessage();
			System.out.println("Received: " + textMessage);
		} catch (JMSException e) {
			e.printStackTrace();
		}

	}
}
