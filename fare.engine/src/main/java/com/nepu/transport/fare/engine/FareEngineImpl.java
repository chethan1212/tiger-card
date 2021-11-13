package com.nepu.transport.fare.engine;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nepu.transport.entity.fare.FareCategory;
import com.nepu.transport.entity.fare.FareService;
import com.nepu.transport.entity.farecap.FareCap;
import com.nepu.transport.entity.farecap.FareCapService;
import com.nepu.transport.trips.DayTrips;
import com.nepu.transport.trips.TotalTripsInfo;
import com.nepu.transport.trips.Trip;
import com.nepu.transport.trips.WeekTrips;

@Component("fareEngine")
public class FareEngineImpl implements FareEngine{
	
	@Autowired
	private FareCapService fareCapService;
	
	@Autowired
	private FareService fareService;

	/*
	 * Calculate weekly and daily fares keeping the zone and fare cap in the logic.
	 * Expects a list of trips with the startDateTime in yyyy/MM/dd HH:mm - a pre validation expected to reject if the date isn't a match.
	 * 
	 */
	public TotalTripsInfo calculate(List<Trip> tripInfos) {
		// Converts list of trips into total trip info.
		// Total trips contains list of week and each week contains list of days and each day contain list of trips.
		TotalTripsInfo totalTripsInfo = createTotalTripsInfo(tripInfos);
		//Iterate over each week in the order of weeks. Not really necessary , but helps with implementing monthly fair cap in future.
		int totalFare = 0;
		for (Map.Entry<Integer, WeekTrips> eachWeek : totalTripsInfo.getWeekTrips().entrySet()) {
			// Iterate over each day and then for each day calculate total fare. 
			FareCap weeklyFareCap = fareCapService.getFareCap(eachWeek.getValue());
			int weeklyFareCapleft = weeklyFareCap.getFareCap();
			int weeklyFareTotal = 0;
			for (Map.Entry<Integer, DayTrips> eachDay : eachWeek.getValue().getDayTrips().entrySet()) {
				DayTrips dayTrips = eachDay.getValue();
				//Calculate each days all trips total. 
				calcualteDayTripFares(dayTrips,weeklyFareCapleft);
				if( weeklyFareTotal + dayTrips.getDayTotalFare() <= weeklyFareCap.getFareCap() ) {
					weeklyFareTotal = weeklyFareTotal + dayTrips.getDayTotalFare();
				}
				weeklyFareCapleft = weeklyFareCap.getFareCap() - weeklyFareTotal;
			}
			totalFare = totalFare + weeklyFareTotal;
			eachWeek.getValue().setWeekTotalFare(weeklyFareTotal);
		}
		totalTripsInfo.setTotalFare(totalFare);
		return totalTripsInfo;
	}
	
	/**
	 * 
	 * @param dayTrips
	 * @param weeklyFareCapleft
	 */
	void calcualteDayTripFares(DayTrips dayTrips, int weeklyFareCapleft) {
		List<Trip> trips = dayTrips.getTrips();
		// Sort the trips for a single day based on time in HHMM format.
		trips.sort(Comparator.comparingInt(Trip::getTime));
		// get the daily fare cap based on the longest trip in the list.
		int dailyFareCap = fareCapService.getFareCap(dayTrips).getFareCap();
		// Verify whether to apply weekly cap or daily cap.
		if(weeklyFareCapleft < dailyFareCap) {
			dailyFareCap = weeklyFareCapleft;
		}
		int dailyFareTotal = 0;
		for (Trip trip : trips) {
			FareCategory fare = fareService.getFare(trip);
			trip.setStandardfare(fare.getFare());
			if(dailyFareTotal + fare.getFare() <= dailyFareCap) {
				trip.setActualFare(fare.getFare());
				dailyFareTotal = dailyFareTotal + fare.getFare();
			}else {
				trip.setActualFare(dailyFareCap - dailyFareTotal);
				dailyFareTotal = dailyFareCap;
			}
		}
		dayTrips.setDayTotalFare(dailyFareTotal);
	}

	/**
	 * Converts list of trips into total trip info.
	 * Total trips contains list of week and each week contains list of days and each day contain list of trips.
	 * @param tripInfos
	 * @return
	 */
	TotalTripsInfo createTotalTripsInfo(List<Trip> tripInfos) {
		TotalTripsInfo totalTripsInfo = new TotalTripsInfo();
		for (Trip tripInfo : tripInfos) {
			Date date = null;
			try {
				date = new SimpleDateFormat("yyyy/MM/dd HH:mm").parse(tripInfo.getStartDateTime());
			} catch (ParseException e) {
				// Validation should have handled this case already.
			}
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
			int year = calendar.get(Calendar.YEAR);
			int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
			totalTripsInfo.getWeekTrip(weekOfYear).getDayTrip(dayOfWeek).getTrips().add(tripInfo);
		}
		return totalTripsInfo;
	}

}
