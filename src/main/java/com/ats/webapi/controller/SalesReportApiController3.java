package com.ats.webapi.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.opssalesreport.FrItemWiseSellData;
import com.ats.webapi.model.opssalesreport.FrItemWiseYearlyData;
import com.ats.webapi.model.opssalesreport.FrItemwiseData;
import com.ats.webapi.model.opssalesreport.FrItemwiseVarAndRetData;
import com.ats.webapi.model.opssalesreport.FrSubCatWiseSellData;
import com.ats.webapi.model.opssalesreport.ItemList;
import com.ats.webapi.model.opssalesreport.SubCatDateWiseData;
import com.ats.webapi.model.opssalesreport.SubCatWiseItems;
import com.ats.webapi.model.opssalesreport.TempItemList;
import com.ats.webapi.model.opssalesreport.TempSubCatWiseItems;
import com.ats.webapi.model.salesreport.ItemWiseFrList;
import com.ats.webapi.model.salesreport.SubCatItemFrBill;
import com.ats.webapi.model.salesreport.SubCatItemFrVarAndRet;
import com.ats.webapi.model.salesreport.SubCatWiseItemList;
import com.ats.webapi.model.salesreport.SubCatWiseItemWiseFrSold;
import com.ats.webapi.model.salesreport3.FrAndSubCatBillData;
import com.ats.webapi.model.salesreport3.FrAndSubCatGrnGvnData;
import com.ats.webapi.model.salesreport3.FrWiseSubCat;
import com.ats.webapi.model.salesreport3.HsnDateWiseSellReport;
import com.ats.webapi.model.salesreport3.SubCatWiseBillData;
import com.ats.webapi.model.salesreport3.TempFrWiseSubCat;
import com.ats.webapi.model.salesreport3.TempSubCatWiseBillData;
import com.ats.webapi.repo.salesreport.SubCatItemFrBillRepo;
import com.ats.webapi.repo.salesreport.SubCatItemFrVarAndRetRepo;
import com.ats.webapi.repo.salesreport3.FrAndSubCatBillDataRepo;
import com.ats.webapi.repo.salesreport3.FrAndSubCatGrnGvnDataRepo;
import com.ats.webapi.repo.salesreport3.FrItemWiseGrnGvnRepo;
import com.ats.webapi.repo.salesreport3.FrItemWiseSellDataRepo;
import com.ats.webapi.repo.salesreport3.FrItemWiseSoldDataRepo;
import com.ats.webapi.repo.salesreport3.FrSubCatWiseSellDataRepo;
import com.ats.webapi.repo.salesreport3.HsnDateWiseSellReportRepo;
import com.ats.webapi.repo.salesreport3.SubCatDateWiseDataRepo;
import com.ats.webapi.model.salesreport3.FrSubCatBillData;
import com.ats.webapi.model.salesreport3.YearlyFrSubCatData;

@RestController
public class SalesReportApiController3 {

	@Autowired
	SubCatItemFrBillRepo subCatItemFrBillRepo;

	@Autowired
	SubCatItemFrVarAndRetRepo subCatItemFrVarAndRetRepo;

	@Autowired
	FrAndSubCatBillDataRepo frAndSubCatBillDataRepo;

	@Autowired
	FrAndSubCatGrnGvnDataRepo frAndSubCatGrnGvnDataRepo;

	@Autowired
	FrItemWiseSoldDataRepo frItemWiseSoldDataRepo;

	@Autowired
	FrItemWiseGrnGvnRepo frItemWiseGrnGvnRepo;

	@Autowired
	FrItemWiseSellDataRepo frItemWiseSellDataRepo;

	@Autowired
	FrSubCatWiseSellDataRepo frSubCatWiseSellDataRepo;

	@Autowired
	SubCatDateWiseDataRepo subCatDateWiseDataRepo;

	@Autowired
	HsnDateWiseSellReportRepo hsnDateWiseSellReportRepo;

	@RequestMapping(value = { "/getFrWiseItemSoldReport" }, method = RequestMethod.POST)
	public @ResponseBody List<SubCatWiseItemWiseFrSold> getFrWiseItemSoldReport(
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,
			@RequestParam("subCatIdList") List<Integer> subCatIdList) {

		System.err.println("PARAMETER ---------------- FROM DATE : " + fromDate + "        TO DATE : " + toDate
				+ "     SC : " + subCatIdList);

		List<SubCatWiseItemWiseFrSold> reportList = new ArrayList<>();

		try {

			List<SubCatItemFrBill> soldList = subCatItemFrBillRepo.getData(fromDate, toDate, subCatIdList);
			List<SubCatItemFrVarAndRet> varList = subCatItemFrVarAndRetRepo.getVariation(fromDate, toDate,
					subCatIdList);
			List<SubCatItemFrVarAndRet> retList = subCatItemFrVarAndRetRepo.getReturn(fromDate, toDate, subCatIdList);

			if (soldList != null) {

				for (int i = 0; i < subCatIdList.size(); i++) {

					List<Integer> tempSubCatIds = new ArrayList<>();

					for (int j = 0; j < soldList.size(); j++) {

						if (subCatIdList.get(i) == soldList.get(j).getSubCatId()) {

							if (!tempSubCatIds.contains(soldList.get(j).getSubCatId())) {

								tempSubCatIds.add(soldList.get(j).getSubCatId());

								SubCatWiseItemWiseFrSold subCatModel = new SubCatWiseItemWiseFrSold();
								subCatModel.setSubCatId(subCatIdList.get(i));
								subCatModel.setSubCatName(soldList.get(j).getSubCatName());

								List<SubCatWiseItemList> itemList = new ArrayList<>();

								List<Integer> tempItemIds = new ArrayList<>();

								for (int k = 0; k < soldList.size(); k++) {

									if ((!tempItemIds.contains(soldList.get(k).getItemId()))
											&& subCatIdList.get(i) == soldList.get(k).getSubCatId()) {

										tempItemIds.add(soldList.get(k).getItemId());

										SubCatWiseItemList item = new SubCatWiseItemList();
										item.setItemId(soldList.get(k).getItemId());
										item.setItemName(soldList.get(k).getItemName());
										item.setSubCatId(soldList.get(k).getSubCatId());

										itemList.add(item);

										List<ItemWiseFrList> frList = new ArrayList<>();

										List<Integer> tempFrIds = new ArrayList<>();

										for (int m = 0; m < soldList.size(); m++) {

											if ((!tempFrIds.contains(soldList.get(m).getFrId()))
													&& subCatIdList.get(i) == soldList.get(m).getSubCatId()
													&& soldList.get(k).getItemId() == soldList.get(m).getItemId()) {

												ItemWiseFrList fr = new ItemWiseFrList();
												fr.setFrId(soldList.get(m).getFrId());
												fr.setFrName(soldList.get(m).getFrName());

												fr.setItemId(soldList.get(m).getItemId());

												fr.setFrSoldAmt(soldList.get(m).getBillTotal());
												fr.setFrSoldQty(soldList.get(m).getBillQty());
												fr.setFrTaxableAmt(soldList.get(m).getBillTaxableAmt());
												fr.setFrTotalTax(soldList.get(m).getBillTotalTax());

												if (varList != null) {
													for (int v = 0; v < varList.size(); v++) {

														if (subCatIdList.get(i) == varList.get(v).getSubCatId()
																&& soldList.get(m).getCatId() == varList.get(v)
																		.getCatId()
																&& soldList.get(m).getItemId() == varList.get(v)
																		.getItemId()
																&& soldList.get(m).getFrId() == varList.get(v)
																		.getFrId()) {
															fr.setFrVarAmt(varList.get(v).getVarAmt());
															fr.setFrVarQty(varList.get(v).getVarQty());
															fr.setFrVarTaxableAmt(varList.get(v).getVarTaxableAmt());
															fr.setFrVarTax(varList.get(v).getVarTotalTax());
															break;

														}

													}
												}

												if (retList != null) {
													for (int v = 0; v < retList.size(); v++) {

														if (subCatIdList.get(i) == retList.get(v).getSubCatId()
																&& soldList.get(m).getCatId() == retList.get(v)
																		.getCatId()
																&& soldList.get(m).getItemId() == retList.get(v)
																		.getItemId()
																&& soldList.get(m).getFrId() == retList.get(v)
																		.getFrId()) {
															fr.setFrRetAmt(retList.get(v).getVarAmt());
															fr.setFrRetQty(retList.get(v).getVarQty());
															fr.setFrRetTaxableAmt(retList.get(v).getVarTaxableAmt());
															fr.setFrRetTax(retList.get(v).getVarTotalTax());
															break;

														}

													}
												}

												frList.add(fr);

											}

										}

										item.setFrList(frList);

									}

								}

								subCatModel.setItemList(itemList);

								reportList.add(subCatModel);

							}
							break;
						}

					}
				}

			}

		} catch (Exception e) {

		}

		return reportList;
	}

	// ----------YEARLY REPORT--------------

	@RequestMapping(value = { "/getYearlyFrSubCatSaleReport" }, method = RequestMethod.POST)
	public @ResponseBody List<YearlyFrSubCatData> getYearlyFrSubCatSaleReport(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("subCatIdList") List<Integer> subCatIdList,
			@RequestParam("frIdList") List<Integer> frIdList) {

		System.err.println("PARAMETER ---------------- FROM DATE : " + fromDate + "        TO DATE : " + toDate
				+ "     SC : " + subCatIdList + "          FR : " + frIdList);

		List<YearlyFrSubCatData> reportList = new ArrayList<>();
		List<FrWiseSubCat> frWiseSubCatList = new ArrayList<>();

		try {

			List<FrAndSubCatBillData> soldList = frAndSubCatBillDataRepo.getBillData(fromDate, toDate, frIdList,
					subCatIdList);
			List<FrAndSubCatGrnGvnData> varList = frAndSubCatGrnGvnDataRepo.getVariationData(fromDate, toDate, frIdList,
					subCatIdList);
			List<FrAndSubCatGrnGvnData> retList = frAndSubCatGrnGvnDataRepo.getReturnData(fromDate, toDate, frIdList,
					subCatIdList);

			System.err.println("SOLD -- " + soldList);
			System.err.println("VAR -- " + varList);
			System.err.println("RET -- " + retList);

			ArrayList<Integer> frIds = new ArrayList<>();
			ArrayList<String> frNames = new ArrayList<>();

			if (soldList != null) {
				for (int i = 0; i < soldList.size(); i++) {
					if (!frIds.contains(soldList.get(i).getFrId())) {
						frIds.add(soldList.get(i).getFrId());
						frNames.add(soldList.get(i).getFrName());
					}
				}
			}

			if (varList != null) {
				for (int i = 0; i < varList.size(); i++) {
					if (!frIds.contains(varList.get(i).getFrId())) {
						frIds.add(varList.get(i).getFrId());
						frNames.add(varList.get(i).getFrName());
					}
				}
			}

			if (retList != null) {
				for (int i = 0; i < retList.size(); i++) {
					if (!frIds.contains(retList.get(i).getFrId())) {
						frIds.add(retList.get(i).getFrId());
						frNames.add(retList.get(i).getFrName());
					}
				}
			}

			System.err.println("FR IDS ----------------------------------- " + frIds);
			System.err.println("FR NAMES ----------------------------------- " + frNames);

			for (int i = 0; i < frIds.size(); i++) {

				FrWiseSubCat frWiseList = new FrWiseSubCat();

				frWiseList.setFrId(frIds.get(i));
				frWiseList.setFrName(frNames.get(i));

				ArrayList<SubCatWiseBillData> subCatBillList = new ArrayList<>();
				ArrayList<Integer> tempSubCatIdList = new ArrayList<>();

				for (int j = 0; j < soldList.size(); j++) {

					if (frIds.get(i) == soldList.get(j).getFrId()) {

						if (!tempSubCatIdList.contains(soldList.get(j).getSubCatId())) {

							tempSubCatIdList.add(soldList.get(j).getSubCatId());

							SubCatWiseBillData bill = new SubCatWiseBillData();

							bill.setSubCatId(soldList.get(j).getSubCatId());
							bill.setSubCatName(soldList.get(j).getSubCatName());

							subCatBillList.add(bill);
						}

					}

				}

				for (int j = 0; j < varList.size(); j++) {

					if (frIds.get(i) == varList.get(j).getFrId()) {

						if (!tempSubCatIdList.contains(varList.get(j).getSubCatId())) {

							tempSubCatIdList.add(varList.get(j).getSubCatId());

							SubCatWiseBillData bill = new SubCatWiseBillData();

							bill.setSubCatId(varList.get(j).getSubCatId());
							bill.setSubCatName(varList.get(j).getSubCatName());

							subCatBillList.add(bill);
						}

					}

				}

				for (int j = 0; j < retList.size(); j++) {

					if (frIds.get(i) == retList.get(j).getFrId()) {

						if (!tempSubCatIdList.contains(retList.get(j).getSubCatId())) {

							tempSubCatIdList.add(retList.get(j).getSubCatId());

							SubCatWiseBillData bill = new SubCatWiseBillData();

							bill.setSubCatId(retList.get(j).getSubCatId());
							bill.setSubCatName(retList.get(j).getSubCatName());

							subCatBillList.add(bill);
						}

					}

				}

				frWiseList.setSubCatList(subCatBillList);

				frWiseSubCatList.add(frWiseList);
			}

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			Calendar calFrom = Calendar.getInstance();
			Calendar calTo = Calendar.getInstance();

			Date d1 = sdf.parse(fromDate);
			Date d2 = sdf.parse(toDate);

			calFrom.setTime(d1);
			calTo.setTime(d2);

			while (calFrom.before(calTo)) {

				System.err.println(
						"--------------------------------------------NEW-----------------------------------------------");

				SimpleDateFormat sdfMonthYear = new SimpleDateFormat("MMM-yyyy");

				int month = calFrom.get(Calendar.MONTH) + 1;
				int year = calFrom.get(Calendar.YEAR);

				YearlyFrSubCatData data = new YearlyFrSubCatData();
				data.setMonthId(month);
				data.setYearId("" + year);
				data.setDateStr(sdfMonthYear.format(calFrom.getTime()));

				List<TempFrWiseSubCat> tempFrWiseSubCatList = new ArrayList<>();
				// tempFrWiseSubCatList.clear();
				// tempFrWiseSubCatList.addAll(frWiseSubCatList);

				if (frWiseSubCatList != null) {
					for (int i = 0; i < frWiseSubCatList.size(); i++) {
						TempFrWiseSubCat fr = new TempFrWiseSubCat();
						fr.setFrId(frWiseSubCatList.get(i).getFrId());
						fr.setFrName(frWiseSubCatList.get(i).getFrName());

						List<TempSubCatWiseBillData> tempScList = new ArrayList<>();
						if (frWiseSubCatList.get(i).getSubCatList() != null) {

							for (int j = 0; j < frWiseSubCatList.get(i).getSubCatList().size(); j++) {
								TempSubCatWiseBillData scData = new TempSubCatWiseBillData();
								scData.setSubCatId(frWiseSubCatList.get(i).getSubCatList().get(j).getSubCatId());
								scData.setSubCatName(frWiseSubCatList.get(i).getSubCatList().get(j).getSubCatName());
								tempScList.add(scData);
							}
						}
						fr.setSubCatList(tempScList);
						tempFrWiseSubCatList.add(fr);
					}
				}

				data.setDataList(tempFrWiseSubCatList);

				System.err.println("MONTH - " + month);
				System.err.println("NEW DATA - " + tempFrWiseSubCatList);

				// List<FrSubCatBillData> billList = new ArrayList<>();

				if (soldList != null) {
					for (int i = 0; i < soldList.size(); i++) {

						if (soldList.get(i).getMonth() == month
								&& soldList.get(i).getYear().equalsIgnoreCase(String.valueOf(year))) {

							System.err.println("---MATCHED ---------- " + soldList.get(i).getMonth() + " - "
									+ soldList.get(i).getYear());

							if (tempFrWiseSubCatList != null) {

								for (int j = 0; j < tempFrWiseSubCatList.size(); j++) {

									TempFrWiseSubCat frData = tempFrWiseSubCatList.get(j);

									if (frData.getFrId() == soldList.get(i).getFrId()) {

										System.err.println("---FR MATCHED ---------- " + soldList.get(i).getFrId());

										for (int k = 0; k < frData.getSubCatList().size(); k++) {

											TempSubCatWiseBillData billData = frData.getSubCatList().get(k);

											if (soldList.get(i).getSubCatId() == billData.getSubCatId()) {

												System.err.println("---SUB CAT MATCHED ---------- "
														+ soldList.get(i).getSubCatId());

												billData.setSoldQty(soldList.get(i).getSoldQty());
												billData.setSoldAmt(soldList.get(i).getSoldAmt());
												billData.setTaxableAmt(soldList.get(i).getTaxableAmt());
												billData.setTaxAmt(soldList.get(i).getTaxAmt());

												break;
											}
										}
									}

								}

							}

							// billList.add(bill);

						}

					}
				}

				if (varList != null) {
					for (int i = 0; i < varList.size(); i++) {

						if (varList.get(i).getMonth() == month
								&& varList.get(i).getYear().equalsIgnoreCase(String.valueOf(year))) {

							/*
							 * if (billList != null) {
							 * 
							 * boolean flag = false;
							 * 
							 * for (int j = 0; j < billList.size(); j++) {
							 * 
							 * if (billList.get(j).getSubCatId() == varList.get(i).getSubCatId() &&
							 * billList.get(j).getFrId() == varList.get(i).getFrId()) {
							 * 
							 * billList.get(j).setVarQty(varList.get(i).getQty());
							 * billList.get(j).setVarAmt(varList.get(i).getAmt());
							 * billList.get(j).setVarTaxableAmt(varList.get(i).getTaxableAmt());
							 * billList.get(j).setVarTaxAmt(varList.get(i).getTaxAmt());
							 * 
							 * flag = true;
							 * 
							 * break;
							 * 
							 * }
							 * 
							 * }
							 * 
							 * if (!flag) { FrSubCatBillData bill = new FrSubCatBillData();
							 * bill.setSubCatName(varList.get(i).getSubCatName());
							 * bill.setFrName(varList.get(i).getFrName());
							 * bill.setFrId(varList.get(i).getFrId());
							 * bill.setSubCatId(varList.get(i).getSubCatId()); bill.setSoldQty(0);
							 * bill.setSoldAmt(0); bill.setTaxableAmt(0); bill.setTaxAmt(0);
							 * bill.setVarQty(varList.get(i).getQty());
							 * bill.setVarAmt(varList.get(i).getAmt());
							 * bill.setVarTaxableAmt(varList.get(i).getTaxableAmt());
							 * bill.setVarTaxAmt(varList.get(i).getTaxAmt());
							 * 
							 * billList.add(bill); } }
							 */

							if (tempFrWiseSubCatList != null) {

								for (int j = 0; j < tempFrWiseSubCatList.size(); j++) {

									TempFrWiseSubCat frData = tempFrWiseSubCatList.get(j);

									if (frData.getFrId() == varList.get(i).getFrId()) {

										System.err.println("---FR MATCHED ---------- " + varList.get(i).getFrId());

										for (int k = 0; k < frData.getSubCatList().size(); k++) {

											TempSubCatWiseBillData billData = frData.getSubCatList().get(k);

											if (varList.get(i).getSubCatId() == billData.getSubCatId()) {

												System.err.println("---SUB CAT MATCHED ---------- "
														+ varList.get(i).getSubCatId());

												billData.setVarQty(varList.get(i).getQty());
												billData.setVarAmt(varList.get(i).getAmt());
												billData.setVarTaxableAmt(varList.get(i).getTaxableAmt());
												billData.setVarTaxAmt(varList.get(i).getTaxAmt());

												break;
											}
										}
									}

								}

							}

						}

					}
				}

				if (retList != null) {

					for (int i = 0; i < retList.size(); i++) {

						if (retList.get(i).getMonth() == month
								&& retList.get(i).getYear().equalsIgnoreCase(String.valueOf(year))) {

							/*
							 * for (int j = 0; j < billList.size(); j++) {
							 * 
							 * if (billList.get(j).getSubCatId() == retList.get(i).getSubCatId() &&
							 * billList.get(j).getFrId() == retList.get(i).getFrId()) {
							 * 
							 * billList.get(j).setRetQty(retList.get(i).getQty());
							 * billList.get(j).setRetAmt(retList.get(i).getAmt());
							 * billList.get(j).setRetTaxableAmt(retList.get(i).getTaxableAmt());
							 * billList.get(j).setRetTaxAmt(retList.get(i).getTaxAmt());
							 * 
							 * flag1 = true;
							 * 
							 * break;
							 * 
							 * }
							 * 
							 * }
							 * 
							 * if (!flag1) { FrSubCatBillData bill = new FrSubCatBillData();
							 * bill.setSubCatName(retList.get(i).getSubCatName());
							 * bill.setFrName(retList.get(i).getFrName());
							 * bill.setFrId(retList.get(i).getFrId());
							 * bill.setSubCatId(retList.get(i).getSubCatId()); bill.setSoldQty(0);
							 * bill.setSoldAmt(0); bill.setTaxableAmt(0); bill.setTaxAmt(0);
							 * bill.setVarQty(0); bill.setVarAmt(0); bill.setVarTaxableAmt(0);
							 * bill.setVarTaxAmt(0); bill.setRetQty(retList.get(i).getQty());
							 * bill.setRetAmt(retList.get(i).getAmt());
							 * bill.setRetTaxableAmt(retList.get(i).getTaxableAmt());
							 * bill.setRetTaxAmt(retList.get(i).getTaxAmt());
							 * 
							 * billList.add(bill); }
							 */

							if (tempFrWiseSubCatList != null) {

								for (int j = 0; j < tempFrWiseSubCatList.size(); j++) {

									TempFrWiseSubCat frData = tempFrWiseSubCatList.get(j);

									if (frData.getFrId() == retList.get(i).getFrId()) {

										System.err.println("---FR MATCHED ---------- " + retList.get(i).getFrId());

										for (int k = 0; k < frData.getSubCatList().size(); k++) {

											TempSubCatWiseBillData billData = frData.getSubCatList().get(k);

											if (retList.get(i).getSubCatId() == billData.getSubCatId()) {

												System.err.println("---SUB CAT MATCHED ---------- "
														+ retList.get(i).getSubCatId());

												billData.setRetQty(retList.get(i).getQty());
												billData.setRetAmt(retList.get(i).getAmt());
												billData.setRetTaxableAmt(retList.get(i).getTaxableAmt());
												billData.setRetTaxAmt(retList.get(i).getTaxAmt());

												break;
											}
										}
									}

								}

							}

						}

					}
				}

				// data.setDataList(billList);

				// data.setDataList(tempFrWiseSubCatList);

				reportList.add(data);

				calFrom.add(Calendar.MONTH, 1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return reportList;
	}

	// ----------------------------SELL REPORT YEARLY SUB CAT
	// WISE------------------------------

	@RequestMapping(value = { "/getFrSubCatSellYearlyReport" }, method = RequestMethod.POST)
	public @ResponseBody List<YearlyFrSubCatData> getFrSubCatSellYearlyReport(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("subCatIdList") List<Integer> subCatIdList,
			@RequestParam("frIdList") List<Integer> frIdList) {

		System.err.println("PARAMETER ---------------- FROM DATE : " + fromDate + "        TO DATE : " + toDate
				+ "     SC : " + subCatIdList + "          FR : " + frIdList);

		List<YearlyFrSubCatData> reportList = new ArrayList<>();
		List<FrWiseSubCat> frWiseSubCatList = new ArrayList<>();

		try {

			List<FrSubCatWiseSellData> soldList = frSubCatWiseSellDataRepo.getSellBillData(fromDate, toDate, frIdList,
					subCatIdList);

			System.err.println("SOLD -- " + soldList);

			ArrayList<Integer> frIds = new ArrayList<>();
			ArrayList<String> frNames = new ArrayList<>();

			if (soldList != null) {
				for (int i = 0; i < soldList.size(); i++) {
					if (!frIds.contains(soldList.get(i).getFrId())) {
						frIds.add(soldList.get(i).getFrId());
						frNames.add(soldList.get(i).getFrName());
					}
				}
			}

			System.err.println("FR IDS ----------------------------------- " + frIds);
			System.err.println("FR NAMES ----------------------------------- " + frNames);

			for (int i = 0; i < frIds.size(); i++) {

				FrWiseSubCat frWiseList = new FrWiseSubCat();

				frWiseList.setFrId(frIds.get(i));
				frWiseList.setFrName(frNames.get(i));

				ArrayList<SubCatWiseBillData> subCatBillList = new ArrayList<>();
				ArrayList<Integer> tempSubCatIdList = new ArrayList<>();

				for (int j = 0; j < soldList.size(); j++) {

					if (frIds.get(i) == soldList.get(j).getFrId()) {

						if (!tempSubCatIdList.contains(soldList.get(j).getSubCatId())) {

							tempSubCatIdList.add(soldList.get(j).getSubCatId());

							SubCatWiseBillData bill = new SubCatWiseBillData();

							bill.setSubCatId(soldList.get(j).getSubCatId());
							bill.setSubCatName(soldList.get(j).getSubCatName());

							subCatBillList.add(bill);
						}

					}

				}

				frWiseList.setSubCatList(subCatBillList);

				frWiseSubCatList.add(frWiseList);
			}

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			Calendar calFrom = Calendar.getInstance();
			Calendar calTo = Calendar.getInstance();

			Date d1 = sdf.parse(fromDate);
			Date d2 = sdf.parse(toDate);

			calFrom.setTime(d1);
			calTo.setTime(d2);

			while (calFrom.before(calTo)) {

				System.err.println(
						"--------------------------------------------NEW-----------------------------------------------");

				SimpleDateFormat sdfMonthYear = new SimpleDateFormat("MMM-yyyy");

				int month = calFrom.get(Calendar.MONTH) + 1;
				int year = calFrom.get(Calendar.YEAR);

				YearlyFrSubCatData data = new YearlyFrSubCatData();
				data.setMonthId(month);
				data.setYearId("" + year);
				data.setDateStr(sdfMonthYear.format(calFrom.getTime()));

				List<TempFrWiseSubCat> tempFrWiseSubCatList = new ArrayList<>();
				// tempFrWiseSubCatList.clear();
				// tempFrWiseSubCatList.addAll(frWiseSubCatList);

				if (frWiseSubCatList != null) {
					for (int i = 0; i < frWiseSubCatList.size(); i++) {
						TempFrWiseSubCat fr = new TempFrWiseSubCat();
						fr.setFrId(frWiseSubCatList.get(i).getFrId());
						fr.setFrName(frWiseSubCatList.get(i).getFrName());

						List<TempSubCatWiseBillData> tempScList = new ArrayList<>();
						if (frWiseSubCatList.get(i).getSubCatList() != null) {

							for (int j = 0; j < frWiseSubCatList.get(i).getSubCatList().size(); j++) {
								TempSubCatWiseBillData scData = new TempSubCatWiseBillData();
								scData.setSubCatId(frWiseSubCatList.get(i).getSubCatList().get(j).getSubCatId());
								scData.setSubCatName(frWiseSubCatList.get(i).getSubCatList().get(j).getSubCatName());
								tempScList.add(scData);
							}
						}
						fr.setSubCatList(tempScList);
						tempFrWiseSubCatList.add(fr);
					}
				}

				data.setDataList(tempFrWiseSubCatList);

				System.err.println("MONTH - " + month);
				System.err.println("NEW DATA - " + tempFrWiseSubCatList);

				// List<FrSubCatBillData> billList = new ArrayList<>();

				if (soldList != null) {
					for (int i = 0; i < soldList.size(); i++) {

						if (soldList.get(i).getMonth() == month
								&& soldList.get(i).getYear().equalsIgnoreCase(String.valueOf(year))) {

							System.err.println("---MATCHED ---------- " + soldList.get(i).getMonth() + " - "
									+ soldList.get(i).getYear());

							if (tempFrWiseSubCatList != null) {

								for (int j = 0; j < tempFrWiseSubCatList.size(); j++) {

									TempFrWiseSubCat frData = tempFrWiseSubCatList.get(j);

									if (frData.getFrId() == soldList.get(i).getFrId()) {

										System.err.println("---FR MATCHED ---------- " + soldList.get(i).getFrId());

										for (int k = 0; k < frData.getSubCatList().size(); k++) {

											TempSubCatWiseBillData billData = frData.getSubCatList().get(k);

											if (soldList.get(i).getSubCatId() == billData.getSubCatId()) {

												System.err.println("---SUB CAT MATCHED ---------- "
														+ soldList.get(i).getSubCatId());

												billData.setSoldQty(soldList.get(i).getSoldQty());
												billData.setSoldAmt(soldList.get(i).getSoldAmt());

												break;
											}
										}
									}

								}

							}

						}

					}
				}

				reportList.add(data);

				calFrom.add(Calendar.MONTH, 1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return reportList;
	}

	// ---------------------OPS ITEM WISE YEARLY
	// REPORT-------------------------------

	@RequestMapping(value = { "/getOpsItemwiseYearlyPurchaseReport" }, method = RequestMethod.POST)
	public @ResponseBody List<FrItemWiseYearlyData> getOpsItemwiseYearlyPurchaseReport(
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,
			@RequestParam("catIdList") List<Integer> catIdList, @RequestParam("frId") int frId) {

		System.err.println("PARAMETER ---------------- FROM DATE : " + fromDate + "        TO DATE : " + toDate
				+ "     CAT : " + catIdList + "          FRID : " + frId);

		List<FrItemWiseYearlyData> reportList = new ArrayList<>();
		List<SubCatWiseItems> frWiseSubCatList = new ArrayList<>();

		try {

			List<FrItemwiseData> soldList = frItemWiseSoldDataRepo.getItemwiseBillData(fromDate, toDate, catIdList,
					frId);
			List<FrItemwiseVarAndRetData> varList = frItemWiseGrnGvnRepo.getVariation(fromDate, toDate, catIdList,
					frId);
			List<FrItemwiseVarAndRetData> retList = frItemWiseGrnGvnRepo.getReturn(fromDate, toDate, catIdList, frId);

			System.err.println("SOLD -- " + soldList);
			System.err.println("VAR -- " + varList);
			System.err.println("RET -- " + retList);

			ArrayList<Integer> subCatIds = new ArrayList<>();
			ArrayList<String> subCatNames = new ArrayList<>();

			if (soldList != null) {
				for (int i = 0; i < soldList.size(); i++) {
					if (!subCatIds.contains(soldList.get(i).getSubCatId())) {
						subCatIds.add(soldList.get(i).getSubCatId());
						subCatNames.add(soldList.get(i).getSubCatName());
					}
				}
			}

			if (varList != null) {
				for (int i = 0; i < varList.size(); i++) {
					if (!subCatIds.contains(varList.get(i).getSubCatId())) {
						subCatIds.add(varList.get(i).getSubCatId());
						subCatNames.add(varList.get(i).getSubCatName());
					}
				}
			}

			if (retList != null) {
				for (int i = 0; i < retList.size(); i++) {
					if (!subCatIds.contains(retList.get(i).getSubCatId())) {
						subCatIds.add(retList.get(i).getSubCatId());
						subCatNames.add(retList.get(i).getSubCatName());
					}
				}
			}

			System.err.println("SUB CAT IDS ----------------------------------- " + subCatIds);
			System.err.println("SUB CAT NAMES ----------------------------------- " + subCatNames);

			for (int i = 0; i < subCatIds.size(); i++) {

				SubCatWiseItems subCatWiseItemList = new SubCatWiseItems();

				subCatWiseItemList.setSubCatId(subCatIds.get(i));
				subCatWiseItemList.setSubCatName(subCatNames.get(i));

				ArrayList<ItemList> itemList = new ArrayList<>();
				ArrayList<Integer> tempItemIdList = new ArrayList<>();

				for (int j = 0; j < soldList.size(); j++) {

					if (subCatIds.get(i) == soldList.get(j).getSubCatId()) {

						if (!tempItemIdList.contains(soldList.get(j).getItemId())) {

							tempItemIdList.add(soldList.get(j).getItemId());

							ItemList bill = new ItemList();

							bill.setItemId(soldList.get(j).getItemId());
							bill.setItemName(soldList.get(j).getItemName());

							itemList.add(bill);
						}

					}

				}

				for (int j = 0; j < varList.size(); j++) {

					if (subCatIds.get(i) == varList.get(j).getSubCatId()) {

						if (!tempItemIdList.contains(varList.get(j).getItemId())) {

							tempItemIdList.add(varList.get(j).getItemId());

							ItemList bill = new ItemList();

							bill.setItemId(varList.get(j).getItemId());
							bill.setItemName(varList.get(j).getItemName());

							itemList.add(bill);
						}

					}

				}

				for (int j = 0; j < retList.size(); j++) {

					if (subCatIds.get(i) == retList.get(j).getFrId()) {

						if (!tempItemIdList.contains(retList.get(j).getSubCatId())) {

							tempItemIdList.add(retList.get(j).getSubCatId());

							ItemList bill = new ItemList();

							bill.setItemId(retList.get(j).getItemId());
							bill.setItemName(retList.get(j).getItemName());

							itemList.add(bill);
						}

					}

				}

				subCatWiseItemList.setItemList(itemList);

				frWiseSubCatList.add(subCatWiseItemList);
			}

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			Calendar calFrom = Calendar.getInstance();
			Calendar calTo = Calendar.getInstance();

			Date d1 = sdf.parse(fromDate);
			Date d2 = sdf.parse(toDate);

			calFrom.setTime(d1);
			calTo.setTime(d2);

			while (calFrom.before(calTo)) {

				System.err.println(
						"--------------------------------------------NEW-----------------------------------------------");

				SimpleDateFormat sdfMonthYear = new SimpleDateFormat("MMM-yyyy");

				int month = calFrom.get(Calendar.MONTH) + 1;
				int year = calFrom.get(Calendar.YEAR);

				FrItemWiseYearlyData data = new FrItemWiseYearlyData();
				data.setMonthId(month);
				data.setYearId("" + year);
				data.setDateStr(sdfMonthYear.format(calFrom.getTime()));

				List<TempSubCatWiseItems> tempFrWiseSubCatList = new ArrayList<>();
				// tempFrWiseSubCatList.clear();
				// tempFrWiseSubCatList.addAll(frWiseSubCatList);

				if (frWiseSubCatList != null) {
					for (int i = 0; i < frWiseSubCatList.size(); i++) {
						TempSubCatWiseItems sc = new TempSubCatWiseItems();
						sc.setSubCatId(frWiseSubCatList.get(i).getSubCatId());
						sc.setSubCatName(frWiseSubCatList.get(i).getSubCatName());

						List<TempItemList> tempItemList = new ArrayList<>();
						if (frWiseSubCatList.get(i).getItemList() != null) {

							for (int j = 0; j < frWiseSubCatList.get(i).getItemList().size(); j++) {
								TempItemList scData = new TempItemList();
								scData.setItemId(frWiseSubCatList.get(i).getItemList().get(j).getItemId());
								scData.setItemName(frWiseSubCatList.get(i).getItemList().get(j).getItemName());
								tempItemList.add(scData);
							}
						}
						sc.setItemList(tempItemList);
						tempFrWiseSubCatList.add(sc);
					}
				}

				data.setDataList(tempFrWiseSubCatList);

				System.err.println("MONTH - " + month);
				System.err.println("NEW DATA - " + tempFrWiseSubCatList);

				// List<FrSubCatBillData> billList = new ArrayList<>();

				if (soldList != null) {
					for (int i = 0; i < soldList.size(); i++) {

						System.err.println("*************************** SOLD LIST MONTH : " + soldList.get(i).getMonth()
								+ "    ------   MONTH : " + month);
						System.err.println("*************************** SOLD LIST YEAR : " + soldList.get(i).getYear()
								+ "    ------   YEAR : " + year);

						if (soldList.get(i).getMonth() == month
								&& soldList.get(i).getYear().equalsIgnoreCase(String.valueOf(year))) {

							System.err.println("---MATCHED ---------- " + soldList.get(i).getMonth() + " - "
									+ soldList.get(i).getYear());

							if (tempFrWiseSubCatList != null) {

								for (int j = 0; j < tempFrWiseSubCatList.size(); j++) {

									TempSubCatWiseItems scData = tempFrWiseSubCatList.get(j);

									if (scData.getSubCatId() == soldList.get(i).getSubCatId()) {

										System.err.println("---SC MATCHED ---------- " + soldList.get(i).getSubCatId());

										for (int k = 0; k < scData.getItemList().size(); k++) {

											TempItemList billData = scData.getItemList().get(k);

											if (soldList.get(i).getItemId() == billData.getItemId()) {

												System.err.println(
														"---ITEM MATCHED ---------- " + soldList.get(i).getItemId());

												billData.setSoldQty(soldList.get(i).getSoldQty());
												billData.setSoldAmt(soldList.get(i).getSoldAmt());
												billData.setTaxableAmt(soldList.get(i).getTaxableAmt());
												billData.setTaxAmt(soldList.get(i).getTaxAmt());

												break;
											}
										}
									}

								}

							}

							// billList.add(bill);

						}

					}
				}

				if (varList != null) {
					for (int i = 0; i < varList.size(); i++) {

						if (varList.get(i).getMonth() == month
								&& varList.get(i).getYear().equalsIgnoreCase(String.valueOf(year))) {

							if (tempFrWiseSubCatList != null) {

								for (int j = 0; j < tempFrWiseSubCatList.size(); j++) {

									TempSubCatWiseItems scData = tempFrWiseSubCatList.get(j);

									if (scData.getSubCatId() == varList.get(i).getSubCatId()) {

										System.err.println("---SC MATCHED ---------- " + varList.get(i).getFrId());

										for (int k = 0; k < scData.getItemList().size(); k++) {

											TempItemList billData = scData.getItemList().get(k);

											if (varList.get(i).getItemId() == billData.getItemId()) {

												System.err.println(
														"---ITEM MATCHED ---------- " + varList.get(i).getItemId());

												billData.setVarQty(varList.get(i).getQty());
												billData.setVarAmt(varList.get(i).getAmt());
												billData.setVarTaxableAmt(varList.get(i).getTaxableAmt());
												billData.setVarTaxAmt(varList.get(i).getTaxAmt());

												break;
											}
										}
									}

								}

							}

						}

					}
				}

				if (retList != null) {

					for (int i = 0; i < retList.size(); i++) {

						if (retList.get(i).getMonth() == month
								&& retList.get(i).getYear().equalsIgnoreCase(String.valueOf(year))) {

							if (tempFrWiseSubCatList != null) {

								for (int j = 0; j < tempFrWiseSubCatList.size(); j++) {

									TempSubCatWiseItems scData = tempFrWiseSubCatList.get(j);

									if (scData.getSubCatId() == retList.get(i).getSubCatId()) {

										System.err.println("---SC MATCHED ---------- " + retList.get(i).getFrId());

										for (int k = 0; k < scData.getItemList().size(); k++) {

											TempItemList billData = scData.getItemList().get(k);

											if (retList.get(i).getItemId() == billData.getItemId()) {

												System.err.println(
														"---ITEM MATCHED ---------- " + retList.get(i).getItemId());

												billData.setRetQty(retList.get(i).getQty());
												billData.setRetAmt(retList.get(i).getAmt());
												billData.setRetTaxableAmt(retList.get(i).getTaxableAmt());
												billData.setRetTaxAmt(retList.get(i).getTaxAmt());

												break;
											}
										}
									}

								}

							}

						}

					}
				}

				// data.setDataList(billList);

				// data.setDataList(tempFrWiseSubCatList);

				reportList.add(data);

				calFrom.add(Calendar.MONTH, 1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return reportList;
	}

	// ---------------------OPS ITEM WISE SELL YEARLY
	// REPORT-------------------------------

	@RequestMapping(value = { "/getOpsItemwiseYearlySellReport" }, method = RequestMethod.POST)
	public @ResponseBody List<FrItemWiseYearlyData> getOpsItemwiseYearlySellReport(
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,
			@RequestParam("catIdList") List<Integer> catIdList, @RequestParam("frId") int frId) {

		System.err.println("PARAMETER ---------------- FROM DATE : " + fromDate + "        TO DATE : " + toDate
				+ "     CAT : " + catIdList + "          FRID : " + frId);

		List<FrItemWiseYearlyData> reportList = new ArrayList<>();
		List<SubCatWiseItems> frWiseSubCatList = new ArrayList<>();

		try {

			List<FrItemWiseSellData> soldList = frItemWiseSellDataRepo.getItemwiseSellBillData(fromDate, toDate,
					catIdList, frId);

			System.err.println("SOLD -- " + soldList);

			ArrayList<Integer> subCatIds = new ArrayList<>();
			ArrayList<String> subCatNames = new ArrayList<>();

			if (soldList != null) {
				for (int i = 0; i < soldList.size(); i++) {
					if (!subCatIds.contains(soldList.get(i).getSubCatId())) {
						subCatIds.add(soldList.get(i).getSubCatId());
						subCatNames.add(soldList.get(i).getSubCatName());
					}
				}
			}

			System.err.println("SUB CAT IDS ----------------------------------- " + subCatIds);
			System.err.println("SUB CAT NAMES ----------------------------------- " + subCatNames);

			for (int i = 0; i < subCatIds.size(); i++) {

				SubCatWiseItems subCatWiseItemList = new SubCatWiseItems();

				subCatWiseItemList.setSubCatId(subCatIds.get(i));
				subCatWiseItemList.setSubCatName(subCatNames.get(i));

				ArrayList<ItemList> itemList = new ArrayList<>();
				ArrayList<Integer> tempItemIdList = new ArrayList<>();

				for (int j = 0; j < soldList.size(); j++) {

					if (subCatIds.get(i) == soldList.get(j).getSubCatId()) {

						if (!tempItemIdList.contains(soldList.get(j).getItemId())) {

							tempItemIdList.add(soldList.get(j).getItemId());

							ItemList bill = new ItemList();

							bill.setItemId(soldList.get(j).getItemId());
							bill.setItemName(soldList.get(j).getItemName());

							itemList.add(bill);
						}

					}

				}

				subCatWiseItemList.setItemList(itemList);

				frWiseSubCatList.add(subCatWiseItemList);
			}

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			Calendar calFrom = Calendar.getInstance();
			Calendar calTo = Calendar.getInstance();

			Date d1 = sdf.parse(fromDate);
			Date d2 = sdf.parse(toDate);

			calFrom.setTime(d1);
			calTo.setTime(d2);

			while (calFrom.before(calTo)) {

				System.err.println(
						"--------------------------------------------NEW-----------------------------------------------");

				SimpleDateFormat sdfMonthYear = new SimpleDateFormat("MMM-yyyy");

				int month = calFrom.get(Calendar.MONTH) + 1;
				int year = calFrom.get(Calendar.YEAR);

				FrItemWiseYearlyData data = new FrItemWiseYearlyData();
				data.setMonthId(month);
				data.setYearId("" + year);
				data.setDateStr(sdfMonthYear.format(calFrom.getTime()));

				List<TempSubCatWiseItems> tempFrWiseSubCatList = new ArrayList<>();
				// tempFrWiseSubCatList.clear();
				// tempFrWiseSubCatList.addAll(frWiseSubCatList);

				if (frWiseSubCatList != null) {
					for (int i = 0; i < frWiseSubCatList.size(); i++) {
						TempSubCatWiseItems sc = new TempSubCatWiseItems();
						sc.setSubCatId(frWiseSubCatList.get(i).getSubCatId());
						sc.setSubCatName(frWiseSubCatList.get(i).getSubCatName());

						List<TempItemList> tempItemList = new ArrayList<>();
						if (frWiseSubCatList.get(i).getItemList() != null) {

							for (int j = 0; j < frWiseSubCatList.get(i).getItemList().size(); j++) {
								TempItemList scData = new TempItemList();
								scData.setItemId(frWiseSubCatList.get(i).getItemList().get(j).getItemId());
								scData.setItemName(frWiseSubCatList.get(i).getItemList().get(j).getItemName());
								tempItemList.add(scData);
							}
						}
						sc.setItemList(tempItemList);
						tempFrWiseSubCatList.add(sc);
					}
				}

				data.setDataList(tempFrWiseSubCatList);

				System.err.println("MONTH - " + month);
				System.err.println("NEW DATA - " + tempFrWiseSubCatList);

				// List<FrSubCatBillData> billList = new ArrayList<>();

				if (soldList != null) {
					for (int i = 0; i < soldList.size(); i++) {

						if (soldList.get(i).getMonth() == month
								&& soldList.get(i).getYear().equalsIgnoreCase(String.valueOf(year))) {

							System.err.println("---MATCHED ---------- " + soldList.get(i).getMonth() + " - "
									+ soldList.get(i).getYear());

							if (tempFrWiseSubCatList != null) {

								for (int j = 0; j < tempFrWiseSubCatList.size(); j++) {

									TempSubCatWiseItems scData = tempFrWiseSubCatList.get(j);

									if (scData.getSubCatId() == soldList.get(i).getSubCatId()) {

										System.err.println("---SC MATCHED ---------- " + soldList.get(i).getSubCatId());

										for (int k = 0; k < scData.getItemList().size(); k++) {

											TempItemList billData = scData.getItemList().get(k);

											if (soldList.get(i).getItemId() == billData.getItemId()) {

												System.err.println(
														"---ITEM MATCHED ---------- " + soldList.get(i).getItemId());

												billData.setSoldQty(soldList.get(i).getSoldQty());
												billData.setSoldAmt(soldList.get(i).getSoldAmt());

												break;
											}
										}
									}

								}

							}

						}

					}
				}

				reportList.add(data);

				calFrom.add(Calendar.MONTH, 1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return reportList;
	}

	// --------SUBCAT DATE WISE SELL REPORT----------------------------

	@RequestMapping(value = { "/getSubCatDateWiseSellReport" }, method = RequestMethod.POST)
	public @ResponseBody List<SubCatDateWiseData> getSubCatDateWiseSellReport(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("catIdList") List<Integer> catIdList,
			@RequestParam("frId") int frId) {

		System.err.println("PARAMETER ---------------- FROM DATE : " + fromDate + "        TO DATE : " + toDate
				+ "     CAT : " + catIdList + "          FR : " + frId);

		List<SubCatDateWiseData> reportList = new ArrayList<>();

		try {

			if (catIdList.get(0) == 5) {

				reportList = subCatDateWiseDataRepo.getSellBillDataspcake(fromDate, toDate, frId, catIdList);
				
			} else {
				reportList = subCatDateWiseDataRepo.getSellBillData(fromDate, toDate, frId, catIdList);
			}

			System.err.println("SOLD -- " + reportList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return reportList;
	}

	// --------HSN DATE WISE SELL REPORT----------------------------

	@RequestMapping(value = { "/getHsnDateWiseSellReport" }, method = RequestMethod.POST)
	public @ResponseBody List<HsnDateWiseSellReport> getHsnDateWiseSellReport(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("frId") int frId) {

		System.err.println("PARAMETER ---------------- FROM DATE : " + fromDate + "        TO DATE : " + toDate
				+ "          FR : " + frId);

		List<HsnDateWiseSellReport> reportList = new ArrayList<>();

		try {

			reportList = hsnDateWiseSellReportRepo.getSellBillData(fromDate, toDate, frId);
			System.err.println("SOLD -- " + reportList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return reportList;
	}

}
