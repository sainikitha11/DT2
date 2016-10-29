package com.buddies.service;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buddies.DAO.MailDAO;
import com.buddies.model.User;

@Service
public class MailService implements IMailService
{

	@Autowired(required=true)
	MailDAO md;
	
	public void send(User user, String subject, String body)throws MessagingException {
		md.send(user, subject, body);
	}

}
