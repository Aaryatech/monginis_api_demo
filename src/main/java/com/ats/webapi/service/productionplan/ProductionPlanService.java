package com.ats.webapi.service.productionplan;

import java.util.List;

import com.ats.webapi.model.PostProductionPlanList;

public interface ProductionPlanService {

	List<PostProductionPlanList> getProductionPlanList(String fromDate);
	

}
