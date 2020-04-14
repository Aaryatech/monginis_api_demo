package com.ats.webapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.ConfigureFranchisee;
import com.ats.webapi.model.Franchisee;
import com.ats.webapi.repository.SubCategoryRepository;
import com.ats.webapi.repository.TestFrRepository;

@Service("TestFrService")

public class TestFrImple implements TestFrService{

	@Autowired
	private TestFrRepository testFrRepository;

	@Override
	public List<ConfigureFranchisee> findFrMenus() {
		
		
		List<ConfigureFranchisee> list=testFrRepository.findAllProjectedNativeQuery();
		
		return list;
	}

}
