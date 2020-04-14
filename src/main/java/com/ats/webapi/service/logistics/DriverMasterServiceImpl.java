package com.ats.webapi.service.logistics;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.logistics.DriverMaster;
import com.ats.webapi.repository.logistics.DriverMasterRepository;

@Service
public class DriverMasterServiceImpl implements DriverMasterService {

	@Autowired
	DriverMasterRepository driverMasterRepository;

	@Override
	public DriverMaster postDriverMaster(DriverMaster driverMaster) {

		DriverMaster response = new DriverMaster();
		try {
			response = driverMasterRepository.save(driverMaster);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public Info deleteDriverMaster(int driverId) {
		Info info = new Info();
		try {

			int delete = driverMasterRepository.deleteDriverMaster(driverId);
			if (delete == 1) {
				info.setError(false);
				info.setMessage("deleted successfully");
			} else {
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
	public List<DriverMaster> getAllDriverList() {

		List<DriverMaster> getAllDriverList = new ArrayList<DriverMaster>();
		try {

			getAllDriverList = driverMasterRepository.findAllByDelStatus(0);

			System.out.println(getAllDriverList.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
		return getAllDriverList;
	}

	@Override
	public DriverMaster getDriverById(int driverId) {
		DriverMaster getDriverById = new DriverMaster();
		try {

			getDriverById = driverMasterRepository.findByDriverIdAndDelStatus(driverId, 0);

			System.out.println(getDriverById.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
		return getDriverById;
	}

	@Override
	public List<DriverMaster> getAlertDriverRecord(String today) {
		List<DriverMaster> getAlertDriverRecord = new ArrayList<DriverMaster>();
		try {

			getAlertDriverRecord = driverMasterRepository.getAlertDriverRecord(today);

			System.out.println(getAlertDriverRecord.toString());
		} catch (Exception e) {

			e.printStackTrace();
		}
		return getAlertDriverRecord;
	}


}
