package com.nepu.transport.entity.specialhours;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nepu.transport.App;
import com.nepu.transport.trips.Trip;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
public class SpecialHoursServiceTest {
	
	@Autowired
	SpecialHoursService specialHoursService;
	
	@Test
	public void testSpecialHoursWeekend() {
		Trip trip = new Trip(1, 1, "2021/10/31 10:45");
		SpecialHours specialHours = specialHoursService.getSpecialHours(trip);
		Assert.assertEquals(2, specialHours.getTripCategoryId());
	}
	
	@Test
	public void testNormalHoursWeekend() {
		Trip trip = new Trip(1, 1, "2021/10/31 6:45");
		SpecialHours specialHours = specialHoursService.getSpecialHours(trip);
		Assert.assertEquals(1, specialHours.getTripCategoryId());
	}
	
	@Test
	public void testSpecialHoursWeekDay() {
		Trip trip = new Trip(1, 1, "2021/11/02 9:45");
		SpecialHours specialHours = specialHoursService.getSpecialHours(trip);
		Assert.assertEquals(2, specialHours.getTripCategoryId());
	}
	
	@Test
	public void testNormalHoursWeekDay() {
		Trip trip = new Trip(1, 1, "2021/11/02 6:45");
		SpecialHours specialHours = specialHoursService.getSpecialHours(trip);
		Assert.assertEquals(1, specialHours.getTripCategoryId());
	}

}
