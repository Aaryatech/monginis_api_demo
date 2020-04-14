package com.ats.webapi.service.logistics;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.Info; 
import com.ats.webapi.model.logistics.VehicalType; 
import com.ats.webapi.repository.logistics.VehTypeRepository;

@Service
public class VehTypeServiceImpl implements VehTypeService{
	
	@Autowired
	VehTypeRepository vehTypeRepository;

	@Override
	public VehicalType postVahType(VehicalType vehicalType) {
		VehicalType response = new VehicalType();
		 try
		 {
			 response = vehTypeRepository.save(vehicalType);
		 }catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		return response;
	}

	@Override
	public Info deleteVehType(int vehId) {
		Info info = new Info();
		try {
			  
			int delete = vehTypeRepository.deleteVehType(vehId);
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
	public List<VehicalType> getAllVehicalTypeList() {
		List<VehicalType> getAllVehicalTypeList = new ArrayList<VehicalType>();
		try {
			  
			getAllVehicalTypeList = vehTypeRepository.findAllByDelStatus(0);
			 
			System.out.println(getAllVehicalTypeList.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
		return getAllVehicalTypeList;
	}

	@Override
	public VehicalType getVehTypeById(int vehiTypeId) {
		VehicalType getVehTypeById = new VehicalType();
		try {
			  
			getVehTypeById = vehTypeRepository.findByVehiTypeId(vehiTypeId);
			 
			System.out.println(getVehTypeById.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
		return getVehTypeById;
	}

	@Override
	public List<VehicalType> typeByMakeId(int makeId) {
		List<VehicalType> typeByMakeId = new ArrayList<VehicalType>();
		try {
			  
			typeByMakeId = vehTypeRepository.findByMakeIdAndDelStatus(makeId,0);
			 
			System.out.println(typeByMakeId.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
		return typeByMakeId;
	}

}
