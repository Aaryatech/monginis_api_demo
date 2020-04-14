package com.ats.webapi.model.tray;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="t_tray_mgt_detail")
public class TrayMgtDetail implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="tran_detail_id")
	private int tranDetailId;
	
	@Column(name="tran_id")
	private int tranId;
	
	@Column(name="fr_id")
	private int frId;
	
	@Column(name="fr_name")
	private String frName;
	
	@Column(name="outtray_big")
	private int outtrayBig;
	
	@Column(name="outtray_small")
	private int outtraySmall;
	
	@Column(name="outtray_lead")
	private int outtrayLead;
	
	@Column(name="outtray_extra")
	private int outtrayExtra;
	
	@Column(name="outtray_date")
	private Date outtrayDate;
	
	@Column(name="intray_big")
	private int intrayBig;
	
	@Column(name="intray_small")
	private int intraySmall;
	
	@Column(name="intray_lead")
	private int intrayLead;
	
	@Column(name="intray_extra")
	private int intrayExtra;
	
	@Column(name="intray_date")
	private Date intrayDate;

	@Column(name="intray_big1")
	private int intrayBig1;
	
	@Column(name="intray_small1")
	private int intraySmall1;
	
	@Column(name="intray_lead1")
	private int intrayLead1;
	
	@Column(name="intray_extra1")
	private int intrayExtra1;
	
	
	@Column(name="intray_date1")
	private Date intrayDate1;
	
	@Column(name="intray_big2")
	private int intrayBig2;
	
	@Column(name="intray_small2")
	private int intraySmall2;
	
	@Column(name="intray_lead2")
	private int intrayLead2;
	
	@Column(name="intray_extra2")
	private int intrayExtra2;

	@Column(name="intray_date2")
	private Date intrayDate2;
		
	@Column(name="balance_big")
	private int balanceBig;
	
	@Column(name="balance_small")
	private int balanceSmall;
	
	@Column(name="balance_lead")
	private int balanceLead;
	
	@Column(name="balance_extra")
	private int balanceExtra;
	
	@Column(name="price_big")
	private float priceBig;
	
	@Column(name="price_small")
	private float priceSmall;
	
	@Column(name="price_lead")
	private float priceLead;
	
	@Column(name="price_extra")
	private float priceExtra;
	
	@Column(name="qty_big")
	private int qtyBig;
	
	@Column(name="qty_small")
	private int qtySmall;
	
	@Column(name="qty_lead")
	private int qtyLead;
	
	@Column(name="qty_extra")
	private int qtyExtra;
	
	@Column(name="gst_per")
	private float gstPer;
	
	@Column(name="gst_rs")
	private float gstRs;
	
	@Column(name="taxable_amt")
	private float taxableAmt;
	
	@Column(name="tax_amt")
	private float taxAmt;
	
	@Column(name="grand_total")
	private float grandTotal;
	
	@Column(name="tray_status")
	private int trayStatus;
	
	@Column(name="deposit_is_used")
	private int depositIsUsed;

	@Column(name="is_same_day")
	private int isSameDay;
	
	@Column(name="del_status")
	private int delStatus;

	
	public String getFrName() {
		return frName;
	}

	public void setFrName(String frName) {
		this.frName = frName;
	}

	public int getQtyBig() {
		return qtyBig;
	}

	public void setQtyBig(int qtyBig) {
		this.qtyBig = qtyBig;
	}

	public int getQtySmall() {
		return qtySmall;
	}

	public void setQtySmall(int qtySmall) {
		this.qtySmall = qtySmall;
	}

	public int getQtyLead() {
		return qtyLead;
	}

	public void setQtyLead(int qtyLead) {
		this.qtyLead = qtyLead;
	}

	public int getQtyExtra() {
		return qtyExtra;
	}

	public void setQtyExtra(int qtyExtra) {
		this.qtyExtra = qtyExtra;
	}

	public float getGstPer() {
		return gstPer;
	}

	public void setGstPer(float gstPer) {
		this.gstPer = gstPer;
	}

	public float getGstRs() {
		return gstRs;
	}

	public void setGstRs(float gstRs) {
		this.gstRs = gstRs;
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

	public int getIsSameDay() {
		return isSameDay;
	}

	public void setIsSameDay(int isSameDay) {
		this.isSameDay = isSameDay;
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

	public int getOuttrayExtra() {
		return outtrayExtra;
	}

	public void setOuttrayExtra(int outtrayExtra) {
		this.outtrayExtra = outtrayExtra;
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

	public int getIntrayExtra() {
		return intrayExtra;
	}

	public void setIntrayExtra(int intrayExtra) {
		this.intrayExtra = intrayExtra;
	}

	public int getIntrayBig1() {
		return intrayBig1;
	}

	public void setIntrayBig1(int intrayBig1) {
		this.intrayBig1 = intrayBig1;
	}

	public int getIntraySmall1() {
		return intraySmall1;
	}

	public void setIntraySmall1(int intraySmall1) {
		this.intraySmall1 = intraySmall1;
	}

	public int getIntrayLead1() {
		return intrayLead1;
	}

	public void setIntrayLead1(int intrayLead1) {
		this.intrayLead1 = intrayLead1;
	}

	public int getIntrayExtra1() {
		return intrayExtra1;
	}

	public void setIntrayExtra1(int intrayExtra1) {
		this.intrayExtra1 = intrayExtra1;
	}

	public int getIntrayBig2() {
		return intrayBig2;
	}

	public void setIntrayBig2(int intrayBig2) {
		this.intrayBig2 = intrayBig2;
	}

	public int getIntraySmall2() {
		return intraySmall2;
	}

	public void setIntraySmall2(int intraySmall2) {
		this.intraySmall2 = intraySmall2;
	}

	public int getIntrayLead2() {
		return intrayLead2;
	}

	public void setIntrayLead2(int intrayLead2) {
		this.intrayLead2 = intrayLead2;
	}

	public int getIntrayExtra2() {
		return intrayExtra2;
	}

	public void setIntrayExtra2(int intrayExtra2) {
		this.intrayExtra2 = intrayExtra2;
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

	public int getBalanceExtra() {
		return balanceExtra;
	}

	public void setBalanceExtra(int balanceExtra) {
		this.balanceExtra = balanceExtra;
	}

	public float getPriceBig() {
		return priceBig;
	}

	public void setPriceBig(float priceBig) {
		this.priceBig = priceBig;
	}

	public float getPriceSmall() {
		return priceSmall;
	}

	public void setPriceSmall(float priceSmall) {
		this.priceSmall = priceSmall;
	}

	public float getPriceLead() {
		return priceLead;
	}

	public void setPriceLead(float priceLead) {
		this.priceLead = priceLead;
	}

	public float getPriceExtra() {
		return priceExtra;
	}

	public void setPriceExtra(float priceExtra) {
		this.priceExtra = priceExtra;
	}

	public float getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(float grandTotal) {
		this.grandTotal = grandTotal;
	}

	public int getTrayStatus() {
		return trayStatus;
	}

	public void setTrayStatus(int trayStatus) {
		this.trayStatus = trayStatus;
	}

	public int getDepositIsUsed() {
		return depositIsUsed;
	}

	public void setDepositIsUsed(int depositIsUsed) {
		this.depositIsUsed = depositIsUsed;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getOuttrayDate() {
		return outtrayDate;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public void setOuttrayDate(Date outtrayDate) {
		this.outtrayDate = outtrayDate;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getIntrayDate() {
		return intrayDate;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public void setIntrayDate(Date intrayDate) {
		this.intrayDate = intrayDate;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getIntrayDate1() {
		return intrayDate1;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public void setIntrayDate1(Date intrayDate1) {
		this.intrayDate1 = intrayDate1;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getIntrayDate2() {
		return intrayDate2;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public void setIntrayDate2(Date intrayDate2) {
		this.intrayDate2 = intrayDate2;
	}

	@Override
	public String toString() {
		return "TrayMgtDetail [tranDetailId=" + tranDetailId + ", tranId=" + tranId + ", frId=" + frId + ", outtrayBig="
				+ outtrayBig + ", outtraySmall=" + outtraySmall + ", outtrayLead=" + outtrayLead + ", outtrayExtra="
				+ outtrayExtra + ", outtrayDate=" + outtrayDate + ", intrayBig=" + intrayBig + ", intraySmall="
				+ intraySmall + ", intrayLead=" + intrayLead + ", intrayExtra=" + intrayExtra + ", intrayDate="
				+ intrayDate + ", intrayBig1=" + intrayBig1 + ", intraySmall1=" + intraySmall1 + ", intrayLead1="
				+ intrayLead1 + ", intrayExtra1=" + intrayExtra1 + ", intrayDate1=" + intrayDate1 + ", intrayBig2="
				+ intrayBig2 + ", intraySmall2=" + intraySmall2 + ", intrayLead2=" + intrayLead2 + ", intrayExtra2="
				+ intrayExtra2 + ", intrayDate2=" + intrayDate2 + ", balanceBig=" + balanceBig + ", balanceSmall="
				+ balanceSmall + ", balanceLead=" + balanceLead + ", balanceExtra=" + balanceExtra + ", priceBig="
				+ priceBig + ", priceSmall=" + priceSmall + ", priceLead=" + priceLead + ", priceExtra=" + priceExtra
				+ ", qtyBig=" + qtyBig + ", qtySmall=" + qtySmall + ", qtyLead=" + qtyLead + ", qtyExtra=" + qtyExtra
				+ ", gstPer=" + gstPer + ", gstRs=" + gstRs + ", taxableAmt=" + taxableAmt + ", taxAmt=" + taxAmt
				+ ", grandTotal=" + grandTotal + ", trayStatus=" + trayStatus + ", depositIsUsed=" + depositIsUsed
				+ ", isSameDay=" + isSameDay + ", delStatus=" + delStatus + "]";
	}
    
    
}
