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
 
import com.ats.webapi.model.OtherBillHeader;
import com.ats.webapi.model.FrSupplier;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.OtherBillDetail;
import com.ats.webapi.repository.FrSupplierRepository;
import com.ats.webapi.repository.OtherBillDetailRepository;
import com.ats.webapi.repository.OtherBillHeaderRepository; 

@RestController
public class OtherBillApiController {
	
	@Autowired
	FrSupplierRepository frSupplierRepository;
	
	@Autowired
	OtherBillHeaderRepository otherBillHeaderRepository;
	
	@Autowired
	OtherBillDetailRepository otherBillDetailRepository;
	
	@RequestMapping(value = { "/postFrSupplier" }, method = RequestMethod.POST)
	public @ResponseBody FrSupplier postFrSupplier(@RequestBody FrSupplier frSupplier)
	{
		System.out.println("Input List :"+frSupplier.toString());
		 
		FrSupplier frSupplierInsertInsert = new FrSupplier();
		try {
			 
			frSupplierInsertInsert = frSupplierRepository.save(frSupplier);
			 
			 
		} catch (Exception e) {

			e.printStackTrace();
		}
		return frSupplierInsertInsert;
           
	}
	
	@RequestMapping(value = { "/getFrSupplierById" }, method = RequestMethod.POST)
	public @ResponseBody FrSupplier getFrSupplierById(@RequestParam("suppId")int suppId)
	{
		System.out.println("suppId:"+suppId);
		 
		FrSupplier getFrSupplierById = new FrSupplier();
		try {
			 
			getFrSupplierById = frSupplierRepository.findBySuppId(suppId);
			 
			 
		} catch (Exception e) {

			e.printStackTrace();
		}
		return getFrSupplierById;
           
	}
	
	@RequestMapping(value = { "/deleteFrSupplier" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteFrSupplier(@RequestParam("suppId")int suppId)
	{
		System.out.println("suppId:"+suppId);
		 
		Info info = new Info();
		try {
			 
			int delete = frSupplierRepository.deleteFrSupplier(suppId);
			 if(delete==1)
			 {
				 info.setError(false);
				 info.setMessage("deleted Successfully ");
			 }
			 else
			 {
				 info.setError(true);
				 info.setMessage("deleted UnSuccessfully ");
			 }
			 
		} catch (Exception e) {

			e.printStackTrace();
		}
		return info;
           
	}
	
	@RequestMapping(value = { "/getAllFrSupplierListByFrId" }, method = RequestMethod.POST)
	public @ResponseBody List<FrSupplier> getAllFrSupplierListByFrId(@RequestParam("frId")int frId)
	{
		System.out.println("frId:"+frId);
		 
		List<FrSupplier> getAllFrSupplierListByFrId = new ArrayList<FrSupplier>();
		try {
			 
			getAllFrSupplierListByFrId = frSupplierRepository.findByFrIdAndDelStatus(frId,0);
			 
			 
		} catch (Exception e) {

			e.printStackTrace();
		}
		return getAllFrSupplierListByFrId;
           
	}
	 
	
	@RequestMapping(value = { "/postOtherBillHeaderAndDetail" }, method = RequestMethod.POST)
	public @ResponseBody OtherBillHeader postOtherBillHeaderAndDetail(@RequestBody OtherBillHeader otherBillHeader)
	{
		System.out.println("Input List :"+otherBillHeader.toString());
		 
		OtherBillHeader otherBillHeaderInsert = new OtherBillHeader();
		try {
			 
			otherBillHeaderInsert = otherBillHeaderRepository.save(otherBillHeader);
			if(otherBillHeaderInsert!=null)
			{
				for(int i=0; i<otherBillHeader.getOtherBillDetailList().size(); i++)
					otherBillHeader.getOtherBillDetailList().get(i).setBillNo(otherBillHeaderInsert.getBillNo());
				
				List<OtherBillDetail> otherBillDetailList = otherBillDetailRepository.save(otherBillHeader.getOtherBillDetailList());
				otherBillHeaderInsert.setOtherBillDetailList(otherBillDetailList);
			}
			
			   

			 
		} catch (Exception e) {

			e.printStackTrace();
		}
		return otherBillHeaderInsert;
           
	}
	
	@RequestMapping(value = { "/getAllOtherBillHeader" }, method = RequestMethod.GET)
	public @ResponseBody List<OtherBillHeader> getAllOtherBillHeader()
	{ 
		
		List<OtherBillHeader> getAllOtherBillHeader = new ArrayList<OtherBillHeader>();
		try {
			 
			getAllOtherBillHeader = otherBillHeaderRepository.findAllByDelStatus(0);
			 
			 
		} catch (Exception e) {

			e.printStackTrace();
		}
		return getAllOtherBillHeader;
           
	}
	
	@RequestMapping(value = { "/getOtherBillHeaderAndDetailByBillNo" }, method = RequestMethod.POST)
	public @ResponseBody OtherBillHeader getOtherBillHeaderAndDetailByBillNo(@RequestParam("billNo")int billNo)
	{ 
		
		OtherBillHeader getOtherBillHeader = new OtherBillHeader();
		try {
			 
			getOtherBillHeader = otherBillHeaderRepository.findByBillNoAndDelStatus(billNo,0);
			List<OtherBillDetail> detailList = otherBillDetailRepository.findByBillNoAndDelStatus(billNo,0);
			getOtherBillHeader.setOtherBillDetailList(detailList);
			 
		} catch (Exception e) {

			e.printStackTrace();
		}
		return getOtherBillHeader;
           
	}
	
	@RequestMapping(value = { "/getOtherBillHeaderBetweenDate" }, method = RequestMethod.POST)
	public @ResponseBody List<OtherBillHeader> getOtherBillHeaderAndDetailBetweenDate(@RequestParam("fromDate")String fromDate,
			@RequestParam("toDate")String toDate, @RequestParam("frId")String frId, @RequestParam("suppId")int suppId)
	{ 
		
		List<OtherBillHeader> getOtherBillHeaderList = new ArrayList<OtherBillHeader>();
		try {
			 if(suppId==0)
			 {
				 getOtherBillHeaderList = otherBillHeaderRepository.getOtherBillHeaderList(fromDate,toDate,frId);
			 }
			 else
			 {
				 getOtherBillHeaderList = otherBillHeaderRepository.getOtherBillHeaderList(fromDate,toDate,frId,suppId);
			 }
			  
			 
		} catch (Exception e) {

			e.printStackTrace();
		}
		return getOtherBillHeaderList;
           
	}

}
