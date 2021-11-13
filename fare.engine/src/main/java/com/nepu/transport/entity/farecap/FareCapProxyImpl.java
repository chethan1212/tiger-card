package com.nepu.transport.entity.farecap;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.nepu.transport.trips.DayTrips;
import com.nepu.transport.trips.Trip;
import com.nepu.transport.trips.WeekTrips;

/*
 * 
 * Returns the Fare Cap from FareCap table based on the Daily or Weekly data passed to the service.
 * Harcoded to mimic DB system.
 * 
 */
@Component
public class FareCapProxyImpl implements FareCapService{

	/*
	 * Returns daily fare cap based on day trip details.
	 */
	@Override
	public FareCap getFareCap(DayTrips dayTrips) {
		List<Trip> trips = dayTrips.getTrips();
		List<Trip> zone1and2Trips = trips.stream().filter(trip -> (( trip.getFromZone() == 1 &&  trip.getToZone() ==2)
				||( trip.getFromZone() == 2 &&  trip.getToZone() ==1))).collect(Collectors.toList());
		if(zone1and2Trips != null && !zone1and2Trips.isEmpty()) {
			return new FareCap("daily", 120);
		}
		List<Trip> zone1and1Trips = trips.stream().filter(trip -> (( trip.getFromZone() == 1 &&  trip.getToZone() ==1))).collect(Collectors.toList());
		if(zone1and1Trips != null && !zone1and1Trips.isEmpty()) {
			return new FareCap("daily", 100);
		}
		return new FareCap("daily", 80);
	}
	
	
	/*
	 * Return weekly fare cap based on weekly trip details.
	 */
	public FareCap getFareCap(WeekTrips weekTrips) {
		Map<Integer,DayTrips> dayTrips = weekTrips.getDayTrips();
		List zone1and2DayTrips = dayTrips.values().stream().filter( dayTrip -> (getFareCap(dayTrip).getFareCap() == 120)).collect(Collectors.toList());
		if(zone1and2DayTrips != null && !zone1and2DayTrips.isEmpty()) {
			return new FareCap("weekly", 600);
		}
		List zone1and1DayTrips = dayTrips.values().stream().filter( dayTrip -> (getFareCap(dayTrip).getFareCap() == 100)).collect(Collectors.toList());
		if(zone1and1DayTrips != null && !zone1and1DayTrips.isEmpty()) {
			return new FareCap("weekly", 500);
		}
		return new FareCap("weekly", 400);
	}

}
