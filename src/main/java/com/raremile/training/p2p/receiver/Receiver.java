package com.raremile.training.p2p.receiver;

import javax.jms.JMSException;
import javax.jms.TextMessage;

public interface Receiver {
	public TextMessage receiveMessage() throws JMSException;

}
