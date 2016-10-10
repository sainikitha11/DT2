package com.buddies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buddies.DAO.ChatDAO;
import com.buddies.model.Chat;

@Service
public class ChatService implements IChatService
{
	@Autowired(required=true)
	private ChatDAO c;

	public void createChat(Chat chat)
	{
		c.createChat(chat);
	}
	
}
