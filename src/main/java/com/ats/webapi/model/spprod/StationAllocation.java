package com.ats.webapi.model.spprod;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="t_prod_station_allocation")
public class StationAllocation implements Serializable{

	@Transient
	private boolean isError;
	
	@Transient
	private String message;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="allocation_id")
	private int allocationId;
	
	@Column(name="station_id")
	private int stationId;
	
	@Column(name="shift_id")
	private int shiftId;
	
	@Column(name="emp_mistry_id")
	private int empMistryId;
	
	@Column(name="emp_helper_id")
	private int empHelperId;
	
	@Column(name="del_status")
	private int delStatus;

	public boolean isError() {
		return isError;
	}

	public void setError(boolean isError) {
		this.isError = isError;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getAllocationId() {
		return allocationId;
	}

	public void setAllocationId(int allocationId) {
		this.allocationId = allocationId;
	}

	public int getStationId() {
		return stationId;
	}

	public void setStationId(int stationId) {
		this.stationId = stationId;
	}

	public int getShiftId() {
		return shiftId;
	}

	public void setShiftId(int shiftId) {
		this.shiftId = shiftId;
	}

	public int getEmpMistryId() {
		return empMistryId;
	}

	public void setEmpMistryId(int empMistryId) {
		this.empMistryId = empMistryId;
	}

	public int getEmpHelperId() {
		return empHelperId;
	}

	public void setEmpHelperId(int empHelperId) {
		this.empHelperId = empHelperId;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "StationAllocation [isError=" + isError + ", message=" + message + ", allocationId=" + allocationId
				+ ", stationId=" + stationId + ", shiftId=" + shiftId + ", empMistryId=" + empMistryId
				+ ", empHelperId=" + empHelperId + ", delStatus=" + delStatus + "]";
	}
	
}
