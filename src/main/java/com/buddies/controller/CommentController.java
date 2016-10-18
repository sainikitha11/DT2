package com.buddies.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.buddies.model.Comment;
import com.buddies.service.ICommentService;

@Controller
public class CommentController 
{
	@Autowired
	ICommentService iCommentService;
	
	@RequestMapping(value = { "comment" })
	public ModelAndView comment(HttpServletRequest request,@ModelAttribute("buddychat")Comment u,BindingResult result) 
	{
		iCommentService.addComment(u);
		System.out.println("View comment");
		ModelAndView mv= new ModelAndView("comment","command",new Comment());
		return mv;
	}
}
