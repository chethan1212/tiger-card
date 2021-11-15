package com.nepu.transport.trips;

/**
 * Each trip info.
 * Input will have fromzone, toZone and startDateTime in "yyyy/MM/dd HH:mm" format.
 */
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Trip {
	
	/*
	 * To be used when persisting this to DB.
	 */
	// private long tripId;
	
	private int fromZone;
	
	private int toZone;
	
	/*
	 * Start Date time in "yyyy/MM/dd HH:mm" format.
	 */
	private String startDateTime;
	
	/*
	 * Actual fare to be paid after adjusting to fare cap.
	 */
	private int actualFare;
	
	/*
	 * As defined.
	 */
	private int standardfare;
	
	public Trip() {
	}
	
	public Trip(int fromZone, int toZone, String startDateTime) {
		this.fromZone = fromZone;
		this.toZone = toZone;
		this.startDateTime = startDateTime;
	}

	public int getDayOfWeek() {
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy/MM/dd HH:mm").parse(startDateTime);
		} catch (ParseException e) {
			// TODO Handle this elegantly.
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_WEEK);
	}
	

	public int getTime() {
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy/MM/dd HH:mm").parse(startDateTime);
		} catch (ParseException e) {
			// TODO Handle this elegantly.
		}
		DateFormat format = new SimpleDateFormat("HHmm");
		return Integer.parseInt(format.format(date));
	}
	

	public void setActualFare(int actualFare) {
		this.actualFare = actualFare;
	}

	public void setStandardfare(int standardfare) {
		this.standardfare = standardfare;
	}

	public int getFromZone() {
		return fromZone;
	}

	public int getToZone() {
		return toZone;
	}

	public String getStartDateTime() {
		return startDateTime;
	}

	@Override
	public String toString() {
		return "Trip [fromZone=" + fromZone + ", toZone=" + toZone + ", startDateTime="
				+ startDateTime + ", actualFare=" + actualFare + ", standardfare=" + standardfare + "]";
	}

	
	
}
