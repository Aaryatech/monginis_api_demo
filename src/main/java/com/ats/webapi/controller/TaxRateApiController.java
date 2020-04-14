package com.ats.webapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.afe.AfeQuestion;
import com.ats.webapi.model.taxrate.GetTaxRate;
import com.ats.webapi.model.taxrate.TaxRate;
import com.ats.webapi.repository.GetTaxRateRepo;
import com.ats.webapi.repository.TaxRateRepo; 

@RestController
public class TaxRateApiController {

	@Autowired
	TaxRateRepo taxRateRepo;

	@Autowired
	GetTaxRateRepo getTaxRateRepo;

	@RequestMapping(value = { "/saveTaxRate" }, method = RequestMethod.POST)
	public @ResponseBody TaxRate saveTaxRate(@RequestBody TaxRate taxRate) {

		TaxRate taxRateRes = new TaxRate();

		try {

			if (taxRate.getTaxRateId() == 0) {

				List<TaxRate> txRaLis = taxRateRepo.findBySubCatIdAndDelStatus(taxRate.getSubCatId(), 0);
				if (txRaLis.size() == 0) {
					System.err.println("in Save method size ==0");

					taxRateRes = taxRateRepo.save(taxRate);
				} else {
					System.err.println("in Save method : Record not added");
				}

			} else {

				taxRateRes = taxRateRepo.findByTaxRateId(taxRate.getTaxRateId());
				taxRateRes.setDelStatus(1);
				taxRateRes = taxRateRepo.save(taxRateRes);
				System.err.println("In Else Tax Rate res for delete");

			}

		} catch (Exception e) {

			System.err.println("TaxRateController -- Exce in /saveTaxRate" + e.getMessage());
			e.printStackTrace();
		}

		System.out.println("saveTaxRate ->response " + taxRateRes.toString());

		return taxRateRes;
	}

	@RequestMapping(value = { "/getTaxReportByRateId" }, method = RequestMethod.POST)
	public @ResponseBody TaxRate getTaxReport(@RequestBody int taxRateId) {

		TaxRate taxRateRes = new TaxRate();

		try {

			taxRateRes = taxRateRepo.findByTaxRateId(taxRateId);

		} catch (Exception e) {

			System.err.println("TaxRateController -- Exce in /getTaxReport" + e.getMessage());
			e.printStackTrace();
		}

		System.out.println("getTaxReportByRateId ->response " + taxRateRes.toString());

		return taxRateRes;
	}

	@RequestMapping(value = { "/getTaxRateList" }, method = RequestMethod.GET)
	public @ResponseBody List<GetTaxRate> getTaxRateList() {

		List<GetTaxRate> taxRateResList = new ArrayList<GetTaxRate>();

		try {

			taxRateResList = getTaxRateRepo.getTaxRateList();

		} catch (Exception e) {

			System.err.println("TaxRateController -- Exce in /getTaxRateList" + e.getMessage());
			e.printStackTrace();
		}

		System.out.println("getTaxReportList ->response " + taxRateResList.toString());

		return taxRateResList;
	}

}
