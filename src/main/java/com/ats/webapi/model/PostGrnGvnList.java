package com.ats.webapi.model;

import java.util.List;

import com.ats.webapi.model.grngvn.GrnGvnHeader;

public class PostGrnGvnList {
	
	
	GrnGvnHeader grnGvnHeader;
	
	//List<GrnGvn> grnGvn;

	/*public List<GrnGvn> getGrnGvn() {
		return grnGvn;
	}

	public void setGrnGvn(List<GrnGvn> grnGvn) {
		this.grnGvn = grnGvn;
	}
*/
	public GrnGvnHeader getGrnGvnHeader() {
		return grnGvnHeader;
	}

	public void setGrnGvnHeader(GrnGvnHeader grnGvnHeader) {
		this.grnGvnHeader = grnGvnHeader;
	}

	@Override
	public String toString() {
		return "PostGrnGvnList [grnGvnHeader=" + grnGvnHeader + "]";
	}
	
	
	

}
