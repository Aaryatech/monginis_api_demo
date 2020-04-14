package com.ats.webapi.model.phpwebservice;

import java.util.List;

public class SpecialCakeBeanList {

	String status;

	List<SpecialCakeBean> sp_cake;

	public String getStatus() {
		return status;
	}

	public List<SpecialCakeBean> getSp_cake() {
		return sp_cake;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setSp_cake(List<SpecialCakeBean> sp_cake) {
		this.sp_cake = sp_cake;
	}

	@Override
	public String toString() {
		return "SpecialCakeBeanList [status=" + status + ", sp_cake=" + sp_cake + "]";
	}
	
}
