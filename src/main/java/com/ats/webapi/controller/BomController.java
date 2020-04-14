package com.ats.webapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.Info;
import com.ats.webapi.model.bom.BillOfMaterialDetailed;
import com.ats.webapi.model.bom.BillOfMaterialHeader;
import com.ats.webapi.model.prod.mixing.GetSpDetailForBom;
import com.ats.webapi.model.prod.mixing.GetSpDetailForBomList;
import com.ats.webapi.model.spprod.GetSpStation;
import com.ats.webapi.model.spprod.SpStationList;
import com.ats.webapi.repository.BillOfMaterialDetailedRepository;
import com.ats.webapi.repository.BillOfMaterialRepository;
import com.ats.webapi.repository.GetSpDetailForBomRepository;
import com.ats.webapi.repository.SpCkAllocDetailRepository;

@RestController
public class BomController {
 
	@Autowired 
	BillOfMaterialRepository billOfMaterialRepository;

	@Autowired
	BillOfMaterialDetailedRepository billOfMaterialDetailedRepository;
    
	@Autowired
	GetSpDetailForBomRepository getSpDetailForBomRepository;
	
	@Autowired
	SpCkAllocDetailRepository spCkAllocDetailRepository;
	
	@RequestMapping(value = { "/saveBom" }, method = RequestMethod.POST)
	public @ResponseBody Info saveBom(@RequestBody BillOfMaterialHeader billOfMaterialHeader) {

		Info info = new Info();
		
		System.out.println("Input Req Param "+billOfMaterialHeader.toString());
		try {

			BillOfMaterialDetailed bDetail=null;
			BillOfMaterialHeader billMatHeader = billOfMaterialRepository.save(billOfMaterialHeader);

			List<BillOfMaterialDetailed> bomDetailList = billOfMaterialHeader.getBillOfMaterialDetailed();

			int reqId = billMatHeader.getReqId();

			for (int i = 0; i < bomDetailList.size(); i++) {

				bomDetailList.get(i).setReqId(reqId);
                if(bomDetailList.get(i).getRmReqQty()>0) {  //added on 31 Aug 2018 by Mahesh
				 bDetail = billOfMaterialDetailedRepository.save(bomDetailList.get(i));
                }
				 System.out.println("Inside For Detail ");

			}

			if (billMatHeader != null) {

				info.setError(false);
				info.setMessage("insert successfull");
			}

		} catch (Exception e) {
			e.printStackTrace();

			System.out.println("Exce in Bom Insert " + e.getMessage());
		}

		return info;

	}
	
	@RequestMapping(value = { "/updateStatusWhileCompletProd" }, method = RequestMethod.POST)
	public @ResponseBody Info updateStatusWhileCompletProd(@RequestParam("prodId") int prodId,@RequestParam("isProduction") int isProduction) {
		
		int updateStatus=billOfMaterialRepository.updateStatusWhileCompletProd(prodId,isProduction);
	    Info info=new Info();
		
		if(updateStatus==1)
		{
			info.setError(false);
			info.setMessage("status Updated Successfully");
		}
		else
		{
			info.setError(true);
			info.setMessage("status Updation Failed");
		}
		
		
		return info;
	}
	
	@RequestMapping(value = { "/getSpDetailForBom" }, method = RequestMethod.POST)
	public @ResponseBody GetSpDetailForBomList getSpDetailForBom(@RequestParam int spId) {
		
		GetSpDetailForBomList getSpDetailForBom=new GetSpDetailForBomList();
		Info info=new Info();
		
		List<GetSpDetailForBom> getSpDetailForBomRes=getSpDetailForBomRepository.findSpDetailForBom(spId);
		
		if(!getSpDetailForBomRes.isEmpty())
		{
			info.setError(false);
            info.setMessage("GetSpDetailForBom List Found Successfully");
            getSpDetailForBom.setGetSpDetailForBomList(getSpDetailForBomRes);
            getSpDetailForBom.setInfo(info);
		}
		else
		{
			info.setError(true);
            info.setMessage("GetSpDetailForBom List Not Found");
            getSpDetailForBom.setInfo(info);	
         }
	                
		
		return getSpDetailForBom;
	}
	@RequestMapping(value = { "/updateIsBomOfSpAllocn" }, method = RequestMethod.POST)
	public @ResponseBody Info updateIsBomOfSpAlloc(@RequestParam("spCkAllocDId") int spCkAllocDId) {
		
		int spCkAllocdId=spCkAllocDetailRepository.updateIsBomOfSpAlloc(spCkAllocDId);
	    Info info=new Info();
		
		if(spCkAllocdId==1)
		{
			info.setError(false);
			info.setMessage("Sp Alloc Is Bom Updated Successfully");
		}
		else
		{
			info.setError(true);
			info.setMessage("Sp Alloc Is Bom Updation Failed");
		}
		
		
		return info;
	}
	
}
