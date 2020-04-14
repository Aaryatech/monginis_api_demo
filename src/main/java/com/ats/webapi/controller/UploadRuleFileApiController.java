package com.ats.webapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.MRule;
import com.ats.webapi.model.materialrecreport.GetMaterialRecieptReportBillWise;
import com.ats.webapi.repository.MRuleRepository; 
 

@RestController
public class UploadRuleFileApiController {
	
	@Autowired
	MRuleRepository mRuleRepository;
	
	@RequestMapping(value = { "/postRuleFile" }, method = RequestMethod.POST)
	public @ResponseBody List<MRule> postRuleFile(@RequestBody List<MRule> fileList)
	{
		List<MRule> list = new ArrayList<MRule>();
		try
		{
			System.out.println("fileList " + fileList);
			 list = mRuleRepository.save(fileList);
		}catch(Exception e)
		{
			
		}
		 
		return list ;

	}
	@RequestMapping(value = { "/getRuleFile" }, method = RequestMethod.GET)
	public @ResponseBody List<MRule> getRuleFile()
	{
		List<MRule> list = new ArrayList<MRule>();
		try
		{
			 list = mRuleRepository.findAllByStatus(0);
		}catch(Exception e)
		{
			
		}
		 
		return list ;

	}

}
