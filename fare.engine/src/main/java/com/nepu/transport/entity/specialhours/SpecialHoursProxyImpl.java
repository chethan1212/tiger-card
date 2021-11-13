package com.nepu.transport.entity.specialhours;

import org.springframework.stereotype.Component;

import com.nepu.transport.trips.Trip;

/*
 * Identify whether a given trip belongs to peak hours or off peak hours.
 */
@Component
public class SpecialHoursProxyImpl implements SpecialHoursService{

	/*
	 * Hardcoded instead of fetching from DB.
	 */
	public SpecialHours getSpecialHours(Trip trip) {
		if (trip.getDayOfWeek() == 1 || trip.getDayOfWeek() == 7) {
			if ((trip.getTime() >= 900 && trip.getTime() < 1100) || (trip.getTime() >= 1800 && trip.getTime() < 2200)) {
				return new SpecialHours(2, trip.getDayOfWeek());
			} else {
				return new SpecialHours(1, trip.getDayOfWeek());
			}
		} else {
			if ((trip.getTime() >= 700 && trip.getTime() < 1030) || (trip.getTime() >= 1700 && trip.getTime() < 2000)) {
				return new SpecialHours(2, trip.getDayOfWeek());
			} else {
				return new SpecialHours(1, trip.getDayOfWeek());
			}
		}
	}

}
