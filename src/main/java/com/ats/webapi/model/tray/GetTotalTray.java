package com.ats.webapi.model.tray;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetTotalTray implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "fr_id")
	private int frId;

	@Column(name = "outtray_big")
	private int outtrayBig;

	@Column(name = "outtray_small")
	private int outtraySmall;

	@Column(name = "outtray_lead")
	private int outtrayLead;

	@Column(name = "intray_big")
	private int intrayBig;

	@Column(name = "intray_small")
	private int intraySmall;

	@Column(name = "intray_lead")
	private int intrayLead;

	@Column(name = "balance_big")
	private int balanceBig;

	@Column(name = "balance_small")
	private int balanceSmall;

	@Column(name = "balance_lead")
	private int balanceLead;

	private String frName;
	
	private String frCode;

	public int getFrId() {
		return frId;
	}

	public void setFrId(int frId) {
		this.frId = frId;
	}

	public int getOuttrayBig() {
		return outtrayBig;
	}

	public void setOuttrayBig(int outtrayBig) {
		this.outtrayBig = outtrayBig;
	}

	public int getOuttraySmall() {
		return outtraySmall;
	}

	public void setOuttraySmall(int outtraySmall) {
		this.outtraySmall = outtraySmall;
	}

	public int getOuttrayLead() {
		return outtrayLead;
	}

	public void setOuttrayLead(int outtrayLead) {
		this.outtrayLead = outtrayLead;
	}

	public int getIntrayBig() {
		return intrayBig;
	}

	public void setIntrayBig(int intrayBig) {
		this.intrayBig = intrayBig;
	}

	public int getIntraySmall() {
		return intraySmall;
	}

	public void setIntraySmall(int intraySmall) {
		this.intraySmall = intraySmall;
	}

	public int getIntrayLead() {
		return intrayLead;
	}

	public void setIntrayLead(int intrayLead) {
		this.intrayLead = intrayLead;
	}

	public int getBalanceBig() {
		return balanceBig;
	}

	public void setBalanceBig(int balanceBig) {
		this.balanceBig = balanceBig;
	}

	public int getBalanceSmall() {
		return balanceSmall;
	}

	public void setBalanceSmall(int balanceSmall) {
		this.balanceSmall = balanceSmall;
	}

	public int getBalanceLead() {
		return balanceLead;
	}

	public void setBalanceLead(int balanceLead) {
		this.balanceLead = balanceLead;
	}

	public String getFrName() {
		return frName;
	}

	public void setFrName(String frName) {
		this.frName = frName;
	}

	public String getFrCode() {
		return frCode;
	}

	public void setFrCode(String frCode) {
		this.frCode = frCode;
	}

	@Override
	public String toString() {
		return "GetTotalTray [frId=" + frId + ", outtrayBig=" + outtrayBig + ", outtraySmall=" + outtraySmall
				+ ", outtrayLead=" + outtrayLead + ", intrayBig=" + intrayBig + ", intraySmall=" + intraySmall
				+ ", intrayLead=" + intrayLead + ", balanceBig=" + balanceBig + ", balanceSmall=" + balanceSmall
				+ ", balanceLead=" + balanceLead + ", frName=" + frName + ", frCode=" + frCode + "]";
	}
	
	
}
