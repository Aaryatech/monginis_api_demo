package com.ats.webapi.service.tally;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.tally.SalesVoucher;
import com.ats.webapi.model.tally.SalesVoucherList;
import com.ats.webapi.repository.tally.TallySVoucherUpdateRepository;
import com.ats.webapi.repository.tally.TallySalesVoucherRepository;

@Service
public class SalesVoucherServiceImpl implements SalesVoucherService{

	@Autowired
	TallySalesVoucherRepository tallySalesVoucherRepository;

	@Autowired
	TallySVoucherUpdateRepository tallySVoucherUpdateRepository;
	
	@Override
	public SalesVoucherList getAllSalesVoucher() {
		
		 List<SalesVoucher> salesVoucherList=tallySalesVoucherRepository.findByIsTallySync();
			
		 SalesVoucherList sVoucherList=new SalesVoucherList();
			ErrorMessage errorMessage=new ErrorMessage();
			
			if(salesVoucherList==null)
			{
			
				errorMessage.setError(true);
				errorMessage.setMessage("Sales Voucher Not Found");
				
				sVoucherList.setErrorMessage(errorMessage);
			}
			else
			{
				errorMessage.setError(false);
				errorMessage.setMessage("Sales Voucher Found Successfully");
				
				sVoucherList.setSalesVoucherList(salesVoucherList);
				sVoucherList.setErrorMessage(errorMessage);
					
			}
		return sVoucherList;
	}

	@Override
	public ErrorMessage updateSalesVouchers(int billNo, int isTallySync) {

		ErrorMessage errorMessage=new ErrorMessage();
		
		int i=tallySVoucherUpdateRepository.updateSalesVouchers(billNo,isTallySync);
		if(i==1) {
		
		errorMessage.setError(false);
		errorMessage.setMessage("Sales Voucher Updated Successfully");
		}
		else
		{
			errorMessage.setError(false);
			errorMessage.setMessage("Sales Voucher Updation Failed");
			
		}
		return errorMessage;
		
	}
	
	
	
	
	
}
