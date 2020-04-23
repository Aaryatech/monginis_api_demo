package com.ats.webapi.service;


import java.util.List;

import org.springframework.data.repository.query.Param;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.GetItemSup;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.Item;
import com.ats.webapi.model.ItemSup;
import com.ats.webapi.model.ItemSupList;
import com.ats.webapi.model.ItemWithSubCat;
import com.ats.webapi.model.tray.TrayType;

public interface ItemService {

	public ErrorMessage saveItem(Item item);
	public Item findItems(int id);
	public ItemsList findAllItems();
	public Item findItem(int id);
	public List<Item> findFrItems(String itemGrp1);
 	public List<Item> getAllItems();
	public List<Item> findItemsByItemId(List<Integer> itemList);
	
	public List<Item> getOtherItemsForFr(int frId, int catId);
	public ItemSup saveItemSup(ItemSup itemSup);
	public Info deleteItemSup(List<String> itemId);
	public ItemSupList getItemSupList();
	public GetItemSup getItemSup(int id);
	public int getUniqueItemCode();
	public List<TrayType> getTrayTypes();
	public ItemsList getAllItemsBySorting();
	public List<Item> getItemsByIsAllowBday();
	public List<Item> getItemsByCatIdForSup(String itemGrp1);
	public List<Item> findAllItemsByItemId(List<Integer> itemList);
	public GetItemSup getItemSupByItemId(int itemId);
	ItemsList getItemsForItemDetail(int rmId, int rmType);
}
