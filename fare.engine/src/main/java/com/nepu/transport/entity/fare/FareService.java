package com.nepu.transport.entity.fare;

import com.nepu.transport.trips.Trip;

/*
 * Given a trip return the fare
 */
public interface FareService {
	public FareCategory getFare(Trip trip);
}
