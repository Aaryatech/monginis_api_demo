package com.ats.webapi.model.spprod;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="t_sp_inst_verif_d")
public class InstVerificationDetail implements Serializable{


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="inst_verif_d_id")
	private int instVerifDId;
	
	@Column(name="inst_verif_h_id")
	private int instVerifHId;
	
	private int instId;
	
	private int bef;
	
	private int aft;


	public int getInstVerifDId() {
		return instVerifDId;
	}

	public void setInstVerifDId(int instVerifDId) {
		this.instVerifDId = instVerifDId;
	}

	public int getInstVerifHId() {
		return instVerifHId;
	}

	public void setInstVerifHId(int instVerifHId) {
		this.instVerifHId = instVerifHId;
	}

	public int getInstId() {
		return instId;
	}

	public void setInstId(int instId) {
		this.instId = instId;
	}

	
	public int getBef() {
		return bef;
	}

	public void setBef(int bef) {
		this.bef = bef;
	}

	public int getAft() {
		return aft;
	}

	public void setAft(int aft) {
		this.aft = aft;
	}

	@Override
	public String toString() {
		return "InstVerificationDetail [ instVerifDId=" + instVerifDId
				+ ", instVerifHId=" + instVerifHId + ", instId=" + instId + ", before=" + bef + ", after=" + aft
				+ "]";
	}
	
	
}
