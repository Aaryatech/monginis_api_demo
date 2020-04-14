package com.ats.webapi.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.commons.Common;
import com.ats.webapi.model.GetPoDetailedForPdf;
import com.ats.webapi.model.GetPoHeaderForPdf;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.purchaseorder.GetPurchaseOrderList;
import com.ats.webapi.model.purchaseorder.GetRmRateAndTax;
import com.ats.webapi.model.purchaseorder.PoDetailsByChkSupp;
import com.ats.webapi.model.purchaseorder.PurchaseOrderDetail;
import com.ats.webapi.model.purchaseorder.PurchaseOrderDetailedList;
import com.ats.webapi.model.purchaseorder.PurchaseOrderHeader;
import com.ats.webapi.model.purchaseorder.TransporterDetails;
import com.ats.webapi.repository.GetPoDetailedForPdfRepository;
import com.ats.webapi.repository.GetPoDetailedPdfRepository;
import com.ats.webapi.repository.PoDetailsByChkSuppRepository;
import com.ats.webapi.repository.PurchaseOrderDetailRepository;
import com.ats.webapi.repository.PurchaseOrderHeaderRepository;
import com.ats.webapi.service.FrItemStockConfigureService;
import com.ats.webapi.service.purchaseorder.PurchaseOrderService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
@RequestMapping("/purchaseOrder")
public class PurchaseOrderApiController {

	@Autowired
	PurchaseOrderService purchaseOrderService;
	
	@Autowired
	FrItemStockConfigureService frItemStockConfigureService;
	
	@Autowired
	PurchaseOrderHeaderRepository purchaseOrderHeaderRepository;
	
	@Autowired
	GetPoDetailedForPdfRepository getPoDetailedForPdfRepository;
	
	@Autowired
	GetPoDetailedPdfRepository getPoDetailedPdfRepository;

	@Autowired
	PoDetailsByChkSuppRepository poDetailsByChkSuppRepository;
	
	//----------------------Get Data Of Raw Material Item Categories---------------
		@RequestMapping(value = { "/insertPurchaseOrder" }, method = RequestMethod.POST)
		public Info insertPurchaseOrder(@RequestBody  PurchaseOrderHeader purchaseOrderHeader)throws ParseException, JsonParseException, JsonMappingException, IOException 
		{
			System.out.println("Data for insert : "+purchaseOrderHeader.toString());
			purchaseOrderHeader.setDelvDateRem(Common.convertToYMD(purchaseOrderHeader.getDelvDateRem()));
			purchaseOrderHeader.setQuotationRefDate(Common.convertToYMD(purchaseOrderHeader.getQuotationRefDate()));
			System.out.println("Data for AFTER : "+purchaseOrderHeader.toString());
		/*	purchaseOrderHeader.setPoDate(Common.convertToYMD(purchaseOrderHeader.getPoDate()));
			List<PurchaseOrderDetail> purchaseOrderDetailList=new ArrayList<PurchaseOrderDetail>();
			for(int i=0; i<purchaseOrderHeader.getPurchaseOrderDetail().size();i++)
			{
				PurchaseOrderDetail PurchaseOrderDetail =purchaseOrderHeader.getPurchaseOrderDetail().get(i);
				PurchaseOrderDetail.setPoDate(Common.convertToYMD(PurchaseOrderDetail.getPoDate()));
				purchaseOrderDetailList.add(PurchaseOrderDetail);
				//purchaseOrderHeader.setPurchaseOrderDetail(PurchaseOrderDetail);
			}
			purchaseOrderHeader.setPurchaseOrderDetail(purchaseOrderDetailList);*/
			Info info=purchaseOrderService.insertHeader(purchaseOrderHeader);
		 
			return info;
		}
		
		@RequestMapping(value = { "/getpurchaseorderList" }, method = RequestMethod.POST)
		public GetPurchaseOrderList getpurchaseorderList(@RequestParam("status")List<String> status)
		{
			GetPurchaseOrderList getPurchaseOrderList = purchaseOrderService.getStatusWisePerchaseOrderList(status);
			
			System.out.println(getPurchaseOrderList);
			return getPurchaseOrderList;
			
			
		}
		@RequestMapping(value = { "/dateWisePo" }, method = RequestMethod.POST)
		public GetPurchaseOrderList dateWisePo(@RequestParam("status")List<String> status,@RequestParam("fromDate")String fromDate,@RequestParam("toDate")String toDate)
		{
			 List<PurchaseOrderHeader> getDateWisePerchaseOrderList = purchaseOrderHeaderRepository.getDateWisePerchaseOrderList(status,fromDate,toDate);
			 GetPurchaseOrderList getPurchaseOrderList = new GetPurchaseOrderList();
			 getPurchaseOrderList.setPurchaseOrderHeaderList(getDateWisePerchaseOrderList);
			System.out.println(getPurchaseOrderList);
			return getPurchaseOrderList;
			
			
		}
		
		@RequestMapping(value = { "/getpurchaseorderHeaderWithDetailed" }, method = RequestMethod.POST)
		public PurchaseOrderHeader getpurchaseorderHeaderWithDetailed(@RequestParam("poId")int poId)
		{
			PurchaseOrderHeader getPurchaseOrder = purchaseOrderService.getpurchaseorderHeaderWithDetailed(poId);
			
			System.out.println(getPurchaseOrder);
			return getPurchaseOrder;
			
			
		}
		
		@RequestMapping(value = { "/getpurchaseorderHeader" }, method = RequestMethod.POST)
		public PurchaseOrderHeader getpurchaseorderHeader(@RequestParam("poId")int poId)
		{
			PurchaseOrderHeader getPurchaseOrder = new PurchaseOrderHeader ();
			try {
				 getPurchaseOrder = purchaseOrderHeaderRepository.findbyPoId(poId);
				
				System.out.println(getPurchaseOrder);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			
			return getPurchaseOrder;
			
			
		}

		@RequestMapping(value = { "/poDetailsByChkSuppList" }, method = RequestMethod.POST)
		public List<PoDetailsByChkSupp> poDetailsByChkSuppList(@RequestParam("suppId")int suppId)
		{
			 List<PoDetailsByChkSupp> poDetailByChkSuppList = null; 
			 try {
				 poDetailByChkSuppList = poDetailsByChkSuppRepository.getPoDetailsBySuppId(suppId);
			 }
			 catch (Exception e) {
				e.printStackTrace();
			}
			 
			 return poDetailByChkSuppList;
			
			
		}
		@RequestMapping(value = { "/deletePoRecord" }, method = RequestMethod.POST)
		public Info deletePoRecord(@RequestParam("poId")int poId)
		{
			Info info = purchaseOrderService.deletePoRecord(poId);
			
			System.out.println(info);
			return info;
			
			
		}
		
		 
		@RequestMapping(value = { "/purchaseorderList" }, method = RequestMethod.POST)
		public GetPurchaseOrderList perchaseorderList(@RequestParam("suppId")int suppId)
		{
			GetPurchaseOrderList getPurchaseOrderList = purchaseOrderService.perchaseorderList(suppId);
			
			System.out.println(getPurchaseOrderList);
			return getPurchaseOrderList;
			
			
		}
		
		@RequestMapping(value = { "/purchaseorderdetailedList" }, method = RequestMethod.POST)
		public PurchaseOrderDetailedList perchaseorderdetailedList(@RequestParam("poId")int poId)
		{
			PurchaseOrderDetailedList PurchaseOrderDetailedList = purchaseOrderService.purchaseOrderDetailedList(poId);
		
			
			System.out.println("List  :"+PurchaseOrderDetailedList.toString());
			return PurchaseOrderDetailedList;
		}
 
 
		@RequestMapping(value = { "/getRmDetailByRmId" }, method = RequestMethod.POST)
		public GetRmRateAndTax getRmDetailByRmId(@RequestParam("rmId")int rmId, @RequestParam("suppId")int suppId )
		{
			GetRmRateAndTax getRmRateAndTax= purchaseOrderService.getRmDetailById(rmId, suppId);
			
			 
			return getRmRateAndTax;
	 	
			
		}
		
		@RequestMapping(value = { "/getPoNo" }, method = RequestMethod.GET)
		public int getPoNo()
		{
			int poNo=frItemStockConfigureService.getPoNo();
			return poNo;
		}
		
		@RequestMapping(value = { "/poDetailedForPdf" }, method = RequestMethod.POST)
		public GetPoHeaderForPdf poDetailedForPdf(@RequestParam("poId")int poId)
		{
			GetPoHeaderForPdf poDetailedForPdf = new GetPoHeaderForPdf();
			try
			{
				 poDetailedForPdf = getPoDetailedForPdfRepository.poDetailedForPdf(poId);
					List<GetPoDetailedForPdf> purchaseOrderDetaillist = getPoDetailedPdfRepository.purchaseOrderDetaillist(poId);
					poDetailedForPdf.setPurchaseOrderDetail(purchaseOrderDetaillist);
					System.out.println("poDetailedForPdf "+poDetailedForPdf);
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			
			return poDetailedForPdf;
			
			
		}
		
}
