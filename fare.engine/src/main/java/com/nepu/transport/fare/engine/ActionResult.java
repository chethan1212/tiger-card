package com.nepu.transport.fare.engine;

import java.util.List;

import com.nepu.transport.trips.TotalTripsInfo;

public class ActionResult {

	private String status;

	private TotalTripsInfo totalTripsInfo;

	private List<String> erros;
	
	public ActionResult(String status, TotalTripsInfo totalTripsInfo, List<String> erros) {
		super();
		this.status = status;
		this.totalTripsInfo = totalTripsInfo;
		this.erros = erros;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public TotalTripsInfo getTotalTripsInfo() {
		return totalTripsInfo;
	}

	public void setTotalTripsInfo(TotalTripsInfo totalTripsInfo) {
		this.totalTripsInfo = totalTripsInfo;
	}

	public List<String> getErros() {
		return erros;
	}

	public void setErros(List<String> erros) {
		this.erros = erros;
	}

}
