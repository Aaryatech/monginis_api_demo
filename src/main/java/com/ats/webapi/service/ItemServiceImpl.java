package com.ats.webapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.commons.Firebase;
import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.GetItemSup;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.Item;
import com.ats.webapi.model.ItemSup;
import com.ats.webapi.model.ItemSupList;
import com.ats.webapi.model.tray.TrayType;
import com.ats.webapi.repository.FranchiseSupRepository;
import com.ats.webapi.repository.GetItemSupRepository;
import com.ats.webapi.repository.ItemRepository;
import com.ats.webapi.repository.ItemSupRepository;
import com.ats.webapi.repository.tray.TrayTypeRepository;

@Service
public class ItemServiceImpl implements ItemService{

	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private ItemSupRepository itemSupRepository;
 	
	@Autowired
	private GetItemSupRepository getItemSupRepository;
	
	@Autowired
	TrayTypeRepository trayTypeRepository;
	@Autowired
	FranchiseSupRepository franchiseSupRepository;
	String jsonUser = "{}";

	public Item findItems(int id) {
		Item item=itemRepository.findOne(id);
		return item;
	}
	
	public ErrorMessage saveItem(Item item) {
		
		Item tempItem =null;
		ErrorMessage errorMessage=new ErrorMessage();
		try {
		
					item= itemRepository.save(item);
					errorMessage.setError(false);
					errorMessage.setMessage("Item Inserted/Updated Successfully");

					 try {
						    List<String> frTokens=franchiseSupRepository.findTokens();

						 for(String token:frTokens) {
				          Firebase.sendPushNotifForCommunication(token,"Item Details Updated","Changes have been made in OPS at item level, SP level, in the rates. Kindly refer the OPS for exact changes made.","inbox");
						 }
				         }
				         catch(Exception e2)
				         {
					       e2.printStackTrace();
				         }
		
		} catch (Exception e) {
			errorMessage.setError(true);
			errorMessage.setMessage("Exc while saving Item");
		}
		return errorMessage;
	}

	
	public ItemsList findAllItems() {
		 List<Item> items=new ArrayList<Item>();
		 ItemsList itemsList=new ItemsList();
		ErrorMessage errorMessage=new ErrorMessage();
		items=itemRepository.findByDelStatusOrderByItemGrp1AscItemGrp2AscItemNameAsc(0);
		if(items!=null)
		{
			
			errorMessage.setError(false);
			errorMessage.setMessage("All items displayed successfully");
			itemsList.setErrorMessage(errorMessage);
			itemsList.setItems(items);
		}
		else
		{
			errorMessage.setError(true);
			errorMessage.setMessage("Items Not Found");
			itemsList.setErrorMessage(errorMessage);
		}
		
		return itemsList;
	}

	@Override
	public Item findItem(int id) {
		Item item=itemRepository.findOne(id);
		return item;
	}

	@Override
	public List<Item> findFrItems(String itemGrp1) {
		List<Item> items=itemRepository.findByItemGrp1AndDelStatusOrderByItemGrp2Asc(itemGrp1,0);
		return items;
	}

	@Override
	public List<Item> getAllItems() {
		 List<Item> items=itemRepository.findByDelStatusOrderByItemGrp2(0);

		return items;
	}

	@Override
	public List<Item> findItemsByItemId(List<Integer> itemList) {

		
		 List<Item> items=itemRepository.findByDelStatusAndItemIdIn(itemList);
		return items;
	}

	@Override
	public ItemSup saveItemSup(ItemSup itemSup) {

		List<ItemSup> suppList=itemSupRepository.findByItemId(itemSup.getItemId());
		ItemSup itemSupRes=null;
		if(suppList.size()==0 || itemSup.getId()!=0) {
		
		 try {
			    List<String> frTokens=franchiseSupRepository.findTokens();
			    itemSupRes=itemSupRepository.save(itemSup);

			 for(String token:frTokens) {
	          Firebase.sendPushNotifForCommunication(token,"Item Details Updated","Changes have been made in OPS at item level, SP level, in the rates. Kindly refer the OPS for exact changes made.","updateList");
			 }
	         }
	         catch(Exception e2)
	         {
		       e2.printStackTrace();
	         }
		}
		return itemSupRes;
	}

	@Override
	public Info deleteItemSup(List<String> itemId) {

		int isDel=itemSupRepository.deleteItemSup(itemId);
		Info info=new Info();
		if(isDel>=1)
		{
			info.setError(false);
			info.setMessage("ItemSup Deleted Successfully.");
		}
		else
		{
			info.setError(true);
			info.setMessage("ItemSup Deletion Failed.");
		}
		return info;
	}

	@Override
	public ItemSupList getItemSupList() {

		ItemSupList itemSupList=new ItemSupList();
		try {
		List<GetItemSup> itemSupListRes=getItemSupRepository.findAllByDelStatus(0);
		
		if(!itemSupListRes.isEmpty())
		{
			Info info=new Info();
			info.setError(true);
			info.setMessage("ItemList Found Successfully.");
			
			itemSupList.setItemSupList(itemSupListRes);
			itemSupList.setInfo(info);
		}
		else
		{
			Info info=new Info();
			info.setError(true);
			info.setMessage("ItemList Not Found.");
			itemSupList.setInfo(info);

		}
		}
		catch(Exception e)
		{
			System.out.println("Exception In GetItemSup List ");
			e.printStackTrace();
			Info info=new Info();
			info.setError(true);
			info.setMessage("ItemList Not Found.");
			itemSupList.setInfo(info);
		}
		return itemSupList;
	}

	@Override
	public GetItemSup getItemSup(int id) {

		GetItemSup itemSup=getItemSupRepository.findGetItemSupById(id);
		return itemSup;
	}
	@Override
	public GetItemSup getItemSupByItemId(int itemId) {

		GetItemSup itemSup=getItemSupRepository.findGetItemSupByItemId(itemId);
		return itemSup;
	}
	@Override
	public int getUniqueItemCode() {

		int maxId=itemRepository.findMaxId();
		return maxId;
	}

	@Override
	public List<TrayType> getTrayTypes() {

		List<TrayType> trayTypeList=trayTypeRepository.findAllByDelStatus(0);
		return trayTypeList;
	}

	@Override
	public ItemsList getAllItemsBySorting() {
		 List<Item> items=new ArrayList<Item>();
		 ItemsList itemsList=new ItemsList();
		ErrorMessage errorMessage=new ErrorMessage();
		items=itemRepository.findByDelStatusOrderByItemGrp2AscItemSortIdAsc(0);
		if(items!=null)
		{
			
			errorMessage.setError(false);
			errorMessage.setMessage("All items displayed successfully");
			itemsList.setErrorMessage(errorMessage);
			itemsList.setItems(items);
		}
		else
		{
			errorMessage.setError(true);
			errorMessage.setMessage("Items Not Found");
			itemsList.setErrorMessage(errorMessage);
		}
		
		return itemsList;
	}

	@Override
	public List<Item> getItemsByIsAllowBday() {

		List<Item> itemList=null;
		try
		{
			itemList=itemRepository.findByIsAllowBirthayAndDelStatus(1,0);
			if(itemList==null)
			{
				itemList=new ArrayList<>();
			}
		}catch(Exception e)
		{
			itemList=new ArrayList<>();
			e.printStackTrace();
		}
		
		return itemList;
	}

	@Override
	public List<Item> getItemsByCatIdForSup(String itemGrp1) {

		List<Item> itemList=null;
		try
		{

			itemList=itemRepository.findByItemGrp1(itemGrp1);
		}catch(Exception e)
		{
			itemList=new ArrayList<>();
			e.printStackTrace();
		}
		return itemList;
	}

	@Override
	public List<Item> findAllItemsByItemId(List<Integer> itemList) {
		List<Item> items=itemRepository.findAllItems(itemList);	
		return items;
	}

	@Override
	public List<Item> getOtherItemsForFr(int frId, int catId) {
		 
		 List<Item> items=itemRepository.getOtherItemsForFr(frId, catId);
			return items;
	}

	//Sachin 23-04-2020
	@Override
	public ItemsList getItemsForItemDetail(int rmId,int rmType) {
		 List<Item> items=new ArrayList<Item>();
		 ItemsList itemsList=new ItemsList();
		ErrorMessage errorMessage=new ErrorMessage();
		items=itemRepository.getItemsByRmIdAndRmType(rmId,rmType);
		if(items!=null)
		{
			
			errorMessage.setError(false);
			errorMessage.setMessage("All items displayed successfully");
			itemsList.setErrorMessage(errorMessage);
			itemsList.setItems(items);
		}
		else
		{
			errorMessage.setError(true);
			errorMessage.setMessage("Items Not Found");
			itemsList.setErrorMessage(errorMessage);
		}
		
		return itemsList;
	}

}
