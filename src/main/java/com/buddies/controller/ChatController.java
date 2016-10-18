package com.buddies.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.buddies.service.IChatService;
import com.buddies.service.IFriendService;
import com.buddies.service.IUserService;

@Controller
public class ChatController {
	
	@Autowired
	IChatService iChatService;

	@Autowired
	IUserService iUserService;
	

	@Autowired
	IFriendService iFriendService;
	
	@RequestMapping(value=  { "viewChatUsers"})
	public ModelAndView viewblog() {
		System.out.println("view chat");
		ModelAndView mv=new ModelAndView("viewChatUsers");
		mv.addObject("chatusers", iUserService.viewUsers());
		/*System.out.println("hyu");
		mv.addObject("friendRequests",iFriendService.viewAllRequest(iUserService.getUser().getUserid()));*/
		return  mv; 
	}
	
	@RequestMapping(value=  { "startChart"})
	public ModelAndView startChart(HttpServletRequest request) {
		System.out.println("start chat");
		String frdid=request.getParameter("frdid");
		System.out.println("hg");
		ModelAndView mv=new ModelAndView("viewChatUsers");
		System.out.println("hgsdc");
		mv.addObject("chatusers", iUserService.viewUsers());
		System.out.println("hcvh");
		mv.addObject("friend",iFriendService.retriveFriend(Integer.parseInt(frdid)));
		return  mv; 
	}
	
	public String toJson(List data){
		String jsonData="";
		ObjectMapper mapper=new ObjectMapper();
		try {
			jsonData=mapper.writeValueAsString(data);
			System.out.println(jsonData);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonData;
	}
}
