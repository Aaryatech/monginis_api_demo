package com.ats.webapi.service;

import java.util.List;

import com.ats.webapi.model.Event;
import com.ats.webapi.model.Flavour;

public interface EventService {
	public String save(Event event);
	public List<Event> findAllEvent();
	public Event findEvent(int id);
	public Event updateEvent( int id);
	public Event findEventById(int speId);
	
}
