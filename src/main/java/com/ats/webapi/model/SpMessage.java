package com.ats.webapi.model;
import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "m_sp_msg")
public class SpMessage  implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="sp_msg_id")
	private int spMsgId;
	
	@Column(name = "sp_msg_text")
	private String spMsgText;
	@Column(name="del_status")
	private int delStatus;
	public int getSpMsgId() {
		return spMsgId;
	}
	public void setSpMsgId(int spMsgId) {
		this.spMsgId = spMsgId;
	}
	public String getSpMsgText() {
		return spMsgText;
	}
	public void setSpMsgText(String spMsgText) {
		this.spMsgText = spMsgText;
	}
	public int getDelStatus() {
		return delStatus;
	}
	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}
	@Override
	public String toString() {
		return "SpMessage [spMsgId=" + spMsgId + ", spMsgText=" + spMsgText + ", delStatus=" + delStatus + "]";
	}
	

}
