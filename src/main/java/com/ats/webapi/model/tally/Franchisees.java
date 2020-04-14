package com.ats.webapi.model.tally;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_franchise_sup")
public class Franchisees {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="fr_id")
	private int frId;
	
	@Column(name="is_tally_sync")
	private int isTallySync;

	public int getFrId() {
		return frId;
	}

	public void setFrId(int frId) {
		this.frId = frId;
	}

	public int getIsTallySync() {
		return isTallySync;
	}

	public void setIsTallySync(int isTallySync) {
		this.isTallySync = isTallySync;
	}
	
	

}
