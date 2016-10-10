package com.niit.cart.service;

import java.util.List;

import com.niit.cart.model.Supplier;

public interface ISupplierService 
{
	public void addSupplier(Supplier s);
	public List<Supplier> viewAllSuppliers();
	public void deleteSupplier(int sid);
	public void updateSupplier(Supplier s);
	public Supplier editSupplier(int sid);
}
