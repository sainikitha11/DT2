package com.buddies.DAO;

import java.util.List;

import com.buddies.model.Chat;


public interface ChatDAO {
	
	public void addChat(Chat chat);
	public List<Chat> viewChat(Integer fromUser,Integer toUser);
 
	
	}
