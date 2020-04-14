package com.ats.webapi.model.prod.mixing;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetTempMixItemDetail implements Serializable {
	
	@Override
	public String toString() {
		return "GetTempMixItemDetail [tempId=" + tempId + ", sfId=" + sfId + ", rmId=" + rmId + ", rmName=" + rmName
				+ ", rmType=" + rmType + ", uom=" + uom + ", mulFactor=" + mulFactor + ", total=" + total + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="temp_id")
	private int tempId;
	
	@Column(name="sf_id")
	private int sfId;
	
	@Column(name="rm_id")
	private int rmId;
	
	@Column(name="rm_name")
	private String rmName;
	
	@Column(name="rm_type")
	private int rmType;
	
	@Column(name="uom")
	private String uom;
	
	@Column(name="mul_factor")
	private float mulFactor;
	
public float getMulFactor() {
		return mulFactor;
	}

	public void setMulFactor(float mulFactor) {
		this.mulFactor = mulFactor;
	}

float total;

public int getTempId() {
	return tempId;
}

public void setTempId(int tempId) {
	this.tempId = tempId;
}


public int getSfId() {
	return sfId;
}

public void setSfId(int sfId) {
	this.sfId = sfId;
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

public int getRmType() {
	return rmType;
}

public void setRmType(int rmType) {
	this.rmType = rmType;
}

public String getUom() {
	return uom;
}

public void setUom(String uom) {
	this.uom = uom;
}

public float getTotal() {
	return total;
}

public void setTotal(float total) {
	this.total = total;
}



	
	/*sf_id
	rm_id
	rm_name
	rm_type
	uom
	total
	
	*/
	

}
