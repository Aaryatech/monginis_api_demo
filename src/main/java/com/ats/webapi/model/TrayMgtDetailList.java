package com.ats.webapi.model;

import java.io.Serializable;
import java.util.List;

import com.ats.webapi.model.tray.TrayMgtDetail;

public class TrayMgtDetailList implements Serializable{

	private int frId;
	
	private List<TrayMgtDetail> trayMgtDetailsList;

	public int getFrId() {
		return frId;
	}

	public void setFrId(int frId) {
		this.frId = frId;
	}

	public List<TrayMgtDetail> getTrayMgtDetailsList() {
		return trayMgtDetailsList;
	}

	public void setTrayMgtDetailsList(List<TrayMgtDetail> trayMgtDetailsList) {
		this.trayMgtDetailsList = trayMgtDetailsList;
	}

	@Override
	public String toString() {
		return "TrayMgtDetailList [frId=" + frId + ", trayMgtDetailsList=" + trayMgtDetailsList + "]";
	}
	
	
}
