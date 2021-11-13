package com.nepu.transport.fare.engine;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nepu.transport.trips.TotalTripsInfo;
import com.nepu.transport.trips.Trip;

/**
 * Dummy test controller wrote to ease the testing of scenarios. Again nothing to see here!!. Move on.
 * @author chethan.c
 *
 */
@RestController
@RequestMapping("/calculate")
public class FareController {

	@Autowired
	private FareEngine fareEngine;

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	String calcualteFare(@RequestBody List<Trip> trips) throws JsonProcessingException {
		TotalTripsInfo totalTripsInfo = fareEngine.calculate(trips);
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(totalTripsInfo);
		return result;
	}

}
