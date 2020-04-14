package com.ats.webapi.service.logistics;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.Info;
import com.ats.webapi.model.logistics.SparePart; 
import com.ats.webapi.repository.logistics.SparePartRepository; 

@Service
public class SparePartServiceImpl implements SparePartService{
	
	@Autowired 
	SparePartRepository sparePartRepository;

	@Override
	public SparePart postSparePart(SparePart sparePart) {
		SparePart response = new SparePart();
		 try
		 {
			 response = sparePartRepository.save(sparePart);
		 }catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		return response;
	}

	@Override
	public Info deleteSparePart(int sprId) {
		Info info = new Info();
		try {
			  
			int delete = sparePartRepository.deleteSparePart(sprId);
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
	public List<SparePart> getAllSparePart() {
		List<SparePart> getAllSparePart = new ArrayList<SparePart>();
		try {
			  
			getAllSparePart = sparePartRepository.findAllByDelStatus(0);
			 
			System.out.println(getAllSparePart.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
		return getAllSparePart;
	}

	@Override
	public SparePart getSparePartById(int sprId) {
		SparePart getSparePartById = new SparePart();
		try {
			  
			getSparePartById = sparePartRepository.findBySprId(sprId);
			 
			System.out.println(getSparePartById.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
		return getSparePartById;
	}

	@Override
	public List<SparePart> sparePartByGroupId(int groupId) {
		List<SparePart> sparePartByGroupId = new ArrayList<SparePart>();
		try {
			  
			sparePartByGroupId = sparePartRepository.findAllByGroupIdAndDelStatus(groupId,0);
			 
			System.out.println(sparePartByGroupId.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
		return sparePartByGroupId;
	}

}
