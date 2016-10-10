package com.niit.cart.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.cart.model.Supplier;
import com.niit.cart.service.ISupplierService;
import com.niit.cart.util.Util;

@Controller
public class SupplierController 
{
	 @Autowired(required=true)
	 ISupplierService iSupplierService;
	 
	 int tsid=0;
	 
	 @RequestMapping(value={"addSupplier"})
	 public ModelAndView addSupplier(@ModelAttribute("cart") Supplier s,BindingResult result)
	 {
		 System.out.println("add supplier");
		 return new ModelAndView("addSupplier","command",new Supplier()).addObject("supplier",iSupplierService.viewAllSuppliers()).addObject("stat","Add Supplier");
	 }
	 
	 @RequestMapping(value={"storesupplier"})
	 public ModelAndView store(HttpServletRequest request,@ModelAttribute("cart") Supplier s,BindingResult result)
	 {
		 System.out.println("store");
		 iSupplierService.addSupplier(s);
		 String name=Util.removeComma(s.getSname());
			s.setSname(name);
			ModelAndView mv=new ModelAndView("addSupplier");
			if(result.hasErrors())
			{
				mv=new ModelAndView("addSupplier", "command", new Supplier()).addObject("addSupplier", iSupplierService.viewAllSuppliers());
						mv.addObject("errors", result.getAllErrors());
						for(ObjectError s1:result.getAllErrors())
						{
							System.out.println(s1);
						}
			}
			return new ModelAndView("addSupplier", "command", new Supplier()).addObject("supplier", iSupplierService.viewAllSuppliers()).addObject("stat","Add Supplier");
		}
	 
	 @RequestMapping(value = { "/Supplier/storesupplier" })
		public ModelAndView updateSupplier(HttpServletRequest request, @ModelAttribute("cart") Supplier s, BindingResult result) 
		{
			System.out.println("Store Supplier");
			//supplier.setSname(s.getSname().substring(s.getSname().lastIndexOf(',')+1));
			s.setSid(tsid);
			iSupplierService.updateSupplier(s);
			return new ModelAndView("addSupplier", "command", new Supplier()).addObject("addSupplier", iSupplierService.viewAllSuppliers());
		}
		
		@RequestMapping(value = { "/Supplier/delete" })
		public ModelAndView delete(HttpServletRequest request)
		{	
			String sid=request.getParameter("s");
			iSupplierService.deleteSupplier(Integer.parseInt(sid));
			System.out.println("Delete Supplier");
			//return "redirect:/addSupplier";
			return new ModelAndView("addSupplier", "command", new Supplier()).addObject("supplier",iSupplierService.viewAllSuppliers());
		}
		
		@RequestMapping(value = { "/Supplier/edit" })
		public ModelAndView edit(HttpServletRequest request) 
		{
			System.out.println("Edit Supplier");
			String sid=request.getParameter("s");
			//supplier=iSupplierService.editSupplier(Integer.parseInt(sid));
			tsid=iSupplierService.editSupplier(Integer.parseInt(sid)).getSid();
			System.out.println(tsid);
			return new ModelAndView("addSupplier", "command", iSupplierService.editSupplier(Integer.parseInt(sid))).addObject("supplier",iSupplierService.viewAllSuppliers()).addObject("stat", "Edit Supplier");
		}
}