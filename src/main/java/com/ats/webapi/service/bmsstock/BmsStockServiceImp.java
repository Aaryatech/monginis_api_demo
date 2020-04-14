package com.ats.webapi.service.bmsstock;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.BmsStockDetailed;
import com.ats.webapi.model.BmsStockHeader;
import com.ats.webapi.model.stock.GetBmsStock;
import com.ats.webapi.repository.BmsStockDetailedRepository;
import com.ats.webapi.repository.BmsStockHeaderRepository;
import com.ats.webapi.repository.bmsstock.GetBmsStockRepository;


@Service
public class BmsStockServiceImp implements BmsStockService {
	
	@Autowired
	BmsStockHeaderRepository bmsStockHeaderRepository;
	
	@Autowired
	BmsStockDetailedRepository bmsStockDetailedRepository;
	
	@Autowired
	GetBmsStockRepository getBmsStockRepository;
	
	@Override
	public BmsStockHeader insertBmsStock(BmsStockHeader bmsStockHeader) {
		
		BmsStockHeader bmsStockHeaderloc = new BmsStockHeader();
		
		try
		{
							
			bmsStockHeaderloc=bmsStockHeaderRepository.save(bmsStockHeader);
			int BmsHeaderId=bmsStockHeaderloc.getBmsStockId();
					
			for(int i=0;i<bmsStockHeader.getBmsStockDetailed().size();i++) 
				bmsStockHeader.getBmsStockDetailed().get(i).setBmsStockId(BmsHeaderId);
			
				bmsStockDetailedRepository.save(bmsStockHeader.getBmsStockDetailed()); 
			
			
		}catch(Exception e)
		{
			System.out.println("error while save stock "+e.getMessage());
		}
		return bmsStockHeaderloc;
		
	}

	@Override
	public	List<GetBmsStock> getBmsStock(String fromDate, String toDate, int rmType) {
		 
	 
		
		 
		
		 
		List<GetBmsStock> bmsStockDetailedList=getBmsStockRepository.getStockDetails(fromDate, toDate,rmType);
		 
		 
		System.out.println("BmsStock : "+bmsStockDetailedList.toString());
		
		return bmsStockDetailedList;
	}

	@Override
	public BmsStockHeader getBmsStockHeader(int status, int rmType) {
		BmsStockHeader bmsStockHeader=new BmsStockHeader();
		
		bmsStockHeader=bmsStockHeaderRepository.getStockDetails(status,  rmType);
		
		return bmsStockHeader;
	}

	@Override
	public BmsStockHeader getBmsStockForEdit(int type) {
		
		BmsStockHeader bmsStockHeader = new BmsStockHeader();
		List<BmsStockDetailed> bmsStockDetailed = new ArrayList<BmsStockDetailed>();
		try
		{
			bmsStockHeader = bmsStockHeaderRepository.getStockDetails(0,  type);
			
			if(bmsStockHeader!=null)
			{
			bmsStockDetailed=bmsStockDetailedRepository.getStockDetailsItem(bmsStockHeader.getBmsStockId());
			bmsStockHeader.setBmsStockDetailed(bmsStockDetailed);
			}
			
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return bmsStockHeader;
		 
	}

}
