package com.ats.webapi.service.tally;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.tally.ItemList;

@Service
public interface TallyItemService {

	 ItemList getAllItems();

	ErrorMessage updateItems(int id, int isTallySync);

}
