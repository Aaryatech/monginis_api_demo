package com.ats.webapi.model;

import java.io.Serializable;
import java.util.List;

public class MaterialRNoteResponse implements Serializable{

	List<MaterialRecNote> MaterialRecNoteList;
	
	ErrorMessage errorMessage;

	public List<MaterialRecNote> getMaterialRecNoteList() {
		return MaterialRecNoteList;
	}

	public void setMaterialRecNoteList(List<MaterialRecNote> materialRecNoteList) {
		MaterialRecNoteList = materialRecNoteList;
	}

	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "MaterialRNoteResponse [MaterialRecNoteList=" + MaterialRecNoteList + ", errorMessage=" + errorMessage
				+ "]";
	}
	
	
}
