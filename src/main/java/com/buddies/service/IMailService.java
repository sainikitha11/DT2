package com.buddies.service;

import javax.mail.MessagingException;

import com.buddies.model.User;

public interface IMailService {

	public void send(User user,String subject,String body)throws MessagingException;

}
