package com.ats.webapi.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.commons.Common;
import com.ats.webapi.model.Customer;
import com.ats.webapi.model.CustomerAmounts;
import com.ats.webapi.model.GetTotalAmt;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.ItemOrderHis;
import com.ats.webapi.model.ItemOrderList;
import com.ats.webapi.model.SellBillHeader;
import com.ats.webapi.model.TransactionDetail;
import com.ats.webapi.model.TransactionDetailWithDisc;
import com.ats.webapi.model.advorder.AdvOrderForAdminDash;
import com.ats.webapi.model.advorder.AdvanceOrderDetail;
import com.ats.webapi.model.advorder.AdvanceOrderHeader;
import com.ats.webapi.model.advorder.GetAdvanceOrderList;
import com.ats.webapi.model.bill.ItemListForCustomerBill;
import com.ats.webapi.model.bill.OpsItemListForCustomerBill;
import com.ats.webapi.repo.CustomerRepo;
import com.ats.webapi.repo.GetTotalAmtRepo;
import com.ats.webapi.repo.ItemListForCustomerBillRepo;
import com.ats.webapi.repo.OpsItemListForCustomerBillRepo;
import com.ats.webapi.repo.TransactionDetailWithDiscRepo;
import com.ats.webapi.repository.CustomerAmountsRepo;
import com.ats.webapi.repository.SellBillHeaderRepository;
import com.ats.webapi.repository.TransactionDetailRepository;
import com.ats.webapi.repository.advorder.AdvOrderForAdminDashRepo;
import com.ats.webapi.repository.advorder.AdvanceOrderDetailRepo;
import com.ats.webapi.repository.advorder.AdvanceOrderHeaderRepo;
import com.ats.webapi.repository.advorder.GetAdvanceOrderListRepo;
import com.ats.webapi.service.OrderService;

@RestController
public class AdvanceOrderApiController {

	@Autowired
	AdvanceOrderHeaderRepo advanceOrderHeaderRepo;

	@Autowired
	AdvanceOrderDetailRepo advanceOrderDetailRepo;

	@Autowired
	GetTotalAmtRepo getTotalAmtRepo;

	@Autowired
	TransactionDetailRepository transactionDetailRepository;

	@Autowired
	private OrderService orderService;

	@Autowired
	ItemListForCustomerBillRepo itemListForCustomerBillRepo;

	@Autowired
	OpsItemListForCustomerBillRepo opsItemListForCustomerBillRepo;

	@Autowired
	CustomerAmountsRepo customerAmountsRepo;

	@Autowired
	SellBillHeaderRepository sellBillHeaderRepository;

	@Autowired
	CustomerRepo customerRepo;

	@Autowired
	TransactionDetailWithDiscRepo transactionDetailWithDiscRepo;

	@RequestMapping(value = { "/saveAdvanceOrderHeadAndDetail" }, method = RequestMethod.POST)
	public @ResponseBody AdvanceOrderHeader saveAdvanceOrderHeadAndDetail(@RequestBody AdvanceOrderHeader matHeader) {

		System.err.println("inside saveAdvanceOrderHeadAndDetail" + matHeader.toString());

		AdvanceOrderHeader header = new AdvanceOrderHeader();

		try {

			header = advanceOrderHeaderRepo.save(matHeader);
			System.err.println("After head" + header.toString());
			for (int i = 0; i < matHeader.getDetailList().size(); i++) {
				matHeader.getDetailList().get(i).setAdvHeaderId(header.getAdvHeaderId());

			}

			List<AdvanceOrderDetail> matDetailsList = advanceOrderDetailRepo.save(matHeader.getDetailList());
			header.setDetailList(matDetailsList);

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Exce in saveAdvanceOrderHeadAndDetail" + e.getMessage());

		}

		return header;

	}

	@RequestMapping(value = { "/checkCustPhone" }, method = RequestMethod.POST)
	public @ResponseBody Info checkEmployeeEmail(@RequestParam String phoneNo) {

		Info info = new Info();
		List<Customer> emp = new ArrayList<Customer>();
		try {

			emp = customerRepo.findByPhoneNumberAndDelStatus(phoneNo, 0);
			System.err.println(emp.toString() + "phoneNo" + phoneNo);
			if (emp.size() > 0) {
				info.setError(true);
				info.setMessage("" + emp.get(0).getCustId());
			} else {
				info.setError(false);
				info.setMessage("0");

			}

		} catch (Exception e) {
			System.err.println("Exce in checkEmployeeEmail  " + e.getMessage());
		}

		return info;

	}

	// Search Advance Order History
	@RequestMapping("/advanceOrderHistoryDetail")
	public @ResponseBody ItemOrderList searchAdvOrderHistory(@RequestParam int headId, @RequestParam String deliveryDt,
			@RequestParam int frId) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = sdf.parse(deliveryDt);
		java.sql.Date deliveryDate = new java.sql.Date(date.getTime());

		ItemOrderList orderList = orderService.searchAdvOrderHistory(headId, deliveryDate, frId);

		return orderList;

	}

	@RequestMapping("/advanceOrderHistoryHedaerByHeadId")
	public @ResponseBody AdvanceOrderHeader advanceOrderHistoryHedaer(@RequestParam int headId) throws ParseException {
		AdvanceOrderHeader orderList = new AdvanceOrderHeader();
		try {
			orderList = advanceOrderHeaderRepo.findByAdvHeaderIdAndDelStatus(headId, 0);
			
			if(orderList==null) {
				orderList = new AdvanceOrderHeader();
			}
			
		} catch (Exception e) {
			System.out.println("Exc in advanceOrderHistoryHeader" + e.getMessage());
			e.printStackTrace();
		}

		return orderList;

	}

	@RequestMapping("/advanceOrderHistoryHeader")
	public @ResponseBody List<AdvanceOrderHeader> advanceOrderHistoryHeader(@RequestParam int flag,
			@RequestParam String deliveryDt, @RequestParam int frId) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = sdf.parse(deliveryDt);
		java.sql.Date deliveryDate = new java.sql.Date(date.getTime());
		List<AdvanceOrderHeader> orderList = new ArrayList<AdvanceOrderHeader>();
		System.out.println(deliveryDt + "flag is " + flag);
		try {

			if (flag == 1) {
				orderList = advanceOrderHeaderRepo
						.findByDeliveryDateAndFrIdAndDelStatusOrderByOrderDateDesc(deliveryDate, frId, 0);

			} else {
				orderList = advanceOrderHeaderRepo
						.findByFrIdAndDelStatusAndIsSellBillGeneratedOrderByOrderDateDesc(frId, 0, 0);

			}

		} catch (Exception e) {
			System.out.println("Exc in advanceOrderHistoryHeader" + e.getMessage());
			e.printStackTrace();
		}

		return orderList;

	}

	@RequestMapping("/advanceOrderHistoryHeaderForDispFr")
	public @ResponseBody List<AdvanceOrderHeader> advanceOrderHistoryHeaderForDispFr(@RequestParam int flag,
			@RequestParam String deliveryDt, @RequestParam int frId) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = sdf.parse(deliveryDt);
		java.sql.Date deliveryDate = new java.sql.Date(date.getTime());
		List<AdvanceOrderHeader> orderList = new ArrayList<AdvanceOrderHeader>();
		System.out.println(deliveryDt + "flag is " + flag);

		String dt = sdf.format(deliveryDate);

		try {

			if (flag == 1) {
				orderList = advanceOrderHeaderRepo.getAdvOrderHeaderByDelDateForDispFr(dt, frId, 0);

			} else {
				orderList = advanceOrderHeaderRepo.getAdvOrderHeaderForDispFr(frId, 0, 0);

			}

		} catch (Exception e) {
			System.out.println("Exc in advanceOrderHistoryHeader" + e.getMessage());
			e.printStackTrace();
		}

		return orderList;

	}

	@Autowired
	GetAdvanceOrderListRepo getAdvanceOrderListRepo;

	@RequestMapping(value = { "/advanceOrderHistoryHeaderAdmin" }, method = RequestMethod.POST)
	public @ResponseBody List<GetAdvanceOrderList> updateBmsStock(@RequestParam String prodDate,
			@RequestParam int isBilled) {
		List<GetAdvanceOrderList> advList = new ArrayList<GetAdvanceOrderList>();

		try {
			if (isBilled < 0) {
				advList = getAdvanceOrderListRepo.getAdvanceOrderList(prodDate);
			} else {
				advList = getAdvanceOrderListRepo.getAdvanceOrderBillNotGen(isBilled);
			}
		} catch (Exception e) {
			System.out.println("Exce in advanceOrderHistoryHeaderAdmin  " + e.getMessage());
			e.printStackTrace();
		}

		return advList;
	}

	@Autowired
	AdvOrderForAdminDashRepo advOrderForAdminDashRepo;

	@RequestMapping(value = { "/advanceOrderHistoryHeaderAdminForAdminDash" }, method = RequestMethod.POST)
	public @ResponseBody List<AdvOrderForAdminDash> advanceOrderHistoryHeaderAdminForAdminDash(
			@RequestParam String prodDate, @RequestParam int isBilled) {
		List<AdvOrderForAdminDash> advList = new ArrayList<AdvOrderForAdminDash>();

		try {
			if (isBilled < 0) {
				advList = advOrderForAdminDashRepo.getAdvanceOrderListAdminDash(prodDate);
			} else {
				advList = advOrderForAdminDashRepo.getAdvanceOrderBillNotGenAdminDash(isBilled);
			}
		} catch (Exception e) {
			System.out.println("Exce in advanceOrderHistoryHeaderAdminForAdminDash  " + e.getMessage());
			e.printStackTrace();
		}

		return advList;
	}

	@RequestMapping("/advanceOrderHistoryDetailForAdmin")
	public @ResponseBody ItemOrderList advanceOrderHistoryDetailForAdmin(@RequestParam int headId)
			throws ParseException {

		ItemOrderList orderList = orderService.searchAdvOrderHistoryForAdmin(headId);

		System.err.println("RESULT ------------------ " + orderList);

		return orderList;

	}

	@RequestMapping("/advanceOrderHistoryDetailForAdmin1")
	public @ResponseBody List<ItemOrderHis> advanceOrderHistoryDetailForAdmin1(@RequestParam int headId)
			throws ParseException {

		List<ItemOrderHis> res = new ArrayList<>();

		ItemOrderList orderList = orderService.searchAdvOrderHistoryForAdmin(headId);
		res = orderList.getItemOrderList();

		System.err.println("RESULT ------------------ " + orderList);

		return res;

	}

	@RequestMapping("/getAdvanceOrderItemsByHeadId")
	public @ResponseBody List<ItemListForCustomerBill> getAdvanceOrderItemsByHeadId(@RequestParam int headId)
			throws ParseException {
		List<ItemListForCustomerBill> itm = null;
		System.err.println("data is" + headId);
		try {
			itm = itemListForCustomerBillRepo.getItem(headId);

			for (int i = 0; i < itm.size(); i++) {
				ItemListForCustomerBill temp = itm.get(i);

				float total = temp.getOrignalMrp() * temp.getQty();
				Float taxableAmt = (total * 100) / (100 + temp.getTaxPer());
				temp.setTaxAmt(total - taxableAmt);
				temp.setTaxableAmt(taxableAmt);
				temp.setTotal(total);

			}

			System.err.println("data is" + itm.toString());

		} catch (Exception e) {
			System.out.println("Exc in advanceOrderHistoryHeader" + e.getMessage());
			e.printStackTrace();
		}

		return itm;

	}

	@RequestMapping("/getOpsAdvanceOrderItemsByHeadId")
	public @ResponseBody List<OpsItemListForCustomerBill> getOpsAdvanceOrderItemsByHeadId(@RequestParam int headId)
			throws ParseException {
		List<OpsItemListForCustomerBill> itm = null;
		System.err.println("data is" + headId);
		try {
			itm = opsItemListForCustomerBillRepo.getOpsItem(headId);

			for (int i = 0; i < itm.size(); i++) {
				OpsItemListForCustomerBill temp = itm.get(i);

				float total = temp.getOrignalMrp() * temp.getQty();
				Float taxableAmt = (total * 100) / (100 + temp.getTaxPer());
				temp.setTaxAmt(total - taxableAmt);
				temp.setTaxableAmt(taxableAmt);
				temp.setTotal(total);

			}

			System.err.println("data is" + itm.toString());

		} catch (Exception e) {
			System.out.println("Exc in advanceOrderHistoryHeader" + e.getMessage());
			e.printStackTrace();
		}

		return itm;

	}

	@RequestMapping(value = { "/updateAdvOrderHeadAndDetail" }, method = RequestMethod.POST)
	public @ResponseBody Info updateFrSettingBillNo(@RequestParam("advHeadId") int advHeadId) {

		Info info = new Info();
		int updateResponse = 0;
		int updateResponse1 = 0;
		try {

			updateResponse = advanceOrderHeaderRepo.updateIsSellBillGen(advHeadId);

			if (updateResponse > 0) {
				updateResponse1 = advanceOrderDetailRepo.updateIsSellBillGen(advHeadId);
			}

			if (updateResponse > 0 && updateResponse1 > 0) {

				info.setError(false);
				info.setMessage("success Updating fr seting sell bill no ");

			} else {
				info.setError(true);
				info.setMessage("failure");
			}

		} catch (Exception e) {

			System.out.println(
					" /updateFrSettingBillNo Exce in Saving/Update fr Setting /FrSettingController " + e.getMessage());
			e.printStackTrace();
		}

		return info;

	}

	@RequestMapping(value = { "/getCustomerAmounts" }, method = RequestMethod.POST)
	public @ResponseBody CustomerAmounts getCustomerAmounts(@RequestParam int custId, @RequestParam int frId) {
		CustomerAmounts orderList = new CustomerAmounts();
		CustomerAmounts orderList1 = new CustomerAmounts();
		CustomerAmounts orderList2 = new CustomerAmounts();
		System.err.println("data is" + custId);

		orderList1 = customerAmountsRepo.findPendingAmt(custId, frId);
		orderList2 = customerAmountsRepo.findAadvAmt(custId, frId);

		orderList.setCreaditAmt(orderList1.getCreaditAmt());

		orderList.setAdvanceAmt(orderList2.getCreaditAmt());
		orderList.setCustId(custId);
		return orderList;

	}

	@RequestMapping("/getSellBillByCustId")
	public @ResponseBody List<SellBillHeader> getSellBillByCustId(@RequestParam int custId, @RequestParam int frId)
			throws ParseException {
		List<SellBillHeader> itm = null;

		Customer cust = new Customer();
		try {
			itm = sellBillHeaderRepository.getSellBillHeaderPending(custId, frId);

			System.err.println("data is" + itm.toString());

			cust = customerRepo.findByCustIdAndDelStatus(custId, 0);

			System.err.println("cust is " + cust.toString());
			for (int i = 0; i < itm.size(); i++) {

				itm.get(i).setUserName(cust.getCustName());

			}
			System.err.println("cust is " + itm.toString());
		} catch (Exception e) {
			System.out.println("Exc in advanceOrderHistoryHeader" + e.getMessage());
			e.printStackTrace();
		}

		return itm;

	}

	@RequestMapping("/advanceOrderHistoryHeaderByCustId")
	public @ResponseBody List<AdvanceOrderHeader> advanceOrderHistoryHeaderByCustId(@RequestParam int custId,
			@RequestParam int frId) throws ParseException {

		List<AdvanceOrderHeader> orderList = new ArrayList<AdvanceOrderHeader>();
		try {

			orderList = advanceOrderHeaderRepo.findByCustIdAndIsSellBillGeneratedAndDelStatus(custId, 0, 0);

		} catch (Exception e) {
			System.out.println("Exc in advanceOrderHistoryHeader" + e.getMessage());
			e.printStackTrace();
		}

		return orderList;

	}

	@RequestMapping(value = { "/saveBillTransDetail" }, method = RequestMethod.POST)
	@ResponseBody
	public Info saveBillTransDetail(@RequestBody List<TransactionDetail> expTransList) {

		Info inf = new Info();

		try {

			for (int i = 0; i < expTransList.size(); i++) {
				TransactionDetail jsonResult = transactionDetailRepository.save(expTransList.get(i));

				if (jsonResult != null) {
					System.err.println("inside update");
					float finPending = Float.parseFloat(jsonResult.getExVar2());
					float finPaid = expTransList.get(i).getExFloat1() - finPending;
					int flag = 0;
					if (finPending <= 0) {

						System.err.println("in sat");
						flag = 1;
					} else {
						flag = 3;
					}

					int del = sellBillHeaderRepository.upDateBillAmt(String.valueOf(Math.round(finPending)),
							String.valueOf(Math.round(finPaid)), expTransList.get(i).getSellBillNo(), flag);

					expTransList.get(i).setExVar2("");
					expTransList.get(i).setExFloat1(0);

				}

			}

			inf.setError(false);
			inf.setMessage("1");
		} catch (Exception e) {

			inf.setError(true);
			inf.setMessage("0");

			System.out.println(
					"restApi Exce for Getting Man GRN Item Conf /getItemsForManGrnByFrAndBill" + e.getMessage());
			e.printStackTrace();
		}

		return inf;
	}

	// pop ups ws of pos

	@RequestMapping("/getAllSellCustBillTodaysBill")
	public @ResponseBody List<SellBillHeader> getAllBillByCustId(@RequestParam int custId, @RequestParam int frId,
			@RequestParam int flag, @RequestParam int tabType) throws ParseException {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		List<SellBillHeader> orderList = new ArrayList<SellBillHeader>();
		System.err.println("tabType*" + tabType);
		Customer cust = new Customer();
		try {
			if (tabType == 1) {
				if (flag == 1) {
					orderList = sellBillHeaderRepository.getSellBillHeader(custId, frId);

				} else if (flag == 2) {
					orderList = sellBillHeaderRepository.getCustBillsPending50(custId, frId);

				}
				cust = customerRepo.findByCustIdAndDelStatus(custId, 0);

				System.err.println("cust is " + cust.toString());
				for (int i = 0; i < orderList.size(); i++) {

					orderList.get(i).setUserName(cust.getCustName());

				}

			}

			else {

				if (flag == 1) {
					orderList = sellBillHeaderRepository.getCustBillsTodays(sf.format(date), frId);
				} else if (flag == 2) {
					orderList = sellBillHeaderRepository.getCustBillsTodaysPending(sf.format(date), frId);
				}

				System.err.println("cust is " + cust.toString());
				for (int i = 0; i < orderList.size(); i++) {
					cust = customerRepo.findByCustIdAndDelStatus(orderList.get(i).getCustId(), 0);

					orderList.get(i).setUserName(cust.getCustName());

				}

			}

		} catch (Exception e) {
			System.out.println("Exc in advanceOrderHistoryHeader" + e.getMessage());
			e.printStackTrace();
		}

		return orderList;

	}

	// DATE
	@RequestMapping("/getAllSellCustBillTodaysBillWithDate")
	public @ResponseBody List<SellBillHeader> getAllSellCustBillTodaysBillWithDate(@RequestParam int custId,
			@RequestParam int frId, @RequestParam int flag, @RequestParam int tabType, @RequestParam String date)
			throws ParseException {

		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");

		List<SellBillHeader> orderList = new ArrayList<SellBillHeader>();
		System.err.println("tabType*" + tabType);
		Customer cust = new Customer();
		try {
			if (tabType == 1) {
				if (flag == 1) {
					orderList = sellBillHeaderRepository.getSellBillHeader(custId, frId);

				} else if (flag == 2) {
					orderList = sellBillHeaderRepository.getCustBillsPending50(custId, frId);

				}
				cust = customerRepo.findByCustIdAndDelStatus(custId, 0);

				System.err.println("cust is " + cust.toString());
				for (int i = 0; i < orderList.size(); i++) {

					orderList.get(i).setUserName(cust.getCustName());

				}

			} else {

				if (flag == 1) {
					orderList = sellBillHeaderRepository.getCustBillsTodays(date, frId);
				} else if (flag == 2) {
					orderList = sellBillHeaderRepository.getCustBillsTodaysPending(date, frId);
				}

				System.err.println("cust is " + cust.toString());
				for (int i = 0; i < orderList.size(); i++) {
					cust = customerRepo.findByCustIdAndDelStatus(orderList.get(i).getCustId(), 0);

					orderList.get(i).setUserName(cust.getCustName());

				}

			}

		} catch (Exception e) {
			System.out.println("Exc in advanceOrderHistoryHeader" + e.getMessage());
			e.printStackTrace();
		}

		return orderList;

	}

	@RequestMapping(value = { "/getAllSellCustBillForCreditNote" }, method = RequestMethod.POST)
	public @ResponseBody List<SellBillHeader> getAllSellCustBillForCreditNote(@RequestParam int custId,
			@RequestParam int frId) throws ParseException {
		System.out.println("getAllSellCustBillForCreditNote" + custId + "   " + frId);
		List<SellBillHeader> orderList = new ArrayList<SellBillHeader>();

		Customer cust = new Customer();
		try {

			orderList = sellBillHeaderRepository.getSellBillHeaderNotInCreditNotePos(custId, frId);

			cust = customerRepo.findByCustIdAndDelStatus(custId, 0);

			System.err.println("cust is " + cust.toString());
			for (int i = 0; i < orderList.size(); i++) {

				orderList.get(i).setUserName(cust.getCustName());

			}

			System.out.println(
					"getAllSellCustBillForCreditNote ---------------------------------------------" + orderList);

		} catch (Exception e) {
			System.out.println("Exc in getAllSellCustBillForCreditNote" + e.getMessage());
			e.printStackTrace();
		}

		return orderList;

	}

	@RequestMapping("/getAllSellCustBillTransaction")
	public @ResponseBody List<TransactionDetail> getAllSellCustBillTransaction(@RequestParam int custId,
			@RequestParam int frId, @RequestParam int tabType) throws ParseException {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		List<TransactionDetail> orderList = new ArrayList<TransactionDetail>();
		System.err.println("tabType*" + sf.format(date));
		try {
			if (tabType == 1) {

				orderList = transactionDetailRepository.getCustBillsTransaction(custId, frId);
			} else {
				orderList = transactionDetailRepository.getCustBillsTransactionToday(frId, sf.format(date));
			}

		} catch (Exception e) {
			System.out.println("Exc in advanceOrderHistoryHeader" + e.getMessage());
			e.printStackTrace();
		}

		return orderList;

	}

	@RequestMapping("/getAllSellCustBillTransactionWithDisc")
	public @ResponseBody List<TransactionDetailWithDisc> getAllSellCustBillTransactionWithDisc(@RequestParam int custId,
			@RequestParam int frId, @RequestParam int tabType, @RequestParam String date) throws ParseException {

		List<TransactionDetailWithDisc> orderList = new ArrayList<TransactionDetailWithDisc>();
		try {
			if (tabType == 1) {

				orderList = transactionDetailWithDiscRepo.getCustBillsTransaction(custId, frId);
			} else {
				orderList = transactionDetailWithDiscRepo.getCustBillsTransactionToday(frId, date);
			}

		} catch (Exception e) {
			System.out.println("Exc in advanceOrderHistoryHeader" + e.getMessage());
			e.printStackTrace();
		}

		return orderList;

	}

	@RequestMapping("/getTotalAdvAmt")
	public @ResponseBody GetTotalAmt getTotalAdvAmt(@RequestParam int frId, @RequestParam String fromDate,
			@RequestParam String toDate) throws ParseException {
		GetTotalAmt amt = new GetTotalAmt();
		try {
			amt = getTotalAmtRepo.getTotalAmount(frId, fromDate, toDate);
		} catch (Exception e) {
			System.out.println("Exc in getTotalAdvAmt" + e.getMessage());
			e.printStackTrace();
		}
		return amt;
	}

	@RequestMapping("/getAllDeletedBillByCustId")
	public @ResponseBody List<SellBillHeader> getAllDeletedBillByCustId(@RequestParam int custId,
			@RequestParam int frId) throws ParseException {

		System.err.println("DELETED BILLS PARAM ---------------------- custId = " + custId + "       frId = " + frId);

		List<SellBillHeader> orderList = new ArrayList<SellBillHeader>();
		Customer cust = new Customer();
		try {
			orderList = sellBillHeaderRepository.getDeletedSellBillHeader(custId, frId);

			cust = customerRepo.findByCustIdAndDelStatus(custId, 0);

			System.err.println("cust is " + cust.toString());
			for (int i = 0; i < orderList.size(); i++) {

				orderList.get(i).setUserName(cust.getCustName());

			}

			System.err.println("DELETED BILLS ---------------------- " + orderList);

		} catch (Exception e) {
			System.out.println("Exc in getAllDeletedBillByCustId" + e.getMessage());
			e.printStackTrace();
		}

		return orderList;

	}

	@RequestMapping("/getDeletedBillAllCust")
	public @ResponseBody List<SellBillHeader> getDeletedBillAllCust(@RequestParam int frId, @RequestParam String date)
			throws ParseException {

		System.err.println("DELETED BILLS PARAM ---------------------- frId = " + frId);

		List<SellBillHeader> orderList = new ArrayList<SellBillHeader>();
		Customer cust = new Customer();
		try {
			orderList = sellBillHeaderRepository.getDeletedSellBillHeaderAllCust(frId, date);

			if (orderList != null) {
				for (int i = 0; i < orderList.size(); i++) {
					cust = customerRepo.findByCustIdAndDelStatus(orderList.get(i).getCustId(), 0);
					orderList.get(i).setUserName(cust.getCustName());
				}
			}

			System.err.println("DELETED BILLS ---------------------- " + orderList);

		} catch (Exception e) {
			System.out.println("Exc in getDeletedBillAllCust" + e.getMessage());
			e.printStackTrace();
		}

		return orderList;

	}

	@RequestMapping(value = { "/deleteBillById" }, method = RequestMethod.POST)
	@ResponseBody
	public Info deleteBillById(@RequestParam int sellBillNo, @RequestParam int status) {

		Info inf = new Info();

		try {

			int del = sellBillHeaderRepository.deleteBill(status, sellBillNo);
			transactionDetailRepository.deleteTransactionDetails(sellBillNo);

			if (del > 0) {
				inf.setError(false);
				inf.setMessage("success");
			} else {
				inf.setError(true);
				inf.setMessage("failed");
			}

		} catch (Exception e) {

			inf.setError(true);
			inf.setMessage("failed");
			e.printStackTrace();
		}

		return inf;
	}

	@RequestMapping(value = { "/deleteBillByIdAddRemark" }, method = RequestMethod.POST)
	@ResponseBody
	public Info deleteBillByIdAddRemark(@RequestParam int sellBillNo, @RequestParam int status,
			@RequestParam String remark) {

		Info inf = new Info();

		try {

			int del = sellBillHeaderRepository.deleteBillWithRemark(status, sellBillNo, remark);
			transactionDetailRepository.deleteTransactionDetails(sellBillNo);

			if (del > 0) {
				inf.setError(false);
				inf.setMessage("success");
			} else {
				inf.setError(true);
				inf.setMessage("failed");
			}

		} catch (Exception e) {

			inf.setError(true);
			inf.setMessage("failed");
			e.printStackTrace();
		}

		return inf;
	}

	// Sachin 26-12-2019
	@RequestMapping(value = { "/getAdvOrdDetailByHeadId" }, method = RequestMethod.POST)
	public @ResponseBody List<AdvanceOrderDetail> getAdvOrdDetailByHeadId(@RequestParam int advHeadId) {
		List<AdvanceOrderDetail> advList = new ArrayList<AdvanceOrderDetail>();

		try {

			advList = advanceOrderDetailRepo.findByAdvHeaderIdAndDelStatus(advHeadId, 0);

		} catch (Exception e) {

			System.out.println("Exce in getAdvOrdDetailByHeadId  " + e.getMessage());
			e.printStackTrace();
		}

		return advList;
	}

	@RequestMapping(value = { "/deleteAdvOrder" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteAdvOrder(@RequestParam int ordHeaderId) {

		Info info = new Info();
		int x = 0;
		try {
			x = advanceOrderHeaderRepo.deleteAdvOrder(ordHeaderId);

			if (x > 0) {
				x = advanceOrderDetailRepo.deleteAdvOrdDetail(ordHeaderId);
			}
			if (x > 0) {
				info.setError(false);
				info.setMessage("success");
			} else {
				info.setError(true);
				info.setMessage("failure");
			}
		} catch (Exception e) {
			info.setError(true);
			info.setMessage("exception");
			System.err.println("Exception in /deleteAdvOrder");
		}

		return info;
	}

	@RequestMapping(value = { "/advOrderHistoryHeaderAdminFdTdFrId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetAdvanceOrderList> advOrderHistoryHeaderAdminFdTdFrId(@RequestParam String fromDate,
			@RequestParam String toDate, @RequestParam int frId) {
		System.err.println("Hi in advOrderHistoryHeaderAdminFdTdFrId");
		List<GetAdvanceOrderList> advList = new ArrayList<GetAdvanceOrderList>();

		try {
			if (frId < 0) {
				advList = getAdvanceOrderListRepo.getAdvOrderListfdTdAllFr(Common.convertToYMD(fromDate),
						Common.convertToYMD(toDate));
			} else {
				advList = getAdvanceOrderListRepo.getAdvOrderListfdTdSpecFr(Common.convertToYMD(fromDate),
						Common.convertToYMD(toDate), frId);
			}
		} catch (Exception e) {
			System.out.println("Exce in advOrderHistoryHeaderAdminFdTdFrId  " + e.getMessage());
			e.printStackTrace();
		}

		return advList;
	}

	@RequestMapping(value = { "/advOrderHistoryHeaderAdminFdTdFrIdForAdminDash" }, method = RequestMethod.POST)
	public @ResponseBody List<AdvOrderForAdminDash> advOrderHistoryHeaderAdminFdTdFrIdForAdminDash(
			@RequestParam String fromDate, @RequestParam String toDate, @RequestParam int frId) {
		System.err.println("Hi in advOrderHistoryHeaderAdminFdTdFrIdForAdminDash");
		List<AdvOrderForAdminDash> advList = new ArrayList<AdvOrderForAdminDash>();

		try {
			if (frId < 0) {
				advList = advOrderForAdminDashRepo.getAdvOrderListfdTdAllFrAdminDash(Common.convertToYMD(fromDate),
						Common.convertToYMD(toDate));
			} else {
				advList = advOrderForAdminDashRepo.getAdvOrderListfdTdSpecFrAdminDash(Common.convertToYMD(fromDate),
						Common.convertToYMD(toDate), frId);
			}
		} catch (Exception e) {
			System.out.println("Exce in advOrderHistoryHeaderAdminFdTdFrIdForAdminDash  " + e.getMessage());
			e.printStackTrace();
		}

		return advList;
	}

	@RequestMapping(value = { "/getAdvOrderHeadList" }, method = RequestMethod.POST)
	public @ResponseBody List<GetAdvanceOrderList> getAdvOrderHeadList(@RequestParam String delDate,
			@RequestParam int frId) {
		System.err.println("Hi in getAdvOrderHeadList delDate " + delDate + "frId" + frId);
		List<GetAdvanceOrderList> advList = new ArrayList<GetAdvanceOrderList>();

		try {
			advList = getAdvanceOrderListRepo.getAdvOrderHeadList(Common.convertToYMD(delDate), frId);
		} catch (Exception e) {
			System.out.println("Exce in advOrderHistoryHeaderAdminFdTdFrId  " + e.getMessage());
			e.printStackTrace();
		}

		return advList;
	}

}
