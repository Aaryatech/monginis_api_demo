package com.ats.webapi.service.logistics;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ats.webapi.model.Info;
import com.ats.webapi.model.logistics.VehicalType;

@Service
public interface VehTypeService {

	VehicalType postVahType(VehicalType vehicalType);

	Info deleteVehType(int vehId);

	List<VehicalType> getAllVehicalTypeList();

	VehicalType getVehTypeById(int vehiTypeId);

	List<VehicalType> typeByMakeId(int makeId);

}
