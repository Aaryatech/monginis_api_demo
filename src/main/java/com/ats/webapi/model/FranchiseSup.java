package com.ats.webapi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author ats-12
 *
 */
@Entity
@Table(name="m_franchise_sup")
public class FranchiseSup implements Serializable{
	
	@Transient
	private boolean error;
	
	@Transient
	private String message;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="fr_id")
	private int frId;
	
	private String frPanNo;
	
	private String frState;
	
	private String frCountry;
	
	private String pass1;

	private String pass2;

	private String pass3;

	private String pass4;
	
	private String pass5;
	
    private int frequency;
	
	private Date pestControlDate;
	
	private Date remainderDate;
	
	private int delStatus;
	
	private int noInRoute;
	
	@Column(name="is_tally_sync")
	private int isTallySync;

	
	public int getNoInRoute() {
		return noInRoute;
	}

	public void setNoInRoute(int noInRoute) {
		this.noInRoute = noInRoute;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getPestControlDate() {
		return pestControlDate;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public void setPestControlDate(Date pestControlDate) {
		this.pestControlDate = pestControlDate;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public Date getRemainderDate() {
		return remainderDate;
	}
	@JsonFormat(locale = "hi",timezone = "Asia/Kolkata", pattern = "dd-MM-yyyy")
	public void setRemainderDate(Date remainderDate) {
		this.remainderDate = remainderDate;
	}

	public int getIsTallySync() {
		return isTallySync;
	}

	public void setIsTallySync(int isTallySync) {
		this.isTallySync = isTallySync;
	}

	public String getPass4() {
		return pass4;
	}

	public void setPass4(String pass4) {
		this.pass4 = pass4;
	}

	public String getPass5() {
		return pass5;
	}

	public void setPass5(String pass5) {
		this.pass5 = pass5;
	}

	public String getPass1() {
		return pass1;
	}

	public void setPass1(String pass1) {
		this.pass1 = pass1;
	}

	public String getPass2() {
		return pass2;
	}

	public void setPass2(String pass2) {
		this.pass2 = pass2;
	}

	public String getPass3() {
		return pass3;
	}

	public void setPass3(String pass3) {
		this.pass3 = pass3;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFrId() {
		return frId;
	}

	public void setFrId(int frId) {
		this.frId = frId;
	}

	public String getFrPanNo() {
		return frPanNo;
	}

	public void setFrPanNo(String frPanNo) {
		this.frPanNo = frPanNo;
	}

	public String getFrState() {
		return frState;
	}

	public void setFrState(String frState) {
		this.frState = frState;
	}

	public String getFrCountry() {
		return frCountry;
	}

	public void setFrCountry(String frCountry) {
		this.frCountry = frCountry;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "FranchiseSup [error=" + error + ", message=" + message + ", id=" + id + ", frId=" + frId + ", frPanNo="
				+ frPanNo + ", frState=" + frState + ", frCountry=" + frCountry + ", pass1=" + pass1 + ", pass2="
				+ pass2 + ", pass3=" + pass3 + ", pass4=" + pass4 + ", pass5=" + pass5 + ", frequency=" + frequency
				+ ", pestControlDate=" + pestControlDate + ", remainderDate=" + remainderDate + ", delStatus="
				+ delStatus + ", noInRoute=" + noInRoute + ", isTallySync=" + isTallySync + "]";
	}
    
}
