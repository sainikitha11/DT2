package com.buddies.controller;

import java.io.IOException;
import java.util.List;

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

import com.buddies.model.User;
import com.buddies.model.UserFriend;
import com.buddies.service.IFriendService;
import com.buddies.service.IUserService;

@Controller
public class UserController
{
	@Autowired
	IUserService iUserService;
	
	@Autowired
	IFriendService iFriendService;
	
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
			iUserService.addUser(u);
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
}
