package com.ats.webapi.service.logistics;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ats.webapi.model.Info;
import com.ats.webapi.model.logistics.Make;

@Service
public interface MakeService {

	Make postMake(Make make);

	Info deleteMake(int makeId);

	List<Make> getAllMakeList();

	Make getMakeById(int makeId);

}
