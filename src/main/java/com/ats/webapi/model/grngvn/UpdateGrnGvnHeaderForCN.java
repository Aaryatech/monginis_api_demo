package com.ats.webapi.model.grngvn;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


//Bean Used to update GRN GVN HEADER After Credit Note Generation :set iscredit note and credit note id 
@Entity
@Table(name="t_grn_gvn_header")
public class UpdateGrnGvnHeaderForCN {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "grn_gvn_header_id")
	int grnGvnHeaderId;
	
	@Column(name = "credit_note_id")
	private String creditNoteId;
	
	@Column(name = "is_credit_note")
	private int isCreditNote;

	public int getGrnGvnHeaderId() {
		return grnGvnHeaderId;
	}

	public void setGrnGvnHeaderId(int grnGvnHeaderId) {
		this.grnGvnHeaderId = grnGvnHeaderId;
	}

	public String getCreditNoteId() {
		return creditNoteId;
	}

	public void setCreditNoteId(String creditNoteId) {
		this.creditNoteId = creditNoteId;
	}

	public int getIsCreditNote() {
		return isCreditNote;
	}

	public void setIsCreditNote(int isCreditNote) {
		this.isCreditNote = isCreditNote;
	}

	@Override
	public String toString() {
		return "UpdateGrnGvnHeaderForCN [grnGvnHeaderId=" + grnGvnHeaderId + ", creditNoteId=" + creditNoteId
				+ ", isCreditNote=" + isCreditNote + "]";
	}

	
}
