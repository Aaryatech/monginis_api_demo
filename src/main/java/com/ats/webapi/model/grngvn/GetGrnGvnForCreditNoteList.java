package com.ats.webapi.model.grngvn;

import java.util.List;

import com.ats.webapi.model.Info;

public class GetGrnGvnForCreditNoteList {
	
	List<GetGrnGvnForCreditNote> getGrnGvnForCreditNotes;
	
	Info info;

	public List<GetGrnGvnForCreditNote> getGetGrnGvnForCreditNotes() {
		return getGrnGvnForCreditNotes;
	}

	public void setGetGrnGvnForCreditNotes(List<GetGrnGvnForCreditNote> getGrnGvnForCreditNotes) {
		this.getGrnGvnForCreditNotes = getGrnGvnForCreditNotes;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "GetGrnGvnForCreditNoteList [getGrnGvnForCreditNotes=" + getGrnGvnForCreditNotes + ", info=" + info
				+ "]";
	}
	
}
