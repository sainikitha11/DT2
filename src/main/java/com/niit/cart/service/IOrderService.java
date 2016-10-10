package com.niit.cart.service;

import com.niit.cart.model.UserOrder;

public interface IOrderService
{
	void addOrder(UserOrder order);
    double getOrderGrandTotal(int cartId);
}
