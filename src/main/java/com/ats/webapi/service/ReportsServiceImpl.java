package com.ats.webapi.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.BillWisePurchase;
import com.ats.webapi.model.BillWisePurchaseList;
import com.ats.webapi.model.BillWiseTaxReport;
import com.ats.webapi.model.BillWiseTaxReportList;
import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.ItemWiseDetail;
import com.ats.webapi.model.ItemWiseDetailList;
import com.ats.webapi.model.ItemWiseReport;
import com.ats.webapi.model.ItemWiseReportList;
import com.ats.webapi.model.MonthWiseReport;
import com.ats.webapi.model.MonthWiseReportList;
import com.ats.webapi.model.report.DispatchReport;
import com.ats.webapi.repository.BillWisePurchaseRepository;
import com.ats.webapi.repository.BillWiseTaxReportRepository;
import com.ats.webapi.repository.DispatchReportRepository;
import com.ats.webapi.repository.ItemWiseDetailRepository;
import com.ats.webapi.repository.ItemWiseReportRepository;
import com.ats.webapi.repository.MonthWiseReportRepository;

@Service
public class ReportsServiceImpl implements ReportsService {

	@Autowired
	BillWisePurchaseRepository billWisePurchaseRepository;

	@Autowired
	ItemWiseDetailRepository itemWiseDetailRepository;

	@Autowired
	ItemWiseReportRepository itemWiseReportRepository;

	@Autowired
	MonthWiseReportRepository monthWiseReportRepository;

	@Autowired
	BillWiseTaxReportRepository billWiseTaxReportRepository;

	@Autowired
	DispatchReportRepository dispatchReportRepository;

	@Override
	public BillWisePurchaseList getBillWisePurchaseReport(int frId, String fromDate, String toDate) {

		List<BillWisePurchase> billWisePurchase = billWisePurchaseRepository.findBillWisePurchaseReport(frId, fromDate,
				toDate);

		BillWisePurchaseList billWisePurchaseList = new BillWisePurchaseList();
		ErrorMessage errorMessage = new ErrorMessage();

		if (billWisePurchase == null) {
			errorMessage.setError(true);
			errorMessage.setMessage("Records Not Found.");
		} else {
			errorMessage.setError(false);
			errorMessage.setMessage("Records Found Successfully.");

			billWisePurchaseList.setBillWisePurchaseList(billWisePurchase);
			billWisePurchaseList.setErrorMessage(errorMessage);
		}
		return billWisePurchaseList;
	}

	@Override
	public ItemWiseDetailList getItemWiseDetailReport(int frId, int catId, String fromDate, String toDate) {

		System.out.println("Date: " + fromDate + "To" + toDate);
		ItemWiseDetailList itemWiseDetailList = new ItemWiseDetailList();
		if (catId == 5) {
			List<ItemWiseDetail> itemWiseDetail = itemWiseDetailRepository.findSpecialCakeWiseDetailReport(frId, catId,
					fromDate, toDate);

			ErrorMessage errorMessage = new ErrorMessage();

			if (itemWiseDetail == null) {
				errorMessage.setError(true);
				errorMessage.setMessage("Records Not Found.");
			} else {
				errorMessage.setError(false);
				errorMessage.setMessage("Records Found Successfully.");

				itemWiseDetailList.setErrorMessage(errorMessage);
				itemWiseDetailList.setItemWiseDetailList(itemWiseDetail);
			}

		} else {
			List<ItemWiseDetail> itemWiseDetail = itemWiseDetailRepository.findItemWiseDetailReport(frId, catId,
					fromDate, toDate);

			ErrorMessage errorMessage = new ErrorMessage();

			if (itemWiseDetail == null) {
				errorMessage.setError(true);
				errorMessage.setMessage("Records Not Found.");
			} else {
				errorMessage.setError(false);
				errorMessage.setMessage("Records Found Successfully.");

				itemWiseDetailList.setErrorMessage(errorMessage);
				itemWiseDetailList.setItemWiseDetailList(itemWiseDetail);
			}

		}
		return itemWiseDetailList;
	}
	
	
	@Override
	public ItemWiseDetailList getItemWiseDetailReportsubCat(int frId, int catId,int subCat, String fromDate, String toDate) {

		System.out.println("Date: " + fromDate + "To" + toDate);
		ItemWiseDetailList itemWiseDetailList = new ItemWiseDetailList();
		
		if (catId == 5) {
			List<ItemWiseDetail> itemWiseDetail = itemWiseDetailRepository.findSpecialCakeWiseDetailReport(frId, catId,
					fromDate, toDate);

			ErrorMessage errorMessage = new ErrorMessage();

			if (itemWiseDetail == null) {
				errorMessage.setError(true);
				errorMessage.setMessage("Records Not Found.");
			} else {
				errorMessage.setError(false);
				errorMessage.setMessage("Records Found Successfully.");

				itemWiseDetailList.setErrorMessage(errorMessage);
				itemWiseDetailList.setItemWiseDetailList(itemWiseDetail);
			}

		} else {
			List<ItemWiseDetail> itemWiseDetail = itemWiseDetailRepository.findItemWiseDetailReportsubCatwise(frId, subCat,
					fromDate, toDate);

			ErrorMessage errorMessage = new ErrorMessage();

			if (itemWiseDetail == null) {
				errorMessage.setError(true);
				errorMessage.setMessage("Records Not Found.");
			} else {
				errorMessage.setError(false);
				errorMessage.setMessage("Records Found Successfully.");

				itemWiseDetailList.setErrorMessage(errorMessage);
				itemWiseDetailList.setItemWiseDetailList(itemWiseDetail);
			}

		}
		return itemWiseDetailList;
	}
	
	 

	@Override
	public ItemWiseDetailList getItemWiseDetailReportByItemIds(int frId,int catId,int subCat, List<Integer> itemIds, String fromDate,
			String toDate) {

		System.out.println("Date: " + fromDate + "To" + toDate);
		ItemWiseDetailList itemWiseDetailList = new ItemWiseDetailList();

		try {

			List<ItemWiseDetail> itemWiseDetail = new ArrayList<>();
			
			if (catId == 5) {
				 itemWiseDetail = itemWiseDetailRepository.findSpecialCakeWiseDetailReportByItemIds(frId,catId, itemIds,
						fromDate, toDate);
 

			} else {
				
				 itemWiseDetail = itemWiseDetailRepository.getItemWiseDetailReportByItemIds(frId,itemIds, fromDate, toDate); 

			}
			
			ErrorMessage errorMessage = new ErrorMessage();

			if (itemWiseDetail == null) {
				errorMessage.setError(true);
				errorMessage.setMessage("Records Not Found.");
			} else {
				errorMessage.setError(false);
				errorMessage.setMessage("Records Found Successfully.");

				itemWiseDetailList.setErrorMessage(errorMessage);
				itemWiseDetailList.setItemWiseDetailList(itemWiseDetail);
			}
			 

		} catch (Exception e) {
			e.printStackTrace();
		}

		return itemWiseDetailList;
	}

	@Override
	public MonthWiseReportList getMonthWiseReport(int frId, String fromDate, String toDate) {

		List<MonthWiseReport> monthWiseReport = monthWiseReportRepository.findMonthWiseReport(frId, fromDate, toDate);

		MonthWiseReportList monthWiseReportList = new MonthWiseReportList();
		ErrorMessage errorMessage = new ErrorMessage();

		if (monthWiseReport == null) {
			errorMessage.setError(true);
			errorMessage.setMessage("Records Not Found.");
		} else {
			errorMessage.setError(false);
			errorMessage.setMessage("Records Found Successfully.");

			monthWiseReportList.setErrorMessage(errorMessage);
			monthWiseReportList.setMonthWiseReportList(monthWiseReport);
		}
		return monthWiseReportList;
	}

	@Override
	public MonthWiseReportList getMonthWiseReportByTypeId(int frId, String fromDate, String toDate, int typeId) {

		MonthWiseReportList monthWiseReportList = new MonthWiseReportList();

		try {

			List<MonthWiseReport> monthWiseReport = new ArrayList<>();

			if (typeId == 1) {

				monthWiseReport = monthWiseReportRepository.findMonthWiseReport(frId, fromDate, toDate);

			} else if (typeId == 2) {

				monthWiseReport = monthWiseReportRepository.findMonthWiseReportGrn(frId, fromDate, toDate);

			} else {

				monthWiseReport = monthWiseReportRepository.findMonthWiseReport(frId, fromDate, toDate);
				List<MonthWiseReport> grn = monthWiseReportRepository.findMonthWiseReportGrn(frId, fromDate, toDate);

				for (int i = 0; i < monthWiseReport.size(); i++) {

					for (int j = 0; j < grn.size(); j++) {

						if (monthWiseReport.get(i).getMonth().equals(grn.get(j).getMonth())) {

							monthWiseReport.get(i)
									.setTaxableAmt(monthWiseReport.get(i).getTaxableAmt() - grn.get(j).getTaxableAmt());
							monthWiseReport.get(i)
									.setCgstRs(monthWiseReport.get(i).getCgstRs() - grn.get(j).getCgstRs());
							monthWiseReport.get(i)
									.setSgstRs(monthWiseReport.get(i).getSgstRs() - grn.get(j).getSgstRs());
							monthWiseReport.get(i)
									.setIgstRs(monthWiseReport.get(i).getIgstRs() - grn.get(j).getIgstRs());
							monthWiseReport.get(i)
									.setGrandTotal(monthWiseReport.get(i).getGrandTotal() - grn.get(j).getGrandTotal());
							break;
						}
					}
				}

			}

			ErrorMessage errorMessage = new ErrorMessage();

			if (monthWiseReport == null) {
				errorMessage.setError(true);
				errorMessage.setMessage("Records Not Found.");
			} else {
				errorMessage.setError(false);
				errorMessage.setMessage("Records Found Successfully.");

				monthWiseReportList.setErrorMessage(errorMessage);
				monthWiseReportList.setMonthWiseReportList(monthWiseReport);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return monthWiseReportList;
	}

	@Override
	public BillWiseTaxReportList getBillWiseTaxReport(int frId, String fromDate, String toDate) {

		List<BillWiseTaxReport> billWiseTax = billWiseTaxReportRepository.findBillWiseTaxReport(frId, fromDate, toDate);

		BillWiseTaxReportList billWiseTaxReportList = new BillWiseTaxReportList();
		ErrorMessage errorMessage = new ErrorMessage();

		if (billWiseTax == null) {
			errorMessage.setError(true);
			errorMessage.setMessage("Records Not Found.");
		} else {
			errorMessage.setError(false);
			errorMessage.setMessage("Records Found Successfully.");

			billWiseTaxReportList.setBillWiseTaxReportList(billWiseTax);
			billWiseTaxReportList.setErrorMessage(errorMessage);
		}
		return billWiseTaxReportList;
	}

	@Override
	public BillWiseTaxReportList getBillWiseTaxReport(int frId, String fromDate, String toDate, int typeId) {

		BillWiseTaxReportList billWiseTaxReportList = new BillWiseTaxReportList();
		try {

			List<BillWiseTaxReport> billWiseTax = new ArrayList<>();

			if (typeId == 1) {

				billWiseTax = billWiseTaxReportRepository.findBillWiseTaxReport(frId, fromDate, toDate);
			} else if (typeId == 2) {

				billWiseTax = billWiseTaxReportRepository.findBillWiseTaxReportGrn(frId, fromDate, toDate);
			} else {

				billWiseTax = billWiseTaxReportRepository.findBillWiseTaxReport(frId, fromDate, toDate);
				List<BillWiseTaxReport> grn = billWiseTaxReportRepository.findBillWiseTaxReportGrn(frId, fromDate,
						toDate);

				for (int i = 0; i < billWiseTax.size(); i++) {

					for (int j = 0; j < grn.size(); j++) {

						if (billWiseTax.get(i).getTaxRate() == grn.get(j).getTaxRate()) {

							billWiseTax.get(i)
									.setTaxableAmt(billWiseTax.get(i).getTaxableAmt() - grn.get(j).getTaxableAmt());
							billWiseTax.get(i).setCgstRs(billWiseTax.get(i).getCgstRs() - grn.get(j).getCgstRs());
							billWiseTax.get(i).setSgstRs(billWiseTax.get(i).getSgstRs() - grn.get(j).getSgstRs());
							billWiseTax.get(i).setIgstRs(billWiseTax.get(i).getIgstRs() - grn.get(j).getIgstRs());
							billWiseTax.get(i)
									.setGrandTotal(billWiseTax.get(i).getGrandTotal() - grn.get(j).getGrandTotal());
							grn.remove(j);
							break;
						}
					}
				}
				
				for (int j = 0; j < grn.size(); j++) {

					billWiseTax.add(grn.get(j)); 
				}
			}

			Collections.sort(billWiseTax, new Comparator<BillWiseTaxReport>() {
				public int compare(BillWiseTaxReport c1, BillWiseTaxReport c2) {
					if (c1.getTaxRate() > c2.getTaxRate())
						return 1;
					if (c1.getTaxRate() < c2.getTaxRate())
						return -1;
					return 0;
				}
			});
			ErrorMessage errorMessage = new ErrorMessage();

			if (billWiseTax == null) {
				errorMessage.setError(true);
				errorMessage.setMessage("Records Not Found.");
			} else {
				errorMessage.setError(false);
				errorMessage.setMessage("Records Found Successfully.");

				billWiseTaxReportList.setBillWiseTaxReportList(billWiseTax);
				billWiseTaxReportList.setErrorMessage(errorMessage);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return billWiseTaxReportList;
	}

	@Override
	public ItemWiseReportList getItemWiseReport(int frId, int catId, String fromDate, String toDate) {

		System.out.println("Date: " + fromDate + "To" + toDate);
		ItemWiseReportList itemWiseReportList = new ItemWiseReportList();
		if (catId == 5) {
			List<ItemWiseReport> itemWiseReport = itemWiseReportRepository.findSpecialCakeWiseReport(frId, catId,
					fromDate, toDate);

			ErrorMessage errorMessage = new ErrorMessage();

			if (itemWiseReport == null) {
				errorMessage.setError(true);
				errorMessage.setMessage("Records Not Found.");
			} else {
				errorMessage.setError(false);
				errorMessage.setMessage("Records Found Successfully.");

				itemWiseReportList.setErrorMessage(errorMessage);
				itemWiseReportList.setItemWiseReportList(itemWiseReport);
			}

		} else {
			List<ItemWiseReport> itemWiseReport = itemWiseReportRepository.findItemWiseReport(frId, catId, fromDate,
					toDate);

			ErrorMessage errorMessage = new ErrorMessage();

			if (itemWiseReport == null) {
				errorMessage.setError(true);
				errorMessage.setMessage("Records Not Found.");
			} else {
				errorMessage.setError(false);
				errorMessage.setMessage("Records Found Successfully.");

				itemWiseReportList.setErrorMessage(errorMessage);
				itemWiseReportList.setItemWiseReportList(itemWiseReport);
			}

		}
		return itemWiseReportList;
	}

	@Override
	public ItemWiseReportList showItemWiseReportByTypeId(int frId, int catId, String fromDate, String toDate,
			int typeId) {

		ItemWiseReportList itemWiseReportList = new ItemWiseReportList();

		try {

			if (typeId == 1) {

				if (catId == 5) {
					List<ItemWiseReport> itemWiseReport = itemWiseReportRepository.findSpecialCakeWiseReport(frId,
							catId, fromDate, toDate);

					ErrorMessage errorMessage = new ErrorMessage();

					if (itemWiseReport == null) {
						errorMessage.setError(true);
						errorMessage.setMessage("Records Not Found.");
					} else {
						errorMessage.setError(false);
						errorMessage.setMessage("Records Found Successfully.");

						itemWiseReportList.setErrorMessage(errorMessage);
						itemWiseReportList.setItemWiseReportList(itemWiseReport);
					}

				} else {
					List<ItemWiseReport> itemWiseReport = itemWiseReportRepository.findItemWiseReport(frId, catId,
							fromDate, toDate);

					ErrorMessage errorMessage = new ErrorMessage();

					if (itemWiseReport == null) {
						errorMessage.setError(true);
						errorMessage.setMessage("Records Not Found.");
					} else {
						errorMessage.setError(false);
						errorMessage.setMessage("Records Found Successfully.");

						itemWiseReportList.setErrorMessage(errorMessage);
						itemWiseReportList.setItemWiseReportList(itemWiseReport);
					}

				}

			} else if (typeId == 2) {

				if (catId == 5) {
					List<ItemWiseReport> itemWiseReport = itemWiseReportRepository.findSpecialCakeWiseReportGrn(frId,
							fromDate, toDate);

					ErrorMessage errorMessage = new ErrorMessage();

					if (itemWiseReport == null) {
						errorMessage.setError(true);
						errorMessage.setMessage("Records Not Found.");
					} else {
						errorMessage.setError(false);
						errorMessage.setMessage("Records Found Successfully.");

						itemWiseReportList.setErrorMessage(errorMessage);
						itemWiseReportList.setItemWiseReportList(itemWiseReport);
					}

				} else {
					List<ItemWiseReport> itemWiseReport = itemWiseReportRepository.findItemWiseReportGrn(frId, catId,
							fromDate, toDate);

					ErrorMessage errorMessage = new ErrorMessage();

					if (itemWiseReport == null) {
						errorMessage.setError(true);
						errorMessage.setMessage("Records Not Found.");
					} else {
						errorMessage.setError(false);
						errorMessage.setMessage("Records Found Successfully.");

						itemWiseReportList.setErrorMessage(errorMessage);
						itemWiseReportList.setItemWiseReportList(itemWiseReport);
					}

				}

			} else {

				if (catId == 5) {

					List<ItemWiseReport> purchse = itemWiseReportRepository.findSpecialCakeWiseReport(frId, catId,
							fromDate, toDate);

					List<ItemWiseReport> grn = itemWiseReportRepository.findSpecialCakeWiseReportGrn(frId, fromDate,
							toDate);

					for (int i = 0; i < purchse.size(); i++) {

						for (int j = 0; j < grn.size(); j++) {

							if (purchse.get(i).getItemId() == grn.get(j).getItemId()) {

								purchse.get(i).setQty(purchse.get(i).getQty() - grn.get(j).getQty());
								purchse.get(i).setTotal(purchse.get(i).getTotal() - grn.get(j).getTotal());
								grn.remove(j);
								break;
							}
						}

					}

					for (int j = 0; j < grn.size(); j++) {

						purchse.add(grn.get(j));
					}

					ErrorMessage errorMessage = new ErrorMessage();
					errorMessage.setError(false);
					errorMessage.setMessage("Records Found Successfully.");

					itemWiseReportList.setErrorMessage(errorMessage);
					itemWiseReportList.setItemWiseReportList(purchse);

				} else {

					List<ItemWiseReport> purchse = itemWiseReportRepository.findItemWiseReport(frId, catId, fromDate,
							toDate);

					List<ItemWiseReport> grn = itemWiseReportRepository.findItemWiseReportGrn(frId, catId, fromDate,
							toDate);

					for (int i = 0; i < purchse.size(); i++) {

						for (int j = 0; j < grn.size(); j++) {

							if (purchse.get(i).getItemId() == grn.get(j).getItemId()) {

								purchse.get(i).setQty(purchse.get(i).getQty() - grn.get(j).getQty());
								purchse.get(i).setTotal(purchse.get(i).getTotal() - grn.get(j).getTotal());
								grn.remove(j);
								break;
							}
						}

					}

					for (int j = 0; j < grn.size(); j++) {

						purchse.add(grn.get(j));
					}

					ErrorMessage errorMessage = new ErrorMessage();
					errorMessage.setError(false);
					errorMessage.setMessage("Records Found Successfully.");

					itemWiseReportList.setErrorMessage(errorMessage);
					itemWiseReportList.setItemWiseReportList(purchse);

				}

				Collections.sort(itemWiseReportList.getItemWiseReportList(), new Comparator<ItemWiseReport>() {
					public int compare(ItemWiseReport c1, ItemWiseReport c2) {
						if (c1.getItemId() > c2.getItemId())
							return 1;
						if (c1.getItemId() < c2.getItemId())
							return -1;
						return 0;
					}
				});
			}

		} catch (

		Exception e) {
			e.printStackTrace();
		}

		return itemWiseReportList;
	}

	@Override
	public List<DispatchReport> getDispatchItemReport(String billDateYMD, List<String> frId, List<String> categories) {

		List<DispatchReport> dispatchReportList;
		try {
			dispatchReportList = dispatchReportRepository.findDispatchReportList(billDateYMD, frId, categories);

		} catch (Exception e) {
			dispatchReportList = new ArrayList<>();
			e.printStackTrace();
		}
		return dispatchReportList;
	}

}
