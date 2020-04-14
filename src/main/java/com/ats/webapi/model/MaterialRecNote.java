package com.ats.webapi.model;

import java.io.Serializable;
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
@Table(name="t_material_receipt_note")
public class MaterialRecNote implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="mrn_id")
	private int mrnId;
	
	@Column(name="mrn_no")
	private String mrnNo;
	
	@Column(name="gate_entry_date")
	private Date gateEntryDate;
	
	@Column(name="gate_entry_time")
	private String gateEntryTime;
	
	@Column(name="transport_id")
	private int transportId;
	
	@Column(name="vehicle_no")
	private String vehicleNo;
	
	@Column(name="lr_no")
	private String lrNo;
	
	@Column(name="lr_date")
	private Date lrDate;
	
	@Column(name="supplier_id")
	private int supplierId;
	
	@Column(name="no_of_item")
	private int noOfItem;
	
	@Column(name="photo1")
	private String photo1;
	
	@Column(name="photo2")
	private String photo2;
	
	@Column(name="gate_user_id")
	private int gateUserId;
	
	@Column(name="gate_remark")
	private String gateRemark;
	
	//--------------------------------
	@Column(name="mrn_store_date")
	private Date mrnStoreDate;
	
	@Column(name="mrn_type")
	private int mrnType;
	
	@Column(name="against_po")
	private int apainstPo;
	
	@Column(name="po_id")
	private int poId;
	
	@Column(name="po_no")
	private String poNo;
	
	@Column(name="po_date")
	private Date poDate;
	
	@Column(name="userid_stores")
	private int useridStores;
	
	@Column(name="stores_remark")
	private String storesRemark;
	
	@Column(name="approved_userid")
	private int approvedUserId;
	
	@Column(name="approval_remark")
	private String approvalRemark;
	//-------------------------------
	@Column(name="inv_book_date")
	private Date invBookDate;
	
	@Column(name="invoice_number")
	private String invoiceNumber;
	
	@Column(name="inv_date")
	private Date invDate;
	
	@Column(name="basic_value")
	private float basicValue;
	
	@Column(name="disc_per")
	private float discPer;
	
	@Column(name="disc_amt")
	private float discAmt;
	
	@Column(name="disc_amt2")
	private float discAmt2;
	
	@Column(name="freight_amt")
	private float freightAmt;
	
	@Column(name="insurance_amt")
	private float insuranceAmt;
	
	@Column(name="cgst")
	private float cgst;
	
	@Column(name="sgst")
	private float sgst;
	
	@Column(name="igst")
	private float igst;
	
	@Column(name="cess")
	private float cess;
	
	@Column(name="round_off")
	private float roundOff;
	
	@Column(name="bill_amount")
	private float billAmount;
	
	@Column(name="userid_acc")
	private int useridAcc;
	
	@Column(name="acc_remark")
	private String accRemark;
	
	//--------------------------
	@Column(name="status")
	private int status;
	
	@Column(name="is_tally_sync")
	private int isTallySync;

	@Column(name="del_status")
	private int delStatus;
	
	@Column(name="other1")
	private float other1;
	
	@Column(name="other2")
	private float other2;
	
	@Column(name="other3")
	private float other3;
	
	@Column(name="other4")
	private float other4;
	 
	private int grpId;
	
	@Transient
	List<MaterialRecNoteDetails> materialRecNoteDetails; 
	
	 
    
	public int getGrpId() {
		return grpId;
	}

	public void setGrpId(int grpId) {
		this.grpId = grpId;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public List<MaterialRecNoteDetails> getMaterialRecNoteDetails() {
		return materialRecNoteDetails;
	}

	public void setMaterialRecNoteDetails(List<MaterialRecNoteDetails> materialRecNoteDetails) {
		this.materialRecNoteDetails = materialRecNoteDetails;
	}

	public int getMrnId() {
		return mrnId;
	}

	public void setMrnId(int mrnId) {
		this.mrnId = mrnId;
	}

	public String getMrnNo() {
		return mrnNo;
	}

	public void setMrnNo(String mrnNo) {
		this.mrnNo = mrnNo;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getGateEntryDate() {
		return gateEntryDate;
	}
    //@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public void setGateEntryDate(Date gateEntryDate) {
		this.gateEntryDate = gateEntryDate;
	}

	public String getGateEntryTime() {
		return gateEntryTime;
	}

	public void setGateEntryTime(String gateEntryTime) {
		this.gateEntryTime = gateEntryTime;
	}

	public int getTransportId() {
		return transportId;
	}

	public void setTransportId(int transportId) {
		this.transportId = transportId;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getLrNo() {
		return lrNo;
	}

	public void setLrNo(String lrNo) {
		this.lrNo = lrNo;
	}
	
	//@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getLrDate() {
		return lrDate;
	}
	
	//@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public void setLrDate(Date lrDate) {
		this.lrDate = lrDate;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}


	public int getNoOfItem() {
		return noOfItem;
	}

	public void setNoOfItem(int noOfItem) {
		this.noOfItem = noOfItem;
	}

	
	public int getApprovedUserId() {
		return approvedUserId;
	}

	public void setApprovedUserId(int approvedUserId) {
		this.approvedUserId = approvedUserId;
	}

	public String getApprovalRemark() {
		return approvalRemark;
	}

	public void setApprovalRemark(String approvalRemark) {
		this.approvalRemark = approvalRemark;
	}

	public String getPhoto1() {
		return photo1;
	}

	public void setPhoto1(String photo1) {
		this.photo1 = photo1;
	}

	public String getPhoto2() {
		return photo2;
	}

	public void setPhoto2(String photo2) {
		this.photo2 = photo2;
	}

	public int getGateUserId() {
		return gateUserId;
	}

	public void setGateUserId(int gateUserId) {
		this.gateUserId = gateUserId;
	}

	public String getGateRemark() {
		return gateRemark;
	}

	public void setGateRemark(String gateRemark) {
		this.gateRemark = gateRemark;
	}

	public Date getMrnStoreDate() {
		return mrnStoreDate;
	}

	public void setMrnStoreDate(Date mrnStoreDate) {
		this.mrnStoreDate = mrnStoreDate;
	}

	public int getMrnType() {
		return mrnType;
	}

	public void setMrnType(int mrnType) {
		this.mrnType = mrnType;
	}

	public int getApainstPo() {
		return apainstPo;
	}

	public void setApainstPo(int apainstPo) {
		this.apainstPo = apainstPo;
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
	
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getPoDate() {
		return poDate;
	}
	
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public void setPoDate(Date poDate) {
		this.poDate = poDate;
	}

	public int getUseridStores() {
		return useridStores;
	}

	public void setUseridStores(int useridStores) {
		this.useridStores = useridStores;
	}

	public String getStoresRemark() {
		return storesRemark;
	}

	public void setStoresRemark(String storesRemark) {
		this.storesRemark = storesRemark;
	}
	
	//@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getInvBookDate() {
		return invBookDate;
	}
	
	//@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public void setInvBookDate(Date invBookDate) {
		this.invBookDate = invBookDate;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	//@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getInvDate() {
		return invDate;
	}
	
	//@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public void setInvDate(Date invDate) {
		this.invDate = invDate;
	}

	public float getBasicValue() {
		return basicValue;
	}

	public void setBasicValue(float basicValue) {
		this.basicValue = basicValue;
	}

	public float getDiscPer() {
		return discPer;
	}

	public void setDiscPer(float discPer) {
		this.discPer = discPer;
	}

	public float getDiscAmt() {
		return discAmt;
	}

	public void setDiscAmt(float discAmt) {
		this.discAmt = discAmt;
	}

	public float getDiscAmt2() {
		return discAmt2;
	}

	public void setDiscAmt2(float discAmt2) {
		this.discAmt2 = discAmt2;
	}

	public float getFreightAmt() {
		return freightAmt;
	}

	public void setFreightAmt(float freightAmt) {
		this.freightAmt = freightAmt;
	}

	public float getInsuranceAmt() {
		return insuranceAmt;
	}

	public void setInsuranceAmt(float insuranceAmt) {
		this.insuranceAmt = insuranceAmt;
	}

	public float getCgst() {
		return cgst;
	}

	public void setCgst(float cgst) {
		this.cgst = cgst;
	}

	public float getSgst() {
		return sgst;
	}

	public void setSgst(float sgst) {
		this.sgst = sgst;
	}

	public float getIgst() {
		return igst;
	}

	public void setIgst(float igst) {
		this.igst = igst;
	}

	public float getCess() {
		return cess;
	}

	public void setCess(float cess) {
		this.cess = cess;
	}

	public float getRoundOff() {
		return roundOff;
	}

	public void setRoundOff(float roundOff) {
		this.roundOff = roundOff;
	}

	public float getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(float billAmount) {
		this.billAmount = billAmount;
	}

	public int getUseridAcc() {
		return useridAcc;
	}

	public void setUseridAcc(int useridAcc) {
		this.useridAcc = useridAcc;
	}

	public String getAccRemark() {
		return accRemark;
	}

	public void setAccRemark(String accRemark) {
		this.accRemark = accRemark;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getIsTallySync() {
		return isTallySync;
	}

	public void setIsTallySync(int isTallySync) {
		this.isTallySync = isTallySync;
	}
	
	

	public float getOther1() {
		return other1;
	}

	public void setOther1(float other1) {
		this.other1 = other1;
	}

	public float getOther2() {
		return other2;
	}

	public void setOther2(float other2) {
		this.other2 = other2;
	}

	public float getOther3() {
		return other3;
	}

	public void setOther3(float other3) {
		this.other3 = other3;
	}

	public float getOther4() {
		return other4;
	}

	public void setOther4(float other4) {
		this.other4 = other4;
	}

	@Override
	public String toString() {
		return "MaterialRecNote [mrnId=" + mrnId + ", mrnNo=" + mrnNo + ", gateEntryDate=" + gateEntryDate
				+ ", gateEntryTime=" + gateEntryTime + ", transportId=" + transportId + ", vehicleNo=" + vehicleNo
				+ ", lrNo=" + lrNo + ", lrDate=" + lrDate + ", supplierId=" + supplierId + ", noOfItem=" + noOfItem
				+ ", photo1=" + photo1 + ", photo2=" + photo2 + ", gateUserId=" + gateUserId + ", gateRemark="
				+ gateRemark + ", mrnStoreDate=" + mrnStoreDate + ", mrnType=" + mrnType + ", apainstPo=" + apainstPo
				+ ", poId=" + poId + ", poNo=" + poNo + ", poDate=" + poDate + ", useridStores=" + useridStores
				+ ", storesRemark=" + storesRemark + ", approvedUserId=" + approvedUserId + ", approvalRemark="
				+ approvalRemark + ", invBookDate=" + invBookDate + ", invoiceNumber=" + invoiceNumber + ", invDate="
				+ invDate + ", basicValue=" + basicValue + ", discPer=" + discPer + ", discAmt=" + discAmt
				+ ", discAmt2=" + discAmt2 + ", freightAmt=" + freightAmt + ", insuranceAmt=" + insuranceAmt + ", cgst="
				+ cgst + ", sgst=" + sgst + ", igst=" + igst + ", cess=" + cess + ", roundOff=" + roundOff
				+ ", billAmount=" + billAmount + ", useridAcc=" + useridAcc + ", accRemark=" + accRemark + ", status="
				+ status + ", isTallySync=" + isTallySync + ", delStatus=" + delStatus + ", other1=" + other1
				+ ", other2=" + other2 + ", other3=" + other3 + ", other4=" + other4 + ", materialRecNoteDetails="
				+ materialRecNoteDetails + "]";
	}


	
	
	
}
