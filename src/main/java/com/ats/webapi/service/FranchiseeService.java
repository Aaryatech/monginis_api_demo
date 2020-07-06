package com.ats.webapi.service;

import java.util.List;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.FrLoginResponse;
import com.ats.webapi.model.FrTarget;
import com.ats.webapi.model.FrTargetList;
import com.ats.webapi.model.FrTotalSale;
import com.ats.webapi.model.Franchise;
import com.ats.webapi.model.FranchiseSup;
import com.ats.webapi.model.FranchiseSupList;
import com.ats.webapi.model.Franchisee;
import com.ats.webapi.model.Info;

public interface FranchiseeService {


	public ErrorMessage saveFranchisee(Franchisee franchisee);

	public List<Franchisee> findAllFranchisee();

	public Franchisee findFranchisee(int frId);

	public String findFranchiseeByFrCode(String frCode, String passwordKey);

	public FranchiseSup saveFranchiseSup(FranchiseSup franchiseSup);

	public Info deleteFranchiseSup(int frId);

	public FranchiseSupList getFranchiseSupList();

	public FranchiseSup getFranchiseSup(int id);

	public Info saveFrTarget(List<FrTarget> frTargetList);

	public FrTargetList getFrTargetList(int frId, int year);

	public FrTotalSale getFrTargetList(int frId, int month, int year);

	public Info updateAdminPwd(int frId, String adminPwd);

	public Info updateFranchiseSupUsrPwd(int frId, String pass2, String pass3);

	public FranchiseSup getFrSupByFrId(int frId);

	public FrLoginResponse getLogin(String fr_code, String fr_password);

	//****************************************************************//
	
	public Franchisee getFranchiseeByFrCode(String frCode);

	public Franchisee findByFrId(int frId);

	public String findFrEmployeeByEmpId(int empId, int frId);
	
	
}
