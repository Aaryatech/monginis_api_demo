package com.ats.webapi.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.commons.Common;
import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.RawMaterialUomList;
import com.ats.webapi.model.RmRateVerificationList;
import com.ats.webapi.model.rawmaterial.GetItemDetail;
import com.ats.webapi.model.rawmaterial.GetRawMaterialByGroup;
import com.ats.webapi.model.rawmaterial.GetRawMaterialDetailList;
import com.ats.webapi.model.rawmaterial.GetUomAndTax;
import com.ats.webapi.model.rawmaterial.ItemDetail;
import com.ats.webapi.model.rawmaterial.ItemDetailList;
import com.ats.webapi.model.rawmaterial.ItemSfHeader;
import com.ats.webapi.model.rawmaterial.ItemSfHeaderList;
import com.ats.webapi.model.rawmaterial.RawMaterialDetails;
import com.ats.webapi.model.rawmaterial.RawMaterialDetailsList;
import com.ats.webapi.model.rawmaterial.RawMaterialTaxDetails;
import com.ats.webapi.model.rawmaterial.RawMaterialTaxDetailsList;
import com.ats.webapi.model.rawmaterial.RawMaterialUom;
import com.ats.webapi.model.rawmaterial.RmItemCatList;
import com.ats.webapi.model.rawmaterial.RmItemCategory;
import com.ats.webapi.model.rawmaterial.RmItemGroup;
import com.ats.webapi.model.rawmaterial.RmItemSubCatList;
import com.ats.webapi.model.rawmaterial.RmItemSubCategory;
import com.ats.webapi.model.rawmaterial.RmRateVerification;
import com.ats.webapi.repository.GetRawMaterialByGroupRepository;
import com.ats.webapi.repository.RawMaterialDetailsRepository;
import com.ats.webapi.repository.RmItemGroupRepostitory;
import com.ats.webapi.repository.RmRateVerificationListRepository;
import com.ats.webapi.service.rawmaterial.RawMaterialService;
 
@RestController
@RequestMapping("/rawMaterial")
public class RawMaterialApiCotroller {

	@Autowired
	RawMaterialService rawMaterialService;
	@Autowired
	RawMaterialDetailsRepository rawMaterialDetailsRepository;
	@Autowired
	RmRateVerificationListRepository rmRateVerificationListRepository;
	
	//Sachin 09-12-2020
	@Autowired
	GetRawMaterialByGroupRepository getRawMaterialByGroupRepository;
	@Autowired
	RmItemGroupRepostitory rmItemGroupRepostitory;
	
	@RequestMapping(value = { "/getRawMaterialDetailByGroupSupp" }, method = RequestMethod.POST)
	public @ResponseBody List<GetRawMaterialByGroup> getRawMaterialDetailByGroupSupp(@RequestParam ("grpId")int grpId,@RequestParam ("suppId")int suppId)
	{
		List<GetRawMaterialByGroup> getRawMaterialByGroupList=getRawMaterialByGroupRepository.getRawMaterialDetailByGroupSupp(grpId,suppId);
		return getRawMaterialByGroupList;
		 
		
	}
	@RequestMapping(value = { "/getRmItemGroup" }, method = RequestMethod.POST)
	public @ResponseBody List<RmItemGroup> getRmItemGroup(@RequestParam("suppId")int suppId)
	{
		List<RmItemGroup> rmItemGroupList=rmItemGroupRepostitory.getGroupBySupp(suppId);
		return rmItemGroupList;
	}
	@RequestMapping(value = { "/getItemSfHeadersByDept" }, method = RequestMethod.GET)
	public @ResponseBody ItemSfHeaderList getItemSfHeadersByDept(int deptId)
	{
		List<ItemSfHeader> itemSfHeaders=rawMaterialService.getItemSfHeadersByDept(deptId);
		
		ItemSfHeaderList itemSfHeaderList=new ItemSfHeaderList();
		
		ErrorMessage errorMessage=new ErrorMessage();
		if(itemSfHeaders!=null)
		{
			errorMessage.setError(false);
			errorMessage.setMessage("ItemSfHeader List  Found successFully");
			itemSfHeaderList.setErrorMessage(errorMessage);
			itemSfHeaderList.setItemSfHeaderList(itemSfHeaders);
		}
		else
		{
			errorMessage.setError(true);
			errorMessage.setMessage("ItemSfHeader List Not Found.");
			itemSfHeaderList.setErrorMessage(errorMessage);
		}
		return itemSfHeaderList;
	}
	
	//----------------------Get Data Of Raw Material Item Categories---------------
	@RequestMapping(value = { "/showRmItemCategories" }, method = RequestMethod.GET)
	public @ResponseBody RmItemCatList showRmItemCategories() {

		RmItemCatList rmItemCatList=rawMaterialService.getRmItemCategories();
		    
			return rmItemCatList;
	  }
	//-------------------------END---------------------------------------------------
	
	//----------------------Get Data Of Raw Material Item SubCategories---------------
	@RequestMapping(value = { "/showRmItemSubCategories" }, method = RequestMethod.GET)
	public @ResponseBody RmItemSubCatList showRmItemSubCategories() {

		RmItemSubCatList rmItemSubCatList=rawMaterialService.getRmItemSubCategories();
		    
			return rmItemSubCatList;
	  }
	//--------------------------END--------------------------------------------------
	//----------------------Save Raw Material Item Category---------------
	@RequestMapping(value = { "/saveRmItemCategory" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage saveRmItemCategory(@RequestBody RmItemCategory rmItemCategory)
	{
		
		ErrorMessage errorMessage=rawMaterialService.saveItemCategory(rmItemCategory);
		
		return errorMessage;
	}
	//--------------------------END--------------------------------------------------
	
	//----------------------Save Raw Material Item Sub Category---------------
	@RequestMapping(value = { "/saveRmItemSubCategory" }, method = RequestMethod.POST)
		public @ResponseBody ErrorMessage saveRmItemSubCategory(@RequestBody RmItemSubCategory rmItemSubCategory)
		{
			
			ErrorMessage errorMessage=rawMaterialService.saveItemSubCategory(rmItemSubCategory);
			
			return errorMessage;
		}
		//--------------------------END--------------------------------------------------
	@RequestMapping(value = { "/deleteRmItemCategory" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteRmItemCategory(@RequestParam("catId")int catId)
	{
		
		ErrorMessage errorMessage=rawMaterialService.deleteRmItemCategory(catId);
		
		return errorMessage;
	}
	//--------------------------END--------------------------------------------------
	
	//--------------------------END--------------------------------------------------
	@RequestMapping(value = { "/deleteRmItemSubCategory" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage deleteRmItemSubCategory(@RequestParam("subCatId")int subCatId)
	{
		
		ErrorMessage errorMessage=rawMaterialService.deleteRmItemSubCategory(subCatId);
		
		return errorMessage;
	}
	//--------------------------END--------------------------------------------------
	
	//--------------------------GetOne Item Category By catId--------------------------------------------------
	@RequestMapping(value = { "/getRmItemCategory" }, method = RequestMethod.POST)
	public @ResponseBody RmItemCategory getRmItemCategory(@RequestParam("catId")int catId)
	{
		
		RmItemCategory rmItemCategory=rawMaterialService.getRmItemCategory(catId);
		
		return rmItemCategory;
	}
	//--------------------------END--------------------------------------------------
	
	//--------------------------GetOneBySubCatId--------------------------------------------------
	@RequestMapping(value = { "/getRmItemSubCategory" }, method = RequestMethod.POST)
	public @ResponseBody RmItemSubCategory getRmItemSubCategory(@RequestParam("subCatId")int subCatId)
	{
		
		RmItemSubCategory rmItemSubCategory=rawMaterialService.getRmItemSubCategory(subCatId);
		
		return rmItemSubCategory;
	}
	//--------------------------END--------------------------------------------------
	//--------------------------GetOneBySubCatId--------------------------------------------------
		@RequestMapping(value = { "/getRmItemSubCategories" }, method = RequestMethod.POST)
		public @ResponseBody List<RmItemSubCategory> getRmItemSubCategories(@RequestParam("catId")int catId)
		{
			
			List<RmItemSubCategory> rmItemSubCategories=rawMaterialService.getRmItemSubCategories(catId);
			
			return rmItemSubCategories;
		}
		//--------------------------END--------------------------------------------------
	
	
	
	//---------------------------addNew RM Master----------------------------------
	
	@RequestMapping(value = { "/addRawMaterial" }, method = RequestMethod.POST)
	public @ResponseBody RawMaterialDetails addRawMaterial(@RequestBody RawMaterialDetails rawMaterialDetails)
	{
		System.out.println("Data  : "+rawMaterialDetails.toString());
		RawMaterialDetails info=rawMaterialService.addRawMaterial(rawMaterialDetails);
		return info;
		
	}
	//---------------------Delete RM Master----------------------------------
	
	@RequestMapping(value = { "/deleteRawMaterial" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteRawMaterial(@RequestParam ("rmId")int rmId)
	{
		Info info=rawMaterialService.deleteRawMaterial(rmId);
		return info;
		
	}
	
	//------------------------------Get All RM Master-------------------------------------
	@RequestMapping(value = { "/getAllRawMaterial" }, method = RequestMethod.GET)
	public @ResponseBody RawMaterialDetailsList getAllRawMaterial()
	{
		RawMaterialDetailsList rawMaterialDetails=new RawMaterialDetailsList();
		ErrorMessage errorMessage;
		List<RawMaterialDetails> rawMaterialDetailsList=rawMaterialService.getAllRawMaterial();
		
		if(rawMaterialDetailsList!=null)
		{
			errorMessage=new ErrorMessage();
			errorMessage.setError(false);
			errorMessage.setMessage("RM Details Found Successfully");
			
			rawMaterialDetails.setErrorMessage(errorMessage);
			rawMaterialDetails.setRawMaterialDetailsList(rawMaterialDetailsList);
		}
		else
		{
			errorMessage=new ErrorMessage();
			errorMessage.setError(true);
			errorMessage.setMessage("RM Details Not Found");
			
			rawMaterialDetails.setErrorMessage(errorMessage);
		}
		return rawMaterialDetails;
		 
		
	}
	@RequestMapping(value = { "/getAllRawMaterialByGroup" }, method = RequestMethod.POST)
	public @ResponseBody RawMaterialDetailsList getAllRawMaterialByGroup(@RequestParam("grpId")int grpId )
	{
		RawMaterialDetailsList rawMaterialDetails=new RawMaterialDetailsList();
		ErrorMessage errorMessage;
		List<RawMaterialDetails> rawMaterialDetailsList=rawMaterialDetailsRepository.findByGrpIdAndDelStatus(grpId, 0);
		
		if(rawMaterialDetailsList!=null)
		{
			errorMessage=new ErrorMessage();
			errorMessage.setError(false);
			errorMessage.setMessage("RM Details Found Successfully");
			
			rawMaterialDetails.setErrorMessage(errorMessage);
			rawMaterialDetails.setRawMaterialDetailsList(rawMaterialDetailsList);
		}
		else
		{
			errorMessage=new ErrorMessage();
			errorMessage.setError(true);
			errorMessage.setMessage("RM Details Not Found");
			
			rawMaterialDetails.setErrorMessage(errorMessage);
		}
		return rawMaterialDetails;
		 
		
	}
	//------------------------------------Get Rm Details------------------------------------
	@RequestMapping(value = { "/getRawMaterialDetail" }, method = RequestMethod.POST)
	public @ResponseBody RawMaterialDetails getRawMaterialDetail(@RequestParam ("rmId")int rmId)
	{
		RawMaterialDetails rawMaterialDetails=rawMaterialService.getRawMaterialDetails(rmId);
		return rawMaterialDetails;
		 
		
	}
	
	//------------------------------------Get Rm Details By group------------------------------------
		@RequestMapping(value = { "/getRawMaterialDetailByGroup" }, method = RequestMethod.POST)
		public @ResponseBody List<GetRawMaterialByGroup> getRawMaterialDetailByGroup(@RequestParam ("grpId")int grpId)
		{
			List<GetRawMaterialByGroup> getRawMaterialByGroupList=rawMaterialService.getRawMaterialDetailByGroup(grpId);
			return getRawMaterialByGroupList;
			 
			
		}
	//-------------------------------getCategory-----------------------------------------------
	@RequestMapping(value = { "/getRmItemCategories" }, method = RequestMethod.POST)
	public @ResponseBody List<RmItemCategory> getRmItemCategories(@RequestParam("grpId")int grpId)
	{
		
		List<RmItemCategory> rmItemCategorieList=rawMaterialService.getCategories(grpId);
		
		return rmItemCategorieList;
	}
	//----------------------------getAllGroup----------------------------------------
	@RequestMapping(value = { "/getAllRmItemGroup" }, method = RequestMethod.GET)
	public @ResponseBody List<RmItemGroup> getAllRmItemGroup()
	{
		List<RmItemGroup> rmItemGroupList=rawMaterialService.getAllGroup();
		return rmItemGroupList;
	}
	//-----------------------------------get RM UOM--------------------------
	@RequestMapping(value = { "/getRmUom" }, method = RequestMethod.GET)
	public @ResponseBody List<RawMaterialUom> getRmUom()
	{
		List<RawMaterialUom> rawMaterialUomList=rawMaterialService.getAllUom();
		return rawMaterialUomList;
	}
	//-----------------------------------get RM UOM by uomId--------------------------
		@RequestMapping(value = { "/getRmUomByUomId" }, method = RequestMethod.POST)
		public @ResponseBody RawMaterialUom getRmUomByUomId(@RequestParam("uomId")int uomId)
		{
			RawMaterialUom rawMaterialUom=rawMaterialService.getUomById(uomId);
			return rawMaterialUom;
		} 
	//-------------------------------------------------------------------------------
    
	@RequestMapping(value = { "/getRmUomList" }, method = RequestMethod.GET)
	public @ResponseBody RawMaterialUomList getRmUomList()
	{
		RawMaterialUomList rmList = new RawMaterialUomList();
		
		List<RawMaterialUom> rawMaterialUomList=rawMaterialService.getAllUom();
		
		rmList.setRawMaterialUom(rawMaterialUomList);
		
		return rmList;
		
	}
	//-----------------------------getRM Gst--------------------------------------
	
	@RequestMapping(value = { "/getAllRmTax" }, method = RequestMethod.GET)
	public @ResponseBody List<RawMaterialTaxDetails> getAllRmTax()
	{
		List<RawMaterialTaxDetails> rawMaterialTaxDetailsList=rawMaterialService.getAllRmTax();
		return rawMaterialTaxDetailsList;
	}
	
	//---------------------------------------getRateVerification------------------------------
	
	@RequestMapping(value = { "/getRmRateVerification" }, method = RequestMethod.POST)
	public @ResponseBody RmRateVerification getRmRateVerification(@RequestParam("suppId")int suppId,@RequestParam("rmId")int rmId,@RequestParam("grpId")int grpId)
	{
		System.err.println(suppId+"suppId"+"rmId"+rmId);
		return rawMaterialService.getRmRateTaxVerification(suppId, rmId,grpId);
	}
	
	@RequestMapping(value = { "/getRmRateVerificationList" }, method = RequestMethod.POST)
	public @ResponseBody List<RmRateVerificationList> getRmRateVerificationList(@RequestParam("suppId")List<String> suppId, @RequestParam("rmId")List<String> rmId)
	{
		List<RmRateVerificationList> rmRateVerificationList= new ArrayList<RmRateVerificationList>();
		try {
			System.out.println("suppId"+suppId);
			System.out.println("rmId"+rmId);
			rmRateVerificationList = rmRateVerificationListRepository.rmRateVerificationList(suppId, rmId);
			System.out.println("rmRateVerificationList"+rmRateVerificationList);
		}catch(Exception e)
		{
			
			e.printStackTrace();
		}
		 
		return rmRateVerificationList;
	}
	//------------------------------------------SubmitRmRateVerification---------------------
	@RequestMapping(value = { "/insertRmRateVerification" }, method = RequestMethod.POST)
	public @ResponseBody Info insertRmRateVerification(@RequestBody RmRateVerification rmRateVerification)
	{
		System.out.println("Before : "+rmRateVerification.toString());
		//toDate = Common.convertToYMD(toDate);
		rmRateVerification.setDate1(Common.convertToYMD(rmRateVerification.getDate1()));
		rmRateVerification.setDate2(Common.convertToYMD(rmRateVerification.getDate2()));
		rmRateVerification.setRateDate(Common.convertToYMD(rmRateVerification.getRateDate()));
		System.out.println("Before : "+rmRateVerification.toString());
		RmRateVerification rmRateVerify=rawMaterialService.postRmRateVerification(rmRateVerification);
		Info info=new Info();
		if(rmRateVerify!=null)
		{
			info.setError(false);
			info.setMessage("Rm Rate Verification Insert Successfully");
		}
		else
		{
			info.setError(true);
			info.setMessage("Failed to insert Rm Rate Verification");
		}
		return info;
	}
	//----------------------------------Insert RM Tax------------------------------
	@RequestMapping(value = { "/insertRmTax" }, method = RequestMethod.POST)
	public @ResponseBody Info insertRmTax(@RequestBody RawMaterialTaxDetails rawMaterialTaxDetails)
	{
	
		RawMaterialTaxDetails rawMaterialTax=rawMaterialService.insertRmTax(rawMaterialTaxDetails);
		Info info=new Info();
		if(rawMaterialTax!=null)
		{
			info.setError(false);
			info.setMessage("RM Tax Insert Successfully");
		}
		else
		{
			info.setError(true);
			info.setMessage("Failed to insert RM Tax ");
		}
		return info;
	}
	
	//-----------------------------------Insert RM UOM--------------------------
	@RequestMapping(value = { "/insertRmUom" }, method = RequestMethod.POST)
	public @ResponseBody Info insertRmUom(@RequestBody RawMaterialUom rawMaterialUom)
	{
		RawMaterialUom rMUom=rawMaterialService.insertRmUom(rawMaterialUom);
		Info info=new Info();
		if(rMUom!=null)
		{
			info.setError(false);
			info.setMessage("RM Uom insert successFully");
		}
		else
		{
			info.setError(true);
			info.setMessage("failed to insert RM Uom");
		}
		return info;
	}
	//-----------------------------------Delete RM UOM--------------------------
		@RequestMapping(value = { "/deleteRmUom" }, method = RequestMethod.POST)
		public @ResponseBody Info deleteRmUom(@RequestParam("uomId")int uomId)
		{
			int isDelete=rawMaterialService.deleteRmUom(uomId);
			Info info=new Info();
			if(isDelete==1)
			{
				info.setError(false);
				info.setMessage("RM Uom Deleted successFully");
			}
			else
			{
				info.setError(true);
				info.setMessage("Failed to Delete RM Uom");
			}
			return info;
		}
	//-------------------------getRmTax------------------------------
	
	@RequestMapping(value = { "/getUomAndTax" }, method = RequestMethod.POST)
	public @ResponseBody GetUomAndTax getUomAndTax(@RequestParam("rmId")int rmId,@RequestParam("grpId")int grpId)
	{
		GetUomAndTax getUomAndTax=rawMaterialService.getUomAndTax(rmId,grpId);
		return getUomAndTax;
	}
	//-----------------------------------Delete RM Tax--------------------------
			@RequestMapping(value = { "/deleteRmTax" }, method = RequestMethod.POST)
			public @ResponseBody Info deleteRmTax(@RequestParam("taxId")int taxId)
			{
				int isDelete=rawMaterialService.deleteRmTax(taxId);
				Info info=new Info();
				if(isDelete==1)
				{
					info.setError(false);
					info.setMessage("RM Tax Deleted successFully");
				}
				else
				{
					info.setError(true);
					info.setMessage("Failed to Delete RM Tax");
				}
				return info;
			}
	@RequestMapping(value = { "/getRMTax" }, method = RequestMethod.POST)
	public @ResponseBody RawMaterialTaxDetails getRMTax(@RequestParam("taxId")int taxId)
	{
		RawMaterialTaxDetails rmTaxRes=rawMaterialService.getRMTax(taxId);
		return rmTaxRes;
	}
	@RequestMapping(value = { "/getAllRawMaterialList" }, method = RequestMethod.GET)
	public @ResponseBody GetRawMaterialDetailList getAllRawMaterialList()
	{
		List<RawMaterialDetails> rawMaterialDetails=rawMaterialService.getAllRawMaterial();
		GetRawMaterialDetailList rawMaterialDetailsList=new GetRawMaterialDetailList();
		rawMaterialDetailsList.setRawMaterialDetailsList(rawMaterialDetails);
		Info info=new Info();
		if(rawMaterialDetails!=null)
		{
			info.setError(false);
			info.setMessage("successFully");
			rawMaterialDetailsList.setInfo(info);
		}
		else
		{
		 
				info.setError(true);
				info.setMessage("unsuccessFully");
				rawMaterialDetailsList.setInfo(info);
			 
		}
		return rawMaterialDetailsList;
		 
		
	}
	
	@RequestMapping(value = { "/getAllRmTaxList" }, method = RequestMethod.GET)
	public @ResponseBody RawMaterialTaxDetailsList getAllRmTaxList()
	{
		List<RawMaterialTaxDetails> rawMaterialTaxDetails=rawMaterialService.getAllRmTax();
		RawMaterialTaxDetailsList rawMaterialTaxDetailsList=new RawMaterialTaxDetailsList();
		rawMaterialTaxDetailsList.setRawMaterialTaxDetailsList(rawMaterialTaxDetails);
		Info info=new Info();
		if(rawMaterialTaxDetailsList!=null)
		{
			info.setError(false);
			info.setMessage("successfully");
		}
		else
		{
			info.setError(true);
			info.setMessage("unsuccessfully");
		}
		return rawMaterialTaxDetailsList;
	}
	
	//-----------------------------------Insert Item Detail--------------------------
		@RequestMapping(value = { "/saveItemDetails" }, method = RequestMethod.POST)
		public @ResponseBody Info saveItemDetail(@RequestBody List<ItemDetail> itemDetailList)
		{
			System.out.println("Item Deatil:"+itemDetailList.toString());
			
			List<ItemDetail> iDetail=rawMaterialService.saveItemDetail(itemDetailList);
			Info info=new Info();
			if(iDetail!=null)
			{
				info.setError(false);
				info.setMessage("ItemDetail  inserted successFully");
			}
			else
			{
				info.setError(true);
				info.setMessage("failed to insert ItemDetail");
			}
			return info;
		}
		
		//----------------------------------END-------------------------------------
		
		//-----------------------------------Get Item Detail--------------------------
				@RequestMapping(value = { "/getItemDetails" }, method = RequestMethod.POST)
				public @ResponseBody ItemDetailList getItemDetails(@RequestParam ("id")int itemId)
				{
					List<GetItemDetail> iDetails=rawMaterialService.getItemDetails(itemId);
					
					ItemDetailList itemDetailList=new ItemDetailList();
					
					ErrorMessage errorMessage=new ErrorMessage();
					if(iDetails!=null)
					{
						errorMessage.setError(false);
						errorMessage.setMessage("ItemDetail List  Found successFully");
						itemDetailList.setErrorMessage(errorMessage);
						itemDetailList.setItemDetailList(iDetails);
					}
					else
					{
						errorMessage.setError(true);
						errorMessage.setMessage("ItemDetail List Not Found.");
						itemDetailList.setErrorMessage(errorMessage);
					}
					return itemDetailList;
				}
				
		//---------------------------------------END------------------------------
		//---------------------------------------Delete Item Detail------------------------------
		
		@RequestMapping(value = { "/deleteItemDetail" }, method = RequestMethod.POST)
		public @ResponseBody Info deleteItemDetail(@RequestParam ("itemDetailId")int itemDetailId)
		{
					Info info=rawMaterialService.deleteItemDetail(itemDetailId);
					return info;
					
		}	
		//-----------------------------------------------------------------------------------

	//--------------------------GetOneByItemDetailId--------------------------------------------------
	@RequestMapping(value = { "/getItemDetail" }, method = RequestMethod.POST)
	public @ResponseBody ItemDetail getItemDetail(@RequestParam("itemDetailId")int itemDetailId)
		{
					
		ItemDetail itemDetailRes=rawMaterialService.getItemDetail(itemDetailId);
					
		return itemDetailRes;
		}
	//--------------------------END--------------------------------------------------	
	
	//-----------------------------------Get Item Detail--------------------------
	@RequestMapping(value = { "/getItemSfHeaders" }, method = RequestMethod.GET)
	public @ResponseBody ItemSfHeaderList getItemSfHeaders()
	{
		List<ItemSfHeader> itemSfHeaders=rawMaterialService.getItemSfHeaders();
		
		ItemSfHeaderList itemSfHeaderList=new ItemSfHeaderList();
		
		ErrorMessage errorMessage=new ErrorMessage();
		if(itemSfHeaders!=null)
		{
			errorMessage.setError(false);
			errorMessage.setMessage("ItemSfHeader List  Found successFully");
			itemSfHeaderList.setErrorMessage(errorMessage);
			itemSfHeaderList.setItemSfHeaderList(itemSfHeaders);
		}
		else
		{
			errorMessage.setError(true);
			errorMessage.setMessage("ItemSfHeader List Not Found.");
			itemSfHeaderList.setErrorMessage(errorMessage);
		}
		return itemSfHeaderList;
	}
	
//---------------------------------------END------------------------------
	//------------------Ganesh   29-12---------------
			@RequestMapping(value = { "/getRawMaterialByCategory" }, method = RequestMethod.POST)
			public @ResponseBody RawMaterialDetailsList getRawMaterialByCategory(@RequestParam("catId")int catId)
			{
				
				RawMaterialDetailsList rawMaterialDetailsList=rawMaterialService.getRMByCatId(catId);
				return rawMaterialDetailsList;
			}
}
