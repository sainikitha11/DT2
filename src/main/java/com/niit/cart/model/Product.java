package com.niit.cart.model;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity

public class Product
{	
	@ManyToOne
	@JoinColumn(name="Category",nullable = false)
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="Supplier",nullable = false)
	private Supplier supplier;
		
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer pid;
	
	@Column
	private String pname;
	
	@Column
	private String desc;
	
	@Column
	@NotNull
	private double price;
	
	@Transient
	private MultipartFile image;
	
	//Implementing getters and setters..
	
	public MultipartFile getImage()
	{
		return image;
	}

	public void setImage(MultipartFile image) 
	{
		this.image = image;
	}
	
	public Integer getPid() 
	{
		return pid;
	}
	
	public void setPid(Integer pid) 
	{
		this.pid = pid;
	}
	
	public Category getCategory() 
	{
		return category;
	}
	
	public void setCategory(Category category)
	{
		this.category = category;
	}
	
	public String getPname()
	{
		return pname;
	}
	
	public void setPname(String pname) 
	{
		this.pname = pname;
	}
	
	public String getDesc()
	{
		return desc;
	}
	
	public void setDesc(String desc) 
	{
		this.desc = desc;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public void setPrice(double price)
	{
		this.price = price;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
}