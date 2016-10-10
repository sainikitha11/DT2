package com.niit.cart.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.niit.cart.model.User;
import com.niit.cart.service.ICategoryService;
import com.niit.cart.service.IUserService;

@Controller
public class UserController 
{
	@Autowired
	IUserService iUserService;
	
	@Autowired
	ICategoryService iCategoryService;
	
	int tuid=0;
	
	User user=null;
	
	@RequestMapping(value = "store", method=RequestMethod.POST)
	public ModelAndView register(/*HttpServletRequest request,*/@Valid @ModelAttribute("cart") User u,BindingResult result) 
	{
		System.out.println("Register");
		//iUserService.addUser(u);
		ModelAndView mv=new ModelAndView("store").addObject("stat", "Register");
		if(result.hasErrors())
		{
			mv=new ModelAndView("register", "command", new User()).addObject("stat", "Register");
					mv.addObject("errors", result.getAllErrors());
					for(ObjectError s:result.getAllErrors())
					{
						System.out.println(s);
					}
		}
		else{
			iUserService.addUser(u);
			mv=new ModelAndView("login", "command", new User());
		}
		return mv;
	}
	
	@RequestMapping(value = { "LoginUser" })
	public ModelAndView Login(HttpServletRequest request,@ModelAttribute("cart") User u,BindingResult result)
	{
		System.out.println("Login");
		user=iUserService.verify(u);
		ModelAndView mv=new ModelAndView("home","Welcome",user).addObject("Categorys",iCategoryService.viewAllCategory());
		if(user.getRole()==1)
		{
			System.out.println(user.getRole());
			mv.addObject("userRole");
		}
		else if(user.getRole()==2)
		{
			System.out.println(user.getRole());
			mv.addObject("userRole","isSupplier");
		}	
		return mv;
	}

	/*@RequestMapping(value = { "logout" })
	public ModelAndView logout() 
	{
		System.out.println("logout");
		return new ModelAndView("index");
	}*/
	
	@RequestMapping(value = { "admin" })
	public ModelAndView admin()
	{
		return new ModelAndView("adminpg","command",new User());
	}

	@RequestMapping(value = { "accessdenied" })
	public ModelAndView error()
	{
		return new ModelAndView("error");
	}
	
	@RequestMapping(value = { "/profile" })
	public ModelAndView profile()
	{
		System.out.println("profile");
		return new ModelAndView("profile","command",user);
	}
	
	@RequestMapping(value = { "User/delete" })
	public ModelAndView delete(HttpServletRequest request) 
	{
		String uid = request.getParameter("u");
		iUserService.deleteUser(Integer.parseInt(uid));
		System.out.println("Delete user");
		//return "redirect:/register";
		return new ModelAndView("profile", "command",new User()).addObject("stat", "Delete User");
	}

	@RequestMapping(value = { "updateUser" })
	public ModelAndView edit(HttpServletRequest request) 
	{
		System.out.println("Edit User");
		String uid = request.getParameter("u");
		//tuid = iUserService.editUser(Integer.parseInt(uid));
		System.out.println(tuid);
		return new ModelAndView("profile", "command", iUserService.editUser(Integer.parseInt(uid))).addObject("user",iUserService.setUser(uid));
	}
}