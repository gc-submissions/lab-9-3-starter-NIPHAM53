package co.grandcircus.trackerapi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import co.grandcircus.trackerapi.model.CountPair;
import co.grandcircus.trackerapi.service.TrackerService;
import co.grandcircus.trackerapi.service.TrackerServiceA;

public class TrackerServiceTests {
	
	private TrackerService service = new TrackerServiceA();
	
	@BeforeEach
	void setup() {
		service.reset();
	}
	
	@Test
	void testAddAndCount() {
		service.add("Alpha");
		service.add("Beta");
		service.add("Gamma");
		assertEquals(3, service.getTotalCount());
	}
	
	@Test
	void testAddAndCountWithDuplicates() {
		service.add("Alpha");
		service.add("Beta");
		service.add("Gamma");
		service.add("Alpha");
		service.add("Beta");
		service.add("Alpha");
		assertEquals(6, service.getTotalCount());
	}

	@Test
	void testLatest() {
		service.add("Alpha");
		service.add("Beta");
		service.add("Gamma");
		assertEquals("Gamma", service.getLatest());
	}
	
	@Test
	void testLatestWithOne() {
		service.add("Alpha");
		assertEquals("Alpha", service.getLatest());
	}

	@Test
	void testLatestWithDuplicates() {
		service.add("Alpha");
		service.add("Beta");
		service.add("Alpha");
		service.add("Beta");
		assertEquals("Beta", service.getLatest());
	}
	
	@Test
	void testLatestWithZero() {
		assertEquals("", service.getLatest());
	}
	
	@Test
	void testTop() {
		service.add("Alpha");
		service.add("Beta");
		service.add("Gamma");
		service.add("Delta");
		service.add("Epsilon");
		service.add("Alpha");
		service.add("Beta");
		service.add("Gamma");
		service.add("Delta");
		service.add("Alpha");
		service.add("Beta");
		service.add("Gamma");
		service.add("Alpha");
		service.add("Beta");
		service.add("Alpha");
		assertEquals(new CountPair("Alpha", 5), service.getTop());
	}
	
	@Test
	void testTop_2() {
		service.add("Alpha");
		service.add("Beta");
		service.add("Gamma");
		service.add("Delta");
		service.add("Gamma");
		service.add("Epsilon");
		service.add("Delta");
		service.add("Gamma");
		service.add("Alpha");
		assertEquals(new CountPair("Gamma", 3), service.getTop());
	}
	
	@Test
	void testTopNoResult() {
		assertEquals(new CountPair("", 0), service.getTop());
	}
	@Test
	void testReset () {
		service.add("Alpha");
		service.reset();
		assertEquals(0, service.getTotalCount());
	}
	@Test
	void testGetTokenExist() {
		service.add("Alpha");
		assertEquals(true, service.getTokenExists("Alpha"));
	}
	@Test
	void testGetTokenExistFalse() {
		service.add("Alpha");
		assertEquals(false, service.getTokenExists("Beta"));

}
	@Test
	void testGetTokenCount() {
		service.add("Alpha");
		service.add("Alpha");
		service.add("Alpha");
		service.add("Gamma");
		assertEquals(3, service.getTokenCount("Alpha"));
		
	}
	
	@Test
	void testLatest5If0() {
		List<String> latest5 = new ArrayList<>();
		assertEquals(latest5, service.getLatest5());
}
	@Test
	void testLatest5IfLessThan5() {
		service.add("2");
		service.add("3");
		service.add("4");
		service.add("5");
		List<String> latest5 = new ArrayList<>();
		latest5.add("2");
		latest5.add("3");
		latest5.add("4");
		latest5.add("5");
		assertEquals(latest5, service.getLatest5());
}
}
