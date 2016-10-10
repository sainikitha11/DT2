package com.niit.cart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.cart.DAO.OrderDAO;
import com.niit.cart.model.Cart;
import com.niit.cart.model.UserOrder;

import java.util.List;



@Service
public class OrderService implements IOrderService {

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private CartService cartService;

    public void addOrder(UserOrder order) 
    {
    	orderDAO.addOrder(order);
    }

    public double getOrderGrandTotal(int cartId) 
    {
        double grandTotal=0;
        List<Cart> cart = cartService.getCartById(cartId);
        List<Cart> cartItems = ((Cart) cart).getCart();

        for (Cart item : cartItems) {
            grandTotal+=item.getTotalPrice();
        }

        return grandTotal;
    }

}
