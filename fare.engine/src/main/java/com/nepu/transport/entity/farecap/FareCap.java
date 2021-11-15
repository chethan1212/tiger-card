package com.nepu.transport.entity.farecap;

/**
 * 
 * Initially planned to create a table.Dropped. Instead harcoded in code via  FareCapService.java
 * 
 * This allows to define monthly or yearly fare cap in future.
 * Also allows to define separate farecap between zones.
 * 
 * Table data for the sample data provided.
 *  -----------------------------------------
 * | fromZone| toZone|   capCategory|fareCap|
 * -----------------------------------------
 * |        1|      1|         Daily|    100|
 * |        1|      1|        Weekly|    500|
 * |        1|      2|         Daily|    120|
 * |        1|      2|        Weekly|    600|
 * |        2|      1|         Daily|    120|
 * |        2|      1|        Weekly|    600|
 * |        2|      2|         Daily|     80|
 * |        2|      2|        Weekly|    400|
 * -----------------------------------------
 * 
 * @author chethan.c
 *
 */
public class FareCap {
	
	private int fromZone;
	
	private int toZone;
	
	private String capCategory;
	
	private int fareCap;
	
	public FareCap(String capCategory, int fareCap) {
		this.capCategory = capCategory;
		this.fareCap = fareCap;
	}

	public int getFareCap() {
		return fareCap;
	}

	public void setFareCap(int fareCap) {
		this.fareCap = fareCap;
	}
	
	

}
