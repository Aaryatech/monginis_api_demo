package com.ats.webapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="m_spcake_sup")
public class SpCakeSupplement implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="sp_id")
	private int spId;
	
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

	
	
	public int getUomId() {
		return uomId;
	}

	public void setUomId(int uomId) {
		this.uomId = uomId;
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

	@Override
	public String toString() {
		return "SpCakeSupplement [id=" + id + ", spId=" + spId + ", spHsncd=" + spHsncd + ", spUom=" + spUom
				+ ", spCess=" + spCess + ", cutSection=" + cutSection + ", isTallySync=" + isTallySync + ", delStatus="
				+ delStatus + ", uomId=" + uomId + "]";
	}

	
}
