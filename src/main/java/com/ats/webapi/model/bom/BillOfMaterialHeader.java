package com.ats.webapi.model.bom;

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
@Table(name = "t_req_bom")
public class BillOfMaterialHeader {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="req_id")
	private int reqId;

	@Column(name="production_id")
	private int productionId;
	
	@Column(name="production_date")
	private Date productionDate;

	@Column(name="is_production")
	private int isProduction;

	@Column(name="from_dept_id")
	private int fromDeptId;
	
	@Column(name="from_dept_name")
	private String fromDeptName;

	@Column(name="to_dept_id")
	private int toDeptId;
	
	@Column(name="to_dept_name")
	private String toDeptName;

	@Column(name="sender_userid")
	private int senderUserid;
	
	@Column(name="req_date")
	private Date reqDate;

	@Column(name="approved_user_id")
	private int approvedUserId;
	
	@Column(name="approved_date")
	private Date approvedDate;

	@Column(name="status")
	private int status;
	
	@Column(name="ex_bool1")
	private int exBool1;

	@Column(name="del_status")
	private int delStatus;
	
	@Column(name="ex_int1")
	private int exInt1;

	@Column(name="ex_int2")
	private int exInt2;
	
	@Column(name="ex_varchar1")
	private String exVarchar1;

	@Column(name="ex_varchar2")
	private String exVarchar2;

	@Transient
	List<BillOfMaterialDetailed> billOfMaterialDetailed;
	//new Fields
	
	@Column(name="is_plan")
	private int isPlan;
	
	@Column(name="is_manual")
	private int isManual;
	
	@Column(name="rej_user_id")
	private int rejUserId;
	@Column(name="rej_date")
	private Date rejDate;
	@Column(name="rej_approve_user_id")
	private int rejApproveUserId;
	@Column(name="rej_approve_date")
	private Date rejApproveDate;
	

	

	public int getReqId() {
		return reqId;
	}

	public void setReqId(int reqId) {
		this.reqId = reqId;
	}

	public int getProductionId() {
		return productionId;
	}

	public void setProductionId(int productionId) {
		this.productionId = productionId;
	}

	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
	}

	public int getIsProduction() {
		return isProduction;
	}

	public void setIsProduction(int isProduction) {
		this.isProduction = isProduction;
	}

	public int getFromDeptId() {
		return fromDeptId;
	}

	public void setFromDeptId(int fromDeptId) {
		this.fromDeptId = fromDeptId;
	}

	public String getFromDeptName() {
		return fromDeptName;
	}

	public void setFromDeptName(String fromDeptName) {
		this.fromDeptName = fromDeptName;
	}

	public int getToDeptId() {
		return toDeptId;
	}

	public void setToDeptId(int toDeptId) {
		this.toDeptId = toDeptId;
	}

	public String getToDeptName() {
		return toDeptName;
	}

	public void setToDeptName(String toDeptName) {
		this.toDeptName = toDeptName;
	}

	public int getSenderUserid() {
		return senderUserid;
	}

	public void setSenderUserid(int senderUserid) {
		this.senderUserid = senderUserid;
	}

	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getReqDate() {
		return reqDate;
	}

	public void setReqDate(Date reqDate) {
		this.reqDate = reqDate;
	}

	public int getApprovedUserId() {
		return approvedUserId;
	}

	public void setApprovedUserId(int approvedUserId) {
		this.approvedUserId = approvedUserId;
	}

	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getExBool1() {
		return exBool1;
	}

	public void setExBool1(int exBool1) {
		this.exBool1 = exBool1;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getExInt1() {
		return exInt1;
	}

	public void setExInt1(int exInt1) {
		this.exInt1 = exInt1;
	}

	public int getExInt2() {
		return exInt2;
	}

	public void setExInt2(int exInt2) {
		this.exInt2 = exInt2;
	}

	public String getExVarchar1() {
		return exVarchar1;
	}

	public void setExVarchar1(String exVarchar1) {
		this.exVarchar1 = exVarchar1;
	}

	public String getExVarchar2() {
		return exVarchar2;
	}

	public void setExVarchar2(String exVarchar2) {
		this.exVarchar2 = exVarchar2;
	}

	public List<BillOfMaterialDetailed> getBillOfMaterialDetailed() {
		return billOfMaterialDetailed;
	}

	public void setBillOfMaterialDetailed(List<BillOfMaterialDetailed> billOfMaterialDetailed) {
		this.billOfMaterialDetailed = billOfMaterialDetailed;
	}

	public int getIsPlan() {
		return isPlan;
	}

	public void setIsPlan(int isPlan) {
		this.isPlan = isPlan;
	}

	public int getIsManual() {
		return isManual;
	}

	public void setIsManual(int isManual) {
		this.isManual = isManual;
	}

	public int getRejUserId() {
		return rejUserId;
	}

	public void setRejUserId(int rejUserId) {
		this.rejUserId = rejUserId;
	}

	public Date getRejDate() {
		return rejDate;
	}

	public void setRejDate(Date rejDate) {
		this.rejDate = rejDate;
	}

	public int getRejApproveUserId() {
		return rejApproveUserId;
	}

	public void setRejApproveUserId(int rejApproveUserId) {
		this.rejApproveUserId = rejApproveUserId;
	}

	public Date getRejApproveDate() {
		return rejApproveDate;
	}

	public void setRejApproveDate(Date rejApproveDate) {
		this.rejApproveDate = rejApproveDate;
	}

}
