package com.ats.webapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_rm")
public class MRm {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="rm_id")
	private int rm_id;
	
	@Column(name="rm_name")
	private String rm_name;

	@Column(name="rm_rate")
	private int rm_rate;

	public int getRm_id() {
		return rm_id;
	}

	public void setRm_id(int rm_id) {
		this.rm_id = rm_id;
	}

	public String getRm_name() {
		return rm_name;
	}

	public void setRm_name(String rm_name) {
		this.rm_name = rm_name;
	}

	public int getRm_rate() {
		return rm_rate;
	}

	public void setRm_rate(int rm_rate) {
		this.rm_rate = rm_rate;
	}

	@Override
	public String toString() {
		return "MRm [rm_id=" + rm_id + ", rm_name=" + rm_name + ", rm_rate=" + rm_rate + "]";
	}
	
	
}
