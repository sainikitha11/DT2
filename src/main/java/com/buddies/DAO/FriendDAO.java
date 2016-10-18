package com.buddies.DAO;

import java.util.List;

import com.buddies.model.User;
import com.buddies.model.UserFriend;

public interface FriendDAO
{
	public void addFriend(User uid, int frdid);
	public void updateStatus(UserFriend uf);
	public List<UserFriend> viewAllFriends();
	public List<UserFriend> viewAllRequest(int fndid);
	public User retriveFriend(int frdid);
}
