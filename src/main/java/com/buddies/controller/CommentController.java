package com.buddies.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.buddies.DAO.CommentDAO;
import com.buddies.model.Comment;
import com.buddies.service.ICommentService;

@RestController
public class CommentController
{
	@Autowired
	ICommentService iCommentService;
	
	@Autowired 
	CommentDAO commentDAO;
	
	private static final Logger logger=LoggerFactory.getLogger(CommentController.class);
	
	//creating a new comment
	@PostMapping(value="/comment")
	public ResponseEntity<List<Comment>> addComment(@RequestBody Comment comment)
	{
		logger.debug("calling mthods after creating");
		commentDAO.addComment(comment);
		return new ResponseEntity<List<Comment>>(HttpStatus.OK);
	}
		
	//deleting a comment by its id
	@DeleteMapping(value="/comment/{id}")
	public ResponseEntity<List<Comment>> deleteEvent(@RequestBody Comment comment,@PathVariable int id)
	{
		logger.debug("delete comment");
		commentDAO.deleteComment(id);
		return new ResponseEntity<List<Comment>>(HttpStatus.OK);
	}
		
	//update comment
	@PutMapping(value="/comment/{id}")
	public ResponseEntity<List<Comment>> update(@RequestBody Comment comment)
	{
		logger.debug("update comment");
		commentDAO.updateComment(comment);
		return new ResponseEntity<List<Comment>>(HttpStatus.OK);
	}
}
