package com.ats.webapi.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.FrItemStockConfigureList;
import com.ats.webapi.model.SellBillDetail;
import com.ats.webapi.model.gatesale.GateEmployee;
import com.ats.webapi.model.gatesale.GateSaleBillDetail;
import com.ats.webapi.model.gatesale.GateSaleBillHeader;
import com.ats.webapi.model.gatesale.GateSaleBillHeaderRes;
import com.ats.webapi.model.gatesale.GateSaleBillHeaderResp;
import com.ats.webapi.model.gatesale.GateSaleDiscList;
import com.ats.webapi.model.gatesale.GateSaleDiscount;
import com.ats.webapi.model.gatesale.GateSaleUser;
import com.ats.webapi.model.gatesale.GateSaleUserList;
import com.ats.webapi.model.gatesale.GetGateSaleEmp;
import com.ats.webapi.model.gatesale.GetGateSaleEmpList;
import com.ats.webapi.model.gatesale.OtherItem;
import com.ats.webapi.model.gatesale.OtherItemList;
import com.ats.webapi.model.gatesale.OtherSupplier;
import com.ats.webapi.model.gatesale.OtherSupplierList;
import com.ats.webapi.repository.gatesale.GateSaleBillDetailRepository;
import com.ats.webapi.repository.gatesale.GateSaleBillDetailResRepository;
import com.ats.webapi.repository.gatesale.GateSaleBillHeaderRepository;
import com.ats.webapi.service.FrItemStockConfigureService;
import com.ats.webapi.service.gatesale.GateSaleService;

@RestController
@RequestMapping("/gatesale")
public class GateSaleController {

	@Autowired
	GateSaleService gateSaleService;
	@Autowired
	FrItemStockConfigureService frItemStockConfigureService;
	//----------------------Save Gate Sale User------------------------------------
	@RequestMapping(value = { "/saveGateSaleUser" }, method = RequestMethod.POST)
	public @ResponseBody ErrorMessage saveGateSaleUser(@RequestBody GateSaleUser gateSaleUser)
	{
		
		ErrorMessage errorMessage=gateSaleService.saveGateSaleUser(gateSaleUser);
		
		return errorMessage;
	}
	//--------------------------END--------------------------------------------------
	//--------------------------Delete Gate Sale User--------------------------------------------------
		@RequestMapping(value = { "/deleteGateSaleUser" }, method = RequestMethod.POST)
		public @ResponseBody ErrorMessage deleteGateSaleUser(@RequestParam("userId")int userId)
		{
			
			ErrorMessage errorMessage=gateSaleService.deleteGateSaleUser(userId);
			
			return errorMessage;
		}
	//--------------------------END--------------------------------------------------
		// ---------------------------Getting GateSaleUser List-------------------------
		@RequestMapping(value = { "/getGateSaleUserList" }, method = RequestMethod.GET)
		public @ResponseBody GateSaleUserList getGateSaleUserList() {

			GateSaleUserList gateSaleUserList = gateSaleService.getGateSaleUserList();

			return gateSaleUserList;

		}
		//-----------------------------------------------------------------------------
		// ---------------------------Getting GateSaleUser By userId-------------------------
		@RequestMapping(value = { "/getGateSaleUserByUserId" }, method = RequestMethod.POST)
		public @ResponseBody GateSaleUser getGateSaleUserByUserId(@RequestParam("userId")int userId) {

			GateSaleUser gateSaleUserRes = gateSaleService.getGateSaleUserByUserId(userId);
            
			return gateSaleUserRes;

		}
	    //------------------------------------------------------------------------------------
		// ---------------------------Getting LoginUser-------------------------
		@RequestMapping(value = { "/loginUser" }, method = RequestMethod.POST)
		public @ResponseBody GateSaleUser loginUser(@RequestParam("mobile")String mobile,@RequestParam("password")String password) {

			GateSaleUser gateSaleUserRes = gateSaleService.loginUser(mobile,password);
		            
			return gateSaleUserRes;

		}
		//------------------------------------------------------------------------------------
		// ---------------------------Update userToken-------------------------
		@RequestMapping(value = { "/updateUserToken" }, method = RequestMethod.POST)
		public @ResponseBody ErrorMessage updateUserToken(@RequestParam("userId")int userId,@RequestParam("token")String token) {

			ErrorMessage errorMessage = gateSaleService.updateUserToken(userId,token);
				            
		return errorMessage;

		}
		//------------------------------------------------------------------------------------
		//----------------------Save Gate Sale Discount------------------------------------
		@RequestMapping(value = { "/saveGateSaleDiscount" }, method = RequestMethod.POST)
		public @ResponseBody ErrorMessage saveGateSaleDiscount(@RequestBody GateSaleDiscount gateSaleDiscount)
		{
			
			ErrorMessage errorMessage=gateSaleService.saveGateSaleDiscount(gateSaleDiscount);
			
			return errorMessage;
		}
		//--------------------------END------------------------------------------------------
		//--------------------------Delete Gate Sale Discount--------------------------------
		@RequestMapping(value = { "/deleteGateSaleDiscount" }, method = RequestMethod.POST)
		public @ResponseBody ErrorMessage deleteGateSaleDiscount(@RequestParam("discountId")int discountId)
		{
			
			ErrorMessage errorMessage=gateSaleService.deleteGateSaleDiscount(discountId);
			
			return errorMessage;
		}
	//----------------------------------END-------------------------------------------------
		// ---------------------------Getting Gate Sale Discount List-----------------------
		@RequestMapping(value = { "/getGateSaleDiscList" }, method = RequestMethod.GET)
		public @ResponseBody GateSaleDiscList getGateSaleDiscList() {

			GateSaleDiscList gateSaleDiscList = gateSaleService.getGateSaleDiscList();

			return gateSaleDiscList;

		}
		//-------------------------------END----------------------------------------------
		// ---------------------------Getting Gate Sale Discount List By CatId-----------------------
		@RequestMapping(value = { "/getGateSaleDiscListByCatId" }, method = RequestMethod.POST)
		public @ResponseBody GateSaleDiscList getGateSaleDiscListByCatId(@RequestParam("catId")int catId) {

			GateSaleDiscList gateSaleDiscList = gateSaleService.getGateSaleDiscListByCatId(catId);

			return gateSaleDiscList;

		}
		//-------------------------------END----------------------------------------------
		// ---------------------------Getting GateSaleDiscount By discountId-------------------------
		@RequestMapping(value = { "/getGateSaleDiscByDiscId" }, method = RequestMethod.POST)
		public @ResponseBody GateSaleDiscount getGateSaleDiscByDiscId(@RequestParam("discountId")int discountId) {

			GateSaleDiscount gateSaleDiscountRes = gateSaleService.getGateSaleDiscByDiscId(discountId);
		            
			return gateSaleDiscountRes;

		}
	   //----------------------------END-------------------------------------------------
		// ---------------------------Getting GateSaleDiscount By userType-------------------------
				@RequestMapping(value = { "/getGateSaleDiscByUsrType" }, method = RequestMethod.POST)
				public @ResponseBody List<GateSaleDiscount> getGateSaleDiscByUsrType(@RequestParam("userType")int userType) {

					List<GateSaleDiscount> gateSaleDiscountRes = gateSaleService.getGateSaleDiscByUsrType(userType);
				            
					return gateSaleDiscountRes;

				}
			   //----------------------------END-------------------------------------------------
		//----------------------Save Employee------------------------------------
		@RequestMapping(value = { "/saveGateEmployee" }, method = RequestMethod.POST)
		public @ResponseBody ErrorMessage saveGateEmployee(@RequestBody GateEmployee gateEmployee)
		{
			
			ErrorMessage errorMessage=gateSaleService.saveGateEmployee(gateEmployee);
			
			return errorMessage;
		}
		//--------------------------END--------------------------------------------------
		//--------------------------Delete GateEmployee--------------------------------------------------
		@RequestMapping(value = { "/deleteGateEmployee" }, method = RequestMethod.POST)
		public @ResponseBody ErrorMessage deleteGateEmployee(@RequestParam("empId")int empId)
		{
					
			ErrorMessage errorMessage=gateSaleService.deleteGateEmployee(empId);
					
			return errorMessage;
		}
		//--------------------------END--------------------------------------------------
		//---------------------------Getting Gate  Emp List-------------------------
		@RequestMapping(value = { "/getGateEmpList" }, method = RequestMethod.GET)
		public @ResponseBody GetGateSaleEmpList getGateEmpList() {

			GetGateSaleEmpList getGateSaleEmpList = gateSaleService.getGateEmpList();

			return getGateSaleEmpList;

		}
		//------------------------------END-----------------------------------------------
	    //---------------------------Getting GateEmpList By empId-------------------------
		@RequestMapping(value = { "/getGateEmpByEmpId" }, method = RequestMethod.POST)
		public @ResponseBody GetGateSaleEmp getGateEmpByEmpId(@RequestParam("empId")int empId) {

			GetGateSaleEmp getGateSaleEmpRes = gateSaleService.getGateEmpByEmpId(empId);
				            
		 return getGateSaleEmpRes;

		}
	    //----------------------------------END-------------------------------------------
		//----------------------Insert GateSaleBill------------------------------------
		@RequestMapping(value = { "/saveGateSaleBill" }, method = RequestMethod.POST)
		public @ResponseBody ErrorMessage saveGateSaleBill(@RequestBody GateSaleBillHeader gateSaleBillHeader)
		{
			ErrorMessage errorMessage=new ErrorMessage();
			try {
			
			Date date = new Date();
			gateSaleBillHeader.setBillDate(date);
			List<String> key=new ArrayList<String>();
			key.add("gate_sale_invoice");
			key.add("gate_sale_alphabet");
			FrItemStockConfigureList settingList = frItemStockConfigureService.findBySettingKeyList(key);
			int invoiceNumber = 0;
			int asciiValAlpha =65;
            for(int i=0;i<settingList.getFrItemStockConfigure().size();i++)
            {
            	if(settingList.getFrItemStockConfigure().get(i).getSettingKey().equals("gate_sale_invoice"))
            	{
            		invoiceNumber=settingList.getFrItemStockConfigure().get(i).getSettingValue();
            	}
            	if(settingList.getFrItemStockConfigure().get(i).getSettingKey().equals("gate_sale_alphabet"))
            	{
            		asciiValAlpha=settingList.getFrItemStockConfigure().get(i).getSettingValue();
            	} 
            }
            
         
			int invLenth=String.valueOf(invoiceNumber).length();
			invLenth=4-invLenth;
			StringBuilder invoiceNo=new StringBuilder(""+(char)asciiValAlpha);
			
			for(int i=0;i<invLenth;i++)
			{ 
				String j="0";
				invoiceNo.append(j);
			}
			invoiceNo.append(String.valueOf(invoiceNumber));
			System.out.println("invoiceNo"+invoiceNo);
			gateSaleBillHeader.setInvoiceNo(""+invoiceNo);
			 errorMessage=gateSaleService.saveGateSaleBill(gateSaleBillHeader);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			return errorMessage;
		}
		
		
		//Insert Gate Sale Bill Patna By Admin(BackEnd)
		@Autowired
		GateSaleBillHeaderRepository gateSaleBillHeaderRepository;
		
		@Autowired
		GateSaleBillDetailRepository gateSaleBillDetailRepository;
		
		@RequestMapping(value = { "/insertGateSaleBill" }, method = RequestMethod.POST)
		public @ResponseBody ErrorMessage insertGateSaleBill(@RequestBody GateSaleBillHeader gateSaleBillHeader)
		{
			ErrorMessage errorMessage=new ErrorMessage();
			
			try {
				
				GateSaleBillHeader headRes=gateSaleBillHeaderRepository.saveAndFlush(gateSaleBillHeader);
				
				int billId=0;
				
				if(headRes!=null) {
					
				errorMessage.setError(false);
				errorMessage.setMessage("Header Saved Successfull");
				billId=headRes.getBillId();
				
				}else {
					
					errorMessage.setError(true);
					errorMessage.setMessage("Header Not Saved Successfull");
					
				}
				
				List<GateSaleBillDetail> sBillDetailsList=gateSaleBillHeader.getGateSaleBillDetailList();
				
				for(int i=0;i<sBillDetailsList.size();i++) {
					
					if(billId!=0) {
					
						sBillDetailsList.get(i).setBillId(billId);
					
						GateSaleBillDetail detailRes=gateSaleBillDetailRepository.saveAndFlush(sBillDetailsList.get(i));
					
						if(detailRes!=null) {
							
							errorMessage.setError(false);
							errorMessage.setMessage("Detail Saved Successfull");
							
						}
						else {
							
							errorMessage.setError(true);
							errorMessage.setMessage("Detail Not Saved Successfull");
							
						}
					
					}
				}
			}catch (Exception e) {
				
				System.err.println("Exception in saving GateSaleBillHeader Detail @GateSaleController " +e.getMessage());
				
				e.printStackTrace();
	
			}
			
			return errorMessage;
			
		}
		     //--------------------------END--------------------------------------------------
		     // ---------------------------Getting GateBillHeaderAndDetails By userId-------------------------
				@RequestMapping(value = { "/gateBillHeaderAndDetails" }, method = RequestMethod.POST)
				public @ResponseBody List<GateSaleBillHeaderResp> gateBillHeaderAndDetails(@RequestParam("fromDate")String fromDate,@RequestParam("toDate")String toDate,
						@RequestParam("isApproved")int isApproved,@RequestParam("approvedUserId")int approvedUserId,@RequestParam("amtIsCollected")int amtIsCollected,
						@RequestParam("collectedUserId")int collectorUserId) {

					List<GateSaleBillHeaderResp> gateBillHeadersRes = gateSaleService.gateBillHeaderAndDetails(fromDate,toDate,isApproved,approvedUserId,amtIsCollected,collectorUserId);
		            
					return gateBillHeadersRes;

				}
			    //------------------------------------------------------------------------------------
				   // ---------------------------Getting GateBillHeaderAndDetails(initiator)-------------------------
				@RequestMapping(value = { "/gateBillHeaderAndDetailsByInitiator" }, method = RequestMethod.POST)
				public @ResponseBody List<GateSaleBillHeaderResp> gateBillHeaderAndDetailsByInitiator(@RequestParam("fromDate")String fromDate,@RequestParam("toDate")String toDate,
						@RequestParam("isApproved")int isApproved,@RequestParam("initiatorUserId")int initiatorUserId) {

					List<GateSaleBillHeaderResp> gateBillHeadersRes = gateSaleService.gateBillHeaderAndDetailsByInitiator(fromDate,toDate,isApproved,initiatorUserId);
		            
					return gateBillHeadersRes;

				}
			    //------------------------------------------------------------------------------------
				// ---------------------------Getting GateBillHeaderAndDetails-------------------------
				@RequestMapping(value = { "/gateBillDetailsAmtPending" }, method = RequestMethod.GET)
				public @ResponseBody List<GateSaleBillHeaderRes> gateBillDetailsAmtPending() {

					List<GateSaleBillHeaderRes> gateBillHeadersRes = gateSaleService.gateBillDetailsAmtPending();
		            
					return gateBillHeadersRes;

				}
			    //------------------------------------------------------------------------------------
				// ---------------------------Getting GateBillHeaderAndDetails-------------------------
				@RequestMapping(value = { "/gateBillDetailAmtPending" }, method = RequestMethod.POST)
				public @ResponseBody List<GateSaleBillHeaderRes> gateBillDetailAmtPending(@RequestParam("isApproved")int isApproved,@RequestParam("amtIsCollected")int amtIsCollected) {

					List<GateSaleBillHeaderRes> gateBillHeadersRes = gateSaleService.gateBillDetailAmtPending(isApproved,amtIsCollected);
		            
					return gateBillHeadersRes;

				}
			    //------------------------------------------------------------------------------------
				//----------------------approveGetSaleBill------------------------------------
				@RequestMapping(value = { "/approveGetSaleBill" }, method = RequestMethod.POST)
				public @ResponseBody ErrorMessage approveGetSaleBill(@RequestParam("billId")int billId,@RequestParam("isApproved")int isApproved,@RequestParam("approvedUserId")int approvedUserId)
				{
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					LocalDate localDate = LocalDate.now();
					ErrorMessage errorMessage=gateSaleService.approveGetSaleBill(billId,isApproved,dtf.format(localDate),approvedUserId);
					
					return errorMessage;
				}
				//--------------------------END--------------------------------------------------	
				
				//----------------------collectGetSaleAmt------------------------------------
				@RequestMapping(value = { "/collectGetSaleAmt" }, method = RequestMethod.POST)
				public @ResponseBody ErrorMessage collectGetSaleAmt(@RequestParam("collectedUserId")int collectedUserId)
				{
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					LocalDate localDate = LocalDate.now();
					ErrorMessage errorMessage=gateSaleService.collectGetSaleAmt(dtf.format(localDate),collectedUserId);
					
					return errorMessage;
				}
				//--------------------------END--------------------------------------------------	
				//----------------------collectGetSaleAmtOfBill------------------------------------
				@RequestMapping(value = { "/collectGetSaleAmtOfBill" }, method = RequestMethod.POST)
				public @ResponseBody ErrorMessage collectGetSaleAmtOfBill(@RequestParam("collectedUserId")int collectedUserId,@RequestParam("amtIsCollected")int amtIsCollected,@RequestParam("billIds")List<Integer> billIds)
				{
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					LocalDate localDate = LocalDate.now();
					ErrorMessage errorMessage=gateSaleService.collectGetSaleAmtOfBill(dtf.format(localDate),collectedUserId,amtIsCollected,billIds);
					
					return errorMessage;
				}
				//--------------------------END--------------------------------------------------	
				//----------------------Save GateSaleOtherSupplier------------------------------------
				@RequestMapping(value = { "/saveGateOtherSupplier" }, method = RequestMethod.POST)
				public @ResponseBody ErrorMessage saveGateOtherSupplier(@RequestBody OtherSupplier otherSupplier)
				{
					
					ErrorMessage errorMessage=gateSaleService.saveGateOtherSupplier(otherSupplier);
					
					return errorMessage;
				}
				//--------------------------END--------------------------------------------------
				//----------------------Save GateSaleSaleOtherItem------------------------------------
				@RequestMapping(value = { "/saveGateOtherItem" }, method = RequestMethod.POST)
				public @ResponseBody ErrorMessage saveGateOtherItem(@RequestBody OtherItem otherItem)
				{
					
					ErrorMessage errorMessage=gateSaleService.saveGateOtherItem(otherItem);
					
					return errorMessage;
				}
				//--------------------------END--------------------------------------------------
				//--------------------------Delete GateOtherItem--------------------------------------------------
				@RequestMapping(value = { "/deleteGateOtherItem" }, method = RequestMethod.POST)
				public @ResponseBody ErrorMessage deleteGateOtherItem(@RequestParam("itemId")int itemId)
				{
							
					ErrorMessage errorMessage=gateSaleService.deleteGateOtherItem(itemId);
							
					return errorMessage;
				}
				//--------------------------END--------------------------------------------------
				//--------------------------Delete GateOtherSupplier--------------------------------------------------
				@RequestMapping(value = { "/deleteGateOtherSupplier" }, method = RequestMethod.POST)
				public @ResponseBody ErrorMessage deleteGateOtherSupplier(@RequestParam("suppId")int suppId)
				{
							
					ErrorMessage errorMessage=gateSaleService.deleteGateOtherSupplier(suppId);
							
					return errorMessage;
				}
				//--------------------------END--------------------------------------------------
				//---------------------------Getting GateSupplierList-------------------------
				@RequestMapping(value = { "/getGateOtherSuppList" }, method = RequestMethod.GET)
				public @ResponseBody OtherSupplierList getGateOtherSuppList() {

					OtherSupplierList otherSupplierListRes = gateSaleService.getGateOtherSuppList();

					return otherSupplierListRes;

				}
				//------------------------------END-----------------------------------------------
				// ---------------------------Getting Gate OtherItem List By suppId-----------------------
				@RequestMapping(value = { "/getGateOtherItemBySuppId" }, method = RequestMethod.POST)
				public @ResponseBody OtherItemList getGateOtherItemBySuppId(@RequestParam("suppId")int suppId) {

					OtherItemList otherItemListRes = gateSaleService.getGateOtherItemBySuppId(suppId);

					return otherItemListRes;

				}
				//-------------------------------END----------------------------------------------
				// ---------------------------Getting GateOtherItem By itemId-------------------------
				@RequestMapping(value = { "/getGateOtherItemByItemId" }, method = RequestMethod.POST)
				public @ResponseBody OtherItem getGateOtherItemByItemId(@RequestParam("itemId")int itemId) {

					OtherItem gateOtherItemRes = gateSaleService.getGateOtherItemByItemId(itemId);
		            
					return gateOtherItemRes;

				}
			    //------------------------------------------------------------------------------------
				// ---------------------------Getting GateOtherSupplier By SuppId-------------------------
				@RequestMapping(value = { "/getGateOtherSupplierBySuppId" }, method = RequestMethod.POST)
				public @ResponseBody OtherSupplier getGateOtherSupplierBySuppId(@RequestParam("suppId")int suppId) {

					OtherSupplier gateOtherSupplierRes = gateSaleService.getGateOtherSupplierBySuppId(suppId);
		            
					return gateOtherSupplierRes;

				}
			    //------------------------------------------------------------------------------------
}
