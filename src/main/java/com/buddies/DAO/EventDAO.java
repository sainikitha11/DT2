package com.buddies.DAO;

import java.util.List;

import com.buddies.model.Event;

public interface EventDAO 
{
	public void addEvent(Event event);
	public boolean deleteEvent(int id);
	public List<Event> viewAllEvents();
}
