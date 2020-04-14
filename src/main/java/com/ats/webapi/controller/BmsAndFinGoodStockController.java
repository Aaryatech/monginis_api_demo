package com.ats.webapi.controller;

import java.util.ArrayList;
import java.util.Calendar;
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
import com.ats.webapi.model.BmsStockHeader;
import com.ats.webapi.model.FrItemStockConfigure;
import com.ats.webapi.model.FrItemStockConfigureList;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.stock.FinishedGoodStock;
import com.ats.webapi.model.stock.FinishedGoodStockDetail;
import com.ats.webapi.model.stock.GetBmsCurrentStock;
import com.ats.webapi.model.stock.GetBmsCurrentStockList;
import com.ats.webapi.model.stock.GetCurProdAndBillQty;
import com.ats.webapi.model.stock.GetCurProdAndBillQtyList;
import com.ats.webapi.model.stock.GetCurrentBmsSFStock;
import com.ats.webapi.model.stock.GetCurrentBmsSFStockList;
import com.ats.webapi.model.stock.UpdateBmsSfStock;
import com.ats.webapi.model.stock.UpdateBmsSfStockList;
import com.ats.webapi.model.stock.UpdateBmsStock;
import com.ats.webapi.model.stock.UpdateBmsStockList;
import com.ats.webapi.repository.bmsstock.CurrentBmsSFStockRepo;
import com.ats.webapi.repository.bmsstock.FinishedGoodStockDetailRepo;
import com.ats.webapi.repository.bmsstock.FinishedGoodStockRepo;
import com.ats.webapi.repository.bmsstock.GetCurProdAndBillQtyRepo;
import com.ats.webapi.repository.bmsstock.GetCurrentBmsStockRepo;
import com.ats.webapi.repository.bmsstock.UpdateBmsSfStockRepo;
import com.ats.webapi.repository.bmsstock.UpdateBmsStockRepo;
import com.ats.webapi.service.FrItemStockConfigureService;

@RestController
public class BmsAndFinGoodStockController {

	private static final String bmsDeptId = null;

	@Autowired
	GetCurrentBmsStockRepo currentBmsStockRepo;

	@Autowired
	FrItemStockConfigureService frItemStockConfigureService;

	@Autowired
	FinishedGoodStockRepo finishedGoodStockRepo;

	@Autowired
	FinishedGoodStockDetailRepo finishedGoodStockDetailRepo;

	@Autowired
	GetCurProdAndBillQtyRepo getCurProdAndBillQtyRepo;
	
	
	
	@Autowired
	CurrentBmsSFStockRepo currentBmsSFStockRepo;
	
	//7feb 
	@Autowired
	UpdateBmsStockRepo updateBmsStockRepo;
	
	@Autowired
	UpdateBmsSfStockRepo updateBmsSfStockRepo;
	
	@RequestMapping(value = { "/updateBmsStockForRM" }, method = RequestMethod.POST)
	public @ResponseBody Info updateBmsStock(@RequestBody  UpdateBmsStockList rmUpdate) {
		int updateBmsRmResponse=0;
		
		Info info=new Info();
		try {
			
			for(int i=0;i<rmUpdate.getBmsStock().size();i++) {
				
				
				UpdateBmsStock stock=rmUpdate.getBmsStock().get(i);
		
				updateBmsRmResponse=updateBmsStockRepo.updateBmsRmStock(stock.getBmsStockId(), stock.getProdIssueQty(), stock.getProdRejectedQty(),
						
				 stock.getProdReturnQty(), stock.getMixingIssueQty(), stock.getMixingRejectedQty(), stock.getMixingReturnQty(), stock.getStoreIssueQty(), 
				 stock.getStoreRejectedQty(), stock.getBmsClosingStock(), stock.getRmId(), stock.getMixingReceiveRejectedQty(), stock.getMixingRecQty());
			}
			
		 if(updateBmsRmResponse>0) {
			 info.setError(false);
			 info.setMessage("success updating RM Bms Stock ");
		 }
		}catch (Exception e) {
		System.out.println("Exce in Bms Stock Update Process for RM  "+e.getMessage());
		e.printStackTrace();
		}
		
		return info;
	}
	
	
	@RequestMapping(value = { "/updateBmsStockForSF" }, method = RequestMethod.POST)
	public @ResponseBody Info updateBmsStockForSf(@RequestBody UpdateBmsSfStockList sfUpdate) {
		int updateBmsSfResponse=0;
		
		Info info=new Info();
		try {
			
			for(int i=0;i<sfUpdate.getBmsSfStock().size();i++) {
				
				UpdateBmsSfStock bmsSf=sfUpdate.getBmsSfStock().get(i);
				updateBmsSfResponse=updateBmsSfStockRepo.updateBmsSfStock(bmsSf.getBmsStockId(), bmsSf.getProdIssueQty(), bmsSf.getProdRejectedQty(), bmsSf.getProdReturnQty(), bmsSf.getMixingIssueQty(), bmsSf.getMixingRejectedQty(), bmsSf.getBmsClosingStock(), bmsSf.getSfId());
				
				if(updateBmsSfResponse>0) {
					info.setError(false);
					info.setMessage("sf Update Success ");
				}
			}
		}catch (Exception e) {
		System.out.println("Exce in Bms Stock Update Process for SF "+e.getMessage());
		e.printStackTrace();
		}
		
		return info;
	}
	
	
	
	/*self Query 
	 //Get BMS Stock Bet Date
	 
	 SELECT d.bms_stock_deatil_id,d.bms_stock_id,d.bms_stock_date, d.rm_name,d.rm_id,d.rm_uom,d.rm_type, SUM(f.bms_opening_stock) AS OPQTY,SUM(t.closing_qty) AS CLOQTY,
SUM(t.store_rec_qty) as storeRecQty,
SUM(t.store_rejected_qty) as storeRejectedQty,
SUM(t.mixing_rec_qty) as mixingRecQty,
SUM(t.mixing_receive_rejected_qty) as mixingReceiveRejectedQty,
SUM(t.mixing_issue_qty) as mixingIssueQty,
SUM(t.mixing_return_qty) as mixingReturnQty,
SUM(t.mixing_rejected) as mixingRejected,
SUM(t.prod_issue_qty) as prodIssueQty,
SUM(t.prod_rejected_qty) as prodRejectedQty,
SUM(t.prod_return_qty) as prodReturnQty
 FROM 
t_bms_stock_details d,t_bms_stock_details f,t_bms_stock_details t ,t_bms_stock h1,t_bms_stock h2,t_bms_stock h3
WHERE h1.bms_stock_id=d.bms_stock_id AND h2.bms_stock_id=f.bms_stock_id AND h3.bms_stock_id=t.bms_stock_id
AND h1.bms_stock_date BETWEEN '2018-01-01' AND '2018-01-26' AND h2.bms_stock_date='2018-01-01' AND h3.bms_stock_date='2018-01-26' AND 
h1.bms_status=1
	 
	 */
//changed on 5 Feb 
	@RequestMapping(value = { "/getCurentBmsStockRM" }, method = RequestMethod.POST)
	public @ResponseBody GetBmsCurrentStockList getCurrentBmsStockListRM(@RequestParam("prodDeptId") int prodDeptId,
			@RequestParam("mixDeptId") int mixDeptId, @RequestParam("bmsDeptId") int bmsDeptId, @RequestParam("stockDate") String stockDate) {
		
		System.out.println("Inside Get bms current stock get web Service");
	
		Info info = new Info();

		//java.sql.Date cDate = new java.sql.Date(Calendar.getInstance().getTime().getTime()); 
		
		
		java.sql.Date cDate=Common.convertToSqlDate(stockDate);
		System.out.println("Input received for BMS Current Stock for RM ");
		System.out.println("Current Date"+cDate + "prod Dept Id"+prodDeptId+"mixDept Id"+mixDeptId+ "bmsDeptId Id "+bmsDeptId);

		GetBmsCurrentStockList bmsStockList = new GetBmsCurrentStockList();
		try {

			List<GetBmsCurrentStock> bmsCurrentStock = currentBmsStockRepo.getBmsCurStockForRM(cDate, prodDeptId, mixDeptId,
					bmsDeptId);

			if (!bmsCurrentStock.isEmpty()) {

				info.setError(false);
				info.setMessage("success getting bms current stock list RM ");

				bmsStockList.setBmsCurrentStock(bmsCurrentStock);
			} else {

				info.setError(true);
				info.setMessage("Error getting bms current  stock list for rm ");

			}

			bmsStockList.setInfo(info);
			System.out.println("Stock List BMS Current Stock for RM   " + bmsStockList.toString());

		} catch (Exception e) {

			System.out.println("Exc in Getting Current BMS stock List for RM  " + e.getMessage());
			e.printStackTrace();
		}
		
		
		return bmsStockList;
	}
	
	
	@RequestMapping(value = { "/getBmsStockRMBetDate" }, method = RequestMethod.POST)
	public @ResponseBody GetBmsCurrentStockList getCurrentBmsStocRMBetDate(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {
		
		System.out.println("Inside Get bms current stock get web Service");
	
		Info info = new Info();

		java.sql.Date cDate = new java.sql.Date(Calendar.getInstance().getTime().getTime()); 
		
		System.out.println("Input received for BMS Current Stock for RM bet date ");
		
		GetBmsCurrentStockList bmsStockList = new GetBmsCurrentStockList();
		try {
			
			Date fDate=Common.convertToSqlDate(fromDate);
			Date tDate=Common.convertToSqlDate(toDate);

			List<GetBmsCurrentStock> bmsCurrentStock = currentBmsStockRepo.getBmsCurStockForRMBetDate(fDate, tDate);

			if (!bmsCurrentStock.isEmpty()) {

				info.setError(false);
				info.setMessage("success getting bms current stock list RM bet date ");

				bmsStockList.setBmsCurrentStock(bmsCurrentStock);
			} else {

				info.setError(true);
				info.setMessage("Error getting bms current  stock list for rm  bet Date");

			}

			bmsStockList.setInfo(info);
			System.out.println("Stock List BMS Current Stock for RM  bet Date " + bmsStockList.toString());

		} catch (Exception e) {

			System.out.println("Exc in Getting Current BMS stock List for RM bet Date  " + e.getMessage());
			e.printStackTrace();
		}
		
		
		return bmsStockList;
	}
	
	
	@RequestMapping(value = { "/getCurentBmsStockSF" }, method = RequestMethod.POST)
	public @ResponseBody GetCurrentBmsSFStockList getCurrentBmsStockListSF(@RequestParam("prodDeptId") int prodDeptId,@RequestParam("stockDate") String stockDate) {
		
		System.out.println("Inside Get bms current stock SF  get web Service");
	
		Info info = new Info();

		java.sql.Date cDate = Common.convertToSqlDate(stockDate);
		System.out.println("Input received for BMS Current Stock for SF ");
		System.out.println("Current Date"+cDate + "prod Dept Id"+prodDeptId);

		GetCurrentBmsSFStockList bmsStockList = new GetCurrentBmsSFStockList();
		try {

			List<GetCurrentBmsSFStock> bmsCurrentStock = currentBmsSFStockRepo.getBmsCurStockForSF(cDate, prodDeptId);
		
			if (!bmsCurrentStock.isEmpty()) {

				info.setError(false);
				info.setMessage("success getting bms current stock list SF");

				bmsStockList.setCurrentBmsSFStock(bmsCurrentStock);
			} else {

				info.setError(true);
				info.setMessage("Error getting bms current  stock list for SF ");

			}

			bmsStockList.setInfo(info);
			System.out.println("Stock List BMS Current Stock for SF   " + bmsStockList.toString());

		} catch (Exception e) {

			System.out.println("Exc in Getting Current BMS stock List for SF  " + e.getMessage());
			e.printStackTrace();
		}
		
		
		return bmsStockList;
	}
	//BMS Stock between date Same finish (sf)//6 feb 2018
	@RequestMapping(value = { "/getBmsStockSFBetDate" }, method = RequestMethod.POST)
	public @ResponseBody GetCurrentBmsSFStockList getBmsStockSFBetDate(@RequestParam("fromDate") String fromDate,@RequestParam("toDate") String toDate) {
		
		System.out.println("Inside Get bms current stock get web Service");
	
		Info info = new Info();

		
		GetCurrentBmsSFStockList bmsStockList = new GetCurrentBmsSFStockList();
		try {
			
			Date fDate=Common.convertToSqlDate(fromDate);
			Date tDate=Common.convertToSqlDate(toDate);

			List<GetCurrentBmsSFStock> bmsCurrentStock = currentBmsSFStockRepo.getBmsStockForSFBetDate(fDate, tDate);
			if (!bmsCurrentStock.isEmpty()) {

				info.setError(false);
				info.setMessage("success getting bms current stock list SF bet Date");

				bmsStockList.setCurrentBmsSFStock(bmsCurrentStock);
			} else {

				info.setError(true);
				info.setMessage("Error getting bms current  stock list for SF bet Date");

			}

			bmsStockList.setInfo(info);
			System.out.println("Stock List BMS Current Stock for SF bet Date   " + bmsStockList.toString());

		} catch (Exception e) {

			System.out.println("Exc in Getting Current BMS stock List for SF Bet Date " + e.getMessage());
			e.printStackTrace();
		}
		
		
		return bmsStockList;
	}


	@RequestMapping(value = { "/getDeptSettingValue" }, method = RequestMethod.POST)
	public @ResponseBody FrItemStockConfigureList getSeetingValueOfDept(
			@RequestParam("settingKeyList") List<String> settingKeyList) {

		System.out.println("input para " + settingKeyList.toString());
		FrItemStockConfigureList settingList = frItemStockConfigureService.findBySettingKeyList(settingKeyList);

		return settingList;
	}

	@RequestMapping(value = { "/insertFinishedGoodOpStock" }, method = RequestMethod.POST)
	public @ResponseBody Info insertBmsStock(@RequestBody FinishedGoodStock finishedGoodStockHeader) {

		Info info = new Info();

		try {

			FinishedGoodStock finGood = finishedGoodStockRepo.save(finishedGoodStockHeader);

			List<FinishedGoodStockDetail> finishedGoodStockDetail = finishedGoodStockHeader
					.getFinishedGoodStockDetail();

			int stockId = finGood.getFinStockId();

			for (int i = 0; i < finishedGoodStockDetail.size(); i++) {

				FinishedGoodStockDetail stockDetail = finishedGoodStockDetail.get(i);
				stockDetail.setFinStockId(stockId);

				FinishedGoodStockDetail stockDetailResponse = finishedGoodStockDetailRepo.save(stockDetail);

			}
			if (finGood != null) {
				info.setError(false);
				info.setMessage("Success: Inserted Fin Good Op Stock");

			}

		} catch (Exception e) {

			System.out.println("Exce in Finished good OP Stock  Insert " + e.getMessage());
			e.printStackTrace();

			info.setError(true);
			info.setMessage("Error: Inserting Fin Good Op Stock");

		}

		return info;

	}

	@RequestMapping(value = { "/getCurrentProdAndBillQty" }, method = RequestMethod.POST)
	public @ResponseBody GetCurProdAndBillQtyList getCurrentProdAndBillQty(@RequestParam("prodDate") String prodDate,
			@RequestParam("catId") int catId, @RequestParam("delStatus") int delStatus, @RequestParam("timestamp") String timestamp,
			@RequestParam("curTimeStamp") String curTimeStamp) {

		Info info = new Info();
		
		System.out.println("Date Received "+prodDate);
		
		GetCurProdAndBillQtyList curProdAndBillList = new GetCurProdAndBillQtyList();

		try {

			List<GetCurProdAndBillQty> getCurProdAndBillQty = getCurProdAndBillQtyRepo.getCurProdAndBillQty(prodDate,
					catId, delStatus,timestamp,curTimeStamp);
			if (!getCurProdAndBillQty.isEmpty()) {

				info.setError(false);
				info.setMessage("success stock list ");

				curProdAndBillList.setGetCurProdAndBillQty(getCurProdAndBillQty);
			} else {

				info.setError(true);
				info.setMessage("Error in Getting cur Prod And Bill Qty list- size = " + getCurProdAndBillQty.size());

			}

			curProdAndBillList.setInfo(info);

		} catch (Exception e) {

			System.out.println("Exc in Getting cur Prod And Bill Qty list " + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("Stock List BMS curProdAndBillList " + curProdAndBillList.toString());
		return curProdAndBillList;
	}

	
	//All Category
	@RequestMapping(value = { "/getCurrentProdAndBillQtyAllCat" }, method = RequestMethod.POST)
	public @ResponseBody GetCurProdAndBillQtyList getCurrentProdAndBillQtyAllCat(@RequestParam("prodDate") String prodDate,
			 @RequestParam("delStatus") int delStatus,@RequestParam("timestamp") String timestamp,
			 @RequestParam("curTimeStamp") String curTimeStamp) {

		Info info = new Info();
		
		System.out.println("Date Received "+prodDate);
		
		GetCurProdAndBillQtyList curProdAndBillList = new GetCurProdAndBillQtyList();

		try {

			List<GetCurProdAndBillQty> getCurProdAndBillQty = getCurProdAndBillQtyRepo.getCurProdAndBillQtyAllCat(prodDate,
					 delStatus,timestamp,curTimeStamp);
			if (!getCurProdAndBillQty.isEmpty()) {

				info.setError(false);
				info.setMessage("success stock list ");

				curProdAndBillList.setGetCurProdAndBillQty(getCurProdAndBillQty);
			} else {

				info.setError(true);
				info.setMessage("Error in Getting cur Prod And Bill Qty lis All Cat - size = " + getCurProdAndBillQty.size());

			}

			curProdAndBillList.setInfo(info);

		} catch (Exception e) {

			System.out.println("Exc in Getting cur Prod And Bill Qty list  All Cate" + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("Stock List BMS curProdAndBillList" + curProdAndBillList.toString());
		return curProdAndBillList;
	}
	@RequestMapping(value = { "/getFinGoodStockHeader" }, method = RequestMethod.POST)
	public @ResponseBody FinishedGoodStock getFinGoodStockHeader(@RequestParam("stockStatus") int stockStatus) {

		FinishedGoodStock finishHeader =new FinishedGoodStock();

		try {

			finishHeader = finishedGoodStockRepo.findByFinGoodStockStatus(stockStatus);

		} catch (Exception e) {

			System.out.println("Exce in getting Finished Good Stock Header " + e.getMessage());
			e.printStackTrace();

		}
		if(finishHeader!=null)
	System.out.println("output finished Good Header = "+finishHeader.toString());
		return finishHeader;

	}
	
	
	@RequestMapping(value = { "/getFinGoodStockHeaderByDate" }, method = RequestMethod.POST)
	public @ResponseBody FinishedGoodStock getFinGoodStockHeaderbyDate(@RequestParam("stockDate") String StockDate) {

		FinishedGoodStock finishHeader = new FinishedGoodStock();

		try {
				Date stkDate=Common.convertToSqlDate(StockDate);
			finishHeader = finishedGoodStockRepo.findByFinGoodStockDate(stkDate);
		} catch (Exception e) {

			System.out.println("Exce in getting Finished Good Stock Header " + e.getMessage());
			e.printStackTrace();

		}
		
		System.out.println("output finished Good Header = "+finishHeader.toString());
		return finishHeader;

	}
	
	
	
	@RequestMapping(value = { "/getFinGoodStockDetail" }, method = RequestMethod.POST)
	public @ResponseBody List<FinishedGoodStockDetail> getFinGoodStockDetail(@RequestParam("stockDate") String stockDate,@RequestParam("catId")int catId) {

		List<FinishedGoodStockDetail> finishedGoodStockDetail=new ArrayList<FinishedGoodStockDetail>();
		try {
						System.out.println("date received for Stock Detail "+stockDate);
						
						System.out.println("cat Id  received for Stock Detail "+catId);
						
			
			Date stkDate= Common.convertToSqlDate(stockDate);
			
			System.out.println("date After convert for Stock Detail "+stkDate);

			finishedGoodStockDetail=finishedGoodStockDetailRepo.findByStockDateAndCatId(stkDate,catId);
		} catch (Exception e) {
			
			System.out.println("Exce in getting Finished Good Stock Detail By Date " + e.getMessage());
			e.printStackTrace();

		}
		
	System.out.println("output finished Good Detail  = "+finishedGoodStockDetail.toString());
		return finishedGoodStockDetail;

	}
	
	//getFinGoodStockDetail all Category
	@RequestMapping(value = { "/getFinGoodStockDetailAllCat" }, method = RequestMethod.POST)
	public @ResponseBody List<FinishedGoodStockDetail> getFinGoodStockDetailAllCat(@RequestParam("stockDate") String stockDate) {

		List<FinishedGoodStockDetail> finishedGoodStockDetail=new ArrayList<>();
		try {
						System.out.println("date received for Stock Detail "+stockDate);
			
			Date stkDate= Common.convertToSqlDate(stockDate);
			
			System.out.println("date After convert for Stock Detail "+stkDate);

			finishedGoodStockDetail=finishedGoodStockDetailRepo.findByStockDate(stkDate);
		} catch (Exception e) {
			
			System.out.println("Exce in getting Finished Good Stock Detail By Date " + e.getMessage());
			e.printStackTrace();

		}
		
	System.out.println("output finished Good Detail  = "+finishedGoodStockDetail.toString());
		return finishedGoodStockDetail;

	}

	//Final Query For Fin good Stock bet two Date 3 Feb 
	
	@RequestMapping(value = { "/getFinGoodStockBetTwoDate" }, method = RequestMethod.POST)
	public @ResponseBody List<FinishedGoodStockDetail> getFinGoodStockBetTwoDate(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {

		List<FinishedGoodStockDetail> finishedGoodStockDetail=new ArrayList<FinishedGoodStockDetail>();
		try {
			
			System.out.println("date received for Stock Detail bet date = "+fromDate);
			
		java.sql.Date stkFrDate= Common.convertToSqlDate(fromDate);
			
			java.sql.Date stkToDate= Common.convertToSqlDate(toDate);
			
			System.out.println("date After convert for Stock Detail bet date stkFrDate= "+stkFrDate);
			
			System.out.println("date After convert for Stock Detail bet date  stkToDate= "+stkToDate);
			

			finishedGoodStockDetail=finishedGoodStockDetailRepo.findByStockDateBetweenTwoDates(stkFrDate, stkToDate);
		} catch (Exception e) {
			
			System.out.println("Exce in getting Finished Good Stock Detail Between two Date  " + e.getMessage());
			e.printStackTrace();

		}
		
	System.out.println("output finished Good Detail bet two dates FInal Query size: = "+finishedGoodStockDetail.size()+"Data :"+finishedGoodStockDetail.toString());
		return finishedGoodStockDetail;

	}
	
	
	//Final Query For Fin good Stock bet two Date 3 Feb  Spec Category
	
		@RequestMapping(value = { "/getFinGoodStockBetTwoDateByCat" }, method = RequestMethod.POST)
		public @ResponseBody List<FinishedGoodStockDetail> getFinGoodStockBetTwoDateByCat(@RequestParam("fromDate") String fromDate,
				@RequestParam("toDate") String toDate,@RequestParam("catId") int catId) {

			List<FinishedGoodStockDetail> finishedGoodStockDetail=new ArrayList<FinishedGoodStockDetail>();
			
			try {
				
				System.out.println("date received for Stock Detail bet date = "+fromDate+ "to Date "+toDate);
				
				java.sql.Date stkFrDate= Common.convertToSqlDate(fromDate);
				
				java.sql.Date stkToDate= Common.convertToSqlDate(toDate);
				
				System.out.println("date After convert for Stock Detail bet date stkFrDate= "+stkFrDate);
				
				System.out.println("date After convert for Stock Detail bet date  stkToDate= "+stkToDate);
				
				finishedGoodStockDetail=finishedGoodStockDetailRepo.findByStockDateBetweenTwoDateByCat(stkFrDate, stkToDate, catId);
			} catch (Exception e) {
				
				System.out.println("Exce in getting Finished Good Stock Detail Between two Date Final Query " + e.getMessage());
				e.printStackTrace();

			}
			
		System.out.println("output finished Good Detail bet two dates FInal Query size: = "+finishedGoodStockDetail.size()+"Data :"+finishedGoodStockDetail.toString());
			return finishedGoodStockDetail;

		}

	
	
	
	
	
	//get Finished Good Stock Bet Date
//dont
	@RequestMapping(value = { "/getFinGoodStockBetDate" }, method = RequestMethod.POST)
	public @ResponseBody List<FinishedGoodStockDetail> getFinGoodStockBetDate(@RequestParam("stockFromDate") String stockFromDate,
			@RequestParam("stockToDate") String stockToDate,@RequestParam("stockStatus")int stockStatus) {

		List<FinishedGoodStockDetail> finishedGoodStockDetail=null;
		try {
			
			System.out.println("date received for Stock Detail bet date = "+stockFromDate);
			
			Date stkFrDate= Common.convertToSqlDate(stockFromDate);
			
			stockToDate=Common.convertToDMY(stockToDate);
			Date stkToDate= Common.convertToSqlDate(stockToDate);
			
			System.out.println("date After convert for Stock Detail bet date  "+stkFrDate);
			

			finishedGoodStockDetail=finishedGoodStockDetailRepo.findByStockDateBetween(stkFrDate, stkToDate, stockStatus);
		} catch (Exception e) {
			
			System.out.println("Exce in getting Finished Good Stock Detail Between two Date " + e.getMessage());
			e.printStackTrace();

		}
		
	System.out.println("output finished Good Detail bet two dates  = "+finishedGoodStockDetail.toString());
		return finishedGoodStockDetail;

	}

}
