package com.ats.webapi.model.logistics;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_logis_group")
public class SprGroup {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "group_id")
	private int groupId; 
	
	@Column(name = "group_name")
	private String groupName;

	@Column(name = "del_status")
	private int delStatus;
	
	//@Column(name = "type_id")
	private int typeId;

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}
	

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	@Override
	public String toString() {
		return "SprGroup [groupId=" + groupId + ", groupName=" + groupName + ", delStatus=" + delStatus + ", typeId="
				+ typeId + "]";
	}
 
	

}
