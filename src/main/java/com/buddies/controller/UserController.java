package com.buddies.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
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

import com.buddies.model.Friend;
import com.buddies.model.User;
import com.buddies.model.UserFriend;
import com.buddies.service.IFriendService;
import com.buddies.service.IMailService;
import com.buddies.service.IUserService;

@Controller
public class UserController
{
	@Autowired
	IUserService iUserService;
	
	@Autowired
	IFriendService iFriendService;
	
	@Autowired
	IMailService iMailService;
	
	@RequestMapping(value="storeRegister", method=RequestMethod.POST)
	public ModelAndView register(HttpServletRequest request,@ModelAttribute("buddychat")User u,BindingResult result)throws MessagingException
	{
		System.out.println("Register"+u.getDate());
		u.setDate(new Date());
		ModelAndView mv=new ModelAndView("storeRegister");
		System.out.println("store");
		boolean flag=true;
		if(result.hasErrors()){
			flag=false;
			System.out.println("duster");
			mv=new ModelAndView("signup", "command", new User());
			System.out.println("controller");
					mv.addObject("errors", result.getAllErrors());
					for(ObjectError s:result.getAllErrors()){
						System.out.println(s.toString());
						if(s.toString().contains("date") && result.getAllErrors().size()==1 ){
							System.out.println("jennifer"
									+ "");
							flag=true;
						}
					}
					
		}
		if(flag){
			System.out.println("chalk");
			iUserService.addUser(u);
			System.out.println("teddy");
			iMailService.send(u, "Welcome to chatting", "Hi Welcome to chatting");
			mv=new ModelAndView("login", "command", new User());
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
	
	@RequestMapping(value=  { "viewFriend"})
	public ModelAndView addUser() {
		System.out.println("user added");
		System.out.println("viewfriend");
		int fndid;
		ModelAndView mv=new ModelAndView("viewFriend","command",new User());
		//System.out.println("hi frds "+iFriendService.viewAllRequest(iUserService.getUser().getUserid()).get(0).getReqid());
		mv.addObject("users", toJson(iUserService.viewUsers()));
		System.out.println("hyu");
		mv.addObject("friendRequests",iFriendService.viewAllRequest(iUserService.getUser().getUserid()));
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
	
	@RequestMapping(value = { "/addFriend" })
	public ModelAndView view(HttpServletRequest request, @ModelAttribute("buddychat") UserFriend f,BindingResult result) 
	{
		System.out.println("addfnd");
		String fid = request.getParameter("u");
		System.out.println("uuuu");
		System.out.println(fid);
		System.out.println("hsab");
		int Uid = 0;
		int frdid = 0;
		System.out.println("user n frds");
		System.out.println(iUserService.getUser().getName());
		System.out.println("sai");
		iFriendService.addFriend(iUserService.getUser(),Integer.parseInt(fid));
		System.out.println("nikki");
		return new ModelAndView("home","welcome",iUserService.getUser());
	}
	
	@RequestMapping(value = { "/acceptfriend" })
	public String view(HttpServletRequest request, @ModelAttribute("buddychat") Friend f,BindingResult result) 
	{
		System.out.println("accfnd");
		String fid = request.getParameter("f");
		System.out.println("jdsbc");
		iFriendService.updateFriendStatus(Integer.parseInt(fid));
		System.out.println("teddy");
		return "redirect:/viewFriend";
	}
}
