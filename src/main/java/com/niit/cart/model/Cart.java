package com.niit.cart.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component

public class Cart
{
	@ManyToOne
	@JoinColumn(name="Product",nullable = false)
	private Product product;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer cartid;
	
	@Column
	private Integer quantity;
	
	@Column
	private Double totalPrice;
	
	@OneToOne
	@JoinColumn(name="User",nullable=false)
	private User user;
	
	//Implementing getter and setter methods
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getCartid() {
		return cartid;
	}

	public void setCartid(Integer cartid) {
		this.cartid = cartid;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public List<Cart> getCart() 
	{
		return getCart();
	}

}
