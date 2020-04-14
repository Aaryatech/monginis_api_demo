package com.ats.webapi.model.prod.mixing;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="t_mixing_temp")
public class TempMixing implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="temp_id")
	private int tempId;
	
	
	@Column(name="prod_header_id")
	private int prodHeaderId;
	
	
	@Column(name="sf_id")
	private int sfId;
	
	@Column(name="rm_id")
	private int rmId;
	
	@Column(name="qty")
	private float qty;

	

	

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

	public float getQty() {
		return qty;
	}

	public void setQty(float qty) {
		this.qty = qty;
	}

	public int getProdHeaderId() {
		return prodHeaderId;
	}

	public void setProdHeaderId(int prodHeaderId) {
		this.prodHeaderId = prodHeaderId;
	}

	@Override
	public String toString() {
		return "TempMixing [tempId=" + tempId + ", prodHeaderId=" + prodHeaderId + ", sfId=" + sfId + ", rmId=" + rmId
				+ ", qty=" + qty + "]";
	}

	

	
}
