package com.buddies.DAO;

import com.buddies.model.Comment;

public interface CommentDAO 
{
	public void addComment(Comment comment);
	public boolean deleteComment(int id);
	public void updateComment(Comment comment);
}
