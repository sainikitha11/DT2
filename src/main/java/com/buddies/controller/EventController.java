package com.buddies.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.buddies.DAO.EventDAO;
import com.buddies.model.Event;
import com.buddies.service.IEventService;

@RestController
public class EventController 
{
	@Autowired
	IEventService iEventService;
	
	@Autowired 
	EventDAO eventDAO;
	
private static final Logger logger=LoggerFactory.getLogger(EventController.class);
	
	//creating a new event
	@PostMapping(value="/event")
	public ResponseEntity<List<Event>> addEvent(@RequestBody Event event)
	{
		logger.debug("calling mthods after creating");
		eventDAO.addEvent(event);
		return new ResponseEntity<List<Event>>(HttpStatus.OK);
	}
		
	//deleting an event by its id
	@DeleteMapping(value="/event/{id}")
	public ResponseEntity<List<Event>> deleteEvent(@RequestBody Event event,@PathVariable int id)
	{
		logger.debug("delete event");
		eventDAO.deleteEvent(id);
		return new ResponseEntity<List<Event>>(HttpStatus.OK);
	}
		
	//updating an event
	@PutMapping(value="/event/{id}")
	public ResponseEntity<List<Event>> update(@RequestBody Event event)
	{
		logger.debug("update event");
		eventDAO.updateEvent(event);
		return new ResponseEntity<List<Event>>(HttpStatus.OK);
	}
}