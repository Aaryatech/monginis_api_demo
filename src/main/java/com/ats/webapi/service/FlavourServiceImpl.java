package com.ats.webapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.Flavour;
import com.ats.webapi.model.Info;
import com.ats.webapi.repository.FlavourRepository;
import com.ats.webapi.util.JsonUtil;
@Service()
public class FlavourServiceImpl implements FlavourService {
	String jsonFlavour="{}";
	
	Flavour flavour=null;
	@Autowired
	FlavourRepository flavourRepository;

	@Override
	public ErrorMessage save(Flavour flavour) {
		 ErrorMessage errorMessage=new ErrorMessage();
		try {
			if(flavour.getSpfName()!=null && !flavour.getSpfName().trim().equals("")) {
				flavour=flavourRepository.save(flavour);
			   
				errorMessage.setError(false);
				errorMessage.setMessage("Flavour inserted Successfully");
			}
			else {
				flavour.setSpfName(flavour.getSpfName());
				errorMessage.setError(true);
				errorMessage.setMessage("Flavour insertion failed");
			}
		}
		catch (Exception e) {
			System.out.println("Flavour service impl ex"+e.getMessage());
		}
	return errorMessage;
	}

	@Override
	public List<Flavour> findAllFlavour() {
		List<Flavour> flavourList=flavourRepository.findByOrderBySpfNameAsc();
	return flavourList;
	}

	@Override
	public Flavour findFlavour(int spfId) {
		Flavour flavour=flavourRepository.findOne(spfId);
	return flavour;
	}

	@Override
	public Flavour updateFlavour(int id) {
		Flavour flavour=flavourRepository.findOne(id);
	return flavour;
	}

}
