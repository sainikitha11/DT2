package com.niit.cart.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.cart.model.Cart;
import com.niit.cart.model.UserOrder;
import com.niit.cart.model.User;
import com.niit.cart.service.ICartService;
import com.niit.cart.service.IOrderService;
import com.niit.cart.service.IUserService;

@Controller
public class OrderController {
	
	@Autowired
	ICartService iCartService;
	
	@Autowired
	IUserService iUserService;

	
}
