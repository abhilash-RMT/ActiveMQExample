package com.raremile.training.p2p.handler;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import com.raremile.training.p2p.receiver.Receiver;
import com.raremile.training.p2p.receiver.ReceiverImpl;
import com.raremile.training.p2p.sender.Sender;
import com.raremile.training.p2p.sender.SenderImpl;

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
			System.out.println("Received: " + textMessage.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}

	}
}
