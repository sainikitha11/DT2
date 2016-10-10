package com.buddies.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buddies.DAO.BlogDAO;
import com.buddies.model.Blog;

@Service
public class BlogService implements IBlogService
{
	@Autowired(required=true)
	private BlogDAO b;
	
	public void addBlog(Blog blog)
	{
		 b.addBlog(blog);
	}

	public List<Blog> viewBlog()
	{
		return b.viewBlog();
	}

	public boolean deleteBlog(int id)
	{
		return b.deleteBlog(id);
	}

	public void updateBlog(Blog blog) 
	{
		b.updateBlog(blog);
	}	
}