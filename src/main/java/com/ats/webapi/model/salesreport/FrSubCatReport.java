package com.ats.webapi.model.salesreport;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FrSubCatReport {
	@Id
	private int subCatId;
	private String subCatName;

	private String frName;
	private int frId;

	private float soldQty;
	private float soldAmt;
	private float varQty;
	private float varAmt;

	private float retQty;
	private float retAmt;

	/*
	 * private float netQty; private float netAmt;
	 */

}
