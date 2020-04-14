

package com.ats.webapi.controller.otheritems;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.model.Info;
import com.ats.webapi.model.otheritems.Otheritems;
import com.ats.webapi.repositories.OtheritemsRepo;


@RestController 
public class OtherItemWebApi {
	
	@Autowired 
	OtheritemsRepo otIRepo;
	
	@RequestMapping(value = {"/getOtherItemListByDel"}, method=RequestMethod.GET)
	public @ResponseBody List<Otheritems> getOtherItemList(){
		return otIRepo.findAllByDelStatusAndIsActive(0, 1);
		
	}
	
	@RequestMapping(value = {"/addNewItems"}, method=RequestMethod.POST)
	public @ResponseBody  Otheritems addNewItem(@RequestBody Otheritems oti) {
		return otIRepo.save(oti);
		
	}
																																																																																																																																																																																																																																																																																																																																																																														
	@RequestMapping(value="/getItemById", method=RequestMethod.POST)
	public @ResponseBody Otheritems getItemById(@RequestParam("id") int id) {
		return otIRepo.findByItemIdDelStatusAndIsActive(id);
		
	}
	
	@RequestMapping(value="/getItemByFrId", method=RequestMethod.POST)
	public @ResponseBody List<Otheritems> getItemByFrId(@RequestParam("frId") int frId) {
		System.out.println("Other Itm FRID="+frId); 
		
		List<Otheritems> othrItmList =  otIRepo.findByFrIdAndDelStatus(frId, 0);
		System.err.println("Oth List:"+othrItmList);
		return othrItmList;
	}
	
	@RequestMapping(value="/deleteItemById", method=RequestMethod.POST)
	public @ResponseBody Info deleteItemById(@RequestParam("id") int id) {
		
		Info info = new Info();
		int isDelete =  otIRepo.deleteItemByItemIdAndDelStatus(id);		
		if(isDelete!=0) {
			info.setError(false);
			info.setMessage("sucess");
		}else {
			info.setError(true);
			info.setMessage("Fail");
		}
		return info;
		
	}
	
	
	
}
