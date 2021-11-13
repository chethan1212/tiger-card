package com.nepu.transport.fare.engine;

import java.util.List;

import com.nepu.transport.trips.TotalTripsInfo;
import com.nepu.transport.trips.Trip;

/**
 * Heart and soul of the application.
 * Takes a list of trips and returns trip info with fares.
 * @author chethan.c
 *
 */
public interface FareEngine {
	
	public TotalTripsInfo calculate(List<Trip> tripInfos);

}
