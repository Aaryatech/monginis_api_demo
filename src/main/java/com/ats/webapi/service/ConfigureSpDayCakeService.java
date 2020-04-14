package com.ats.webapi.service;

import com.ats.webapi.model.ConfiguredSpDayCkResponse;
import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.GetConfiguredSpDayCk;
import com.ats.webapi.model.SpDayConfigure;

public interface ConfigureSpDayCakeService {

	ErrorMessage configureSpDayCake(SpDayConfigure spDayConfigure);

	ConfiguredSpDayCkResponse getConfiguredSpDayCkList();

	GetConfiguredSpDayCk findConfSpDayCake(int spdayId);

	ErrorMessage findConfiguredSpDayCk(int spdayId);

	ConfiguredSpDayCkResponse getSpDayCkList(int frId);


}
