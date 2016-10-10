package com.buddies.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.buddies.DAO.ChatDAO;
import com.buddies.model.Chat;
import com.buddies.service.IChatService;

@RestController
public class ChatController 
{
	@Autowired
	IChatService iChatService;
	
	@Autowired 
	ChatDAO chatDAO;
	
	private static final Logger logger=LoggerFactory.getLogger(ChatController.class);
	
	//creating a new chat
	@PostMapping(value="/chat")
	public ResponseEntity<List<Chat>> addComment(@RequestBody Chat chat)
	{
		logger.debug("calling mthods after creating");
		iChatService.createChat(chat);
		//chatDAO.createChat(chat);
		return new ResponseEntity<List<Chat>>(HttpStatus.OK);
	}
}
