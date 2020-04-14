package com.ats.webapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_fr_opening_stock_detail")
public class RegularSpecialStockCal {
	
	
	@Id
	@Column(name="reg")
	private int reg;
	
	@Column(name="sp")
	private int sp;

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
		return "RegularSpecialStockCal [reg=" + reg + ", sp=" + sp + "]";
	}
	

}
