package com.niit.cart.service;

import java.util.List;

import com.niit.cart.model.Category;
import com.niit.cart.model.Product;
import com.niit.cart.model.Supplier;

public interface IProductService
{
	void addProduct(Product p);
	public List<Product> viewAllProducts(Category c);
	public List<Product> viewAllProducts(Supplier s);
	public List<Product> viewAllProducts();
	public void deleteProduct(int pid);
	public Product editProduct(int pid);
	public void updateProduct(Product p);
	public Product cart(int pid);
}
