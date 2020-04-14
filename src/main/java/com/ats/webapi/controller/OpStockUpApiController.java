package com.ats.webapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.commons.Common;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.SubCategoryRes;
import com.ats.webapi.model.opstock.CustList;
import com.ats.webapi.model.opstock.CustListRepo;
import com.ats.webapi.model.opstock.OpStockUpdate;
import com.ats.webapi.model.opstock.OpStockUpdateRepo;
import com.ats.webapi.model.taxreport.Tax1Report;
import com.ats.webapi.repository.SubCategoryResRepository;

@RestController
public class OpStockUpApiController {

	@Autowired
	OpStockUpdateRepo opStockUpdateRepo;
	@Autowired
	CustListRepo custListRepo;

	// ----------------------------SAVE Opening Stock ---------------------------
	@RequestMapping(value = { "/saveOpStock" }, method = RequestMethod.POST)
	public @ResponseBody Info saveOpStock(@RequestBody OpStockUpdate OpStockUp) {

		OpStockUpdate opStockUpdateRes = null;
		Info info = new Info();
		try {

			opStockUpdateRes = opStockUpdateRepo.save(OpStockUp);

			if (opStockUpdateRes != null) {
				info.setError(false);
				info.setMessage("  Saved Successfully.");
			} else {
				info.setError(true);
				info.setMessage("  Not Saved .");
			}

		} catch (Exception e) {

			info.setError(true);
			info.setMessage("  Not Saved .");

			e.printStackTrace();
			System.out.println("Exception In OpStockUpApiController /saveOpStock" + e.getMessage());

		}
		return info;

	}

	@RequestMapping(value = { "/getOpStockAdjReport" }, method = RequestMethod.POST)
	public @ResponseBody List<OpStockUpdate> getOpStockAdjReport(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("catId") int catId) {

		List<OpStockUpdate> OpStockUpdateList = null;
		try {
			fromDate = Common.convertToYMD(fromDate);
			toDate = Common.convertToYMD(toDate);

			OpStockUpdateList = opStockUpdateRepo.getOpStockAdjReport(fromDate, toDate, catId);

		} catch (Exception e) {
			System.out.println(" Exce in Tax1 Report " + e.getMessage());
			e.printStackTrace();
		}
		return OpStockUpdateList;
	}

	@RequestMapping(value = { "/getCutslList" }, method = RequestMethod.GET)
	public @ResponseBody List<CustList> getCutslList() {

		List<CustList> OpStockUpdateList = null;
		try {

			OpStockUpdateList = custListRepo.getOpStockAdjReport();

		} catch (Exception e) {
			System.out.println(" Exce in Tax1 Report " + e.getMessage());
			e.printStackTrace();
		}
		return OpStockUpdateList;
	}

	@RequestMapping(value = { "/getCutslListFroFranchasee" }, method = RequestMethod.POST)
	public @ResponseBody List<CustList> getCutslListFroFranchasee(@RequestParam("frId") int frId) {

		List<CustList> OpStockUpdateList = null;
		try {

			OpStockUpdateList = custListRepo.getOpStockAdjReportByfrId(frId);

		} catch (Exception e) {
			System.out.println(" Exce in Tax1 Report " + e.getMessage());
			e.printStackTrace();
		}
		return OpStockUpdateList;
	}

}
