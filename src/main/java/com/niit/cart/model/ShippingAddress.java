package com.niit.cart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;


@Entity

public class ShippingAddress
{
    @Id
    @GeneratedValue
    private int shippingAddressId;
   
    @Column
    private String addressLine1;
   
    @Column
    private String city;
    
    @Column
    private String state;
    
    @Column
    private String country;
    
    @Column
    private String zipCode;

    @OneToOne
  //  @JoinColumn(name="User",nullable=false)
    private User user;

	public int getShippingAddressId()
	{
		return shippingAddressId;
	}

	public void setShippingAddressId(int shippingAddressId) 
	{
		this.shippingAddressId = shippingAddressId;
	}

	public String getAddressLine1()
	{
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1)
	{
		this.addressLine1 = addressLine1;
	}

	public String getCity() 
	{
		return city;
	}

	public void setCity(String city) 
	{
		this.city = city;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public String getCountry()
	{
		return country;
	}

	public void setCountry(String country) 
	{
		this.country = country;
	}

	public String getZipCode()
	{
		return zipCode;
	}

	public void setZipCode(String zipCode) 
	{
		this.zipCode = zipCode;
	}

	public User getUser() 
	{
		return user;
	}

	public void setUser(User user) 
	{
		this.user = user;
	}

}    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*@Override
	public String toString() {
		return "ShippingAdd [shippingAddressId=" + shippingAddressId + ", houseNumber=" + houseNumber
				+ ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", city=" + city + ", state="
				+ state + ", country=" + country + ", zipCode=" + zipCode + ", usersDetail=" + usersDetail + "]";
	}*/



