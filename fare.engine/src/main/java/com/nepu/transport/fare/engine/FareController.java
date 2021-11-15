package com.nepu.transport.fare.engine;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nepu.transport.Constants;
import com.nepu.transport.trips.TotalTripsInfo;
import com.nepu.transport.trips.Trip;
import com.nepu.transport.validation.TripValidator;

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
	
	@Autowired
	private TripValidator tripValidator;

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	String calcualteFare(@RequestBody List<Trip> trips) throws JsonProcessingException {
		ActionResult actionResult = null;
		ObjectMapper mapper = new ObjectMapper();
		List<String> errors =  tripValidator.validate(trips);
		if(errors != null) {
			TotalTripsInfo totalTripsInfo = fareEngine.calculate(trips);
			actionResult = new ActionResult(Constants.SUCCESS, totalTripsInfo, null);
		}else {
			actionResult = new ActionResult(Constants.VALIDATION_ERR, null, errors);
		}
		String result = mapper.writeValueAsString(actionResult);
		return result;
	}

}
