package com.ats.webapi.service.logistics;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.Info; 
import com.ats.webapi.model.logistics.Variant; 
import com.ats.webapi.repository.logistics.VariantRepository;

@Service
public class VariantServiceImpl implements VariantService{
	
	@Autowired
	VariantRepository variantRepository;

	@Override
	public Variant postVariant(Variant variant) {
		Variant response = new Variant();
		 try
		 {
			 response = variantRepository.save(variant);
		 }catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		return response;
	}

	@Override
	public Info deleteVariant(int variantId) {
		Info info = new Info();
		try {
			  
			int delete = variantRepository.deleteVariant(variantId);
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
	public List<Variant> getAllVariantList() {
		List<Variant> getAllVariantList = new ArrayList<Variant>();
		try {
			  
			getAllVariantList = variantRepository.findAllByDelStatus(0);
			 
			System.out.println(getAllVariantList.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
		return getAllVariantList;
	}

	@Override
	public Variant getVariantById(int variantId) {
		Variant getVariantById = new Variant();
		try {
			  
			getVariantById = variantRepository.findByVariantId(variantId);
			 
			System.out.println(getVariantById.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
		return getVariantById;
	}

	@Override
	public List<Variant> getVariantByMakeIdAndTypeId(int makeId, int typeId) {
		List<Variant> getAllVariantList = new ArrayList<Variant>();
		try {
			  
			getAllVariantList = variantRepository.findAllByMakeIdAndVehTypeIdAndDelStatus(makeId,typeId,0);
			 
			System.out.println(getAllVariantList.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
		return getAllVariantList;
	}

}
