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
@Table(name="m_shift")
public class Shift implements Serializable{
	
	@Transient
	private boolean isError;
	
	@Transient
	private String message;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="shift_id")
	private int shiftId;
	
	@Column(name="shift_no")
	private int shiftNo;
	
	@Column(name="shift_name")
	private String shiftName;
	
	@Column(name="is_used")
	private int isUsed;
	
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

	public int getShiftId() {
		return shiftId;
	}

	public void setShiftId(int shiftId) {
		this.shiftId = shiftId;
	}

	public int getShiftNo() {
		return shiftNo;
	}

	public void setShiftNo(int shiftNo) {
		this.shiftNo = shiftNo;
	}

	public String getShiftName() {
		return shiftName;
	}

	public void setShiftName(String shiftName) {
		this.shiftName = shiftName;
	}

	public int getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "Shift [isError=" + isError + ", message=" + message + ", shiftId=" + shiftId + ", shiftNo=" + shiftNo
				+ ", shiftName=" + shiftName + ", isUsed=" + isUsed + ", delStatus=" + delStatus + "]";
	}

}
