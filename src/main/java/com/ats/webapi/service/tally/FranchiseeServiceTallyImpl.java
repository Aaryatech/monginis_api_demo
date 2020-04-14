package com.ats.webapi.service.tally;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.tally.Franchisee;
import com.ats.webapi.model.tally.FranchiseeList;
import com.ats.webapi.repository.tally.TallyFrUpdateRepository;
import com.ats.webapi.repository.tally.TallyFranchiseeRepository;

@Service
public class FranchiseeServiceTallyImpl  implements FranchiseeService {

	@Autowired
	TallyFranchiseeRepository tallyFranchiseeRepository;
	@Autowired
	TallyFrUpdateRepository tallyFrUpdateRepository;
	
	@Override
	public FranchiseeList getAllFranchisee() {
		
		List<Franchisee> franchiseeList=tallyFranchiseeRepository.findByIsTallySync();
		
		FranchiseeList allFranchiseeList=new FranchiseeList();
		ErrorMessage errorMessage=new ErrorMessage();
		
		if(franchiseeList==null)
		{
		
			errorMessage.setError(true);
			errorMessage.setMessage("Franchisee Not Found");
			
			allFranchiseeList.setErrorMessage(errorMessage);
		}
		else
		{
			errorMessage.setError(false);
			errorMessage.setMessage("Franchisee Found Successfully");
			
			allFranchiseeList.setFranchiseeList(franchiseeList);
			allFranchiseeList.setErrorMessage(errorMessage);
			
		}
		return allFranchiseeList;
	}

	@Override
	public ErrorMessage updateFranchisees(int customerId, int isTallySync) {

		ErrorMessage errorMessage=new ErrorMessage();
	
		int i=tallyFrUpdateRepository.updateFranchisee(customerId,isTallySync);
		
		if(i==1) {
		
		errorMessage.setError(false);
		errorMessage.setMessage("Franchisee Updated Successfully");
		}
		else
		{
			errorMessage.setError(false);
			errorMessage.setMessage("Franchisee Updation Failed");
			
		}
		return errorMessage;
	}

}
