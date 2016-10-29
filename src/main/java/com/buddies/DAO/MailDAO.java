package com.buddies.DAO;

import javax.mail.MessagingException;

import com.buddies.model.User;


public interface MailDAO 
{
	public void send(User user,String subject,String body)throws MessagingException;
}
