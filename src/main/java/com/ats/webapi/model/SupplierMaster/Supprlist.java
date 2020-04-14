package com.ats.webapi.model.SupplierMaster;

import java.util.List;


public class Supprlist {
	
	private List<SupplierDetails> SupplierDetailslist;

	public List<SupplierDetails> getSupplierDetailslist() {
		return SupplierDetailslist;
	}

	public void setSupplierDetailslist(List<SupplierDetails> supplierDetailslist) {
		SupplierDetailslist = supplierDetailslist;
	}

	@Override
	public String toString() {
		return "Supprlist [SupplierDetailslist=" + SupplierDetailslist + "]";
	}
	
	

}
