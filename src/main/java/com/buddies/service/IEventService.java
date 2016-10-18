package com.buddies.service;

import java.util.List;

import com.buddies.model.Event;

public interface IEventService
{
	public void addEvent(Event event);
	public boolean deleteEvent(int id);
	public List<Event> viewAllEvents();
}
