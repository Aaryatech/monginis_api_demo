package com.ats.webapi.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.CreditNoteReport;
import com.ats.webapi.model.grngvnreport.GGReportByDate;
import com.ats.webapi.model.grngvnreport.GGReportGrpByFrId;
import com.ats.webapi.model.grngvnreport.GGReportGrpByItemId;
import com.ats.webapi.model.grngvnreport.GGReportGrpByMonthDate;
import com.ats.webapi.model.grngvnreport.GrnGvnReportByGrnType;
import com.ats.webapi.repo.CreditNoteReportRepo;
import com.ats.webapi.repository.ggreport.GGReportByDateRepo;
import com.ats.webapi.repository.ggreport.GGReportGrpByFrIdRepo;
import com.ats.webapi.repository.ggreport.GGReportGrpByItemIdRepo;
import com.ats.webapi.repository.ggreport.GGreportGrpByDateMonthRepo;
import com.ats.webapi.repository.ggreport.GrnGvnReportByGrnTypeRepo;

@RestController
public class GrnGvnReportController {

	@Autowired
	GGreportGrpByDateMonthRepo gGreportGrpByDateMonthRepo;//r3,r4

	@Autowired
	GGReportGrpByFrIdRepo gGReportGrpByFrIdRepo;//r2
	
	
	@Autowired
	GGReportByDateRepo gGReportByDateRepo;//r1
	
	@Autowired
	GGReportGrpByItemIdRepo gGReportGrpByItemIdRepo;
	@Autowired
	GrnGvnReportByGrnTypeRepo getGrnGvnReportByGrnTypeRepo; // 25-05-2018

	@Autowired
	CreditNoteReportRepo creditNoteReportRepo;
	
	@RequestMapping(value = { "/getGrnGvnReportByGrnType" }, method = RequestMethod.POST)
	public @ResponseBody List<GrnGvnReportByGrnType> getGrnGvnReportByGrnType(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("frIdList") List<String> frIdList) {

		System.err.println(
				"Parameter received fromDate:  " + fromDate + "toDate : " + toDate + "frIdList  : " + frIdList);

		List<GrnGvnReportByGrnType> gGvnReportByGrnTypeList = new ArrayList<GrnGvnReportByGrnType>();
		try {

			if (!frIdList.contains("0")) {
				System.err.println(" frIdList: It is Not zero ");
				gGvnReportByGrnTypeList = getGrnGvnReportByGrnTypeRepo.getGrnGvnReportByGrnType(fromDate, toDate,
						frIdList);

			} else {
				System.err.println(" frIdList: It is  zero ");

				gGvnReportByGrnTypeList = getGrnGvnReportByGrnTypeRepo.getGrnGvnReportByGrnTypeAllFr(fromDate, toDate);

			}
		} catch (Exception e) {

			System.err.println("Exce in /GrnGvnReportController : /getGrnGvnReportByGrnType msg-" + e.getMessage()
					+ " trace-" + e.getStackTrace().toString());
			e.printStackTrace();
			e.getCause();
		}

		return gGvnReportByGrnTypeList;
	}
	//r1
	//report 1
	@RequestMapping(value = { "/getgGReportByDate" }, method = RequestMethod.POST)
	public @ResponseBody List<GGReportByDate> getgGReportByDate(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("isGrn") List<String> isGrn,
			@RequestParam("frIdList") List<String> frIdList) {
		
		
		System.err.println("Parameter received fromDate:  " +fromDate+ "toDate : " +toDate + "frIdList  : "+frIdList + "isGrn : "+ isGrn);

		List<GGReportByDate> grpByDateList = new ArrayList<GGReportByDate>();
		try {
			
			if (!frIdList.contains("0")) {
				System.err.println(" frIdList: It is Not zero ");
				grpByDateList = gGReportByDateRepo.getGrnGvnReportByDateSelFr(fromDate, toDate, frIdList, isGrn);
						
			} else {
				System.err.println(" frIdList: It is  zero ");

			grpByDateList = gGReportByDateRepo.getGrnGvnReportByDateAllFr(fromDate, toDate, isGrn);
    
			}
		} catch (Exception e) {

			System.err.println("Exce in /GrnGvnReportController : /getgGReportByDate msg-" + e.getMessage()+ " trace-" +e.getStackTrace().toString());
			e.printStackTrace();
			e.getCause();
		}

		return grpByDateList;
	}
	
	//r1
	
	
	// sumit sir query Report 2
		@RequestMapping(value = { "/gGReportGrpByFrId" }, method = RequestMethod.POST)
		public @ResponseBody List<GGReportGrpByFrId> gGReportGrpByFrId(@RequestParam("fromDate") String fromDate,
				@RequestParam("toDate") String toDate, @RequestParam("isGrn") List<String> isGrn,
				@RequestParam("frIdList") List<String> frIdList) {

			System.err.println("Parameter received fromDate:  " +fromDate+ "toDate : " +toDate + "frIdList  : "+frIdList + "isGrn : "+ isGrn);

			List<GGReportGrpByFrId> grpByFrIdList = null;

			try {
				if (!frIdList.contains("0")) {
					System.out.println("fr Id List doesn't contain zero ");
					grpByFrIdList = gGReportGrpByFrIdRepo.getGGReportGrpByFrIdSelFr(fromDate, toDate, isGrn, frIdList);
				} else {
					System.out.println("fr id list is zero : get For All Fr");
					grpByFrIdList = gGReportGrpByFrIdRepo.getGGReportGrpByFrIdSelFrAllFr(fromDate, toDate, isGrn);
				}

			} catch (Exception e) {

				System.err.println("Exce in /GrnGvnReportController : /gGReportGrpByFrId" + e.getMessage());
				e.printStackTrace();
			}

			return grpByFrIdList;
		}

	// report 3
	@RequestMapping(value = { "/getGGReportGrpByDate" }, method = RequestMethod.POST)
	public @ResponseBody List<GGReportGrpByMonthDate> getGGReportGrpByDate(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("isGrn") List<String> isGrn,
			@RequestParam("frIdList") List<String> frIdList) {

		System.err.println("Parameter received fromDate:  " +fromDate+ "toDate : " +toDate + "frIdList  : "+frIdList + "isGrn : "+ isGrn);

		List<GGReportGrpByMonthDate> grpByDateList = null;
		try {
			if (!frIdList.contains("0")) {
				grpByDateList = gGreportGrpByDateMonthRepo.getGrnGvnReportByDateSelFrGroupByDate(fromDate, toDate,
						isGrn, frIdList);
			} else {

				grpByDateList = gGreportGrpByDateMonthRepo.getGrnGvnReportByDateAllFrAllGGGroupByDate(fromDate, toDate,isGrn);

			}
		} catch (Exception e) {

			System.err.println("Exce in /GrnGvnReportController : /getGGReportGrpByDate" + e.getMessage());
			e.printStackTrace();
		}

		return grpByDateList;
	}

	// report 4
	@RequestMapping(value = { "/getGGReportGrpByMonth" }, method = RequestMethod.POST)
	public @ResponseBody List<GGReportGrpByMonthDate> getGGReportGrpByMonth(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("isGrn") List<String> isGrn,
			@RequestParam("frIdList") List<String> frIdList) {
		System.err.println("Parameter received fromDate:  " +fromDate+ "toDate : " +toDate + "frIdList  : "+frIdList + "isGrn : "+ isGrn);

		List<GGReportGrpByMonthDate> grpByDateList = null;
		try {
			if (!frIdList.contains("0")) {
				grpByDateList = gGreportGrpByDateMonthRepo.getGrnGvnReportByDateSelFrGroupByMonth(fromDate, toDate,
						frIdList, isGrn);
			} else {

				grpByDateList = gGreportGrpByDateMonthRepo.getGrnGvnReportByDateAllFrAllGGGroupByMonth(fromDate, toDate,
						isGrn);

			}
		} catch (Exception e) {

			System.err.println("Exce in /GrnGvnReportController : /getGGReportGrpByMonth" + e.getMessage());
			e.printStackTrace();
		}

		return grpByDateList;
	}
	
	@RequestMapping(value = { "/gGReportGrpByItemId" }, method = RequestMethod.POST)
	public @ResponseBody List<GGReportGrpByItemId> gGReportGrpByItemId(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("isGrn") List<String> isGrn,
			@RequestParam("frIdList") List<String> frIdList, @RequestParam("catIdList") List<String> catIdList) {

		System.err.println("Parameter received fromDate:  " + fromDate + "toDate : " + toDate + "frIdList  : "
				+ frIdList + "isGrn : " + isGrn);

		List<GGReportGrpByItemId> grpByFrIdList = null;

		try {
			if (!frIdList.contains("-1") && !catIdList.contains("-1")) {
				System.out.println("fr Id List doesn't contain zero ");
				grpByFrIdList = gGReportGrpByItemIdRepo.getGGReportGrpByFrIdSelFr(fromDate, toDate, isGrn, frIdList,
						catIdList);
			} else if (!frIdList.contains("-1") && catIdList.contains("-1")) {
				grpByFrIdList = gGReportGrpByItemIdRepo.getGGReportGrpByItemId(fromDate, toDate, isGrn, frIdList);
			}

			else if (frIdList.contains("-1") && !catIdList.contains("-1")) {
				grpByFrIdList = gGReportGrpByItemIdRepo.getGGReportGrpByItemIdSelFr(fromDate, toDate, isGrn, catIdList);
			}

			else {
				System.out.println("fr id list is zero : get For All Fr");
				grpByFrIdList = gGReportGrpByItemIdRepo.getGGReportGrpByFrIdSelFrAllFr(fromDate, toDate, isGrn);
			}

		} catch (Exception e) {

			System.err.println("Exce in /GrnGvnReportController : /gGReportGrpByFrId" + e.getMessage());
			e.printStackTrace();
		}

		return grpByFrIdList;
	}
	
	@RequestMapping(value = { "/creditNoteReportBetweenDate" }, method = RequestMethod.POST)
	public @ResponseBody List<CreditNoteReport> creditNoteReportBetweenDate(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("frId") int frId) {

		 

		List<CreditNoteReport> list = new ArrayList<>();
		DecimalFormat df = new DecimalFormat("#.00");
		try {
			if (frId!=0) {
				 
				list = creditNoteReportRepo.creditNoteReportBetweenDate(fromDate, toDate,frId);
				
			} 
			else {
				
				list = creditNoteReportRepo.creditNoteReportBetweenDate(fromDate, toDate);
			}
			
			for(int i =0 ; i<list.size() ; i++)
			{
				
				float rate = ((list.get(i).getIgstPer()/100)*list.get(i).getBaseRate())+list.get(i).getBaseRate();
				float totalAmt = list.get(i).getGrnGvnQty()*rate;
				list.get(i).setBaseRate(Float.parseFloat(df.format(rate)));
				if((totalAmt-list.get(i).getGrnGvnAmt())<=0) {
					list.get(i).setPeneltyAmt(Float.parseFloat(df.format(0)));
				}else {
					list.get(i).setPeneltyAmt(Float.parseFloat(df.format(totalAmt-list.get(i).getGrnGvnAmt())));
				}
				
				
			}
		} catch (Exception e) {

			 
			e.printStackTrace();
		}

		return list;
	}


}
