package com.ats.webapi.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ItemDiscConfigured implements Serializable{
	
	@Id
	private int id;
	
	private int frId;
	
	private float discPer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFrId() {
		return frId;
	}

	public void setFrId(int frId) {
		this.frId = frId;
	}

	public float getDiscPer() {
		return discPer;
	}

	public void setDiscPer(float discPer) {
		this.discPer = discPer;
	}

	@Override
	public String toString() {
		return "ItemDiscConfigured [id=" + id + ", frId=" + frId + ", discPer=" + discPer + "]";
	}
	
	

}
