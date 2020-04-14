package com.ats.webapi.service.logistics;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.Info;
import com.ats.webapi.model.logistics.Dealer; 
import com.ats.webapi.repository.logistics.DealerRepository; 

@Service
public class DealerServiceImpl implements DealerService{

	@Autowired
	DealerRepository dealerRepository;
	
	@Override
	public Dealer postDealer(Dealer dealer) {
		Dealer response = new Dealer();
		 try
		 {
			 response = dealerRepository.save(dealer);
		 }catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		return response;
	}

	@Override
	public Info deleteDealer(int dealerId) {
		Info info = new Info();
		try {
			  
			int delete = dealerRepository.deleteDealer(dealerId);
			if(delete==1)
			{
				info.setError(false);
				info.setMessage("deleted successfully");
			}
			else
			{
				info.setError(true);
				info.setMessage("failed to delete");
			}
			System.out.println(info.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
        
		
		return info;
	}

	@Override
	public List<Dealer> getAllDealerList() {
		List<Dealer> getAllDealerList = new ArrayList<Dealer>();
		try {
			  
			getAllDealerList = dealerRepository.findAllByDelStatus(0);
			 
			System.out.println(getAllDealerList.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
		return getAllDealerList;
	}

	@Override
	public Dealer getDealerById(int dealerId) {
		Dealer getDealerById = new Dealer();
		try {
			  
			getDealerById = dealerRepository.findByDealerId(dealerId);
			 
			System.out.println(getDealerById.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
		return getDealerById;
	}

	@Override
	public List<Dealer> getDealerByMakeId(int makeId) {
		List<Dealer> getDealerByMakeId = new ArrayList<Dealer>();
		try {
			  
			getDealerByMakeId = dealerRepository.findAllByMakeIdAndDelStatus(makeId,0);
			 
			System.out.println(getDealerByMakeId.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
		return getDealerByMakeId;
	}

}
