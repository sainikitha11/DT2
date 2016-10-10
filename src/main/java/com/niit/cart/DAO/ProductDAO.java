package com.niit.cart.DAO;

import java.util.List;

import com.niit.cart.model.Category;
import com.niit.cart.model.Product;
import com.niit.cart.model.Supplier;

public interface ProductDAO 
{
	void addProduct(Product p);
	public List<Product> viewAllProducts(Category c);
	public List<Product> viewAllProducts(Supplier s);
	public List<Product> viewAllProducts();
	public void deleteProduct(int pid);
	public Product editProduct(int pid);
	public void updateProduct(Product p);
	Product cart(int pid);
}
	
