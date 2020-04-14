package com.ats.webapi.service.tally;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.tally.FranchiseeList;

@Service
public interface FranchiseeService {

	public FranchiseeList getAllFranchisee();

	public ErrorMessage updateFranchisees(int customerId, int isTallySync);

}
