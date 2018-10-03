package se.ju.csi.oom.lab4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DateTimeTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testToString() {
		
		DateTime testString = new DateTime(2018, 10, 3, 11, 59, 36);
		
		assertEquals("2018-10-03 11:59:36", testString.toString());//generates a string from an object and compares with a hard-coded string
	}

	@Test
	public void testDateTimeString() {
		
		DateTime testObject1 = new DateTime(2018, 10, 3, 11, 59, 36);
		DateTime testObject2 = new DateTime("2018-10-03 11:59:36");
		
		assertEquals(testObject1.toString(), testObject2.toString());
	}

}
