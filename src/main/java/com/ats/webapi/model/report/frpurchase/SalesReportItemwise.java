package com.ats.webapi.model.report.frpurchase;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
//Sales Report no 8
public class SalesReportItemwise implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	
	@Column(name="item_hsncd")
	private String itemHsncd;
	
	@Column(name="item_tax1")
	private float itemTax1;
	
	@Column(name="item_tax2")
	private float itemTax2;
	
	@Column(name="item_tax3")
	private float itemTax3;
 
	@Column(name="item_name")
	private String itemName;
 
 float taxableAmtSum;
 float sgstRsSum;
 float cgstRsSum;
 float igstRsSum;
 int billQtySum;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getItemHsncd() {
	return itemHsncd;
}
public void setItemHsncd(String itemHsncd) {
	this.itemHsncd = itemHsncd;
}
public float getItemTax1() {
	return itemTax1;
}
public void setItemTax1(float itemTax1) {
	this.itemTax1 = itemTax1;
}
public float getItemTax2() {
	return itemTax2;
}
public void setItemTax2(float itemTax2) {
	this.itemTax2 = itemTax2;
}
public float getItemTax3() {
	return itemTax3;
}
public void setItemTax3(float itemTax3) {
	this.itemTax3 = itemTax3;
}
public String getItemName() {
	return itemName;
}
public void setItemName(String itemName) {
	this.itemName = itemName;
}
public float getTaxableAmtSum() {
	return taxableAmtSum;
}
public void setTaxableAmtSum(float taxableAmtSum) {
	this.taxableAmtSum = taxableAmtSum;
}
public float getSgstRsSum() {
	return sgstRsSum;
}
public void setSgstRsSum(float sgsstRsSum) {
	this.sgstRsSum = sgsstRsSum;
}
public float getCgstRsSum() {
	return cgstRsSum;
}
public void setCgstRsSum(float cgstRsSum) {
	this.cgstRsSum = cgstRsSum;
}
public float getIgstRsSum() {
	return igstRsSum;
}
public void setIgstRsSum(float igstRsSum) {
	this.igstRsSum = igstRsSum;
}
public int getBillQtySum() {
	return billQtySum;
}
public void setBillQtySum(int billQtySum) {
	this.billQtySum = billQtySum;
}
 
 

}
