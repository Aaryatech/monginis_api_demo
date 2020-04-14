package com.ats.webapi.service.logistics;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.Info; 
import com.ats.webapi.model.logistics.VehicalMaster; 
import com.ats.webapi.repository.logistics.VehicalMasterRepository;

@Service
public class VehicalMasterServiceImpl implements VehicalMasterService{
	
	@Autowired
	VehicalMasterRepository vehicalMasterRepository;

	@Override
	public VehicalMaster postVehicalMaster(VehicalMaster vehicalMaster) {
		VehicalMaster response = new VehicalMaster();
		 try
		 {
			 response = vehicalMasterRepository.save(vehicalMaster);
		 }catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		return response;
	}

	@Override
	public Info deleteVehicalMaster(int vehicalId) {
		Info info = new Info();
		try {
			  
			int delete = vehicalMasterRepository.deleteVehicalMaster(vehicalId);
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
	public List<VehicalMaster> getAllVehicalList() {
		List<VehicalMaster> getAllVehicalList = new ArrayList<VehicalMaster>();
		try {
			  
			getAllVehicalList = vehicalMasterRepository.findByDelStatus(0);
			 
			System.out.println(getAllVehicalList.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
		return getAllVehicalList;
	}

	@Override
	public VehicalMaster getVehicalById(int vehicalId) {
		VehicalMaster getVehicalById = new VehicalMaster();
		try {
			  
			getVehicalById = vehicalMasterRepository.findByVehId(vehicalId);
			 
			System.out.println(getVehicalById.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
		return getVehicalById;
	}

	/*@Override
	public List<VehicalMaster> getAlertVehicleRecord() {
		List<VehicalMaster> getAlertVehicleRecord = new ArrayList<VehicalMaster>();
		try {
			  
			getAlertVehicleRecord = vehicalMasterRepository.getAlertVehicleRecord();
			 
			System.out.println(getAlertVehicleRecord.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
		return getAlertVehicleRecord;
	}*/

}
