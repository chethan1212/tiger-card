package com.nepu.transport;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nepu.transport.trips.Trip;

/**
 * Just a client class created to test the Fare Engine. Nothing to see here. move on.
 * @author chethan.c
 *
 */
public class ClientTester {

	public static void main(String[] args) throws ClientProtocolException, IOException {

		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost postRequest = new HttpPost("http://localhost:8080/calculate");

		List<Trip> trips = new ArrayList<>();
//		trips.add(new Trip(1, 2, "2021/11/07 09:30"));
//		trips.add(new Trip(1, 2, "2021/11/07 08:30"));
//		trips.add(new Trip(1, 2, "2021/11/07 07:30"));
//		trips.add(new Trip(1, 2, "2021/11/07 06:30"));
//		trips.add(new Trip(1, 2, "2021/11/07 05:30"));
//		trips.add(new Trip(1, 2, "2021/11/07 04:30"));
//		trips.add(new Trip(1, 2, "2021/11/07 03:30"));
//		trips.add(new Trip(1, 2, "2021/11/07 02:30"));
//		trips.add(new Trip(1, 2, "2021/11/07 01:30"));
//		trips.add(new Trip(1, 2, "2021/11/07 11:30"));
//		trips.add(new Trip(1, 2, "2021/11/07 12:30"));
//		trips.add(new Trip(1, 2, "2021/11/07 13:30"));
		

		ObjectMapper mapper = new ObjectMapper();
		StringEntity inputEntity = new StringEntity(mapper.writeValueAsString(trips));
		inputEntity.setContentType("application/json");
		postRequest.setEntity(inputEntity);
		HttpResponse response = httpClient.execute(postRequest);
		BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
		String output= null;
		while ((output = br.readLine()) != null) {
			System.out.println("------------------------------------------------------------------------------------------------------------------");
			System.out.println(output);
			System.out.println("------------------------------------------------------------------------------------------------------------------");
		}
		httpClient.getConnectionManager().shutdown();

	}

}
