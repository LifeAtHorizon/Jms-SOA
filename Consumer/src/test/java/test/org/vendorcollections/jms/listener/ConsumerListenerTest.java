package test.org.vendorcollections.jms.listener;

import static org.junit.Assert.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.apache.activemq.advisory.ConsumerEvent;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.vendorcollection.jms.listener.ConsumerListener;
public class ConsumerListenerTest  {

	private TextMessage textmssg;
	private ApplicationContext context;
	private ConsumerListener listener;
	private String jsonStringtest = "{vendorName : \"MicrosftTest\",firstName:\"BobTest\",lastName:\"MarleyTest\"}";
	@Before
	public void setUp() throws Exception {
	textmssg = createMock(TextMessage.class);
	context = new ClassPathXmlApplicationContext("/spring/application-config.xml");
	listener = (ConsumerListener)context.getBean("consumerListener");
	}

	@After
	public void tearDown() throws Exception {
	((ConfigurableApplicationContext)context).close();
	}

	@Test
	public void test() throws JMSException {
		expect(textmssg.getText()).andReturn(jsonStringtest);
		replay(textmssg);
		
		listener.onMessage(textmssg);  
		verify(textmssg);
	}

}
