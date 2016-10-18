package com.buddies.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class User
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer userid;
	
	@Size(min = 2, max = 50, message="firstname must have atleat 6 letter")
	private String name;
	
	@Size(min = 6, max = 14, message="pwd must have atleat 6 letter")
	private String pwd;
	
	@Size(min = 2, max = 50, message="Mail Id can not be Empty")
	@Email
	private String mail;
	
	@NotNull
	private Date date;
	
	@Column
	private String ph;
	
	@Column
	private boolean enabled;
	
	@Transient
	private MultipartFile image;
	
	@Column
	private Integer role;

	//implementing getters and setters...
	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPh() {
		return ph;
	}

	public void setPh(String ph) {
		this.ph = ph;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}
}