package com.nepu.transport.entity.fare;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nepu.transport.App;
import com.nepu.transport.entity.specialhours.SpecialHours;
import com.nepu.transport.entity.specialhours.SpecialHoursService;
import com.nepu.transport.trips.Trip;

@ActiveProfiles("mockSpecialHoursService")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
public class FareServiceTest {

	@Autowired
	FareService fareService;

	@Autowired
	SpecialHoursService specialHoursService;

	@Test
	public void testNormalHoursFareZone1to1() {
		Trip trip = new Trip(1, 1, "2021/10/31 10:45");
		SpecialHours specialHours = new SpecialHours(1, 1);
		Mockito.when(specialHoursService.getSpecialHours(trip)).thenReturn(specialHours);
		FareCategory category = fareService.getFare(trip);
		Assert.assertEquals(25, category.getFare());
	}
	
	@Test
	public void testPeakHoursFareZone1to1() {
		Trip trip = new Trip(1, 1, "2021/10/31 10:45");
		SpecialHours specialHours = new SpecialHours(2, 1);
		Mockito.when(specialHoursService.getSpecialHours(trip)).thenReturn(specialHours);
		FareCategory category = fareService.getFare(trip);
		Assert.assertEquals(30, category.getFare());
	}
	
	@Test
	public void testNormalHoursFareZone1to2() {
		Trip trip = new Trip(1, 2, "2021/10/31 10:45");
		SpecialHours specialHours = new SpecialHours(1, 1);
		Mockito.when(specialHoursService.getSpecialHours(trip)).thenReturn(specialHours);
		FareCategory category = fareService.getFare(trip);
		Assert.assertEquals(30, category.getFare());
	}
	
	@Test
	public void testPeakHoursFareZone1to2() {
		Trip trip = new Trip(1, 2, "2021/10/31 10:45");
		SpecialHours specialHours = new SpecialHours(2, 1);
		Mockito.when(specialHoursService.getSpecialHours(trip)).thenReturn(specialHours);
		FareCategory category = fareService.getFare(trip);
		Assert.assertEquals(35, category.getFare());
	}
	
	@Test
	public void testNormalHoursFareZone2to2() {
		Trip trip = new Trip(2, 2, "2021/10/31 10:45");
		SpecialHours specialHours = new SpecialHours(1, 1);
		Mockito.when(specialHoursService.getSpecialHours(trip)).thenReturn(specialHours);
		FareCategory category = fareService.getFare(trip);
		Assert.assertEquals(20, category.getFare());
	}
	
	@Test
	public void testPeakHoursFareZone2to2() {
		Trip trip = new Trip(2, 2, "2021/10/31 10:45");
		SpecialHours specialHours = new SpecialHours(2, 1);
		Mockito.when(specialHoursService.getSpecialHours(trip)).thenReturn(specialHours);
		FareCategory category = fareService.getFare(trip);
		Assert.assertEquals(25, category.getFare());
	}

}
