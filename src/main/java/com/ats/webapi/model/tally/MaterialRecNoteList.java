package com.ats.webapi.model.tally;

import java.io.Serializable;
import java.util.List;

import com.ats.webapi.model.ErrorMessage;

public class MaterialRecNoteList implements Serializable{

	List<MaterialReceiptNote> materialRecNoteResList;
	
	ErrorMessage errorMessage;

	public List<MaterialReceiptNote> getMaterialRecNoteResList() {
		return materialRecNoteResList;
	}

	public void setMaterialRecNoteResList(List<MaterialReceiptNote> materialRecNoteResList) {
		this.materialRecNoteResList = materialRecNoteResList;
	}

	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "MaterialRecNoteList [materialRecNoteResList=" + materialRecNoteResList + ", errorMessage="
				+ errorMessage + "]";
	}
	
	
}
