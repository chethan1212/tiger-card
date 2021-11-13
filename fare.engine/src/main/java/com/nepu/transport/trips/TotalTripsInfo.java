package com.nepu.transport.trips;

import java.util.Map;
import java.util.TreeMap;

/**
 * Entire trip info.
 * List<trips> is converted to TotalTripsInfo.
 * @author chethan.c
 *
 */
public class TotalTripsInfo {

	private int totalFare;

	/*
	 * Maintained as tree-map t preserve order.
	 */
	private Map<Integer, WeekTrips> weekTrips;

	public WeekTrips getWeekTrip(int weekOfYear) {
		if (!getWeekTrips().containsKey(weekOfYear)) {
			getWeekTrips().put(weekOfYear, new WeekTrips(weekOfYear));
		}
		return getWeekTrips().get(weekOfYear);
	}

	public int getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(int totalFare) {
		this.totalFare = totalFare;
	}

	public Map<Integer, WeekTrips> getWeekTrips() {
		if (weekTrips == null)
			weekTrips = new TreeMap<Integer, WeekTrips>();
		return weekTrips;
	}

	public void setWeekTrips(Map<Integer, WeekTrips> weekTrips) {
		this.weekTrips = weekTrips;
	}

}
