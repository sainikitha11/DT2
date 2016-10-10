package com.niit.cart.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.cart.DAO.CartDAO;
import com.niit.cart.model.Cart;

@Service("CartService")
public class CartService implements ICartService
{	
	@Autowired(required=true)
	private CartDAO cd;
	
	public List<Cart> viewAllCart()
	{
		return cd.viewAllCart();
	}

	public void deleteCart(int cartid)
	{
		cd.deleteCart(cartid);
	}

	public void addToCart(Cart cart) 
	{
		cd.addCart(cart);		
	}

	public List<Cart> getCartById(int cartId) 
	{
		return cd.getCartById(cartId);
	}

	public void updateCart(Cart cart)
	{
		cd.updateCart(cart);
	}
}
