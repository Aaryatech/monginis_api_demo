package com.ats.webapi.model; 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetPoDetailedForPdf {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="po_detail_id")
	private int poDetailId;
	
	@Column(name="rm_id")
	private int rmId;
	
	@Column(name="rm_name")
	private String rmName;
	
	@Column(name="po_qty")
	private String poQty;
	
	@Column(name="po_rate")
	private float poRate;
	
	@Column(name="disc_per")
	private float discPer;
	
	@Column(name="po_taxable")
	private float poTaxable;
	
	@Column(name="uom")
	private String uom;
	
	@Column(name="rm_clo_qty")
	private String hsnCode;

	public int getPoDetailId() {
		return poDetailId;
	}

	public void setPoDetailId(int poDetailId) {
		this.poDetailId = poDetailId;
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

	public String getPoQty() {
		return poQty;
	}

	public void setPoQty(String poQty) {
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

	public float getPoTaxable() {
		return poTaxable;
	}

	public void setPoTaxable(float poTaxable) {
		this.poTaxable = poTaxable;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	 

	public String getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}

	@Override
	public String toString() {
		return "GetPoDetailedForPdf [poDetailId=" + poDetailId + ", rmId=" + rmId + ", rmName=" + rmName + ", poQty="
				+ poQty + ", poRate=" + poRate + ", discPer=" + discPer + ", poTaxable=" + poTaxable + ", uom=" + uom
				+ ", hsnCode=" + hsnCode + "]";
	} 

	
	
}
