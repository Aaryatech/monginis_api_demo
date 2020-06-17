package com.ats.webapi.model.frsetting;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_fr_setting")
public class FrSetting implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "fr_setting_id")
	private int frSettingId;

	@Column(name = "fr_id")
	private int frId;

	@Column(name = "frCode")
	private String frCode;

	@Column(name = "sell_bill_no")
	private int sellBillNo;

	@Column(name = "grn_gvn_no")
	private int grnGvnNo;

	@Column(name = "ex_int")
	private int spNo;

	@Column(name = "ex_int1")
	private int count;

	@Column(name = "ex_int2")
	private int posCr;

	@Column(name = "ex_varchar")
	private String exVarchar;

	public int getSpNo() {
		return spNo;
	}

	public void setSpNo(int spNo) {
		this.spNo = spNo;
	}

	public int getFrId() {
		return frId;
	}

	public void setFrId(int frId) {
		this.frId = frId;
	}

	public String getFrCode() {
		return frCode;
	}

	public void setFrCode(String frCode) {
		this.frCode = frCode;
	}

	public int getSellBillNo() {
		return sellBillNo;
	}

	public void setSellBillNo(int sellBillNo) {
		this.sellBillNo = sellBillNo;
	}

	public int getGrnGvnNo() {
		return grnGvnNo;
	}

	public void setGrnGvnNo(int grnGvnNo) {
		this.grnGvnNo = grnGvnNo;
	}

	public int getFrSettingId() {
		return frSettingId;
	}

	public void setFrSettingId(int frSettingId) {
		this.frSettingId = frSettingId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getExVarchar() {
		return exVarchar;
	}

	public void setExVarchar(String exVarchar) {
		this.exVarchar = exVarchar;
	}

	public int getPosCr() {
		return posCr;
	}

	public void setPosCr(int posCr) {
		this.posCr = posCr;
	}

	@Override
	public String toString() {
		return "FrSetting [frSettingId=" + frSettingId + ", frId=" + frId + ", frCode=" + frCode + ", sellBillNo="
				+ sellBillNo + ", grnGvnNo=" + grnGvnNo + ", spNo=" + spNo + ", count=" + count + ", posCr=" + posCr
				+ ", exVarchar=" + exVarchar + "]";
	}

}
