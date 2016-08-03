package com.raremile.training.p2p.sender;

import javax.jms.JMSException;

public interface Sender {
	public void sendMessage(String message) throws JMSException;
}
