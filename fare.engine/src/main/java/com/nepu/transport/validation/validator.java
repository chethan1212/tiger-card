package com.nepu.transport.validation;

import java.util.List;

import com.nepu.transport.trips.Trip;

public interface validator {
	
	public List<String> validate(List<Trip> trips);

}
