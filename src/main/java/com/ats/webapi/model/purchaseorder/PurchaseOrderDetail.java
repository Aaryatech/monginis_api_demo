package com.ats.webapi.model.purchaseorder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_purchase_order_detail")
public class PurchaseOrderDetail {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="po_detail_id")
	private int poDetailId;
	
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
	
	@Column(name="rm_id")
	private int rmId;
	
	@Column(name="rm_name")
	private String rmName;
	
	@Column(name="rm_uom_id")
	private int rmUomId;
	
	@Column(name="rm_specification")
	private String specification;
	
	@Column(name="rm_remark")
	private String rmRemark;
	
	@Column(name="po_qty")
	private int poQty;
	
	@Column(name="po_rate")
	private float poRate;
	
	@Column(name="disc_per")
	private float discPer;
	
	@Column(name="gst_per")
	private float gstPer;
	
	@Column(name="cgst_per")
	private float cgstPer;
	
	
	@Column(name="sgst_per")
	private float sgstPer;
	
	@Column(name="igst_per")
	private float igstPer;
	
	@Column(name="cess_per")
	private float cessPer;
	
	@Column(name="po_taxable")
	private float poTaxable;
	
	@Column(name="po_total")
	private float poTotal;
	
	@Column(name="sch_days")
	private int schDays;
	
	@Column(name="del_status")
	private int delStatus;

	public int getPoDetailId() {
		return poDetailId;
	}

	public void setPoDetailId(int poDetailId) {
		this.poDetailId = poDetailId;
	}

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

	public int getRmId() {
		return rmId;
	}

	public void setRmId(int rmId) {
		this.rmId = rmId;
	}

	public String getRmName() {
		return rmName;
	}

	public void setRmName(String rmName) {
		this.rmName = rmName;
	}

	public int getRmUomId() {
		return rmUomId;
	}

	public void setRmUomId(int rmUomId) {
		this.rmUomId = rmUomId;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getRmRemark() {
		return rmRemark;
	}

	public void setRmRemark(String rmRemark) {
		this.rmRemark = rmRemark;
	}

	public int getPoQty() {
		return poQty;
	}

	public void setPoQty(int poQty) {
		this.poQty = poQty;
	}

	public float getPoRate() {
		return poRate;
	}

	public void setPoRate(float poRate) {
		this.poRate = poRate;
	}

	public float getDiscPer() {
		return discPer;
	}

	public void setDiscPer(float discPer) {
		this.discPer = discPer;
	}

	public float getGstPer() {
		return gstPer;
	}

	public void setGstPer(float gstPer) {
		this.gstPer = gstPer;
	}

	public float getCgstPer() {
		return cgstPer;
	}

	public void setCgstPer(float cgstPer) {
		this.cgstPer = cgstPer;
	}

	public float getSgstPer() {
		return sgstPer;
	}

	public void setSgstPer(float sgstPer) {
		this.sgstPer = sgstPer;
	}

	public float getIgstPer() {
		return igstPer;
	}

	public void setIgstPer(float igstPer) {
		this.igstPer = igstPer;
	}

	public float getCessPer() {
		return cessPer;
	}

	public void setCessPer(float cessPer) {
		this.cessPer = cessPer;
	}

	public float getPoTaxable() {
		return poTaxable;
	}

	public void setPoTaxable(float poTaxable) {
		this.poTaxable = poTaxable;
	}

	public float getPoTotal() {
		return poTotal;
	}

	public void setPoTotal(float poTotal) {
		this.poTotal = poTotal;
	}

	public int getSchDays() {
		return schDays;
	}

	public void setSchDays(int schDays) {
		this.schDays = schDays;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "PurchaseOrderDetail [poDetailId=" + poDetailId + ", poId=" + poId + ", poNo=" + poNo + ", poDate="
				+ poDate + ", poType=" + poType + ", suppId=" + suppId + ", rmId=" + rmId + ", rmName=" + rmName
				+ ", rmUomId=" + rmUomId + ", specification=" + specification + ", rmRemark=" + rmRemark + ", poQty="
				+ poQty + ", poRate=" + poRate + ", discPer=" + discPer + ", gstPer=" + gstPer + ", cgstPer=" + cgstPer
				+ ", sgstPer=" + sgstPer + ", igstPer=" + igstPer + ", cessPer=" + cessPer + ", poTaxable=" + poTaxable
				+ ", poTotal=" + poTotal + ", schDays=" + schDays + ", delStatus=" + delStatus + "]";
	}
	
	
	
}
