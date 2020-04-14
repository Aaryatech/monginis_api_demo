package com.ats.webapi.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class FrList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="fr_id")
	private int frId;
	
	@Column(name="fr_name")
	private String frName;
	
	@Column(name="abc_type")
	private int abcType;
	
	@Transient
	List<ItemListForDispatchReport> itemList;
	
	public int getFrId() {
		return frId;
	}
	public void setFrId(int frId) {
		this.frId = frId;
	}
	public String getFrName() {
		return frName;
	}
	public void setFrName(String frName) {
		this.frName = frName;
	}
	public int getAbcType() {
		return abcType;
	}
	public void setAbcType(int abcType) {
		this.abcType = abcType;
	}
	public List<ItemListForDispatchReport> getItemList() {
		return itemList;
	}
	public void setItemList(List<ItemListForDispatchReport> itemList) {
		this.itemList = itemList;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "FrList [id=" + id + ", frId=" + frId + ", frName=" + frName + ", abcType=" + abcType + ", itemList="
				+ itemList + "]";
	}
	
	

}
