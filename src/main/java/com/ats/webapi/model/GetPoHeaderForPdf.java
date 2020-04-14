package com.ats.webapi.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.ats.webapi.model.purchaseorder.PurchaseOrderDetail;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetPoHeaderForPdf {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="po_id")
	private int poId;
	
	@Column(name="po_no")
	private String poNo;

	@Column(name="po_date")
	private Date poDate;
	
	@Column(name="po_type")
	private int poType;
	 
	@Column(name="supp_name")
	private String suppName;
	
	@Column(name="supp_addr")
	private String suppAddr;
	
	@Column(name="supp_state")
	private String suppState;
	
	@Column(name="supp_gstin")
	private String suppGstin;
	
	@Column(name="tran_name")
	private String tranName;
	
	@Column(name="quotation_ref_no")
	private int quotationRefNo;
	
	@Column(name="quotation_ref_date")
	private Date quotationRefDate;
	
	@Column(name="kind_attn")
	private String kindAttn;
	
	@Column(name="pay_id")
	private int payId; 
	
	@Column(name="delv_at_rem")
	private String delvAtRem;
	
	@Column(name="delv_date_rem")
	private Date delvDateRem;
	
	@Column(name="sp_rem")
	private String spRem;
	
	@Column(name="po_total_value")
	private float poTotalValue;
	
	@Transient
	List<GetPoDetailedForPdf> purchaseOrderDetail;
	
	
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getPoDate() {
		return poDate;
	}

	public void setPoDate(Date poDate) {
		this.poDate = poDate;
	}

	public String getTranName() {
		return tranName;
	}

	public void setTranName(String tranName) {
		this.tranName = tranName;
	}

	public int getPoId() {
		return poId;
	}

	public void setPoId(int poId) {
		this.poId = poId;
	}

	public String getPoNo() {
		return poNo;
	}

	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}

	public int getPoType() {
		return poType;
	}

	public void setPoType(int poType) {
		this.poType = poType;
	}

	public String getSuppName() {
		return suppName;
	}

	public void setSuppName(String suppName) {
		this.suppName = suppName;
	}

	public String getSuppAddr() {
		return suppAddr;
	}

	public void setSuppAddr(String suppAddr) {
		this.suppAddr = suppAddr;
	}

	public String getSuppState() {
		return suppState;
	}

	public void setSuppState(String suppState) {
		this.suppState = suppState;
	}

	public String getSuppGstin() {
		return suppGstin;
	}

	public void setSuppGstin(String suppGstin) {
		this.suppGstin = suppGstin;
	}

	public int getQuotationRefNo() {
		return quotationRefNo;
	}

	public void setQuotationRefNo(int quotationRefNo) {
		this.quotationRefNo = quotationRefNo;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getQuotationRefDate() {
		return quotationRefDate;
	}

	public void setQuotationRefDate(Date quotationRefDate) {
		this.quotationRefDate = quotationRefDate;
	}

	public String getKindAttn() {
		return kindAttn;
	}

	public void setKindAttn(String kindAttn) {
		this.kindAttn = kindAttn;
	}

	public int getPayId() {
		return payId;
	}

	public void setPayId(int payId) {
		this.payId = payId;
	}

	public String getDelvAtRem() {
		return delvAtRem;
	}

	public void setDelvAtRem(String delvAtRem) {
		this.delvAtRem = delvAtRem;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getDelvDateRem() {
		return delvDateRem;
	}

	public void setDelvDateRem(Date delvDateRem) {
		this.delvDateRem = delvDateRem;
	}

	public String getSpRem() {
		return spRem;
	}

	public void setSpRem(String spRem) {
		this.spRem = spRem;
	}

	public float getPoTotalValue() {
		return poTotalValue;
	}

	public void setPoTotalValue(float poTotalValue) {
		this.poTotalValue = poTotalValue;
	}

	public List<GetPoDetailedForPdf> getPurchaseOrderDetail() {
		return purchaseOrderDetail;
	}

	public void setPurchaseOrderDetail(List<GetPoDetailedForPdf> purchaseOrderDetaillist) {
		this.purchaseOrderDetail = purchaseOrderDetaillist;
	}

	@Override
	public String toString() {
		return "GetPoDetailedForPdf [poId=" + poId + ", poNo=" + poNo + ", poType=" + poType + ", suppName=" + suppName
				+ ", suppAddr=" + suppAddr + ", suppState=" + suppState + ", suppGstin=" + suppGstin
				+ ", quotationRefNo=" + quotationRefNo + ", quotationRefDate=" + quotationRefDate + ", kindAttn="
				+ kindAttn + ", payId=" + payId + ", delvAtRem=" + delvAtRem + ", delvDateRem=" + delvDateRem
				+ ", spRem=" + spRem + ", poTotalValue=" + poTotalValue + ", purchaseOrderDetail=" + purchaseOrderDetail
				+ "]";
	}
	
	
	
	
	 

}
