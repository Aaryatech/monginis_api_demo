package com.ats.webapi.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.commons.Common;
import com.ats.webapi.model.GetBillDetails;
import com.ats.webapi.model.SellBillDetailList;
import com.ats.webapi.model.bill.Company;
import com.ats.webapi.model.bill.FrBillHeaderForPrint;
import com.ats.webapi.model.bill.GetBillDetailPrint;
import com.ats.webapi.repository.BillDetailForPrintRepo;
import com.ats.webapi.repository.CompanyRepository;
import com.ats.webapi.repository.GetBillHeaderForPrintRepo;

@RestController
public class PrintFrBillController {

	@Autowired
	GetBillHeaderForPrintRepo billHeaderForPrintRepo;

	@Autowired
	BillDetailForPrintRepo billDetailForPrintRepo;

	@Autowired
	CompanyRepository companyRepository;
	
	@RequestMapping(value = { "/getBillHeaderForPrint" }, method = RequestMethod.POST)
	public @ResponseBody List<FrBillHeaderForPrint> getBillHeaderForPrint(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<FrBillHeaderForPrint> billHeaderPrintList = null;
		try {
			fromDate = Common.convertToYMD(fromDate);
			toDate = Common.convertToYMD(toDate);

			billHeaderPrintList = billHeaderForPrintRepo.getFrBillHeaderForPrint(fromDate, toDate);

		} catch (Exception e) {
			System.out.println(" Exce in bill Header List for Print " + e.getMessage());
			e.printStackTrace();
		}
		return billHeaderPrintList;
	}
	
	//for FrId
	@RequestMapping(value = { "/getBillHeaderForPrintByFrId" }, method = RequestMethod.POST)
	public @ResponseBody List<FrBillHeaderForPrint> getBillHeaderForPrintByFrId(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate,@RequestParam("frIdList") List<String> frIdList) {

		List<FrBillHeaderForPrint> billHeaderPrintList = null;
		try {
			fromDate = Common.convertToYMD(fromDate);
			toDate = Common.convertToYMD(toDate);

			billHeaderPrintList = billHeaderForPrintRepo.getFrBillHeaderForPrintByFrIds(fromDate, toDate, frIdList);

		} catch (Exception e) {
			System.out.println(" Exce in bill Header List for Print Using frIds,from,to Date " + e.getMessage());
			e.printStackTrace();
		}
		return billHeaderPrintList;
	}

	@RequestMapping(value = "/getBillDetailsForPrint", method = RequestMethod.POST)
	public @ResponseBody List<GetBillDetailPrint> getBillDetailsForPrint(
			@RequestParam("billNoList") List<String> billNoList) {
		System.out.println("inside PrintFrBill Controller for getting bill detail for print fr bill ");
		System.out.println("input received as billNoList " + billNoList.toString());
		List<GetBillDetailPrint> billDetailsForPrint = null;
		
		try {
			billDetailsForPrint = billDetailForPrintRepo.getBillDetailsForPrint(billNoList);
		} catch (Exception e) {
			System.out.println("Exce In getting bill Detail For Print");
			e.printStackTrace();
		}
		
		return billDetailsForPrint;

	}
	@RequestMapping(value = { "/getCompany" }, method = RequestMethod.GET)
	public @ResponseBody Company getCompany() {

		Company company = null;
		try {
			String pattern = "yyyy-MM-dd";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

			String date = simpleDateFormat.format(new java.util.Date());
			 company=companyRepository.findByBillDate(date);

		} catch (Exception e) {
			System.out.println(" Exce in bill Header List for Print " + e.getMessage());
			e.printStackTrace();
		}
		return company;
	}
	
	@RequestMapping(value = { "/getFrBillHeaderForPrintSelectedBill" }, method = RequestMethod.POST)
	public @ResponseBody List<FrBillHeaderForPrint> getFrBillHeaderForPrintSelectedBill(@RequestParam("billNoList") List<String> billNoList) {

		List<FrBillHeaderForPrint> billHeaderPrintList = null;
		try {
			
			billHeaderPrintList = billHeaderForPrintRepo.getFrBillHeaderForPrintSelectedBill(billNoList);

			for(int i=0;i<billHeaderPrintList.size();i++) {
				String pattern = "yyyy-MM-dd";
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

				String date = simpleDateFormat.format(billHeaderPrintList.get(i).getBillDate());
				Company company=companyRepository.findByBillDate(date);
				billHeaderPrintList.get(i).setCompany(company);
			}

		} catch (Exception e) {
			System.out.println(" Exce in bill Header List for Print " + e.getMessage());
			e.printStackTrace();
		}
		return billHeaderPrintList;
	}
	
}
