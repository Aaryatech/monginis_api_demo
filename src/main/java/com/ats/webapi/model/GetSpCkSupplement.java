package com.ats.webapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class GetSpCkSupplement implements Serializable{

	@Transient
	private boolean error;
	
	@Transient
	private String message;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="sp_id")
	private int spId;
	
	@Column(name="sp_name")
	private String spName;
	
	@Column(name="sp_hsncd")
	private String spHsncd;
	
	@Column(name="sp_uom")
	private String spUom;
	
	@Column(name="sp_cess")
	private float spCess;
	
	@Column(name="cut_section")
	private int cutSection;
	
	@Column(name="is_tally_sync")
	private int isTallySync;
	
	@Column(name="del_status")
	private int delStatus;

	@Column(name="uom_id")
	private int uomId;
	
	@Column(name="sp_code")
	private String spCode;
	
	
	public int getUomId() {
		return uomId;
	}

	public void setUomId(int uomId) {
		this.uomId = uomId;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSpId() {
		return spId;
	}

	public void setSpId(int spId) {
		this.spId = spId;
	}

	public String getSpName() {
		return spName;
	}

	public void setSpName(String spName) {
		this.spName = spName;
	}

	public String getSpHsncd() {
		return spHsncd;
	}

	public void setSpHsncd(String spHsncd) {
		this.spHsncd = spHsncd;
	}

	public String getSpUom() {
		return spUom;
	}

	public void setSpUom(String spUom) {
		this.spUom = spUom;
	}

	public float getSpCess() {
		return spCess;
	}

	public void setSpCess(float spCess) {
		this.spCess = spCess;
	}

	public int getCutSection() {
		return cutSection;
	}

	public void setCutSection(int cutSection) {
		this.cutSection = cutSection;
	}

	public int getIsTallySync() {
		return isTallySync;
	}

	public void setIsTallySync(int isTallySync) {
		this.isTallySync = isTallySync;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public String getSpCode() {
		return spCode;
	}

	public void setSpCode(String spCode) {
		this.spCode = spCode;
	}

	@Override
	public String toString() {
		return "GetSpCkSupplement [error=" + error + ", message=" + message + ", id=" + id + ", spId=" + spId
				+ ", spName=" + spName + ", spHsncd=" + spHsncd + ", spUom=" + spUom + ", spCess=" + spCess
				+ ", cutSection=" + cutSection + ", isTallySync=" + isTallySync + ", delStatus=" + delStatus
				+ ", uomId=" + uomId + ", spCode=" + spCode + "]";
	}

	
}
