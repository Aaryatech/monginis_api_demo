package com.ats.webapi.service;

import java.util.List;

import com.ats.webapi.model.ItemWithSubCat;

public interface GetFrItemsService {

	   public List<ItemWithSubCat> findFrItems( List<Integer>items);

}
