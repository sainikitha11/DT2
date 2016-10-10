package com.niit.cart.DAO;

import com.niit.cart.model.User;

public interface UserDAO
{
	public void addUser(User u);
	public User verify(User u);
	public User getUser();
	Object setUser(Object object);
	public void deleteUser(int uid);
	public User editUser(int uid);
}
