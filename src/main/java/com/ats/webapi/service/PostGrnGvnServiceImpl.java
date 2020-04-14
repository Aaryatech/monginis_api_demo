package com.ats.webapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.GrnGvn;
import com.ats.webapi.model.grngvn.GrnGvnHeader;
import com.ats.webapi.repository.PostGrnGvnRepository;
import com.ats.webapi.repository.UpdateBillDetailForGrnGvnRepository;
import com.ats.webapi.repository.grngvnheader.GrnGvnHeaderRepo;
import com.ats.webapi.repository.grngvnheader.UpdateGrnGvnHeaderForCNRepo;

@Service
public class PostGrnGvnServiceImpl implements PostGrnGvnService {
	
	
	@Autowired
	PostGrnGvnRepository grnGvnRepository;
	
	
	@Autowired
	UpdateBillDetailForGrnGvnRepository updateBillDetailForGrnGvnRepository;
	
	@Autowired
	GrnGvnHeaderRepo grnGvnHeaderRepo;

	@Autowired
	UpdateGrnGvnHeaderForCNRepo updateGrnGvnHeaderForCNRepo;
	
//Prev Grn Save method commented on 15 FEB
	/*@Override
	public GrnGvn saveGrnGvn(List<GrnGvn> grnGvnList) {
		
		GrnGvn grnGvnReturnList=new GrnGvn();
		
		for(int i=0;i<grnGvnList.size();i++) {
			
			grnGvnReturnList=grnGvnRepository.save(grnGvnList.get(i));
			
			//14 FEb to be used on 15 feb when billdetil no inserted in grn table 
			//int result=updateBillDetailForGrnGvnRepository.updateBillDetailForGrnGvnInsert(
					//grnGvnReturnList.getBillNo(), 1);
			
		}
		
	return grnGvnReturnList;
	
	}*/
	
	//14 FEB changed 
	@Override
	public int  updateBill(int billDetailNo) {
		
			int billUpdate=updateBillDetailForGrnGvnRepository.updateBillDetailForGrnGvnInsert(billDetailNo, 1);
		
		return billUpdate;
		
	}

	
	//Grn Save method created  on 15 FEB
	@Override
	public GrnGvnHeader saveGrnGvnHeader(GrnGvnHeader header) {
	
		GrnGvnHeader grnGvnHeader=new GrnGvnHeader();
		
		try {
			
			grnGvnHeader=grnGvnHeaderRepo.save(header);
			
			int headerId=grnGvnHeader.getGrnGvnHeaderId();
			
			GrnGvn grnGvnReturnList=new GrnGvn();
			
			for(int i=0;i<header.getGrnGvn().size();i++) {
				
			if(header.getGrnGvn().get(i).getGrnGvnQty()>0) {
				header.getGrnGvn().get(i).setGrnGvnHeaderId(headerId);
				grnGvnReturnList=new GrnGvn();
				grnGvnReturnList=grnGvnRepository.save(header.getGrnGvn().get(i));
				
			}
				
				//14 FEb to be used on 15 feb when billdetil no inserted in grn table
				
				if(header.getIsGrn()==1) {
				int result=updateBillDetailForGrnGvnRepository.updateBillDetailForGrnGvnInsert(
						grnGvnReturnList.getBillDetailNo(), 1);
				
				System.out.println("Bill Detail Updated For Gvn response "+result);
				}
				else {
					
					System.out.println("It is Gvn So no need to Update Bill Detail for GVN Insert Against bill_detail ");
				}
			}
			
		}catch (Exception e) {
				System.out.println("EXCE in saving grn Header and details "+e.getMessage());
		
				e.printStackTrace();
		}
		
		return grnGvnHeader;
	}

//forced to implement not to consider
	@Override
	public GrnGvn saveGrnGvn(List<GrnGvn> grnGvn) {
		// TODO Auto-generated method stub
		return null;
	}

}
