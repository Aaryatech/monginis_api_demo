package com.ats.webapi.service.logistics;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ats.webapi.model.Info;
import com.ats.webapi.model.logistics.VehicleDcoument;

@Service
public interface VehicleDcoumentService {

	VehicleDcoument postVehicleDocument(VehicleDcoument vehicleDcoument);

	Info deleteVehicleDcoument(int vehDocId);

	List<VehicleDcoument> getAllVehicleDcoument();

	VehicleDcoument getVehicleDcoumentById(int vehDocId);

	List<VehicleDcoument> getAlertDocumentRecord(String today);

}
