package com.ats.webapi.model;

import java.util.List;

public class FrItemStockConfigurePostList {
	
	List<GetFrItemStockConfiguration> frItemStockConfigurePosts;
	Info info;
	public List<GetFrItemStockConfiguration> getFrItemStockConfigurePosts() {
		return frItemStockConfigurePosts;
	}
	public void setFrItemStockConfigurePosts(List<GetFrItemStockConfiguration> frItemStockConfigurePosts) {
		this.frItemStockConfigurePosts = frItemStockConfigurePosts;
	}
	public Info getInfo() {
		return info;
	}
	public void setInfo(Info info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "FrItemStockConfigurePostList [frItemStockConfigurePosts=" + frItemStockConfigurePosts + ", info=" + info
				+ "]";
	}
	
	

}
