package com.buddies.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.buddies.model.Chat;
import com.buddies.model.User;
import com.buddies.service.IChatService;
import com.buddies.service.IFriendService;
import com.buddies.service.IUserService;


@Controller
public class ChatController {
	
	@Autowired
	IChatService iChatService;

	@Autowired
	IUserService iUserService;
	
	User friend;
	
	int trackid;

	@Autowired
	IFriendService iFriendService;
	
	
	@RequestMapping(value = {"/startChart" })
	public ModelAndView startChat(HttpServletRequest request,HttpServletResponse response){
		System.out.println("started chatting");
		trackid=Integer.parseInt(request.getParameter("frdid"));
		//System.out.println("asdfgh"+friend.getUserid());
		System.out.println("sdfghj"+trackid);
		return new ModelAndView("viewChatUsers", "command", new Chat()).addObject("msgs",iChatService.viewChat(iUserService.getUser().getUserid(),trackid)).addObject("chatusers",iUserService.viewUsers());
	}
	
	@RequestMapping(value = {"/storechat" })
	public ModelAndView reChat(HttpServletRequest request,ModelMap model,@ModelAttribute("buddychat") Chat c,BindingResult result){
		c.setFromUser(iUserService.getUser().getUserid());
		System.out.println("from user");
		//c.setMessage("Hi");
		System.out.println("msg set");
		c.setToUser(trackid);
		System.out.println("track");
		iChatService.addChat(c);
		System.out.println("cchat");
		return new ModelAndView("viewChatUsers", "command", new Chat()).addObject("msgs",iChatService.viewChat(iUserService.getUser().getUserid(),trackid)).addObject("chatusers",iUserService.viewUsers());
	}
	
	//this is for view chat
	@RequestMapping(value={ "viewChatUsers"})
	public ModelAndView viewchat(HttpServletRequest request,@Valid @ModelAttribute("thinkQuest") Chat c,BindingResult result) 
	{
		System.out.println("view chat");
		ModelAndView mv=new ModelAndView("viewChatUsers","command",new Chat());
		mv.addObject("chatusers", iUserService.viewUsers());
		System.out.println("chatting users");
		return  mv; 
	}
	
	//this mehtod is used to search the chat
	public String toJson(List data){
		String jsonData="";
		ObjectMapper mapper=new ObjectMapper();
		try {
			jsonData=mapper.writeValueAsString(data);
			System.out.println(jsonData);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonData;
	}
}

