package com.ats.webapi.model.logistics;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_logis_make")
public class Make {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "make_id")
	private int makeId; 
	
	@Column(name = "make_name")
	private String makeName; 
	
	@Column(name = "del_status")
	private int delStatus;

	public int getMakeId() {
		return makeId;
	}

	public void setMakeId(int makeId) {
		this.makeId = makeId;
	}

	public String getMakeName() {
		return makeName;
	}

	public void setMakeName(String makeName) {
		this.makeName = makeName;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "Make [makeId=" + makeId + ", makeName=" + makeName + ", delStatus=" + delStatus + "]";
	}
	
	

}
