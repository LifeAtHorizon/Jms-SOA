package test.org.vendorcollections.jms.adapter;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.vendorcollection.jms.adapter.ConsumerAdapter;

public class ConsumerAdapterTest {

	private String jsonStringtest = "{vendorName : \"MicrosftTest\",firstName:\"BobTest\",lastName:\"MarleyTest\"}";
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		ConsumerAdapter consumeradapter = new ConsumerAdapter();
		consumeradapter.sendToMongo(jsonStringtest);
		assertNotNull(jsonStringtest);
	}

}
