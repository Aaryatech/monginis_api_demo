package com.ats.webapi.model.dashboard;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CredNoteReport {
	
	@Id
	Date  crnDate;
	
	float crnGrandTotal;
	float crnTaxableAmt;
	float crnTotalTax;
	
	int isGrn;

	public Date getCrnDate() {
		return crnDate;
	}

	public void setCrnDate(Date crnDate) {
		this.crnDate = crnDate;
	}

	public float getCrnGrandTotal() {
		return crnGrandTotal;
	}

	public void setCrnGrandTotal(float crnGrandTotal) {
		this.crnGrandTotal = crnGrandTotal;
	}

	public float getCrnTaxableAmt() {
		return crnTaxableAmt;
	}

	public void setCrnTaxableAmt(float crnTaxableAmt) {
		this.crnTaxableAmt = crnTaxableAmt;
	}

	public float getCrnTotalTax() {
		return crnTotalTax;
	}

	public void setCrnTotalTax(float crnTotalTax) {
		this.crnTotalTax = crnTotalTax;
	}

	public int getIsGrn() {
		return isGrn;
	}

	public void setIsGrn(int isGrn) {
		this.isGrn = isGrn;
	}

	@Override
	public String toString() {
		return "CredNoteReportFrEnd [crnDate=" + crnDate + ", crnGrandTotal=" + crnGrandTotal + ", crnTaxableAmt="
				+ crnTaxableAmt + ", crnTotalTax=" + crnTotalTax + ", isGrn=" + isGrn + "]";
	}
	

}
