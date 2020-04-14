package com.ats.webapi.model.spprod;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class GetStationAllocation implements Serializable{

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="allocation_id")
		private int allocationId;
		
		@Column(name="station_id")
		private int stationId;
		
		@Column(name="st_name")
		private String stName;
		
		@Column(name="shift_id")
		private int shiftId;
		
		@Column(name="shift_name")
		private String shiftName;
		
		@Column(name="emp_mistry_id")
		private int empMistryId;
		
		@Column(name="emp_mistry_name")
		private String empMistryName;
		
		@Column(name="emp_helper_id")
		private int empHelperId;
		
		@Column(name="emp_helper_name")
		private String empHelperName;
		
		@Column(name="del_status")
		private int delStatus;
        
		public String getStName() {
			return stName;
		}

		public void setStName(String stName) {
			this.stName = stName;
		}

		public String getShiftName() {
			return shiftName;
		}

		public void setShiftName(String shiftName) {
			this.shiftName = shiftName;
		}

		public String getEmpMistryName() {
			return empMistryName;
		}

		public void setEmpMistryName(String empMistryName) {
			this.empMistryName = empMistryName;
		}

		public String getEmpHelperName() {
			return empHelperName;
		}

		public void setEmpHelperName(String empHelperName) {
			this.empHelperName = empHelperName;
		}

		public int getAllocationId() {
			return allocationId;
		}

		public void setAllocationId(int allocationId) {
			this.allocationId = allocationId;
		}

		public int getStationId() {
			return stationId;
		}

		public void setStationId(int stationId) {
			this.stationId = stationId;
		}

		public int getShiftId() {
			return shiftId;
		}

		public void setShiftId(int shiftId) {
			this.shiftId = shiftId;
		}

		public int getEmpMistryId() {
			return empMistryId;
		}

		public void setEmpMistryId(int empMistryId) {
			this.empMistryId = empMistryId;
		}

		public int getEmpHelperId() {
			return empHelperId;
		}

		public void setEmpHelperId(int empHelperId) {
			this.empHelperId = empHelperId;
		}

		public int getDelStatus() {
			return delStatus;
		}

		public void setDelStatus(int delStatus) {
			this.delStatus = delStatus;
		}

		@Override
		public String toString() {
			return "StationAllocation [ allocationId=" + allocationId
					+ ", stationId=" + stationId + ", shiftId=" + shiftId + ", empMistryId=" + empMistryId
					+ ", empHelperId=" + empHelperId + ", delStatus=" + delStatus + "]";
		}
		
	}
