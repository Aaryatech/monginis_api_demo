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
import com.ats.webapi.model.CustomerListForDash;
import com.ats.webapi.model.DashboardData;
import com.ats.webapi.model.DateWiseDashboardGraphQuery;
import com.ats.webapi.model.GetDataForLineChart;
import com.ats.webapi.model.GetItemListForDashboardByCatId;
import com.ats.webapi.model.dailysales.DailySalesRegular;
import com.ats.webapi.model.dailysales.DailySalesReportDao;
import com.ats.webapi.model.dailysales.SpDailySales;
import com.ats.webapi.repo.CatWiseDashboardQueryRepo;
import com.ats.webapi.repo.DashboardDataRepo;
import com.ats.webapi.repo.DateWiseDashboardGraphQueryRepo;
import com.ats.webapi.repository.CustomerListForDashRepo;
import com.ats.webapi.repository.GetDataForLineChartRepo;
import com.ats.webapi.repository.GetItemListForDashboardByCatIdRepo;
import com.ats.webapi.repository.dailysales.DailySpSalesRepository;

@RestController
public class DashboardApiController {

	@Autowired
	DashboardDataRepo dashboardDataRepo;

	@Autowired
	DateWiseDashboardGraphQueryRepo dateWiseDashboardGraphQueryRepo;

	@Autowired
	CatWiseDashboardQueryRepo catWiseDashboardQueryRepo;

	@Autowired
	GetItemListForDashboardByCatIdRepo getItemListForDashboardByCatIdRepo;

	@Autowired
	CustomerListForDashRepo customerListForDashRepo;
	
	@Autowired
	GetDataForLineChartRepo getDataForLineChartRepo;

	@RequestMapping(value = "/getDashboardData", method = RequestMethod.POST)
	public @ResponseBody DashboardData getDashboardData(@RequestParam("frId") int frId,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,
			@RequestParam("month") int month, @RequestParam("year") int year) {
		DashboardData dashboardData = new DashboardData();
		try {

			dashboardData = dashboardDataRepo.getDashboardData(fromDate, toDate, frId, month, year);

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

	@RequestMapping(value = "/getItemListForDashboardByCatId", method = RequestMethod.POST)
	public @ResponseBody List<GetItemListForDashboardByCatId> getItemListForDashboardByCatId(
			@RequestParam("frId") int frId, @RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("catId") int catId, @RequestParam("flag") int flag) {
		List<GetItemListForDashboardByCatId> list = new ArrayList<>();
		try {

			if (catId != 5) {
				if (flag == 1) {
					list = getItemListForDashboardByCatIdRepo.getItemListForDashboardByCatIdasc(fromDate, toDate, frId,
							catId);
				} else {
					list = getItemListForDashboardByCatIdRepo.getItemListForDashboardByCatIddesc(fromDate, toDate, frId,
							catId);
				}

			} else {
				if (flag == 1) {
					list = getItemListForDashboardByCatIdRepo.getItemListForDashboardspdasc(fromDate, toDate, frId);
				} else {
					list = getItemListForDashboardByCatIdRepo.getItemListForDashboardspddesc(fromDate, toDate, frId);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@RequestMapping(value = "/getListOfCustomer", method = RequestMethod.POST)
	public @ResponseBody List<CustomerListForDash> getListOfCustomer(@RequestParam("frId") int frId,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {
		List<CustomerListForDash> list = new ArrayList<>();
		try {

			list = customerListForDashRepo.getListOfCustomer(fromDate, toDate, frId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@RequestMapping(value = "/getDataForLineChart", method = RequestMethod.POST)
	public @ResponseBody List<GetDataForLineChart> getDataForLineChart(@RequestParam("frId") int frId,
			@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,
			@RequestParam("flag") int flag) {
		List<GetDataForLineChart> list = new ArrayList<>();
		try {

			if(flag==1) {
				list = getDataForLineChartRepo.getDataForLineChartdate(fromDate, toDate, frId);
			}else if(flag==2) {
				list = getDataForLineChartRepo.getDataForLineChartweek(fromDate, toDate, frId);
			}else if(flag==3) {
				list = getDataForLineChartRepo.getDataForLineChartmonth(fromDate, toDate, frId);
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
