package com.ats.webapi.model.grngvn;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.ats.webapi.model.GrnGvn;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="t_grn_gvn_header")
public class GrnGvnHeader {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="grn_gvn_header_id")
	private int grnGvnHeaderId;

	@Column(name="fr_id")
	private int frId;
	
	@Column(name="grngvn_srno")
	private String grngvnSrno;
	
	@Column(name="grngvn_date")
	private Date grngvnDate;
	
	@Column(name="is_grn")
	private int isGrn;
	
	@Column(name="taxable_amt")
	private float taxableAmt;
	
	@Column(name="tax_amt")
	private float taxAmt;
	
	@Column(name="total_amt")
	private float totalAmt;
	
	@Column(name="grngvn_status")
	private int grngvnStatus;
	
	@Column(name="approved_amt")
	private float apporvedAmt;
	
	@Column(name="is_credit_note")
	private int isCreditNote;
	
	@Column(name="credit_note_id")
	private String creditNoteId;//changed datatype for , separated crn no
	
	@Column(name="approved_datetime")
	private String approvedDatetime;
	
	//new Field added on 26 FEB
	@Column(name = "apr_taxable_amt")
	float aprTaxableAmt;
	
	@Column(name = "apr_total_tax")
	float aprTotalTax;
	
	@Column(name = "apr_sgst_rs")
	float aprSgstRs;
	
	@Column(name = "apr_cgst_rs")
	float aprCgstRs;
	
	@Column(name = "apr_cess_rs")
	float aprCessRs;//new1
	
	@Column(name = "apr_igst_rs")
	float aprIgstRs;
	
	@Column(name = "apr_grand_total")
	float aprGrandTotal;
	
	@Column(name = "apr_r_off")
	float aprROff;
	
	@Transient
	List<GrnGvn> grnGvn;
	


	public int getGrnGvnHeaderId() {
		return grnGvnHeaderId;
	}


	public void setGrnGvnHeaderId(int grnGvnHeaderId) {
		this.grnGvnHeaderId = grnGvnHeaderId;
	}


	public int getFrId() {
		return frId;
	}



	public float getAprCessRs() {
		return aprCessRs;
	}


	public void setAprCessRs(float aprCessRs) {
		this.aprCessRs = aprCessRs;
	}


	public void setFrId(int frId) {
		this.frId = frId;
	}


	public String getGrngvnSrno() {
		return grngvnSrno;
	}


	public void setGrngvnSrno(String grngvnSrno) {
		this.grngvnSrno = grngvnSrno;
	}


	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getGrngvnDate() {
		return grngvnDate;
	}

	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public void setGrngvnDate(Date grngvnDate) {
		this.grngvnDate = grngvnDate;
	}


	public int getIsGrn() {
		return isGrn;
	}


	public void setIsGrn(int isGrn) {
		this.isGrn = isGrn;
	}


	public float getTaxableAmt() {
		return taxableAmt;
	}


	public void setTaxableAmt(float taxableAmt) {
		this.taxableAmt = taxableAmt;
	}


	public float getTaxAmt() {
		return taxAmt;
	}



	public void setTaxAmt(float taxAmt) {
		this.taxAmt = taxAmt;
	}


	public float getTotalAmt() {
		return totalAmt;
	}


	public void setTotalAmt(float totalAmt) {
		this.totalAmt = totalAmt;
	}



	public int getGrngvnStatus() {
		return grngvnStatus;
	}


	public void setGrngvnStatus(int grngvnStatus) {
		this.grngvnStatus = grngvnStatus;
	}



	public float getApporvedAmt() {
		return apporvedAmt;
	}


	public void setApporvedAmt(float apporvedAmt) {
		this.apporvedAmt = apporvedAmt;
	}


	public int getIsCreditNote() {
		return isCreditNote;
	}


	public void setIsCreditNote(int isCreditNote) {
		this.isCreditNote = isCreditNote;
	}


	public String getCreditNoteId() {
		return creditNoteId;
	}


	public void setCreditNoteId(String creditNoteId) {
		this.creditNoteId = creditNoteId;
	}


	public String getApprovedDatetime() {
		return approvedDatetime;
	}


	public void setApprovedDatetime(String approvedDatetime) {
		this.approvedDatetime = approvedDatetime;
	}


	public List<GrnGvn> getGrnGvn() {
		return grnGvn;
	}


	public void setGrnGvn(List<GrnGvn> grnGvn) {
		this.grnGvn = grnGvn;
	}


	public float getAprTaxableAmt() {
		return aprTaxableAmt;
	}


	public void setAprTaxableAmt(float aprTaxableAmt) {
		this.aprTaxableAmt = aprTaxableAmt;
	}


	public float getAprTotalTax() {
		return aprTotalTax;
	}


	public void setAprTotalTax(float aprTotalTax) {
		this.aprTotalTax = aprTotalTax;
	}


	public float getAprSgstRs() {
		return aprSgstRs;
	}


	public void setAprSgstRs(float aprSgstRs) {
		this.aprSgstRs = aprSgstRs;
	}


	public float getAprCgstRs() {
		return aprCgstRs;
	}


	public void setAprCgstRs(float aprCgstRs) {
		this.aprCgstRs = aprCgstRs;
	}


	public float getAprIgstRs() {
		return aprIgstRs;
	}


	public void setAprIgstRs(float aprIgstRs) {
		this.aprIgstRs = aprIgstRs;
	}


	public float getAprGrandTotal() {
		return aprGrandTotal;
	}


	public void setAprGrandTotal(float aprGrandTotal) {
		this.aprGrandTotal = aprGrandTotal;
	}


	public float getAprROff() {
		return aprROff;
	}


	public void setAprROff(float aprROff) {
		this.aprROff = aprROff;
	}


	@Override
	public String toString() {
		return "GrnGvnHeader [grnGvnHeaderId=" + grnGvnHeaderId + ", frId=" + frId + ", grngvnSrno=" + grngvnSrno
				+ ", grngvnDate=" + grngvnDate + ", isGrn=" + isGrn + ", taxableAmt=" + taxableAmt + ", taxAmt="
				+ taxAmt + ", totalAmt=" + totalAmt + ", grngvnStatus=" + grngvnStatus + ", apporvedAmt=" + apporvedAmt
				+ ", isCreditNote=" + isCreditNote + ", creditNoteId=" + creditNoteId + ", approvedDatetime="
				+ approvedDatetime + ", aprTaxableAmt=" + aprTaxableAmt + ", aprTotalTax=" + aprTotalTax
				+ ", aprSgstRs=" + aprSgstRs + ", aprCgstRs=" + aprCgstRs + ", aprCessRs=" + aprCessRs + ", aprIgstRs="
				+ aprIgstRs + ", aprGrandTotal=" + aprGrandTotal + ", aprROff=" + aprROff + ", grnGvn=" + grnGvn + "]";
	}
	
 }
