package com.ats.webapi.model.spprod;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="m_instrument")
public class Instrument implements Serializable{

	@Transient
	private boolean isError;
	
	@Transient
	private String message;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="instrument_id")
	private int instrumentId;
	
	@Column(name="instrument_name")
	private String instrumentName;
	
	@Column(name="instrument_opqty")
	private int instrumentOpqty;
	
	@Column(name="instrument_clqty")
	private int instrumentClqty;
	
	@Column(name="instrument_is_used")
	private int instrumentIsUsed;
	
	@Column(name="instrument_status")
	private String instrumentStatus;
	
	@Column(name="stock_qty")
	private int stockQty;
	
	@Column(name="inst_type")
	private int instType;

	@Column(name="del_status")
	private int delStatus;
	
	public int getInstType() {
		return instType;
	}

	public void setInstType(int instType) {
		this.instType = instType;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public boolean isError() {
		return isError;
	}

	public void setError(boolean isError) {
		this.isError = isError;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getInstrumentId() {
		return instrumentId;
	}

	public void setInstrumentId(int instrumentId) {
		this.instrumentId = instrumentId;
	}

	public String getInstrumentName() {
		return instrumentName;
	}

	public void setInstrumentName(String instrumentName) {
		this.instrumentName = instrumentName;
	}

	public int getInstrumentOpqty() {
		return instrumentOpqty;
	}

	public void setInstrumentOpqty(int instrumentOpqty) {
		this.instrumentOpqty = instrumentOpqty;
	}

	public int getInstrumentClqty() {
		return instrumentClqty;
	}

	public void setInstrumentClqty(int instrumentClqty) {
		this.instrumentClqty = instrumentClqty;
	}

	public int getInstrumentIsUsed() {
		return instrumentIsUsed;
	}

	public void setInstrumentIsUsed(int instrumentIsUsed) {
		this.instrumentIsUsed = instrumentIsUsed;
	}

	public String getInstrumentStatus() {
		return instrumentStatus;
	}

	public void setInstrumentStatus(String instrumentStatus) {
		this.instrumentStatus = instrumentStatus;
	}

	public int getStockQty() {
		return stockQty;
	}

	public void setStockQty(int stockQty) {
		this.stockQty = stockQty;
	}

	@Override
	public String toString() {
		return "Instrument [isError=" + isError + ", message=" + message + ", instrumentId=" + instrumentId
				+ ", instrumentName=" + instrumentName + ", instrumentOpqty=" + instrumentOpqty + ", instrumentClqty="
				+ instrumentClqty + ", instrumentIsUsed=" + instrumentIsUsed + ", instrumentStatus=" + instrumentStatus
				+ ", stockQty=" + stockQty + "]";
	}

}
