package com.ats.webapi.service.logistics;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.Info; 
import com.ats.webapi.model.logistics.Make; 
import com.ats.webapi.repository.logistics.MakeRepository;

@Service
public class MakeServiceImpl implements MakeService{
	
	@Autowired
	MakeRepository makeRepository;

	@Override
	public Make postMake(Make make) {
		Make response = new Make();
		 try
		 {
			 response = makeRepository.save(make);
		 }catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		return response;
	}

	@Override
	public Info deleteMake(int makeId) {
		Info info = new Info();
		try {
			  
			int delete = makeRepository.deleteMake(makeId);
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
	public List<Make> getAllMakeList() {
		List<Make> getAllMakeList = new ArrayList<Make>();
		try {
			  
			getAllMakeList = makeRepository.findAllByDelStatus(0);
			 
			System.out.println(getAllMakeList.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
		return getAllMakeList;
	}

	@Override
	public Make getMakeById(int makeId) {
		Make getMakeById = new Make();
		try {
			  
			getMakeById = makeRepository.findByMakeId(makeId);
			 
			System.out.println(getMakeById.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
		return getMakeById;
	}

}
