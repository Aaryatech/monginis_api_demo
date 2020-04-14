package com.ats.webapi.service.logistics;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.Info;
import com.ats.webapi.model.logistics.MachineMaster;
import com.ats.webapi.model.logistics.VehicalMaster;
import com.ats.webapi.repository.logistics.MachineMasterRepository;
import com.ats.webapi.repository.logistics.VehicalMasterRepository;

@Service
public class MachineMasterServiceImpl implements MachineMasterService{
	
	@Autowired
	MachineMasterRepository machineMasterRepository;

	@Override
	public MachineMaster postMachineMaster(MachineMaster machineMaster) {
		MachineMaster response = new MachineMaster();
		 try
		 {
			 response = machineMasterRepository.save(machineMaster);
		 }catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		return response; 
		 
	}

	@Override
	public Info deleteMachineMaster(int machineId) {
		Info info = new Info();
		try {
			  
			int delete = machineMasterRepository.deleteMachineMaster(machineId);
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
	public List<MachineMaster> getAllMachineMaster() {
		List<MachineMaster> getAllMachineMaster = new ArrayList<MachineMaster>();
		try {
			  
			getAllMachineMaster = machineMasterRepository.findByDelStatus(0);
			 
			System.out.println(getAllMachineMaster.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
		return getAllMachineMaster;
	}

	@Override
	public MachineMaster getMachineMasterById(int machineId) {
		MachineMaster getMachineMasterById = new MachineMaster();
		try {
			  
			getMachineMasterById = machineMasterRepository.findByMachineId(machineId);
			 
			System.out.println(getMachineMasterById.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
		return getMachineMasterById;
	}

}
