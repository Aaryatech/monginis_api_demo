package com.ats.webapi.model.tally;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_credit_note_header")
public class CreditNotes {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="crn_id")
	private int crnId;
	
	@Column(name="is_tally_sync")
	private int isTallySync;

	public int getCrnId() {
		return crnId;
	}

	public void setCrnId(int crnId) {
		this.crnId = crnId;
	}

	public int getIsTallySync() {
		return isTallySync;
	}

	public void setIsTallySync(int isTallySync) {
		this.isTallySync = isTallySync;
	}
	
	
}
