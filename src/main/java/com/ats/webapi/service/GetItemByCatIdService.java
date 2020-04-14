package com.ats.webapi.service;

import com.ats.webapi.model.GetItemByCatIdList;

public interface GetItemByCatIdService {

	GetItemByCatIdList getItemByCatId(int catId);

	GetItemByCatIdList getItemBySubCatId(int subCatId);

}
