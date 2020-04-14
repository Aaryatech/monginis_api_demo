package com.ats.webapi.model.logistics;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat; 


@Entity
@Table(name = "m_logis_serv")
public class ServHeader {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "serv_id")
	private int servId; 
	
	@Column(name = "serv_date")
	private Date servDate;
	
	@Column(name = "type_id")
	private int typeId;

	@Column(name = "dealer_id")
	private int dealerId;  

	@Column(name = "serv_type")
	private int servType;
	
	@Column(name = "serv_type2")
	private int servType2;

	@Column(name = "bill_no")
	private String billNo;

	@Column(name = "bill_date")
	private Date billDate;
	
	@Column(name = "veh_id")
	private int vehId; 

	@Column(name = "veh_no")
	private String vehNo;

	@Column(name = "serv_advise_rem")
	private String servAdviseRem;
	
	@Column(name = "serv_done_rem")
	private String servDoneRem;

	@Column(name = "spr_tot")
	private float sprTot;

	@Column(name = "lab_chrge")
	private float labChrge;
	
	@Column(name = "total_disc")
	private float totalDisc;

	@Column(name = "total_extra")
	private float totalExtra;
	
	@Column(name = "disc_on_bill")
	private float discOnBill;
	
	@Column(name = "extra_on_bill")
	private float extraOnBill;
	
	@Column(name = "tax_amt")
	private float taxAmt;
	
	@Column(name = "taxable_amt")
	private float taxableAmt;
	
	@Column(name = "round_off")
	private float roundOff;

	@Column(name = "total")
	private float total;
	
	@Column(name = "serv_done_km")
	private int servDoneKm;
	
	@Column(name = "next_due_km")
	private int nextDueKm;
	
	@Column(name = "is_approved")
	private int isApproved;
	
	@Column(name = "del_status")
	private int delStatus;
	
	@Column(name = "bill_file")
	private String billFile;
	
	@Transient
	List<ServDetail> servDetail;

	public int getServId() {
		return servId;
	}

	public void setServId(int servId) {
		this.servId = servId;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getServDate() {
		return servDate;
	}

	public void setServDate(Date servDate) {
		this.servDate = servDate;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public int getDealerId() {
		return dealerId;
	}

	public void setDealerId(int dealerId) {
		this.dealerId = dealerId;
	}

	public int getServType() {
		return servType;
	}

	public void setServType(int servType) {
		this.servType = servType;
	}

	public int getServType2() {
		return servType2;
	}

	public void setServType2(int servType2) {
		this.servType2 = servType2;
	}

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

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

	public String getServAdviseRem() {
		return servAdviseRem;
	}

	public void setServAdviseRem(String servAdviseRem) {
		this.servAdviseRem = servAdviseRem;
	}

	public String getServDoneRem() {
		return servDoneRem;
	}

	public void setServDoneRem(String servDoneRem) {
		this.servDoneRem = servDoneRem;
	}

	public float getSprTot() {
		return sprTot;
	}

	public void setSprTot(float sprTot) {
		this.sprTot = sprTot;
	}

	public float getLabChrge() {
		return labChrge;
	}

	public void setLabChrge(float labChrge) {
		this.labChrge = labChrge;
	}

	public float getTotalDisc() {
		return totalDisc;
	}

	public void setTotalDisc(float totalDisc) {
		this.totalDisc = totalDisc;
	}

	public float getTotalExtra() {
		return totalExtra;
	}

	public void setTotalExtra(float totalExtra) {
		this.totalExtra = totalExtra;
	}

	public float getDiscOnBill() {
		return discOnBill;
	}

	public void setDiscOnBill(float discOnBill) {
		this.discOnBill = discOnBill;
	}

	public float getExtraOnBill() {
		return extraOnBill;
	}

	public void setExtraOnBill(float extraOnBill) {
		this.extraOnBill = extraOnBill;
	}

	public float getTaxAmt() {
		return taxAmt;
	}

	public void setTaxAmt(float taxAmt) {
		this.taxAmt = taxAmt;
	}

	public float getTaxableAmt() {
		return taxableAmt;
	}

	public void setTaxableAmt(float taxableAmt) {
		this.taxableAmt = taxableAmt;
	}

	public float getRoundOff() {
		return roundOff;
	}

	public void setRoundOff(float roundOff) {
		this.roundOff = roundOff;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public int getServDoneKm() {
		return servDoneKm;
	}

	public void setServDoneKm(int servDoneKm) {
		this.servDoneKm = servDoneKm;
	}

	public int getNextDueKm() {
		return nextDueKm;
	}

	public void setNextDueKm(int nextDueKm) {
		this.nextDueKm = nextDueKm;
	}

	public int getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(int isApproved) {
		this.isApproved = isApproved;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public List<ServDetail> getServDetail() {
		return servDetail;
	}

	public void setServDetail(List<ServDetail> servDetail) {
		this.servDetail = servDetail;
	}
	

	public String getBillFile() {
		return billFile;
	}

	public void setBillFile(String billFile) {
		this.billFile = billFile;
	}

	 

	@Override
	public String toString() {
		return "ServHeader [servId=" + servId + ", servDate=" + servDate + ", typeId=" + typeId + ", dealerId="
				+ dealerId + ", servType=" + servType + ", servType2=" + servType2 + ", billNo=" + billNo
				+ ", billDate=" + billDate + ", vehId=" + vehId + ", vehNo=" + vehNo + ", servAdviseRem="
				+ servAdviseRem + ", servDoneRem=" + servDoneRem + ", sprTot=" + sprTot + ", labChrge=" + labChrge
				+ ", totalDisc=" + totalDisc + ", totalExtra=" + totalExtra + ", discOnBill=" + discOnBill
				+ ", extraOnBill=" + extraOnBill + ", taxAmt=" + taxAmt + ", taxableAmt=" + taxableAmt + ", roundOff="
				+ roundOff + ", total=" + total + ", servDoneKm=" + servDoneKm + ", nextDueKm=" + nextDueKm
				+ ", isApproved=" + isApproved + ", delStatus=" + delStatus + ", billFile=" + billFile + ", servDetail="
				+ servDetail + "]";
	}
	
	

}
