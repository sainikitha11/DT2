package com.buddies.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.buddies.model.User;

@Controller
public class HomeController 
{		
	@RequestMapping(value = { "/", "home" })
	public ModelAndView home() 
	{
		System.out.println("home");
		return new ModelAndView("home");
	}
	
	@RequestMapping(value = { "logout" })
	public ModelAndView logout() 
	{
		System.out.println("logout");
		return new ModelAndView("home","command",new User());
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
}