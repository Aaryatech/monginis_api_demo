package com.ats.webapi.controller.salescompare;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.report.salecompare.AdminDashYearlyReport;
import com.ats.webapi.model.report.salecompare.SalesComparison;
import com.ats.webapi.model.report.salecompare.SalesComparisonReport;
import com.ats.webapi.model.report.salecompare.SalesGrn;
import com.ats.webapi.repository.salecomparereport.AdminDashYearlyReportRepo;
import com.ats.webapi.repository.salecomparereport.SalesCompareGrnRepository;
import com.ats.webapi.repository.salecomparereport.SalesComparisonReportRepo;

@RestController
public class SalesCompareReportController {
	@Autowired
	SalesComparisonReportRepo salesComparisonReportRepo;
	
	@Autowired
	SalesCompareGrnRepository salesCompareGrnRepository;
	
	@Autowired
	AdminDashYearlyReportRepo adminDashYearlyReportRepo;
	
	@RequestMapping(value = { "/getSalesReportComparion" }, method = RequestMethod.POST)
	public @ResponseBody SalesComparison getSalesReportComparion(@RequestParam("monthNumber") int monthNumber,@RequestParam("year") int year) {
		SalesComparison saleCompare=new SalesComparison();
		
		try {
			
		List<SalesComparisonReport> billTotalList =salesComparisonReportRepo.getSalesReportComparisonBillTotal(monthNumber,year);
		
		List<SalesGrn> grnGvnTotalList =salesCompareGrnRepository.getSalesReportComparisonGrnGvnTotal(monthNumber,year);
		
		saleCompare.setBillTotalList(billTotalList);
		saleCompare.setGrnGvnTotalList(grnGvnTotalList);
		
		}catch (Exception e) {
			
			System.err.println(" Error In web service @ /getSalesReportComparion In /SalesCompareReportController ");
			e.printStackTrace();
		}

		return saleCompare;

	}
	
	@RequestMapping(value = { "/getAdminDashData" }, method = RequestMethod.POST)
	public @ResponseBody List<AdminDashYearlyReport> getAdminDashData(@RequestParam("fromDate") String fromDate,@RequestParam("toDate") String toDate) {
		List<AdminDashYearlyReport> res=new ArrayList<>();
		
		try {
			
			res =adminDashYearlyReportRepo.getAdminDashYearlyData(fromDate, toDate);
		
		}catch (Exception e) {
			
			e.printStackTrace();
		}

		return res;

	}
	
}
