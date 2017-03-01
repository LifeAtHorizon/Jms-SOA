package org.vendorcollection.jms.listener;

import javax.jms.Message;
import javax.jms.MessageListener;

import org.springframework.stereotype.Component;

@Component
public class ConsumerListener implements MessageListener {

	public void onMessage(Message arg0) {
		
		System.out.println("Called onMessage()");

	}

}
