package com.ats.webapi.model.grngvn;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import com.fasterxml.jackson.annotation.JsonFormat;


@Entity

public class GetGrnGvnForCreditNote implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "grn_gvn_id")
	int grnGvnId;

	@Column(name = "grn_gvn_date")
	Date grnGvnDate;
	

	@Column(name = "bill_no")
	private int billNo;

	@Column(name = "fr_id")
	private int frId;

	@Column(name = "item_id")
	private int itemId;
	
	@Column(name = "item_rate")
	private float itemRate;
	
	@Column(name = "item_mrp")
	private float itemMrp;

	@Column(name = "apr_qty_acc")
	private int aprQtyAcc;

	@Column(name = "apr_grand_total")
	private float aprGrandTotal;

	@Column(name = "grn_type")
	private int grnType;
	
	@Column(name = "is_grn")
	private int isGrn;
	
	@Column(name = "is_grn_edit")
	private int isGrnEdit;
	
	

	@Column(name = "fr_grn_gvn_remark")
	private String frGrnGvnRemark;

	

	@Column(name = "grn_gvn_status")
	private int grnGvnStatus;

	

	@Column(name = "approved_datetime_acc")
	private String grnApprovedDateTimeAcc;


	@Column(name = "del_status")
	private int delStatus;
	
	@Column(name = "grn_gvn_qty_auto")
	private int grnGvnQtyAuto;
	
	
	
//newly added 04/11/17
	
	@Column(name = "is_tally_sync")
	private int isTallySync;
	
	
	@Column(name = "base_rate")
	private float baseRate;
	
	@Column(name = "sgst_per")
	private float sgstPer;
	
	@Column(name = "cgst_per")
	private float cgstPer;
	
	@Column(name = "cess_per")//new1
	private float cessPer;//new1
	
	@Column(name = "igst_per")
	private float igstPer;
	
	@Column(name = "apr_taxable_amt")
	private float aprTaxableAmt;
	
	@Column(name = "apr_total_tax")
	private float aprTotalTax;
	
	
	
	@Column(name = "apr_r_off")
	private float aprROff;
	
	
	@Column(name = "item_name")
	private String itemName;

	@Column(name = "fr_name")
	private String frName;

	
	
	@Column(name = "is_credit_note")
	private int isCreditNote;
	
	
	
	@Column(name = "menu_id")
	private int menuId;
	

	@Column(name = "cat_id")
	private int catId;
	

	@Column(name = "invoice_no")
	private String invoiceNo;
	

	@Column(name = "ref_invoice_date")
	private Date refInvoiceDate;
	
	
	//new column 23 FEB
	@Column(name = "grngvn_srno")
	private String grngvnSrno;
	
	//new column 23 FEB
	@Column(name = "grn_gvn_header_id")
	private int grnGvnHeaderId;
	//new column 4june19
	private String hsnCode;

	
	public String getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}

	public int getGrnGvnId() {
		return grnGvnId;
	}

	public void setGrnGvnId(int grnGvnId) {
		this.grnGvnId = grnGvnId;
	}

	public Date getGrnGvnDate() {
		return grnGvnDate;
	}

	public void setGrnGvnDate(Date grnGvnDate) {
		this.grnGvnDate = grnGvnDate;
	}

	public int getBillNo() {
		return billNo;
	}

	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}

	public int getFrId() {
		return frId;
	}

	public void setFrId(int frId) {
		this.frId = frId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public float getItemRate() {
		return itemRate;
	}

	public void setItemRate(float itemRate) {
		this.itemRate = itemRate;
	}

	public float getItemMrp() {
		return itemMrp;
	}

	public void setItemMrp(float itemMrp) {
		this.itemMrp = itemMrp;
	}

	public int getAprQtyAcc() {
		return aprQtyAcc;
	}

	public void setAprQtyAcc(int aprQtyAcc) {
		this.aprQtyAcc = aprQtyAcc;
	}

	public float getAprGrandTotal() {
		return aprGrandTotal;
	}

	public void setAprGrandTotal(float aprGrandTotal) {
		this.aprGrandTotal = aprGrandTotal;
	}

	public int getGrnType() {
		return grnType;
	}

	public void setGrnType(int grnType) {
		this.grnType = grnType;
	}

	public int getIsGrn() {
		return isGrn;
	}

	public void setIsGrn(int isGrn) {
		this.isGrn = isGrn;
	}

	public int getIsGrnEdit() {
		return isGrnEdit;
	}

	public void setIsGrnEdit(int isGrnEdit) {
		this.isGrnEdit = isGrnEdit;
	}

	public String getFrGrnGvnRemark() {
		return frGrnGvnRemark;
	}

	public void setFrGrnGvnRemark(String frGrnGvnRemark) {
		this.frGrnGvnRemark = frGrnGvnRemark;
	}

	public int getGrnGvnStatus() {
		return grnGvnStatus;
	}

	public void setGrnGvnStatus(int grnGvnStatus) {
		this.grnGvnStatus = grnGvnStatus;
	}

	public String getGrnApprovedDateTimeAcc() {
		return grnApprovedDateTimeAcc;
	}

	public void setGrnApprovedDateTimeAcc(String grnApprovedDateTimeAcc) {
		this.grnApprovedDateTimeAcc = grnApprovedDateTimeAcc;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getGrnGvnQtyAuto() {
		return grnGvnQtyAuto;
	}

	public void setGrnGvnQtyAuto(int grnGvnQtyAuto) {
		this.grnGvnQtyAuto = grnGvnQtyAuto;
	}

	public int getIsTallySync() {
		return isTallySync;
	}

	public void setIsTallySync(int isTallySync) {
		this.isTallySync = isTallySync;
	}

	public float getBaseRate() {
		return baseRate;
	}

	public void setBaseRate(float baseRate) {
		this.baseRate = baseRate;
	}

	public float getSgstPer() {
		return sgstPer;
	}

	public void setSgstPer(float sgstPer) {
		this.sgstPer = sgstPer;
	}

	public float getCgstPer() {
		return cgstPer;
	}

	public void setCgstPer(float cgstPer) {
		this.cgstPer = cgstPer;
	}

	public float getIgstPer() {
		return igstPer;
	}

	public void setIgstPer(float igstPer) {
		this.igstPer = igstPer;
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

	public float getAprROff() {
		return aprROff;
	}

	public void setAprROff(float aprROff) {
		this.aprROff = aprROff;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getFrName() {
		return frName;
	}

	public void setFrName(String frName) {
		this.frName = frName;
	}

	public int getIsCreditNote() {
		return isCreditNote;
	}

	public void setIsCreditNote(int isCreditNote) {
		this.isCreditNote = isCreditNote;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public Date getRefInvoiceDate() {
		return refInvoiceDate;
	}

	public void setRefInvoiceDate(Date refInvoiceDate) {
		this.refInvoiceDate = refInvoiceDate;
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
    
	public float getCessPer() {
		return cessPer;
	}

	public void setCessPer(float cessPer) {
		this.cessPer = cessPer;
	}

	@Override
	public String toString() {
		return "GetGrnGvnForCreditNote [grnGvnId=" + grnGvnId + ", grnGvnDate=" + grnGvnDate + ", billNo=" + billNo
				+ ", frId=" + frId + ", itemId=" + itemId + ", itemRate=" + itemRate + ", itemMrp=" + itemMrp
				+ ", aprQtyAcc=" + aprQtyAcc + ", aprGrandTotal=" + aprGrandTotal + ", grnType=" + grnType + ", isGrn="
				+ isGrn + ", isGrnEdit=" + isGrnEdit + ", frGrnGvnRemark=" + frGrnGvnRemark + ", grnGvnStatus="
				+ grnGvnStatus + ", grnApprovedDateTimeAcc=" + grnApprovedDateTimeAcc + ", delStatus=" + delStatus
				+ ", grnGvnQtyAuto=" + grnGvnQtyAuto + ", isTallySync=" + isTallySync + ", baseRate=" + baseRate
				+ ", sgstPer=" + sgstPer + ", cgstPer=" + cgstPer + ", cessPer=" + cessPer + ", igstPer=" + igstPer
				+ ", aprTaxableAmt=" + aprTaxableAmt + ", aprTotalTax=" + aprTotalTax + ", aprROff=" + aprROff
				+ ", itemName=" + itemName + ", frName=" + frName + ", isCreditNote=" + isCreditNote + ", menuId="
				+ menuId + ", catId=" + catId + ", invoiceNo=" + invoiceNo + ", refInvoiceDate=" + refInvoiceDate
				+ ", grngvnSrno=" + grngvnSrno + ", grnGvnHeaderId=" + grnGvnHeaderId + ", hsnCode=" + hsnCode + "]";
	}

	
    
}
