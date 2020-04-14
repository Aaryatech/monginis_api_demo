package com.ats.webapi.model.logistics;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_logis_document")
public class Document {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "doc_id")
	private int docId;  
	
	@Column(name = "doc_name")
	private String docName; 
	
	@Column(name = "doc_alertdays")
	private String docAlertdays; 
	
	@Column(name = "doc_seq")
	private String docSeq; 
	
	@Column(name = "del_status")
	private int delStatus;

	public int getDocId() {
		return docId;
	}

	public void setDocId(int docId) {
		this.docId = docId;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getDocAlertdays() {
		return docAlertdays;
	}

	public void setDocAlertdays(String docAlertdays) {
		this.docAlertdays = docAlertdays;
	}

	public String getDocSeq() {
		return docSeq;
	}

	public void setDocSeq(String docSeq) {
		this.docSeq = docSeq;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "Document [docId=" + docId + ", docName=" + docName + ", docAlertdays=" + docAlertdays + ", docSeq="
				+ docSeq + ", delStatus=" + delStatus + "]";
	}
	
	

}
