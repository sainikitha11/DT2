package com.niit.cart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity

public class Supplier 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int sid;

	@Column
	private String sname;
	
	@Column
	private String saddress;
	
	//getters and setters
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() 
	{
		return sname;
	}
	
	public void setSname(String sname)
	{
		this.sname = sname;
	}
	
	public String getSaddress()
	{
		return saddress;
	}
	
	public void setSaddress(String saddress) 
	{
		this.saddress = saddress;
	}
}
