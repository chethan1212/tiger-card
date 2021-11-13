package com.nepu.transport.fare.engine;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nepu.transport.App;
import com.nepu.transport.entity.fare.FareService;
import com.nepu.transport.entity.farecap.FareCapService;
import com.nepu.transport.trips.TotalTripsInfo;
import com.nepu.transport.trips.Trip;

// @ActiveProfiles("mocksForFareEngineTest")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
public class FareEngineTest {
	
//	@Autowired
//	private FareCapService fareCapService;
	
//	@Autowired
//	private FareService fareService;
	
	@Autowired
	FareEngine fareEngine;
	
	@Test
	public void testSingleDayTripsBelowDailyCap() {
		List<Trip> trips = new ArrayList<>();
		trips.add(new Trip(1, 1, "2021/10/31 10:45"));
		trips.add(new Trip(1, 2, "2021/10/31 11:45"));
		trips.add(new Trip(2, 2, "2021/10/31 12:45"));
		TotalTripsInfo totalTripsInfo = fareEngine.calculate(trips);
		Assert.assertEquals(80, totalTripsInfo.getTotalFare());
		Assert.assertEquals(80, totalTripsInfo.getWeekTrip(45).getWeekTotalFare());
		Assert.assertEquals(80, totalTripsInfo.getWeekTrip(45).getDayTrip(1).getDayTotalFare());
	}
	
	@Test
	public void testSingleDayTripsAboveDailyCap() {
		List<Trip> trips = new ArrayList<>();
		trips.add(new Trip(1, 1, "2021/11/01 10:45"));
		trips.add(new Trip(1, 1, "2021/11/01 11:45"));
		trips.add(new Trip(1, 1, "2021/11/01 12:45"));
		trips.add(new Trip(1, 1, "2021/11/01 13:45"));
		trips.add(new Trip(1, 1, "2021/11/01 14:45"));
		trips.add(new Trip(1, 1, "2021/11/01 15:45"));
		trips.add(new Trip(1, 1, "2021/11/01 16:45"));
		trips.add(new Trip(1, 1, "2021/11/01 17:45"));
		trips.add(new Trip(1, 1, "2021/11/01 18:45"));
		trips.add(new Trip(1, 1, "2021/11/01 19:45"));
		TotalTripsInfo totalTripsInfo = fareEngine.calculate(trips);
		Assert.assertEquals(100, totalTripsInfo.getTotalFare());
		Assert.assertEquals(100, totalTripsInfo.getWeekTrip(45).getWeekTotalFare());
		Assert.assertEquals(100, totalTripsInfo.getWeekTrip(45).getDayTrip(2).getDayTotalFare());
	}
	
	@Test
	public void testSingleWeekTripsAboveDailyCap() {
		List<Trip> trips = new ArrayList<>();
		trips.add(new Trip(1, 1, "2021/10/31 10:45"));
		trips.add(new Trip(1, 2, "2021/10/31 11:45"));
		trips.add(new Trip(2, 2, "2021/10/31 12:45"));
		trips.add(new Trip(1, 1, "2021/11/01 10:45"));
		trips.add(new Trip(1, 1, "2021/11/01 11:45"));
		trips.add(new Trip(1, 1, "2021/11/01 12:45"));
		trips.add(new Trip(1, 1, "2021/11/01 13:45"));
		trips.add(new Trip(1, 1, "2021/11/01 14:45"));
		trips.add(new Trip(1, 1, "2021/11/01 15:45"));
		trips.add(new Trip(1, 1, "2021/11/01 16:45"));
		trips.add(new Trip(1, 1, "2021/11/01 17:45"));
		trips.add(new Trip(1, 1, "2021/11/01 18:45"));
		trips.add(new Trip(1, 1, "2021/11/01 19:45"));
		trips.add(new Trip(1, 2, "2021/11/02 18:45"));
		trips.add(new Trip(1, 2, "2021/11/02 10:45"));
		trips.add(new Trip(1, 2, "2021/11/02 11:45"));
		trips.add(new Trip(1, 2, "2021/11/02 12:45"));
		trips.add(new Trip(1, 2, "2021/11/02 13:45"));
		trips.add(new Trip(1, 2, "2021/11/02 14:45"));
		trips.add(new Trip(1, 2, "2021/11/02 15:45"));
		trips.add(new Trip(1, 2, "2021/11/02 15:45"));
		trips.add(new Trip(1, 2, "2021/11/02 15:45"));
		trips.add(new Trip(2, 1, "2021/11/03 20:00"));
		trips.add(new Trip(2, 1, "2021/11/03 20:00"));
		trips.add(new Trip(2, 1, "2021/11/03 20:00"));
		trips.add(new Trip(2, 1, "2021/11/03 20:00"));
		trips.add(new Trip(2, 1, "2021/11/03 20:00"));
		trips.add(new Trip(2, 1, "2021/11/03 20:00"));
		trips.add(new Trip(2, 1, "2021/11/03 20:00"));
		trips.add(new Trip(2, 2, "2021/11/04 12:45"));
		trips.add(new Trip(2, 2, "2021/11/04 13:45"));
		trips.add(new Trip(2, 2, "2021/11/04 14:45"));
		trips.add(new Trip(2, 2, "2021/11/04 15:45"));
		trips.add(new Trip(2, 2, "2021/11/04 16:45"));
		trips.add(new Trip(2, 2, "2021/11/04 17:45"));
		trips.add(new Trip(2, 2, "2021/11/04 18:45"));
		trips.add(new Trip(2, 2, "2021/11/04 19:45"));
		trips.add(new Trip(2, 2, "2021/11/04 20:45"));
		trips.add(new Trip(2, 1, "2021/11/05 05:30"));
		trips.add(new Trip(2, 1, "2021/11/05 06:30"));
		trips.add(new Trip(2, 1, "2021/11/05 07:30"));
		trips.add(new Trip(2, 1, "2021/11/05 08:30"));
		trips.add(new Trip(2, 1, "2021/11/05 09:30"));
		trips.add(new Trip(2, 1, "2021/11/05 10:30"));
		trips.add(new Trip(2, 1, "2021/11/05 11:30"));
		trips.add(new Trip(2, 1, "2021/11/05 12:30"));
		trips.add(new Trip(2, 1, "2021/11/05 13:30"));
		trips.add(new Trip(1, 2, "2021/11/06 04:30"));
		trips.add(new Trip(1, 2, "2021/11/06 05:30"));
		trips.add(new Trip(1, 2, "2021/11/06 06:30"));
		trips.add(new Trip(1, 2, "2021/11/06 07:30"));
		trips.add(new Trip(1, 2, "2021/11/06 08:30"));
		trips.add(new Trip(1, 2, "2021/11/06 09:30"));
		trips.add(new Trip(1, 2, "2021/11/06 10:30"));
		trips.add(new Trip(1, 2, "2021/11/06 11:30"));
		trips.add(new Trip(1, 2, "2021/11/06 02:30"));
		TotalTripsInfo totalTripsInfo = fareEngine.calculate(trips);
		Assert.assertEquals(600, totalTripsInfo.getTotalFare());
		Assert.assertEquals(600, totalTripsInfo.getWeekTrip(45).getWeekTotalFare());
		Assert.assertEquals(80, totalTripsInfo.getWeekTrip(45).getDayTrip(1).getDayTotalFare());
		Assert.assertEquals(100, totalTripsInfo.getWeekTrip(45).getDayTrip(2).getDayTotalFare());
		Assert.assertEquals(120, totalTripsInfo.getWeekTrip(45).getDayTrip(3).getDayTotalFare());
		Assert.assertEquals(120, totalTripsInfo.getWeekTrip(45).getDayTrip(4).getDayTotalFare());
		Assert.assertEquals(80, totalTripsInfo.getWeekTrip(45).getDayTrip(5).getDayTotalFare());
		Assert.assertEquals(100, totalTripsInfo.getWeekTrip(45).getDayTrip(6).getDayTotalFare());
		Assert.assertEquals(0, totalTripsInfo.getWeekTrip(45).getDayTrip(7).getDayTotalFare());
		
	}
	
	
	

}
