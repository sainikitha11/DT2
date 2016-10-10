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

import com.buddies.DAO.BlogDAO;
import com.buddies.model.Blog;
import com.buddies.service.IBlogService;

@RestController
public class BlogController
{
	@Autowired 
	IBlogService iBlogService;
	
	@Autowired 
	BlogDAO blogDAO;
	
	private static final Logger logger=LoggerFactory.getLogger(BlogController.class);
	
	//retrive list of blog
	@GetMapping("/blog")
	public ResponseEntity<List<Blog>> viewBlog()
	{
		logger.debug("calling methods for viewing blogs");
		List<Blog> l1=blogDAO.viewBlog();
		if(l1.isEmpty())
		{
			return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Blog>>(HttpStatus.OK);	
	}
	
	//retrive single blog by id
	@GetMapping(value="/blog/{id}")
	public ResponseEntity<List<Blog>> viewBlog(@RequestBody Blog blog)
	{
		logger.debug("call methods one by one");
		blog=(Blog) blogDAO.viewBlog();
		if(blog==null)
		{
			return new ResponseEntity<List<Blog>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Blog>>(HttpStatus.OK);
	}
	
	//creating a new blog
	@PostMapping(value="/blog")
	public ResponseEntity<List<Blog>> addBlog(@RequestBody Blog blog)
	{
		logger.debug("calling mthods after creating");
		blogDAO.addBlog(blog);
		return new ResponseEntity<List<Blog>>(HttpStatus.OK);
	}
	
	//deleting a blog by its id
	@DeleteMapping(value="/blog/{id}")
	public ResponseEntity<List<Blog>> deleteBlog(@RequestBody Blog blog,@PathVariable int id)
	{
		logger.debug("delete a blog");
		blogDAO.deleteBlog(id);
		return new ResponseEntity<List<Blog>>(HttpStatus.OK);
	}
	
	//update a blog
	@PutMapping(value="/blog/{id}")
	public ResponseEntity<List<Blog>> update(@RequestBody Blog blog)
	{
		logger.debug("delete blog");
		blogDAO.updateBlog(blog);
		return new ResponseEntity<List<Blog>>(HttpStatus.OK);
	}
}