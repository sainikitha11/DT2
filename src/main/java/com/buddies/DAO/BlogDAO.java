package com.buddies.DAO;

import java.util.List;

import com.buddies.model.Blog;

public interface BlogDAO 
{
	public void addBlog(Blog blog);
	public List<Blog> viewBlog();
	public boolean deleteBlog(int id);
	public void updateBlog(Blog blog);
}
