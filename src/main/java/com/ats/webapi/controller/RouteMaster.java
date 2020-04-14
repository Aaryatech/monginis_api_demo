package com.ats.webapi.controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_fr_route")
public class RouteMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@Column(name="route_id")
	private int routeId;
	
	@Column(name="route_name")
	private String routeName;
	
    @Column(name="del_status")
    private int delStatus;
    
    @Column(name="abc_type")
    private int abcType;
    
    @Column(name="seq_no")
    private int seqNo;

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getAbcType() {
		return abcType;
	}

	public void setAbcType(int abcType) {
		this.abcType = abcType;
	}

	public int getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(int seqNo) {
		this.seqNo = seqNo;
	}

	@Override
	public String toString() {
		return "RouteMaster [routeId=" + routeId + ", routeName=" + routeName + ", delStatus=" + delStatus
				+ ", abcType=" + abcType + ", seqNo=" + seqNo + "]";
	}
    
    

}
