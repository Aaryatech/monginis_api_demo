package com.ats.webapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.CatWiseDashboardQuery;
import com.ats.webapi.model.DashboardData;
import com.ats.webapi.model.DateWiseDashboardGraphQuery;
import com.ats.webapi.model.dailysales.DailySalesRegular;
import com.ats.webapi.model.dailysales.DailySalesReportDao;
import com.ats.webapi.model.dailysales.SpDailySales;
import com.ats.webapi.repo.CatWiseDashboardQueryRepo;
import com.ats.webapi.repo.DashboardDataRepo;
import com.ats.webapi.repo.DateWiseDashboardGraphQueryRepo;
import com.ats.webapi.repository.dailysales.DailySpSalesRepository;

@RestController
public class DashboardApiController {

	@Autowired
	DashboardDataRepo dashboardDataRepo;
	
	@Autowired
	DateWiseDashboardGraphQueryRepo dateWiseDashboardGraphQueryRepo;
	
	@Autowired
	CatWiseDashboardQueryRepo catWiseDashboardQueryRepo;

	@RequestMapping(value = "/getDashboardData", method = RequestMethod.POST)
	public @ResponseBody DashboardData getDashboardData(@RequestParam("frId") int frId,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {
		DashboardData dashboardData = new DashboardData();
		try {

			dashboardData = dashboardDataRepo.getDashboardData(fromDate, toDate, frId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dashboardData;
	}
	
	@RequestMapping(value = "/dateWiseDashboardGraphQuery", method = RequestMethod.POST)
	public @ResponseBody List<DateWiseDashboardGraphQuery> dateWiseDashboardGraphQuery(@RequestParam("frId") int frId,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {
		List<DateWiseDashboardGraphQuery> list = new ArrayList<>();
		try {

			list = dateWiseDashboardGraphQueryRepo.dateWiseDashboardGraphQuery(fromDate, toDate, frId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping(value = "/catWiseDashboardQuery", method = RequestMethod.POST)
	public @ResponseBody List<CatWiseDashboardQuery> catWiseDashboardQuery(@RequestParam("frId") int frId,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {
		List<CatWiseDashboardQuery> list = new ArrayList<>();
		try {

			list = catWiseDashboardQueryRepo.dateWiseDashboardGraphQuery(fromDate, toDate, frId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
