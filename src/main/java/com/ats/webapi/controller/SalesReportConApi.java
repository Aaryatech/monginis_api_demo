package com.ats.webapi.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.commons.Common;
import com.ats.webapi.model.report.frpurchase.SalesReportBillwise;
import com.ats.webapi.model.report.frpurchase.SalesReportDMCredit;
import com.ats.webapi.model.report.frpurchase.SalesReportDateMonth;

import com.ats.webapi.repository.frpurchasereport.SaleReportBillwiseRepo;
import com.ats.webapi.repository.frpurchasereport.SalesReportDMCreditRepo;
import com.ats.webapi.repository.frpurchasereport.SalesReportDateMonthRepo;

@RestController
public class SalesReportConApi {
	@Autowired
	SalesReportDMCreditRepo salesReportDMCreditRepo;

	@Autowired
	SaleReportBillwiseRepo saleReportBillwiseRepo;
	
	@Autowired SalesReportDateMonthRepo salesReportDateMonthRepo;

	@RequestMapping(value = { "/getDatewiseReport" }, method = RequestMethod.POST)
	public @ResponseBody List<SalesReportDateMonth> getDatewiseReport(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("frIdList") List<String> frIdList) {

		List<SalesReportDateMonth> salesReportDateMonthList = new ArrayList<>();
		List<SalesReportBillwise> salesReportBillwiseList = new ArrayList<>();
		List<SalesReportDMCredit> grnList = null;
		List<SalesReportDMCredit> gvnList = null;
		try {
			fromDate = Common.convertToYMD(fromDate);
			toDate = Common.convertToYMD(toDate);

			salesReportBillwiseList = saleReportBillwiseRepo.getSaleReportBillwiseByDate(frIdList, fromDate, toDate);

			grnList = salesReportDMCreditRepo.getDataGRN(frIdList, fromDate, toDate);

			gvnList = salesReportDMCreditRepo.getDataGVN(frIdList, fromDate, toDate);

			for (int i = 0; i < salesReportBillwiseList.size(); i++) {

				SalesReportDateMonth save = new SalesReportDateMonth();

				save.setBillDate(salesReportBillwiseList.get(i).getBillDate());
				save.setFrId(salesReportBillwiseList.get(i).getFrId());
				save.setGrandTotal(salesReportBillwiseList.get(i).getGrandTotal());
				save.setTaxableAmt(salesReportBillwiseList.get(i).getTaxableAmt());
				save.setTotalTax(salesReportBillwiseList.get(i).getTotalTax());

				salesReportDateMonthList.add(save);

			}

			for (int i = 0; i < salesReportDateMonthList.size(); i++) {
				for (int j = 0; j < grnList.size(); j++) {

					if (salesReportDateMonthList.get(i).getBillDate().compareTo(grnList.get(j).getCrnDate()) == 0) {

						salesReportDateMonthList.get(i).setCrnDate(grnList.get(j).getCrnDate());
						salesReportDateMonthList.get(i).setGrnTaxableAmt(grnList.get(j).getTaxableAmt());
						salesReportDateMonthList.get(i).setGrnTotalTax(grnList.get(j).getCrnTotalTax());
						salesReportDateMonthList.get(i).setGrnGrandTotal(grnList.get(j).getGrandTotal());
						break;

					} else {

						salesReportDateMonthList.get(i).setGrnTaxableAmt(0);
						salesReportDateMonthList.get(i).setGrnTotalTax(0);
						salesReportDateMonthList.get(i).setGrnGrandTotal(0);
					}

				}
			}

			for (int i = 0; i < salesReportDateMonthList.size(); i++) {
				for (int j = 0; j < gvnList.size(); j++) {

					if (salesReportDateMonthList.get(i).getBillDate().compareTo(grnList.get(j).getCrnDate()) == 0) {

						salesReportDateMonthList.get(i).setCrnDate(gvnList.get(j).getCrnDate());
						salesReportDateMonthList.get(i).setGvnTaxableAmt(gvnList.get(j).getTaxableAmt());
						salesReportDateMonthList.get(i).setGvnTotalTax(gvnList.get(j).getCrnTotalTax());
						salesReportDateMonthList.get(i).setGvnGrandTotal(gvnList.get(j).getGrandTotal());
						break;

					} else {

						salesReportDateMonthList.get(i).setGvnTaxableAmt(0);
						salesReportDateMonthList.get(i).setGvnTotalTax(0);
						salesReportDateMonthList.get(i).setGvnGrandTotal(0);
					}

				}
			}

		} catch (Exception e) {
			System.out.println(" Exce in Tax1 Report " + e.getMessage());
			e.printStackTrace();
		}
		return salesReportDateMonthList;
	}

	@RequestMapping(value = { "/getMonthwiseReport" }, method = RequestMethod.POST)
	public @ResponseBody List<SalesReportDateMonth> getMonthwiseReport(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("frIdList") List<String> frIdList) {

		List<SalesReportDateMonth> salesReportDateMonthList = new ArrayList<>();
		List<SalesReportBillwise> salesReportBillwiseList = new ArrayList<>();
		List<SalesReportDMCredit> grnList = null;
		List<SalesReportDMCredit> gvnList = null;
		try {
			fromDate = Common.convertToYMD(fromDate);
			toDate = Common.convertToYMD(toDate);
			
			salesReportDateMonthList=salesReportDateMonthRepo.getSaleMonthWiseReport(frIdList, fromDate, toDate);
			System.err.println("MONTHLY LIST - "+salesReportDateMonthList);

			//salesReportBillwiseList = saleReportBillwiseRepo.getSaleReportBillwiseByMonth(frIdList, fromDate, toDate);

			//grnList = salesReportDMCreditRepo.getDataGRNForMonth(frIdList, fromDate, toDate);

			//gvnList = salesReportDMCreditRepo.getDataGVNForMonth(frIdList, fromDate, toDate);
			
			//System.err.println("BILL LIST - "+salesReportBillwiseList);
			//System.err.println("GRN LIST - "+grnList);
			//System.err.println("GVN LIST - "+gvnList);
			

//			for (int i = 0; i < salesReportBillwiseList.size(); i++) {
//
//				SalesReportDateMonth save = new SalesReportDateMonth();
//
//				save.setBillDate(salesReportBillwiseList.get(i).getBillDate());
//				save.setFrId(salesReportBillwiseList.get(i).getFrId());
//				save.setGrandTotal(salesReportBillwiseList.get(i).getGrandTotal());
//				save.setTaxableAmt(salesReportBillwiseList.get(i).getTaxableAmt());
//				save.setTotalTax(salesReportBillwiseList.get(i).getTotalTax());
//				save.setMonth(salesReportBillwiseList.get(i).getMonth());
//
//				salesReportDateMonthList.add(save);
//
//			}
//
//			for (int i = 0; i < salesReportDateMonthList.size(); i++) {
//				for (int j = 0; j < grnList.size(); j++) {
//
//					Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Paris"));
//					cal.setTime(salesReportDateMonthList.get(i).getBillDate()); 
//					int month = cal.get(Calendar.MONTH); 
//					
//					Calendar cal1 = Calendar.getInstance(TimeZone.getTimeZone("Europe/Paris"));
//					cal1.setTime(grnList.get(j).getCrnDate()); 
//					int month1 = cal1.get(Calendar.MONTH); 
//					
//					System.out.println(month + " " + month1);
//					if (month==month1) {
//
//						salesReportDateMonthList.get(i).setCrnDate(grnList.get(j).getCrnDate());
//						salesReportDateMonthList.get(i).setGrnTaxableAmt(grnList.get(j).getTaxableAmt());
//						salesReportDateMonthList.get(i).setGrnTotalTax(grnList.get(j).getCrnTotalTax());
//						salesReportDateMonthList.get(i).setGrnGrandTotal(grnList.get(j).getGrandTotal());
//						break;
//
//					} else {
//
//						salesReportDateMonthList.get(i).setGrnTaxableAmt(0);
//						salesReportDateMonthList.get(i).setGrnTotalTax(0);
//						salesReportDateMonthList.get(i).setGrnGrandTotal(0);
//					}
//
//				}
//			}
//
//			for (int i = 0; i < salesReportDateMonthList.size(); i++) {
//				for (int j = 0; j < gvnList.size(); j++) {
//
//					Calendar cal = Calendar.getInstance();
//					cal.setTime(salesReportDateMonthList.get(i).getBillDate()); 
//					int month = cal.get(Calendar.MONTH); 
//					
//					Calendar cal1 = Calendar.getInstance();
//					cal1.setTime(gvnList.get(j).getCrnDate()); 
//					int month1 = cal1.get(Calendar.MONTH); 
//					
//					
//					
//					
//					System.out.println(month + " " + month1);
//					if (month==month1) { 
//
//						salesReportDateMonthList.get(i).setCrnDate(gvnList.get(j).getCrnDate());
//						salesReportDateMonthList.get(i).setGvnTaxableAmt(gvnList.get(j).getTaxableAmt());
//						salesReportDateMonthList.get(i).setGvnTotalTax(gvnList.get(j).getCrnTotalTax());
//						salesReportDateMonthList.get(i).setGvnGrandTotal(gvnList.get(j).getGrandTotal());
//						break;
//
//					} else {
//
//						salesReportDateMonthList.get(i).setGvnTaxableAmt(0);
//						salesReportDateMonthList.get(i).setGvnTotalTax(0);
//						salesReportDateMonthList.get(i).setGvnGrandTotal(0);
//					}
//
//				}
//			}

		} catch (Exception e) {
			System.out.println(" Exce in Tax1 Report " + e.getMessage());
			e.printStackTrace();
		}
		return salesReportDateMonthList;
	}

}
