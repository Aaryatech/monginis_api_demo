package com.ats.webapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_temp_prod")
public class GetSfData implements Serializable{

	@Id
	@Column(name="sf_id")
	private int sfId;
	@Column(name="rm_qty")
	private float rmQty;
	private int type;
	public int getSfId() {
		return sfId;
	}

	public float getRmQty() {
		return rmQty;
	}

	public void setSfId(int sfId) {
		this.sfId = sfId;
	}

	public void setRmQty(float rmQty) {
		this.rmQty = rmQty;
	}
    
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "GetSfData [sfId=" + sfId + ", rmQty=" + rmQty + ", type=" + type + "]";
	}
	
}
