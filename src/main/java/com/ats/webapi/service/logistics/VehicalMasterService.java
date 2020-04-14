package com.ats.webapi.service.logistics;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ats.webapi.model.Info;
import com.ats.webapi.model.logistics.VehicalMaster;

@Service
public interface VehicalMasterService {

	VehicalMaster postVehicalMaster(VehicalMaster vehicalMaster);

	Info deleteVehicalMaster(int vehicalId);

	List<VehicalMaster> getAllVehicalList();

	VehicalMaster getVehicalById(int vehicalId);

	/*List<VehicalMaster> getAlertVehicleRecord();*/

}
