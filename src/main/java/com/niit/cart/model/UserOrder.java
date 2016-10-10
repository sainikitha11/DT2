package com.niit.cart.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class UserOrder
{
    @Id
    @GeneratedValue
    private Integer userOrderId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

	@ManyToOne
    @JoinColumn(name="shippingAddressId")
    private ShippingAddress shippingAddress;

	//Implementing getters and setters
	public Integer getUserOrderId()
	{
		return userOrderId;
	}

	public void setUserOrderId(Integer userOrderId) 
	{
		this.userOrderId = userOrderId;
	}


	public User getUser()
	{
		return user;
	}

	public void setUser(User user) 
	{
		this.user = user;
	}

	public ShippingAddress getShippingAddress() 
	{
		return shippingAddress;
	}

	public void setShippingAddress(ShippingAddress shippingAddress) 
	{
		this.shippingAddress = shippingAddress;
	}
}
