package com.ats.webapi.controller;

import java.io.IOException;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.commons.Common;
import com.ats.webapi.model.BillWisePurchaseList;
import com.ats.webapi.model.BillWiseTaxReportList;
import com.ats.webapi.model.ItemReport;
import com.ats.webapi.model.ItemReportDetail;
import com.ats.webapi.model.ItemWiseDetailList;
import com.ats.webapi.model.ItemWiseReportList;
import com.ats.webapi.model.MonthWiseReportList;
import com.ats.webapi.model.Orders;
import com.ats.webapi.model.POrder;
import com.ats.webapi.model.report.DispatchReport;
import com.ats.webapi.model.report.GetCustBillTax;
import com.ats.webapi.model.report.GetCustomerBill;
import com.ats.webapi.model.report.GetRepFrDatewiseSell;
import com.ats.webapi.model.report.GetRepItemwiseSell;
import com.ats.webapi.model.report.GetRepMenuwiseSell;
import com.ats.webapi.model.report.GetRepMonthwiseSell;
import com.ats.webapi.model.report.GetRepTaxSell;
import com.ats.webapi.model.report.PDispatchReport;
import com.ats.webapi.model.report.SpFlavourWiseSummaryDao;
import com.ats.webapi.model.report.SpKgSummaryDao;
import com.ats.webapi.repository.DispatchOrderRepository;
import com.ats.webapi.repository.ItemReportDetailRepo;
import com.ats.webapi.repository.ItemReportRepo;
import com.ats.webapi.repository.PDispatchReportRepository;
import com.ats.webapi.repository.SpFlavourWiseSummaryRepo;
import com.ats.webapi.repository.SpKgSummaryRepository;
import com.ats.webapi.service.RepFrSellServise;
import com.ats.webapi.service.ReportsService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
public class ReportsController {

	@Autowired
	ReportsService reportsService;

	@Autowired
	RepFrSellServise repFrSellServise;

	@Autowired
	PDispatchReportRepository pDispatchReportRepository;

	@Autowired
	DispatchOrderRepository dispatchOrderRepository;

	@Autowired
	ItemReportRepo itemReportRepo;

	@Autowired
	ItemReportDetailRepo itemReportDetailRepo;
	
	@Autowired
	SpKgSummaryRepository spKgSummaryRepository;
	
	@Autowired
	SpFlavourWiseSummaryRepo spFlavourWiseSummaryRepo;

	@RequestMapping(value = { "/getItemDetailReport" }, method = RequestMethod.POST)
	public @ResponseBody List<ItemReportDetail> getItemDetailReport(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("itemId") int itemId, @RequestParam("frId") int frId) {

		List<ItemReportDetail> saleList = new ArrayList<>();
		try {
			if (frId == -1) {

				saleList = itemReportDetailRepo.getItemReport(fromDate, toDate, itemId);
			} else {

				saleList = itemReportDetailRepo.getItemReportByItemId(fromDate, toDate, itemId, frId);
				System.out.println("saleListsaleListsaleList" + saleList.toString());
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return saleList;
	}

	@RequestMapping(value = { "/getItemReport" }, method = RequestMethod.POST)
	public @ResponseBody List<ItemReport> getItemReport(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("frId") int frId) {

		List<ItemReport> saleList = new ArrayList<>();
		try {

			if (frId == -1) {

				saleList = itemReportRepo.getItemReport(fromDate, toDate);
			} else {

				saleList = itemReportRepo.getItemReportByFrId(fromDate, toDate, frId);
				System.out.println(saleList.toString());
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return saleList;
	}

	@RequestMapping(value = { "/updateEditedQty" }, method = RequestMethod.POST)

	public @ResponseBody List<POrder> updateEditedQty(@RequestBody List<POrder> orderList)
			throws ParseException, JsonParseException, JsonMappingException, IOException {
		List<POrder> ordersList = null;
		try {
			ordersList = dispatchOrderRepository.save(orderList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ordersList;
	}

	@RequestMapping(value = { "/showBillWisePurchaseReport" }, method = RequestMethod.POST)
	public @ResponseBody BillWisePurchaseList showBillWisePurchase(@RequestParam("frId") int frId,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {

		BillWisePurchaseList billWisePurchaseList = reportsService.getBillWisePurchaseReport(frId, fromDate, toDate);

		return billWisePurchaseList;
	}

	@RequestMapping(value = { "/showItemWiseDetailsReport" }, method = RequestMethod.POST)
	public @ResponseBody ItemWiseDetailList showItemWiseDetail(@RequestParam("frId") int frId,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,
			@RequestParam("catId") int catId) {

		ItemWiseDetailList ItemWiseDetailList = reportsService.getItemWiseDetailReport(frId, catId, fromDate, toDate);

		return ItemWiseDetailList;
	}
	
	@RequestMapping(value = { "/showItemWiseDetailsReportByCatId" }, method = RequestMethod.POST)
	public @ResponseBody ItemWiseDetailList showItemWiseDetailsReportByCatId(@RequestParam("frId") int frId,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,
			@RequestParam("subCat") int subCat,@RequestParam("catId") int catId,@RequestParam("itemIds") List<Integer> itemIds) {

		ItemWiseDetailList ItemWiseDetailList = new ItemWiseDetailList();
		
		try {
			
			/*if(itemIds.contains(0)) {
				ItemWiseDetailList = reportsService.getItemWiseDetailReport(frId, catId, fromDate, toDate);
			}else {
				
				ItemWiseDetailList = reportsService.getItemWiseDetailReportByItemIds(frId,catId, itemIds, fromDate, toDate);
				
			}*/
			
			
			if(itemIds.contains(0)) {
				ItemWiseDetailList = reportsService.getItemWiseDetailReportsubCat(frId,catId, subCat, fromDate, toDate);
			}else {
				
				ItemWiseDetailList = reportsService.getItemWiseDetailReportByItemIds(frId,catId,subCat, itemIds, fromDate, toDate);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		

		return ItemWiseDetailList;
	}

	@RequestMapping(value = { "/showItemWiseReport" }, method = RequestMethod.POST)
	public @ResponseBody ItemWiseReportList showItemWiseReport(@RequestParam("frId") int frId,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,
			@RequestParam("catId") int catId) {

		ItemWiseReportList ItemWiseReportList = reportsService.getItemWiseReport(frId, catId, fromDate, toDate);

		return ItemWiseReportList;
	}
	
	@RequestMapping(value = { "/showItemWiseReportByTypeId" }, method = RequestMethod.POST)
	public @ResponseBody ItemWiseReportList showItemWiseReportByTypeId(@RequestParam("frId") int frId,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,
			@RequestParam("catId") int catId,@RequestParam("typeId") int typeId) {

		ItemWiseReportList ItemWiseReportList = reportsService.showItemWiseReportByTypeId(frId, catId, fromDate, toDate,typeId);

		return ItemWiseReportList;
	}

	@RequestMapping(value = { "/showMonthWiseReport" }, method = RequestMethod.POST)
	public @ResponseBody MonthWiseReportList showMonthWiseReport(@RequestParam("frId") int frId,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {

		MonthWiseReportList monthWiseReportList = reportsService.getMonthWiseReport(frId, fromDate, toDate);

		return monthWiseReportList;
	}
	
	@RequestMapping(value = { "/showMonthWiseReportByTypeId" }, method = RequestMethod.POST)
	public @ResponseBody MonthWiseReportList showMonthWiseReportByTypeId(@RequestParam("frId") int frId,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,@RequestParam("typeId") int typeId) {

		MonthWiseReportList monthWiseReportList = reportsService.getMonthWiseReportByTypeId(frId, fromDate, toDate,typeId);

		return monthWiseReportList;
	}

	@RequestMapping(value = { "/showBillWiseTaxReport" }, method = RequestMethod.POST)
	public @ResponseBody BillWiseTaxReportList showBillWiseTaxReport(@RequestParam("frId") int frId,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {

		BillWiseTaxReportList billWiseTaxReportList = reportsService.getBillWiseTaxReport(frId, fromDate, toDate);

		return billWiseTaxReportList;
	}
	
	@RequestMapping(value = { "/showBillWiseTaxReportByTypeId" }, method = RequestMethod.POST)
	public @ResponseBody BillWiseTaxReportList showBillWiseTaxReportByTypeId(@RequestParam("frId") int frId,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,@RequestParam("typeId") int typeId) {

		BillWiseTaxReportList billWiseTaxReportList = reportsService.getBillWiseTaxReport(frId, fromDate, toDate,typeId);

		return billWiseTaxReportList;
	}

	// -----------------------------------------------------------------------------------
	// Sell Reports start

	@RequestMapping(value = "/getRepDatewiseSell", method = RequestMethod.POST)
	public @ResponseBody List<GetRepFrDatewiseSell> getRepDatewiseSell(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("frId") List<String> frId) {
		List<GetRepFrDatewiseSell> tempList = new ArrayList<>();

		fromDate = Common.convertToYMD(fromDate);
		toDate = Common.convertToYMD(toDate);
		
		tempList = repFrSellServise.getDatewiseSellReport(fromDate, toDate, frId);
		
		/*List<GetRepFrDatewiseSell> repFrDatewiseSellList = repFrSellServise.getDatewiseSellReport(fromDate, toDate,
				frId);

		LinkedHashMap<Date, GetRepFrDatewiseSell> hashList = new LinkedHashMap<Date, GetRepFrDatewiseSell>();

		for (int i = 0; i < repFrDatewiseSellList.size(); i++) {
			float cash = 0, card = 0, other = 0;

			if (hashList.containsKey(repFrDatewiseSellList.get(i).getBillDate()) == false) {

				for (int j = 0; j < repFrDatewiseSellList.size(); j++) {

					if (repFrDatewiseSellList.get(j).getBillDate().equals(repFrDatewiseSellList.get(i).getBillDate())) {
						cash = cash + repFrDatewiseSellList.get(j).getCash();
						card = card + repFrDatewiseSellList.get(j).getCard();
						other = other + repFrDatewiseSellList.get(j).getOther();
					}
				}

				// System.err.println(getRepFrDatewiseSellResponse.get(i).getBillDate() + " cash
				// " + cash + "card "
				// + card + "other " + other);
				repFrDatewiseSellList.get(i).setCash(cash);
				repFrDatewiseSellList.get(i).setCard(card);
				repFrDatewiseSellList.get(i).setOther(other);
				hashList.put(repFrDatewiseSellList.get(i).getBillDate(), repFrDatewiseSellList.get(i));

			}
		}
		tempList = new ArrayList<GetRepFrDatewiseSell>(hashList.values());
		*/
 
		return tempList;

	}

	// ---------------------------------Dispatch Item
	// Report-----------------------------------------
	@RequestMapping(value = "/getDispatchItemReport", method = RequestMethod.POST)
	public @ResponseBody List<DispatchReport> getDispatchItemReport(@RequestParam("billDate") String billDate,
			@RequestParam("frId") List<String> frId, @RequestParam("categories") List<String> categories) {

		String billDateYMD = Common.convertToYMD(billDate);
		List<DispatchReport> dispatchReportList = reportsService.getDispatchItemReport(billDateYMD, frId, categories);
		return dispatchReportList;

	}

	// ---------------------------------PDispatch Item
	// Report-----------------------------------------
	// sumit
	@RequestMapping(value = "/getPDispatchItemReportMenuwise", method = RequestMethod.POST)
	public @ResponseBody List<PDispatchReport> getPDispatchItemReport(
			@RequestParam("productionDate") String productionDate, @RequestParam("frId") List<String> frId,
			@RequestParam("menu") List<Integer> menu, @RequestParam("ItemId") List<Integer> ItemId) {

		String productionDateYMD = Common.convertToYMD(productionDate);

		System.out.println(" fr................." + frId.toString());
		List<PDispatchReport> dispatchReportList = pDispatchReportRepository
				.getPDispatchItemReportMenuwise(productionDateYMD, frId, menu, ItemId);
		System.out.println(" fr................." + dispatchReportList.toString());

		return dispatchReportList;

	}
	// ------------------------------------------------------------------------------------------------

	// ---------------------------------PDispatch Item
	// Report-----------------------------------------
	@RequestMapping(value = "/getPDispatchItemReport", method = RequestMethod.POST)
	public @ResponseBody List<PDispatchReport> getPDispatchItemReports(
			@RequestParam("productionDate") String productionDate, @RequestParam("frId") List<String> frId,
			@RequestParam("categories") List<Integer> categories, @RequestParam("menuId") List<Integer> menuId) {

		String productionDateYMD = Common.convertToYMD(productionDate);

		System.out.println(" fr................." + frId.toString());
		List<PDispatchReport> dispatchReportList = pDispatchReportRepository.getPDispatchItemReport(productionDateYMD,
				frId, categories, menuId);
		System.out.println(" fr................." + dispatchReportList.toString());

		return dispatchReportList;

	}

	// ------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/getRepMonthwiseSell", method = RequestMethod.POST)
	public @ResponseBody List<GetRepMonthwiseSell> getRepMonthwiseSell(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("frId") List<String> frId) {
		List<GetRepMonthwiseSell> tempList = null;
		System.out.println("from" + fromDate);
		System.out.println("to" + toDate);

		/*
		 * fromDate = Common.convertToYMD(fromDate); toDate =
		 * Common.convertToYMD(toDate);
		 */

		System.out.println("to" + toDate);
		System.out.println("from" + fromDate);
		List<GetRepMonthwiseSell> GetRepMonthwiseSellList = repFrSellServise.getMonthwiseSellReport(fromDate, toDate,
				frId);

		LinkedHashMap<String, GetRepMonthwiseSell> hashList = new LinkedHashMap<String, GetRepMonthwiseSell>();

		for (int i = 0; i < GetRepMonthwiseSellList.size(); i++) {
			float cash = 0, card = 0, other = 0;

			if (hashList.containsKey(GetRepMonthwiseSellList.get(i).getMonth()) == false) {

				for (int j = 0; j < GetRepMonthwiseSellList.size(); j++) {

					if (GetRepMonthwiseSellList.get(j).getMonth().equals(GetRepMonthwiseSellList.get(i).getMonth())) {
						cash = cash + GetRepMonthwiseSellList.get(j).getCash();
						card = card + GetRepMonthwiseSellList.get(j).getCard();
						other = other + GetRepMonthwiseSellList.get(j).getOther();
					}
				}

				// System.err.println(getRepFrDatewiseSellResponse.get(i).getBillDate() + " cash
				// " + cash + "card "
				// + card + "other " + other);
				GetRepMonthwiseSellList.get(i).setCash(cash);
				GetRepMonthwiseSellList.get(i).setCard(card);
				GetRepMonthwiseSellList.get(i).setOther(other);
				hashList.put(GetRepMonthwiseSellList.get(i).getMonth(), GetRepMonthwiseSellList.get(i));

			}
		}

		tempList = new ArrayList<GetRepMonthwiseSell>(hashList.values());
		return tempList;

	}

	@RequestMapping(value = "/getRepItemwiseSell", method = RequestMethod.POST)
	public @ResponseBody List<GetRepItemwiseSell> getRepItemwiseSell(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("frId") List<String> frId,
			@RequestParam("catId") List<String> catId) {
		List<GetRepItemwiseSell> getRepItemwiseSellList = new ArrayList<>();

		fromDate = Common.convertToYMD(fromDate);
		toDate = Common.convertToYMD(toDate);
		if (catId.contains("5")) {
			getRepItemwiseSellList = repFrSellServise.getItemwiseSellReportForCat5(fromDate, toDate, frId);

		} else {
			getRepItemwiseSellList = repFrSellServise.getItemwiseSellReport(fromDate, toDate, frId, catId);
		}
		return getRepItemwiseSellList;

	}

	/*
	 * @RequestMapping(value = "/getRepItemwiseSellForCat5", method =
	 * RequestMethod.POST) public @ResponseBody List<GetRepItemwiseSell>
	 * getRepItemwiseSellForCat5(@RequestParam("fromDate") String fromDate,
	 * 
	 * @RequestParam("toDate") String toDate, @RequestParam("frId") List<String>
	 * frId, @RequestParam("catId") List<String> catId) { List<GetRepItemwiseSell>
	 * getRepItemwiseSellList=new ArrayList<>(); fromDate =
	 * Common.convertToYMD(fromDate); toDate = Common.convertToYMD(toDate);
	 * System.err.println("cat Id " +catId); if(catId.contains(5)) {
	 * getRepItemwiseSellList=repFrSellServise.getItemwiseSellReportForCat5(
	 * fromDate, toDate, frId, catId);
	 * 
	 * }else {
	 * getRepItemwiseSellList=repFrSellServise.getItemwiseSellReport(fromDate,
	 * toDate, frId, catId); } return getRepItemwiseSellList;
	 * 
	 * }
	 */
	@RequestMapping(value = "/getRepMenuwiseSell", method = RequestMethod.POST)
	public @ResponseBody List<GetRepMenuwiseSell> getRepMenuwiseSell(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("frId") List<String> frId) {

		fromDate = Common.convertToYMD(fromDate);
		toDate = Common.convertToYMD(toDate);
		List<GetRepMenuwiseSell> getRepMenuwiseSellList = repFrSellServise.getMenuwiseSellReport(fromDate, toDate,
				frId);
		return getRepMenuwiseSellList;

	}

	@RequestMapping(value = "/getRepDateItemwiseSell", method = RequestMethod.POST)
	public @ResponseBody List<GetRepItemwiseSell> getRepDateItemwiseSell(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("frId") List<String> frId,
			@RequestParam("catId") List<String> catId) {
		List<GetRepItemwiseSell> getRepItemwiseSellList = new ArrayList<>();

		fromDate = Common.convertToYMD(fromDate);
		toDate = Common.convertToYMD(toDate);
		if (catId.contains("5")) {
			getRepItemwiseSellList = repFrSellServise.getItemwiseSellReportForCat5(fromDate, toDate, frId);

		} else {
			getRepItemwiseSellList = repFrSellServise.getDateItemwiseSellReport(fromDate, toDate, frId, catId);
		}
		return getRepItemwiseSellList;

	}

	@RequestMapping(value = "/getRepDateCatwiseSell", method = RequestMethod.POST)
	public @ResponseBody List<GetRepItemwiseSell> getRepDateCatwiseSell(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("frId") List<String> frId,
			@RequestParam("catId") List<String> catId) {

		fromDate = Common.convertToYMD(fromDate);
		toDate = Common.convertToYMD(toDate);
		List<GetRepItemwiseSell> getRepItemwiseSellList = repFrSellServise.getDateCatwiseSellReport(fromDate, toDate,
				frId, catId);
		return getRepItemwiseSellList;

	}

	// Sac May 10 change Tax Report for SP
	@RequestMapping(value = "/getRepTaxSell", method = RequestMethod.POST)
	public @ResponseBody List<GetRepTaxSell> getRepTaxSell(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("frId") List<String> frId) {

		List<GetRepTaxSell> tempList = null;

		fromDate = Common.convertToYMD(fromDate);
		toDate = Common.convertToYMD(toDate);
		List<GetRepTaxSell> getRepTaxSellList = repFrSellServise.getTaxSellReport(fromDate, toDate, frId);
		System.out.println("  List  :" + getRepTaxSellList);

		LinkedHashMap<Float, GetRepTaxSell> hashList = new LinkedHashMap<Float, GetRepTaxSell>();

		for (int i = 0; i < getRepTaxSellList.size(); i++) {
			float taxable = 0, igst = 0, sgst = 0, cgst = 0;

			if (hashList.containsKey(getRepTaxSellList.get(i).getTax_per()) == false) {

				for (int j = 0; j < getRepTaxSellList.size(); j++) {

					if (getRepTaxSellList.get(j).getTax_per() == (getRepTaxSellList.get(i).getTax_per())) {
						taxable = taxable + getRepTaxSellList.get(j).getTax_amount();
						igst = igst + getRepTaxSellList.get(j).getIgst();
						sgst = sgst + getRepTaxSellList.get(j).getSgst();
						cgst = cgst + getRepTaxSellList.get(j).getCgst();
					}
				}

				// System.err.println(getRepFrDatewiseSellResponse.get(i).getBillDate() + " cash
				// " + cash + "card "
				// + card + "other " + other);
				getRepTaxSellList.get(i).setTax_amount(taxable);
				getRepTaxSellList.get(i).setIgst(igst);
				getRepTaxSellList.get(i).setSgst(sgst);
				getRepTaxSellList.get(i).setCgst(cgst);
				hashList.put(getRepTaxSellList.get(i).getTax_per(), getRepTaxSellList.get(i));

			}
		}

		tempList = new ArrayList<GetRepTaxSell>(hashList.values());
		System.out.println("  List  :" + getRepTaxSellList);
		return tempList;

	}

	// Sac May 10 change Tax Report for SP
	@RequestMapping(value = "/getRepDatewiseTaxSell", method = RequestMethod.POST)
	public @ResponseBody List<GetRepTaxSell> getRepDatewiseTaxSell(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("frId") List<String> frId) {
		List<GetRepTaxSell> tempList = null;
		fromDate = Common.convertToYMD(fromDate);
		toDate = Common.convertToYMD(toDate);
		List<GetRepTaxSell> getRepTaxSellList = repFrSellServise.getDatewiseTaxSellReport(fromDate, toDate, frId);

		LinkedHashMap<Date, GetRepTaxSell> hashList = new LinkedHashMap<Date, GetRepTaxSell>();

		for (int i = 0; i < getRepTaxSellList.size(); i++) {
			float taxable = 0, igst = 0, sgst = 0, cgst = 0;

			if (hashList.containsKey(getRepTaxSellList.get(i).getBillDate()) == false) {

				for (int j = 0; j < getRepTaxSellList.size(); j++) {

					if (getRepTaxSellList.get(j).getBillDate().equals(getRepTaxSellList.get(i).getBillDate())) {
						taxable = taxable + getRepTaxSellList.get(j).getTax_amount();
						igst = igst + getRepTaxSellList.get(j).getIgst();
						sgst = sgst + getRepTaxSellList.get(j).getSgst();
						cgst = cgst + getRepTaxSellList.get(j).getCgst();
					}
				}

				// System.err.println(getRepFrDatewiseSellResponse.get(i).getBillDate() + " cash
				// " + cash + "card "
				// + card + "other " + other);
				getRepTaxSellList.get(i).setTax_amount(taxable);
				getRepTaxSellList.get(i).setIgst(igst);
				getRepTaxSellList.get(i).setSgst(sgst);
				getRepTaxSellList.get(i).setCgst(cgst);
				hashList.put(getRepTaxSellList.get(i).getBillDate(), getRepTaxSellList.get(i));

			}
		}

		tempList = new ArrayList<GetRepTaxSell>(hashList.values());
		System.out.println("  List  :" + getRepTaxSellList);
		return tempList;

	}

	@RequestMapping(value = "/getRepBillwiseTaxSell", method = RequestMethod.POST)
	public @ResponseBody List<GetRepTaxSell> getRepBillwiseTaxSell(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("frId") List<String> frId) {

		fromDate = Common.convertToYMD(fromDate);
		toDate = Common.convertToYMD(toDate);
		List<GetRepTaxSell> getRepTaxSellList = repFrSellServise.getBillwiseTaxSellReport(fromDate, toDate, frId);
		System.out.println("  List  :" + getRepTaxSellList);
		return getRepTaxSellList;

	}

	// Sell Report
	// End-------------------------------------------------------------------

	// customer bill-----------------------

	@RequestMapping(value = "/getCustomerBill", method = RequestMethod.POST)
	public @ResponseBody List<GetCustomerBill> getCustomerBill(@RequestParam("billNo") int billNo) {

		List<GetCustomerBill> getCustomerBillList = repFrSellServise.getCustBill(billNo);
		System.out.println("  List  :" + getCustomerBillList);
		return getCustomerBillList;

	}

	@RequestMapping(value = "/getCustomerBillTax", method = RequestMethod.POST)
	public @ResponseBody List<GetCustBillTax> getCustomerBillTax(@RequestParam("billNo") int billNo) {

		List<GetCustBillTax> getCustBillTaxList = repFrSellServise.getCustBillTax(billNo);
		System.out.println("  List  :" + getCustBillTaxList);
		return getCustBillTaxList;

	}

	// ---------------------------------PDispatch Franchises wise Special Cake
	// Report-----------------------------------------
	// sumit
	@RequestMapping(value = "/getPDispatchFranchasewiseSpCake", method = RequestMethod.POST)
	public @ResponseBody List<PDispatchReport> getPDispatchFranchasewiseSpCake(
			@RequestParam("deliveryDate") String deliveryDate, @RequestParam("frId") List<String> frId,
			@RequestParam("menu") List<Integer> menu) {

		String deliveryDateYMD = Common.convertToYMD(deliveryDate);

		System.out.println(" fr................." + frId.toString());
		List<PDispatchReport> dispatchReportList = pDispatchReportRepository
				.getPDispatchFranchisewiseSpCake(deliveryDateYMD, frId, menu);
		System.out.println(" fr................." + dispatchReportList.toString());

		return dispatchReportList;

	}
	// ------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/getSpKgSummaryReport", method = RequestMethod.POST)
	public @ResponseBody List<SpKgSummaryDao> getSpKgSummaryReport(
			@RequestParam("fromDate") String fromDate,@RequestParam("toDate") String toDate, @RequestParam("frId") List<Integer> frId) {

		List<SpKgSummaryDao> spKgSummaryDaoList = spKgSummaryRepository.getSpKgSummaryReport(fromDate, toDate, frId);
	
		return spKgSummaryDaoList;

	}
	// ------------------------------------------------------------------------------------------------

	
	// ------------------------------------------------------------------------------------------------
	//Anmol-->26-11-2019--->SP_FLAVOUR_WISE_REPORT
		@RequestMapping(value = "/getSpFlavourSummaryReport", method = RequestMethod.POST)
		public @ResponseBody List<SpFlavourWiseSummaryDao> getSpFlavourSummaryReport(
				@RequestParam("fromDate") String fromDate,@RequestParam("toDate") String toDate, @RequestParam("frId") List<Integer> frId) {

			List<SpFlavourWiseSummaryDao> spFlavourSummaryDaoList = spFlavourWiseSummaryRepo.getFlavourSummaryReport(fromDate, toDate, frId);
		
			return spFlavourSummaryDaoList;

		}
		// ------------------------------------------------------------------------------------------------

		
}
