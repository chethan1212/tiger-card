package com.nepu.transport.trips;

import java.util.ArrayList;
import java.util.List;

/**
 * Total trips taken in a day.-
 * @author chethan.c
 *
 */
public class DayTrips {
	
	private int dayTotalFare;
	
	private int dayOfWeek;
	
	private List<Trip> trips;
	
	public int getDayTotalFare() {
		return dayTotalFare;
	}

	public void setDayTotalFare(int dayTotalFare) {
		this.dayTotalFare = dayTotalFare;
	}

	public DayTrips(int dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public List<Trip> getTrips() {
		if(trips == null) {
			trips = new ArrayList<>();
		}
		return trips;
	}

}
