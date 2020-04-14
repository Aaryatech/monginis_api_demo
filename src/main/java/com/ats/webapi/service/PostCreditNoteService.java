package com.ats.webapi.service;

import java.util.List;

import com.ats.webapi.model.grngvn.PostCreditNoteHeader;

public interface PostCreditNoteService {
	
	public List<PostCreditNoteHeader> savePostCreditNote(List<PostCreditNoteHeader> postCreditNoteHeader);

	public List<PostCreditNoteHeader> postCreditNoteForUpdate(List<PostCreditNoteHeader> postCreditNoteHeader);
	

}
