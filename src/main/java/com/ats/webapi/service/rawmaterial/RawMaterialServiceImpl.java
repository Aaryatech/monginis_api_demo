package com.ats.webapi.service.rawmaterial;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.commons.Common;
import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.rawmaterial.GetItemDetail;
import com.ats.webapi.model.rawmaterial.GetRawMaterialByGroup;
import com.ats.webapi.model.rawmaterial.GetRmItemCategory;
import com.ats.webapi.model.rawmaterial.GetRmItemSubCat;
import com.ats.webapi.model.rawmaterial.GetUomAndTax;
import com.ats.webapi.model.rawmaterial.ItemDetail;
import com.ats.webapi.model.rawmaterial.ItemSfHeader;
import com.ats.webapi.model.rawmaterial.RawMaterialDetails;
import com.ats.webapi.model.rawmaterial.RawMaterialDetailsList;
import com.ats.webapi.model.rawmaterial.RawMaterialTaxDetails;
import com.ats.webapi.model.rawmaterial.RawMaterialUom;
import com.ats.webapi.model.rawmaterial.RmItemCatList;
import com.ats.webapi.model.rawmaterial.RmItemCategory;
import com.ats.webapi.model.rawmaterial.RmItemGroup;
import com.ats.webapi.model.rawmaterial.RmItemSubCatList;
import com.ats.webapi.model.rawmaterial.RmItemSubCategory;
import com.ats.webapi.model.rawmaterial.RmRateVerification;
import com.ats.webapi.model.tally.RawMaterialResList;
import com.ats.webapi.model.tally.RawMaterialResponse;
import com.ats.webapi.repository.RmItemCategoryRepository;
import com.ats.webapi.repository.RmItemGroupRepostitory;
import com.ats.webapi.repository.RmItemSubCategoryRepository;
import com.ats.webapi.repository.RmRateVerificationRepository;
import com.ats.webapi.repository.tally.RawMaterialResTallyRepository;
import com.ats.webapi.repository.GetItemDetailRepository;
import com.ats.webapi.repository.GetRawMaterialByGroupRepository;
import com.ats.webapi.repository.GetRmItemCatRepository;
import com.ats.webapi.repository.GetRmItemSubCatRepository;
import com.ats.webapi.repository.GetUomAndTaxRepository;
import com.ats.webapi.repository.ItemDetailRepository;
import com.ats.webapi.repository.ItemSfHeaderRawRepo;
import com.ats.webapi.repository.ItemSfHeaderRepository;
import com.ats.webapi.repository.RawMaterialDetailsRepository;
import com.ats.webapi.repository.RawMaterialTaxDetailsRepository;
import com.ats.webapi.repository.RawMaterialUomRepository;

@Service
public class RawMaterialServiceImpl implements RawMaterialService{

	@Autowired
	RmItemCategoryRepository rmItemCategoryRepository;
	
	@Autowired
	RmItemSubCategoryRepository rmItemSubCategoryRepository;
	
	@Autowired
	ItemDetailRepository itemDetailRepository;
	
	@Autowired
	ItemSfHeaderRawRepo itemSfHeaderRepository;

	@Autowired
	RawMaterialDetailsRepository rawMaterialDetailsRepository;
 
	
	@Autowired
	RmItemGroupRepostitory rmItemGroupRepostitory;
	
	@Autowired
	GetRmItemCatRepository getRmItemCatRepository;
	
	@Autowired
	GetRmItemSubCatRepository getRmItemSubCatRepository;
	
	@Autowired
	RawMaterialUomRepository rawMaterialUomRepository;
	
	@Autowired
	RawMaterialTaxDetailsRepository rawMaterialTaxDetailsRepository;
	
	@Autowired
	RmRateVerificationRepository rmRateVerificationRepository;
	
	@Autowired
	GetRawMaterialByGroupRepository getRawMaterialByGroupRepository;
	
	@Autowired
	GetUomAndTaxRepository getUomAndTaxRepository;
	
	@Autowired
	GetItemDetailRepository getItemDetailRepository;
	
	@Autowired
	RawMaterialResTallyRepository rawMaterialResTallyRepository;
	
	@Override
	public RmItemCatList getRmItemCategories() {

		RmItemCatList rmItemCategoryList=new RmItemCatList();
		
		List<GetRmItemCategory> rmItemCatList=getRmItemCatRepository.findRmItemCategoryByDelStatus(); 
		ErrorMessage errorMessage=new ErrorMessage();
		
		if(rmItemCatList==null) {
			
			errorMessage.setError(true);
			errorMessage.setMessage("Raw Material Item Categories Not Found.");
			
			rmItemCategoryList.setErrorMessage(errorMessage);
		}
		else
		{
			errorMessage.setError(false);
			errorMessage.setMessage("Raw Material Item Categories Found Successfully.");
			
			rmItemCategoryList.setErrorMessage(errorMessage);
			rmItemCategoryList.setRmItemCategoryList(rmItemCatList);
			
		}
		return rmItemCategoryList;
	}

	@Override
	public RmItemSubCatList getRmItemSubCategories() {

		RmItemSubCatList rmItemSubCategoryList=new RmItemSubCatList();
		
		List<GetRmItemSubCat> rmItemSubCatList=getRmItemSubCatRepository.findRmItemSubCategoryByDelStatus(); 
		ErrorMessage errorMessage=new ErrorMessage();
		
		if(rmItemSubCatList==null) {
			
			errorMessage.setError(true);
			errorMessage.setMessage("Raw Material Item Categories Not Found.");
			
			rmItemSubCategoryList.setErrorMessage(errorMessage);
		}
		else
		{
			errorMessage.setError(false);
			errorMessage.setMessage("Raw Material Item Categories Found Successfully.");
			
			rmItemSubCategoryList.setErrorMessage(errorMessage);
			rmItemSubCategoryList.setRmItemSubCategory(rmItemSubCatList);
			
		}
		return rmItemSubCategoryList;
	}

	@Override
	public ErrorMessage saveItemCategory(RmItemCategory rmItemCategory) {

		ErrorMessage errorMessage=new ErrorMessage();

		try {
		RmItemCategory rmItemCategoryRes=rmItemCategoryRepository.save(rmItemCategory);
		
		if(rmItemCategoryRes==null)
		{
			errorMessage.setError(true);
			errorMessage.setMessage("Error:Failed To Insert Raw Material Item Category.");
			
		}else
		{
			errorMessage.setError(false);
			errorMessage.setMessage(" Raw Material Item Category  Saved Successfully.");
			
		}
		}catch(Exception e)
		{
			errorMessage.setError(true);
		    errorMessage.setMessage("Error:Error:Failed To Insert Raw Material Item  SubCategory.");
			return errorMessage;
		}
		return errorMessage;
	}

	@Override
	public ErrorMessage saveItemSubCategory(RmItemSubCategory rmItemSubCategory) {

		ErrorMessage errorMessage=new ErrorMessage();

		try {
		RmItemSubCategory rmItemSubCategoryRes=rmItemSubCategoryRepository.save(rmItemSubCategory);
		
		if(rmItemSubCategoryRes==null)
		{
			errorMessage.setError(true);
			errorMessage.setMessage("Error:Failed To Insert Raw Material Item  SubCategory.");
			
		}else
		{
			errorMessage.setError(false);
			errorMessage.setMessage("Raw Material Item SubCategory  Saved Successfully.");
			
		}
		}catch(Exception e)
		{
			errorMessage.setError(true);
		    errorMessage.setMessage("Error:Error:Failed To Insert Raw Material Item  SubCategory.");
			return errorMessage;
		}
		return errorMessage;
	}

	@Override
	public ErrorMessage deleteRmItemCategory(int catId) {
		ErrorMessage errorMessage=new ErrorMessage();

		try {
		RmItemCategory rmItemCategory=rmItemCategoryRepository.findRmItemCategoryByCatId(catId);
		
		rmItemCategory.setDelStatus(1);
		
		RmItemCategory rmItemCategoryRes=rmItemCategoryRepository.save(rmItemCategory);
		
		if(rmItemCategoryRes==null)
		{
			errorMessage.setError(true);
			errorMessage.setMessage("Error:Failed To Delete Raw Material Item Category.");
			
		}else
		{
			errorMessage.setError(false);
			errorMessage.setMessage(" Raw Material Item Category deleted Successfully.");
			
		}
		}catch(Exception e)
		{
			errorMessage.setError(true);
		    errorMessage.setMessage("Error:Failed To Delete Raw Material ItemCategory.");
			return errorMessage;
		}
		return errorMessage;

	}
	
	@Override
	public ErrorMessage deleteRmItemSubCategory(int subCatId) {
		ErrorMessage errorMessage=new ErrorMessage();

		try {
		RmItemSubCategory rmItemSubCategory=rmItemSubCategoryRepository.findRmItemSubCategoryBySubCatId(subCatId);
		
		rmItemSubCategory.setDelStatus(1);
		
		RmItemSubCategory rmItemSubCategoryRes=rmItemSubCategoryRepository.save(rmItemSubCategory);
		
		if(rmItemSubCategoryRes==null)
		{
			errorMessage.setError(true);
			errorMessage.setMessage("Error:Failed To Delete Raw Material Item Sub Category.");
			
		}else
		{
			errorMessage.setError(false);
			errorMessage.setMessage(" Raw Material Item Sub Category deleted Successfully.");
			
		}

		}catch(Exception e)
		{
			errorMessage.setError(true);
		    errorMessage.setMessage("Error:Failed To Delete Raw Material Item Sub Category.");
			return errorMessage;
		}
		return errorMessage;

	}

	@Override
	public RawMaterialDetails addRawMaterial(RawMaterialDetails rawMaterialMasterDetails) {
		
		RawMaterialDetails rawMaterialMaster=rawMaterialDetailsRepository.save(rawMaterialMasterDetails);
		
		Info info=new Info();
		if(rawMaterialMaster!=null)
		{
			info.setError(false);
			info.setMessage("Add new Raw material ");
		}
		else
		{
				info.setError(true);
				info.setMessage("Failed add new Raw material ");
		}
		return rawMaterialMaster;
	}

	@Override
	public RawMaterialDetails getRawMaterialDetails(int rmId) {
		
		RawMaterialDetails rawMaterialMaster=rawMaterialDetailsRepository.findByRmId(rmId);
		if(rawMaterialMaster!=null)
		{
			System.out.println("RM  Details : "+rawMaterialMaster.toString());
		}
		else
		{
			System.out.println("Raw material  Not exist");
		}
		return rawMaterialMaster;
	}

	@Override
	public List<RawMaterialDetails> getAllRawMaterial() {
		List<RawMaterialDetails> rawMaterialMasterDetailList=rawMaterialDetailsRepository.findByDelStatus(0);
		if(rawMaterialMasterDetailList!=null)
		{
			System.out.println("RM  Details List : "+rawMaterialMasterDetailList.toString());
		}
		else
		{
			System.out.println("Raw material  Not exist");
		}
		return rawMaterialMasterDetailList;
	}

	@Override
	public Info deleteRawMaterial(int rmId) {
		
		int res=rawMaterialDetailsRepository.deleteRawMaterial(rmId);
	
		Info info=new Info();
		if(res>0)
		{
			info.setError(false);
			info.setMessage("Delete Raw material ");
		}
		else
		{
			
				info.setError(true);
				info.setMessage("Failed delete Raw material ");
			
		}
		return info;
	}

	@Override
	public RmItemCategory getRmItemCategory(int catId) {
		RmItemCategory rmItemCategory=null;
		try {
			rmItemCategory=rmItemCategoryRepository.findRmItemCategoryByCatId(catId);
		}
		catch(Exception e)
		{
			rmItemCategory=new RmItemCategory();
		}
		
		return rmItemCategory;
	}

	@Override
	public RmItemSubCategory getRmItemSubCategory(int subCatId) {
		
		RmItemSubCategory rmItemSubCategory=null;
		try {
			rmItemSubCategory=rmItemSubCategoryRepository.findRmItemSubCategoryBySubCatId(subCatId);
		}
		catch(Exception e)
		{
			rmItemSubCategory=new RmItemSubCategory();
		}
		
		return rmItemSubCategory;
	}

	@Override
	public List<RmItemSubCategory> getRmItemSubCategories(int catId) {
		List<RmItemSubCategory> rmItemSubCategories=null;
		try {
			
			rmItemSubCategories=rmItemSubCategoryRepository.findRmItemSubCategoryByCatIdAndDelStatus(catId,0);
	        	
		}
		catch(Exception e)
		{
			rmItemSubCategories=new ArrayList<RmItemSubCategory>();
		}
		
		return rmItemSubCategories;
	}

	@Override
	public List<RmItemCategory> getCategories(int grpId) {
		
		List<RmItemCategory> rmItemCategoryList=rmItemCategoryRepository.findRmItemCategoryByGrpIdAndDelStatus(grpId,0);
		if(rmItemCategoryList!=null)
		{
			System.out.println("Category List  : "+rmItemCategoryList.toString());
		}
		else
		{
			System.out.println("Category Not found");
		}
		return rmItemCategoryList;
	}

	@Override
	public List<RmItemGroup> getAllGroup() {
		
		List<RmItemGroup> rmItemGroupList=rmItemGroupRepostitory.findByDelStatus(0);
		if(rmItemGroupList!=null)
		{
			System.out.println("Group List  : "+rmItemGroupList.toString());
		}
		else
		{
			System.out.println("Group Not found");
		}
		return rmItemGroupList;
	}

	@Override
	public List<RawMaterialUom> getAllUom() {
		 
		List<RawMaterialUom> rawMaterialUomList=rawMaterialUomRepository.findAllByDelStatus(0);
		if(rawMaterialUomList!=null)
		{
			System.out.println("RM UOM List : "+rawMaterialUomList.toString());
		}
		else
		{
			System.out.println("RM UOM List empty");
		}
		return rawMaterialUomList;
	}

	@Override
	public List<RawMaterialTaxDetails> getAllRmTax() {
		

		List<RawMaterialTaxDetails> rawMaterialTaxDetailsList=rawMaterialTaxDetailsRepository.findAllByDelStatus(0);
		if(rawMaterialTaxDetailsList!=null)
		{
			System.out.println("Tax details : "+rawMaterialTaxDetailsList.toString());
		}
		else 
		{
			System.out.println("Problen in geting Tax details");
		}
		return rawMaterialTaxDetailsList;
	}

	@Override
	public RmRateVerification getRmRateTaxVerification(int suppId, int rmId,int grpId) {
	
		RmRateVerification rmRateVerification=rmRateVerificationRepository.getRmTaxVer(suppId, rmId,grpId);
		
		if(rmRateVerification!=null)
		{
			
			System.out.println("Verification : "+rmRateVerification.toString());
			 
			rmRateVerification.setDate2(Common.convertToDMY(rmRateVerification.getDate2()));
			rmRateVerification.setDate1(Common.convertToDMY(rmRateVerification.getDate1()));
			rmRateVerification.setRateDate(Common.convertToDMY(rmRateVerification.getRateDate()));
			  
		}
		else
		{
			int taxId=0;
			System.out.println("Error in Rate Verification or not found ");
			rmRateVerification=new RmRateVerification();
			rmRateVerification.setDate1(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
			rmRateVerification.setDate2(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
			rmRateVerification.setRateDate(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
			rmRateVerification.setRmId(rmId);
			rmRateVerification.setSuppId(suppId);
			if(grpId!=2 && grpId!=3) { 
			 taxId=rmRateVerificationRepository.getTaxId(rmRateVerification.getRmId());
			}
			System.out.println("Tax Id ----------"+taxId);
			rmRateVerification.setTaxId(taxId);
			 
			
		}
		return rmRateVerification;
		
	}

	@Override
	public RmRateVerification postRmRateVerification(RmRateVerification rmRateVerification) {
		
		 
		RmRateVerification rmRateVerify=rmRateVerificationRepository.save(rmRateVerification);
		return rmRateVerify;
	}

	@Override
	public List<GetRawMaterialByGroup> getRawMaterialDetailByGroup(int grpId) {
		List<GetRawMaterialByGroup> getRawMaterialByGroupList=getRawMaterialByGroupRepository.getRmByGroup(grpId);
		if(getRawMaterialByGroupList!=null)
		{
			System.out.println("rawMaterialDetailsList is: "+getRawMaterialByGroupList.toString());
		}
		else
		{
			System.out.println("Problem in getting RM Details  ");
		}
		return getRawMaterialByGroupList;
	}

	@Override
	public RawMaterialTaxDetails insertRmTax(RawMaterialTaxDetails rawMaterialTaxDetails) {
		
		RawMaterialTaxDetails rawMaterialTax=rawMaterialTaxDetailsRepository.save(rawMaterialTaxDetails);
		return rawMaterialTax;
		
	}

	@Override
	public RawMaterialUom insertRmUom(RawMaterialUom rawMaterialUom) {
		RawMaterialUom rMUom=rawMaterialUomRepository.save(rawMaterialUom);
		return rMUom;
		
	}

	@Override
	public GetUomAndTax getUomAndTax(int rmId,int grpId) {
		
		GetUomAndTax  getUomAndTax=new GetUomAndTax();
		getUomAndTax=getUomAndTaxRepository.getUomTax(rmId);
		if(grpId==18||grpId==19)
		{
		
			getUomAndTax=getUomAndTaxRepository.getUomTaxForItem(rmId);
			
		}else {
			System.err.println(rmId);

			getUomAndTax=getUomAndTaxRepository.getUomTax(rmId);
			System.err.println(getUomAndTax.toString());
		}
		
		if(getUomAndTax!=null)
		{
			System.out.println("List is : "+getUomAndTax.toString());
	}
	else
	{
		System.out.println("Not found ");
	}
		return getUomAndTax;
	}

	@Override
	public List<GetItemDetail> getItemDetails(int itemId) {

		List<GetItemDetail> itemDetails=getItemDetailRepository.findAllItemDetailByDelStatus(itemId);
		return itemDetails;
	}

	@Override
	public Info deleteItemDetail(int itemDetailId) {
		
		Info info=null;
		int res=itemDetailRepository.updateItemDetail(itemDetailId);
		
		if(res>0)
		{	  info=new Info();

			info.setError(false);
			info.setMessage("ItemDetail Deleted Successfully ");
		}
		else
		{
			
				info.setError(true);
				info.setMessage("ItemDetail deletion Failed");
			
		}		
		return info;
	}

	@Override
	public ItemDetail getItemDetail(int itemDetailId) {

		ItemDetail itemDetail=itemDetailRepository.findByItemDetailId(itemDetailId);
		return itemDetail;
	}

	@Override
	public List<ItemSfHeader> getItemSfHeaders() {

		List<ItemSfHeader> itemSfHeaders=itemSfHeaderRepository.findItemSfHeaderByDelStatus(0);
		
		return itemSfHeaders;
	}

	@Override
	public List<ItemDetail> saveItemDetail(List<ItemDetail> itemDetail) {

		List<ItemDetail>  itemDetails=new ArrayList<ItemDetail>();

		for(int i=0;i<itemDetail.size();i++)
		{
			ItemDetail itemDetailRes=itemDetailRepository.save(itemDetail.get(i));
			itemDetails.add(itemDetailRes);
		}
		return itemDetails;
	}

	@Override
	public RawMaterialUom getUomById(int uomId) {
		
		RawMaterialUom rawMaterialUomRes=rawMaterialUomRepository.findByUomId(uomId);
	
		return rawMaterialUomRes;
	}

	@Override
	public int deleteRmUom(int uomId) {

		int isDelete=rawMaterialUomRepository.deleteRmUom(uomId);
		return isDelete;
	}

	@Override
	public RawMaterialTaxDetails getRMTax(int taxId) {

		  RawMaterialTaxDetails  rawMaterialTaxDetails=rawMaterialTaxDetailsRepository.findByTaxId(taxId);	
			return rawMaterialTaxDetails;
	
	}

	@Override
	public int deleteRmTax(int taxId) {

		int isDelete=rawMaterialTaxDetailsRepository.deleteRmTax(taxId);
		return isDelete;
	}
//  -----Ganesh  29-12-------
	@Override
	public RawMaterialDetailsList getRMByCatId(int catId) {
		
			RawMaterialDetailsList rawMaterialDetailsList=new RawMaterialDetailsList();
		List<RawMaterialDetails> rawMaterialList=rawMaterialDetailsRepository.findByCatId(catId);
		
		ErrorMessage errorMessage=new ErrorMessage();
		
		if(rawMaterialList!=null)
		{
			System.out.println("List RM "+rawMaterialList.toString());
			
			rawMaterialDetailsList.setRawMaterialDetailsList(rawMaterialList);
			errorMessage.setError(false);
			errorMessage.setMessage("Success");
		}
		else{
			errorMessage.setError(true);
			errorMessage.setMessage("Failed");
		}
		rawMaterialDetailsList.setErrorMessage(errorMessage);
		return rawMaterialDetailsList;
	}

	@Override
	public RawMaterialResList getAllRawMaterialForTally() {
		
		RawMaterialResList rawMaterialDetails=new RawMaterialResList();
		ErrorMessage errorMessage;
		List<RawMaterialResponse> rawMaterialMasterDetailList=rawMaterialResTallyRepository.findByDelStatusAndIsTallySync();

		if(!rawMaterialMasterDetailList.isEmpty())
		{
			errorMessage=new ErrorMessage();
			errorMessage.setError(false);
			errorMessage.setMessage("RM Details Found Successfully");
			
			rawMaterialDetails.setErrorMessage(errorMessage);
			rawMaterialDetails.setRawMaterialList(rawMaterialMasterDetailList);
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

	@Override
	public ErrorMessage updateRawMaterial(int rmId, int isTallySync) {
		
		ErrorMessage errorMessage=new ErrorMessage();
		
			int i=rawMaterialDetailsRepository.updateRawMaterial(rmId,isTallySync);
	
		if(i==1) {
		
		errorMessage.setError(false);
		errorMessage.setMessage("Raw Material Updated Successfully");
		}
		else
		{
			errorMessage.setError(false);
			errorMessage.setMessage("Raw Material Updation Failed");
			
		}
		return errorMessage;
	}

	@Override
	public List<RawMaterialDetails> getAllRawMaterialByDept(int deptId) {
		List<RawMaterialDetails> rawMaterialMasterDetailList=rawMaterialDetailsRepository.findByDelStatusAndRmOpRate(0,deptId);
		if(rawMaterialMasterDetailList!=null)
		{
			System.out.println("RM  Details List : "+rawMaterialMasterDetailList.toString());
		}
		else
		{
			System.out.println("Raw material  Not exist");
		}
		return rawMaterialMasterDetailList;
	}

	@Override
	public List<ItemSfHeader> getItemSfHeadersByDept(int deptId) {
List<ItemSfHeader> itemSfHeaders=itemSfHeaderRepository.findItemSfHeaderByDelStatusAndInt1(0,deptId);
		
		return itemSfHeaders;
	}
	
	
}