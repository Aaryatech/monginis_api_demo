package com.ats.webapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.bom.BillOfMaterialDetailed;
import com.ats.webapi.model.bom.BillOfMaterialHeader;
import com.ats.webapi.model.bom.GetBillOfMaterialList;
import com.ats.webapi.repository.BillOfMaterialDetailedRepository;
import com.ats.webapi.repository.BillOfMaterialRepository;

@Service
public class BillOfMaterialServiceImp implements BillOfMaterialService{

	@Autowired
	BillOfMaterialRepository billOfMaterialRepository;
	
	@Autowired
	BillOfMaterialDetailedRepository billOfMaterialDetailedRepository;
	
	@Override
	public GetBillOfMaterialList getBillOfMaterialithDate(String frmdate, String todate, int bmsDeptId, int mixDeptId) {

		GetBillOfMaterialList getBillOfMaterialList = new GetBillOfMaterialList();
		ErrorMessage errorMessage = new ErrorMessage();
		System.out.println("frmdate  "+frmdate+"todate  "+todate);
		try
		{
			List<BillOfMaterialHeader> billOfMaterialHeaderList =  billOfMaterialRepository.getAlllist(frmdate, todate,bmsDeptId,mixDeptId);
			
			/*for(int i=0;i<billOfMaterialHeaderList.size();i++)
			{
				List<BillOfMaterialDetailed> listBillOfMaterialDetailed = new ArrayList<BillOfMaterialDetailed>();
				int req=billOfMaterialHeaderList.get(i).getReqId();
				System.out.println("reqId  "+req);
				listBillOfMaterialDetailed = billOfMaterialDetailedRepository.getBomdetailedListById(req);
				billOfMaterialHeaderList.get(i).setBillOfMaterialDetailed(listBillOfMaterialDetailed);
			}*/
			getBillOfMaterialList.setBillOfMaterialHeader(billOfMaterialHeaderList);
			errorMessage.setError(false);
			errorMessage.setMessage("success");
			getBillOfMaterialList.setErrorMessage(errorMessage);
			
			
		}catch(Exception e)
		{
			e.getStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("unsuccess");
			getBillOfMaterialList.setErrorMessage(errorMessage);
		}
		return getBillOfMaterialList;
		
	}
	
	@Override
	public BillOfMaterialHeader gettBomdetaildwithId(int reqId) {
		
		BillOfMaterialHeader billOfMaterial = new BillOfMaterialHeader();
		try
		{
			billOfMaterial=billOfMaterialRepository.getByReqstId(reqId);
			
			
				List<BillOfMaterialDetailed> billOfMaterialDetailed= new ArrayList<BillOfMaterialDetailed>();
				billOfMaterialDetailed=billOfMaterialDetailedRepository.getBomdetailedListById(reqId);
				billOfMaterial.setBillOfMaterialDetailed(billOfMaterialDetailed);
				
			
					
		}catch(Exception e)
		{
			System.out.println("in Implementation  "+e.getMessage());
		}
		return billOfMaterial;
		
	}

	@Override
	public GetBillOfMaterialList getallBOMHeaderList() {
		
		GetBillOfMaterialList getBillOfMaterialList = new GetBillOfMaterialList();
		ErrorMessage errorMessage = new ErrorMessage();
		try
		{
			List<BillOfMaterialHeader> billOfMaterialHeaderList =  billOfMaterialRepository.findBillOfMaterialHeaderByDelStatusOrderByReqIdDesc(0);
			
			/*for(int i=0;i<billOfMaterialHeaderList.size();i++)
			{
				List<BillOfMaterialDetailed> listBillOfMaterialDetailed = new ArrayList<BillOfMaterialDetailed>();
				int req=billOfMaterialHeaderList.get(i).getReqId();
				System.out.println("reqId  "+req);
				listBillOfMaterialDetailed = billOfMaterialDetailedRepository.getBomdetailedListById(req);
				billOfMaterialHeaderList.get(i).setBillOfMaterialDetailed(listBillOfMaterialDetailed);
			}*/
			getBillOfMaterialList.setBillOfMaterialHeader(billOfMaterialHeaderList);
			errorMessage.setError(false);
			errorMessage.setMessage("success");
			getBillOfMaterialList.setErrorMessage(errorMessage);
			
			
		}catch(Exception e)
		{
			e.getStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("unsuccess");
			getBillOfMaterialList.setErrorMessage(errorMessage);
		}
		return getBillOfMaterialList;
		
	}

	@Override
	public GetBillOfMaterialList getBillOfMaterialBmsToStoreDate(int fromDept, int toDept, String frmdate,
			String todate) {
		GetBillOfMaterialList getBillOfMaterialList = new GetBillOfMaterialList();
		ErrorMessage errorMessage = new ErrorMessage();
		System.out.println("frmdate  "+frmdate+"todate  "+todate);
		try
		{
			List<BillOfMaterialHeader> billOfMaterialHeaderList =  billOfMaterialRepository.getAlllist(fromDept, toDept, frmdate, todate);
			
			 
			getBillOfMaterialList.setBillOfMaterialHeader(billOfMaterialHeaderList);
			errorMessage.setError(false);
			errorMessage.setMessage("success");
			getBillOfMaterialList.setErrorMessage(errorMessage);
			
			
		}catch(Exception e)
		{
			e.getStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("unsuccess");
			getBillOfMaterialList.setErrorMessage(errorMessage);
		}
		return getBillOfMaterialList;
	}

	@Override
	public GetBillOfMaterialList getBillOfMaterialBmsToStoreDate(int fromDept, int toDept, List<String> status) {
		GetBillOfMaterialList getBillOfMaterialList = new GetBillOfMaterialList();
		ErrorMessage errorMessage = new ErrorMessage();
		 
		try
		{
			List<BillOfMaterialHeader> billOfMaterialHeaderList =  billOfMaterialRepository.getAlllist(fromDept, toDept, status);
			
			 
			getBillOfMaterialList.setBillOfMaterialHeader(billOfMaterialHeaderList);
			errorMessage.setError(false);
			errorMessage.setMessage("success");
			getBillOfMaterialList.setErrorMessage(errorMessage);
			
			
		}catch(Exception e)
		{
			e.getStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("unsuccess");
			getBillOfMaterialList.setErrorMessage(errorMessage);
		}
		return getBillOfMaterialList;
	}

	 
	
	/*@Override
	public ErrorMessage updatestatus(int reqId) {
		
		ErrorMessage errorMessage = new ErrorMessage();
		try
		{
			int update=billOfMaterialRepository.updatestatus(reqId);
			if(update==1)
			{
				System.out.println("updated");
				errorMessage.setError(false);
				errorMessage.setMessage("success");
			}
			else
			{
				System.out.println("failed");
				errorMessage.setError(true);
				errorMessage.setMessage("failed");
			}
			
				
			
					
		}catch(Exception e)
		{
			System.out.println("in Implementation  "+e.getMessage());
		}
		return errorMessage;
		
	}*/
	
	
	

}
