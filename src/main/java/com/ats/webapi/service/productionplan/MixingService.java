package com.ats.webapi.service.productionplan;

import com.ats.webapi.model.GetMixingList;
import com.ats.webapi.model.MixingHeader;

public interface MixingService {

	MixingHeader insertMixingHeaderndDetailed(MixingHeader mixingHeader);
	
	GetMixingList gettMixingHeaderndDetailed(String frmdate, String todate);

	MixingHeader gettMixingdetaildwithId(int mixId);

	int updateisBom(int mixId);
	
	

}
