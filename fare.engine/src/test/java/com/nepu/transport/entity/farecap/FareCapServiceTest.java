package com.nepu.transport.entity.farecap;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nepu.transport.App;
import com.nepu.transport.trips.DayTrips;
import com.nepu.transport.trips.Trip;
import com.nepu.transport.trips.WeekTrips;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
public class FareCapServiceTest {
	
	@Autowired
	FareCapService fareCapService;
	
	@Test
	public void testDailyFareCapForOnlyZone1to1Trip() {
		DayTrips dayTrips = new DayTrips(1);
		dayTrips.getTrips().add(new Trip(1, 1, "2021/10/31 10:45"));
		dayTrips.getTrips().add(new Trip(1, 1, "2021/10/31 10:45"));
		FareCap fareCap = fareCapService.getFareCap(dayTrips);
		Assert.assertEquals(100, fareCap.getFareCap());
	}
	
	@Test
	public void testDailyFareCapForOnlyZone1to2Trip() {
		DayTrips dayTrips = new DayTrips(1);
		dayTrips.getTrips().add(new Trip(1, 1, "2021/10/31 10:45"));
		dayTrips.getTrips().add(new Trip(1, 2, "2021/10/31 10:45"));
		FareCap fareCap = fareCapService.getFareCap(dayTrips);
		Assert.assertEquals(120, fareCap.getFareCap());
	}
	
	@Test
	public void testDailyFareCapForOnlyZone2to2Trip() {
		DayTrips dayTrips = new DayTrips(1);
		dayTrips.getTrips().add(new Trip(2, 2, "2021/10/31 10:45"));
		dayTrips.getTrips().add(new Trip(2, 2, "2021/10/31 10:45"));
		FareCap fareCap = fareCapService.getFareCap(dayTrips);
		Assert.assertEquals(80, fareCap.getFareCap());
	}
	
	@Test
	public void testDailyFareCapForOnlyZone1to1And2to2Trip() {
		DayTrips dayTrips = new DayTrips(1);
		dayTrips.getTrips().add(new Trip(1, 1, "2021/10/31 10:45"));
		dayTrips.getTrips().add(new Trip(2, 2, "2021/10/31 10:45"));
		FareCap fareCap = fareCapService.getFareCap(dayTrips);
		Assert.assertEquals(100, fareCap.getFareCap());
	}
	
	@Test
	public void testDailyFareCapForOnlyZone1to1And1to2Trip() {
		DayTrips dayTrips = new DayTrips(1);
		dayTrips.getTrips().add(new Trip(1, 1, "2021/10/31 10:45"));
		dayTrips.getTrips().add(new Trip(1, 2, "2021/10/31 10:45"));
		FareCap fareCap = fareCapService.getFareCap(dayTrips);
		Assert.assertEquals(120, fareCap.getFareCap());
	}
	
	@Test
	public void testDailyFareCapForOnlyZone2to2And1to2Trip() {
		DayTrips dayTrips = new DayTrips(1);
		dayTrips.getTrips().add(new Trip(2, 2, "2021/10/31 10:45"));
		dayTrips.getTrips().add(new Trip(1, 2, "2021/10/31 10:45"));
		FareCap fareCap = fareCapService.getFareCap(dayTrips);
		Assert.assertEquals(120, fareCap.getFareCap());
	}
	
	@Test
	public void testWeeklyFareCapForOnlyZone1to1Trip() {
		WeekTrips weekTrips= new WeekTrips(1);
		DayTrips dayTrips = new DayTrips(1);
		weekTrips.getDayTrips().put(1, dayTrips);
		dayTrips.getTrips().add(new Trip(1, 1, "2021/10/31 10:45"));
		dayTrips.getTrips().add(new Trip(1, 1, "2021/10/31 10:45"));
		FareCap fareCap = fareCapService.getFareCap(weekTrips);
		Assert.assertEquals(500, fareCap.getFareCap());
	}
	
	@Test
	public void testWeeklyFareCapForOnlyZone1to2Trip() {
		WeekTrips weekTrips= new WeekTrips(1);
		DayTrips dayTrips = new DayTrips(1);
		weekTrips.getDayTrips().put(1, dayTrips);
		dayTrips.getTrips().add(new Trip(1, 1, "2021/10/31 10:45"));
		dayTrips.getTrips().add(new Trip(1, 2, "2021/10/31 10:45"));
		FareCap fareCap = fareCapService.getFareCap(weekTrips);
		Assert.assertEquals(600, fareCap.getFareCap());
	}
	
	@Test
	public void testWeeklyFareCapForOnlyZone2to2Trip() {
		WeekTrips weekTrips= new WeekTrips(1);
		DayTrips dayTrips = new DayTrips(1);
		weekTrips.getDayTrips().put(1, dayTrips);
		dayTrips.getTrips().add(new Trip(2, 2, "2021/10/31 10:45"));
		dayTrips.getTrips().add(new Trip(2, 2, "2021/10/31 10:45"));
		FareCap fareCap = fareCapService.getFareCap(weekTrips);
		Assert.assertEquals(400, fareCap.getFareCap());
	}
	
	@Test
	public void testWeeklyFareCapForOnlyZone1to1And2to2Trip() {
		WeekTrips weekTrips= new WeekTrips(1);
		DayTrips dayTrips = new DayTrips(1);
		weekTrips.getDayTrips().put(1, dayTrips);
		dayTrips.getTrips().add(new Trip(1, 1, "2021/10/31 10:45"));
		dayTrips.getTrips().add(new Trip(2, 2, "2021/10/31 10:45"));
		FareCap fareCap = fareCapService.getFareCap(weekTrips);
		Assert.assertEquals(500, fareCap.getFareCap());
	}
	
	@Test
	public void testWeeklyFareCapForOnlyZone1to1And1to2Trip() {
		WeekTrips weekTrips= new WeekTrips(1);
		DayTrips dayTrips = new DayTrips(1);
		weekTrips.getDayTrips().put(1, dayTrips);
		dayTrips.getTrips().add(new Trip(1, 1, "2021/10/31 10:45"));
		dayTrips.getTrips().add(new Trip(1, 2, "2021/10/31 10:45"));
		FareCap fareCap = fareCapService.getFareCap(weekTrips);
		Assert.assertEquals(600, fareCap.getFareCap());
	}
	
	@Test
	public void testWeeklyFareCapForOnlyZone2to2And1to2Trip() {
		WeekTrips weekTrips= new WeekTrips(1);
		DayTrips dayTrips = new DayTrips(1);
		weekTrips.getDayTrips().put(1, dayTrips);
		dayTrips.getTrips().add(new Trip(2, 2, "2021/10/31 10:45"));
		dayTrips.getTrips().add(new Trip(1, 2, "2021/10/31 10:45"));
		FareCap fareCap = fareCapService.getFareCap(weekTrips);
		Assert.assertEquals(600, fareCap.getFareCap());
	}

}
