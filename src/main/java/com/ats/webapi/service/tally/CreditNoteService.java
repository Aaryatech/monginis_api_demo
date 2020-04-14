package com.ats.webapi.service.tally;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.tally.CreditNoteList;

@Service
public interface CreditNoteService {

	CreditNoteList getAllCreditNote();

	ErrorMessage updateCreditNote(int crnIdList, int isTallySync);

}
