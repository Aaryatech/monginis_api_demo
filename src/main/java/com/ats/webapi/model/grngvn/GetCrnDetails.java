package com.ats.webapi.model.grngvn;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class GetCrnDetails {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="crnd_id")
	private int crndId;
	
	
	@Column(name="crn_id")
	private int crnId;
	
	
	@Column(name="item_id")
	private int itemId;
	
	
	@Column(name="grn_gvn_id")
	private int grnGvnId;
	
	
	@Column(name="is_grn")
	private int isGrn;
	
	
	@Column(name="grn_type")
	private int grnType;
	
	@Column(name="grn_gvn_date")
	private Date grnGvnDate;
	
	@Column(name="grn_gvn_qty")
	private int grnGvnQty;
	
	@Column(name="taxable_amt")
	private float taxableAmt;
	
	@Column(name="total_tax")
	private float totalTax;
	
	@Column(name="grn_gvn_amt")
	private float grnGvnAmt;
	
	@Column(name="cgst_per")
	private float cgstPer;
	
	@Column(name="sgst_per")
	private float sgstPer;
	
	
	@Column(name="igst_per")
	private float igstPer;
	
	@Column(name="cgst_rs")
	private float cgstRs;
	
	@Column(name="sgst_rs")
	private float sgstRs;
	
	@Column(name="igst_rs")
	private float igstRs;
	
	@Column(name="cess_rs")
	private float cessRs;
	
	@Column(name="del_status")
	private int delStatus;
	
	@Column(name="bill_no")
	private int billNo;
	
	@Column(name="bill_date")
	private Date billDate;
	
	
	
		@Column(name = "cat_id")
		private int catId;
		
		
		@Column(name = "base_rate")
		private float baseRate;
		
		@Column(name = "cess_per")
		private float cessPer;
		
		@Column(name = "ref_invoice_no")
		private String  refInvoiceNo;
		
		
		@Column(name = "grngvn_srno")
		private String grngvnSrno;
		
		@Column(name = "grn_gvn_header_id")
		private int grnGvnHeaderId;
		
		
		
		@Column(name="item_name")
		private String itemName;
		
		
		@Column(name="hsn_code")
		private String itemHsncd;
		
		@Column(name="item_uom")
		private String itemUom;
		
		
		
		
		

		public int getCrndId() {
			return crndId;
		}


		public void setCrndId(int crndId) {
			this.crndId = crndId;
		}


		public int getCrnId() {
			return crnId;
		}


		public void setCrnId(int crnId) {
			this.crnId = crnId;
		}


		public int getItemId() {
			return itemId;
		}


		public void setItemId(int itemId) {
			this.itemId = itemId;
		}


		public int getGrnGvnId() {
			return grnGvnId;
		}


		public void setGrnGvnId(int grnGvnId) {
			this.grnGvnId = grnGvnId;
		}


		public int getIsGrn() {
			return isGrn;
		}


		public void setIsGrn(int isGrn) {
			this.isGrn = isGrn;
		}


		public int getGrnType() {
			return grnType;
		}


		public void setGrnType(int grnType) {
			this.grnType = grnType;
		}

		@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")

		public Date getGrnGvnDate() {
			return grnGvnDate;
		}


		public void setGrnGvnDate(Date grnGvnDate) {
			this.grnGvnDate = grnGvnDate;
		}


		public int getGrnGvnQty() {
			return grnGvnQty;
		}


		public void setGrnGvnQty(int grnGvnQty) {
			this.grnGvnQty = grnGvnQty;
		}


		public float getTaxableAmt() {
			return taxableAmt;
		}


		public void setTaxableAmt(float taxableAmt) {
			this.taxableAmt = taxableAmt;
		}


		public float getTotalTax() {
			return totalTax;
		}


		public void setTotalTax(float totalTax) {
			this.totalTax = totalTax;
		}


		public float getGrnGvnAmt() {
			return grnGvnAmt;
		}


		public void setGrnGvnAmt(float grnGvnAmt) {
			this.grnGvnAmt = grnGvnAmt;
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


		public float getCgstRs() {
			return cgstRs;
		}


		public void setCgstRs(float cgstRs) {
			this.cgstRs = cgstRs;
		}


		public float getSgstRs() {
			return sgstRs;
		}


		public void setSgstRs(float sgstRs) {
			this.sgstRs = sgstRs;
		}


		public float getIgstRs() {
			return igstRs;
		}


		public void setIgstRs(float igstRs) {
			this.igstRs = igstRs;
		}


		public float getCessRs() {
			return cessRs;
		}


		public void setCessRs(float cessRs) {
			this.cessRs = cessRs;
		}


		public int getDelStatus() {
			return delStatus;
		}


		public void setDelStatus(int delStatus) {
			this.delStatus = delStatus;
		}


		public int getBillNo() {
			return billNo;
		}


		public void setBillNo(int billNo) {
			this.billNo = billNo;
		}


		public Date getBillDate() {
			return billDate;
		}


		public void setBillDate(Date billDate) {
			this.billDate = billDate;
		}


		public int getCatId() {
			return catId;
		}


		public void setCatId(int catId) {
			this.catId = catId;
		}


		public float getBaseRate() {
			return baseRate;
		}


		public void setBaseRate(float baseRate) {
			this.baseRate = baseRate;
		}


		public float getCessPer() {
			return cessPer;
		}


		public void setCessPer(float cessPer) {
			this.cessPer = cessPer;
		}


		public String getRefInvoiceNo() {
			return refInvoiceNo;
		}


		public void setRefInvoiceNo(String refInvoiceNo) {
			this.refInvoiceNo = refInvoiceNo;
		}


		public String getGrngvnSrno() {
			return grngvnSrno;
		}


		public void setGrngvnSrno(String grngvnSrno) {
			this.grngvnSrno = grngvnSrno;
		}


		public int getGrnGvnHeaderId() {
			return grnGvnHeaderId;
		}


		public void setGrnGvnHeaderId(int grnGvnHeaderId) {
			this.grnGvnHeaderId = grnGvnHeaderId;
		}


		public String getItemName() {
			return itemName;
		}


		public void setItemName(String itemName) {
			this.itemName = itemName;
		}


		public String getItemHsncd() {
			return itemHsncd;
		}


		public void setItemHsncd(String itemHsncd) {
			this.itemHsncd = itemHsncd;
		}


		public String getItemUom() {
			return itemUom;
		}


		public void setItemUom(String itemUom) {
			this.itemUom = itemUom;
		}


		@Override
		public String toString() {
			return "GetCrnDetails [crndId=" + crndId + ", crnId=" + crnId + ", itemId=" + itemId + ", grnGvnId="
					+ grnGvnId + ", isGrn=" + isGrn + ", grnType=" + grnType + ", grnGvnDate=" + grnGvnDate
					+ ", grnGvnQty=" + grnGvnQty + ", taxableAmt=" + taxableAmt + ", totalTax=" + totalTax
					+ ", grnGvnAmt=" + grnGvnAmt + ", cgstPer=" + cgstPer + ", sgstPer=" + sgstPer + ", igstPer="
					+ igstPer + ", cgstRs=" + cgstRs + ", sgstRs=" + sgstRs + ", igstRs=" + igstRs + ", cessRs="
					+ cessRs + ", delStatus=" + delStatus + ", billNo=" + billNo + ", billDate=" + billDate + ", catId="
					+ catId + ", baseRate=" + baseRate + ", cessPer=" + cessPer + ", refInvoiceNo=" + refInvoiceNo
					+ ", grngvnSrno=" + grngvnSrno + ", grnGvnHeaderId=" + grnGvnHeaderId + ", itemName=" + itemName
					+ ", itemHsncd=" + itemHsncd + ", itemUom=" + itemUom + "]";
		}

}