package com.ats.webapi.model.rawmaterial;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="m_item_sf_header")
public class ItemSfHeader implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="sf_id")
	private int sfId;
	
	@Column(name="sf_name")
	private String sfName;
	
	@Column(name="sf_type")
	private String sfType;
	
	@Column(name="sf_uom_id")
	private int sfUomId;
	
	@Column(name="sf_weight")
	private float sfWeight;
	
	@Column(name="stock_qty")
	private int stockQty;
	
	@Column(name="min_level_qty")
	private float minLevelQty;
	
	@Column(name="max_level_qty")
	private float maxLevelQty;
	
	@Column(name="reorder_level_qty")
	private float reorderLevelQty;

	@Column(name="del_status")
	private int delStatus;
	
	@Column(name="mul_factor")
	private float mulFactor;

	
	@Column(name="int_1")
    private int int1;//deptId
	
	@Column(name="int_2")
	private int int2;//issue Sequence No
	
	@Column(name="varchar_1")
	private String varchar1;//extra
	
	@Column(name="varchar_2")
	private String varchar2;//extra
	
	@Column(name="bool_1")
	private int bool1;//extra
	
	

	
	public int getInt1() {
		return int1;
	}

	public void setInt1(int int1) {
		this.int1 = int1;
	}

	public int getInt2() {
		return int2;
	}

	public void setInt2(int int2) {
		this.int2 = int2;
	}

	public String getVarchar1() {
		return varchar1;
	}

	public void setVarchar1(String varchar1) {
		this.varchar1 = varchar1;
	}

	public String getVarchar2() {
		return varchar2;
	}

	public void setVarchar2(String varchar2) {
		this.varchar2 = varchar2;
	}

	public int getBool1() {
		return bool1;
	}

	public void setBool1(int bool1) {
		this.bool1 = bool1;
	}

	public float getMulFactor() {
		return mulFactor;
	}

	public void setMulFactor(float mulFactor) {
		this.mulFactor = mulFactor;
	}

	public int getSfId() {
		return sfId;
	}

	public void setSfId(int sfId) {
		this.sfId = sfId;
	}

	public String getSfName() {
		return sfName;
	}

	public void setSfName(String sfName) {
		this.sfName = sfName;
	}


	public int getSfUomId() {
		return sfUomId;
	}

	public void setSfUomId(int sfUomId) {
		this.sfUomId = sfUomId;
	}

	public int getStockQty() {
		return stockQty;
	}

	public void setStockQty(int stockQty) {
		this.stockQty = stockQty;
	}

	public float getMinLevelQty() {
		return minLevelQty;
	}

	public void setMinLevelQty(float minLevelQty) {
		this.minLevelQty = minLevelQty;
	}

	public float getMaxLevelQty() {
		return maxLevelQty;
	}

	public void setMaxLevelQty(float maxLevelQty) {
		this.maxLevelQty = maxLevelQty;
	}

	public float getReorderLevelQty() {
		return reorderLevelQty;
	}

	public void setReorderLevelQty(float reorderLevelQty) {
		this.reorderLevelQty = reorderLevelQty;
	}
	
	
	public String getSfType() {
		return sfType;
	}

	public void setSfType(String sfType) {
		this.sfType = sfType;
	}

	public float getSfWeight() {
		return sfWeight;
	}

	public void setSfWeight(float sfWeight) {
		this.sfWeight = sfWeight;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "ItemSfHeader [sfId=" + sfId + ", sfName=" + sfName + ", sfType=" + sfType + ", sfUomId=" + sfUomId
				+ ", sfWeight=" + sfWeight + ", stockQty=" + stockQty + ", minLevelQty=" + minLevelQty
				+ ", maxLevelQty=" + maxLevelQty + ", reorderLevelQty=" + reorderLevelQty + ", delStatus=" + delStatus
				+ ", mulFactor=" + mulFactor + ", int1=" + int1 + ", int2=" + int2 + ", varchar1=" + varchar1
				+ ", varchar2=" + varchar2 + ", bool1=" + bool1 + "]";
	}

	
}
