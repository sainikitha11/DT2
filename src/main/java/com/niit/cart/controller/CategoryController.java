package com.niit.cart.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.cart.model.Category;
import com.niit.cart.service.ICategoryService;
import com.niit.cart.util.Util;

@Controller
public class CategoryController 
{
	@Autowired(required=true)
	ICategoryService iCategoryService;
	
	int tcid=0;

	@RequestMapping(value = { "/addcategory" })
	public ModelAndView addCategory( @ModelAttribute("cart") Category c,BindingResult result) 
	{
		System.out.println("add Category");
		return new ModelAndView("addcategory", "command", new Category()).addObject("category",iCategoryService.viewAllCategory()).addObject("stat", "Update Category");
	}			
	
	@RequestMapping(value = { "storecategory" })
	public ModelAndView storeCategory(HttpServletRequest request, @ModelAttribute("cart") Category c, BindingResult result)
	{
		System.out.println("Store Category");
		iCategoryService.addCategory(c);
		String name=Util.removeComma(c.getCname());
		c.setCname(name);
		ModelAndView mv=new ModelAndView("addcategory");
		if(result.hasErrors())
		{
			mv=new ModelAndView("addcategory", "command", new Category()).addObject("category", iCategoryService.viewAllCategory());
					mv.addObject("errors", result.getAllErrors());
					for(ObjectError s:result.getAllErrors())
					{
						System.out.println(s);
					}
		}
		return new ModelAndView("addcategory", "command", new Category()).addObject("category", iCategoryService.viewAllCategory()).addObject("stat", "Update Category");
	}
	
	@RequestMapping(value = { "/Category/storecategory" })
	public ModelAndView updateCategory(HttpServletRequest request, @ModelAttribute("cart") Category c, BindingResult result) 
	{
		System.out.println("Store Category");
		c.setCid(tcid);
		iCategoryService.updateCategory(c);
		return new ModelAndView("addcategory", "command", new Category()).addObject("addcategory", iCategoryService.viewAllCategory());
	}
	
	@RequestMapping(value = { "Category/delete" })
	public String delete(HttpServletRequest request)
	{	
		String cid=request.getParameter("c");
		iCategoryService.deleteCategory(Integer.parseInt(cid));
		System.out.println("Delete Category");
		return "redirect:/addcategory";
/*		return new ModelAndView("addcategory", "command", new Category()).addObject("category",iCategoryService.viewAllCategory());*/
	}
	
	@RequestMapping(value = { "/Category/edit" })
	public ModelAndView edit(HttpServletRequest request) 
	{
		System.out.println("Edit Category");
		String cid=request.getParameter("c");
		tcid=iCategoryService.editCategory(Integer.parseInt(cid)).getCid();
		System.out.println(tcid);
		return new ModelAndView("addcategory", "command", iCategoryService.editCategory(Integer.parseInt(cid))).addObject("category",iCategoryService.viewAllCategory()).addObject("stat", "Edit Product");
	}
}