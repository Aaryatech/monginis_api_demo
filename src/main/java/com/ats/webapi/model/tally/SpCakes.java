package com.ats.webapi.model.tally;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="m_spcake_sup")
public class SpCakes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="sp_id")
	private int spId;
	
	@Column(name="is_tally_sync")
	private int isTallySync;

	

	public int getSpId() {
		return spId;
	}

	public void setSpId(int spId) {
		this.spId = spId;
	}

	public int getIsTallySync() {
		return isTallySync;
	}

	public void setIsTallySync(int isTallySync) {
		this.isTallySync = isTallySync;
	}

	

   
}
