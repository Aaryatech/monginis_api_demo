package com.ats.webapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ats.webapi.model.Event;
import com.ats.webapi.model.Flavour;
import com.ats.webapi.model.Info;
import com.ats.webapi.repository.EventRepository;
import com.ats.webapi.util.JsonUtil;
@Service
public class EventServiceImpl implements EventService {
	String jsonEvent="{}";
	Event event;
	@Autowired
	EventRepository eventRepository;

	@Override
	public String save(Event event) {
		
		try {
			if(event.getSpeName()!=null&&!event.getSpeName().trim().equals("")) {
				event=eventRepository.save(event);
				Info info=new Info();
				info.setError(false);
				info.setMessage("Event inserted Successfully");
				jsonEvent=JsonUtil.javaToJson(info);
			}
			else {
				 event.setSpeName(event.getSpeName());
				 Info info=new Info();
				 info.setError(true);
				 info.setMessage("Event insertion failed");
				 jsonEvent=JsonUtil.javaToJson(info);
				
			}
			
		}
		catch (Exception e) {
				System.out.println("Flavour service impl ex"+e.getMessage());
			}
		return jsonEvent;
	}

	@Override
	public List<Event> findAllEvent() {
		List<Event> eventList=eventRepository.findByDelStatusOrderBySpeNameAsc(0);
	return eventList;
	}

	@Override
	public Event findEvent(int id) {
		Event event=eventRepository.findOne(id);
	return event;
	}

	@Override
	public Event updateEvent(int id) {
		Event event=eventRepository.findOne(id);
	return event;
	}

	@Override
	public Event findEventById(int speId) {
		
		Event event=eventRepository.findOne(speId);

		return event;
	}

}
