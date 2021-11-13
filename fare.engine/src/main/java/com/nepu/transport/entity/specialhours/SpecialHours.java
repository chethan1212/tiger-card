package com.nepu.transport.entity.specialhours;

/**
 * Initially planned to create a table.Dropped. Instead hard coded in code via  SpecialHoursService.java
 * 
 * Define special hours. Only special hours. Some sample rows below.
 * 
 *  --------------------------------------------
 * | tripCategoryId| dayOfWeek| startime|endtime|
 * ---------------------------------------------
 * |              2|         1|     0900|   1100|
 * |              2|         1|     1800|   2200|
 * |              2|         7|     0900|   1100|
 * |              2|         7|     1800|   2200|
 * |              2|         2|     0700|   1030|
 * |              2|         3|     0700|   1030|
 * |              2|         4|     0700|   1030|
 * |              2|         5|     0700|   1030|
 * 
 * 
 */
public class SpecialHours {
	
	/*
	 * Define the category. Peak Hours / off peak hours. In future can define night hours.
	 */
	private int tripCategoryId;
	
	private int dayOfWeek;
	
	private int startime;
	
	private int endtime;
	
	

	public SpecialHours(int tripCategoryId, int dayOfWeek) {
		this.tripCategoryId = tripCategoryId;
		this.dayOfWeek = dayOfWeek;
	}

	public int getTripCategoryId() {
		return tripCategoryId;
	}

	public void setTripCategoryId(int tripCategoryId) {
		this.tripCategoryId = tripCategoryId;
	}

	public int getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(int dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public int getStartime() {
		return startime;
	}

	public void setStartime(int startime) {
		this.startime = startime;
	}

	public int getEndtime() {
		return endtime;
	}

	public void setEndtime(int endtime) {
		this.endtime = endtime;
	}
	
	
	

}
