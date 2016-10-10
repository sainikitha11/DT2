package com.buddies.service;

import java.util.List;

import com.buddies.model.Forum;

public interface IForumService
{
	public void addQuestion(Forum question);
	public List<Forum> viewForum();
	public boolean deleteQuestion(int id);
	public Forum getQuestion(int id);
}
