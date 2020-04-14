package com.ats.webapi.service.logistics;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ats.webapi.model.Info;
import com.ats.webapi.model.logistics.Dealer;

@Service
public interface DealerService {

	Dealer postDealer(Dealer dealer);

	Info deleteDealer(int dealerId);

	List<Dealer> getAllDealerList();

	Dealer getDealerById(int makeId);

	List<Dealer> getDealerByMakeId(int makeId);

}
