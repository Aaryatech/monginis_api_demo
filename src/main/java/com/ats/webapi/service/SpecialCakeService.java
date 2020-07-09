package com.ats.webapi.service;

import java.util.List;

import com.ats.webapi.model.GetSpCkSupplement;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.SearchSpCakeResponse;
import com.ats.webapi.model.SpCakeSupplement;
import com.ats.webapi.model.SpecialCake;


public interface SpecialCakeService {
	public String save(SpecialCake specialcake);
	public List<SpecialCake> showAllSpecialCake();
	public SpecialCake findSpecialCake(int spId);
	public SearchSpCakeResponse searchSpecialCake(String spCode);
	public List<String> searchSpecialCakeSpCodes(List<Integer>items,int frId,int menuId);
	public SpCakeSupplement saveSpCakeSup(SpCakeSupplement spCakeSupplement);
	public Info deleteSpCakeSup(List<Integer> id);
	public GetSpCkSupplement getSpCakeSupp(int id);
	public List<GetSpCkSupplement> getSpCakeSupList();
	public List<SpecialCake> findSpecialCakes(List<Integer> spId);
	public SearchSpCakeResponse searchSpecialCakeBySpId(int spId);
	public List<SpecialCake> showAllSpecialCakeOrderBySpCode();
	
	public SpCakeSupplement getSpCakeSupById(int spId);
}
