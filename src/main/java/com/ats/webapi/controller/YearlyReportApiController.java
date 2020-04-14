package com.ats.webapi.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.yearlyreport.FrList;
import com.ats.webapi.model.yearlyreport.GrnGvnData;
import com.ats.webapi.model.yearlyreport.ItemList;
import com.ats.webapi.model.yearlyreport.SoldData;
import com.ats.webapi.model.yearlyreport.SubCatList;
import com.ats.webapi.model.yearlyreport.TempFrList;
import com.ats.webapi.model.yearlyreport.TempItemList;
import com.ats.webapi.model.yearlyreport.TempSubCatList;
import com.ats.webapi.model.yearlyreport.YearlyReport;
import com.ats.webapi.repo.yearlyreport.GrnGvnDataRepo;
import com.ats.webapi.repo.yearlyreport.SoldDataRepo;

@RestController
public class YearlyReportApiController {

	@Autowired
	SoldDataRepo soldDataRepo;

	@Autowired
	GrnGvnDataRepo grnGvnDataRepo;

	// ----------YEARLY REPORT--------------

	@RequestMapping(value = { "/getYearlyFrSubCatItemSaleReport" }, method = RequestMethod.POST)
	public @ResponseBody List<YearlyReport> getYearlyFrSubCatSaleReport(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("catIdList") List<Integer> catIdList,
			@RequestParam("frIdList") List<Integer> frIdList) {

		System.err.println("PARAMETER ---------------- FROM DATE : " + fromDate + "        TO DATE : " + toDate
				+ "     CAT : " + catIdList + "          FR : " + frIdList);

		List<YearlyReport> reportList = new ArrayList<>();
		List<FrList> frList = new ArrayList<>();

		try {

			List<SoldData> soldList = soldDataRepo.getBillData(fromDate, toDate, frIdList, catIdList);
			List<GrnGvnData> varList = grnGvnDataRepo.getVariationData(fromDate, toDate, frIdList, catIdList);
			List<GrnGvnData> retList = grnGvnDataRepo.getReturnData(fromDate, toDate, frIdList, catIdList);

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

				FrList frWiseList = new FrList();

				frWiseList.setFrId(frIds.get(i));
				frWiseList.setFrName(frNames.get(i));

				ArrayList<SubCatList> subCatBillList = new ArrayList<>();
				ArrayList<Integer> tempSubCatIdList = new ArrayList<>();

				for (int j = 0; j < soldList.size(); j++) {

					// if (frIds.get(i) == soldList.get(j).getFrId()) {

					if (!tempSubCatIdList.contains(soldList.get(j).getSubCatId())) {

						tempSubCatIdList.add(soldList.get(j).getSubCatId());

						SubCatList bill = new SubCatList();

						bill.setSubCatId(soldList.get(j).getSubCatId());
						bill.setSubCatName(soldList.get(j).getSubCatName());

						ArrayList<ItemList> itemBillList = new ArrayList<>();
						ArrayList<Integer> tempItemIdList = new ArrayList<>();

						for (int k = 0; k < soldList.size(); k++) {

							if (bill.getSubCatId() == soldList.get(k).getSubCatId()) {

								if (!tempItemIdList.contains(soldList.get(k).getItemId())) {

									tempItemIdList.add(soldList.get(k).getItemId());

									ItemList billItem = new ItemList();

									billItem.setItemId(soldList.get(k).getItemId());
									billItem.setItemName(soldList.get(k).getItemName());

									itemBillList.add(billItem);
									// break;

								}
							}

						}

						bill.setItemList(itemBillList);
						subCatBillList.add(bill);
						// break;
					}

					// }

				}

				for (int j = 0; j < varList.size(); j++) {

					if (frIds.get(i) == varList.get(j).getFrId()) {

						if (!tempSubCatIdList.contains(varList.get(j).getSubCatId())) {

							tempSubCatIdList.add(varList.get(j).getSubCatId());

							SubCatList bill = new SubCatList();

							bill.setSubCatId(varList.get(j).getSubCatId());
							bill.setSubCatName(varList.get(j).getSubCatName());

							ArrayList<ItemList> itemBillList = new ArrayList<>();
							ArrayList<Integer> tempItemIdList = new ArrayList<>();

							for (int k = 0; k < soldList.size(); k++) {

								if (bill.getSubCatId() == soldList.get(k).getSubCatId()) {

									if (!tempItemIdList.contains(soldList.get(k).getItemId())) {

										tempItemIdList.add(soldList.get(k).getItemId());

										ItemList billItem = new ItemList();

										billItem.setItemId(soldList.get(k).getItemId());
										billItem.setItemName(soldList.get(k).getItemName());

										itemBillList.add(billItem);
										// break;

									}
								}

							}

							bill.setItemList(itemBillList);

							subCatBillList.add(bill);
						}

					}

				}

				for (int j = 0; j < retList.size(); j++) {

					if (frIds.get(i) == retList.get(j).getFrId()) {

						if (!tempSubCatIdList.contains(retList.get(j).getSubCatId())) {

							tempSubCatIdList.add(retList.get(j).getSubCatId());

							SubCatList bill = new SubCatList();

							bill.setSubCatId(retList.get(j).getSubCatId());
							bill.setSubCatName(retList.get(j).getSubCatName());

							ArrayList<ItemList> itemBillList = new ArrayList<>();
							ArrayList<Integer> tempItemIdList = new ArrayList<>();

							for (int k = 0; k < soldList.size(); k++) {

								if (bill.getSubCatId() == soldList.get(k).getSubCatId()) {

									if (!tempItemIdList.contains(soldList.get(k).getItemId())) {

										tempItemIdList.add(soldList.get(k).getItemId());

										ItemList billItem = new ItemList();

										billItem.setItemId(soldList.get(k).getItemId());
										billItem.setItemName(soldList.get(k).getItemName());

										itemBillList.add(billItem);
										// break;

									}
								}

							}

							bill.setItemList(itemBillList);

							subCatBillList.add(bill);
						}
					}

				}

				frWiseList.setSubCatList(subCatBillList);

				frList.add(frWiseList);
			}

			System.err.println("FR LIST --------------------- " + frList);

			/*
			 * for (int i = 0; i < frIds.size(); i++) {
			 * 
			 * FrList frWiseList = new FrList();
			 * 
			 * frWiseList.setFrId(frIds.get(i)); frWiseList.setFrName(frNames.get(i));
			 * 
			 * ArrayList<SubCatList> subCatBillList = new ArrayList<>(); ArrayList<Integer>
			 * tempSubCatIdList = new ArrayList<>();
			 * 
			 * for (int j = 0; j < soldList.size(); j++) {
			 * 
			 * // if (frIds.get(i) == soldList.get(j).getFrId()) {
			 * 
			 * if (!tempSubCatIdList.contains(soldList.get(j).getSubCatId())) {
			 * 
			 * tempSubCatIdList.add(soldList.get(j).getSubCatId());
			 * 
			 * SubCatList bill = new SubCatList();
			 * 
			 * bill.setSubCatId(soldList.get(j).getSubCatId());
			 * bill.setSubCatName(soldList.get(j).getSubCatName());
			 * 
			 * subCatBillList.add(bill); }
			 * 
			 * // }
			 * 
			 * }
			 * 
			 * for (int j = 0; j < varList.size(); j++) {
			 * 
			 * if (frIds.get(i) == varList.get(j).getFrId()) {
			 * 
			 * if (!tempSubCatIdList.contains(varList.get(j).getSubCatId())) {
			 * 
			 * tempSubCatIdList.add(varList.get(j).getSubCatId());
			 * 
			 * SubCatList bill = new SubCatList();
			 * 
			 * bill.setSubCatId(varList.get(j).getSubCatId());
			 * bill.setSubCatName(varList.get(j).getSubCatName());
			 * 
			 * subCatBillList.add(bill); }
			 * 
			 * }
			 * 
			 * }
			 * 
			 * for (int j = 0; j < retList.size(); j++) {
			 * 
			 * if (frIds.get(i) == retList.get(j).getFrId()) {
			 * 
			 * if (!tempSubCatIdList.contains(retList.get(j).getSubCatId())) {
			 * 
			 * tempSubCatIdList.add(retList.get(j).getSubCatId());
			 * 
			 * SubCatList bill = new SubCatList();
			 * 
			 * bill.setSubCatId(retList.get(j).getSubCatId());
			 * bill.setSubCatName(retList.get(j).getSubCatName());
			 * 
			 * subCatBillList.add(bill); } }
			 * 
			 * }
			 * 
			 * frWiseList.setSubCatList(subCatBillList);
			 * 
			 * frList.add(frWiseList); }
			 */

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

				YearlyReport data = new YearlyReport();
				data.setMonthId(month);
				data.setYearId("" + year);
				data.setDateStr(sdfMonthYear.format(calFrom.getTime()));

				List<TempFrList> tempFrList = new ArrayList<>();

				/*
				 * if (frList != null) { for (int i = 0; i < frList.size(); i++) { TempFrList fr
				 * = new TempFrList(); fr.setFrId(frList.get(i).getFrId());
				 * fr.setFrName(frList.get(i).getFrName());
				 * 
				 * List<TempSubCatList> tempScList = new ArrayList<>(); if
				 * (frList.get(i).getSubCatList() != null) {
				 * 
				 * for (int j = 0; j < frList.get(i).getSubCatList().size(); j++) {
				 * TempSubCatList scData = new TempSubCatList();
				 * scData.setSubCatId(frList.get(i).getSubCatList().get(j).getSubCatId());
				 * scData.setSubCatName(frList.get(i).getSubCatList().get(j).getSubCatName());
				 * 
				 * List<TempItemList> tempItemList = new ArrayList<>(); if
				 * (frList.get(i).getSubCatList().get(j).getItemList() != null) {
				 * 
				 * for (int k = 0; k < frList.get(i).getSubCatList().get(j).getItemList()
				 * .size(); k++) {
				 * 
				 * TempItemList itemData = new TempItemList(); itemData.setItemId(
				 * frList.get(i).getSubCatList().get(j).getItemList().get(k).getItemId());
				 * itemData.setItemName(frList.get(i).getSubCatList().get(j).getItemList().get(
				 * k) .getItemName());
				 * 
				 * tempItemList.add(itemData); } }
				 * 
				 * scData.setTempItemList(tempItemList); tempScList.add(scData); } }
				 * fr.setTempSubCatList(tempScList); tempFrList.add(fr); } }
				 * 
				 * data.setFrList(tempFrList);
				 */

				System.err.println("MONTH - " + month);
				System.err.println("NEW DATA - " + tempFrList);

				if (frList != null) {
					for (int i = 0; i < frList.size(); i++) {
						TempFrList fr = new TempFrList();
						fr.setFrId(frList.get(i).getFrId());
						fr.setFrName(frList.get(i).getFrName());

						List<TempSubCatList> tempScList = new ArrayList<>();
						if (frList.get(i).getSubCatList() != null) {

							for (int j = 0; j < frList.get(i).getSubCatList().size(); j++) {
								TempSubCatList scData = new TempSubCatList();
								scData.setSubCatId(frList.get(i).getSubCatList().get(j).getSubCatId());
								scData.setSubCatName(frList.get(i).getSubCatList().get(j).getSubCatName());

								List<TempItemList> tempItemList = new ArrayList<>();
								if (frList.get(i).getSubCatList().get(j).getItemList() != null) {

									for (int k = 0; k < frList.get(i).getSubCatList().get(j).getItemList()
											.size(); k++) {

										TempItemList itemData = new TempItemList();
										itemData.setItemId(
												frList.get(i).getSubCatList().get(j).getItemList().get(k).getItemId());
										itemData.setItemName(frList.get(i).getSubCatList().get(j).getItemList().get(k)
												.getItemName());

										for (int s = 0; s < soldList.size(); s++) {

											if (fr.getFrId() == soldList.get(s).getFrId()
													&& scData.getSubCatId() == soldList.get(s).getSubCatId()
													&& itemData.getItemId() == soldList.get(s).getItemId()
													&& month == soldList.get(s).getMonth() && String.valueOf(year)
															.equalsIgnoreCase(soldList.get(s).getYear())) {

												itemData.setSoldQty(soldList.get(s).getSoldQty());
												itemData.setSoldAmt(soldList.get(s).getSoldAmt());
												itemData.setTaxableAmt(soldList.get(s).getTaxableAmt());
												itemData.setTaxAmt(soldList.get(s).getTaxAmt());
												break;
											}

										}
										
										
										for (int s = 0; s < varList.size(); s++) {

											if (fr.getFrId() == varList.get(s).getFrId()
													&& scData.getSubCatId() == varList.get(s).getSubCatId()
													&& itemData.getItemId() == varList.get(s).getItemId()
													&& month == varList.get(s).getMonth() && String.valueOf(year)
															.equalsIgnoreCase(varList.get(s).getYear())) {

												itemData.setVarQty(varList.get(s).getQty());
												itemData.setVarAmt(varList.get(s).getAmt());
												itemData.setVarTaxableAmt(varList.get(s).getTaxableAmt());
												itemData.setVarTaxAmt(varList.get(s).getTaxAmt());
												break;
											}

										}
										
										
										for (int s = 0; s < retList.size(); s++) {

											if (fr.getFrId() == retList.get(s).getFrId()
													&& scData.getSubCatId() == retList.get(s).getSubCatId()
													&& itemData.getItemId() == retList.get(s).getItemId()
													&& month == retList.get(s).getMonth() && String.valueOf(year)
															.equalsIgnoreCase(retList.get(s).getYear())) {

												itemData.setRetQty(retList.get(s).getQty());
												itemData.setRetAmt(retList.get(s).getAmt());
												itemData.setRetTaxableAmt(retList.get(s).getTaxableAmt());
												itemData.setRetTaxAmt(retList.get(s).getTaxAmt());
												break;
											}

										}
										

										tempItemList.add(itemData);
									}
								}

								scData.setTempItemList(tempItemList);
								tempScList.add(scData);
							}
						}
						fr.setTempSubCatList(tempScList);
						tempFrList.add(fr);
					}
				}

				data.setFrList(tempFrList);

				/*
				 * if (soldList != null) { for (int i = 0; i < soldList.size(); i++) {
				 * 
				 * if (soldList.get(i).getMonth() == month &&
				 * soldList.get(i).getYear().equalsIgnoreCase(String.valueOf(year))) {
				 * 
				 * System.err.println("---MATCHED ---------- " + soldList.get(i).getMonth() +
				 * " - " + soldList.get(i).getYear());
				 * 
				 * if (tempFrList != null) {
				 * 
				 * for (int j = 0; j < tempFrList.size(); j++) {
				 * 
				 * TempFrList frData = tempFrList.get(j); //ArrayList<TempSubCatList>
				 * tempSubCatListForFr = new ArrayList<>();
				 * 
				 * if (frData.getFrId() == soldList.get(i).getFrId()) {
				 * 
				 * System.err.println("---FR MATCHED ---------- " + soldList.get(i).getFrId());
				 * 
				 * for (int k = 0; k < frData.getTempSubCatList().size(); k++) {
				 * 
				 * TempSubCatList scData = frData.getTempSubCatList().get(k);
				 * 
				 * if (soldList.get(i).getSubCatId() == scData.getSubCatId()) {
				 * 
				 * System.err.println("---SUB CAT MATCHED ---------- " +
				 * soldList.get(i).getSubCatId());
				 * 
				 * for (int m = 0; m < scData.getTempItemList().size(); m++) {
				 * 
				 * TempItemList itemData = scData.getTempItemList().get(m);
				 * 
				 * if (soldList.get(i).getItemId() == itemData.getItemId()) {
				 * 
				 * itemData.setSoldQty(soldList.get(i).getSoldQty());
				 * itemData.setSoldAmt(soldList.get(i).getSoldAmt());
				 * itemData.setTaxableAmt(soldList.get(i).getTaxableAmt());
				 * itemData.setTaxAmt(soldList.get(i).getTaxAmt());
				 * 
				 * break;
				 * 
				 * 
				 * }
				 * 
				 * }
				 * 
				 * 
				 * 
				 * } }
				 * 
				 * } //frData.setTempSubCatList(tempSubCatListForFr);
				 * 
				 * }
				 * 
				 * }
				 * 
				 * // billList.add(bill);
				 * 
				 * }
				 * 
				 * } }
				 */

				/*
				 * if (varList != null) { for (int i = 0; i < varList.size(); i++) {
				 * 
				 * if (varList.get(i).getMonth() == month &&
				 * varList.get(i).getYear().equalsIgnoreCase(String.valueOf(year))) {
				 * 
				 * 
				 * if (tempFrWiseSubCatList != null) {
				 * 
				 * for (int j = 0; j < tempFrWiseSubCatList.size(); j++) {
				 * 
				 * TempFrWiseSubCat frData = tempFrWiseSubCatList.get(j);
				 * 
				 * if (frData.getFrId() == varList.get(i).getFrId()) {
				 * 
				 * System.err.println("---FR MATCHED ---------- " + varList.get(i).getFrId());
				 * 
				 * for (int k = 0; k < frData.getSubCatList().size(); k++) {
				 * 
				 * TempSubCatWiseBillData billData = frData.getSubCatList().get(k);
				 * 
				 * if (varList.get(i).getSubCatId() == billData.getSubCatId()) {
				 * 
				 * System.err.println("---SUB CAT MATCHED ---------- " +
				 * varList.get(i).getSubCatId());
				 * 
				 * billData.setVarQty(varList.get(i).getQty());
				 * billData.setVarAmt(varList.get(i).getAmt());
				 * billData.setVarTaxableAmt(varList.get(i).getTaxableAmt());
				 * billData.setVarTaxAmt(varList.get(i).getTaxAmt());
				 * 
				 * break; } } }
				 * 
				 * }
				 * 
				 * }
				 * 
				 * }
				 * 
				 * } }
				 */

				/*
				 * if (retList != null) {
				 * 
				 * for (int i = 0; i < retList.size(); i++) {
				 * 
				 * if (retList.get(i).getMonth() == month &&
				 * retList.get(i).getYear().equalsIgnoreCase(String.valueOf(year))) {
				 * 
				 * 
				 * 
				 * if (tempFrWiseSubCatList != null) {
				 * 
				 * for (int j = 0; j < tempFrWiseSubCatList.size(); j++) {
				 * 
				 * TempFrWiseSubCat frData = tempFrWiseSubCatList.get(j);
				 * 
				 * if (frData.getFrId() == retList.get(i).getFrId()) {
				 * 
				 * System.err.println("---FR MATCHED ---------- " + retList.get(i).getFrId());
				 * 
				 * for (int k = 0; k < frData.getSubCatList().size(); k++) {
				 * 
				 * TempSubCatWiseBillData billData = frData.getSubCatList().get(k);
				 * 
				 * if (retList.get(i).getSubCatId() == billData.getSubCatId()) {
				 * 
				 * System.err.println("---SUB CAT MATCHED ---------- " +
				 * retList.get(i).getSubCatId());
				 * 
				 * billData.setRetQty(retList.get(i).getQty());
				 * billData.setRetAmt(retList.get(i).getAmt());
				 * billData.setRetTaxableAmt(retList.get(i).getTaxableAmt());
				 * billData.setRetTaxAmt(retList.get(i).getTaxAmt());
				 * 
				 * break; } } }
				 * 
				 * }
				 * 
				 * }
				 * 
				 * }
				 * 
				 * } }
				 */

				reportList.add(data);

				calFrom.add(Calendar.MONTH, 1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return reportList;
	}

}
