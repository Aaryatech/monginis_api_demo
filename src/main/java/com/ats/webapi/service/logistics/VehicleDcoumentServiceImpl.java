package com.ats.webapi.service.logistics;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.Info; 
import com.ats.webapi.model.logistics.VehicleDcoument; 
import com.ats.webapi.repository.logistics.VehicleDcoumentRepository;

@Service
public class VehicleDcoumentServiceImpl implements VehicleDcoumentService {
	
	@Autowired
	VehicleDcoumentRepository vehicleDcoumentRepository;

	@Override
	public VehicleDcoument postVehicleDocument(VehicleDcoument vehicleDcoument) {
		VehicleDcoument response = new VehicleDcoument();
		 try
		 {
			 response = vehicleDcoumentRepository.save(vehicleDcoument);
		 }catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		return response;
	}

	@Override
	public Info deleteVehicleDcoument(int vehDocId) {
		Info info = new Info();
		try {
			  
			int delete = vehicleDcoumentRepository.deleteVehicleDcoument(vehDocId);
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
	public List<VehicleDcoument> getAllVehicleDcoument() {
		List<VehicleDcoument> getAllVehicleDcoument = new ArrayList<VehicleDcoument>();
		try {
			  
			getAllVehicleDcoument = vehicleDcoumentRepository.findByDelStatus(0);
			 
			System.out.println(getAllVehicleDcoument.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
		return getAllVehicleDcoument;
	}

	@Override
	public VehicleDcoument getVehicleDcoumentById(int vehDocId) {
		VehicleDcoument getVehicleDcoumentById = new VehicleDcoument();
		try {
			  
			getVehicleDcoumentById = vehicleDcoumentRepository.findByVehDocId(vehDocId);
			 
			System.out.println(getVehicleDcoumentById.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
		return getVehicleDcoumentById;
	}

	@Override
	public List<VehicleDcoument> getAlertDocumentRecord(String today) {
		List<VehicleDcoument> getAllVehicleDcoument = new ArrayList<VehicleDcoument>();
		try {
			  
			getAllVehicleDcoument = vehicleDcoumentRepository.getAlertDocumentRecord(today);
			 
			System.out.println(getAllVehicleDcoument.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
		return getAllVehicleDcoument;
	}

}
