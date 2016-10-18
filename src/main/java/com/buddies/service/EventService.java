package com.buddies.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buddies.DAO.EventDAO;
import com.buddies.model.Event;

@Service
public class EventService implements IEventService
{
	@Autowired(required=true)
	private EventDAO e;
	
	public void addEvent(Event event) 
	{
		e.addEvent(event);
	}

	public boolean deleteEvent(int id) 
	{
		return e.deleteEvent(id);
	}

	public List<Event> viewAllEvents() {
		return e.viewAllEvents();
	}
}
