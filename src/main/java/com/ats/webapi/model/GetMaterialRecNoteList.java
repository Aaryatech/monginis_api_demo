package com.ats.webapi.model;

import java.util.List;

public class GetMaterialRecNoteList {

	
	List<MaterialRecNote> materialRecNoteList;
	
	ErrorMessage errorMessage;

	public List<MaterialRecNote> getMaterialRecNoteList() {
		return materialRecNoteList;
	}

	public void setMaterialRecNoteList(List<MaterialRecNote> materialRecNoteList) {
		this.materialRecNoteList = materialRecNoteList;
	}

	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "GetMaterialRecNoteList [materialRecNoteList=" + materialRecNoteList + ", errorMessage=" + errorMessage
				+ "]";
	}
	
}
