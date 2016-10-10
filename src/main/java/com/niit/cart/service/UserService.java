package com.niit.cart.service;

import com.niit.cart.DAO.UserDAO;
import com.niit.cart.model.User;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserService implements IUserService 
{
	@Autowired(required=true)
	private UserDAO cd;
	
	public void addUser(User u) 
	{
		cd.addUser(u);
	}
	
	public User verify(User u)
	{
		User user=cd.verify(u);
		System.out.println(user.getFirstname());
		return user;
	}
	
	public User getUser() 
	{
		return cd.getUser();
	}

	public Object setUser(Object object) 
	{
		return null;
	}

	public void deleteUser(int uid) {
		cd.deleteUser(uid);
	}

	public User editUser(int uid) {
		return cd.editUser(uid);
	}
}
