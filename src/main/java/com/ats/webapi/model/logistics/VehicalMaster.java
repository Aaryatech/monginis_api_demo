package com.ats.webapi.model.logistics;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "m_logis_vehical")
public class VehicalMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "veh_id")
	private int vehId; 
	
	@Column(name = "veh_no")
	private String vehNo;

	@Column(name = "make_id")
	private int makeId;

	@Column(name = "veh_eng_no")
	private String vehEngNo;
	
	@Column(name = "veh_chesi_no")
	private String vehChesiNo;

	@Column(name = "veh_color")
	private String vehColor;

	@Column(name = "purchase_date")
	private Date purchaseDate;
	
	@Column(name = "reg_date")
	private Date regDate;
	
	@Column(name = "dealer_id")
	private int dealerId;

	@Column(name = "fuel_type")
	private int fuelType;

	@Column(name = "veh_type_id")
	private int vehTypeId;
	
	@Column(name = "variant_id")
	private int variantId;

	@Column(name = "veh_comp_avg")
	private float vehCompAvg;

	@Column(name = "veh_stand_avg")
	private float vehStandAvg;
	
	@Column(name = "veh_mini_avg")
	private float vehMiniAvg;

	@Column(name = "del_status")
	private int delStatus;
	
	@Column(name = "freq_km")
	private int freqKm;
	
	@Column(name = "wheel_change_freq")
	private int wheelChangeFreq;
	
	@Column(name = "battary_change_freq")
	private int battaryChangeFreq;
	
	@Column(name = "ac_change_freq")
	private int acChangeFreq;
	
	@Column(name = "current_running_km")
	private int currentRunningKm;
	
	@Column(name = "last_servicing_km")
	private int lastServicingKm;
	
	@Column(name = "next_servicing_km")
	private int nextServicingKm;
	
	@Column(name = "alert_next_servicing_km")
	private int alertNextServicingKm;
	
	@Column(name = "last_amc_date")
	private Date lastAmcDate;
	
	@Column(name = "next_amc_date")
	private Date nextAmcDate;
	
	@Column(name = "alert_amc_date")
	private Date alertAmcDate;

	public int getVehId() {
		return vehId;
	}

	public void setVehId(int vehId) {
		this.vehId = vehId;
	}

	public String getVehNo() {
		return vehNo;
	}

	public void setVehNo(String vehNo) {
		this.vehNo = vehNo;
	}

	public int getMakeId() {
		return makeId;
	}

	public void setMakeId(int makeId) {
		this.makeId = makeId;
	}

	public String getVehEngNo() {
		return vehEngNo;
	}

	public void setVehEngNo(String vehEngNo) {
		this.vehEngNo = vehEngNo;
	}

	public String getVehChesiNo() {
		return vehChesiNo;
	}

	public void setVehChesiNo(String vehChesiNo) {
		this.vehChesiNo = vehChesiNo;
	}

	public String getVehColor() {
		return vehColor;
	}

	public void setVehColor(String vehColor) {
		this.vehColor = vehColor;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getDealerId() {
		return dealerId;
	}

	public void setDealerId(int dealerId) {
		this.dealerId = dealerId;
	}

	public int getFuelType() {
		return fuelType;
	}

	public void setFuelType(int fuelType) {
		this.fuelType = fuelType;
	}

	public int getVehTypeId() {
		return vehTypeId;
	}

	public void setVehTypeId(int vehTypeId) {
		this.vehTypeId = vehTypeId;
	}

	public int getVariantId() {
		return variantId;
	}

	public void setVariantId(int variantId) {
		this.variantId = variantId;
	}

	public float getVehCompAvg() {
		return vehCompAvg;
	}

	public void setVehCompAvg(float vehCompAvg) {
		this.vehCompAvg = vehCompAvg;
	}

	public float getVehStandAvg() {
		return vehStandAvg;
	}

	public void setVehStandAvg(float vehStandAvg) {
		this.vehStandAvg = vehStandAvg;
	}

	public float getVehMiniAvg() {
		return vehMiniAvg;
	}

	public void setVehMiniAvg(float vehMiniAvg) {
		this.vehMiniAvg = vehMiniAvg;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}
	
	

	 

	public int getFreqKm() {
		return freqKm;
	}

	public void setFreqKm(int freqKm) {
		this.freqKm = freqKm;
	}

	public int getWheelChangeFreq() {
		return wheelChangeFreq;
	}

	public void setWheelChangeFreq(int wheelChangeFreq) {
		this.wheelChangeFreq = wheelChangeFreq;
	}

	public int getBattaryChangeFreq() {
		return battaryChangeFreq;
	}

	public void setBattaryChangeFreq(int battaryChangeFreq) {
		this.battaryChangeFreq = battaryChangeFreq;
	}

	public int getAcChangeFreq() {
		return acChangeFreq;
	}

	public void setAcChangeFreq(int acChangeFreq) {
		this.acChangeFreq = acChangeFreq;
	}
	
	

	public int getCurrentRunningKm() {
		return currentRunningKm;
	}

	public void setCurrentRunningKm(int currentRunningKm) {
		this.currentRunningKm = currentRunningKm;
	}

	public int getLastServicingKm() {
		return lastServicingKm;
	}

	public void setLastServicingKm(int lastServicingKm) {
		this.lastServicingKm = lastServicingKm;
	}

	public int getNextServicingKm() {
		return nextServicingKm;
	}

	public void setNextServicingKm(int nextServicingKm) {
		this.nextServicingKm = nextServicingKm;
	}

	public int getAlertNextServicingKm() {
		return alertNextServicingKm;
	}

	public void setAlertNextServicingKm(int alertNextServicingKm) {
		this.alertNextServicingKm = alertNextServicingKm;
	}
	
	
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getLastAmcDate() {
		return lastAmcDate;
	}

	public void setLastAmcDate(Date lastAmcDate) {
		this.lastAmcDate = lastAmcDate;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getNextAmcDate() {
		return nextAmcDate;
	}

	public void setNextAmcDate(Date nextAmcDate) {
		this.nextAmcDate = nextAmcDate;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getAlertAmcDate() {
		return alertAmcDate;
	}

	public void setAlertAmcDate(Date alertAmcDate) {
		this.alertAmcDate = alertAmcDate;
	}

	@Override
	public String toString() {
		return "VehicalMaster [vehId=" + vehId + ", vehNo=" + vehNo + ", makeId=" + makeId + ", vehEngNo=" + vehEngNo
				+ ", vehChesiNo=" + vehChesiNo + ", vehColor=" + vehColor + ", purchaseDate=" + purchaseDate
				+ ", regDate=" + regDate + ", dealerId=" + dealerId + ", fuelType=" + fuelType + ", vehTypeId="
				+ vehTypeId + ", variantId=" + variantId + ", vehCompAvg=" + vehCompAvg + ", vehStandAvg=" + vehStandAvg
				+ ", vehMiniAvg=" + vehMiniAvg + ", delStatus=" + delStatus + ", freqKm=" + freqKm
				+ ", wheelChangeFreq=" + wheelChangeFreq + ", battaryChangeFreq=" + battaryChangeFreq
				+ ", acChangeFreq=" + acChangeFreq + ", currentRunningKm=" + currentRunningKm + ", lastServicingKm="
				+ lastServicingKm + ", nextServicingKm=" + nextServicingKm + ", alertNextServicingKm="
				+ alertNextServicingKm + ", lastAmcDate=" + lastAmcDate + ", nextAmcDate=" + nextAmcDate
				+ ", alertAmcDate=" + alertAmcDate + "]";
	}

	
	
	
}
