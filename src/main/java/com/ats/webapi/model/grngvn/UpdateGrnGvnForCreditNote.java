package com.ats.webapi.model.grngvn;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_grn_gvn")
public class UpdateGrnGvnForCreditNote {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "grn_gvn_id")
	int grnGvnId;
	
	
	@Column(name = "is_credit_note")
	private int isCreditNote;


	public int getGrnGvnId() {
		return grnGvnId;
	}


	public void setGrnGvnId(int grnGvnId) {
		this.grnGvnId = grnGvnId;
	}


	public int getIsCreditNote() {
		return isCreditNote;
	}


	public void setIsCreditNote(int isCreditNote) {
		this.isCreditNote = isCreditNote;
	}

	@Override
	public String toString() {
		return "UpdateGrnGvnForCreditNote [grnGvnId=" + grnGvnId + ", isCreditNote=" + isCreditNote + "]";
	}
	
}
