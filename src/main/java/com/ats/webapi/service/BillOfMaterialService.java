package com.ats.webapi.service;

import java.util.List;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.bom.BillOfMaterialHeader;
import com.ats.webapi.model.bom.GetBillOfMaterialList;

public interface BillOfMaterialService{
	
	GetBillOfMaterialList getBillOfMaterialithDate(String frmdate, String todate,int bmsDeptId, int mixDeptId);
	
	GetBillOfMaterialList getBillOfMaterialBmsToStoreDate(int fromDept, int toDept, String frmdate, String todate);

	BillOfMaterialHeader gettBomdetaildwithId(int reqId);

	GetBillOfMaterialList getallBOMHeaderList();

	GetBillOfMaterialList getBillOfMaterialBmsToStoreDate(int fromDept, List<Integer> toDept, List<String> status);

	/*ErrorMessage updatestatus(int reqId);*/

}
