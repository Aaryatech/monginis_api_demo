package com.ats.webapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.AllRegularSpCkItems;
import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.GetRegularSpCkItems;
import com.ats.webapi.repository.RegularSpCkItemsRepository;

@Service
public class RegularSpCkItemsServiceImpl  implements RegularSpCkItemsService{

	@Autowired
	RegularSpCkItemsRepository regularSpCkItemsRepository;
	
	AllRegularSpCkItems allRegularSpCkItems=new AllRegularSpCkItems();
	
	@Override
	public AllRegularSpCkItems findRegularSpCkItems(List<Integer> items, int itemGrp2) {

		List<GetRegularSpCkItems> regularSpCkItemsService=regularSpCkItemsRepository.findRegularSpCkItems(items,itemGrp2);
		ErrorMessage errorMessage=new ErrorMessage();
		
		if(regularSpCkItemsService!=null)
		{
			errorMessage.setError(false);
			errorMessage.setMessage("Items Displayed Successfully");
			allRegularSpCkItems.setErrorMessage(errorMessage);
			allRegularSpCkItems.setGetRegularSpCkItems(regularSpCkItemsService);
			
		}
		else
		{
			errorMessage.setError(true);
			errorMessage.setMessage("Items Not Found");
			allRegularSpCkItems.setErrorMessage(errorMessage);
			
		}
		return allRegularSpCkItems;
	}

}
