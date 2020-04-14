package com.ats.webapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.Info;
import com.ats.webapi.model.grngvn.GetGrnGvnForCreditNote;
import com.ats.webapi.model.grngvn.GetGrnGvnForCreditNoteList;
import com.ats.webapi.repository.GrnGvnForCreditNoteRepositoty;

@Service
public class GetGrnGvnForCreditNoteServiceImpl implements GetGrnGvnForCreditNoteService {
	
	@Autowired
	GrnGvnForCreditNoteRepositoty gvnForCreditNoteRepositoty;

	@Override
	public GetGrnGvnForCreditNoteList getGrnGvnForCreditNote(int isGrn,String fromDate, String toDate,
			List<Integer> frList) {
		
		
		GetGrnGvnForCreditNoteList getGrnGvnForCreditNote=new GetGrnGvnForCreditNoteList();
		
		Info info=new Info();
		
		List<GetGrnGvnForCreditNote> getGrnGvnForCreditNoteList=gvnForCreditNoteRepositoty.getGrnGvnDetailForCreditNote(isGrn,fromDate,toDate,frList);
		
		if(!getGrnGvnForCreditNoteList.isEmpty()||getGrnGvnForCreditNoteList!=null) {
			
			getGrnGvnForCreditNote.setGetGrnGvnForCreditNotes(getGrnGvnForCreditNoteList);
			
			info.setError(false);
			info.setMessage("Grn_Gvn Data received for credit note");
			
			
		}
		
		else {
			info.setError(true);
			info.setMessage("Error:Grn_Gvn Data failed");
			
		}
	
		getGrnGvnForCreditNote.setInfo(info);
		
	return getGrnGvnForCreditNote;
		
	}

}
