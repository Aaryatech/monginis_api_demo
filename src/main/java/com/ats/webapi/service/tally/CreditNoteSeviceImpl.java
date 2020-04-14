package com.ats.webapi.service.tally;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.tally.CreditNote;
import com.ats.webapi.model.tally.CreditNoteList;
import com.ats.webapi.repository.tally.TallyCNoteUpdateRepository;
import com.ats.webapi.repository.tally.TallyCreditNoteRepository;

@Service
public class CreditNoteSeviceImpl implements CreditNoteService{

	@Autowired
	TallyCreditNoteRepository tallyCreditNoteRepository;
	
	@Autowired
	TallyCNoteUpdateRepository tallyCNoteUpdateRepository;
	
	@Override
	public CreditNoteList getAllCreditNote() {   
		
		CreditNoteList creditNoteList=new CreditNoteList();

     List<CreditNote> creditNotes=tallyCreditNoteRepository.findByIsTallySync();
		
		ErrorMessage errorMessage=new ErrorMessage();
		
		if(creditNotes==null)
		{
		
			errorMessage.setError(true);
			errorMessage.setMessage("Credit Note Not Found");
			
			creditNoteList.setErrorMessage(errorMessage);
		}
		else
		{
			errorMessage.setError(false);
			errorMessage.setMessage("Credit Note Found Successfully");
			
			creditNoteList.setCreditNoteList(creditNotes);
			creditNoteList.setErrorMessage(errorMessage);
			
		}
		return creditNoteList;
	}

	@Override
	public ErrorMessage updateCreditNote(int crnId, int isTallySync) {

		ErrorMessage errorMessage=new ErrorMessage();
		
		int i=tallyCNoteUpdateRepository.updateCreditNote(crnId,isTallySync);
	
		if(i==1) {
		
		errorMessage.setError(false);
		errorMessage.setMessage("Credit Note Updated Successfully");
		}
		else
		{
			errorMessage.setError(false);
			errorMessage.setMessage("Credit Note Updation Failed");
			
		}
		return errorMessage;
}

}
