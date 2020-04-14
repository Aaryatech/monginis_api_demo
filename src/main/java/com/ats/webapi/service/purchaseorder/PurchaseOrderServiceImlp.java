package com.ats.webapi.service.purchaseorder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.purchaseorder.GetPurchaseOrderList;
import com.ats.webapi.model.purchaseorder.GetRmRateAndTax;
import com.ats.webapi.model.purchaseorder.GetPurchaseOrderList;
import com.ats.webapi.model.purchaseorder.PurchaseOrderDetail;
import com.ats.webapi.model.purchaseorder.PurchaseOrderDetailedList;
import com.ats.webapi.model.purchaseorder.PurchaseOrderHeader;
import com.ats.webapi.model.purchaseorder.TransporterDetails;
import com.ats.webapi.repository.FrItemStockConfigureRepository;
import com.ats.webapi.repository.GetRmRateAndTaxRepository;
import com.ats.webapi.repository.PurchaseOrderDetailRepository;
import com.ats.webapi.repository.PurchaseOrderHeaderRepository;
import com.ats.webapi.repository.UpdateSeetingForPBRepo;

@Service
public class PurchaseOrderServiceImlp implements PurchaseOrderService{

	//private static  List<PurchaseOrderHeader> purchaseOrderHeader = new ArrayList<PurchaseOrderHeader>();
  
	@Autowired
	PurchaseOrderHeaderRepository purchaseOrderHeaderRepository;
	
	@Autowired
	PurchaseOrderDetailRepository purchaseOrderDetailRepository;
	
	@Autowired
	GetRmRateAndTaxRepository getRmRateAndTaxRepository;
	
	@Autowired
	UpdateSeetingForPBRepo updateSeetingForPBRepo;
	
	
	
	@Override
	public Info insertHeader(PurchaseOrderHeader purchaseOrderHeader) {
		PurchaseOrderHeader pOHeader=new PurchaseOrderHeader();
		pOHeader=purchaseOrderHeaderRepository.save(purchaseOrderHeader);
		
		int headerId=pOHeader.getPoId();
		
		//PurchaseOrderDetail PurchaseOrderDetail=new PurchaseOrderDetail();
		//List<PurchaseOrderDetail> purchaseOrderDetailList=purchaseOrderHeader.getPurchaseOrderDetail();
		System.out.println("purchaseOrderHeader"+purchaseOrderHeader.toString());
		System.out.println("purchaseOrderHeader"+purchaseOrderHeader.getPurchaseOrderDetail().toString());
		
		for(int i=0;i<purchaseOrderHeader.getPurchaseOrderDetail().size();i++)
		{
			PurchaseOrderDetail purchaseOrderDetail=purchaseOrderHeader.getPurchaseOrderDetail().get(i);
			purchaseOrderDetail.setPoId(headerId);
			purchaseOrderDetailRepository.save(purchaseOrderDetail);
		}
		Info info=new Info();
		if(pOHeader!=null)
		{
			info.setError(false);
			info.setMessage("Insert Successfully");
			updateSeetingForPBRepo.updateSeetingForPurBill( purchaseOrderHeader.getPoNo()+1, "po_no");
			
		}
		else
		{
			info.setError(true);
			info.setMessage("Insert UnSuccessfully");
		}	
		 
		return info;
	}


	@Override
	public GetPurchaseOrderList perchaseorderList(int suppId) {
		
	 
		GetPurchaseOrderList getPurchaseOrderList=new GetPurchaseOrderList();
		ErrorMessage errorMessage=new   ErrorMessage();
		try
		{
			
			List<PurchaseOrderHeader> purchaseOrderHeaderList =purchaseOrderHeaderRepository.findBySuppId(suppId);
			 
			getPurchaseOrderList.setPurchaseOrderHeaderList(purchaseOrderHeaderList);
			
		
			
			if(purchaseOrderHeaderList!=null)
			{
				errorMessage.setError(false);
				errorMessage.setMessage("Successfully");
			}
			else
			{
				errorMessage.setError(true);
				errorMessage.setMessage("UnSuccessfully");
			}
			 
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			errorMessage.setError(true);
			errorMessage.setMessage(" failed");
			getPurchaseOrderList.setErrorMessage(errorMessage);
		}
		return getPurchaseOrderList;
		
		
		
		
	}


	@Override
	public PurchaseOrderDetailedList purchaseOrderDetailedList(int poId) {
		
		PurchaseOrderDetailedList purchaseOrderDetailed = new PurchaseOrderDetailedList();
		ErrorMessage errorMessage=new ErrorMessage();
		try
		{
			List<PurchaseOrderDetail> purchaseOrderDetaillist = purchaseOrderDetailRepository.purchaseOrderDetaillist(poId);
			purchaseOrderDetailed.setPurchaseOrderDetaillist(purchaseOrderDetaillist);
			errorMessage.setError(false);
			errorMessage.setMessage("success");
			purchaseOrderDetailed.setErrorMessage(errorMessage);
			System.out.println("LIst in nService :"+purchaseOrderDetailed.toString() );
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			errorMessage.setError(true);
			errorMessage.setMessage("unsuccess");
			purchaseOrderDetailed.setErrorMessage(errorMessage);
		}
		return purchaseOrderDetailed;
		
	}


	@Override
	public GetPurchaseOrderList getStatusWisePerchaseOrderList(List<String> status) {
		
		GetPurchaseOrderList getPurchaseOrderList=new GetPurchaseOrderList();
		ErrorMessage errorMessage=new   ErrorMessage();
		try
		{
			
			List<PurchaseOrderHeader> purchaseOrderHeaderList =purchaseOrderHeaderRepository.getPoByStatus(status);
			 
			getPurchaseOrderList.setPurchaseOrderHeaderList(purchaseOrderHeaderList);
			if(purchaseOrderHeaderList!=null)
			{
				errorMessage.setError(false);
				errorMessage.setMessage("Successfully");
			}
			else
			{
				errorMessage.setError(true);
				errorMessage.setMessage("UnSuccessfully");
			}
			 
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			errorMessage.setError(true);
			errorMessage.setMessage(" failed");
			getPurchaseOrderList.setErrorMessage(errorMessage);
		}
		return getPurchaseOrderList;
		
	}


	@Override
	public Info deletePoRecord(int poId) {
		Info info = new Info();
		
		try
		{
			int deletepo =purchaseOrderHeaderRepository.deletePoRecord(poId);
			if(deletepo==1)
			{
				info.setError(false);
				info.setMessage("successfully deleted");
			}
			else
			{
				info.setError(true);
				info.setMessage("error while deleting");
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public PurchaseOrderHeader getpurchaseorderHeaderWithDetailed(int poId) {
		PurchaseOrderHeader pOHeader=new PurchaseOrderHeader();
		try
		{
			pOHeader = purchaseOrderHeaderRepository.findbyPoId(poId);
			
			List<PurchaseOrderDetail> purchaseOrderDetaillist = purchaseOrderDetailRepository.purchaseOrderDetaillist(poId);
			pOHeader.setPurchaseOrderDetail(purchaseOrderDetaillist);
			
			
			System.out.println("purchase order header with detailed "+pOHeader.toString());
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return pOHeader;
		
		
	}


	@Override
	public GetRmRateAndTax getRmDetailById(int rmId, int suppId) {
		 
		GetRmRateAndTax getRmRateAndTax=null;
		GetRmRateAndTax getRmRateAndTax1=getRmRateAndTaxRepository.getRmDetailById(rmId,suppId);
		if(getRmRateAndTax1==null)
		{
			System.out.println("List is null");
		}
		else {
			getRmRateAndTax = getRmRateAndTax1;
			System.out.println("List  :  "+getRmRateAndTax1.toString());
		}
		
		return getRmRateAndTax;
	}

 
	

}
