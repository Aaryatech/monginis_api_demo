package com.ats.webapi.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.Discount;
import com.ats.webapi.model.Franchisee;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.Item;
import com.ats.webapi.model.SpecialCake;
import com.ats.webapi.repository.DiscountRepository;
import com.ats.webapi.repository.FranchiseeRepository;
import com.ats.webapi.repository.ItemRepository;
import com.ats.webapi.repository.SpecialCakeRepository;
@RestController
public class DiscountController {
	
	@Autowired
	DiscountRepository discountRepository;
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private FranchiseeRepository franchiseeRepository;
	@Autowired
	SpecialCakeRepository specialCakeRepository;
	
	@RequestMapping(value = { "/saveDiscount" }, method = RequestMethod.POST)
	public @ResponseBody Info saveDiscount(@RequestBody Discount discount) {

		Discount disc = null;
		Info info = new Info();
		try {

			disc = discountRepository.save(discount);

			if (disc != null) {
				info.setError(false);
				info.setMessage("Discount Saved Successfully.");
			} else {
				info.setError(true);
				info.setMessage("Discount Not Saved .");
			}

		} catch (Exception e) {

			info.setError(true);
			info.setMessage("Discount Not Saved .");

			e.printStackTrace();
			System.out.println("Exception In MasterController /saveDiscount" + e.getMessage());

		}
		return info;

	}
	
	@RequestMapping(value="/getAllDiscount", method=RequestMethod.GET)
	public@ResponseBody List<Discount> getAllCustomer(){
		List<Discount> discList=null;
		
		try {
			 discList=discountRepository.findAllByDelStatus(0);
			 try {
				 if(discList.size()>0) {
					 for(int i=0;i<discList.size();i++)
					 {
						 List<Integer> frids = Stream.of(discList.get(i).getFranchId().split(","))
				            .map(Integer::parseInt)
				            .collect(Collectors.toList());
						List<Franchisee> frList= franchiseeRepository.findByDelStatusAndFrIdIn(0,frids);
						String frNames="";
						for(int j=0;j<frList.size();j++)
						{
							frNames=frList.get(j).getFrName()+","+frNames;
						}
						discList.get(i).setFranchId(frNames);
						
						 List<Integer> itemids = Stream.of(discList.get(i).getItemId().split(","))
						            .map(Integer::parseInt)
						            .collect(Collectors.toList());
						 if(discList.get(i).getCategoryId()!=5) {
							 
						    List<Item> itemList= itemRepository.findByDelStatusAndIdIn(0,itemids);
							String itemNames="";
							for(int j=0;j<itemList.size();j++)
							{
								itemNames=itemList.get(j).getItemName()+","+itemNames;
							}
							discList.get(i).setItemId(itemNames);
						
						 }else
						 {
							 List<SpecialCake> spList= specialCakeRepository.findByDelStatusAndSpIdIn(0,itemids);
								String itemNames="";
								for(int j=0;j<spList.size();j++)
								{
									itemNames=spList.get(j).getSpName()+","+itemNames;
								}
								discList.get(i).setItemId(itemNames);
						 }

					 }
				 }
			 }catch (Exception e) {
				// TODO: handle exception
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return discList; 
		
	}


	@RequestMapping(value="/getDiscountById", method=RequestMethod.POST)
	public@ResponseBody Discount getDiscountById(@RequestParam int id){
		return discountRepository.findByDiscIdAndDelStatus(id,0);
		
	}
	
		
	
	@RequestMapping(value="/deleteDiscountId", method=RequestMethod.POST)
	public @ResponseBody Info deleteDiscount(@RequestParam int id) {
		
		Info info =new Info();
		int isDelete = discountRepository.deleteDiscId(id);
		
		if(isDelete!=0) {
			info.setError(false);
			info.setMessage("sucess");
		}else {
			info.setError(true);
			info.setMessage("Fail");
		}
		return info;
		
	}
	
	/*	@RequestMapping(value = { "/deleteMultiDiscount" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMultiDiscount(@RequestParam("discId") List<Integer> discId) {

		Info info = new Info();

		try {
			int delete = discountRepository.deleteDiscount(discId);

			if (delete >= 1) {
				info.setError(false);
				info.setMessage("successfully Multiple Deleted");
			} else {
				info.setError(true);
				info.setMessage(" Deleted to Delete");
			}

		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMessage(" Deleted to Delete");

		}
		return info;

	}*/
}
