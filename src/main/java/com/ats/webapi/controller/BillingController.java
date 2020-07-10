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

import com.ats.webapi.model.HsnwiseBillExcelSummary;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.SellBillDataCommon;
import com.ats.webapi.model.SellBillDetail;
import com.ats.webapi.model.SellBillDetailEdit;
import com.ats.webapi.model.SellBillDetailList;
import com.ats.webapi.model.SellBillDetails;
import com.ats.webapi.model.SellBillEditBean;
import com.ats.webapi.model.SellBillHeader;
import com.ats.webapi.model.TransactionDetail;
import com.ats.webapi.model.bill.ExpressBillService;
import com.ats.webapi.model.bill.GetItemHsnCode;
import com.ats.webapi.model.bill.SlabwiseBill;
import com.ats.webapi.model.bill.SlabwiseBillList;
import com.ats.webapi.repository.ExpressBillRepository;
import com.ats.webapi.repository.HsnwiseBillExcelSummaryRepository;
import com.ats.webapi.repository.SellBillDetailEditRepository;
import com.ats.webapi.repository.SellBillDetailRepository;
import com.ats.webapi.repository.SellBillDetailsRepository;
import com.ats.webapi.repository.SlabwiseDetailsRepository;
import com.ats.webapi.repository.TransactionDetailRepository;
import com.ats.webapi.repository.UpdateSellBillTimeStampRepo;

@RestController
public class BillingController {

	@Autowired
	ExpressBillService expressBillService;
	
	@Autowired
	SlabwiseDetailsRepository slabwiseDetailsRepository; 
	
	@Autowired
	UpdateSellBillTimeStampRepo  updateSellBillTimeStampRepo;
	
	@Autowired
	HsnwiseBillExcelSummaryRepository hsnwiseBillExcelSummaryRepository;
	
	@Autowired
	ExpressBillRepository  expressBillRepository;
	
	@Autowired
	SellBillDetailRepository sellBillDetailRepository;
	
	@Autowired
	SellBillDetailEditRepository sellBillDetailEditRepository;
	
	@Autowired
	TransactionDetailRepository transactionDetailRepository;
	
	
	@RequestMapping(value = { "/updateSellBillTimeStamp" }, method = RequestMethod.POST)
	public @ResponseBody Info updateSellBillTimeStamp(@RequestParam("sellBillNo") int sellBillNo,
			@RequestParam("timeStamp") String timeStamp) {
		
		Info info=new Info();

		int response=updateSellBillTimeStampRepo.updateTimeForSellBill(sellBillNo, timeStamp);
		
		if(response>0) {
			info.setError(false);
			info.setMessage("successfully Updated Time Stamp /updateSellBillTimeStamp");
		}
		System.err.println("BillingController -/updateSellBillTimeStamp ->response " +response);
		    
		return info;
	  }
	
	
	@RequestMapping(value = { "/deleteExBillHeader" }, method = RequestMethod.POST)
	public @ResponseBody int deleteExPBillHeader(@RequestParam("sellBillNo") int sellBillNo) {

		int response=expressBillService.deleteSellBillHeader(sellBillNo);
		    
		return response;
	  }
	
	
	 
	@RequestMapping(value = { "/showNotDayClosedRecord" }, method = RequestMethod.POST)
	public @ResponseBody SellBillDataCommon showNotDayClosedRecord(@RequestParam("frId") int frId) {

		SellBillDataCommon dayNotCloseRecord=expressBillService.showNotDayClosedRecord(frId);
		    
			return dayNotCloseRecord;
	  }
	
	@RequestMapping(value = { "/getSellBillDetails" }, method = RequestMethod.POST)
	public @ResponseBody SellBillDetailList getSellBillDetails(@RequestParam("billNo") int billNo) {

		SellBillDetailList sellBillDetailList=expressBillService.getSellBillDetails(billNo);
		    
			return sellBillDetailList;
	  }
	@RequestMapping(value = { "/getSellBillHeaderAndDetails" }, method = RequestMethod.POST)
	public @ResponseBody SellBillEditBean getSellBillHeaderAndDetails(@RequestParam("billNo") int billNo) {

		SellBillEditBean sellBillEditBean=new SellBillEditBean();
		SellBillHeader sellBillHeader=expressBillRepository.findBySellBillNo(billNo);
		List<SellBillDetailEdit> sellBillDetails=sellBillDetailEditRepository.findBySellBillNo(billNo);
		sellBillEditBean.setSellBillHeader(sellBillHeader);
		sellBillEditBean.setSellBillDetailList(sellBillDetails);	
		return sellBillEditBean;
	  }
	@RequestMapping(value = { "/saveSellBillHeader" }, method = RequestMethod.POST)
	public @ResponseBody SellBillHeader saveSellBillHeader(@RequestBody SellBillHeader sellBillHeader) {

		SellBillHeader sellBillHeaderRes=expressBillService.saveSellBillHeader(sellBillHeader);
		    
			return sellBillHeaderRes;
	  }
	@RequestMapping(value = { "/saveSellBillDetail" }, method = RequestMethod.POST)
	public @ResponseBody SellBillDetail saveSellBillDetail(@RequestBody SellBillDetail sellBillDetail) {

		SellBillDetail SellBillDetailRes=expressBillService.saveSellBillDetail(sellBillDetail);
		    
			return SellBillDetailRes;
	  }
	
	
	@RequestMapping(value = { "/getSellBillHeaderForDayClose" }, method = RequestMethod.POST)
	public @ResponseBody SellBillHeader getSellBillHeader(@RequestParam("sellBillNo") int sellBillNo) {
		
		SellBillHeader sellBillHeader=null;
		
		try {

		 sellBillHeader=expressBillService.getSellBillHeaderBysellBillNo(sellBillNo);
		 
		}catch (Exception e) {
			
			System.out.println("Exce in getting sell Bill Header "+e.getMessage());
			e.printStackTrace();
			
		}
			return sellBillHeader;
	  }
	
	
	
	@RequestMapping(value = { "/deleteSellBillDetail" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteSellBillDetail(
			@RequestParam("sellBillDetailNo") int sellBillDetailNo) {

		int result= expressBillService.deleteBillDetail(sellBillDetailNo);
		
		Info info=new Info();
		
		if(result>0) {
			
			info.setError(false);
			info.setMessage(" Sell Bill Detail Updated Successfully");
			
		}
		else {
			info.setError(true);
			info.setMessage("Error: Sell Bill Detail update  failed");
			
			
		}
			return info;
	  }
	@RequestMapping(value = { "/getItemHsnCode" }, method = RequestMethod.POST)
	public @ResponseBody GetItemHsnCode getItemHsnCode(@RequestParam("itemId") int itemId) {
	
		GetItemHsnCode getItemHsnCode=expressBillService.getItemHsnCode(itemId);
		
		return getItemHsnCode;
	}
	@RequestMapping(value = { "/getSlabwiseBillData" }, method = RequestMethod.POST)
	public @ResponseBody List<SlabwiseBillList> getSlabwiseBillData(@RequestParam("billNoList") List<String> billNos) {
	
		List<SlabwiseBillList> slabwiseBillList=new ArrayList<SlabwiseBillList>();
		for(int i=0;i<billNos.size();i++)
		{
			System.out.println("billNo"+billNos.get(i));
			
		  SlabwiseBillList slabwiseBill=new SlabwiseBillList();
		  
		  List<SlabwiseBill> slabwiseBills=slabwiseDetailsRepository.getSlabwiseBillData(Integer.parseInt(billNos.get(i)));
		  System.out.println("slabwiseBills"+slabwiseBills.toString());
		  slabwiseBill.setBillNo(Integer.parseInt(billNos.get(i)));
		  slabwiseBill.setSlabwiseBill(slabwiseBills);
		  slabwiseBillList.add(slabwiseBill);
		  System.out.println("slabwiseBillList"+slabwiseBillList.toString());

		}
		return slabwiseBillList;
	}
	@RequestMapping(value = { "/getHsnwiseBillDataForExcel" }, method = RequestMethod.POST)
	public @ResponseBody List<HsnwiseBillExcelSummary> getHsnwiseBillDataForExcel(@RequestParam("billNoList") List<String> billNos,@RequestParam("all")int all,@RequestParam("fromDate")String fromDate,@RequestParam("toDate")String toDate) {
		List<HsnwiseBillExcelSummary> hsnwiseBills=new ArrayList<HsnwiseBillExcelSummary>();
		if(all==0) {
		hsnwiseBills=hsnwiseBillExcelSummaryRepository.getHsnwiseBillDataForExcel(billNos);
		}
		else
		{
			hsnwiseBills=hsnwiseBillExcelSummaryRepository.getHsnwiseBillDataForExcelAll(fromDate,toDate);

		}
		return hsnwiseBills;
	}
	
	//SACHIN 11 MAY
	@RequestMapping(value = { "/getHsnwiseBillDataForExcelV2" }, method = RequestMethod.POST)
	public @ResponseBody List<HsnwiseBillExcelSummary> getHsnwiseBillDataForExcelV2(@RequestParam("frIdList")List<String> frIdList,@RequestParam("fromDate")String fromDate,@RequestParam("toDate")String toDate) {
		List<HsnwiseBillExcelSummary> hsnwiseBills=new ArrayList<HsnwiseBillExcelSummary>();
		if(frIdList.contains("-1")) {
		System.err.println("All Fr ");
		hsnwiseBills=hsnwiseBillExcelSummaryRepository.getHsnwiseBillDataForExcelAllFr(fromDate, toDate);
		}
		else
		{
			System.err.println("Multi Fr ");
			hsnwiseBills=hsnwiseBillExcelSummaryRepository.getHsnwiseBillDataForExcelMultiFr(fromDate, toDate, frIdList);

		}
		return hsnwiseBills;
	}
	
	@RequestMapping(value = { "/saveTransactionDetail" }, method = RequestMethod.POST)
	public @ResponseBody List<TransactionDetail> saveTransactionDetail(
			@RequestBody List<TransactionDetail> transactionDetail) {

		List<TransactionDetail> transactionDetailRes = transactionDetailRepository.save(transactionDetail);

		return transactionDetailRes;
	}
	
	@RequestMapping(value = { "/deleteTransactionDetails" }, method = RequestMethod.POST)
	public @ResponseBody int deleteTransactionDetails(@RequestParam("sellBillNo") int sellBillNo) {

		int response = transactionDetailRepository.deleteTransactionDetails(sellBillNo);

		return response;
	}

	@RequestMapping(value = { "/deleteTransactionDetailsByIsAdvAmt" }, method = RequestMethod.POST)
	public @ResponseBody int deleteTransactionDetailsByIsAdvAmt(@RequestParam("sellBillNo") int sellBillNo,
			@RequestParam("advAmtStatus") int advAmtStatus) {

		int response = transactionDetailRepository.deleteTransactionDetailsByIsAdvAmt(sellBillNo, advAmtStatus);

		return response;
	}

	@RequestMapping(value = { "/getAdvAmtTransaction" }, method = RequestMethod.POST)
	public @ResponseBody TransactionDetail getAdvAmtTransaction(@RequestParam("sellBillNo") int sellBillNo) {

		TransactionDetail transactionDetailRes = transactionDetailRepository.getAdvAmtTransaction(sellBillNo);

		return transactionDetailRes;
	}
	
	
	@RequestMapping(value = { "/deleteSellBillDetailByItemId" }, method = RequestMethod.POST)
	public @ResponseBody int deleteSellBillDetailByItemId(@RequestParam("sellBillNo") int sellBillNo,
			@RequestParam("itemId") int itemId) {

		int response = sellBillDetailRepository.deleteSellBillDetailByItemId(sellBillNo, itemId);

		return response;
	}
	
	@RequestMapping(value = { "/getTransactionByBillId" }, method = RequestMethod.POST)
	public @ResponseBody TransactionDetail getTransactionByBillId(@RequestParam("sellBillNo") int sellBillNo) {

		TransactionDetail transactionDetailRes = transactionDetailRepository.getTransactionByBillId(sellBillNo);

		return transactionDetailRes;
	}
	
	
}
