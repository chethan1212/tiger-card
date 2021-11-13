package com.nepu.transport.entity.fare;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nepu.transport.entity.specialhours.SpecialHours;
import com.nepu.transport.entity.specialhours.SpecialHoursService;
import com.nepu.transport.trips.Trip;

/**
 * Mimics a DB fetch for fare based on trip details.
 * Temp proxy class hard codes the rules. But an actual class
 * can get the fare from the FareCategory table based on Special Hours defined.
 * @author chethan.c
 *
 */
@Component
public class FareServiceProxyImpl implements FareService {

	@Autowired
	private SpecialHoursService specialHoursService;

	/**
	 * Hard coded proxy class.
	 * Actual implementation fetch from DB.
	 */
	@Override
	public FareCategory getFare(Trip trip) {
		// Special hours identify whether the trip is off peak hours or peak hours.
		SpecialHours specialHours = specialHoursService.getSpecialHours(trip);
		if (trip.getFromZone() == 1 && trip.getToZone() == 1) {
			if (specialHours.getTripCategoryId() == 1) {
				return new FareCategory(trip.getFromZone(), trip.getToZone(), 25);
			} else {
				return new FareCategory(trip.getFromZone(), trip.getToZone(), 30);
			}
		} else if (trip.getFromZone() == 2 && trip.getToZone() == 2) {
			if (specialHours.getTripCategoryId() == 1) {
				return new FareCategory(trip.getFromZone(), trip.getToZone(), 20);
			} else {
				return new FareCategory(trip.getFromZone(), trip.getToZone(), 25);
			}
		} else {
			if (specialHours.getTripCategoryId() == 1) {
				return new FareCategory(trip.getFromZone(), trip.getToZone(), 30);
			} else {
				return new FareCategory(trip.getFromZone(), trip.getToZone(), 35);
			}
		}
	}

}
