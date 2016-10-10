package com.niit.cart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "Category")
@Component

public class Category 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer cid;
	
	@Column
	private String cname;
	
	@Column
	private String cdesc;
	
	public Integer getCid()
	{
		return cid;
	}

	public void setCid(Integer cid) 
	{
		this.cid = cid;
	}

	public String getCname()
	{
		return cname;
	}

	public void setCname(String cname) 
	{
		this.cname = cname;
	}

	public String getCdesc()
	{
		return cdesc;
	}

	public void setCdesc(String cdesc)
	{
		this.cdesc = cdesc;
	}
}
