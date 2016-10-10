package com.buddies.service;

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

	public void updateEvent(Event event)
	{
		e.updateEvent(event);
	}
}
