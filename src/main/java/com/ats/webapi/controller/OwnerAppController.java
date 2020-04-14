package com.ats.webapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.ownerapp.BillDetailDisplayForApp;
import com.ats.webapi.model.ownerapp.BillHeaderDisplayForApp;
import com.ats.webapi.model.ownerapp.CreditNoteDetailDisplayFroApp;
import com.ats.webapi.model.ownerapp.CreditNoteHeaderDisplayForApp;
import com.ats.webapi.repo.ownerapp.BillDetailDisplayForAppRepo;
import com.ats.webapi.repo.ownerapp.BillHeaderDisplayForAppRepo;
import com.ats.webapi.repo.ownerapp.CreditNoteDetailDisplayFroAppRepo;
import com.ats.webapi.repo.ownerapp.CreditNoteHeaderDisplayForAppRepo;

@RestController
public class OwnerAppController {

	@Autowired
	BillHeaderDisplayForAppRepo billHeaderDisplayForAppRepo;

	@Autowired
	BillDetailDisplayForAppRepo billDetailDisplayForAppRepo;

	@Autowired
	CreditNoteHeaderDisplayForAppRepo creditNoteHeaderDisplayForAppRepo;

	@Autowired
	CreditNoteDetailDisplayFroAppRepo creditNoteDetailDisplayFroAppRepo;

	@RequestMapping(value = { "/getBillHeaderDisplayForApp" }, method = RequestMethod.POST)
	public @ResponseBody List<BillHeaderDisplayForApp> getBillHeaderDisplayForApp(
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,
			@RequestParam("frIds") ArrayList<Integer> frIds) {

		List<BillHeaderDisplayForApp> result = new ArrayList<>();

		try {
			result = billHeaderDisplayForAppRepo.getBillHeaderByDateAndFr(fromDate, toDate, frIds);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	@RequestMapping(value = { "/getBillDetailDisplayForApp" }, method = RequestMethod.POST)
	public @ResponseBody List<BillDetailDisplayForApp> getBillDetailDisplayForApp(
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,
			@RequestParam("frIds") ArrayList<Integer> frIds) {

		List<BillDetailDisplayForApp> result = new ArrayList<>();

		try {
			result = billDetailDisplayForAppRepo.getBillDetailByDateAndFr(fromDate, toDate, frIds);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	@RequestMapping(value = { "/getCrnHeaderDisplayForApp" }, method = RequestMethod.POST)
	public @ResponseBody List<CreditNoteHeaderDisplayForApp> getCrnHeaderDisplayForApp(
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,
			@RequestParam("frIds") ArrayList<Integer> frIds) {

		List<CreditNoteHeaderDisplayForApp> result = new ArrayList<>();

		try {
			result = creditNoteHeaderDisplayForAppRepo.getCrnHeaderByDateAndFr(fromDate, toDate, frIds);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	@RequestMapping(value = { "/getCrnDetailDisplayForApp" }, method = RequestMethod.POST)
	public @ResponseBody List<CreditNoteDetailDisplayFroApp> getCrnDetailDisplayForApp(
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,
			@RequestParam("frIds") ArrayList<Integer> frIds) {

		List<CreditNoteDetailDisplayFroApp> result = new ArrayList<>();

		try {
			result = creditNoteDetailDisplayFroAppRepo.getCrnDetailByDateAndFr(fromDate, toDate, frIds);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
