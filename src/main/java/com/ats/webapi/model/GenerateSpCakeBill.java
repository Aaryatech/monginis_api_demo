package com.ats.webapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GenerateSpCakeBill {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="sp_vno")
	private int spVno;
	
	@Column(name="fr_id")
	int  frId;
	
	@Column(name="menu_id")
	int  menuId;
	
	@Column(name="sp_id")
	int  spId;
	
	
	@Column(name="sp_rate_with_add_rate")
	double  spRatWithAddRate;
	
	@Column(name="sp_price")
	double  spPrice;
	
	@Column(name="fr_name")
	String  frName;
	
	@Column(name="menu_title")
	String  menuTitle;
	
	@Column(name="sp_name")
	String  spName;
	
	@Column(name="fr_code")
	String  frCode;
	
	@Column(name="tax_1")
	private String tax1;
	
	@Column(name="tax_2")
	private String tax2;
	
	
	@Column(name="grn_type")//newly added
	int  grnType;
	

	@Column(name="delivery_date")//newly added
	Date  deliveryDate;

	
	
	
}
