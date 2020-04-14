package com.ats.webapi.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_sp_cake_detail")
public class SpCakeDetailed {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="sp_cake_detailed_id")
	private int spCakeDetailedId;

	@Column(name="sp_id")
	private int spId;
	
	@Column(name="rm_type")
	private int rmType;

	@Column(name="rm_id")
	private int rmId;
	
	@Column(name="rm_name")
	private String rmName;
	
	@Column(name="rm_uom_id")
	private int rmUomId;
	
	@Column(name="rm_qty")
	private float rmQty;
	
	@Column(name="rm_weight")
	private float rmWeight;
	
	@Column(name="no_of_pieces_per_item")
	private float noOfPiecesPerItem;
	
	@Column(name="del_status")
	private int delStatus;
	
	/*	@Column(name="int1")
	private int int1;
	
	@Column(name="int2")
	private int int2;
	
	@Column(name="varchar1")
	private String varchar1;
	
	@Column(name="boll1")
	private int boll1;
	
	@Column(name="boll2")
	private int boll2;*/

	public int getSpCakeDetailedId() {
		return spCakeDetailedId;
	}

	public void setSpCakeDetailedId(int spCakeDetailedId) {
		this.spCakeDetailedId = spCakeDetailedId;
	}

	public int getSpId() {
		return spId;
	}

	public void setSpId(int spId) {
		this.spId = spId;
	}

	public int getRmType() {
		return rmType;
	}

	public void setRmType(int rmType) {
		this.rmType = rmType;
	}

	public int getRmId() {
		return rmId;
	}

	public void setRmId(int rmId) {
		this.rmId = rmId;
	}

	public String getRmName() {
		return rmName;
	}

	public void setRmName(String rmName) {
		this.rmName = rmName;
	}

	public int getRmUomId() {
		return rmUomId;
	}

	public void setRmUomId(int rmUomId) {
		this.rmUomId = rmUomId;
	}

	public float getRmQty() {
		return rmQty;
	}

	public void setRmQty(float rmQty) {
		this.rmQty = rmQty;
	}

	public float getRmWeight() {
		return rmWeight;
	}

	public void setRmWeight(float rmWeight) {
		this.rmWeight = rmWeight;
	}

	public float getNoOfPiecesPerItem() {
		return noOfPiecesPerItem;
	}

	public void setNoOfPiecesPerItem(float noOfPiecesPerItem) {
		this.noOfPiecesPerItem = noOfPiecesPerItem;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	/*public int getInt1() {
		return int1;
	}

	public void setInt1(int int1) {
		this.int1 = int1;
	}

	public int getInt2() {
		return int2;
	}

	public void setInt2(int int2) {
		this.int2 = int2;
	}

	public String getVarchar1() {
		return varchar1;
	}

	public void setVarchar1(String varchar1) {
		this.varchar1 = varchar1;
	}

	public int getBoll1() {
		return boll1;
	}

	public void setBoll1(int boll1) {
		this.boll1 = boll1;
	}

	public int getBoll2() {
		return boll2;
	}

	public void setBoll2(int boll2) {
		this.boll2 = boll2;
	}

	@Override
	public String toString() {
		return "SpCakeDetailed [spCakeDetailedId=" + spCakeDetailedId + ", spId=" + spId + ", rmType=" + rmType
				+ ", rmId=" + rmId + ", rmName=" + rmName + ", rmUomId=" + rmUomId + ", rmQty=" + rmQty + ", rmWeight="
				+ rmWeight + ", noOfPiecesPerItem=" + noOfPiecesPerItem + ", delStatus=" + delStatus + ", int1=" + int1
				+ ", int2=" + int2 + ", varchar1=" + varchar1 + ", boll1=" + boll1 + ", boll2=" + boll2 + "]";
	}

	
	*/
	
	
	
	
}
