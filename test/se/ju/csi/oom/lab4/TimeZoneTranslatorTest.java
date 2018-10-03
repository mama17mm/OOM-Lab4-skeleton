package se.ju.csi.oom.lab4;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;

public class TimeZoneTranslatorTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testShiftTimeZone() {
		DateTime date = new DateTime(2018, 10, 1, 14, 33, 12);
		
		assertEquals("2018-10-01 17:33:12", TimeZoneTranslator.shiftTimeZone(date, 2, 5).toString());
	}

	@Test
	public void testShiftEventTimeZone() {
		
		String label = "Something";
		DateTime startDate = new DateTime(2018, 10, 1, 1, 30, 0);
		DateTime endDate = new DateTime(2018, 10, 2, 3, 30, 0);
		Person martin = new Person("Martin Malmström");
		Place tomelilla = new Place("Tomelilla", 57.7785672, 14.1614833,20.0);
		
		
		Event event = new Event(
				label,
				startDate,
				endDate,
				new HashSet<>(Arrays.asList(martin)),
				tomelilla
				);
		
		assertEquals("Event label:\tSomething\nStart date:\t2018-10-01 06:30:00\nEnd date:\t2018-10-02 08:30:00\nAttendees:\t[Martin Malmström]\nPlace:\t\tTomelilla", TimeZoneTranslator.shiftEventTimeZone(event, TimeZone.GREENWICH_UTC, TimeZone.PAKISTAN).toString());
		
	
	}
	
	@Test
	public void testShiftTimeZone2() {
		DateTime date = new DateTime(2016, 1, 1, 6, 0, 0);
		
		assertNotEquals("2015-12-31 21:00:00", TimeZoneTranslator.shiftTimeZone(date, 1, -8).toString());
	}

}
