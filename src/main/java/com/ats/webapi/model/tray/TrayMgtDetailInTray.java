package com.ats.webapi.model.tray;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_tray_mgmt_detail_intray")
public class TrayMgtDetailInTray {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "intray_id")
	private int intrayId;

	@Column(name = "tran_detail_id")
	private int tranDetailId;

	@Column(name = "tran_id")
	private int tranId;

	@Column(name = "fr_id")
	private int frId;

	@Column(name = "intray_date")
	private String intrayDate;

	@Column(name = "ex_int1")
	private int exInt1;
	@Column(name = "ex_int2")
	private int exInt2;

	@Column(name = "ex_var1")
	private String exVar1;

	@Column(name = "ex_var2")
	private String exVar2;

	@Column(name = "del_status")
	private int delStatus;

	@Column(name = "intray_big")
	private int intrayBig;

	@Column(name = "intray_lead")
	private int intrayLead;

	// tran_intray_id

	@Column(name = "tran_intray_id")
	private int tranIntrayId;

	@Column(name = "intray_small")
	private int intraySmall;

	public int getIntrayId() {
		return intrayId;
	}

	public void setIntrayId(int intrayId) {
		this.intrayId = intrayId;
	}

	public int getTranDetailId() {
		return tranDetailId;
	}

	public void setTranDetailId(int tranDetailId) {
		this.tranDetailId = tranDetailId;
	}

	public int getTranId() {
		return tranId;
	}

	public void setTranId(int tranId) {
		this.tranId = tranId;
	}

	public int getFrId() {
		return frId;
	}

	public void setFrId(int frId) {
		this.frId = frId;
	}

	public String getIntrayDate() {
		return intrayDate;
	}

	public void setIntrayDate(String intrayDate) {
		this.intrayDate = intrayDate;
	}

	public int getExInt1() {
		return exInt1;
	}

	public void setExInt1(int exInt1) {
		this.exInt1 = exInt1;
	}

	public int getExInt2() {
		return exInt2;
	}

	public void setExInt2(int exInt2) {
		this.exInt2 = exInt2;
	}

	public String getExVar1() {
		return exVar1;
	}

	public void setExVar1(String exVar1) {
		this.exVar1 = exVar1;
	}

	public String getExVar2() {
		return exVar2;
	}

	public void setExVar2(String exVar2) {
		this.exVar2 = exVar2;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getIntrayBig() {
		return intrayBig;
	}

	public void setIntrayBig(int intrayBig) {
		this.intrayBig = intrayBig;
	}

	public int getIntrayLead() {
		return intrayLead;
	}

	public void setIntrayLead(int intrayLead) {
		this.intrayLead = intrayLead;
	}

	public int getIntraySmall() {
		return intraySmall;
	}

	public void setIntraySmall(int intraySmall) {
		this.intraySmall = intraySmall;
	}

	public int getTranIntrayId() {
		return tranIntrayId;
	}

	public void setTranIntrayId(int tranIntrayId) {
		this.tranIntrayId = tranIntrayId;
	}

	@Override
	public String toString() {
		return "TrayMgtDetailInTray [intrayId=" + intrayId + ", tranDetailId=" + tranDetailId + ", tranId=" + tranId
				+ ", frId=" + frId + ", intrayDate=" + intrayDate + ", exInt1=" + exInt1 + ", exInt2=" + exInt2
				+ ", exVar1=" + exVar1 + ", exVar2=" + exVar2 + ", delStatus=" + delStatus + ", intrayBig=" + intrayBig
				+ ", intrayLead=" + intrayLead + ", tranIntrayId=" + tranIntrayId + ", intraySmall=" + intraySmall
				+ "]";
	}

}
