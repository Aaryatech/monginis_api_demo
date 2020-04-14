package com.ats.webapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SpCakeCount {
	@Id
	private int count;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "SpCakeCount [count=" + count + "]";
	}

}
