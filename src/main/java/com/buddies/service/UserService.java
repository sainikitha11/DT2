package com.buddies.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buddies.DAO.UserDAO;
import com.buddies.model.User;

@Service
public class UserService implements IUserService 
{
	@Autowired(required=true)
	private UserDAO ud; 
	
	public void addUser(User user) 
	{
		ud.addUser(user);		
	}

	public User verifyMail(User u) 
	{
		return ud.verifyMail(u);
	}

	public List<User> viewUsers() 
	{
		return ud.viewUsers();
	}

	public void deactivateUser(int id)
	{
		ud.deactivateUser(id);
	}

	public void activateUser(int id)
	{
		ud.activateUser(id);
	}

	public User getUser() {
		return ud.getUser();
	}
}