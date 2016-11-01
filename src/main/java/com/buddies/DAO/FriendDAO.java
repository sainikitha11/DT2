package com.buddies.DAO;

import java.util.List;

import com.buddies.model.User;
import com.buddies.model.UserFriend;


public interface FriendDAO {
	
	public void addFriend(User Uid,Integer fndid);
	public void updateFriend(int fndid);
	public List<UserFriend> viewAllFriends(User u);
	public List <UserFriend> viewAllRequest(int fndid);
	public User retriveFriend(int fndid);

}
