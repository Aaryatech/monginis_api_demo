package com.ats.webapi.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.MaterialRecNote;
import com.ats.webapi.model.SupplierMaster.SupplierDetails;
import com.ats.webapi.model.rawmaterial.RawMaterialDetails;
import com.ats.webapi.model.rawmaterial.RawMaterialDetailsList;
import com.ats.webapi.model.tally.CreditNote;
import com.ats.webapi.model.tally.CreditNoteList;
import com.ats.webapi.model.tally.FranchiseeList;
import com.ats.webapi.model.tally.ItemList;
import com.ats.webapi.model.tally.MaterialRecNoteList;
import com.ats.webapi.model.tally.MaterialReceiptNote;
import com.ats.webapi.model.tally.RawMaterialResList;
import com.ats.webapi.model.tally.SalesVoucher;
import com.ats.webapi.model.tally.SalesVoucherList;
import com.ats.webapi.model.tally.SpCakeList;
import com.ats.webapi.model.tally.SuppliersList;
import com.ats.webapi.repository.tally.TallyCreditNoteRepository;
import com.ats.webapi.repository.tally.TallySalesVoucherRepository;
import com.ats.webapi.service.SuppilerMasterService;
import com.ats.webapi.service.MaterialRcNote.MaterialRecNoteService;
import com.ats.webapi.service.rawmaterial.RawMaterialService;
import com.ats.webapi.service.tally.CreditNoteService;
import com.ats.webapi.service.tally.FranchiseeService;
import com.ats.webapi.service.tally.SalesVoucherService;
import com.ats.webapi.service.tally.SpCakeService;
import com.ats.webapi.service.tally.TallyItemService;
import com.ats.webapi.util.JsonUtil;

@RestController
@RequestMapping("/tally")
public class TallySyncController {

	@Autowired
	FranchiseeService franchiseeService;
	
	@Autowired
	TallyItemService itemService;
	
	@Autowired
	SpCakeService specialCakeService;
	
	@Autowired
	SalesVoucherService salesVoucherService;
	
	@Autowired
	CreditNoteService creditNoteService;
	
	@Autowired
	SuppilerMasterService supplierMasterService;
	
	@Autowired
	RawMaterialService rawMaterialService;
	
	@Autowired
	MaterialRecNoteService materialRecNoteService;
	
	@Autowired
	TallySalesVoucherRepository tallySalesVoucherRepository;
	
	@Autowired
	TallyCreditNoteRepository tallyCreditNoteRepository;
	
	@RequestMapping(value = { "/getAllExcelFranchise" }, method = RequestMethod.GET)
	public @ResponseBody FranchiseeList getAllExcelFranchise()
	  {

		    FranchiseeList franchiseeList=franchiseeService.getAllFranchisee();
		    
		    return franchiseeList;
	  }
	@RequestMapping(value = { "/getAllExcelItems" }, method = RequestMethod.GET)
	public @ResponseBody ItemList getAllExcelItems()
	  {

		    ItemList itemList=itemService.getAllItems();
		    return itemList;
		    
	  }
	@RequestMapping(value = { "/getAllExcelSpCake" }, method = RequestMethod.GET)
	public @ResponseBody SpCakeList getAllExcelSpCake()
	  {
		SpCakeList spCakeList=specialCakeService.getAllSpCake();
		return spCakeList;
	  }
	@RequestMapping(value = { "/getSalesVouchersByBillNo" }, method = RequestMethod.POST)
	public @ResponseBody SalesVoucherList getSalesVouchersByBillNo(@RequestParam("billNo")List<Integer> billNo,@RequestParam("all")int all,
			@RequestParam("fromDate")String fromDate, @RequestParam("toDate")String toDate)
	  {
		SalesVoucherList salesVoucherList = new SalesVoucherList();
		List<SalesVoucher> salesVoucher = new ArrayList<SalesVoucher>();
		try {
			if(all==1)
			{
				 salesVoucher=tallySalesVoucherRepository.getSalesVouchersAll(fromDate,toDate);
			}
			else
			{
				 salesVoucher=tallySalesVoucherRepository.getSalesVouchersByBillNo(billNo);
			}
		
		
		 
			ErrorMessage errorMessage=new ErrorMessage();
			
			if(salesVoucher==null)
			{
			
				errorMessage.setError(true);
				errorMessage.setMessage("Sales Voucher Not Found");
				
				salesVoucherList.setErrorMessage(errorMessage);
			}
			else
			{
				errorMessage.setError(false);
				errorMessage.setMessage("Sales Voucher Found Successfully");
				
				
				for(int i=0;i<salesVoucher.size();i++) {
					
					if(salesVoucher.get(i).getErpLink().equalsIgnoreCase("0")) {
						salesVoucher.get(i).setErpLink("A");
						
					}
				}
				
				salesVoucherList.setSalesVoucherList(salesVoucher);
				salesVoucherList.setErrorMessage(errorMessage);
					
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		    return salesVoucherList;
	  }
	
	 @RequestMapping(value = { "/getCreditNotesByCrnId" }, method = RequestMethod.POST)
		public @ResponseBody CreditNoteList getCreditNotesByCrnId(@RequestParam("crnId")List<Integer> crnId)
		  {

			CreditNoteList creditNoteList=new CreditNoteList();
			try
			{
				 List<CreditNote> creditNotes=tallyCreditNoteRepository.getCreditNotesByCrnId(crnId);
					
					ErrorMessage errorMessage=new ErrorMessage();
					
					if(creditNotes==null)
					{
					
						errorMessage.setError(true);
						errorMessage.setMessage("Credit Note Not Found");
						
						creditNoteList.setErrorMessage(errorMessage);
					}
					else
					{
						errorMessage.setError(false);
						errorMessage.setMessage("Credit Note Found Successfully");
						
						for(int i=0;i<creditNotes.size();i++) {
							
							if(creditNotes.get(i).getErpLink().equalsIgnoreCase("0")) {
								
								creditNotes.get(i).setErpLink("A");
								
							}
						}
						
						creditNoteList.setCreditNoteList(creditNotes);
						creditNoteList.setErrorMessage(errorMessage);
						
					}
			}catch(Exception e)
			{
				e.printStackTrace();
			}

		    
				return creditNoteList; 
		  }
	@RequestMapping(value = { "/getAllFranchisee" }, method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<byte[]> showAllFranchisee()
	  {

		    FranchiseeList franchiseeList=franchiseeService.getAllFranchisee();
		    
		    String regData =JsonUtil.javaToJson(franchiseeList);

		    byte[] output = regData.getBytes();

		    HttpHeaders responseHeaders = new HttpHeaders();

		    responseHeaders.setContentType(MediaType.valueOf("application/json;charset=UTF-8"));

		    responseHeaders.setContentLength(output.length);

		    responseHeaders.set("Content-disposition", "attachment; filename=allFranchisee.json");



		    return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);


	  }
	@RequestMapping(value = { "/getAllItems" }, method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<byte[]> showAllItem()
	  {

		    ItemList itemList=itemService.getAllItems();
		    
            String regData =JsonUtil.javaToJson(itemList);

		    byte[] output = regData.getBytes();

		    HttpHeaders responseHeaders = new HttpHeaders();

		    responseHeaders.setContentType(MediaType.valueOf("application/json;charset=UTF-8"));

		    responseHeaders.setContentLength(output.length);

		    responseHeaders.set("Content-disposition", "attachment; filename=allItems.json");

		    return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);
		    
	  }
	@RequestMapping(value = { "/getAllSpCake" }, method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<byte[]> showAllSpCake()
	  {

		SpCakeList spCakeList=specialCakeService.getAllSpCake();
		    
		String regData =JsonUtil.javaToJson(spCakeList);

	    byte[] output = regData.getBytes();

	    HttpHeaders responseHeaders = new HttpHeaders();

	    responseHeaders.setContentType(MediaType.valueOf("application/json;charset=UTF-8"));

	    responseHeaders.setContentLength(output.length);

	    responseHeaders.set("Content-disposition", "attachment; filename=allSpecialCakes.json");

	    return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);
	    
	  }
	
	@RequestMapping(value = { "/updateFranchisees" }, method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<byte[]> updateFranchisees(@RequestParam("customerId")int customerId,@RequestParam("isTallySync")int isTallySync)
	  {
		
		ErrorMessage errorMessage=franchiseeService.updateFranchisees(customerId,isTallySync);
		
		String regData =JsonUtil.javaToJson(errorMessage);

	    byte[] output = regData.getBytes();

	    HttpHeaders responseHeaders = new HttpHeaders();

	    responseHeaders.setContentType(MediaType.valueOf("application/json;charset=UTF-8"));

	    responseHeaders.setContentLength(output.length);

	    responseHeaders.set("Content-disposition", "attachment; filename=updateFranchisees.json");

	    return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);
	  }
	
	  @RequestMapping(value = { "/updateItems" }, method = RequestMethod.GET)
	  public @ResponseBody ResponseEntity<byte[]> updateItems(@RequestParam("id")int id,@RequestParam("isTallySync")int isTallySync)
	  {

		    ErrorMessage errorMessage=itemService.updateItems(id,isTallySync);
		    
		    String regData =JsonUtil.javaToJson(errorMessage);

		    byte[] output = regData.getBytes();

		    HttpHeaders responseHeaders = new HttpHeaders();

		    responseHeaders.setContentType(MediaType.valueOf("application/json;charset=UTF-8"));

		    responseHeaders.setContentLength(output.length);

		    responseHeaders.set("Content-disposition", "attachment; filename=updateItems.json");

		    return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);
	  }
	  
	  @RequestMapping(value = { "/updateSpCakes" }, method = RequestMethod.GET)
		public @ResponseBody ResponseEntity<byte[]> updateSpCakes(@RequestParam("id")int id,@RequestParam("isTallySync")int isTallySync)
		  {

		  ErrorMessage errorMessage=specialCakeService.updateSpCakes(id,isTallySync);
			    
		  String regData =JsonUtil.javaToJson(errorMessage);

		    byte[] output = regData.getBytes();

		    HttpHeaders responseHeaders = new HttpHeaders();

		    responseHeaders.setContentType(MediaType.valueOf("application/json;charset=UTF-8"));

		    responseHeaders.setContentLength(output.length);

		    responseHeaders.set("Content-disposition", "attachment; filename=updateSpecialCakes.json");

		    return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);
		  }
		
	     @RequestMapping(value = { "/getAllSalesVouchers" }, method = RequestMethod.GET)
		public @ResponseBody ResponseEntity<byte[]> showAllSalesVoucher()
		  {

	    	 SalesVoucherList salesVoucherList=salesVoucherService.getAllSalesVoucher();
			    
	    	 String regData =JsonUtil.javaToJson(salesVoucherList);

			    byte[] output = regData.getBytes();

			    HttpHeaders responseHeaders = new HttpHeaders();

			    responseHeaders.setContentType(MediaType.valueOf("application/json;charset=UTF-8"));

			    responseHeaders.setContentLength(output.length);

			    responseHeaders.set("Content-disposition", "attachment; filename=allSalesVouchers.json");

			    return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);
		  }
		
		 
	     @RequestMapping(value = { "/updateSalesVoucher" }, method = RequestMethod.GET)
			public @ResponseBody ResponseEntity<byte[]> updateSalesVouchers(@RequestParam("VNo")int billNo,@RequestParam("isTallySync")int isTallySync)
			  {

			  ErrorMessage errorMessage=salesVoucherService.updateSalesVouchers(billNo,isTallySync);
				    
			  String regData =JsonUtil.javaToJson(errorMessage);

			    byte[] output = regData.getBytes();

			    HttpHeaders responseHeaders = new HttpHeaders();

			    responseHeaders.setContentType(MediaType.valueOf("application/json;charset=UTF-8"));

			    responseHeaders.setContentLength(output.length);

			    responseHeaders.set("Content-disposition", "attachment; filename=updateSalesVouchers.json");

			    return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);
			  }
	     @RequestMapping(value = { "/getAllCreditNotes" }, method = RequestMethod.GET)
			public @ResponseBody ResponseEntity<byte[]> showAllCreditNote()
			  {

	    	 CreditNoteList creditNoteList=creditNoteService.getAllCreditNote();
				    
	    	 String regData =JsonUtil.javaToJson(creditNoteList);

			    byte[] output = regData.getBytes();

			    HttpHeaders responseHeaders = new HttpHeaders();

			    responseHeaders.setContentType(MediaType.valueOf("application/json;charset=UTF-8"));

			    responseHeaders.setContentLength(output.length);

			    responseHeaders.set("Content-disposition", "attachment; filename=allCreditNotes.json");

			    return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);
			    
			  }
	     @RequestMapping(value = { "/updateCreditNote" }, method = RequestMethod.GET)
			public @ResponseBody ResponseEntity<byte[]> updateCreditNote(@RequestParam("VNo")int crnId,@RequestParam("isTallySync")int isTallySync)
			  {

			  ErrorMessage errorMessage=creditNoteService.updateCreditNote(crnId,isTallySync);
				    
			  String regData =JsonUtil.javaToJson(errorMessage);

			    byte[] output = regData.getBytes();

			    HttpHeaders responseHeaders = new HttpHeaders();

			    responseHeaders.setContentType(MediaType.valueOf("application/json;charset=UTF-8"));

			    responseHeaders.setContentLength(output.length);

			    responseHeaders.set("Content-disposition", "attachment; filename=updateCreditNotes.json");

			    return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);
			  }
			//-------------------------------------------------------------------------------------
			@RequestMapping(value = { "/getAllSupplier" }, method = RequestMethod.GET)
			public @ResponseBody ResponseEntity<byte[]> getAllSupplier()
			{
				SuppliersList supplierList=supplierMasterService.getAllSupplierForTally();
				
				 String regData =JsonUtil.javaToJson(supplierList);

				    byte[] output = regData.getBytes();

				    HttpHeaders responseHeaders = new HttpHeaders();

				    responseHeaders.setContentType(MediaType.valueOf("application/json;charset=UTF-8"));

				    responseHeaders.setContentLength(output.length);

				    responseHeaders.set("Content-disposition", "attachment; filename=allSuppliers.json");

				    return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);
				
			}
			//-------------------------------------------------------------------------------------
			//------------------------------Get All RM Master-------------------------------------
			@RequestMapping(value = { "/getAllRawMaterial" }, method = RequestMethod.GET)
			public @ResponseBody ResponseEntity<byte[]> getAllRawMaterial()
			{
				RawMaterialResList rawMaterialDetailsList=rawMaterialService.getAllRawMaterialForTally();
				
				 String regData =JsonUtil.javaToJson(rawMaterialDetailsList);

				    byte[] output = regData.getBytes();

				    HttpHeaders responseHeaders = new HttpHeaders();

				    responseHeaders.setContentType(MediaType.valueOf("application/json;charset=UTF-8"));

				    responseHeaders.setContentLength(output.length);

				    responseHeaders.set("Content-disposition", "attachment; filename=allRawMaterial.json");

				    return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);
				
			}
			//----------------------------------------------------------------------------------------
			   @RequestMapping(value = { "/updateSupplier" }, method = RequestMethod.GET)
				public @ResponseBody ResponseEntity<byte[]> updateSupplier(@RequestParam("suppId")int suppId,@RequestParam("isTallySync")int isTallySync)
				  {

				  ErrorMessage errorMessage=supplierMasterService.updateSupplier(suppId,isTallySync);
					    
				  String regData =JsonUtil.javaToJson(errorMessage);

				    byte[] output = regData.getBytes();

				    HttpHeaders responseHeaders = new HttpHeaders();

				    responseHeaders.setContentType(MediaType.valueOf("application/json;charset=UTF-8"));

				    responseHeaders.setContentLength(output.length);

				    responseHeaders.set("Content-disposition", "attachment; filename=updateSupplier.json");

				    return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);
				  }
				//----------------------------------------------------------------------------------------
				   @RequestMapping(value = { "/updateRawMaterial" }, method = RequestMethod.GET)
					public @ResponseBody ResponseEntity<byte[]> updateRawMaterial(@RequestParam("rmId")int rmId,@RequestParam("isTallySync")int isTallySync)
					  {

					  ErrorMessage errorMessage=rawMaterialService.updateRawMaterial(rmId,isTallySync);
						    
					  String regData =JsonUtil.javaToJson(errorMessage);

					    byte[] output = regData.getBytes();

					    HttpHeaders responseHeaders = new HttpHeaders();

					    responseHeaders.setContentType(MediaType.valueOf("application/json;charset=UTF-8"));

					    responseHeaders.setContentLength(output.length);

					    responseHeaders.set("Content-disposition", "attachment; filename=updateRawMaterial.json");

					    return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);
					  }	
					@RequestMapping(value = { "/getAllInwards" }, method = RequestMethod.GET)
					public @ResponseBody ResponseEntity<byte[]> getAllInwards()
					{

						MaterialRecNoteList materialRecNoteRes = materialRecNoteService.getAllInwards();
						  String regData =JsonUtil.javaToJson(materialRecNoteRes);

						    byte[] output = regData.getBytes();

						    HttpHeaders responseHeaders = new HttpHeaders();

						    responseHeaders.setContentType(MediaType.valueOf("application/json;charset=UTF-8"));

						    responseHeaders.setContentLength(output.length);

						    responseHeaders.set("Content-disposition", "attachment; filename=allInwards.json");

						    return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);
					}
					
					//----------------------------------------------------------------------------------------
					   @RequestMapping(value = { "/updateInward" }, method = RequestMethod.GET)
						public @ResponseBody ResponseEntity<byte[]> updateInward(@RequestParam("mrnId")int mrnId,@RequestParam("isTallySync")int isTallySync)
						  {

						  ErrorMessage errorMessage=materialRecNoteService.updateInward(mrnId,isTallySync);
							    
						  String regData =JsonUtil.javaToJson(errorMessage);

						    byte[] output = regData.getBytes();

						    HttpHeaders responseHeaders = new HttpHeaders();

						    responseHeaders.setContentType(MediaType.valueOf("application/json;charset=UTF-8"));

						    responseHeaders.setContentLength(output.length);

						    responseHeaders.set("Content-disposition", "attachment; filename=updateInward.json");

						    return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);
						  }	
}
