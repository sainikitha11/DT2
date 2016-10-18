package com.buddies.service;

import java.util.List;

import com.buddies.model.User;
import com.buddies.model.UserFriend;

public interface IFriendService
{
	public void addFriend(User uid,int frdid);
	public void updateStatus(UserFriend uf);
	public List<UserFriend> viewAllFriends();
	public List<UserFriend> viewAllRequest(int fndid);
	public void retriveFriend(int frdid);
}