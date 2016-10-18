package com.buddies.service;

import java.util.List;

import com.buddies.model.User;

public interface IUserService
{
	public void addUser(User user);
	public User verifyMail(User u);
	public List<User> viewUsers();
	public void deactivateUser(int id);
	public void activateUser(int id);
	public User getUser();
}
