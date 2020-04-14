package com.ats.webapi.service;

import java.util.List;

import com.ats.webapi.model.AllRegularSpCkItems;

public interface RegularSpCkItemsService {

	public AllRegularSpCkItems findRegularSpCkItems(List<Integer> items, int itemGrp2);
		
}
