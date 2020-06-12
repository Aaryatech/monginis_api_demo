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
import com.ats.webapi.model.salesreport.FrSubCatItemReportNew;
import com.ats.webapi.model.salesreport.SubCatBillRep;
import com.ats.webapi.model.salesreport.SubCatCreditGrnFrItemRep;
import com.ats.webapi.model.salesreport.SubCatCreditGrnFrRep;
import com.ats.webapi.model.salesreport.SubCatCreditGrnRep;
import com.ats.webapi.model.salesreport.SubCatFrItemRepBill;
import com.ats.webapi.model.salesreport.SubCatFrRepBill;
import com.ats.webapi.model.salesreport.SubCatFrReport;
import com.ats.webapi.model.salesreport.SubCatItemReport;
import com.ats.webapi.model.salesreport.SubCatReport;
import com.ats.webapi.repo.salesreport.FrSubCatItemReportNewRepo;
import com.ats.webapi.repo.salesreport.SubCatBillRepRepo;
import com.ats.webapi.repo.salesreport.SubCatCreditGrnFrItemRepRepo;
import com.ats.webapi.repo.salesreport.SubCatCreditGrnFrRepRepo;
import com.ats.webapi.repo.salesreport.SubCatCreditGrnRepRepo;
import com.ats.webapi.repo.salesreport.SubCatFrItemRepBillRepo;
import com.ats.webapi.repo.salesreport.SubCatFrRepBillRepo;
import com.ats.webapi.repo.salesreport.SubCatItemReportRepo;
import com.ats.webapi.repo.salesreport.SubCatReportRepo;

@RestController
public class SalesReportApiController2 {

	@Autowired
	SubCatReportRepo subCatReportRepo;

	@Autowired
	SubCatBillRepRepo subCatBillRepRepo;

	@Autowired
	SubCatCreditGrnRepRepo subCatCreditGrnRepRepo;

	@RequestMapping(value = { "/getSubCatReportApi" }, method = RequestMethod.POST)
	public @ResponseBody List<SubCatReport> getSubCatReportApi(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<SubCatReport> catReportList = new ArrayList<>();
		List<SubCatBillRep> catReportBill = null;

		List<SubCatCreditGrnRep> subCatCreditGrnRep = new ArrayList<>();
		List<SubCatCreditGrnRep> subCatCreditGvnRep = new ArrayList<>();
		try {
			fromDate = Common.convertToYMD(fromDate);
			toDate = Common.convertToYMD(toDate);

			// catReportList = subCatReportRepo.getData(fromDate, toDate);

			catReportBill = subCatBillRepRepo.getData(fromDate, toDate);

			subCatCreditGrnRep = subCatCreditGrnRepRepo.getDataGRN(fromDate, toDate);

			System.err.println("Matched -------------------- " + subCatCreditGrnRep);

			subCatCreditGvnRep = subCatCreditGrnRepRepo.getDataGVN(fromDate, toDate);
			System.err.println("Matched -------------------- " + subCatCreditGvnRep);

			for (int i = 0; i < catReportBill.size(); i++) {

				SubCatReport subCatReport = new SubCatReport();

				subCatReport.setCatId(catReportBill.get(i).getCatId());
				subCatReport.setSubCatId(catReportBill.get(i).getSubCatId());
				subCatReport.setSubCatName(catReportBill.get(i).getSubCatName());

				subCatReport.setSoldAmt(catReportBill.get(i).getSoldAmt());
				subCatReport.setSoldQty(catReportBill.get(i).getSoldQty());

				catReportList.add(subCatReport);

			}

			for (int i = 0; i < catReportList.size(); i++) {
				for (int j = 0; j < subCatCreditGrnRep.size(); j++) {

					if (catReportList.get(i).getSubCatId() == subCatCreditGrnRep.get(j).getSubCatId()) {

						System.err.println("Matched -------------------- " + subCatCreditGrnRep.get(j).getSubCatId());

						catReportList.get(i).setRetQty(subCatCreditGrnRep.get(j).getVarQty());
						catReportList.get(i).setRetAmt(subCatCreditGrnRep.get(j).getVarAmt());

						System.err.println("GRN " + subCatCreditGrnRep.get(j).getVarQty());
						System.err.println("GRN AMT  " + subCatCreditGrnRep.get(j).getVarAmt());

						break;

					} else {

						catReportList.get(i).setRetAmt(0);
						catReportList.get(i).setRetQty(0);
					}

				}
			}

			for (int i = 0; i < catReportList.size(); i++) {
				for (int j = 0; j < subCatCreditGvnRep.size(); j++) {

					if (catReportList.get(i).getSubCatId() == subCatCreditGvnRep.get(j).getSubCatId()) {

						catReportList.get(i).setVarAmt(subCatCreditGvnRep.get(j).getVarAmt());
						catReportList.get(i).setVarQty(subCatCreditGvnRep.get(j).getVarQty());
						System.err.println("GVN " + subCatCreditGvnRep.get(j).getVarQty());
						System.err.println("GVN AMT  " + subCatCreditGvnRep.get(j).getVarAmt());

						break;

					} else {

						catReportList.get(i).setVarAmt(0);
						catReportList.get(i).setVarQty(0);
					}

				}
			}

		} catch (Exception e) {
			System.out.println(" Exce in Tax1 Report " + e.getMessage());
			e.printStackTrace();
		}
		return catReportList;
	}

	@RequestMapping(value = { "/getSubCatReportApiByFrId" }, method = RequestMethod.POST)
	public @ResponseBody List<SubCatReport> getSubCatReportApiByFrId(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("frId") int frId) {

		List<SubCatReport> catReportList = new ArrayList<>();
		List<SubCatBillRep> catReportBill = null;

		List<SubCatCreditGrnRep> subCatCreditGrnRep = null;
		List<SubCatCreditGrnRep> subCatCreditGvnRep = null;
		try {
			fromDate = Common.convertToYMD(fromDate);
			toDate = Common.convertToYMD(toDate);

			// catReportList = subCatReportRepo.getData(fromDate, toDate);

			catReportBill = subCatBillRepRepo.getDataByFrId(fromDate, toDate, frId);

			subCatCreditGrnRep = subCatCreditGrnRepRepo.getDataGRNByFrId(fromDate, toDate, frId);

			subCatCreditGvnRep = subCatCreditGrnRepRepo.getDataGVNByFrId(fromDate, toDate, frId);

			for (int i = 0; i < catReportBill.size(); i++) {

				SubCatReport subCatReport = new SubCatReport();

				subCatReport.setCatId(catReportBill.get(i).getCatId());
				subCatReport.setSubCatId(catReportBill.get(i).getSubCatId());
				subCatReport.setSubCatName(catReportBill.get(i).getSubCatName());

				subCatReport.setSoldAmt(catReportBill.get(i).getSoldAmt());
				subCatReport.setSoldQty(catReportBill.get(i).getSoldQty());

				catReportList.add(subCatReport);

			}

			for (int i = 0; i < catReportList.size(); i++) {
				for (int j = 0; j < subCatCreditGrnRep.size(); j++) {

					if (catReportList.get(i).getSubCatId() == subCatCreditGrnRep.get(j).getSubCatId()) {

						System.err.println("Matched -------------------- " + subCatCreditGrnRep.get(j).getSubCatId());

						catReportList.get(i).setRetQty(subCatCreditGrnRep.get(j).getVarQty());
						catReportList.get(i).setRetAmt(subCatCreditGrnRep.get(j).getVarAmt());

						break;

					} else {

						catReportList.get(i).setRetAmt(0);
						catReportList.get(i).setRetQty(0);
					}

				}
			}

			for (int i = 0; i < catReportList.size(); i++) {
				for (int j = 0; j < subCatCreditGvnRep.size(); j++) {

					if (catReportList.get(i).getSubCatId() == subCatCreditGvnRep.get(j).getSubCatId()) {

						catReportList.get(i).setVarAmt(subCatCreditGvnRep.get(j).getVarAmt());
						catReportList.get(i).setVarQty(subCatCreditGvnRep.get(j).getVarQty());
						break;

					} else {

						catReportList.get(i).setVarAmt(0);
						catReportList.get(i).setVarQty(0);
					}

				}
			}

		} catch (Exception e) {
			System.out.println(" Exce in Tax1 Report " + e.getMessage());
			e.printStackTrace();
		}
		return catReportList;
	}

	@Autowired
	SubCatCreditGrnFrRepRepo subCatCreditGrnFrRepRepo;

	@Autowired
	SubCatFrRepBillRepo subCatFrRepBillRepo;

	@RequestMapping(value = { "/getSubCatFrReportApi" }, method = RequestMethod.POST)
	public @ResponseBody List<SubCatFrReport> getSubCatFrReportApi(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("frIdList") List<Integer> frIdList,
			@RequestParam("subCatIdList") List<Integer> subCatIdList) {

		List<SubCatFrReport> catReportList = new ArrayList<>();
		List<SubCatFrRepBill> catReportBill = null;

		List<SubCatCreditGrnFrRep> subCatCreditGrnRep = null;
		List<SubCatCreditGrnFrRep> subCatCreditGvnRep = null;
		try {
			fromDate = Common.convertToYMD(fromDate);
			toDate = Common.convertToYMD(toDate);

			// catReportList = subCatReportRepo.getData(fromDate, toDate);

			catReportBill = subCatFrRepBillRepo.getData(fromDate, toDate, frIdList, subCatIdList);

			subCatCreditGrnRep = subCatCreditGrnFrRepRepo.getDataGRN(fromDate, toDate, frIdList, subCatIdList);

			subCatCreditGvnRep = subCatCreditGrnFrRepRepo.getDataGVN(fromDate, toDate, frIdList, subCatIdList);

			System.out.println(catReportBill.toString());
			System.out.println(subCatCreditGrnRep.toString());
			System.out.println(subCatCreditGvnRep.toString());

			for (int i = 0; i < catReportBill.size(); i++) {

				SubCatFrReport subCatReport = new SubCatFrReport();
				subCatReport.setSubCatId(catReportBill.get(i).getSubCatId());
				subCatReport.setSubCatName(catReportBill.get(i).getSubCatName());
				subCatReport.setFrId(catReportBill.get(i).getFrId());
				subCatReport.setFrName(catReportBill.get(i).getFrName());
				subCatReport.setSoldAmt(catReportBill.get(i).getSoldAmt());
				subCatReport.setSoldQty(catReportBill.get(i).getSoldQty());
				subCatReport.setBillDetailNo(catReportBill.get(i).getBillDetailNo());

				catReportList.add(subCatReport);

			}

			for (int i = 0; i < catReportList.size(); i++) {
				for (int j = 0; j < subCatCreditGrnRep.size(); j++) {

					if (catReportList.get(i).getFrId() == subCatCreditGrnRep.get(j).getFrId()
							&& catReportList.get(i).getSubCatId() == subCatCreditGrnRep.get(j).getSubCatId()) {

						catReportList.get(i).setRetAmt(subCatCreditGrnRep.get(j).getVarAmt());
						catReportList.get(i).setRetQty(subCatCreditGrnRep.get(j).getVarQty());
						break;

					} /*
						 * else {
						 * 
						 * catReportList.get(i).setRetAmt(0); catReportList.get(i).setRetQty(0); }
						 */

				}
			}

			for (int i = 0; i < catReportList.size(); i++) {
				for (int j = 0; j < subCatCreditGvnRep.size(); j++) {

					if (catReportList.get(i).getFrId() == subCatCreditGrnRep.get(j).getFrId()
							&& catReportList.get(i).getSubCatId() == subCatCreditGrnRep.get(j).getSubCatId()) {

						catReportList.get(i).setVarAmt(subCatCreditGvnRep.get(j).getVarAmt());
						catReportList.get(i).setVarQty(subCatCreditGvnRep.get(j).getVarQty());
						break;

					} /*
						 * else {
						 * 
						 * catReportList.get(i).setVarAmt(0); catReportList.get(i).setVarQty(0); }
						 */

				}
			}

		} catch (Exception e) {
			System.out.println(" Exce in Tax1 Report " + e.getMessage());
			e.printStackTrace();
		}
		return catReportList;
	}

	@Autowired
	SubCatCreditGrnFrItemRepRepo subCatCreditGrnFrItemRepRepo;

	@Autowired
	SubCatFrItemRepBillRepo subCatFrItemRepBillRepo;

	@Autowired
	SubCatItemReportRepo subCatItemReportRepo;

	@RequestMapping(value = { "/getSubCatFrItemReportApi" }, method = RequestMethod.POST)
	public @ResponseBody List<SubCatItemReport> getSubCatFrItemReportApi(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("frIdList") List<Integer> frIdList,
			@RequestParam("subCatIdList") List<Integer> subCatIdList) {

		List<SubCatItemReport> catReportList = new ArrayList<>();
		List<SubCatFrItemRepBill> catReportBill = null;

		List<SubCatCreditGrnFrItemRep> subCatCreditGrnRep = null;
		List<SubCatCreditGrnFrItemRep> subCatCreditGvnRep = null;
		try {
			fromDate = Common.convertToYMD(fromDate);
			toDate = Common.convertToYMD(toDate);

			catReportList = subCatItemReportRepo.getFrWiseSubCatWiseItemWiseData(fromDate, toDate, frIdList,
					subCatIdList);

//			catReportBill = subCatFrItemRepBillRepo.getData(fromDate, toDate, frIdList, subCatIdList);
//
//			subCatCreditGrnRep = subCatCreditGrnFrItemRepRepo.getDataGRN(fromDate, toDate, frIdList, subCatIdList);
//
//			subCatCreditGvnRep = subCatCreditGrnFrItemRepRepo.getDataGVN(fromDate, toDate, frIdList, subCatIdList);
//
//			System.out.println(catReportBill.toString());
//			System.out.println(subCatCreditGrnRep.toString());
//			System.out.println(subCatCreditGvnRep.toString());
//
//			for (int i = 0; i < catReportBill.size(); i++) {
//
//				SubCatItemReport subCatReport = new SubCatItemReport();
//
//				subCatReport.setSubCatId(catReportBill.get(i).getSubCatId());
//				subCatReport.setSubCatName(catReportBill.get(i).getSubCatName());
//				subCatReport.setFrId(catReportBill.get(i).getFrId());
//				subCatReport.setFrName(catReportBill.get(i).getFrName());
//				subCatReport.setSoldAmt(catReportBill.get(i).getSoldAmt());
//				subCatReport.setSoldQty(catReportBill.get(i).getSoldQty());
//				subCatReport.setItemId(catReportBill.get(i).getItemId());
//				subCatReport.setItemName(catReportBill.get(i).getItemName());
//
//				catReportList.add(subCatReport);
//
//			}
//
//			for (int i = 0; i < catReportList.size(); i++) {
//				for (int j = 0; j < subCatCreditGrnRep.size(); j++) {
//
//					if (catReportList.get(i).getItemId() == subCatCreditGrnRep.get(j).getItemId() && catReportList.get(i).getSubCatId() ==subCatCreditGrnRep.get(j).getSubCatId()&& catReportList.get(i).getFrId() ==subCatCreditGrnRep.get(j).getFrId()) {
//
//						catReportList.get(i).setRetAmt(subCatCreditGrnRep.get(j).getVarAmt());
//						catReportList.get(i).setRetQty(subCatCreditGrnRep.get(j).getVarQty());
//						break;
//
//					} 
//
//				}
//			}
//
//			for (int i = 0; i < catReportList.size(); i++) {
//				for (int j = 0; j < subCatCreditGvnRep.size(); j++) {
//
//					if (catReportList.get(i).getItemId() == subCatCreditGrnRep.get(j).getItemId() && catReportList.get(i).getSubCatId() ==subCatCreditGrnRep.get(j).getSubCatId()&& catReportList.get(i).getFrId() ==subCatCreditGrnRep.get(j).getFrId()) {
//
//						catReportList.get(i).setVarAmt(subCatCreditGvnRep.get(j).getVarAmt());
//						catReportList.get(i).setVarQty(subCatCreditGvnRep.get(j).getVarQty());
//						break;
//
//					} 
//
//				}
//			}

		} catch (Exception e) {
			System.out.println(" Exce in Tax1 Report " + e.getMessage());
			e.printStackTrace();
		}
		return catReportList;
	}

	@Autowired
	FrSubCatItemReportNewRepo frSubCatItemReportNewRepo;

	@RequestMapping(value = { "/getFrSubCatItemWiseReport" }, method = RequestMethod.POST)
	public @ResponseBody List<FrSubCatItemReportNew> getFrSubCatItemWiseReport(
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,
			@RequestParam("frIdList") List<Integer> frIdList,
			@RequestParam("subCatIdList") List<Integer> subCatIdList) {

		List<FrSubCatItemReportNew> catReportList = new ArrayList<>();

		try {
			fromDate = Common.convertToYMD(fromDate);
			toDate = Common.convertToYMD(toDate);

			catReportList = frSubCatItemReportNewRepo.getFrWiseSubCatWiseItemWiseData(fromDate, toDate, frIdList,
					subCatIdList);
			
			

		} catch (Exception e) {
			System.out.println(" Exce in Tax1 Report " + e.getMessage());
			e.printStackTrace();
		}
		return catReportList;
	}

}
