package com.ats.webapi.model;

import java.util.List;

public class SpCakeOrdersBeanList {
	List<SpCakeOrdersBean> spCakeOrdersBean;
	Info info;
	public List<SpCakeOrdersBean> getSpCakeOrdersBean() {
		return spCakeOrdersBean;
	}
	public void setSpCakeOrdersBean(List<SpCakeOrdersBean> spCakeOrdersBean) {
		this.spCakeOrdersBean = spCakeOrdersBean;
	}
	public Info getInfo() {
		return info;
	}
	public void setInfo(Info info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "SpCakeOrdersBeanList [spCakeOrdersBean=" + spCakeOrdersBean + ", info=" + info + "]";
	}
	
	
	
	

}
