package org.vendorcollection.jms.listener;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.logging.LogManager;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.vendorcollection.jms.adapter.ConsumerAdapter;


@Component
public class ConsumerListener implements MessageListener {
	// Define the logger for logging 
	private static Logger logger = org.apache.logging.log4j.LogManager.getLogger(ConsumerListener.class.getName());
	@Autowired
	JmsTemplate jmstemplate;
	// The consumer adapter is to connect the service to the mongodb
	@Autowired
	ConsumerAdapter consumeradapter;
	public void onMessage(Message message) {
		
		
		String jsonString = null;
        logger.info("Called onMessage()");
		if(message instanceof TextMessage){
			try {
				/*
				 *  if the message is textmessage then it is
				 *  assigned to the jsonstring variable 
				 */
				jsonString = ((TextMessage)message).getText();
				
				/*
				 * No we are sending the json message to the consumeradapter
				 * 
				 */
				consumeradapter.sendToMongo(jsonString);
			} catch (JMSException e) {
				/*
				 * As there is a exception we have to add it to the 
				 * Rejected message endpoint queue
				 * 
				 * For adding that to the queue we have the JMS template 
				 * which is from the spring
				 * 
				 * What is convert and send in the jmstemplate 
				 * In jms template you create a connection factory and get a connection
				 * By convert and send what we are doing is changing the jsonstring into a 
				 * message and sending to the queue 
				 * 
				 */
				jmstemplate.convertAndSend(jsonString);
				e.printStackTrace();
			}
		}
	}

}
