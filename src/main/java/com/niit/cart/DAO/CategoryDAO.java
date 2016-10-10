package com.niit.cart.DAO;

import java.util.List;

import com.niit.cart.model.Category;

public interface CategoryDAO 
{
	void addCategory(Category c);
	public List<Category> viewAllCategory();
	public Category viewCategory(int cid);
	public void deleteCategory(int cid);
	public Category editCategory(int cid);
	public void updateCategory(Category c);
	
}
