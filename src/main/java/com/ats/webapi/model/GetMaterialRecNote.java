package com.ats.webapi.model;

import java.io.Serializable;
import java.util.List;


public class GetMaterialRecNote implements Serializable{

	  	MaterialRecNote materialRecNote;
	  	
	  	List<MaterialRecNoteDetails> materialRecNoteDetailList;

		public MaterialRecNote getMaterialRecNote() {
			return materialRecNote;
		}

		public void setMaterialRecNote(MaterialRecNote materialRecNote) {
			this.materialRecNote = materialRecNote;
		}

		public List<MaterialRecNoteDetails> getMaterialRecNoteDetailList() {
			return materialRecNoteDetailList;
		}

		public void setMaterialRecNoteDetailList(List<MaterialRecNoteDetails> materialRecNoteDetailList) {
			this.materialRecNoteDetailList = materialRecNoteDetailList;
		}
	  	
	  	
		
	}


