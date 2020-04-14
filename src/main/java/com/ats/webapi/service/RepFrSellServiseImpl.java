package com.ats.webapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.report.GetCustBillTax;
import com.ats.webapi.model.report.GetCustomerBill;
import com.ats.webapi.model.report.GetRepFrDatewiseSell;
import com.ats.webapi.model.report.GetRepItemwiseSell;
import com.ats.webapi.model.report.GetRepMenuwiseSell;
import com.ats.webapi.model.report.GetRepMonthwiseSell;
import com.ats.webapi.model.report.GetRepTaxSell;
import com.ats.webapi.repository.GetCustBillTaxRepository;
import com.ats.webapi.repository.GetCustomerBillRepository;
import com.ats.webapi.repository.RepFrDatewiseSellRepository;
import com.ats.webapi.repository.RepFrItemwiseSellRepository;
import com.ats.webapi.repository.RepFrMenuwiseSellRepository;
import com.ats.webapi.repository.RepFrMonthwiseSellRepository;
import com.ats.webapi.repository.RepTaxSellRepository;
 

@Service
public class RepFrSellServiseImpl implements RepFrSellServise{

	@Autowired
	RepFrDatewiseSellRepository repFrDateSellRepository;
	@Autowired
	RepFrMonthwiseSellRepository repFrMonthwiseSellRepository;
	@Autowired
	RepFrItemwiseSellRepository repFrItemwiseSellRepository;
	@Autowired
	RepTaxSellRepository repTaxSellRepository;
	
	@Autowired
	RepFrMenuwiseSellRepository repFrMenuwiseSellRepository;

	@Autowired
	GetCustomerBillRepository getCustomerBillRepository;
	
	@Autowired
	GetCustBillTaxRepository getCustBillTaxRepository;
	@Override
	public List<GetRepFrDatewiseSell> getDatewiseSellReport(String fromDate, String toDate,  List<String> frId) {
		
		List<GetRepFrDatewiseSell> repFrDatewiseSellServiseList=repFrDateSellRepository.getRepFrDatewiseSell(fromDate, toDate, frId);
		
		return repFrDatewiseSellServiseList;
	}
	@Override
	public List<GetRepMonthwiseSell> getMonthwiseSellReport(String fromDate, String toDate, List<String> frId) {
List<GetRepMonthwiseSell> repFrMonthwiseSellServiseList=repFrMonthwiseSellRepository.getRepFrMonthwiseSell(fromDate, toDate, frId);
		
		return repFrMonthwiseSellServiseList;
	}
	@Override
	public List<GetRepItemwiseSell> getItemwiseSellReport(String fromDate, String toDate, List<String> frId,
			List<String> catId) {

List<GetRepItemwiseSell> getRepItemwiseSellList=repFrItemwiseSellRepository.getRepFrItemwiseSell(fromDate, toDate, frId, catId);
		
		return getRepItemwiseSellList;
	}
	@Override
	public List<GetRepItemwiseSell> getDateItemwiseSellReport(String fromDate, String toDate, List<String> frId,
			List<String> catId) {
		List<GetRepItemwiseSell> getRepItemwiseSellList=repFrItemwiseSellRepository.getRepFrDateItemwiseSell(fromDate, toDate, frId, catId);
		
		return getRepItemwiseSellList;
	}
	@Override
	public List<GetRepTaxSell> getTaxSellReport(String fromDate, String toDate, List<String> frId) {
		 
		List<GetRepTaxSell> getRepTaxSellList=repTaxSellRepository.getRepFrTaxSell(fromDate, toDate, frId);
		
		return getRepTaxSellList;
	}
	@Override
	public List<GetRepTaxSell> getDatewiseTaxSellReport(String fromDate, String toDate, List<String> frId) {
		List<GetRepTaxSell> getRepTaxSellList=repTaxSellRepository.getRepFrDatewiseTaxSell(fromDate, toDate, frId);
		
		return getRepTaxSellList;
	}
	@Override
	public List<GetRepTaxSell> getBillwiseTaxSellReport(String fromDate, String toDate, List<String> frId) {
		List<GetRepTaxSell> getRepTaxSellList=repTaxSellRepository.getRepFrBillwiseTaxSell(fromDate, toDate, frId);
		
		return getRepTaxSellList;
	}
	@Override
	public List<GetRepMenuwiseSell> getMenuwiseSellReport(String fromDate, String toDate, List<String> frId) {
		List<GetRepMenuwiseSell> getRepMenuwiseSellList=repFrMenuwiseSellRepository.getRepFrMenuwiseSell(fromDate, toDate, frId);
		
		return getRepMenuwiseSellList;
	 

	}
	@Override
	public List<GetRepItemwiseSell> getDateCatwiseSellReport(String fromDate, String toDate, List<String> frId,
			List<String> catId) {
List<GetRepItemwiseSell> getRepCatwiseSellList=repFrItemwiseSellRepository.getRepFrDateCatwiseSell(fromDate, toDate, frId, catId);
		
		return getRepCatwiseSellList;
	}
	@Override
	public List<GetCustomerBill> getCustBill(int billNo) {
		List<GetCustomerBill> getCustomerBillList=getCustomerBillRepository.getCustBill(billNo);
		
		
		
		
		return getCustomerBillList;
	}
	@Override
	public List<GetCustBillTax> getCustBillTax(int billNo) {
		
		List<GetCustBillTax> getCustBillTaxList=getCustBillTaxRepository.getCustBill(billNo);
		return getCustBillTaxList;
	}
	@Override
	public List<GetRepItemwiseSell> getItemwiseSellReportForCat5(String fromDate, String toDate, List<String> frId) {
List<GetRepItemwiseSell> getRepItemwiseSellList=repFrItemwiseSellRepository.getRepFrItemwiseSellCatId5(fromDate, toDate, frId);
		
		return getRepItemwiseSellList;
	}
 

}
