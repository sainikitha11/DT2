package com.buddies.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.buddies.model.Blog;
import com.buddies.model.Event;
import com.buddies.service.IEventService;

@Controller
public class EventController
{
	@Autowired
	IEventService iEventService;
	
	@RequestMapping(value = { "event" })
	public ModelAndView view(HttpServletRequest request,@ModelAttribute("buddychat")Event u,BindingResult result) 
	{
		iEventService.addEvent(u);
		System.out.println("View blog");
		ModelAndView mv= new ModelAndView("event","command",new Event());
		return mv;
	}
	
	@RequestMapping(value=  { "addEvent"})
	public ModelAndView viewEvent() {
		System.out.println("viewEvent");
		String jsonData="";
		//objectmapper is used 2 bring value instead of returning the total object
		ObjectMapper mapper=new ObjectMapper();
		try 
		{
			jsonData=mapper.writeValueAsString(iEventService.viewAllEvents());
			System.out.println(jsonData);
		}
		catch (JsonGenerationException e)
		{
			e.printStackTrace();
		}
		catch (JsonMappingException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return new ModelAndView("addEvent","command",new Event()).addObject("events", jsonData);
	}
}
