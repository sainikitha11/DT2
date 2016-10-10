package com.niit.cart.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.cart.model.Cart;
import com.niit.cart.model.Category;
import com.niit.cart.model.Product;
import com.niit.cart.model.User;
import com.niit.cart.service.ICategoryService;
import com.niit.cart.service.IProductService;
import com.niit.cart.service.IUserService;

@Controller
public class HomeController 
{	
	@Autowired
	ICategoryService iCategoryService;
	
	@Autowired
	IProductService iProductService;
	
	@Autowired
	IUserService iUserService;
	
	@RequestMapping(value = { "/" , "home"})
	public ModelAndView newfile() 
	{
		System.out.println("home");
		return new ModelAndView("index").addObject("Categorys",iCategoryService.viewAllCategory());
	}
	
	@RequestMapping(value = { "about" })
	public ModelAndView about() 
	{
		System.out.println("about");
		return new ModelAndView("aboutUs");
	}
	
	@RequestMapping(value = { "alogin" })
	public ModelAndView alogin(ModelMap model) 
	{
		System.out.println("alogin");
		return new ModelAndView("alogin");
	}
	
	@RequestMapping(value = { "contact" })
	public ModelAndView contact() 
	{
		System.out.println("contact");
		return new ModelAndView("contactUs");
	}
	
	@RequestMapping(value = { "login" })
	public ModelAndView Login() 
	{
		System.out.println("Login");
		return new ModelAndView("home","command",new User()).addObject("login", true);
	}
	
	@RequestMapping(value = { "register" })
	public ModelAndView register() 
	{
		System.out.println("register");
		return new ModelAndView("home","command",new User()).addObject("register", true);
	}
	
	@RequestMapping(value = { "logout" })
	public ModelAndView logout() 
	{
		System.out.println("logout");
		return new ModelAndView("index","command",new User()).addObject("logout", true).addObject("Welcome",iUserService.setUser(null));
	}

	@RequestMapping(value = { "welcome" })
	public ModelAndView welcome() 
	{
		System.out.println("welcome");
		return new ModelAndView("welcome","command",new User()).addObject("welcome", true);
	}
	
	@RequestMapping(value = { "buy" })
	public ModelAndView buy()
	{
		System.out.println("buy");
		return new ModelAndView("buy");
		
	}
	
	@RequestMapping(value = { "confirm" })
	public ModelAndView confirm() 
	{
		System.out.println("confirm");
		return new ModelAndView("confirm");
	}
	
	@RequestMapping(value = { "shippingAddress" })
	public ModelAndView shippingAddress() 
	{
		System.out.println("shippingAddress");
		return new ModelAndView("shippingAddress");
	}
	
	@RequestMapping(value = { "userDetails" })
	public ModelAndView userDetails() 
	{
		System.out.println("userDetails");
		return new ModelAndView("userDetails");
	}
}
