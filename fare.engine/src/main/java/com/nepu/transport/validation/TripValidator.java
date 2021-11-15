package com.nepu.transport.validation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.nepu.transport.Constants;
import com.nepu.transport.InvalidInputException;
import com.nepu.transport.trips.Trip;

@Component
public class TripValidator implements validator {

	@Override
	public List<String> validate(List<Trip> trips) {
		if (trips == null || trips.isEmpty()) {
			throw new InvalidInputException("Null on empty list given as input to fare engine");
		}
		List<String> errors = new ArrayList<String>();
		for (Trip trip : trips) {
			if (!(trip.getFromZone() == 1 || trip.getFromZone() == 2 || trip.getToZone() == 1 || trip.getToZone() == 2)) {
				errors.add(Constants.TCTZ001);
			}
			if(trip.getStartDateTime() == null || trip.getStartDateTime().trim() == "") {
				errors.add(Constants.TCTD001);
			}else {
				
				DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		        sdf.setLenient(false);
		        try {
		            sdf.parse(trip.getStartDateTime());
		        } catch (ParseException e) {
		        	errors.add(Constants.TCTD001);
		        }
			}
		}
		return errors;
	}

}
