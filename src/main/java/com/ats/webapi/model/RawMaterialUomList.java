package com.ats.webapi.model;

import java.util.List;

import com.ats.webapi.model.rawmaterial.RawMaterialUom;

public class RawMaterialUomList {

	
	List<RawMaterialUom> rawMaterialUom;

	public List<RawMaterialUom> getRawMaterialUom() {
		return rawMaterialUom;
	}

	public void setRawMaterialUom(List<RawMaterialUom> rawMaterialUom) {
		this.rawMaterialUom = rawMaterialUom;
	}

	@Override
	public String toString() {
		return "RawMaterialUomList [rawMaterialUom=" + rawMaterialUom + "]";
	}
	
	
}
