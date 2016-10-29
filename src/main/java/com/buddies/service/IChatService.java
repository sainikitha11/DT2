package com.buddies.service;

import java.util.List;

import com.buddies.model.Chat;


public interface IChatService {

	public void addChat(Chat chat);
	public List<Chat> viewChat(Integer fromUser,Integer toUser);
}
