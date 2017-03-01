package test.org.vendorcollections.jms.listener;

import static org.junit.Assert.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;

import javax.jms.TextMessage;

import org.apache.activemq.advisory.ConsumerEvent;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.vendorcollection.jms.listener.ConsumerListener;
public class ConsumerListenerTest {

	private TextMessage textmssg;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		ConsumerListener consumerlistener = new ConsumerListener();
		consumerlistener.onMessage(textmssg);  
		assertNull(textmssg);
	}

}
