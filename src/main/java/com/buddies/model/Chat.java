package com.buddies.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Chat
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String chatid;
	
	@Size(min = 2, max = 50, message="message")
	private String message;
	
	@Size(min = 2, max = 50, message="from user")
	private String fromUser;
	
	@Size(min = 2, max = 50, message="to user")
	private String toUser;
	
	@NotNull
	private Date date;

	//implementing getters and setters
	public String getChatid() {
		return chatid;
	}
	
	public void setChatid(String chatid) {
		this.chatid = chatid;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getFromUser() {
		return fromUser;
	}

	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}

	public String getToUser() {
		return toUser;
	}

	public void setToUser(String toUser) {
		this.toUser = toUser;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}