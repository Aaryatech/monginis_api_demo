package com.ats.webapi.model.rawmaterial;

import java.util.List;

import com.ats.webapi.model.Info;

public class RawMaterialTaxDetailsList {
	
	List<RawMaterialTaxDetails> rawMaterialTaxDetailsList;
	
	Info info;

	public List<RawMaterialTaxDetails> getRawMaterialTaxDetailsList() {
		return rawMaterialTaxDetailsList;
	}

	public void setRawMaterialTaxDetailsList(List<RawMaterialTaxDetails> rawMaterialTaxDetailsList) {
		this.rawMaterialTaxDetailsList = rawMaterialTaxDetailsList;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "RawMaterialTaxDetailsList [rawMaterialTaxDetailsList=" + rawMaterialTaxDetailsList + ", info=" + info
				+ "]";
	}
	
	

}
