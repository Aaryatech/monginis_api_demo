package com.ats.webapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_bill_detail")
public class StockRegSpPurchase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int no;
	
	private int reg;
	
	
	private int sp;
	
	

	

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getReg() {
		return reg;
	}

	public void setReg(int reg) {
		this.reg = reg;
	}

	public int getSp() {
		return sp;
	}

	public void setSp(int sp) {
		this.sp = sp;
	}

	@Override
	public String toString() {
		return "StockRegSpPurchase [no=" + no + ", reg=" + reg + ", sp=" + sp + "]";
	}

	
	

}
