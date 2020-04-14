package com.ats.webapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.GetItemByCatId;
import com.ats.webapi.model.GetItemByCatIdList;
import com.ats.webapi.repository.GetItemByCatIdRepository;

@Service
public class GetItemByCatIdServiceImpl implements GetItemByCatIdService {

	@Autowired
	GetItemByCatIdRepository getItemByCatIdRepository;

	@Override
	public GetItemByCatIdList getItemByCatId(int catId) {

		GetItemByCatIdList itemList = new GetItemByCatIdList();

		List<GetItemByCatId> itemByCatId = getItemByCatIdRepository.getItemByCategory(catId);

		itemList.setGetItemByCatId(itemByCatId);

		return itemList;
	}

	@Override
	public GetItemByCatIdList getItemBySubCatId(int subCatId) {

		GetItemByCatIdList itemList = new GetItemByCatIdList();

		List<GetItemByCatId> itemByCatId =null;
		if(subCatId==4)
		{
			itemByCatId=getItemByCatIdRepository.getSpByCategoryBySubCatId();

		}else {				
			itemByCatId=getItemByCatIdRepository.getItemByCategoryBySubCatId(subCatId);
		}

		itemList.setGetItemByCatId(itemByCatId);

		return itemList;
	}

}
