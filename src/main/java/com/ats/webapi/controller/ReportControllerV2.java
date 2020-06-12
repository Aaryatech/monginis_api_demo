package com.ats.webapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.commons.Common;
import com.ats.webapi.model.GrandTotalBillWise;
import com.ats.webapi.model.GrandTotalCreditnoteWise;
import com.ats.webapi.model.reportv2.CrNoteRegItem;
import com.ats.webapi.model.reportv2.CrNoteRegSp;
import com.ats.webapi.model.reportv2.CrNoteRegisterList;
import com.ats.webapi.model.reportv2.GstRegisterItem;
import com.ats.webapi.model.reportv2.GstRegisterList;
import com.ats.webapi.model.reportv2.GstRegisterSp;
import com.ats.webapi.model.reportv2.HSNWiseReport;
import com.ats.webapi.model.reportv2.SalesReport;
import com.ats.webapi.repo.GrandTotalCreditnoteWiseRepository;
import com.ats.webapi.repository.reportv2.CrNoteRegItemRepo;
import com.ats.webapi.repository.reportv2.CrNoteRegSpRepo;
import com.ats.webapi.repository.reportv2.GstRegisterItemRepo;
import com.ats.webapi.repository.reportv2.GstRegisterSpRepo;
import com.ats.webapi.repository.reportv2.HSNWiseReportRepo;
import com.ats.webapi.repository.reportv2.SalesReportRepo;

@RestController
public class ReportControllerV2 {

	@Autowired
	SalesReportRepo getSalesReportRepo;
	@Autowired
	GstRegisterItemRepo getGstRegisterItemRepo;

	@Autowired
	GstRegisterSpRepo getGstRegisterSpRepo;

	@Autowired
	CrNoteRegSpRepo getCrNoteRegSpRepo;
	@Autowired
	CrNoteRegItemRepo getCrNoteRegItemRepo;

	@Autowired
	HSNWiseReportRepo hSNWiseReportRepo;

	@Autowired
	GrandTotalCreditnoteWiseRepository grandTotalCreditnoteWiseRepository;

	@RequestMapping(value = { "/getHsnBillReport" }, method = RequestMethod.POST)
	public @ResponseBody List<HSNWiseReport> getHsnBillReport(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {
		List<HSNWiseReport> saleList = new ArrayList<>();
		try {

			saleList = hSNWiseReportRepo.getReport(fromDate, toDate);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return saleList;
	}

	@RequestMapping(value = { "/getHsnBillReportByFrId" }, method = RequestMethod.POST)
	public @ResponseBody List<HSNWiseReport> getHsnBillReportByFrId(@RequestParam("frId") int frId,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {
		List<HSNWiseReport> saleList = new ArrayList<>();
		try {

			saleList = hSNWiseReportRepo.getReportByFrId(frId, fromDate, toDate);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return saleList;
	}

	@RequestMapping(value = { "/getHsnReport" }, method = RequestMethod.POST)
	public @ResponseBody List<HSNWiseReport> getHsnReport(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<HSNWiseReport> saleList = new ArrayList<>();
		try {

			saleList = hSNWiseReportRepo.getReportHsn(fromDate, toDate);
			System.out.println(saleList.toString());

		} catch (Exception e) {
			// TODO: handle exception
		}

		return saleList;
	}

	// Anmol---->5/12/2019--------------->
	@RequestMapping(value = { "/getHsnReportFilterGrnGvn" }, method = RequestMethod.POST)
	public @ResponseBody List<HSNWiseReport> getHsnReportFilterGrnGvn(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("grngvnType") List<Integer> grngvnType) {

		List<HSNWiseReport> saleList = new ArrayList<>();
		try {

			saleList = hSNWiseReportRepo.getReportHsnIn(fromDate, toDate, grngvnType);
			System.out.println(saleList.toString());

		} catch (Exception e) {
			// TODO: handle exception
		}

		return saleList;
	}

	@RequestMapping(value = { "/getHsnReportByFrId" }, method = RequestMethod.POST)
	public @ResponseBody List<HSNWiseReport> getHsnReportByFrId(@RequestParam("frId") int frId,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {

		List<HSNWiseReport> saleList = new ArrayList<>();
		try {

			saleList = hSNWiseReportRepo.getReportHsnByFrId(frId, fromDate, toDate);
			System.out.println(saleList.toString());

		} catch (Exception e) {
			// TODO: handle exception
		}

		return saleList;
	}

	@RequestMapping(value = { "/getSalesReportV2" }, method = RequestMethod.POST)
	public @ResponseBody List<SalesReport> getSalesReportV2(@RequestParam("frIdList") List<String> frIdList,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {

		List<SalesReport> saleList = new ArrayList<>();

		saleList = getSalesReportRepo.getSalesReportSpecFr(fromDate, toDate, frIdList);

		return saleList;
	}

//	@RequestMapping(value = { "/getGstRegister" }, method = RequestMethod.POST)
//	public @ResponseBody GstRegisterList getGstRegister(@RequestParam("frIdList") List<Integer> frIdList,
//			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {
//
//		System.err.println("-------------------- IN getGstRegister-----------------------------");
//
//		GstRegisterList gstList = new GstRegisterList();
//
//		if (frIdList.contains("-1")) {
//
//			List<GstRegisterItem> saleList1 = new ArrayList<>();
//			List<GstRegisterSp> saleList2 = new ArrayList<>();
//
//			saleList1 = getGstRegisterItemRepo.getGstRegisterAllFrItem(fromDate, toDate);
//			gstList.setGstRegItemList(saleList1);
//
//			saleList2 = getGstRegisterSpRepo.getGstRegisterAllFrSp(fromDate, toDate);
//			gstList.setGstRegSpList(saleList2);
//
//		} else {
//
//			List<GstRegisterItem> saleList1 = new ArrayList<>();
//			List<GstRegisterSp> saleList2 = new ArrayList<>();
//
//			saleList1 = getGstRegisterItemRepo.getGstRegisterSpecFrItem(fromDate, toDate, frIdList);
//			gstList.setGstRegItemList(saleList1);
//
//			saleList2 = getGstRegisterSpRepo.getGstRegisterSpecFrSp(fromDate, toDate, frIdList);
//			gstList.setGstRegSpList(saleList2);
//
//		}
//		System.err.println("size Item  gstList " + gstList.getGstRegItemList().size());
//		System.err.println("size Sp  gstList " + gstList.getGstRegSpList());
//
//		return gstList;
//	}

	@RequestMapping(value = { "/getGstRegisterNew" }, method = RequestMethod.POST)
	public @ResponseBody List<GstRegisterItem> getGstRegisterNew(@RequestParam("frIdList") List<Integer> frIdList,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {

		System.err.println("-------------------- IN getGstRegisterNew-----------------------------");

		List<GstRegisterItem> saleList1 = null;

		saleList1 = getGstRegisterItemRepo.getGstRegisterNew(fromDate, toDate, frIdList);

		if (saleList1 == null) {
			saleList1 = new ArrayList<>();
		}

		System.err.println("gstList - " + saleList1);

		return saleList1;
	}

	@RequestMapping(value = { "/getCrNoteRegister" }, method = RequestMethod.POST)
	public @ResponseBody CrNoteRegisterList getCrNoteRegister(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		CrNoteRegisterList crNoteList = new CrNoteRegisterList();

		List<CrNoteRegItem> crNoteRegItemList;
		List<CrNoteRegSp> crNoteRegSpList = new ArrayList<CrNoteRegSp>();

		crNoteRegItemList = getCrNoteRegItemRepo.getCrNoteRegItem(fromDate, toDate);
		crNoteList.setCrNoteRegItemList(crNoteRegItemList);

		// crNoteRegSpList = getCrNoteRegSpRepo.getCrNoteRegSp(fromDate, toDate);
		crNoteList.setCrNoteRegSpList(crNoteRegSpList);

		System.err.println("size Item  crNoteList " + crNoteList.getCrNoteRegItemList().size());
		System.err.println("size Sp  crNoteList " + crNoteList.getCrNoteRegSpList());

		return crNoteList;
	}

	@RequestMapping(value = { "/getCrNoteRegisterNew" }, method = RequestMethod.POST)
	public @ResponseBody List<CrNoteRegItem> getCrNoteRegisterNew(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<CrNoteRegItem> crNoteRegItemList;

		crNoteRegItemList = getCrNoteRegItemRepo.getCrNoteRegItemNew(fromDate, toDate);
		if (crNoteRegItemList == null) {
			crNoteRegItemList = new ArrayList<>();
		}

		return crNoteRegItemList;
	}

	// neha
	@RequestMapping(value = { "/getCrNoteRegisterByFrId" }, method = RequestMethod.POST)
	public @ResponseBody CrNoteRegisterList getCrNoteRegisterByFrId(@RequestParam("frId") int frId,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {

		CrNoteRegisterList crNoteList = new CrNoteRegisterList();

		List<CrNoteRegItem> crNoteRegItemList;
		List<CrNoteRegSp> crNoteRegSpList = new ArrayList<CrNoteRegSp>();

		crNoteRegItemList = getCrNoteRegItemRepo.getCrNoteRegItemByFrId(frId, fromDate, toDate);
		crNoteList.setCrNoteRegItemList(crNoteRegItemList);

		// crNoteRegSpList = getCrNoteRegSpRepo.getCrNoteRegSpByFrId(frId, fromDate,
		// toDate);
		crNoteList.setCrNoteRegSpList(crNoteRegSpList);

		System.err.println("size Item  crNoteList " + crNoteList.getCrNoteRegItemList().size());
		System.err.println("size Sp  crNoteList " + crNoteList.getCrNoteRegSpList());

		return crNoteList;
	}

	@RequestMapping(value = { "/getCrNoteRegisterDone" }, method = RequestMethod.POST)
	public @ResponseBody CrNoteRegisterList getCrNoteRegisterDone(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("CreditNoteType") String CreditNoteType) {

		CrNoteRegisterList crNoteList = new CrNoteRegisterList();

		List<CrNoteRegItem> crNoteRegItemList;
		List<CrNoteRegSp> crNoteRegSpList = new ArrayList<>();

		crNoteRegItemList = getCrNoteRegItemRepo.getCrNoteRegItemDone(fromDate, toDate, CreditNoteType);
		crNoteList.setCrNoteRegItemList(crNoteRegItemList);

		// crNoteRegSpList = getCrNoteRegSpRepo.getCrNoteRegSpDone(fromDate, toDate);
		crNoteList.setCrNoteRegSpList(crNoteRegSpList);

		System.err.println("size Item  crNoteList " + crNoteList.getCrNoteRegItemList().size());
		System.err.println("size Sp  crNoteList " + crNoteList.getCrNoteRegSpList());

		return crNoteList;
	}

	@RequestMapping(value = { "/getGrandTotalCreditnotewise" }, method = RequestMethod.POST)
	public @ResponseBody List<GrandTotalCreditnoteWise> getGrandTotalCreditnotewise(
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,
			@RequestParam("creditNoteType") int creditNoteType) {

		List<GrandTotalCreditnoteWise> tax1ReportList = new ArrayList<>();
		try {
			fromDate = Common.convertToYMD(fromDate);
			toDate = Common.convertToYMD(toDate);
			tax1ReportList = grandTotalCreditnoteWiseRepository.getGrandTotalCreditnotewise(fromDate, toDate,
					creditNoteType);

		} catch (Exception e) {
			System.out.println(" Exce in Tax1 Report " + e.getMessage());
			e.printStackTrace();
		}
		return tax1ReportList;
	}

	// neha
	@RequestMapping(value = { "/getCrNoteRegisterDoneByFrId" }, method = RequestMethod.POST)
	public @ResponseBody CrNoteRegisterList getCrNoteRegisterDoneByFrId(@RequestParam("frId") int frId,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {

		CrNoteRegisterList crNoteList = new CrNoteRegisterList();

		List<CrNoteRegItem> crNoteRegItemList;
		List<CrNoteRegSp> crNoteRegSpList = new ArrayList<CrNoteRegSp>();

		crNoteRegItemList = getCrNoteRegItemRepo.getCrNoteRegItemDoneByFrId(frId, fromDate, toDate);
		crNoteList.setCrNoteRegItemList(crNoteRegItemList);

		// crNoteRegSpList = getCrNoteRegSpRepo.getCrNoteRegSpDoneByFrId(frId, fromDate,
		// toDate);
		crNoteList.setCrNoteRegSpList(crNoteRegSpList);

		System.err.println("size Item  crNoteList " + crNoteList.getCrNoteRegItemList().size());
		System.err.println("size Sp  crNoteList " + crNoteList.getCrNoteRegSpList());

		return crNoteList;
	}
}
