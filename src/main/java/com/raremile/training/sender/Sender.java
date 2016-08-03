package com.raremile.training.sender;

import javax.jms.JMSException;

public interface Sender {
	public void sendMessage(String message) throws JMSException;
}
