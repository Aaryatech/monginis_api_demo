package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.webapi.model.Event;


public interface EventRepository extends JpaRepository<Event, Integer>{
	public Event save(Event event);
	public List<Event> findAll();
	public List<Event> findByDelStatus(int i);
	public Event findOne(int speId);
	public List<Event> findByDelStatusOrderBySpeNameAsc(int i);
	
		

}
