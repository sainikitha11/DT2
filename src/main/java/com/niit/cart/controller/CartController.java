package com.niit.cart.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.cart.model.Cart;
import com.niit.cart.model.UserOrder;
import com.niit.cart.model.Product;
import com.niit.cart.model.User;
import com.niit.cart.service.CartService;
import com.niit.cart.service.ICartService;
import com.niit.cart.service.IOrderService;
import com.niit.cart.service.IProductService;
import com.niit.cart.service.IUserService;

@Controller
public class CartController {
	                             
	@Autowired(required=true)
	ICartService iCartService;
	
	@Autowired(required=true)
	IProductService iProductService;
	
	@Autowired(required=true)
	IUserService iUserService;
	
	@Autowired
	IOrderService iOrderService;
	
	int cart1=0;
	
	@RequestMapping(value = { "/addcart" })
	public ModelAndView addCart()
	{
		System.out.println("add cart");
		return new ModelAndView("addcart").addObject("cart",iCartService.viewAllCart());
	}
	
	@RequestMapping(value = { "viewcart" })
	public ModelAndView cart(HttpServletRequest request, @ModelAttribute("cart") Product p,BindingResult result) {
		System.out.println("View Cart");
		return new ModelAndView("viewcart").addObject("cart",iCartService.viewAllCart());
	}
	
	@RequestMapping(value = { "/storecart" })
	public ModelAndView addcart(HttpServletRequest request, @ModelAttribute("cart") Product p,BindingResult result) {
		System.out.println("Store Cart");
		String pid = request.getParameter("p");
		Cart c=new Cart();
		c.setProduct(iProductService.editProduct(Integer.parseInt(pid)));
		c.setQuantity(1);
		c.setTotalPrice(0.0);
		System.out.print("adding to cart "+iUserService.getUser());
		c.setUser(iUserService.getUser());
		iCartService.addToCart(c);
		return new ModelAndView("addcart","cartItem",c).addObject("cart",iCartService.viewAllCart());
	}
	
	@RequestMapping(value = { "/updateCart" })
	public ModelAndView updateCart(){
		return new ModelAndView("updateCart");
	}
	@RequestMapping(value = { "cart/delete" })
	public String delete(HttpServletRequest request) 
	{
		String cartid = request.getParameter("c");
		iCartService.deleteCart(Integer.parseInt(cartid));
		System.out.println("Delete Product");
		iCartService.viewAllCart();
		return "redirect:/addcart";
		//return new ModelAndView("cart", "command", new Cart()).addObject("cart",iCartService.viewAllCart());
	}
		
	@RequestMapping(value = { "/cart"})
	public ModelAndView cont(HttpServletRequest request) 
	{
		System.out.println("Continue");
		return new ModelAndView("index").addObject("continue",true).addObject("Welcome",iUserService.getUser());
	}
	
	
	@RequestMapping(value = { "cart/order" })
	public String check(HttpServletRequest request,String c)
	{
		System.out.println("order");
		UserOrder order=new UserOrder();
		String car=request.getParameter("c");
		System.out.println("yup"+car);
		int cid= Integer.parseInt(car);
		System.out.println("yes");
		List<Cart> cart=iCartService.getCartById(cid);
		System.out.println(cart);
		System.out.println("cart");
		System.out.println("jhgfdv");
		User user=null;
		for(Cart ct:cart){
			user=ct.getUser();
		}
		order.setUser(user);
		//order.setShippingAddress(user.getShippingAddress());
		System.out.println("ship");
		iOrderService.addOrder(order);
		System.out.println("ord");
        user.getUid();
        System.out.println("user id");
		return "redirect:/shippingAddress";
		}
}