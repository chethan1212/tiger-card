package com.nepu.transport.trips;

/*
 * ALl the trips over a week. 
 * As of now doesnt handle the corner case of weeks spanning multiple years - Yet to be deined
 */
import java.util.Map;
import java.util.TreeMap;

public class WeekTrips {

	private long weekTotalFare;

	private int weekOfYear;

	/*
	 * Maintained as tree-map to preserve the order.
	 */
	private Map<Integer, DayTrips> dayTrips;

	public DayTrips getDayTrip(Integer dayOfWeek) {
		if(!getDayTrips().containsKey(dayOfWeek)) {
			getDayTrips().put(dayOfWeek, new DayTrips(dayOfWeek));
		}
		return getDayTrips().get(dayOfWeek);
	}

	public WeekTrips(int weekOfYear) {
		this.weekOfYear = weekOfYear;
	}

	public long getWeekTotalFare() {
		return weekTotalFare;
	}

	public void setWeekTotalFare(long weekTotal) {
		this.weekTotalFare = weekTotal;
	}

	public Map<Integer, DayTrips> getDayTrips() {
		if (dayTrips == null) {
			dayTrips = new TreeMap<>();
		}
		return dayTrips;
	}

}
