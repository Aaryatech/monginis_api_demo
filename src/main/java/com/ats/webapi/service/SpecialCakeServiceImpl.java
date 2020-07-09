package com.ats.webapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.commons.Firebase;
import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.GetSpCkSupplement;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.OrderSpecialCake;
import com.ats.webapi.model.SearchSpCakeResponse;
import com.ats.webapi.model.SpCakeSupplement;
import com.ats.webapi.model.SpecialCake;
import com.ats.webapi.model.SpecialCakeList;
import com.ats.webapi.repository.ConfiSpCodeRepository;
import com.ats.webapi.repository.FranchiseSupRepository;
import com.ats.webapi.repository.GetSpCakeSupRepository;
import com.ats.webapi.repository.OrderSpCakeRepository;
import com.ats.webapi.repository.SpCakeSupRepository;
import com.ats.webapi.repository.SpecialCakeRepository;
import com.ats.webapi.util.JsonUtil;

@Service
public class SpecialCakeServiceImpl implements SpecialCakeService{
	
	String jsonSpecialCake="{}";
	SpecialCake specialcake=null;
	
	@Autowired
	SpecialCakeRepository specialcakeRepository;
	@Autowired
	OrderSpCakeRepository orderSpCakeRepository;
	@Autowired
	ConfiSpCodeRepository confiSpCodeRepository;
	
	@Autowired
	SpCakeSupRepository spCakeSupRepository;
	
	@Autowired
	GetSpCakeSupRepository getSpCakeSupRepository;
	@Autowired
	FranchiseSupRepository franchiseSupRepository;
	@Override
	public String save(SpecialCake specialcake) {
		
		SpecialCakeList specialCakeList=new SpecialCakeList();
		String jsonSpecialCake="";
		
		
		try {
			System.out.println("inside special cake insert");
			if(specialcake!=null) {
				
				    System.out.println("before save");
					specialcake=specialcakeRepository.save(specialcake);
					System.out.println("after save");
					
					Info info=new Info();
					info.setError(false);
					info.setMessage("Special cake inserted successfully ");
					jsonSpecialCake=JsonUtil.javaToJson(info);
					
					 try {
						    List<String> frTokens=franchiseSupRepository.findTokens();

						 for(String token:frTokens) {
				          Firebase.sendPushNotifForCommunication(token,"Special Cake Details Updated","Changes have been made in OPS at item level, SP level, in the rates. Kindly refer the OPS for exact changes made.","inbox");
						 }
				         }
				         catch(Exception e2)
				         {
					       e2.printStackTrace();
				         }
			}
			else {
				Info info=new Info();
				info.setError(true);
				info.setMessage("Special cake insert failure");
				jsonSpecialCake=JsonUtil.javaToJson(info);
			}
		
		}
		catch(Exception e ) {
			System.out.println("error in special cake insertion "+e.getMessage());
			
		}
		
		return jsonSpecialCake;
	}
	
	@Override
	public List<SpecialCake> showAllSpecialCake() {
		List<SpecialCake> specialCakeList=specialcakeRepository.findByDelStatusOrderBySpNameAsc(0);
		return specialCakeList;		
	}
	@Override
	public List<SpecialCake> showAllSpecialCakeOrderBySpCode() {
		List<SpecialCake> specialCakeList=specialcakeRepository.findByDelStatusOrderBySpCodeAsc(0);
		return specialCakeList;		
	}

	@Override
	public SpecialCake findSpecialCake(int spId) {
		SpecialCake specialCake=specialcakeRepository.findOne(spId);
		return specialCake;
	}

	@Override
	public SearchSpCakeResponse searchSpecialCake(String spCode) {
		
		OrderSpecialCake specialCake=null;
		SearchSpCakeResponse searchSpCakeResponse=new SearchSpCakeResponse();
		SpCakeSupplement  spCakeresponse=new SpCakeSupplement();
		ErrorMessage errorMessage=new ErrorMessage();
	    System.err.println("Special Cake Data:"+spCode);
	    specialCake=orderSpCakeRepository.findBySpCode(spCode);
	    System.err.println("Special Cake Data:"+specialCake.toString());
	    int spId=specialCake.getSpId();
	    
	    
		if(specialCake==null)
		{
			errorMessage.setError(true);
			errorMessage.setMessage("Special Cake Not Found");
			searchSpCakeResponse.setErrorMessage(errorMessage);
		}
		else
		{
			spCakeresponse=spCakeSupRepository.findBySpId(spId);
			errorMessage.setError(false);
			errorMessage.setMessage("Special Cake Found Successfully");
			searchSpCakeResponse.setErrorMessage(errorMessage);
			searchSpCakeResponse.setSpecialCake(specialCake);
			searchSpCakeResponse.setSpCakeSup(spCakeresponse);
		}
		
		return searchSpCakeResponse;
	}

	@Override
	public List<String> searchSpecialCakeSpCodes(List<Integer>items,int frId,int menuId) {
	    List<String> spCodeList=confiSpCodeRepository.findSpCode(items);//,frId,menuId

		return spCodeList;
	}

	@Override
	public SpCakeSupplement saveSpCakeSup(SpCakeSupplement spCakeSupplement) {

		SpCakeSupplement spCakeSupplementRes=null;
		List<SpCakeSupplement> spCakeSuppList=spCakeSupRepository.findBySpIdById(spCakeSupplement.getSpId());
		if(spCakeSuppList.size()==0 || spCakeSupplement.getId()!=0) {
		 spCakeSupplementRes=spCakeSupRepository.saveAndFlush(spCakeSupplement);
		}
		return spCakeSupplementRes;
	}

	@Override
	public Info deleteSpCakeSup(List<Integer> id) {

		Long isDel=spCakeSupRepository.deleteBySpIdIn(id);
		Info info=new Info();
		if(isDel>0)
		{
			info.setError(false);
			info.setMessage("SpCakeSupplement Deleted Successfully.");
		}
		else
		{
			info.setError(true);
			info.setMessage("SpCakeSupplement Deletion Failed.");
		}
		return info;
	}

	@Override
	public GetSpCkSupplement getSpCakeSupp(int id) {

		GetSpCkSupplement spCakeSupplement=getSpCakeSupRepository.findById(id);
		return spCakeSupplement;
	}

	@Override
	public List<GetSpCkSupplement> getSpCakeSupList() {
		List<GetSpCkSupplement> spSuppList;
     try {
    	 spSuppList=getSpCakeSupRepository.findByDelStatus(0);
    	 
     }
     catch (Exception e) {
    	 spSuppList=new ArrayList<GetSpCkSupplement>();
    	 e.printStackTrace();
	}
     return spSuppList;
	}

	@Override
	public List<SpecialCake> findSpecialCakes(List<Integer> spId) {
		
		List<SpecialCake> spList=specialcakeRepository.findBySpIdIn(spId);
		
		return spList;
	}
	
	

	@Override
	public SearchSpCakeResponse searchSpecialCakeBySpId(int spId) {
		OrderSpecialCake specialCake=null;
		SearchSpCakeResponse searchSpCakeResponse=new SearchSpCakeResponse();
		SpCakeSupplement  spCakeresponse=new SpCakeSupplement();
		ErrorMessage errorMessage=new ErrorMessage();
		
	    specialCake=orderSpCakeRepository.findBySpId(spId);
	 
		if(specialCake==null)
		{
			errorMessage.setError(true);
			errorMessage.setMessage("Special Cake Not Found");
			searchSpCakeResponse.setErrorMessage(errorMessage);
		}
		else
		{
			spCakeresponse=spCakeSupRepository.findBySpId(spId);
			errorMessage.setError(false);
			errorMessage.setMessage("Special Cake Found Successfully");
			searchSpCakeResponse.setErrorMessage(errorMessage);
			searchSpCakeResponse.setSpecialCake(specialCake);
			searchSpCakeResponse.setSpCakeSup(spCakeresponse);
		}
		
		return searchSpCakeResponse;
	}

	@Override
	public SpCakeSupplement getSpCakeSupById(int spId) {
		SpCakeSupplement spSup = spCakeSupRepository.findBySpId(spId);
		return spSup;
	}
	

}
