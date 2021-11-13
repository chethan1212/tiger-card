package com.nepu.transport.entity.fare;

/**
 * Initially planned to create a table.Dropped. Instead harcoded in code via  FareService.java
 * 
 * Table data for the sample data provided.
 * ---------------------------------------------
 * |fareId|startZone|endZone|tripCategoryId|fare|
 * ---------------------------------------------
 * |     1|        1|      1|             1|  25|
 * |     1|        1|      1|             2|  30|
 * |     2|        1|      2|             1|  30|
 * |     3|        1|      2|             2|  35|
 * |     4|        2|      1|             1|  30|
 * |     5|        2|      1|             2|  35|
 * |     6|        2|      2|             1|  20|
 * |     7|        2|      2|             2|  25|
 * ----------------------------------------------
 * 
 * @author chethan.c
 *
 */
public class FareCategory {
	
	private int fareId;
	
	private int startZone;
	
	private int endZone;
	
	private int tripCategoryId;
	
	private int fare;
	
	

	public FareCategory(int startZone, int endZone, int fare) {
		this.startZone = startZone;
		this.endZone = endZone;
		this.fare = fare;
	}

	public int getFareId() {
		return fareId;
	}

	public void setFareId(int fareId) {
		this.fareId = fareId;
	}

	public int getStartZone() {
		return startZone;
	}

	public void setStartZone(int startZone) {
		this.startZone = startZone;
	}

	public int getEndZone() {
		return endZone;
	}

	public void setEndZone(int endZone) {
		this.endZone = endZone;
	}

	public int getTripCategoryId() {
		return tripCategoryId;
	}

	public void setTripCategoryId(int tripCategoryId) {
		this.tripCategoryId = tripCategoryId;
	}

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}
	
	

}
