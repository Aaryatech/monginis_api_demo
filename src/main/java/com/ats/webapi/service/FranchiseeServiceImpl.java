package com.ats.webapi.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.FrEmpLoginResp;
import com.ats.webapi.model.FrLoginResponse;
import com.ats.webapi.model.FrTarget;
import com.ats.webapi.model.FrTargetList;
import com.ats.webapi.model.FrTotalSale;
import com.ats.webapi.model.Franchise;
import com.ats.webapi.model.FranchiseSup;
import com.ats.webapi.model.FranchiseSupList;
import com.ats.webapi.model.Franchisee;
import com.ats.webapi.model.GetFranchiseSup;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.LoginInfo;
import com.ats.webapi.model.pettycash.FrEmpMaster;
import com.ats.webapi.repo.FrEmpMasterRepo;
import com.ats.webapi.repository.FrTargetRepository;
import com.ats.webapi.repository.FrTotalSaleRepository;
import com.ats.webapi.repository.FranchiseRepository;
import com.ats.webapi.repository.FranchiseSupRepository;
import com.ats.webapi.repository.FranchiseeRepository;
import com.ats.webapi.repository.GetFranchiseSupRepository;
import com.ats.webapi.util.JsonUtil;

@Service
public class FranchiseeServiceImpl implements FranchiseeService {

    @Autowired
    private FranchiseeRepository franchiseeRepository;
    @Autowired
    FranchiseRepository franchiseRepository;
    @Autowired
    FranchiseSupRepository franchiseSupRepository;
    
    @Autowired
    GetFranchiseSupRepository getFrSupRepository;
    
    @Autowired
    FrTargetRepository frTargetRepository;
    
    @Autowired
    FrTotalSaleRepository frTotalSaleRepository;
    
    @Autowired FrEmpMasterRepo frEmpRepo;
    
	@Override
	public ErrorMessage saveFranchisee(Franchisee franchisee) {
		
		Franchisee dbFranchisee= franchiseeRepository.save(franchisee);
		ErrorMessage errorMessage=new ErrorMessage();

		if(!dbFranchisee.equals(null))
		{
		 errorMessage.setError(false);
		 errorMessage.setMessage("Franchisee Inserted Successfully");
		
		}
		else
		{
			errorMessage.setError(true);
			errorMessage.setMessage("Franchisee insertion Failed");
			
		}
		return errorMessage;

	}

	@Override
	public List<Franchisee> findAllFranchisee() {
		 List<Franchisee> franchisee=new ArrayList<Franchisee>();
			franchisee=franchiseeRepository.findAllByDelStatusOrderByFrNameAsc(0);
	
		
		return franchisee;
	}

	@Override
	public Franchisee findFranchisee(int frId) {
		Franchisee franchisee=franchiseeRepository.findOne(frId);
	     return franchisee;
	}

	@Override
	public String findFranchiseeByFrCode(String frCode, String frPassword) {
	
		String dbFrCode = null;
		String dbPassword = null;
		String jsonFr = "{}";
        Franchise dbFranchisee=new Franchise();

			
			FrLoginResponse frLoginResponse = new FrLoginResponse();
			LoginInfo loginInfo=new LoginInfo();
			try {
				dbFranchisee = franchiseRepository.findByFrCodeAndDelStatus(frCode,0);
				System.out.println(" details "+dbFranchisee.toString());
				
				dbFrCode = dbFranchisee.getFrCode();
				dbPassword = dbFranchisee.getFrPassword();
			} catch (Exception e) {
				
				System.out.println("Exception while finding prev fr "+e.getMessage());
				frLoginResponse = new FrLoginResponse();
				frLoginResponse.setFranchisee(dbFranchisee);
				loginInfo.setError(true);
				loginInfo.setAccessRight(0);

				loginInfo.setMessage("Franchisee Not Registerd");
				frLoginResponse.setLoginInfo(loginInfo);
				jsonFr = JsonUtil.javaToJson(frLoginResponse);
			}
			try {
				if (dbFranchisee.getFrCode() == null || dbFranchisee.getFrPassword() == null||dbFranchisee.getFrCode().equalsIgnoreCase("")||dbFranchisee.getFrPassword().equalsIgnoreCase("")) {

				
					System.out.println("Exception fr details null ");
					
					 frLoginResponse.setFranchisee(dbFranchisee);
					 loginInfo.setError(true);
 					loginInfo.setAccessRight(0);
					 loginInfo.setMessage("Franchisee Not Registered");
					 frLoginResponse.setLoginInfo(loginInfo);
					jsonFr = JsonUtil.javaToJson(frLoginResponse);
					
				} else if (dbFrCode.equalsIgnoreCase(frCode) && dbPassword.equals(frPassword)) {
					
				
					frLoginResponse.setFranchisee(dbFranchisee);
					loginInfo.setError(false);
					loginInfo.setAccessRight(1);
					loginInfo.setMessage("Franchisee displayed Successfully");
					frLoginResponse.setLoginInfo(loginInfo);
					jsonFr = JsonUtil.javaToJson(frLoginResponse);

				} else if (dbFrCode.equalsIgnoreCase(frCode) && dbPassword != frPassword) {
					
					FranchiseSup franchiseSup=franchiseSupRepository.findFranchiseSupByFrId(dbFranchisee.getFrId());

					System.out.println("FranchiseSup"+franchiseSup.toString());
                    if(franchiseSup!=null) {
                    	
                    	if(franchiseSup.getPass1().equals(frPassword))
                    	{
                    		frLoginResponse.setFranchisee(dbFranchisee);
        					loginInfo.setError(false);
        					loginInfo.setAccessRight(1);
        					loginInfo.setMessage("Franchisee displayed Successfully");
        					frLoginResponse.setLoginInfo(loginInfo);
        					jsonFr = JsonUtil.javaToJson(frLoginResponse);
                    	}
                    	else
                    		if(franchiseSup.getPass2().equals(frPassword))
                    		{
                    			frLoginResponse.setFranchisee(dbFranchisee);
            					loginInfo.setError(false);
            					loginInfo.setAccessRight(2);
            					loginInfo.setMessage("Franchisee displayed Successfully");
            					frLoginResponse.setLoginInfo(loginInfo);
            					jsonFr = JsonUtil.javaToJson(frLoginResponse);
                    		}
                    		else
                        		if(franchiseSup.getPass3().equals(frPassword))
                        		{
                        			frLoginResponse.setFranchisee(dbFranchisee);
                					loginInfo.setError(false);
                					loginInfo.setAccessRight(3);
                					loginInfo.setMessage("Franchisee displayed Successfully");
                					frLoginResponse.setLoginInfo(loginInfo);
                					jsonFr = JsonUtil.javaToJson(frLoginResponse);
                        		}
                        		else
                        		{

            						frLoginResponse = new FrLoginResponse();
            					 loginInfo.setError(true);
             					loginInfo.setAccessRight(0);

            					 loginInfo.setMessage("Invalid login details");
            					 frLoginResponse.setLoginInfo(loginInfo);
            					 jsonFr = JsonUtil.javaToJson(frLoginResponse);
                        		}
					
                    }
                    
				}
			} catch (Exception e) {
				System.out.println("Exception while converting prev fr "+e.getMessage());
				frLoginResponse = new FrLoginResponse();
				 frLoginResponse.setFranchisee(dbFranchisee);
				 loginInfo.setError(true);
					loginInfo.setAccessRight(0);

				 loginInfo.setMessage("Franchisee Not Registered");
			     frLoginResponse.setLoginInfo(loginInfo);
				jsonFr = JsonUtil.javaToJson(frLoginResponse);
			}
			return jsonFr;

		}

	@Override
	public FranchiseSup saveFranchiseSup(FranchiseSup franchiseSup) {

		FranchiseSup franchiseSupRes=franchiseSupRepository.saveAndFlush(franchiseSup);
		return franchiseSupRes;
	}

	@Override
	public Info deleteFranchiseSup(int frId) {

		int delStatus=franchiseSupRepository.deleteFranchiseSup(frId);
		Info info=new Info();
		if(delStatus==1)
		{
			info.setError(false);
			info.setMessage("Franchisee Sup Deleted Successfully");
		}
		else
		{
			info.setError(true);
			info.setMessage("Franchisee Sup Deletion Failed ");
		}
		return info;
	}

	@Override
	public FranchiseSupList getFranchiseSupList() {

		List<GetFranchiseSup> getFrSupList=getFrSupRepository.findByDelStatus();
		FranchiseSupList franchiseSupList=new FranchiseSupList();
		Info info=new Info();
		
		if(!getFrSupList.isEmpty())
		{
			info.setMessage("Franchisee SupList Found Successfully.");
			info.setError(false);
			franchiseSupList.setInfo(info);
			franchiseSupList.setFrList(getFrSupList);
		}
		else
		{
			info.setMessage("Franchisee SupList Not Found.");
			info.setError(true);
			franchiseSupList.setInfo(info);
		}
		return franchiseSupList;
	}

	@Override
	public FranchiseSup getFranchiseSup(int id) {

		FranchiseSup franchiseSup=franchiseSupRepository.findFranchiseSupById(id);
		return franchiseSup;
	}

	@Override
	public Info saveFrTarget(List<FrTarget> frTargetList) {

		Info info=null;
		try
		{
		
		for(int i=0;i<frTargetList.size();i++)
		{
			FrTarget frTarget=frTargetList.get(i);
			FrTarget frTargetRes=frTargetRepository.saveAndFlush(frTarget);
		}
		 info=new Info();
		 info.setError(false);
		 info.setMessage("Fr Target Saved Successfully");
		}
		catch(Exception e)
		{
			info=new Info();
			info.setError(true);
			info.setMessage("Fr Target Failed to Save");
			
			System.out.println("Exception In /saveFrTarget FrService");
		}
		return info;
	}

	@Override
	public FrTargetList getFrTargetList(int frId,int year) {

		List<FrTarget> frtargetListRes=frTargetRepository.findFrTargetByFrIdAndFrTargetYearAndDelStatus(frId,year,0);
		FrTargetList frTargetList=new FrTargetList();
		
		if(!frtargetListRes.isEmpty())
		{
			Info info=new Info();
			info.setError(false);
            info.setMessage("FrTarget Found Successfully.");
            frTargetList.setInfo(info);
			frTargetList.setFrTargetList(frtargetListRes);
		}
		else
		{
			Info info=new Info();
			info.setError(true);
            info.setMessage("FrTarget Not Found.");
            frTargetList.setInfo(info);
		}
		return frTargetList;
	}

	@Override
	public FrTotalSale getFrTargetList(int frId, int month, int year) {
		int frIdval=frId;
		FrTotalSale frTotalSale=new FrTotalSale();
		try {
		Date lastDate = getLastDateOfMonth(year,month);
		System.out.println("lastDate:"+lastDate);

		String firstDate=year+"-"+month+"-"+01;
		
		System.out.println("firstDate:"+firstDate);
		SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
		 frTotalSale=frTotalSaleRepository.findFrTotalSale(frId,firstDate,sm.format(lastDate));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		 float monthTarget=frTotalSaleRepository.findMonthSale(frId,month,year);
		 frTotalSale.setTargetAmt(monthTarget);
		 
		}
		catch(Exception e)
		{
			frTotalSale.setFrId(frId);
			frTotalSale.setMonth(month);
			frTotalSale.setTotalSale(0);
			System.out.println("Exc In getFrTargetList"+e.getMessage());
		}
		return frTotalSale;
	}
	public static Date getLastDateOfMonth(int year, int month) {
		  Calendar calendar = new GregorianCalendar(year, month,
		  Calendar.DAY_OF_MONTH);
		  calendar.set(Calendar.DAY_OF_MONTH,
		  calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		  return calendar.getTime();
		}

	@Override
	public Info updateAdminPwd(int frId, String adminPwd) {

		int updateStatus=franchiseeRepository.updateAdminPwd(frId,adminPwd);
		int updateFrPass=franchiseSupRepository.updateFrPwd(frId,adminPwd);
		Info info=new Info();
		if(updateStatus>=1&&updateFrPass>=1)
		{
			info.setError(false);
			info.setMessage("Admin Pwd Updated Successfully");
		}
		else
		{
			info.setError(true);
			info.setMessage("Admin Pwd Deletion Failed ");
		}
		return info;
	}

	@Override
	public Info updateFranchiseSupUsrPwd(int frId, String pass2, String pass3) {
		
		int updateStatus=franchiseSupRepository.updateFranchiseSupUserPwd(frId,pass2,pass3);
		
		Info info=new Info();
		if(updateStatus==1)
		{
			info.setError(false);
			info.setMessage("FrUsr Pwd Updated Successfully");
		}
		else
		{
			info.setError(true);
			info.setMessage("FrUsr Pwd Deletion Failed ");
		}
		return info;
	}

	@Override
	public FranchiseSup getFrSupByFrId(int frId) {
		FranchiseSup franchiseSup=franchiseSupRepository.findFranchiseSupByFrId(frId);
		return franchiseSup;
	}

	@Override
	public FrLoginResponse getLogin(String frCode, String frPassword) {
	
		String dbFrCode = null;
		String dbPassword = null;
		String jsonFr = "{}";
        Franchise dbFranchisee=new Franchise();

			
			FrLoginResponse frLoginResponse = new FrLoginResponse();
			LoginInfo loginInfo=new LoginInfo();
			try {
				dbFranchisee = franchiseRepository.findByFrCodeAndDelStatus(frCode,0);
				System.out.println(" details "+dbFranchisee.toString());
				
				dbFrCode = dbFranchisee.getFrCode();
				dbPassword = dbFranchisee.getFrPassword();
			} catch (Exception e) {
				
				System.out.println("Exception while finding prev fr "+e.getMessage());
				frLoginResponse = new FrLoginResponse();
				frLoginResponse.setFranchisee(dbFranchisee);
				loginInfo.setError(true);
				loginInfo.setAccessRight(0);

				loginInfo.setMessage("Franchisee Not Registerd");
				frLoginResponse.setLoginInfo(loginInfo);
				jsonFr = JsonUtil.javaToJson(frLoginResponse);
			}
			try {
				if (dbFranchisee.getFrCode() == null || dbFranchisee.getFrPassword() == null||dbFranchisee.getFrCode().equalsIgnoreCase("")||dbFranchisee.getFrPassword().equalsIgnoreCase("")) {

				
					System.out.println("Exception fr details null ");
					
					 frLoginResponse.setFranchisee(dbFranchisee);
					 loginInfo.setError(true);
 					loginInfo.setAccessRight(0);
					 loginInfo.setMessage("Franchisee Not Registered");
					 frLoginResponse.setLoginInfo(loginInfo);
					jsonFr = JsonUtil.javaToJson(frLoginResponse);
					
				} else if (dbFrCode.equalsIgnoreCase(frCode) && dbPassword.equals(frPassword)) {
					
				
					frLoginResponse.setFranchisee(dbFranchisee);
					loginInfo.setError(false);
					loginInfo.setAccessRight(1);
					loginInfo.setMessage("Franchisee displayed Successfully");
					frLoginResponse.setLoginInfo(loginInfo);
					jsonFr = JsonUtil.javaToJson(frLoginResponse);

				} else if (dbFrCode.equalsIgnoreCase(frCode) && dbPassword != frPassword) {
					
					FranchiseSup franchiseSup=franchiseSupRepository.findFranchiseSupByFrId(dbFranchisee.getFrId());

					System.out.println("FranchiseSup"+franchiseSup.toString());
                    if(franchiseSup!=null) {
                    	
                    	if(franchiseSup.getPass1().equals(frPassword))
                    	{
                    		frLoginResponse.setFranchisee(dbFranchisee);
        					loginInfo.setError(false);
        					loginInfo.setAccessRight(1);
        					loginInfo.setMessage("Franchisee displayed Successfully");
        					frLoginResponse.setLoginInfo(loginInfo);
        					jsonFr = JsonUtil.javaToJson(frLoginResponse);
                    	}
                    	else
                    		if(franchiseSup.getPass2().equals(frPassword))
                    		{
                    			frLoginResponse.setFranchisee(dbFranchisee);
            					loginInfo.setError(false);
            					loginInfo.setAccessRight(2);
            					loginInfo.setMessage("Franchisee displayed Successfully");
            					frLoginResponse.setLoginInfo(loginInfo);
            					jsonFr = JsonUtil.javaToJson(frLoginResponse);
                    		}
                    		else
                        		if(franchiseSup.getPass3().equals(frPassword))
                        		{
                        			frLoginResponse.setFranchisee(dbFranchisee);
                					loginInfo.setError(false);
                					loginInfo.setAccessRight(3);
                					loginInfo.setMessage("Franchisee displayed Successfully");
                					frLoginResponse.setLoginInfo(loginInfo);
                					jsonFr = JsonUtil.javaToJson(frLoginResponse);
                        		}
                        		else
                        		{

            						frLoginResponse = new FrLoginResponse();
            					 loginInfo.setError(true);
             					loginInfo.setAccessRight(0);

            					 loginInfo.setMessage("Invalid login details");
            					 frLoginResponse.setLoginInfo(loginInfo);
            					 jsonFr = JsonUtil.javaToJson(frLoginResponse);
                        		}
					
                    }
                    
				}
			} catch (Exception e) {
				System.out.println("Exception while converting prev fr "+e.getMessage());
				frLoginResponse = new FrLoginResponse();
				 frLoginResponse.setFranchisee(dbFranchisee);
				 loginInfo.setError(true);
					loginInfo.setAccessRight(0);

				 loginInfo.setMessage("Franchisee Not Registered");
			     frLoginResponse.setLoginInfo(loginInfo);
				jsonFr = JsonUtil.javaToJson(frLoginResponse);
			}
			return frLoginResponse;

		}

	@Override
	public Franchisee getFranchiseeByFrCode(String frCode) {
		// TODO Auto-generated method stub
		Franchisee fr = new Franchisee(); 
		 fr = franchiseeRepository.findByfrCodeAndDelStatus(frCode,0);
		return fr;
	}

	@Override
	public Franchisee findByFrId(int frId) {
		Franchisee fr = new Franchisee(); 
		return fr = franchiseeRepository.findOne(frId);
	}

	@Override
	public String findFrEmployeeByEmpId(int empId, int frId) {
		String frEmpMob = null;
		String frEmpPass = null;
		String jsonFr = "{}";
		
		Franchisee franchisee = new Franchisee();
		FrEmpMaster frEmp = new FrEmpMaster();
		LoginInfo loginInfo=new LoginInfo();
		
		FrEmpLoginResp empLogResp = new FrEmpLoginResp();
		try { 
			frEmp=frEmpRepo.findByFrIdAndFrEmpIdAndDelStatus(frId,empId, 0);
			franchisee = franchiseeRepository.findOne(frId);
			System.out.println("Franchisee Employee Details : "+frEmp);
			loginInfo.setError(false);
			loginInfo.setAccessRight(1);
			frEmpMob = frEmp.getFrEmpContact();
			frEmpPass = frEmp.getPassword();
			empLogResp.setFrEmp(frEmp);
			
			empLogResp.setFranchisee(franchisee);
			empLogResp.setLoginInfo(loginInfo);
			jsonFr = JsonUtil.javaToJson(empLogResp);
		}catch (Exception e) {
			e.printStackTrace();
			
			System.out.println("Exception while finding prev fr "+e.getMessage());
			
			empLogResp.setFrEmp(frEmp);
			empLogResp.setFranchisee(franchisee);
			loginInfo.setError(true);
			loginInfo.setAccessRight(0);

			loginInfo.setMessage("Franchisee Employee Not Registerd");
			empLogResp.setLoginInfo(loginInfo);
			jsonFr = JsonUtil.javaToJson(empLogResp);
		}
		try {
			
			if (frEmp.getFrEmpContact() == null || frEmp.getPassword() == null||frEmp.getFrEmpContact().equalsIgnoreCase("")||frEmp.getPassword().equalsIgnoreCase("")) {

				System.out.println("Exception fr details null ");
				
				empLogResp.setFrEmp(frEmp);
				loginInfo.setError(true);
				loginInfo.setAccessRight(0);
				loginInfo.setMessage("Franchisee Employee Not Registered");
				empLogResp.setLoginInfo(loginInfo);
				jsonFr = JsonUtil.javaToJson(empLogResp);
				
			}
			
		}catch (Exception e) {
			System.out.println("Exception while converting prev fr "+e.getMessage());
			
			empLogResp.setFrEmp(frEmp);
			empLogResp.setFranchisee(franchisee);
			loginInfo.setError(true);
			loginInfo.setAccessRight(0);

			loginInfo.setMessage("Franchisee Employee Not Registered");
			empLogResp.setLoginInfo(loginInfo);
			jsonFr = JsonUtil.javaToJson(empLogResp);
		}
		
		return jsonFr;
	}
	
	
}
