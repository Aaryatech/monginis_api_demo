package com.ats.webapi.service;

import java.util.List;

import com.ats.webapi.model.GrnGvn;
import com.ats.webapi.model.grngvn.GrnGvnHeader;

public interface PostGrnGvnService {
	
	public GrnGvn saveGrnGvn(List<GrnGvn> grnGvn);
	
	public GrnGvnHeader saveGrnGvnHeader(GrnGvnHeader header); //inserting grn header 15 feb
	
	int  updateBill(int billDetailNo) ;

}
