package com.ats.webapi.service.tally;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.tally.SpCakeList;

@Service
public interface SpCakeService {

	SpCakeList getAllSpCake();

	ErrorMessage updateSpCakes(int spId, int isTallySync);

}
