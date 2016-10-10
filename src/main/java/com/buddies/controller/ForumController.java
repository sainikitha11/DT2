package com.buddies.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.buddies.DAO.ForumDAO;
import com.buddies.model.Forum;
import com.buddies.service.IForumService;

@RestController
public class ForumController
{
	@Autowired
	IForumService iForumService;
	
	@Autowired 
	ForumDAO forumDAO;
	
private static final Logger logger=LoggerFactory.getLogger(ForumController.class);
	
	//retrive list of forum
	@GetMapping("/forum")
	public ResponseEntity<List<Forum>> view()
	{
		logger.debug("calling methods for viewing blogs");
		List<Forum> l1=forumDAO.viewForum();
		if(l1.isEmpty())
		{
			return new ResponseEntity<List<Forum>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Forum>>(HttpStatus.OK);	
	}
	
	//retrive single forum by id
	@GetMapping(value="/forum/{id}")
	public ResponseEntity<List<Forum>> view(@RequestBody Forum forum,@PathVariable int id)
	{
		logger.debug("call methods one by one");
		forum= forumDAO.getQuestion(id);
		if(forum==null)
		{
			return new ResponseEntity<List<Forum>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Forum>>(HttpStatus.OK);
	}
	
	//creating a new forum
	@PostMapping(value="/forum")
	public ResponseEntity<List<Forum>> addForum(@RequestBody Forum forum,@PathVariable Forum question)
	{
		logger.debug("calling mthods after creating");
		int id = 0;
		if(forumDAO.getQuestion(id)==null)
		{
			return new ResponseEntity<List<Forum>>(HttpStatus.NO_CONTENT);
		}
		forumDAO.addQuestion(question);
		return new ResponseEntity<List<Forum>>(HttpStatus.OK);
	}
	
	//deleting a forum by its id
	@DeleteMapping(value="/forum/{id}")
	public ResponseEntity<List<Forum>> deleteBlog(@RequestBody Forum forum,@PathVariable int id)
	{
		logger.debug("delete a blog");
		if(forumDAO.getQuestion(id)==null)
		{
			return new ResponseEntity<List<Forum>>(HttpStatus.NO_CONTENT);
		}
		forumDAO.deleteQuestion(id);
		return new ResponseEntity<List<Forum>>(HttpStatus.OK);
	}
	
	/*//update a forum
	@PutMapping(value="/forum/{id}")
	public ResponseEntity<List<Forum>> update(@RequestBody Forum forum)
	{
		logger.debug("update blog");
		forumDAO.
		return new ResponseEntity<List<Blog>>(HttpStatus.OK);
	}*/
}

