package com.ats.webapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

 
import com.ats.webapi.model.materialrecreport.GetMaterialRecieptReportBillWise;
import com.ats.webapi.model.materialrecreport.GetMaterialRecieptReportHsnCodeWise;
import com.ats.webapi.model.materialrecreport.GetMaterialRecieptReportItemWise;
import com.ats.webapi.model.materialrecreport.GetMaterialRecieptReportMonthWise;
import com.ats.webapi.repository.materialrecreport.MaterialRecieptReportRepository;
import com.ats.webapi.repository.materialrecreport.MaterialRecieptReportRepositoryHsnCodeWise;
import com.ats.webapi.repository.materialrecreport.MaterialRecieptReportRepositoryItemWise;
import com.ats.webapi.repository.materialrecreport.MaterialRecieptReportRepositoryMonthWise; 

@RestController
public class MaterialRecieptReportApiController {
	
	@Autowired
	MaterialRecieptReportRepository materialRecieptReportRepository;
	
	@Autowired
	MaterialRecieptReportRepositoryItemWise materialRecieptReportRepositoryItemWise;
	
	@Autowired
	MaterialRecieptReportRepositoryHsnCodeWise materialRecieptReportRepositoryHsnCodeWise;
	
	@Autowired
	MaterialRecieptReportRepositoryMonthWise materialRecieptReportRepositoryMonthWise;
	
	@RequestMapping(value = { "/materialRecieptBillWiseReport" }, method = RequestMethod.POST)
	public @ResponseBody List<GetMaterialRecieptReportBillWise> materialRecieptBillWiseReport(@RequestParam("suppId")List<String> suppId,@RequestParam("fromDate")String fromDate,
			@RequestParam("toDate")String toDate)
	{
		List<GetMaterialRecieptReportBillWise> billWiseReport = new ArrayList<GetMaterialRecieptReportBillWise>();
		try
		{
			System.out.println("suppId : "+suppId);
			System.out.println("fromDate : "+fromDate);
			System.out.println("toDate : "+toDate);
			billWiseReport = materialRecieptReportRepository.billWiseReport(suppId, fromDate, toDate);
		}catch(Exception e)
		{
			
		}
		

		return billWiseReport ;

	}
	
	@RequestMapping(value = { "/materialRecieptSupplierWiseReport" }, method = RequestMethod.POST)
	public @ResponseBody List<GetMaterialRecieptReportBillWise> materialRecieptSupplierWiseReport(@RequestParam("suppId")List<String> suppId,@RequestParam("fromDate")String fromDate,
			@RequestParam("toDate")String toDate)
	{
		List<GetMaterialRecieptReportBillWise> materialRecieptSupplierWiseReport = new ArrayList<GetMaterialRecieptReportBillWise>();
		try
		{
			System.out.println("suppId : "+suppId);
			System.out.println("fromDate : "+fromDate);
			System.out.println("toDate : "+toDate);
			materialRecieptSupplierWiseReport = materialRecieptReportRepository.materialRecieptSupplierWiseReport(suppId, fromDate, toDate);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		

		return materialRecieptSupplierWiseReport ;

	}
	@RequestMapping(value = { "/materialRecieptDateWiseReport" }, method = RequestMethod.POST)
	public @ResponseBody List<GetMaterialRecieptReportBillWise> materialRecieptDateWiseReport(@RequestParam("suppId")List<String> suppId,@RequestParam("fromDate")String fromDate,
			@RequestParam("toDate")String toDate)
	{
		List<GetMaterialRecieptReportBillWise> materialRecieptSupplierWiseReport = new ArrayList<GetMaterialRecieptReportBillWise>();
		try
		{
			System.out.println("suppId : "+suppId);
			System.out.println("fromDate : "+fromDate);
			System.out.println("toDate : "+toDate);
			materialRecieptSupplierWiseReport = materialRecieptReportRepository.materialRecieptDateWiseReport(suppId, fromDate, toDate);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		

		return materialRecieptSupplierWiseReport ;

	}
	@RequestMapping(value = { "/materialRecieptItemWiseReport" }, method = RequestMethod.POST)
	public @ResponseBody List<GetMaterialRecieptReportItemWise> materialRecieptItemWise(@RequestParam("item")List<String> item,@RequestParam("fromDate")String fromDate,
			@RequestParam("toDate")String toDate)
	{
		List<GetMaterialRecieptReportItemWise> materialRecieptItemWise = new ArrayList<GetMaterialRecieptReportItemWise>();
		try
		{
			System.out.println("item : "+item);
			System.out.println("fromDate : "+fromDate);
			System.out.println("toDate : "+toDate);
			materialRecieptItemWise = materialRecieptReportRepositoryItemWise.materialRecieptItemWise(item, fromDate, toDate);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		

		return materialRecieptItemWise ;

	}
	
	@RequestMapping(value = { "/materialRecieptHsnCodeWiseReport" }, method = RequestMethod.POST)
	public @ResponseBody List<GetMaterialRecieptReportHsnCodeWise> materialRecieptHsnCodeWise(@RequestParam("suppId")List<String> suppId,@RequestParam("fromDate")String fromDate,
			@RequestParam("toDate")String toDate)
	{
		List<GetMaterialRecieptReportHsnCodeWise> materialRecieptHsnCodeWise = new ArrayList<GetMaterialRecieptReportHsnCodeWise>();
		try
		{
			System.out.println("suppId : "+suppId);
			System.out.println("fromDate : "+fromDate);
			System.out.println("toDate : "+toDate);
			materialRecieptHsnCodeWise = materialRecieptReportRepositoryHsnCodeWise.materialRecieptHsnCodeWise(suppId, fromDate, toDate);
			System.out.println("materialRecieptHsnCodeWise"+materialRecieptHsnCodeWise);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		

		return materialRecieptHsnCodeWise ;

	}
	
	@RequestMapping(value = { "/materialRecieptMonthWiseReport" }, method = RequestMethod.POST)
	public @ResponseBody List<GetMaterialRecieptReportMonthWise> materialRecieptMonthWiseReport(@RequestParam("suppId")List<String> suppId,@RequestParam("fromDate")String fromDate,
			@RequestParam("toDate")String toDate)
	{
		List<GetMaterialRecieptReportMonthWise> materialRecieptMonthWiseReport = new ArrayList<GetMaterialRecieptReportMonthWise>();
		try
		{
			System.out.println("suppId : "+suppId);
			System.out.println("fromDate : "+fromDate);
			System.out.println("toDate : "+toDate);
			materialRecieptMonthWiseReport = materialRecieptReportRepositoryMonthWise.materialRecieptMonthWiseReport(suppId, fromDate, toDate);
			System.out.println("materialRecieptHsnCodeWise"+materialRecieptMonthWiseReport);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		

		return materialRecieptMonthWiseReport ;

	}


}
