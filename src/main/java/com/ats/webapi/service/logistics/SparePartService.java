package com.ats.webapi.service.logistics;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ats.webapi.model.Info;
import com.ats.webapi.model.logistics.SparePart;

@Service
public interface SparePartService {

	SparePart postSparePart(SparePart sparePart);

	Info deleteSparePart(int sprId);

	List<SparePart> getAllSparePart();

	SparePart getSparePartById(int sprId);

	List<SparePart> sparePartByGroupId(int groupId); 

}
