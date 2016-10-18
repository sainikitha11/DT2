package com.buddies.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class Friend implements Serializable
{
	private Integer frdid;
	
	@ManyToOne
	private User user;

	public Integer getFrdid() {
		return frdid;
	}

	public void setFrdid(Integer frdid) {
		this.frdid = frdid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}