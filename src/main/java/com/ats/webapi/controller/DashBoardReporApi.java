package com.ats.webapi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.dashboard.CredNoteReport;
import com.ats.webapi.model.dashboard.PurBillBackEndReport;
import com.ats.webapi.model.dashboard.SellBillFrontEndReport;
import com.ats.webapi.repository.dashboard.CredNoteReportRepo;
import com.ats.webapi.repository.dashboard.PurBillBackEndReportRepo;
import com.ats.webapi.repository.dashboard.SellBillFrontEndReportRepo;

@RestController
public class DashBoardReporApi {
	
	@Autowired
	PurBillBackEndReportRepo getPurBillBackEndReportRepo;
	
	@Autowired
	SellBillFrontEndReportRepo  getSellBillFrontEndReportRepo;
	
	@Autowired
	CredNoteReportRepo getCredNoteReportRepo;
	
	@RequestMapping(value = { "/getCredNoteReport" }, method = RequestMethod.POST)
	public @ResponseBody CredNoteReport getCredNoteReport(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate,@RequestParam("frIdList") List<String> frIdList,
			@RequestParam("isGrn") List<String> isGrn)
	{
		
		CredNoteReport crnReport = null;

		try {
			
			if(!frIdList.contains("0")) {
				//for Front End Dashboard
				
			crnReport=getCredNoteReportRepo.getCreNoteReportForFr(fromDate, toDate, frIdList, isGrn);
			}
			else {
				//for BackEnd End Dashboard

				crnReport=getCredNoteReportRepo.getCreNoteReportAllFr(fromDate, toDate, isGrn);
			}
			
		}
		catch (Exception e) {
			
			System.err.println("Exception in DashBoardReporApi /getCredNoteReport" +e.getMessage());
			
			e.printStackTrace();
       }
		
		return crnReport;
	}
	
	
	@RequestMapping(value = { "/getPurBillReport" }, method = RequestMethod.POST)
	public @ResponseBody PurBillBackEndReport getPurBillReport(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate)
	{
		
		PurBillBackEndReport purBillReport = null;

		try {
			
			purBillReport=getPurBillBackEndReportRepo.getPurReportByDates(fromDate, toDate);
			
		}
		catch (Exception e) {
			
			System.err.println("Exception in DashBoardReporApi /getPurBillReport" +e.getMessage());
			
			e.printStackTrace();
       }
		
		return purBillReport;
	}
	
	//for Front End Dashboard
	
	@RequestMapping(value = { "/getPurReportByDateAndFr" }, method = RequestMethod.POST)
	public @ResponseBody PurBillBackEndReport getPurReportByDateAndFr(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate,@RequestParam("frIdList") List<String> frIdList)
	{
		
		PurBillBackEndReport purBillReport = null;

		try {
			
			purBillReport=getPurBillBackEndReportRepo.getPurReportByDateAndFr(fromDate, toDate,frIdList);
			
		}
		catch (Exception e) {
			
			System.err.println("Exception in DashBoardReporApi /getPurReportByDateAndFr" +e.getMessage());
			
			e.printStackTrace();
       }
		
		return purBillReport;
	}
	
	
	@RequestMapping(value = { "/getSellBillReport" }, method = RequestMethod.POST)
	public @ResponseBody SellBillFrontEndReport getSellBillReport(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate,@RequestParam("frIdList") List<String> frIdList) 
	{
		
		SellBillFrontEndReport purBillReport = null;

		try {
			
			purBillReport=getSellBillFrontEndReportRepo.getSellReportByDateAndFr(fromDate, toDate,frIdList);
			
		}
		catch (Exception e) {
			
			System.err.println("Exception in DashBoardReporApi /getSellBillReport" +e.getMessage());
			
			e.printStackTrace();
       }
		
		return purBillReport;
	}
	
	

}
