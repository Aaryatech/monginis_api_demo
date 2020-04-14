package com.ats.webapi.service.tally;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.tally.ItemList;
import com.ats.webapi.model.tally.TallyItem;
import com.ats.webapi.repository.tally.TallyItemRepository;
import com.ats.webapi.repository.tally.TallyItemUpdateRepository;

@Service
public class ItemServiceTallyImpl implements TallyItemService{

	@Autowired
	TallyItemRepository tallyItemRepository;
	
	@Autowired
	TallyItemUpdateRepository tallyItemUpdateRepository;
	
	@Override
	public ItemList getAllItems() {
		
    List<TallyItem> itemList=tallyItemRepository.findByIsTallySync();
		
		ItemList allItemList=new ItemList();
		ErrorMessage errorMessage=new ErrorMessage();
		
		if(itemList==null)
		{
		
			errorMessage.setError(true);
			errorMessage.setMessage("Item Not Found");
			
			allItemList.setErrorMessage(errorMessage);
		}
		else
		{
			errorMessage.setError(false);
			errorMessage.setMessage("Item Found Successfully");
			
			allItemList.setItemList(itemList);
            allItemList.setErrorMessage(errorMessage);			
		}
		return allItemList;
	}

	@Override
	public ErrorMessage updateItems(int id, int isTallySync) {

		ErrorMessage errorMessage=new ErrorMessage();
		
		int i=tallyItemUpdateRepository.updateItems(id,isTallySync);
		if(i==1) {
		
		errorMessage.setError(false);
		errorMessage.setMessage("Items Updated Successfully");
		}
		else
		{
			errorMessage.setError(false);
			errorMessage.setMessage("Items Updation Failed");
			
		}
		return errorMessage;
		
	}

}
