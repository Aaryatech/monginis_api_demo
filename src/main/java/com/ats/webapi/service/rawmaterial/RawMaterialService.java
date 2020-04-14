package com.ats.webapi.service.rawmaterial;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.rawmaterial.GetItemDetail;
import com.ats.webapi.model.rawmaterial.GetRawMaterialByGroup;
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

@Service
public interface RawMaterialService {

	RmItemCatList getRmItemCategories();

	RmItemSubCatList getRmItemSubCategories();

	ErrorMessage saveItemCategory(RmItemCategory rmItemCategory);

	ErrorMessage saveItemSubCategory(RmItemSubCategory rmItemSubCategory);

	ErrorMessage deleteRmItemCategory(int catId);

	ErrorMessage deleteRmItemSubCategory(int subCatId);
	
	RawMaterialDetails addRawMaterial(RawMaterialDetails rawMaterialMasterDetails);

	RawMaterialDetails getRawMaterialDetails(int rmId);
	
	List<RawMaterialDetails> getAllRawMaterial();
	
	Info deleteRawMaterial(int rmId);

	RmItemCategory getRmItemCategory(int catId);

	RmItemSubCategory getRmItemSubCategory(int subCatId);

	List<RmItemSubCategory> getRmItemSubCategories(int catId);

	List<RmItemCategory> getCategories(int grpId);

	List<RmItemGroup> getAllGroup();

	List<RawMaterialUom> getAllUom();

	List<RawMaterialTaxDetails> getAllRmTax();

	RmRateVerification getRmRateTaxVerification(int suppId, int rmId, int grpId);

	RmRateVerification postRmRateVerification(RmRateVerification rmRateVerification);

	List<GetRawMaterialByGroup> getRawMaterialDetailByGroup(int grpId);

	RawMaterialTaxDetails insertRmTax(RawMaterialTaxDetails rawMaterialTaxDetails);

	RawMaterialUom insertRmUom(RawMaterialUom rawMaterialUom);

	GetUomAndTax getUomAndTax(int rmId,int grpId);

	List<ItemDetail> saveItemDetail(List<ItemDetail> itemDetail);

	List<GetItemDetail> getItemDetails(int itemId);

	Info deleteItemDetail(int itemDetailId);

	ItemDetail getItemDetail(int itemDetailId);

	List<ItemSfHeader> getItemSfHeaders();

	RawMaterialUom getUomById(int uomId);

	int deleteRmUom(int uomId);

	RawMaterialTaxDetails getRMTax(int taxId);

	int deleteRmTax(int taxId);
	RawMaterialDetailsList getRMByCatId(int catId);

	RawMaterialResList getAllRawMaterialForTally();

	ErrorMessage updateRawMaterial(int rmId, int isTallySync);
}