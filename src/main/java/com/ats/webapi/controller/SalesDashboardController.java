package com.ats.webapi.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.GenerateBill;
import com.ats.webapi.model.OrderLog;
import com.ats.webapi.model.Orders;
import com.ats.webapi.model.saledashboard.CatWiseAllData;
import com.ats.webapi.model.saledashboard.CatWiseSaleTotal;
import com.ats.webapi.model.saledashboard.FrWiseSaleForDash;
import com.ats.webapi.model.saledashboard.ItemListBySubCat;
import com.ats.webapi.model.saledashboard.RouteWiseSaleForDash;
import com.ats.webapi.model.saledashboard.SubCatListByCat;
import com.ats.webapi.model.saledashboard.TotalAmount;
import com.ats.webapi.repo.CatWiseSaleTotalRepo;
import com.ats.webapi.repo.FrWiseSaleForDashRepo;
import com.ats.webapi.repo.ItemListBySubCatRepo;
import com.ats.webapi.repo.RouteWiseSaleForDashRepo;
import com.ats.webapi.repo.SubCatListByCatRepo;
import com.ats.webapi.repo.TotalAmountRepo;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
public class SalesDashboardController {

	@Autowired
	TotalAmountRepo totalAmountRepo;

	@Autowired
	CatWiseSaleTotalRepo catWiseSaleTotalRepo;
	
	@Autowired
	SubCatListByCatRepo subCatListByCatRepo;
	
	@Autowired
	ItemListBySubCatRepo itemListBySubCatRepo;
	
	@Autowired
	RouteWiseSaleForDashRepo routeWiseSaleForDashRepo;
	
	@Autowired
	FrWiseSaleForDashRepo frWiseSaleForDashRepo;

	@RequestMapping(value = { "/getSalesDashAmt" }, method = RequestMethod.POST)
	public @ResponseBody TotalAmount getSalesDashAmt(@RequestParam String fromDate, @RequestParam String toDate) {

		TotalAmount model = null;

		model = totalAmountRepo.getSaleForDash(fromDate, toDate);

		if (model == null) {
			model = new TotalAmount();
		}

		return model;
	}

	@RequestMapping(value = { "/getCatWiseSaleData" }, method = RequestMethod.POST)
	public @ResponseBody List<CatWiseSaleTotal> getCatWiseSaleData(@RequestParam String fromDate,
			@RequestParam String toDate) throws ParseException, JsonParseException, JsonMappingException, IOException {
		List<CatWiseSaleTotal> catList = new ArrayList<>();

		catList = catWiseSaleTotalRepo.getCatWiseSaleAmt(fromDate, toDate);

		if (catList == null) {
			catList = new ArrayList<>();
		}

		return catList;
	}

	@RequestMapping(value = { "/getCatWiseCRNData" }, method = RequestMethod.POST)
	public @ResponseBody List<CatWiseSaleTotal> getCatWiseCRNData(@RequestParam String fromDate,
			@RequestParam String toDate) throws ParseException, JsonParseException, JsonMappingException, IOException {
		List<CatWiseSaleTotal> catList = new ArrayList<>();

		catList = catWiseSaleTotalRepo.getCatWiseCRNAmt(fromDate, toDate);

		if (catList == null) {
			catList = new ArrayList<>();
		}

		return catList;
	}

	@RequestMapping(value = { "/getCatWiseNetData" }, method = RequestMethod.POST)
	public @ResponseBody List<CatWiseSaleTotal> getCatWiseNetData(@RequestParam String fromDate,
			@RequestParam String toDate) throws ParseException, JsonParseException, JsonMappingException, IOException {
		List<CatWiseSaleTotal> catList = new ArrayList<>();

		catList = catWiseSaleTotalRepo.getCatWiseNetAmt(fromDate, toDate);

		if (catList == null) {
			catList = new ArrayList<>();
		}

		return catList;
	}

	@RequestMapping(value = { "/getCatWiseDataForDash" }, method = RequestMethod.POST)
	public @ResponseBody CatWiseAllData getCatWiseDataForDash(@RequestParam String fromDate,
			@RequestParam String toDate) throws ParseException, JsonParseException, JsonMappingException, IOException {
		CatWiseAllData data = new CatWiseAllData();

		List<CatWiseSaleTotal> saleList = new ArrayList<>();
		saleList = catWiseSaleTotalRepo.getCatWiseSaleAmt(fromDate, toDate);
		
		List<CatWiseSaleTotal> crnList = new ArrayList<>();
		crnList = catWiseSaleTotalRepo.getCatWiseCRNAmt(fromDate, toDate);

		List<CatWiseSaleTotal> netList = new ArrayList<>();
		netList = catWiseSaleTotalRepo.getCatWiseNetAmt(fromDate, toDate);

		data.setSaleList(saleList);
		data.setCrnList(crnList);
		data.setNetList(netList);

		return data;
	}
	
	@RequestMapping(value = { "/getSubCatDataByCat" }, method = RequestMethod.POST)
	public @ResponseBody List<SubCatListByCat> getSubCatDataByCat(@RequestParam String fromDate,
			@RequestParam String toDate,@RequestParam int catId) throws ParseException, JsonParseException, JsonMappingException, IOException {
		List<SubCatListByCat> catList = new ArrayList<>();

		if(catId!=5) {
			catList = subCatListByCatRepo.getSubCatAmtByCat(fromDate, toDate,catId);	
		}else {
			catList = subCatListByCatRepo.getSubCatAmtByCatSpCake(fromDate, toDate);
		}
		

		if (catList == null) {
			catList = new ArrayList<>();
		}

		return catList;
	}

	@RequestMapping(value = { "/getItemListBySubCat" }, method = RequestMethod.POST)
	public @ResponseBody List<ItemListBySubCat> getItemListBySubCat(@RequestParam String fromDate,
			@RequestParam String toDate,@RequestParam int catId,@RequestParam int subCatId) throws ParseException, JsonParseException, JsonMappingException, IOException {
		List<ItemListBySubCat> itemList = new ArrayList<>();
		
		if(catId==5) {
			itemList = itemListBySubCatRepo.getItemListBySubCatSpCake(fromDate, toDate);
		}else {
			itemList = itemListBySubCatRepo.getItemListBySubCat(fromDate, toDate,subCatId);
		}

		if (itemList == null) {
			itemList = new ArrayList<>();
		}

		return itemList;
	}
	
	
	@RequestMapping(value = { "/getRouteWiseSaleData" }, method = RequestMethod.POST)
	public @ResponseBody List<RouteWiseSaleForDash> getRouteWiseSaleData(@RequestParam String fromDate,
			@RequestParam String toDate) throws ParseException, JsonParseException, JsonMappingException, IOException {
		List<RouteWiseSaleForDash> routeList = new ArrayList<>();

		routeList = routeWiseSaleForDashRepo.getRouteWiseSale(fromDate, toDate);

		if (routeList == null) {
			routeList = new ArrayList<>();
		}

		return routeList;
	}
	
	
	@RequestMapping(value = { "/getFrWiseSaleData" }, method = RequestMethod.POST)
	public @ResponseBody List<FrWiseSaleForDash> getFrWiseSaleData(@RequestParam String fromDate,
			@RequestParam String toDate) throws ParseException, JsonParseException, JsonMappingException, IOException {
		List<FrWiseSaleForDash> frList = new ArrayList<>();

		frList = frWiseSaleForDashRepo.getFrWiseSale(fromDate, toDate);

		if (frList == null) {
			frList = new ArrayList<>();
		}

		return frList;
	}
	
}
