package com.ats.webapi.model;

import java.util.List;

public class EventList {
	List<Event> event;
	Info info;
	public List<Event> getEvent() {
		return event;
	}
	public void setEvent(List<Event> event) {
		this.event = event;
	}
	public Info getInfo() {
		return info;
	}
	public void setInfo(Info info) {
		this.info = info;
	}
	

}
