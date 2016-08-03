package com.raremile.training.receiver;

import javax.jms.JMSException;
import javax.jms.TextMessage;

public interface Receiver {
	public TextMessage receiveMessage() throws JMSException;

}
