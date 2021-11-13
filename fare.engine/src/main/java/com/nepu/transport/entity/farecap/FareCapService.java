package com.nepu.transport.entity.farecap;

import com.nepu.transport.trips.DayTrips;
import com.nepu.transport.trips.WeekTrips;

/*
 * 
 * Interface to define the Farecap based on daily and weekly trips.
 * Ideally can be configured to fetch from FareCap Table.
 * 
 */
public interface FareCapService {
	
	public FareCap getFareCap(DayTrips dayTrips);
	
	public FareCap getFareCap(WeekTrips weekTrips);

}
