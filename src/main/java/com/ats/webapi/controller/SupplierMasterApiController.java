package com.ats.webapi.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.SupplierMaster.SupPaymentTerms;
import com.ats.webapi.model.SupplierMaster.SupPaymentTermsList;
import com.ats.webapi.model.SupplierMaster.SupplierDetails;
import com.ats.webapi.model.SupplierMaster.Supprlist;
import com.ats.webapi.model.SupplierMaster.Transporter;
import com.ats.webapi.model.SupplierMaster.TransporterList;
import com.ats.webapi.model.rawmaterial.RmItemCatList;
import com.ats.webapi.model.rawmaterial.RmItemCategory;
import com.ats.webapi.repository.SupplierDetailRepository;
import com.ats.webapi.service.SuppilerMasterService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
public class SupplierMasterApiController {

	@Autowired
	SuppilerMasterService suppilerMasterService;
	@Autowired
	SupplierDetailRepository supplierDetailRepository;
	
	@RequestMapping(value = { "/addNewSupplier" }, method = RequestMethod.POST)
	public @ResponseBody Info addNewSupplier(@RequestBody SupplierDetails supplierDetails)
			throws ParseException, JsonParseException, JsonMappingException, IOException {

		System.out.println("Data : "+supplierDetails);
		SupplierDetails supplier=suppilerMasterService.addSuppler(supplierDetails);
		Info info=new Info();
		if(supplier!=null)
		{
			info.setError(false);
			info.setMessage("Add new Supplier Successfully");
		}
		else {
			info.setError(true);
			info.setMessage("Problem in Add new Supplier");
		}
		
		return info;
	
}
	
	@RequestMapping(value = { "/getAllSupplier" }, method = RequestMethod.GET)
	public @ResponseBody List<SupplierDetails> getAllSupplier()
	{
		List<SupplierDetails> supplierDetailsList=suppilerMasterService.getAllSupplier();
		if(supplierDetailsList!=null)
		{
			System.out.println("Supplier List "+ supplierDetailsList.toString());
		}
		else
		{
			System.out.println("No supplier in List");
		}
		return supplierDetailsList;
		
	}
	@RequestMapping(value = { "/getSuppliersByItemId" }, method = RequestMethod.POST)
	public @ResponseBody List<SupplierDetails> getSupplierByItemId(@RequestParam("itemId")int itemId,@RequestParam("grpId")int grpId)
	{
		List<SupplierDetails> supplierDetailsList=supplierDetailRepository.getSupplierByItemId(itemId,grpId);
		if(supplierDetailsList!=null)
		{
			System.out.println("Supplier List "+ supplierDetailsList.toString());
		}
		else
		{
			System.out.println("No supplier in List");
		}
		return supplierDetailsList;
		
	}
	
	@RequestMapping(value = { "/getSupplierDetails" }, method = RequestMethod.POST)
	public @ResponseBody SupplierDetails getSupplierDetails(@RequestParam("suppId") int suppId)
			throws ParseException, JsonParseException, JsonMappingException, IOException {

		System.out.println("Supp Id : "+suppId);
		SupplierDetails supplierDetails=suppilerMasterService.getSupplier(suppId);
		 
		if(supplierDetails.getSuppName()!=null)
		{
			 
			System.out.println("Suppiler  Name"+supplierDetails.getSuppName());
		}
		else {
			System.out.println("Suppiler not exist");
		}
		
		return supplierDetails;
	
}
	
	@RequestMapping(value = { "/deleteSupplier" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteSupplier(@RequestParam("suppId") int suppId)
	{
		System.out.println("Supp Id : "+suppId);
		int result=suppilerMasterService.deleteSupplier(suppId);
		
		Info info=new Info();
		if(result>0)
		{
			info.setError(false);
			info.setMessage("Delete SuccessFully");
		}
		else
		{
			info.setError(true);
			info.setMessage("Deletion Failed");
		}
		return info;
		
	}
	
	//----------------------Get Data Of Transporter---------------
	@RequestMapping(value = { "/showTransporters" }, method = RequestMethod.GET)
	public @ResponseBody TransporterList showAllTransporter() {

		TransporterList transporterList=suppilerMasterService.showAllTransporter();
			    
		return transporterList;
	}
	//-------------------------END---------------------------------------------------
		
	//----------------------Get Data Of Transporter---------------
	@RequestMapping(value = { "/showPaymentTerms" }, method = RequestMethod.GET)
	public @ResponseBody SupPaymentTermsList showPaymentTerms() {

		SupPaymentTermsList supPaymentTermsList=suppilerMasterService.showPaymentTerms();
					    
		return supPaymentTermsList;
	}
	//-------------------------END---------------------------------------------------
				
	//----------------------Save Transporter---------------
		@RequestMapping(value = { "/saveTransporter" }, method = RequestMethod.POST)
		public @ResponseBody ErrorMessage saveTransporter(@RequestBody Transporter transporter)
		{
			System.out.println("Transporter:"+transporter.toString());
			ErrorMessage errorMessage=suppilerMasterService.saveTransporter(transporter);
			
			return errorMessage;
		}
		//--------------------------END--------------------------------------------------
		//----------------------Save SupPaymentTerms---------------
		@RequestMapping(value = { "/saveSupPaymentTerms" }, method = RequestMethod.POST)
		public @ResponseBody ErrorMessage saveSupPaymentTerms(@RequestBody SupPaymentTerms supPaymentTerms)
		{
			
			ErrorMessage errorMessage=suppilerMasterService.saveSupPaymentTerms(supPaymentTerms);
			
			return errorMessage;
		}
		//--------------------------END--------------------------------------------------
		//--------------------------Delete Transporter--------------------------------------------------
		@RequestMapping(value = { "/deleteTransporter" }, method = RequestMethod.POST)
		public @ResponseBody ErrorMessage deleteTransporter(@RequestParam("tranId")int tranId)
		{
			
			ErrorMessage errorMessage=suppilerMasterService.deleteTransporter(tranId);
			
			return errorMessage;
		}
		//--------------------------END--------------------------------------------------
		//--------------------------Delete Sup Payment Term--------------------------------------------------
	    @RequestMapping(value = { "/deleteSupPaymentTerm" }, method = RequestMethod.POST)
	    public @ResponseBody ErrorMessage deleteSupPaymenTerm(@RequestParam("payId")int payId)
	    {
					
		  ErrorMessage errorMessage=suppilerMasterService.deleteSupPaymentTerm(payId);
					
		  return errorMessage;
	    }
	//--------------------------END--------------------------------------------------
	  //--------------------------GetOneByPayId Sup Payment Term--------------------------------------------------
	    @RequestMapping(value = { "/getSupPaymentTerm" }, method = RequestMethod.POST)
	    public @ResponseBody SupPaymentTerms getSupPaymentTerm(@RequestParam("payId")int payId)
	    {
					
	    	SupPaymentTerms paymentTermRes=suppilerMasterService.getSupPaymentTerm(payId);
					
		  return paymentTermRes;
	    }
	//--------------------------END------------------------------------------------------------------ 
	  //--------------------------GetOneByTranId Transporter--------------------------------------------------
	  		@RequestMapping(value = { "/getTransporter" }, method = RequestMethod.POST)
	  		public @ResponseBody Transporter getTransporter(@RequestParam("tranId")int tranId)
	  		{
	  			
	  			Transporter transporter=suppilerMasterService.getTransporter(tranId);
	  			
	  			return transporter;
	  		}
	//--------------------------END--------------------------------------------------------------------   
	  		
	  		
	  		@RequestMapping(value = { "/getAllSupplierlist" }, method = RequestMethod.GET)
	  		public @ResponseBody Supprlist getAllSupplierlist()
	  		{
	  			Supprlist supprlist= new Supprlist();
	  			supprlist.setSupplierDetailslist(suppilerMasterService.getAllSupplier());
	  			if(supprlist!=null)
	  				System.out.println("Supplier List "+ supprlist.toString());
	  			else
	  				System.out.println("No supplier in List");
	  			return supprlist;
	  			
	  		}
}






