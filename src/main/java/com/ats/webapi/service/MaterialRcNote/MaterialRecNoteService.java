package com.ats.webapi.service.MaterialRcNote;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ats.webapi.model.ErrorMessage;
import com.ats.webapi.model.GetMaterialRecNoteList;
import com.ats.webapi.model.MaterialRecNote;
import com.ats.webapi.model.tally.MaterialRecNoteList;
import com.ats.webapi.model.tally.MaterialReceiptNote;

@Service
public interface MaterialRecNoteService {

	MaterialRecNote postMaterialRecNote(MaterialRecNote materialRecNote);

	GetMaterialRecNoteList getMaterialRecNote(List<String> status);

	MaterialRecNote getMaterialRecNotesHeaderDetails(int mrnId);
	MaterialRecNote getMaterialRecNotesHeaderDetailsNew(int mrnId);

	MaterialRecNoteList getAllInwards();

	ErrorMessage updateInward(int mrnId, int isTallySync);

	 


}
