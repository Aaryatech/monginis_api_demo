package com.ats.webapi.component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import com.ats.webapi.commons.Common;
import com.ats.webapi.commons.EmailUtility;
import com.ats.webapi.commons.Firebase;
import com.ats.webapi.controller.UserUtilApi;
import com.ats.webapi.model.Franchisee;
import com.ats.webapi.model.GetTotalAmt;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.SellBillHeader;
import com.ats.webapi.model.ShopAnivData;
import com.ats.webapi.model.pettycash.GetCashAdvAndExpAmt;
import com.ats.webapi.model.pettycash.PettyCashManagmt;
import com.ats.webapi.model.posdashboard.BillHeaderDashCount;
import com.ats.webapi.model.posdashboard.BillTransactionDetailDashCount;
import com.ats.webapi.model.posdashboard.CreaditAmtDash;
import com.ats.webapi.model.posdashboard.DashAdvanceOrderCounts;
import com.ats.webapi.model.posdashboard.PosDashCounts;
import com.ats.webapi.model.posdashboard.SellBillHeaderDashCounts;
import com.ats.webapi.repo.GetTotalAmtRepo;
import com.ats.webapi.repo.OtherBillDetailAdvRepo;
import com.ats.webapi.repo.PettyCashManagmtRepo;
import com.ats.webapi.repo.SellBillDetailAdvRepo;
import com.ats.webapi.repo.SpCakeAdvRepo;
import com.ats.webapi.repo.posdashboard.BillHeaderDashCountRepo;
import com.ats.webapi.repo.posdashboard.BillTransactionDetailDashCountRepo;
import com.ats.webapi.repo.posdashboard.CreaditAmtDashRepo;
import com.ats.webapi.repo.posdashboard.DashAdvanceOrderCountsRepo;
import com.ats.webapi.repo.posdashboard.SellBillHeaderDashCountsRepo;
import com.ats.webapi.repository.FrAniversaryRepository;
import com.ats.webapi.repository.FranchiseSupRepository;
import com.ats.webapi.repository.FranchiseeRepository;
import com.ats.webapi.repository.GetCashAdvAndExpAmtRepo;
import com.ats.webapi.repository.SellBillHeaderRepository;

@Component
public class ScheduleTask {

	@Autowired
	FranchiseSupRepository franchiseSupRepository;

	@Autowired
	FrAniversaryRepository frAniversaryRepository;

	private static final Logger logger = LoggerFactory.getLogger(ScheduleTask.class);
	private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

	@Scheduled(cron = "0 0 7 * * *")
	public void scheduleTaskWithCronExpression() {
		logger.info("Cron Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));

		List<String> frTokens = franchiseSupRepository.findTokensByBirthdate(new Date());
		logger.info("frTokens" + frTokens);
		List<ShopAnivData> frOPTokens = frAniversaryRepository.findTokensByFrOpeningDate(new Date());
		logger.info("frOPTokens" + frOPTokens);
		// -----------------------For Notification-----------------

		if (!frTokens.isEmpty()) {

			try {
				for (String token : frTokens) {
					Firebase.sendPushNotifForCommunication(token, "HAPPY BIRTHDAY",
							"Team Monginis wishes you a very happy birthday and many many happy returns of the day.",
							"inbox");
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
		if (!frOPTokens.isEmpty()) {

			try {
				for (ShopAnivData token : frOPTokens) {
					Firebase.sendPushNotifForCommunication(token.getToken(), "Shop Anniversary",
							"Congratulations on successful completion of " + token.getNoOfYears()
									+ "years with Monginis. Thank you for being part of our family. Team Monginis",
							"inbox");
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
		// -----------------------------------------------------
	}

	@Scheduled(cron = "0 0 6 1 * ?")
	public void scheduleTaskWithCronExpressionOnMonthStart() {
		logger.info("Cron Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));

		List<String> frTokens = franchiseSupRepository.findTokens();

		if (!frTokens.isEmpty()) {

			try {
				for (String token : frTokens) {
					Firebase.sendPushNotifForCommunication(token, "Close Your Month",
							"Since today is first day of the month, please close the last month in your software.",
							"inbox");
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}

	}

	// ------------PETTY CASH------------------------

	@Autowired
	FranchiseeRepository franchiseeRepository;

	@Autowired
	GetTotalAmtRepo getTotalAmtRepo;

	@Autowired
	GetCashAdvAndExpAmtRepo getCashAdvAndExpAmtRepo;

	@Autowired
	PettyCashManagmtRepo pettyRepo;

	@Autowired
	SpCakeAdvRepo spRepo;

	@Autowired
	SellBillDetailAdvRepo sellBillRepo;

	@Autowired
	OtherBillDetailAdvRepo otherBillRepo;

	@Autowired
	SellBillHeaderRepository sellBillHeaderRepository;

	// Petty Cash Day End Process every morning 6.00 am

	@Scheduled(cron = "0 0 7 * * *")
	//@Scheduled(cron = "2 * * * * *")
	public void crownForPettyCashDayEnd() {

		List<Franchisee> franchisee = new ArrayList<Franchisee>();
		franchisee = franchiseeRepository.findAllByDelStatusOrderByFrNameAsc(0);

		if (franchisee != null) {

			for (int j = 0; j < franchisee.size(); j++) {

				Franchisee fr = franchisee.get(j);
				System.err.println("FRA ------------------" + fr);

				int empId = 0;
				try {
					SellBillHeader res = sellBillHeaderRepository.getLastBillHeaderByFrId(fr.getFrId());
					if (res != null) {
						empId = res.getExtInt1();
					}
				} catch (Exception e) {
					e.printStackTrace();
					empId = 0;
				}

				System.err.println("EMP ID = " + empId + "    FOR - FR =" + fr.getFrId());

				PettyCashManagmt petty = new PettyCashManagmt();
				try {

					petty = pettyRepo.findByFrIdAndStatusLimit1(fr.getFrId(), 0);
					System.err.println("OLD PETTY CASH ENTRY = " + petty);

					Calendar cal = Calendar.getInstance();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String date = sdf.format(cal.getTime());

					if (petty != null) {

						cal = Calendar.getInstance();

						cal.setTime(petty.getDate());

						// Add 1 day
						cal.add(Calendar.DAY_OF_MONTH, 1);
						date = sdf.format(cal.getTime());

					}

					GetCashAdvAndExpAmt data = new GetCashAdvAndExpAmt();
					data = getCashAdvAndExpAmtRepo.getAmt(fr.getFrId(), date);

					GetTotalAmt creditNoteAmt = new GetTotalAmt();
					creditNoteAmt = getTotalAmtRepo.getTotalPOSCreditNoteAmt(fr.getFrId(), date);

					float creditNtAmt = 0;
					if (creditNoteAmt != null) {
						creditNtAmt = creditNoteAmt.getTotalAmt();
					}

					if (petty != null) {
						petty.setTotalAmt(data.getTrCashAmt() + data.getAdvAmt() - data.getExpAmt() - creditNtAmt);
					}

					Calendar cal2 = Calendar.getInstance();

					System.err.println("DATE 1 --------------------- " + sdf.format(cal.getTime()));
					System.err.println("DATE 2 --------------------- " + sdf.format(cal2.getTime()));

					if (cal.compareTo(cal2) <= 0) {

						String d1 = sdf.format(cal.getTime());
						String d2 = sdf.format(cal2.getTime());

						if (!d1.equalsIgnoreCase(d2)) {

							PettyCashManagmt pettycash = new PettyCashManagmt();

							float cashAmt = 0;
							float closAmt = 0;
							float withdrawAmt = 0;
							float opnAmt = 0;
							float cashEdtAmt = 0;
							try {
								if (petty != null) {
									cashAmt = petty.getTotalAmt();
									withdrawAmt = cashAmt;
									opnAmt = petty.getClosingAmt();
									cashEdtAmt = petty.getCashAmt();
									closAmt = opnAmt + cashAmt - withdrawAmt;
								}
							} catch (Exception e) {
								e.printStackTrace();
							}

							SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
							Calendar cal1 = Calendar.getInstance();

							pettycash.setPettycashId(0);
							pettycash.setCardAmt(0);
							pettycash.setCashAmt(cashAmt);
							pettycash.setClosingAmt(closAmt);
							pettycash.setDate(sdf.parse(date));
							pettycash.setExFloat1(0);
							pettycash.setExInt1(empId);
							pettycash.setExVar1("" + sdf1.format(cal1.getTime()));
							pettycash.setExVar2("NA");
							pettycash.setFrId(fr.getFrId());
							pettycash.setOpeningAmt(opnAmt);
							pettycash.setCardEditAmt(0);
							pettycash.setTtlEditAmt(0);
							pettycash.setOtherAmt(0);
							pettycash.setStatus(0);
							pettycash.setTotalAmt(0);
							pettycash.setTtlEditAmt(0);
							pettycash.setWithdrawalAmt(withdrawAmt);
							pettycash.setOpnEditAmt(0);
							pettycash.setCashEditAmt(cashEdtAmt);
							pettycash.setExFloat1(0);

							System.err.println("SAVE PETTY CASH = " + pettycash);

							PettyCashManagmt cash = new PettyCashManagmt();
							try {
								cash = pettyRepo.save(pettycash);
								if (cash != null) {

									String senderEmail = UserUtilApi.senderEmail;
									String senderPassword = UserUtilApi.senderPassword;

									// Franchisee frDetails = franchiseeRepository.findOne(fr.getFrId());

									String fromDate = sdf.format(cal.getTime());
									String toDate = sdf.format(cal.getTime());

									PosDashCounts posDetails = getPosDashData(fromDate, toDate, fr.getFrId(),
											fr.getFrRateCat());
									System.out.println("POS Details----------" + posDetails);

									if (posDetails != null) {

										String msg = "Total summary for (" + fr.getFrCode() + ") at ("
												+ Common.convertToDMY(fromDate) + ")\n" + "E-Pay - ("
												+ posDetails.getEpayAmt() + ")\n" + "Cash - (" + posDetails.getCashAmt()
												+ ")\n" + "Card - (" + posDetails.getCardAmt() + ")\n" + "Sales - ("
												+ posDetails.getSaleAmt() + ")\n" + "Discount - ("
												+ posDetails.getDiscountAmt() + ")\n" + "Purchase  - ("
												+ posDetails.getPurchaseAmt() + ")\n" + "Advance - ("
												+ posDetails.getAdvanceAmt() + ")\n" + "Credit Bill - ("
												+ posDetails.getCreditAmt() + ")\n" + "Expenses - ("
												+ posDetails.getExpenseAmt() + ")";

										String mailSubject = "Total summary for (" + fr.getFrCode() + ") at ("
												+ Common.convertToDMY(fromDate) + ")";
										String defPass = "";

										System.err.println("Send Mail---------" + fr.getFrId() + " " + fr.getFrCode()
												+ " " + fromDate + " - " + toDate);
										Info info = EmailUtility.sendEmail(senderEmail, senderPassword, fr.getFrEmail(),
												mailSubject, msg, defPass);

										if (info.isError() == false) {
											EmailUtility.send(fr.getFrMob(), msg);
										}

									}
								}

							} catch (Exception e) {
								System.err.println("Exception in addPettyCash : " + e.getMessage());
								e.printStackTrace();
							}

						}

					}

				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		}

	}

	/*****************************************************************/
	@Autowired
	SellBillHeaderDashCountsRepo sellBillHeaderDashCountsRepo;

	@Autowired
	BillTransactionDetailDashCountRepo billTransactionDetailDashCountRepo;

	@Autowired
	BillHeaderDashCountRepo billHeaderDashCountRepo;

	@Autowired
	CreaditAmtDashRepo creaditAmtDashRepo;

	@Autowired
	DashAdvanceOrderCountsRepo dashAdvanceOrderCountsRepo;

	public PosDashCounts getPosDashData(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("frId") int frId,
			@RequestParam("frRateCat") int frRateCat) {

		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Asia/Calcutta"));
		Date date = calendar.getTime();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String currentDate = df.format(date);
		PosDashCounts crnReport = new PosDashCounts();

		SellBillHeaderDashCounts headcount = new SellBillHeaderDashCounts();
		BillTransactionDetailDashCount tranCount = new BillTransactionDetailDashCount();
		BillHeaderDashCount billCountch = new BillHeaderDashCount();
		BillHeaderDashCount billCountpur = new BillHeaderDashCount();
		CreaditAmtDash daseqe = new CreaditAmtDash();

		List<DashAdvanceOrderCounts> dailyList = new ArrayList<DashAdvanceOrderCounts>();
		List<DashAdvanceOrderCounts> advOrderList = new ArrayList<DashAdvanceOrderCounts>();

		System.err.println("PARAM ------ " + fromDate + "       " + toDate + "         " + frId);

		System.err.println("DashBoardReporApi data is " + fromDate + toDate + frId);
		try {

			try {
				headcount = sellBillHeaderDashCountsRepo.getDataFordash(fromDate, toDate, frId);
			} catch (Exception e) {
				e.getMessage();
			}

			try {
				tranCount = billTransactionDetailDashCountRepo.getD1ataFordash(fromDate, toDate, frId);
			} catch (Exception e) {
				e.getMessage();
			}

			try {
				billCountch = billHeaderDashCountRepo.getD1ataFordash2Ch(fromDate, toDate, frId);
			} catch (Exception e) {
				e.getMessage();
			}

			try {
				billCountpur = billHeaderDashCountRepo.getD1ataFordash2pur(fromDate, toDate, frId);
			} catch (Exception e) {
				e.getMessage();
			}

			try {
				daseqe = creaditAmtDashRepo.getDataFordash(fromDate, toDate, frId);
			} catch (Exception e) {
				e.getMessage();
			}

			try {
				dailyList = dashAdvanceOrderCountsRepo.getAdvDetail(currentDate, frId, 2);
			} catch (Exception e) {
				e.getMessage();
			}

			try {
				advOrderList = dashAdvanceOrderCountsRepo.getAdvDetail(currentDate, frId, 1);
			} catch (Exception e) {
				e.getMessage();
			}

			System.err.println("DashBoardReporApi ***" + daseqe.toString());
			crnReport.setDailyMartList(dailyList);
			crnReport.setAdvOrderList(advOrderList);

			System.err.println("PURCHASE ====================== " + billCountpur);

			GetTotalAmt getAdvAmt = getTotalAmtRepo.getTotalAmount(frId, fromDate, toDate);
			float advAmt = 0;
			if (getAdvAmt != null) {
				advAmt = getAdvAmt.getTotalAmt();
			}

			GetTotalAmt getProfitAmt = getTotalAmtRepo.getTotalProfit(frId, fromDate, toDate);
			float profitAmt = 0;
			if (getProfitAmt != null) {
				profitAmt = getProfitAmt.getTotalAmt();
			}

			crnReport.setProfitAmt((int) profitAmt);

			// System.err.println( "DashBoardReporApi /tranCount" + tranCount.toString());
			// System.err.println( "DashBoardReporApi /billCountch" +
			// billCountch.toString());
			// System.err.println( "DashBoardReporApi /billCountpur" +
			// billCountpur.toString());

			// crnReport.setAdvanceAmt(headcount.getAdvanceAmt());
			crnReport.setAdvanceAmt(advAmt);

			if (tranCount.getCardAmt() == "" || tranCount.getCardAmt() == null) {
				crnReport.setCardAmt(0);
			} else {
				crnReport.setCardAmt(Float.parseFloat(tranCount.getCardAmt()));
			}
			if (tranCount.getCashAmt() == "" || tranCount.getCashAmt() == null) {
				crnReport.setCashAmt(0);
			} else {
				crnReport.setCashAmt(Float.parseFloat(tranCount.getCashAmt()));
			}

			if (tranCount.getePayAmt() == "" || tranCount.getePayAmt() == null) {
				crnReport.setEpayAmt(0);
			} else {
				crnReport.setEpayAmt(Float.parseFloat(tranCount.getePayAmt()));
			}

			if (daseqe.getCreditAmt() == "" || daseqe.getCreditAmt() == null) {
				crnReport.setCreditAmt(0);
			} else {
				// crnReport.setEpayAmt(Float.parseFloat(tranCount.getePayAmt()));
				crnReport.setCreditAmt(Float.parseFloat(daseqe.getCreditAmt()));
			}

			crnReport.setDiscountAmt(headcount.getDiscAmt());

			crnReport.setNoOfBillGenerated(headcount.getNoBillGen());
			crnReport.setSaleAmt(headcount.getSellAmt());

			// crnReport.setProfitAmt(headcount.getProfitAmt());

			try {
				crnReport.setPurchaseAmt(Float.parseFloat(billCountpur.getPurchaeAmt()));
			} catch (Exception e) {
				crnReport.setPurchaseAmt(0);
			}
			/*
			 * if (billCountpur.getPurchaeAmt() == "" || billCountpur.getPurchaeAmt() ==
			 * null || billCountpur.getPurchaeAmt() == "0") { crnReport.setPurchaseAmt(0); }
			 * else {
			 * crnReport.setPurchaseAmt(Float.parseFloat(billCountpur.getPurchaeAmt())); }
			 */

			if (billCountch.getChAmt() == "" || billCountch.getChAmt() == null || billCountch.getChAmt() == "0") {
				crnReport.setExpenseAmt(0);
			} else {
				crnReport.setExpenseAmt(Float.parseFloat(billCountch.getChAmt()));
			}

			System.err.println("DashBoardReporApi /getCredNoteReport" + crnReport.toString());

		} catch (Exception e) {

			System.err.println("Exception in DashBoardReporApi /getCredNoteReport" + e.getMessage());

			e.printStackTrace();
		}

		return crnReport;
	}

}
