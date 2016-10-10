package com.niit.cart.service;

import java.io.IOException;
import java.util.List;

import com.niit.cart.model.Cart;
import com.niit.cart.model.Product;

public interface ICartService 
{
	public List<Cart> viewAllCart();
	public void deleteCart(int cartid);
	public void addToCart(Cart c);
	public List<Cart> getCartById(int cartId);
	public void updateCart(Cart cart);
}
