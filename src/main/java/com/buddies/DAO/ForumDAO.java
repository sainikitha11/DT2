package com.buddies.DAO;

import java.util.List;

import com.buddies.model.Forum;

public interface ForumDAO 
{
	public void addQuestion(Forum question);
	public List<Forum> viewForum();
	public boolean deleteQuestion(int id);
	public Forum getQuestion(int id);
}
