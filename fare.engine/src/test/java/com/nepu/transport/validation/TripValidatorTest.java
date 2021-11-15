package com.nepu.transport.validation;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nepu.transport.App;
import com.nepu.transport.Constants;
import com.nepu.transport.InvalidInputException;
import com.nepu.transport.trips.Trip;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
public class TripValidatorTest {
	
	@Autowired
	TripValidator tripValidator;
	
	@Test
	public void testNullTripAndEmptyTrip() {
		try {
			tripValidator.validate(null);
		} catch (InvalidInputException e) {
			Assert.assertEquals(e.getMessage(),"Null on empty list given as input to fare engine");
		}
	}
	
	@Test
	public void testInValidZoneAndTime() {
		List<Trip> trips = new ArrayList<>();
		Trip trip = new Trip(9, 0, "xyz");
		trips.add(trip);
		List<String> errors =  tripValidator.validate(trips);
		Assert.assertEquals(2, errors.size());
		Assert.assertEquals(true, errors.contains(Constants.TCTZ001));
		Assert.assertEquals(true, errors.contains(Constants.TCTD001));
		
	
	}
	
	@Test
	public void testStartTimeMissing() {
		List<Trip> trips = new ArrayList<>();
		Trip trip = new Trip(2, 1, "");
		trips.add(trip);
		List<String> errors =  tripValidator.validate(trips);
		Assert.assertEquals(1, errors.size());
		Assert.assertEquals(true, errors.contains(Constants.TCTD001));
		
	
	}

}
