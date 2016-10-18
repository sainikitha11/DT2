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

import com.buddies.model.Forum;
import com.buddies.service.IForumService;

@Controller
public class ForumController 
{
	@Autowired
	IForumService iForumService;
	
	@RequestMapping(value = { "forum" })
	public ModelAndView addBlog(HttpServletRequest request,@ModelAttribute("buddychat")Forum f,BindingResult result) 
	{
		System.out.println("hi forum");
		iForumService.addQuestion(f);
		System.out.println("f added");
		ModelAndView mv= new ModelAndView("forum","command",new Forum());
		System.out.println("new forum");
		return mv;
	}
	
	@RequestMapping(value=  { "addForum"})
	public ModelAndView addforum() {
		System.out.println("addforum");
		String jsonData="";
		//objectmapper is used 2 bring value instead of returning the total object
		ObjectMapper mapper=new ObjectMapper();
		try 
		{
			jsonData=mapper.writeValueAsString(iForumService.viewForum());
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
		return new ModelAndView("addforum","command",new Forum()).addObject("forum", jsonData);
	}
}
