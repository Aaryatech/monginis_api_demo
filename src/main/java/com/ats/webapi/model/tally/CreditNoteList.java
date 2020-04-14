package com.ats.webapi.model.tally;

import java.io.Serializable;
import java.util.List;

import com.ats.webapi.model.ErrorMessage;

public class CreditNoteList implements Serializable{
	
	List<CreditNote> creditNoteList;
	
	ErrorMessage errorMessage;

	public List<CreditNote> getCreditNoteList() {
		return creditNoteList;
	}

	public void setCreditNoteList(List<CreditNote> creditNoteList) {
		this.creditNoteList = creditNoteList;
	}

	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "CreditNoteList [creditNoteList=" + creditNoteList + ", errorMessage=" + errorMessage + "]";
	}
	
	

}
