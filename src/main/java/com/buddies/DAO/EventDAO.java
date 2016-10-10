package com.buddies.DAO;

import com.buddies.model.Event;

public interface EventDAO 
{
	public void addEvent(Event event);
	public boolean deleteEvent(int id);
	public void updateEvent(Event event);
}
