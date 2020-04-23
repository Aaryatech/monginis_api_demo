package com.ats.webapi.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.commons.Firebase;
import com.ats.webapi.model.AllMenus;
import com.ats.webapi.model.CategoryList;
import com.ats.webapi.model.ConfigureFranchisee;
import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.Flavour;
import com.ats.webapi.model.FlavourConf;
import com.ats.webapi.model.FrItemStockConfigureList;
import com.ats.webapi.model.FrListForSupp;
import com.ats.webapi.model.FrMenuConfigure;
import com.ats.webapi.model.FrTarget;
import com.ats.webapi.model.FrTargetList;
import com.ats.webapi.model.FrTotalSale;
import com.ats.webapi.model.FranchiseSup;
import com.ats.webapi.model.FranchiseSupList;
import com.ats.webapi.model.GetFrMenuConfigure;
import com.ats.webapi.model.GetItemSup;
import com.ats.webapi.model.GetRegSpCakeOrders;
import com.ats.webapi.model.GetSpCkSupplement;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.Item;
import com.ats.webapi.model.ItemForMOrder;
import com.ats.webapi.model.ItemIdOnly;
import com.ats.webapi.model.ItemResponse;
import com.ats.webapi.model.ItemSup;
import com.ats.webapi.model.ItemSupList;
import com.ats.webapi.model.MCategory;
import com.ats.webapi.model.PostFrItemStockDetail;
import com.ats.webapi.model.PostFrItemStockHeader;
import com.ats.webapi.model.RegularSpCkOrders;
import com.ats.webapi.model.SectionMaster;
import com.ats.webapi.model.SpCake;
import com.ats.webapi.model.SpCakeSupplement;
import com.ats.webapi.model.SubCategory;
import com.ats.webapi.model.SubCategoryRes;
import com.ats.webapi.model.frsetting.FrSetting;
import com.ats.webapi.model.newsetting.NewSetting;
import com.ats.webapi.model.tally.FranchiseeList;
import com.ats.webapi.model.tray.TrayType;
import com.ats.webapi.repository.ConfigureFrRepository;
import com.ats.webapi.repository.FlavourConfRepository;
import com.ats.webapi.repository.FlavourRepository;
import com.ats.webapi.repository.FrItemStockConfigureRepository;
import com.ats.webapi.repository.FrListForSuppRepository;
import com.ats.webapi.repository.FrMenuConfigureRepository;
import com.ats.webapi.repository.FranchiseSupRepository;
import com.ats.webapi.repository.FranchiseeRepository;
import com.ats.webapi.repository.GetFrMenuConfigureRepository;
import com.ats.webapi.repository.GetSpCakeSupRepository;
import com.ats.webapi.repository.ItemForMOrderRepository;
import com.ats.webapi.repository.ItemIdOnlyRepository;
import com.ats.webapi.repository.ItemRepository;
import com.ats.webapi.repository.ItemSupRepository;
import com.ats.webapi.repository.NewSettingRepository;
import com.ats.webapi.repository.OrderRepository;
import com.ats.webapi.repository.PostFrOpStockDetailRepository;
import com.ats.webapi.repository.PostFrOpStockHeaderRepository;
import com.ats.webapi.repository.SpCakeListRepository;
import com.ats.webapi.repository.SpCakeOrdersRepository;
import com.ats.webapi.repository.SpCkDeleteOrderRepository;
import com.ats.webapi.repository.SubCategoryRepository;
import com.ats.webapi.repository.SubCategoryResRepository;
import com.ats.webapi.repository.UpdateSeetingForPBRepo;
import com.ats.webapi.repository.frsetting.FrSettingRepo;
import com.ats.webapi.service.ConfigureFranchiseeService;
import com.ats.webapi.service.FrItemStockConfigureService;
import com.ats.webapi.service.FranchiseeService;
import com.ats.webapi.service.ItemService;
import com.ats.webapi.service.OrderService;
import com.ats.webapi.service.PostFrOpStockService;
import com.ats.webapi.service.RegularSpCkOrderService;
import com.ats.webapi.service.SpecialCakeService;
import com.ats.webapi.util.JsonUtil;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.ats.webapi.repository.CategoryRepository;;
  
@RestController
public class MasterController {

	@Autowired
	ItemService itemService;
	
	@Autowired
	ItemSupRepository itemSuppRepository;
	
	@Autowired
	SubCategoryResRepository subCategoryResRepository;
	
	@Autowired
	FranchiseeService franchiseeService;
	
	@Autowired
	RegularSpCkOrderService regularSpCkOrderService;
	
	@Autowired
	FranchiseeRepository franchiseeRepository;
	
	@Autowired
	SpCkDeleteOrderRepository spCkDeleteOrderRepository;
	
	@Autowired
	SpecialCakeService spCakeService;
	
	@Autowired
	FrListForSuppRepository frListForSuppRepository;
	
	@Autowired
	SpCakeListRepository spCakeListRepository;
	
	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	FranchiseSupRepository franchiseSupRepository;
	
	@Autowired
	SubCategoryRepository subCategoryRepository;
	
	@Autowired
	ConfigureFrRepository configureFrRepository;
	

	@Autowired
	PostFrOpStockHeaderRepository postFrOpStockHeaderRepository;

	@Autowired
	GetSpCakeSupRepository getSpCakeSupRepository;
	
	@Autowired
	PostFrOpStockDetailRepository postFrOpStockDetailRepository;

	@Autowired
	FlavourRepository flavourRepository;
	
	@Autowired
	FrMenuConfigureRepository frMenuConfigureRepository;
	
	@Autowired
	GetFrMenuConfigureRepository getFrMenuConfigureRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	 ItemForMOrderRepository itemRepositoryForMOrderRepository;
	@Autowired
	 ItemIdOnlyRepository itemIdOnlyRepository;
	
	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	SpCakeOrdersRepository spCakeOrdersRepository;
	
	@Autowired
	FrItemStockConfigureService frItemStockConfigureService;
	@Autowired
	UpdateSeetingForPBRepo updateSeetingForPBRepo;
	
	@Autowired
	FrItemStockConfigureRepository frItemStockConfRepo;
	
	@Autowired
	NewSettingRepository newSettingRepository;
	
	@Autowired
	FlavourConfRepository flavourConfRepository;
	@Autowired
	FrSettingRepo frSettingRepo;
	
	
	//Sac 23-04-2020
	@RequestMapping(value = "/getItemsByProductionIdCatId", method = RequestMethod.POST)
	public @ResponseBody List<Item> getItemsByProductionIdCatId(@RequestParam int prodHeaderId) {

		List<Item> itemList;
		try {
			itemList = itemRepository.getItemsByProductionIdCatId(prodHeaderId);
		} catch (Exception e) {
			itemList = new ArrayList<>();
			e.printStackTrace();

		}
		return itemList;

	}
	//Sac 23-04-2020
	@RequestMapping(value = "/findItemsByGrpIdForRmIssue", method = RequestMethod.POST)
	public @ResponseBody List<Item> findItemsByGrpIdForRmIssue(@RequestParam String itemGrp3,
			@RequestParam int prodHeaderId, @RequestParam int fromDept, @RequestParam int toDept) {

		List<Item> itemList = itemRepository.findByItemGrp3(itemGrp3, prodHeaderId, fromDept, toDept);
		return itemList;

	}
	
	
	@RequestMapping(value = "/getOtherItemsByCatIdAndFrId", method = RequestMethod.POST)
	public @ResponseBody List<Item> getOtherItemsByCatIdAndFrId(@RequestParam double frId) {

		List<Item> items = itemRepository.findByItemGrp1AndItemRate2AndDelStatus("7",frId,0);
		
		return items;

	}
	 @RequestMapping(value = { "/updateBillStatusToProduction" }, method = RequestMethod.POST)
		public @ResponseBody Info updateBillStatusToProduction(@RequestParam("spOrderNo") List<Integer> spOrderNo,@RequestParam("billStatus") int billStatus) {
		 int res=0;
		
		 for(int i=0;i<spOrderNo.size();i++)
		 {
		
		 int slipNo=frItemStockConfRepo.findBySettingKey("sp_slip_no");
            System.err.println("slipNo"+slipNo);
		 int result = spCakeOrdersRepository.updateSpBillStatusMul(spOrderNo.get(i),billStatus,""+slipNo);
		 res=res+result;
		
		 int isSpNoUpdated = updateSeetingForPBRepo.updateSeetingForSlip();
		 }

			Info infoRes=new Info();
			if(res>=1)
			{
				infoRes.setError(false);
				infoRes.setMessage("Bill Status Updated");
			}
			else
			{
				infoRes.setError(true);
				infoRes.setMessage("Bill Status Update Failed");
			}
			return infoRes;
		}
	// ----------------------------GET Flavours By Type--------------------------------
		@RequestMapping(value = { "/getFlavoursByType" }, method = RequestMethod.POST)
		public @ResponseBody List<Flavour> getFlavoursByType(@RequestParam("type") int type) {
			
			List<Flavour> flavourList=flavourRepository.findBySpType(type);

		  return flavourList;
		}
		@RequestMapping(value = "/getFlavoursBySpfIdIn", method = RequestMethod.POST)
		public @ResponseBody List<Flavour> getFlavoursBySpfIdIn(@RequestParam List<Integer> spfId) {

			List<Flavour> flavourList = flavourRepository.findBySpfIdIn(spfId);
			
			return flavourList;
		}
		@RequestMapping(value = "/getFlavoursBySpfIdNotIn", method = RequestMethod.POST)
		public @ResponseBody List<Flavour> getFlavoursBySpfIdNotIn(@RequestParam List<Integer> spfId,@RequestParam("type") int type) {

			List<Flavour> flavourList=null;
			if(type!=0) {
			 flavourList = flavourRepository.findBySpfIdNotInAndSpType(spfId,type);
			}
			else
			{
			 flavourList = flavourRepository.findBySpfIdNotIn(spfId);
			}
			
			return flavourList;
		}
	// ----------------------------GET FrToken--------------------------------
	@RequestMapping(value = { "/getFrToken" }, method = RequestMethod.POST)
	public @ResponseBody String getFrToken(@RequestParam("frId") int frId) {
		
	  String frToken=franchiseSupRepository.findTokenByFrId(frId);

	  return frToken;
	}
	//-------------------------------------------------------------------------
	@RequestMapping(value = { "/getItemCode" }, method = RequestMethod.POST)
	public @ResponseBody String getItemCode(@RequestParam("catId") int catId,@RequestParam("subCatId") int subCatId) {
		
	  String code=itemSuppRepository.findItemPrefix(subCatId);
	  
	  int cnt=itemSuppRepository.findItemCount(catId,subCatId);
	  
	  int maxCodeLenth = String.valueOf(cnt).length();
	  maxCodeLenth = 5 - maxCodeLenth;
		StringBuilder itemCode = new StringBuilder(code);

		for (int i = 0; i < maxCodeLenth; i++) {
			String j = "0";
			itemCode.append(j);
		}
		itemCode.append(String.valueOf(cnt));

	  return ""+itemCode;
	}
	// ----------------------------SAVE Item Sup---------------------------
		@RequestMapping(value = { "/saveItemSup" }, method = RequestMethod.POST)
		public @ResponseBody Info saveItemSup(@RequestBody ItemSup itemSup) {

			ItemSup itemSupRes = null;
			Info info = new Info();
			try {

				itemSupRes = itemService.saveItemSup(itemSup);

				if (itemSupRes != null) {
					info.setError(false);
					info.setMessage("ItemSup Saved Successfully.");
				} else {
					info.setError(true);
					info.setMessage("ItemSup Not Saved .");
				}

			} catch (Exception e) {

				info.setError(true);
				info.setMessage("ItemSup Not Saved .");

				e.printStackTrace();
				System.out.println("Exception In MasterController /saveItemSup" + e.getMessage());

			}
			return info;

		}
		@RequestMapping(value = { "/saveItem" }, method = RequestMethod.POST)
		public @ResponseBody Item saveItem(@RequestBody Item item) {

			Item itemRes = null;
			try {

				itemRes = itemRepository.save(item);

			} catch (Exception e) {
				itemRes=new Item();
			}
			return itemRes;

		}
      //---------------------------------------------------------------------------
		
		// ----------------------------SAVE Sub Category---------------------------
				@RequestMapping(value = { "/saveSubCategory" }, method = RequestMethod.POST)
				public @ResponseBody Info saveSubCategory(@RequestBody SubCategoryRes subCategory) {

					SubCategoryRes subCategoryRes = null;
					Info info = new Info();
					try {

						subCategoryRes = subCategoryResRepository.save(subCategory);

						if (subCategoryRes != null) {
							info.setError(false);
							info.setMessage("SubCategoryRes Saved Successfully.");
						} else {
							info.setError(true);
							info.setMessage("SubCategoryRes Not Saved .");
						}

					} catch (Exception e) {

						info.setError(true);
						info.setMessage("SubCategoryRes Not Saved .");

						e.printStackTrace();
						System.out.println("Exception In MasterController /saveSubCategory" + e.getMessage());

					}
					return info;

				}
		      //---------------------------------------------------------------------------
				// ------------------------Delete SubCategoryRes------------------------------------
				@RequestMapping(value = { "/deleteSubCategory" }, method = RequestMethod.POST)
				public @ResponseBody Info deleteSubCategory(@RequestParam("subCatId") int subCatId) {

					int isDeleted = subCategoryResRepository.deleteSubCategory(subCatId);
					Info infoRes=new Info();
					if(isDeleted>=1)
					{
						infoRes.setError(false);
						infoRes.setMessage("SubCategoryRes Deleted");
					}
					else
					{
						infoRes.setError(true);
						infoRes.setMessage("SubCategoryRes Deletion Failed");
					}
					return infoRes;
				}
		        //------------------------------------------------------------------------
				@RequestMapping(value = { "/getSubCategory" }, method = RequestMethod.POST)
				public @ResponseBody SubCategoryRes getSubCategory(@RequestParam("subCatId") int subCatId) {

					SubCategoryRes getSubCategoryRes = null;
			    	try {
						getSubCategoryRes = subCategoryResRepository.findBySubCatId(subCatId);

					} catch (Exception e) {
						getSubCategoryRes=new SubCategoryRes();
				    	e.printStackTrace();
					}
					return getSubCategoryRes;

				}
		// ----------------------------SAVE SpCake Sup---------------------------
				@RequestMapping(value = { "/saveSpCakeSup" }, method = RequestMethod.POST)
				public @ResponseBody Info saveSpCakeSup(@RequestBody SpCakeSupplement spCakeSupplement) {

					SpCakeSupplement spCakeSupplementRes = null;
					Info info = new Info();
					try {

						spCakeSupplementRes = spCakeService.saveSpCakeSup(spCakeSupplement);

						if (spCakeSupplementRes != null) {
							info.setError(false);
							info.setMessage("SpCakeSupplement Saved Successfully.");
							
							try {
							    List<String> frTokens=franchiseSupRepository.findTokens();

							 for(String token:frTokens) {
					          Firebase.sendPushNotifForCommunication(token,"Special Cake Details Updated","Changes have been made in OPS at item level, SP level, in the rates. Kindly refer the OPS for exact changes made.","updateList");
							 }
					         }
					         catch(Exception e2)
					         {
						       e2.printStackTrace();
					         }
						} else {
							info.setError(true);
							info.setMessage("SpCakeSupplement Not Saved .");
						}

					} catch (Exception e) {

						info.setError(true);
						info.setMessage("SpCakeSupplement Not Saved");

						e.printStackTrace();
						System.out.println("Exception In MasterController /saveSpCakeSup" + e.getMessage());

					}
					return info;

				}
		 //---------------------------------------------------------------------------
		// ------------------------Delete SpCake Sup------------------------------------
		@RequestMapping(value = { "/deleteSpCakeSup" }, method = RequestMethod.POST)
		public @ResponseBody Info deleteSpCakeSup(@RequestParam("id") List<Integer> id) {

			Info info = spCakeService.deleteSpCakeSup(id);
			return info;
		}
        //------------------------------------------------------------------------
		// ------------------------------------------------------------
		@RequestMapping(value = { "/updateItemHsnAndPer" }, method = RequestMethod.POST)
		public @ResponseBody Info updateItemHsnAndPer(@RequestParam("items") List<Integer> items,@RequestParam("itemHsncd")String itemHsncd,@RequestParam("itemTax1")double itemTax1,@RequestParam("itemTax2")double itemTax2,@RequestParam("itemTax3")double itemTax3) {
			Info info=null;
			try {
				System.err.println(items+"hsn"+itemHsncd+"t1"+itemTax1+"t2"+itemTax2+"t3"+itemTax3);
			if(!items.isEmpty()) {				System.err.println(items+"hsn"+itemHsncd+"t1"+itemTax1+"t2"+itemTax2+"t3"+itemTax3);
 				
			for(Integer id:items) {
					System.err.println(id+"hsn"+itemHsncd+"t1"+itemTax1+"t2"+itemTax2+"t3"+itemTax3);

			     int isUpdate=itemRepository.updateItemHsnAndPerInItem(id,itemTax1,itemTax2,itemTax3);
			     try { 
					 int isUpdated = itemSuppRepository.updateItemHsnAndPerInSup(id,itemHsncd);
				 }catch (Exception e) {
						e.printStackTrace();
					}
				    
				}
				info=new Info();
				info.setError(false);
				info.setMessage("Updated");
			}

		
			}
			catch (Exception e) {
				e.printStackTrace();
				info=new Info();
				info.setError(true);
				info.setMessage("Updation Failed");
			}
			return info;
		}
        //------------------------------------------------------------------------
		
		// ------------------------Delete ItemSup------------------------------------
		@RequestMapping(value = { "/deleteItemSup" }, method = RequestMethod.POST)
		public @ResponseBody Info deleteItemSup(@RequestParam("id") List<String>  itemId) {

			Info info = itemService.deleteItemSup(itemId);
			return info;
		}
        //------------------------------------------------------------------------
		// ---------------------------Getting ItemSup List-----------------------
		@RequestMapping(value = { "/getItemSupList" }, method = RequestMethod.GET)
		public @ResponseBody ItemSupList getItemSupList() {

			ItemSupList itemSupList = itemService.getItemSupList();

			return itemSupList;

		}
		//------------------------------------------------------------------------
		// ---------------------------Getting SpCakeSup List-----------------------
		@RequestMapping(value = { "/getSpCakeSuppList" }, method = RequestMethod.GET)
		public @ResponseBody List<GetSpCkSupplement> getSpCakeSupList() {

			List<GetSpCkSupplement> spCakeSupplementList = spCakeService.getSpCakeSupList();

			return spCakeSupplementList;

		}
		//------------------------------------------------------------------------
		// ---------------------------Getting SpCakeList List-----------------------
				@RequestMapping(value = { "/getSpCakeList" }, method = RequestMethod.GET)
				public @ResponseBody List<SpCake> getSpCakeList() {

					List<SpCake> spCakeList;
					try {
					 spCakeList = spCakeListRepository.getSpCakeList();
					}
					catch(Exception e)
					{
						spCakeList=new ArrayList<>();
						e.printStackTrace();
					}
					return spCakeList;

				}
				//------------------------------------------------------------------------
		// ------------------------Getting One ItemSup by Id-----------------------
		@RequestMapping(value = { "/getItemSup" }, method = RequestMethod.POST)
		public @ResponseBody GetItemSup getItemSup(@RequestParam("id") int id) {

			GetItemSup getItemSupRes = null;
			try {
				getItemSupRes = itemService.getItemSup(id);

				if (getItemSupRes != null) {
					getItemSupRes.setError(false);
					getItemSupRes.setMessage("ItemSup Found Successfully");
				} else {
					getItemSupRes = new GetItemSup();
					getItemSupRes.setError(true);
					getItemSupRes.setMessage("ItemSup Not Found");
				}
			} catch (Exception e) {
				getItemSupRes = new GetItemSup();
				getItemSupRes.setError(true);
				getItemSupRes.setMessage("ItemSup Not Found");
				System.out.println("Exception In getItemSup:" + e.getMessage());
			}

			return getItemSupRes;

		}
		@RequestMapping(value = { "/getItemSupByItemId" }, method = RequestMethod.POST)
		public @ResponseBody GetItemSup getItemSupByItemId(@RequestParam("itemId") int itemId) {

			GetItemSup getItemSupRes = null;
			try {
				getItemSupRes = itemService.getItemSupByItemId(itemId);

				if (getItemSupRes != null) {
					getItemSupRes.setError(false);
					getItemSupRes.setMessage("ItemSup Found Successfully");
				} else {
					getItemSupRes = new GetItemSup();
					getItemSupRes.setError(true);
					getItemSupRes.setMessage("ItemSup Not Found");
				}
			} catch (Exception e) {
				getItemSupRes = new GetItemSup();
				getItemSupRes.setError(true);
				getItemSupRes.setMessage("ItemSup Not Found");
				System.out.println("Exception In getItemSup:" + e.getMessage());
			}

			return getItemSupRes;

		}
		// ------------------------Getting One SpCakeSup by Id-----------------------
				@RequestMapping(value = { "/getSpCakeSupp" }, method = RequestMethod.POST)
				public @ResponseBody GetSpCkSupplement getSpCakeSupp(@RequestParam("id") int id) {

					GetSpCkSupplement getSpCkSupRes = null;
					try {
						getSpCkSupRes = spCakeService.getSpCakeSupp(id);

						if (getSpCkSupRes != null) {
							getSpCkSupRes.setError(false);
							getSpCkSupRes.setMessage("GetSpCkSupplement Found Successfully");
						} else {
							getSpCkSupRes = new GetSpCkSupplement();
							getSpCkSupRes.setError(true);
							getSpCkSupRes.setMessage("GetSpCkSupplement Not Found");
						}
					} catch (Exception e) {
						getSpCkSupRes = new GetSpCkSupplement();
						getSpCkSupRes.setError(true);
						getSpCkSupRes.setMessage("GetSpCkSupplement Not Found");
						System.out.println("Exception In getSpCakeSupp:" + e.getMessage());
					}

					return getSpCkSupRes;

				}
				// ------------------------Getting One SpCakeSup by Id-----------------------
				@RequestMapping(value = { "/getSpCakeSupplement" }, method = RequestMethod.POST)
				public @ResponseBody GetSpCkSupplement getSpCakeSupplement(@RequestParam("id") int id) {

					GetSpCkSupplement getSpCkSupRes = null;
					try {
						getSpCkSupRes = getSpCakeSupRepository.getSpCakeSupplement(id);

						if (getSpCkSupRes != null) {
							getSpCkSupRes.setError(false);
							getSpCkSupRes.setMessage("GetSpCkSupplement Found Successfully");
						} else {
							getSpCkSupRes = new GetSpCkSupplement();
							getSpCkSupRes.setError(true);
							getSpCkSupRes.setMessage("GetSpCkSupplement Not Found");
						}
					} catch (Exception e) {
						getSpCkSupRes = new GetSpCkSupplement();
						getSpCkSupRes.setError(true);
						getSpCkSupRes.setMessage("GetSpCkSupplement Not Found");
						System.out.println("Exception In getSpCakeSupp:" + e.getMessage());
					}

					return getSpCkSupRes;

				}

	// ----------------------------SAVE FranchiseSup---------------------------
		@RequestMapping(value = { "/saveFranchiseSup" }, method = RequestMethod.POST)
		public @ResponseBody Info saveFranchiseSup(@RequestBody FranchiseSup franchiseSup) {

			FranchiseSup franchiseSupRes = null;
			Info info = new Info();
			try {

				franchiseSupRes = franchiseeService.saveFranchiseSup(franchiseSup);

				if (franchiseSupRes != null) {
					info.setError(false);
					info.setMessage("FranchiseSup Saved Successfully.");
				} else {
					info.setError(true);
					info.setMessage("FranchiseSup Not Saved .");
				}

			} catch (Exception e) {

				info.setError(true);
				info.setMessage("FranchiseSup Not Saved .");

				e.printStackTrace();
				System.out.println("Exception In MasterController /saveFranchiseSup" + e.getMessage());

			}
			return info;

		}
      //---------------------------------------------------------------------------
	// ------------------------Delete FranchiseSup------------------------------------
				@RequestMapping(value = { "/deleteFranchiseSup" }, method = RequestMethod.POST)
				public @ResponseBody Info deleteFranchiseSup(@RequestParam int frId) {

					Info info = franchiseeService.deleteFranchiseSup(frId);
					return info;
				}
	 //------------------------------------------------------------------------
				
	// ---------------------------Getting FranchiseSup List-----------------------
				@RequestMapping(value = { "/getFranchiseSupList" }, method = RequestMethod.GET)
				public @ResponseBody FranchiseSupList getFranchiseSupList() {

					FranchiseSupList franchiseSupList = franchiseeService.getFranchiseSupList();

					return franchiseSupList;

				}
	//------------------------------------------------------------------------	
		// ------------------------Getting One FranchiseSup by Id-----------------------
				@RequestMapping(value = { "/getFranchiseSup" }, method = RequestMethod.POST)
				public @ResponseBody FranchiseSup getFranchiseSup(@RequestParam("id") int id) {

					FranchiseSup getFranchiseSupRes = null;
					try {
						getFranchiseSupRes = franchiseeService.getFranchiseSup(id);

						if (getFranchiseSupRes != null) {
							getFranchiseSupRes.setError(false);
							getFranchiseSupRes.setMessage("FranchiseSup Found Successfully");
						} else {
							getFranchiseSupRes = new FranchiseSup();
							getFranchiseSupRes.setError(true);
							getFranchiseSupRes.setMessage("FranchiseSup Not Found");
						}
					} catch (Exception e) {
						getFranchiseSupRes = new FranchiseSup();
						getFranchiseSupRes.setError(true);
						getFranchiseSupRes.setMessage("FranchiseSup Not Found");
						System.out.println("Exception In getFranchiseSup:" + e.getMessage());
					}

					return getFranchiseSupRes;

				}
				// ----------------------------SAVE FranchiseSup---------------------------
				@RequestMapping(value = { "/saveFrTarget" }, method = RequestMethod.POST)
				public @ResponseBody Info saveFrTarget(@RequestBody List<FrTarget> frTargetList) {

					Info	info = franchiseeService.saveFrTarget(frTargetList);

					return info;

				}
		      //---------------------------------------------------------------------------	
				// ---------------------------Getting FrTarget List-----------------------
				@RequestMapping(value = { "/getFrTargetList" }, method = RequestMethod.POST)
				public @ResponseBody FrTargetList getFrTargetList(@RequestParam("frId")int frId,@RequestParam("year")int year) {

					FrTargetList frTargetList = franchiseeService.getFrTargetList(frId,year);

					return frTargetList;

				}
	        //------------------------------------------------------------------------	
				// Get Items
				@RequestMapping(value = "/getItemsByIsAllowBday", method = RequestMethod.GET)
				public @ResponseBody List<Item> getItemsByIsAllowBday() {

					List<Item> items = itemService.getItemsByIsAllowBday();
					return items;

				}
				// ---------------------------Getting TotalFrSale List-----------------------
				@RequestMapping(value = { "/getFrTotalSale" }, method = RequestMethod.POST)
				public @ResponseBody FrTotalSale getFrTotalSale(@RequestParam("frId")int frId,@RequestParam("month")int month,@RequestParam("year")int year) {

					System.out.println("frId"+frId);
					FrTotalSale frTotalSale = franchiseeService.getFrTargetList(frId,month,year);

					return frTotalSale; 

				}
	        //------------------------------------------------------------------------		
				// --------------------------------Update Fr Admin password------------------
				@RequestMapping(value = { "/updateAdminPwd" }, method = RequestMethod.POST)
				public @ResponseBody Info updateAdminPwd(@RequestParam("frId")int frId,@RequestParam("adminPwd")String adminPwd) {

					Info info = franchiseeService.updateAdminPwd(frId,adminPwd);

					return info; 

				}
	        //------------------------------------------------------------------------			
				// ------------------------Update FranchiseSup Passwords------------------------------------
				@RequestMapping(value = { "/updateFranchiseSupUsrPwd" }, method = RequestMethod.POST)
				public @ResponseBody Info updateFranchiseUsrPwd(@RequestParam int frId,@RequestParam String pass2,@RequestParam String pass3) {

					Info info = franchiseeService.updateFranchiseSupUsrPwd(frId,pass2,pass3);
					return info;
				}
	 //------------------------------------------------------------------------				
				// ------------------------Getting One FranchiseSup by Id-----------------------
				@RequestMapping(value = { "/getFrSupByFrId" }, method = RequestMethod.POST)
				public @ResponseBody FranchiseSup getFrSupByFrId(@RequestParam("frId") int frId) {

					FranchiseSup getFranchiseSupRes = null;
					try {
						getFranchiseSupRes = franchiseeService.getFrSupByFrId(frId);

						if (getFranchiseSupRes != null) {
							getFranchiseSupRes.setError(false);
							getFranchiseSupRes.setMessage("FranchiseSup Found Successfully");
						} else {
							getFranchiseSupRes = new FranchiseSup();
							getFranchiseSupRes.setError(true);
							getFranchiseSupRes.setMessage("FranchiseSup Not Found");
						}
					} catch (Exception e) {
						getFranchiseSupRes = new FranchiseSup();
						getFranchiseSupRes.setError(true);
						getFranchiseSupRes.setMessage("FranchiseSup Not Found");
						System.out.println("Exception In getFranchiseSup:" + e.getMessage());
					}

					return getFranchiseSupRes;

				}		
				// ---------------------------Getting Franchise List For Supplement-----------------------
				@RequestMapping(value = { "/getFrListForSupp" }, method = RequestMethod.GET)
				public @ResponseBody List<FrListForSupp> getFrListForSupp() {

					List<FrListForSupp> franchiseSupList = frListForSuppRepository.getFrListForSupp();

					return franchiseSupList;

				}
	              //------------------------------------------------------------------------	
				// ------------------------Delete RegularSpOrder------------------------------------
				@RequestMapping(value = { "/deleteRegularSpOrder" }, method = RequestMethod.POST)
				public @ResponseBody Info deleteRegularSpOrder(@RequestParam int rspId) {

					Info info = regularSpCkOrderService.deleteRegularSpOrder(rspId);
					return info;
				}
	          //------------------------------------------------------------------------
				// ------------------------DeleteSpCkOrder------------------------------------
				@RequestMapping(value = { "/deleteSpCkOrder" }, method = RequestMethod.POST)
				public @ResponseBody Info deleteSpCkOrder(@RequestParam int spOrderNo) {

					int isDeleted =spCkDeleteOrderRepository.deleteSpCkOrder(spOrderNo);
					Info info=new Info();
					if(isDeleted==1)
					{
						info.setError(false);
						info.setMessage("SpCkOrder Deleted");
					}
					else
					{
						info.setError(true);
						info.setMessage("SpCkOrder Deletion Failed");
					}
					return info;
				}
	          //------------------------------------------------------------------------	
				// ------------------------Get Unique Franchise Code------------------------------------
				@RequestMapping(value = { "/getUnigueFrCode" }, method = RequestMethod.GET)
				public @ResponseBody Integer getUnigueFrCode() {

					int maxId =franchiseeRepository.getUnigueFrCode();
					
					return maxId;
				}
				
				// ------------------------Get Unique Sp Code------------------------------------
				@RequestMapping(value = { "/getUniqueSpCode" }, method = RequestMethod.GET)
				public @ResponseBody Integer getUniqueSpCode() {

					int maxId =spCakeListRepository.getUniqueSpCode();
					
					return maxId;
				}
	          //------------------------------------------------------------------------
				// ------------------------Get Unique Item Code------------------------------------
				@RequestMapping(value = { "/getUniqueItemCode" }, method = RequestMethod.GET)
				public @ResponseBody Integer getUniqueItemCode() {

					int maxId =itemService.getUniqueItemCode();
					
					return maxId;
				}
	          //------------------------------------------------------------------------
				// ------------------------Get TrayTypes------------------------------------
				@RequestMapping(value = { "/getTrayTypes" }, method = RequestMethod.GET)
				public @ResponseBody List<TrayType> getTrayTypes() {

					List<TrayType> trayTypes =itemService.getTrayTypes();
					
					return trayTypes;
				}
	          //------------------------------------------------------------------------
				// Get Items
				@RequestMapping(value = "/getItemsByCatIdForSup", method = RequestMethod.POST)
				public @ResponseBody List<Item> getItemsByCatIdForSup(@RequestParam String itemGrp1) {

					List<Item> items = itemService.getItemsByCatIdForSup(itemGrp1);
					return items;

				}		
				// Get Items By Category order by sub cat and sort id
				@RequestMapping(value = "/getItemsByCatIdForDisp", method = RequestMethod.POST)
				public @ResponseBody List<Item> getItemsByCatIdForDisp(@RequestParam List<String> catIdList) {

					List<Item> items=null;
					try {
					 items = itemRepository.findByItemGrp2InAndDelStatusOrderByItemGrp2AscItemNameAsc(catIdList,0);
					 System.err.println(items.toString()+"items");
					}/*findByItemGrp1InAndDelStatusOrderByItemGrp2AscItemSortIdAsc*/
					catch(Exception e)
					{
						items=new ArrayList<>();
						e.printStackTrace();
						
					}
					return items;

				}
				// Get SubCategories
				@RequestMapping(value = "/getSubCatList")
				public @ResponseBody List<SubCategory> getAllSubCategories(@RequestParam List<String> catId) {

					List<SubCategory> subCategoryList;
					try {
					 subCategoryList = subCategoryRepository.findByCatIdInAndDelStatus(catId);
					}
					catch (Exception e) {
						subCategoryList=new ArrayList<>();
						e.printStackTrace();

					}
					return subCategoryList;

				}
				@RequestMapping(value = "/getSubCatListForDis")
				public @ResponseBody List<SubCategory> getSubCatListForDis(@RequestParam List<Integer> catId) {

					List<SubCategory> subCategoryList=null;
					try {
					 subCategoryList = subCategoryRepository.findBySubCatIdInAndDelStatus(catId,0);
					}
					catch (Exception e) {
						subCategoryList=new ArrayList<>();
						e.printStackTrace();

					}
					return subCategoryList;

				}
				// Get SubCategories
				@RequestMapping(value = "/getAllSubCatList", method = RequestMethod.GET)
				public @ResponseBody List<SubCategory> getAllSubCatList() {

					List<SubCategory> subCategoryList;
					try {
					 subCategoryList = subCategoryRepository.findAllSubCategories();
					}
					catch (Exception e) {
						subCategoryList=new ArrayList<>();
						e.printStackTrace();

					}
					return subCategoryList;

				}
				@RequestMapping(value = { "/getRegSpCakeOrderHistory" }, method = RequestMethod.POST)
				@ResponseBody
				public List<GetRegSpCakeOrders> getRegSpCakeOrderHistory(
						@RequestParam String spDeliveryDt,@RequestParam int  frId,@RequestParam List<String> catId) {
					List<GetRegSpCakeOrders> regSpCakeOrder = regularSpCkOrderService.getRegSpCakeOrderHistory(spDeliveryDt, frId,catId);
					return regSpCakeOrder;
				}
				  public static boolean contains(int[] arr, int item) {
				      for (int n : arr) {
				         if (item == n) {
				            return true;
				         }
				      }
				      return false;
				   }
				@RequestMapping(value = "/updateConfiguredItems", method = RequestMethod.POST)
				public @ResponseBody Info updateConfiguredItems(@RequestParam List<String> frIdList,@RequestParam int menuId,@RequestParam List<String> itemIdList,@RequestParam int catId)
				{
					Info info=new Info();
					try {
						for(String frId:frIdList)
						{
							
						 ConfigureFranchisee configureFr=configureFrRepository.findByFrIdAndMenuIdAndDelStatus(Integer.parseInt(frId),menuId,0);
						
						 if(configureFr!=null) {
						 String itemShow=configureFr.getItemShow();
						 int[] intArray = null;
						 try {
						  intArray = Arrays.stream(itemShow.split(","))
								    .mapToInt(Integer::parseInt)
								    .toArray();
						 }
						 catch (Exception e) {
							e.printStackTrace();
						}
						  for(String itemId:itemIdList)
						  {
							  if(intArray.length!=0)
							  {
							  if(!contains(intArray, Integer.parseInt(itemId)))
							  {
						     	itemShow=itemShow+","+itemId;
							  }
							  }
						  }
						  configureFr.setItemShow(itemShow);
						  
						  ConfigureFranchisee configureFranchiseeReport=configureFrRepository.save(configureFr);
						 
						  try {

							  PostFrItemStockHeader stockHeader=postFrOpStockHeaderRepository.findByFrIdAndCatIdAndIsMonthClosed(Integer.parseInt(frId),catId,0);

							  if(stockHeader!=null)
							  {				  

							  for(String itemId:itemIdList)
							  {
								 
								  PostFrItemStockDetail stockDetailRes=postFrOpStockDetailRepository.findByOpeningStockHeaderIdAndItemId(stockHeader.getOpeningStockHeaderId(),Integer.parseInt(itemId));
							  
								  if(stockDetailRes==null)
									  {
									    PostFrItemStockDetail stockDetail=new PostFrItemStockDetail();
							            stockDetail.setOpeningStockHeaderId(stockHeader.getOpeningStockHeaderId());
							            stockDetail.setItemId(Integer.parseInt(itemId));		  
							            postFrOpStockDetailRepository.save(stockDetail);
									  }
							  }
							  }
							  
						  }catch (Exception e) {
							e.printStackTrace();
						}
						 }
						  
						}
						info.setError(false);
						info.setMessage("CF Updated");
					}catch (Exception e) {
						e.printStackTrace();
						info.setError(true);
						info.setMessage("CF Updation Failed");
					}
					
					return info;
				}	
				@Autowired
				private ConfigureFranchiseeService configureService;
		
		       //--------------------------------------------------------------------
				@RequestMapping(value = "/saveFrMenuConfigure", method = RequestMethod.POST)
				public @ResponseBody Info saveFrMenuConfigure(@RequestParam List<String> frIdList,@RequestParam List<String> menuIdList)
				{
					Info info=new Info();
					int currentYear=Calendar.getInstance().get(Calendar.YEAR);    
					System.err.println("1 currentYear="+currentYear);
					int currentMonth=Calendar.getInstance().get(Calendar.MONTH ) + 1;  
					System.err.println("2 currentMonth="+currentMonth);
					try {
						System.err.println("3 try main");
						for(int i=0;i<frIdList.size();i++)
						{
							System.err.println("###  ###");
							for(int j=0;j<menuIdList.size();j++)
							{
								System.err.println("***  ***");
								FrMenuConfigure prevFrMenuConfigure=frMenuConfigureRepository.findByFrIdAndMenuIdAndIsDel(Integer.parseInt(frIdList.get(i)),Integer.parseInt(menuIdList.get(j)),0);
								System.err.println("4 prevFrMenuConfigure"+prevFrMenuConfigure);
								if(prevFrMenuConfigure==null) {
									
								FrMenuConfigure frMenu=new FrMenuConfigure();
								frMenu.setSettingId(0);
								frMenu.setFrId(Integer.parseInt(frIdList.get(i)));
								frMenu.setMenuId(Integer.parseInt(menuIdList.get(j)));
								frMenu.setIsDel(0);
								System.err.println("5 frMenu"+frMenu.toString());
								FrMenuConfigure frMenuConfigure=frMenuConfigureRepository.save(frMenu);
								System.err.println("6 frMenuConfigure afer insert"+frMenuConfigure.toString());
								}
								
							}
						}
						info.setError(false);
						info.setMessage("Menu Configured");
						System.err.println("7 info"+info.toString());
						for(int i=0;i<frIdList.size();i++)
						{
							System.err.println("### ###");
							for(int j=0;j<menuIdList.size();j++)	
							{
								System.err.println("1111111  j"+j);
								ConfigureFranchisee configureFranchisee = configureService.findFranchiseeById(Integer.parseInt(menuIdList.get(j)));
								System.err.println("8 configureFranchisee"+configureFranchisee.toString());
								NewSetting	newSetting = newSettingRepository.findBySettingKeyAndDelStatus("cat_id_open_stock",0);
								List<Integer> catIdForStock= Stream.of(newSetting.getSettingValue1().split(","))
						                .map(Integer::parseInt)
						                .collect(Collectors.toList());
								List<PostFrItemStockHeader> prevStockHeader=postFrOpStockHeaderRepository.findByFrIdAndIsMonthClosedAndCatId(Integer.parseInt(frIdList.get(i)),0,configureFranchisee.getCatId());
								System.err.println("9 prevStockHeader"+prevStockHeader);
								if (catIdForStock.contains(configureFranchisee.getCatId())) {

								if(prevStockHeader.size()==0)
								{
									PostFrItemStockHeader postFrItemStockHeader = new PostFrItemStockHeader();
									postFrItemStockHeader.setOpeningStockHeaderId(0);
									postFrItemStockHeader.setFrId(Integer.parseInt(frIdList.get(i)));
									postFrItemStockHeader.setCatId(configureFranchisee.getCatId());
									postFrItemStockHeader.setYear(currentYear);
									postFrItemStockHeader.setMonth(currentMonth);
									postFrItemStockHeader.setIsMonthClosed(0);
									System.err.println("10 postFrItemStockHeader"+postFrItemStockHeader.toString());
							PostFrItemStockHeader postFrItemStockHeaderRes = postFrOpStockHeaderRepository.save(postFrItemStockHeader);
							System.err.println("11 after insert postFrItemStockHeader --"+postFrItemStockHeaderRes.toString());
							
									List<PostFrItemStockDetail> postFrItemStockDetailList = new ArrayList<PostFrItemStockDetail>();
									List<Integer> ids = Stream.of(configureFranchisee.getItemShow().split(","))
							                .map(Integer::parseInt)
							                .collect(Collectors.toList());
									System.err.println("12 ids --"+ids.toString());

									List<Item> itemsList = itemService.findAllItemsByItemId(ids);
									System.err.println("13 itemsList --"+itemsList.toString());
									for (int k = 0; k < itemsList.size(); k++) {

										    PostFrItemStockDetail	postFrItemStockDetail = new PostFrItemStockDetail();
											postFrItemStockDetail.setOpeningStockHeaderId(postFrItemStockHeaderRes.getOpeningStockHeaderId());
											postFrItemStockDetail.setOpeningStockDetailId(0);
											postFrItemStockDetail.setRegOpeningStock(0);
										    postFrItemStockDetail.setItemId(itemsList.get(k).getId());
										    postFrItemStockDetail.setRemark("");
										    postFrItemStockDetailList.add(postFrItemStockDetail);
										    System.err.println("14 postFrItemStockDetail --"+postFrItemStockDetail.toString());
									}
									   System.err.println("15 postFrItemStockDetailList --"+postFrItemStockDetailList.toString());
								    postFrOpStockDetailRepository.save(postFrItemStockDetailList);

								}else
								{
									List<PostFrItemStockDetail> postFrItemStockDetailList = new ArrayList<PostFrItemStockDetail>();
									List<Integer> ids = Stream.of(configureFranchisee.getItemShow().split(","))
							                .map(Integer::parseInt)
							                .collect(Collectors.toList());
									  System.err.println("16 ids --"+ids.toString());
									List<Item> itemsList = itemService.findAllItemsByItemId(ids);
									  System.err.println("17 itemsList --"+itemsList.toString());
									for (int k = 0; k < itemsList.size(); k++) {

										PostFrItemStockDetail	prevFrItemStockDetail=postFrOpStockDetailRepository.findByItemIdAndOpeningStockHeaderId(itemsList.get(k).getId(),prevStockHeader.get(0).getOpeningStockHeaderId());
										  System.err.println("18 prevFrItemStockDetail --"+prevFrItemStockDetail);
										if(prevFrItemStockDetail==null) {
										    PostFrItemStockDetail	postFrItemStockDetail = new PostFrItemStockDetail();
											postFrItemStockDetail.setOpeningStockHeaderId(prevStockHeader.get(0).getOpeningStockHeaderId());//first stock header (month closed 0 status))
											postFrItemStockDetail.setOpeningStockDetailId(0);
											postFrItemStockDetail.setRegOpeningStock(0);
										    postFrItemStockDetail.setItemId(itemsList.get(k).getId());
										    postFrItemStockDetail.setRemark("");
										    postFrItemStockDetailList.add(postFrItemStockDetail);
										    System.err.println("19 postFrItemStockDetail --"+postFrItemStockDetail.toString());
										 }
									}
								    postFrOpStockDetailRepository.save(postFrItemStockDetailList);
								    System.err.println("20 postFrItemStockDetailList --"+postFrItemStockDetailList.toString());
								}
								}
								
						
							}
						}
					}catch (Exception e) {
						e.printStackTrace();
						info.setError(true);
						info.setMessage("Menu Configuration Failed");
					}
					
					return info;
					
					/*PostFrItemStockHeader postFrItemStockHeaders = new PostFrItemStockHeader();
					List<PostFrItemStockHeader> postFrItemStockHeaderList = new ArrayList<PostFrItemStockHeader>();

					postFrItemStockHeaders = postFrOpStockHeaderRepository.save(postFrItemStockHeader);
					postFrItemStockHeaderList.add(postFrItemStockHeaders);
					int headerId = postFrItemStockHeader.getOpeningStockHeaderId();

					List<PostFrItemStockDetail> PostFrItemStockDetailList = postFrItemStockHeader.getPostFrItemStockDetailList();

					for (int j = 0; j < PostFrItemStockDetailList.size(); j++) {

						PostFrItemStockDetail postFrItemStockDetail = PostFrItemStockDetailList.get(j);

						postFrItemStockDetail.setOpeningStockHeaderId(headerId);

						postFrOpStockDetailRepository.save(postFrItemStockDetail);

					}*/

				}
				@RequestMapping(value = "/updateOrderDetails", method = RequestMethod.POST)
				public @ResponseBody Info updateOrderDetails(@RequestParam List<Integer> orderIds,@RequestParam String delDate,@RequestParam String prodDate)
				{
					Info info=new Info();
					 DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
						 System.err.println(orderIds.toString());
						 Date dateDel = new Date();
						 Date dateProd = new Date();
						 try {
							 dateDel = df.parse(delDate);
							 dateProd=df.parse(prodDate);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						int isUpdated=orderRepository.updateOrderDelivery(orderIds,dateDel,dateProd);
						if(isUpdated>0)
						{
							info.setError(false);
							info.setMessage("Order Updated Successfully");
						}else
						{
							info.setError(true);
							info.setMessage("Orders Not Updated");
						}
						
					
					
					return info;
				}
				
				
				@RequestMapping(value = "/getFrMenuConfigureList", method = RequestMethod.GET)
				public @ResponseBody List<GetFrMenuConfigure> getFrMenuConfigureList() {

					List<GetFrMenuConfigure> confList;
					try {
						confList = getFrMenuConfigureRepository.getFrMenuConfigureList();
					}
					catch (Exception e) {
						confList=new ArrayList<>();
						e.printStackTrace();

					}
					return confList;

				}
				// ------------------------DeleteSpCkOrder------------------------------------
				@RequestMapping(value = { "/deleteFrConfMenu" }, method = RequestMethod.POST)
				public @ResponseBody Info deleteFrConfMenu(@RequestParam int settingId) {

					int isDeleted =frMenuConfigureRepository.deleteFrConfMenu(settingId);
					Info info=new Info();
					if(isDeleted==1)
					{
						info.setError(false);
						info.setMessage("Menu Conf Deleted");
					}
					else
					{
						info.setError(true);
						info.setMessage("Menu Conf Deletion Failed");
					}
					return info;
				}		
				@RequestMapping(value = { "/postFrOpStockDetailList" }, method = RequestMethod.POST)
				public @ResponseBody List<PostFrItemStockDetail>  postFrOpStockDetailList(@RequestBody List<PostFrItemStockDetail>  detailList)
						throws ParseException, JsonParseException, JsonMappingException, IOException {

					System.out.println("Data Common " + detailList.toString());

					List<PostFrItemStockDetail> details = postFrOpStockDetailRepository.save(detailList);

				
					return details;

				}
				@RequestMapping(value = "/getItemListForMOrder", method = RequestMethod.POST)
				public @ResponseBody List<ItemForMOrder> getItemListForMOrder(@RequestParam("itemGrp1")int itemGrp1,@RequestParam("frId")int frId,@RequestParam("menuId")int menuId,@RequestParam("ordertype")int ordertype,@RequestParam("prodDate")String prodDate) {

					List<ItemForMOrder> itemList;
					try {
						if(ordertype==0)
						{
							System.err.println("itemGrp1"+itemGrp1+"frId"+menuId+"ordertype"+ordertype+"prodDate"+prodDate);
					    	itemList = itemRepositoryForMOrderRepository.getItemListForMOrder(itemGrp1,frId,menuId,prodDate);
						}
						else if(ordertype==2)
						{
							itemList = itemRepositoryForMOrderRepository.getItemListForMOrderMul(itemGrp1);

						}else
						{
							itemList = itemRepositoryForMOrderRepository.getItemListForMOrderPrev(itemGrp1,frId);

						}
					}
					catch (Exception e) {
						itemList=new ArrayList<>();
						e.printStackTrace();

					}
					return itemList;

				}
				
				@RequestMapping(value = { "/getItemsByMenuId" }, method = RequestMethod.POST)
				public @ResponseBody  List<ItemIdOnly> finditmsByMenuIdIn(@RequestParam("menuId") int menuId) {
					 
					List<ItemIdOnly> itemList = itemIdOnlyRepository.finditmsMenuIdIn(0,menuId);
							  
							  System.out.println("itemList" +itemList.toString());
					return itemList;
				}
				@RequestMapping(value = { "/getItemsByMenuIdMultiple" }, method = RequestMethod.POST)
				public @ResponseBody  List<ItemIdOnly> getItemsByMenuIdMultiple(@RequestParam("menuId") List<Integer> menuId) {
					 System.out.println("menuId" +menuId);
					
					List<ItemIdOnly> itemList;
							  itemList = itemIdOnlyRepository.finditmsMenuIdInMultiple(0,menuId);
							  
							  System.out.println("itemList" +itemList.toString());
					return itemList;
				}
				
				
				@RequestMapping(value = { "/getCatidByMenuId" }, method = RequestMethod.POST)
				public @ResponseBody  List<MCategory> findCatidByMenuIdIn(@RequestParam("menuId") int menuId) {
					List<MCategory> catlist;
					catlist = categoryRepository.findCatidByMenuIdIn(menuId);
							  
							  System.out.println("itemList" +catlist.toString());
					return catlist;
				}
				@RequestMapping(value = "/generateSpBillOps", method = RequestMethod.POST)
				public @ResponseBody Boolean generateSpBillOps(@RequestParam int spOrderNo,@RequestParam String invoiceNo,@RequestParam int frId)
				{
					Boolean msg=false;
					int isUpdated=spCakeOrdersRepository.generateSpBillOps(spOrderNo,invoiceNo);
					FrSetting frSetting=frSettingRepo.findByFrId(frId);
				    int	updateResponse = frSettingRepo.updateFrSettingBillNo((frSetting.getSellBillNo()+1), frId);
						if(updateResponse>0)
						{
							msg=true;
						}
					return msg;
				}
				
				@RequestMapping(value = { "/findNewSettingByKey" }, method = RequestMethod.POST)
				public @ResponseBody NewSetting findNewSettingByKey(@RequestParam("settingKey") String settingKey) {
					
					NewSetting	newSetting = newSettingRepository.findBySettingKeyAndDelStatus(settingKey,0);
							  
					return newSetting;
				}
				
				
				@RequestMapping(value = { "/saveFlavourConf" }, method = RequestMethod.POST)
				public @ResponseBody List<FlavourConf> saveFlavourConf(@RequestBody List<FlavourConf> flavourConfList) {

					List<FlavourConf> flList = new ArrayList<FlavourConf>();
					try {
                        for(FlavourConf flavourConf:flavourConfList)
                        {
                        	FlavourConf isPresent=flavourConfRepository.findByDelStatusAndSpfIdAndSpId(0,flavourConf.getSpfId(),flavourConf.getSpId());
                        	if(isPresent!=null)
                        	{
                        	    flavourConf.setFlavId(isPresent.getFlavId());
                        	    FlavourConf flr= flavourConfRepository.save(flavourConf);
                        	    flList.add(flr);
                        	}else
                        	{
                        		 FlavourConf flr= flavourConfRepository.save(flavourConf);
                          	     flList.add(flr);
                        	}
                        }
						
					} catch (Exception e) {

						e.printStackTrace();
					
					}
					return flList;
				}
				@RequestMapping(value = "/getAllFlConf", method = RequestMethod.GET)
				public @ResponseBody List<FlavourConf> getAllFlConf() {

					List<FlavourConf> flList;
					try {
						flList = flavourConfRepository.findByDelStatus(0);
					}
					catch (Exception e) {
						flList=new ArrayList<>();
						e.printStackTrace();

					}
					return flList;

				}
				@RequestMapping(value = "/getFlConfByIds", method = RequestMethod.POST)
				public @ResponseBody FlavourConf getFlConfByIds(@RequestParam("spfId") int  spfId,@RequestParam("spId") int  spId) {

					FlavourConf flavour=new FlavourConf();
					try {
						flavour = flavourConfRepository.findBySpIdAndSpfIdAndDelStatus(spId,spfId,0);
					}
					catch (Exception e) {
						flavour=new FlavourConf();
						e.printStackTrace();

					}
					return flavour;

				}
				@RequestMapping(value ="/updateFlavourConf", method = RequestMethod.POST)
				public Info updateFlavourConf(@RequestParam("flavId") int flavId, @RequestParam("rate") float rate,@RequestParam("mrp") float mrp)
				{
					Info info=new Info();
					try {
						int isUpdated=flavourConfRepository.updateFlavourConf(flavId,rate,mrp);
						if(isUpdated>0)
						{
							info.setError(false);
							info.setMessage("FlavourConf Updated Successfully.");
						}else
						{
							info.setError(true);
							info.setMessage("FlavourConf Updation Failed.");
						}
						
					}catch (Exception e) {
						e.printStackTrace();
					}
					
					return info;
				}
				@RequestMapping(value="/deleteFlavourConf", method=RequestMethod.POST)
				public @ResponseBody Info deleteFlavourConf(@RequestParam int flavId) {
					
					Info info =new Info();
					int isDelete = flavourConfRepository.deleteByFlavId(flavId);
					
					if(isDelete!=0) {
						info.setError(false);
						info.setMessage("Success");
					}else {
						info.setError(true);
						info.setMessage("Fail");
					}
					return info;
					
				}
				
				
				
}
