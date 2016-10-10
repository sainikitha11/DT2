package com.buddies.service;

import com.buddies.model.Comment;

public interface ICommentService
{
	public void addComment(Comment comment);
	public boolean deleteComment(int id);
	public void updateComment(Comment comment);
}
