package com.ats.webapi.model.tally;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="m_item_sup")
public class Items {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="item_id")
	private int id;
	
	@Column(name="is_tally_sync")
	private int isTallySync;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIsTallySync() {
		return isTallySync;
	}

	public void setIsTallySync(int isTallySync) {
		this.isTallySync = isTallySync;
	}

	
    
}
