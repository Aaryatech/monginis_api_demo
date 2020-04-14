package com.ats.webapi.model.purchaseorder;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

 

@Entity
@Table(name = "t_purchase_order_header")
public class PurchaseOrderHeader {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="po_id")
	private int poId;
	
	@Column(name="po_no")
	private int poNo;
	
	@Column(name="po_date")
	private String poDate;
	
	@Column(name="po_type")
	private int poType;
	
	@Column(name="supp_id")
	private int suppId;
	
	@Column(name="quotation_ref_no")
	private int quotationRefNo;
	
	@Column(name="quotation_ref_date")
	private String quotationRefDate;

	@Column(name="kind_attn")
	private String kindAttn;

	@Column(name="pay_id")
	private int payId;

	@Column(name="taxation_rem")
	private int taxationRem;

	@Column(name="freight_rem")
	private int freidhtRem;

	@Column(name="insu_rem")
	private int insuRem;
	

	@Column(name="delv_at_rem")
	private String delvAtRem;

	@Column(name="delv_date_rem")
	private String delvDateRem;

	@Column(name="tran_id")
	private int tranId;

	@Column(name="sp_rem")
	private String spRem;

	@Column(name="validity")
	private int validity;

	@Column(name="po_total_value")
	private float poTotalValue;

	@Column(name="po_status")
	private int poStatus;

	@Column(name="user_id")
	private int userId;

	@Column(name="approved_id")
	private int approvedId;

	@Column(name="del_status")
	private int delStatusId;
	
	@Transient
	List<PurchaseOrderDetail> purchaseOrderDetail;

	public int getPoId() {
		return poId;
	}

	public void setPoId(int poId) {
		this.poId = poId;
	}

	public int getPoNo() {
		return poNo;
	}

	public void setPoNo(int poNo) {
		this.poNo = poNo;
	}

	public String getPoDate() {
		return poDate;
	}

	public void setPoDate(String poDate) {
		this.poDate = poDate;
	}

	public int getPoType() {
		return poType;
	}

	public void setPoType(int poType) {
		this.poType = poType;
	}

	public int getSuppId() {
		return suppId;
	}

	public void setSuppId(int suppId) {
		this.suppId = suppId;
	}

	public int getQuotationRefNo() {
		return quotationRefNo;
	}

	public void setQuotationRefNo(int quotationRefNo) {
		this.quotationRefNo = quotationRefNo;
	}

	public String getQuotationRefDate() {
		return quotationRefDate;
	}

	public void setQuotationRefDate(String quotationRefDate) {
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

	public int getTaxationRem() {
		return taxationRem;
	}

	public void setTaxationRem(int taxationRem) {
		this.taxationRem = taxationRem;
	}

	public int getFreidhtRem() {
		return freidhtRem;
	}

	public void setFreidhtRem(int freidhtRem) {
		this.freidhtRem = freidhtRem;
	}

	public int getInsuRem() {
		return insuRem;
	}

	public void setInsuRem(int insuRem) {
		this.insuRem = insuRem;
	}

	public String getDelvAtRem() {
		return delvAtRem;
	}

	public void setDelvAtRem(String delvAtRem) {
		this.delvAtRem = delvAtRem;
	}

	public String getDelvDateRem() {
		return delvDateRem;
	}

	public void setDelvDateRem(String delvDateRem) {
		this.delvDateRem = delvDateRem;
	}

	public int getTranId() {
		return tranId;
	}

	public void setTranId(int tranId) {
		this.tranId = tranId;
	}

	public String getSpRem() {
		return spRem;
	}

	public void setSpRem(String spRem) {
		this.spRem = spRem;
	}

	public int getValidity() {
		return validity;
	}

	public void setValidity(int validity) {
		this.validity = validity;
	}

	public float getPoTotalValue() {
		return poTotalValue;
	}

	public void setPoTotalValue(float poTotalValue) {
		this.poTotalValue = poTotalValue;
	}

	public int getPoStatus() {
		return poStatus;
	}

	public void setPoStatus(int poStatus) {
		this.poStatus = poStatus;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getApprovedId() {
		return approvedId;
	}

	public void setApprovedId(int approvedId) {
		this.approvedId = approvedId;
	}

	public int getDelStatusId() {
		return delStatusId;
	}

	public void setDelStatusId(int delStatusId) {
		this.delStatusId = delStatusId;
	}

	public List<PurchaseOrderDetail> getPurchaseOrderDetail() {
		return purchaseOrderDetail;
	}

	public void setPurchaseOrderDetail(List<PurchaseOrderDetail> purchaseOrderDetail) {
		this.purchaseOrderDetail = purchaseOrderDetail;
	}

	@Override
	public String toString() {
		return "PurchaseOrderHeader [poId=" + poId + ", poNo=" + poNo + ", poDate=" + poDate + ", poType=" + poType
				+ ", suppId=" + suppId + ", quotationRefNo=" + quotationRefNo + ", quotationRefDate=" + quotationRefDate
				+ ", kindAttn=" + kindAttn + ", payId=" + payId + ", taxationRem=" + taxationRem + ", freidhtRem="
				+ freidhtRem + ", insuRem=" + insuRem + ", delvAtRem=" + delvAtRem + ", delvDateRem=" + delvDateRem
				+ ", tranId=" + tranId + ", spRem=" + spRem + ", validity=" + validity + ", poTotalValue="
				+ poTotalValue + ", poStatus=" + poStatus + ", userId=" + userId + ", approvedId=" + approvedId
				+ ", delStatusId=" + delStatusId + ", purchaseOrderDetail=" + purchaseOrderDetail + "]";
	}

	 
	
	
}
