package com.ats.webapi.model;

import java.util.List;

/**
 * @author ats-11
 *
 */
public class GetGrnItemConfigList {
	
	List<GetGrnItemConfig> getGrnItemConfigs;
	
	Info info;

	public List<GetGrnItemConfig> getGetGrnItemConfigs() {
		return getGrnItemConfigs;
	}

	public void setGetGrnItemConfigs(List<GetGrnItemConfig> getGrnItemConfigs) {
		this.getGrnItemConfigs = getGrnItemConfigs;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "GetGrnItemConfigList [getGrnItemConfigs=" + getGrnItemConfigs + ", info=" + info + "]";
	}
	
	
	

}
