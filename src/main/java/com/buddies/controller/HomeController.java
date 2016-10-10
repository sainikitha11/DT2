package com.buddies.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.buddies.model.Event;
import com.buddies.model.Forum;
import com.buddies.model.User;
import com.buddies.model.Blog;
import com.buddies.model.Comment;
import com.buddies.service.IBlogService;
import com.buddies.service.ICommentService;
import com.buddies.service.IEventService;
import com.buddies.service.IForumService;
import com.buddies.service.IUserService;

@Controller
public class HomeController 
{	
	@Autowired
	IBlogService iBlogService;
	
	@Autowired
	IUserService iUserService;
	
	@Autowired
	IForumService iForumService;
	
	@Autowired
	IEventService iEventService;
	
	@Autowired
	ICommentService iCommentService;
	
	@RequestMapping(value = { "/", "home" })
	public ModelAndView home() 
	{
		System.out.println("home");
		return new ModelAndView("home");
	}
	
	@RequestMapping(value = { "login" })
	public ModelAndView login() 
	{
		System.out.println("login");
		return new ModelAndView("login","command",new User());
	}
	
	@RequestMapping(value = { "signUp" })
	public ModelAndView sign() 
	{
		System.out.println("sign");
		return new ModelAndView("signUp","command",new User());
	}
	
	@RequestMapping(value=  { "addBlog"})
	public ModelAndView viewblog() {
		System.out.println("viewblog");
		String jsonData="";
		//objectmapper is used 2 bring value instead of returning the total object
		ObjectMapper mapper=new ObjectMapper();
		try 
		{
			jsonData=mapper.writeValueAsString(iBlogService.viewBlog());
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
		return new ModelAndView("addBlog","command",new Blog()).addObject("blogs", jsonData);
	}
	/*@RequestMapping(value = { "addBlog" })
	public ModelAndView addBlog(HttpServletRequest request, @ModelAttribute("buddychat")Blog b) 
	{
		System.out.println("blog app");
		return new ModelAndView("addBlog","command",new Blog()).addObject("blog",iBlogService.viewBlog());
	}*/
	
	/*@RequestMapping(value = { "blog" })
	public ModelAndView blog() 
	{
		System.out.println("blog app");
		return new ModelAndView("blog");
	}*/
	
	@RequestMapping(value = { "chat" })
	public ModelAndView chat() 
	{
		System.out.println("chat app");
		return new ModelAndView("chat");
	}
	
	@RequestMapping(value = { "viewComment" })
	public ModelAndView viewComment() 
	{
		System.out.println("view Comment");
		return new ModelAndView("viewComment");
	}
	
	@RequestMapping(value = { "forum" })
	public ModelAndView addBlog(HttpServletRequest request,@ModelAttribute("buddychat")Forum f,BindingResult result) 
	{
		System.out.println("hi forum");
		iForumService.addQuestion(f);
		System.out.println("blog added");
		ModelAndView mv= new ModelAndView("forum","command",new Forum());
		System.out.println("new forum");
		return mv;
	}
	
	@RequestMapping(value = { "blog" })
	public ModelAndView Blog(HttpServletRequest request,@ModelAttribute("buddychat")Blog b,BindingResult result) 
	{
		iBlogService.addBlog(b);
		System.out.println("Blog");
		ModelAndView mv=new ModelAndView("blog","command",new Blog());
		return mv;
	}
	
	@RequestMapping(value = { "event" })
	public ModelAndView view(HttpServletRequest request,@ModelAttribute("buddychat")Event u,BindingResult result) 
	{
		iEventService.addEvent(u);
		System.out.println("View blog");
		ModelAndView mv= new ModelAndView("event","command",new Event());
		return mv;
	}
	
	@RequestMapping(value = { "comment" })
	public ModelAndView comment(HttpServletRequest request,@ModelAttribute("buddychat")Comment u,BindingResult result) 
	{
		iCommentService.addComment(u);
		System.out.println("View comment");
		ModelAndView mv= new ModelAndView("comment","command",new Comment());
		return mv;
	}
	
	@RequestMapping(value="storeRegister", method=RequestMethod.POST)
	public ModelAndView register(HttpServletRequest request,@ModelAttribute("buddychat")User u,BindingResult result)
	{
		System.out.println("register");
		ModelAndView mv=new ModelAndView("storeRegister");
		System.out.println("signing");
		if(result.hasErrors())
		{
			System.out.println("hello errors");
			mv=new ModelAndView("signUp","command",new User());
			mv.addObject("errors",result.getAllErrors());
			for(ObjectError s:result.getAllErrors())
			{
				System.out.println(s);
			}
		}
		else
		{
			iUserService.signUp(u);
			mv=new ModelAndView("login","command",new User());
		}
		return mv;
	}
	
	@RequestMapping(value="loginUser")
	public ModelAndView login(@ModelAttribute("buddychat")User u,BindingResult result)
	{
		System.out.println("login..");
		User user=iUserService.verifyMail(u);
		ModelAndView mv=new ModelAndView("home","command",new User());
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