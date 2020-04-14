package com.ats.webapi.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "m_fr_route")
public class Route implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@Column(name="route_id")
	private int routeId;
	@Column(name="route_name")
	private String routeName;
    @Column(name="del_status")
    private int delStatus;
    
	
	public String getRouteName() {
		return routeName;
	}
	public int getRouteId() {
		return routeId;
	}
	public void setRouteId(int routeId) {
		this.routeId = routeId;
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
	@Override
	public String toString() {
		return "Route [routeId=" + routeId + ", routeName=" + routeName + ", delStatus=" + delStatus + "]";
	}
	
}
