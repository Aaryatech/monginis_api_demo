package com.ats.webapi.service.logistics;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ats.webapi.model.Info;
import com.ats.webapi.model.logistics.MachineMaster;

@Service
public interface MachineMasterService {

	MachineMaster postMachineMaster(MachineMaster machineMaster);

	Info deleteMachineMaster(int machineId);

	List<MachineMaster> getAllMachineMaster();

	MachineMaster getMachineMasterById(int machineId);

}
