package com.buddies.service;

import com.buddies.model.Event;

public interface IEventService
{
	public void addEvent(Event event);
	public boolean deleteEvent(int id);
	public void updateEvent(Event event);
}
