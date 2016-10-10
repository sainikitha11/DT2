package com.buddies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buddies.DAO.CommentDAO;
import com.buddies.model.Comment;

@Service
public class CommentService implements ICommentService
{
	@Autowired(required=true)
	private CommentDAO cd;

	public void addComment(Comment comment) 
	{
		cd.addComment(comment);
	}

	public boolean deleteComment(int id)
	{
		return cd.deleteComment(id);
	}

	public void updateComment(Comment comment)
	{
		cd.updateComment(comment);
	}
}
