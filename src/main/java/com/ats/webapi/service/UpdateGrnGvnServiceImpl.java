package com.ats.webapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.repository.UpdateGrnGvnRepository;

@Service
public class UpdateGrnGvnServiceImpl implements  UpdateGrnGvnService {
	
	@Autowired
	UpdateGrnGvnRepository updateGrnGvnRepository;

	@Override
	public int updateGrnForGate(int approvedLoginGate,int aprQtyGate, String approveimedDateTimeGate, String approvedRemarkGate,
			int grnGvnStatus,int grnGvnId) {
		
		int i=updateGrnGvnRepository.updateGateGrn(approvedLoginGate, aprQtyGate, approveimedDateTimeGate, approvedRemarkGate, grnGvnStatus, grnGvnId);
		
		
		
		return i;
	}

	@Override
	public int updateGrnForAcc(int approvedLoginAcc, int aprQtyAcc,String approvedDateTimeAcc, String approvedRemarkAcc,
			int grnGvnStatus,float aprTaxableAmt,float aprTotalTax,float aprSgstRs,float aprCgstRs,float aprIgstRs,float aprGrandTotal,
			float aprROff,int grnGvnId) {

		int i=updateGrnGvnRepository.updateAccGrn(approvedLoginAcc, aprQtyAcc, approvedDateTimeAcc, approvedRemarkAcc, grnGvnStatus, aprTaxableAmt, aprTotalTax, aprSgstRs, aprCgstRs, aprIgstRs, aprGrandTotal, aprROff, grnGvnId);
		
		
		return i;
	}

	@Override
	public int updateGrnGvnForStore(int approvedLoginStore,int aprQtyStore, String approvedDateTimeStore, String approvedRemarkStore,
			int grnGvnStatus, int grnGvnId) {
		
		int i=updateGrnGvnRepository.updateStoreGvn(approvedLoginStore,aprQtyStore, approvedDateTimeStore, approvedRemarkStore, grnGvnStatus, grnGvnId);
				
				return i;
		
	}
	
	
	
	

}
