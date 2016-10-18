package com.buddies.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buddies.DAO.FriendDAO;
import com.buddies.model.User;
import com.buddies.model.UserFriend;

@Service
public class FriendService implements IFriendService
{
	@Autowired(required=true)
	private FriendDAO frd;
	
	public void addFriend(User uid, int frdid) {
		frd.addFriend(uid, frdid);
	}

	public void updateStatus(UserFriend uf) {
		frd.updateStatus(uf);
	}

	public List<UserFriend> viewAllFriends() {
		return frd.viewAllFriends();
	}

	public List<UserFriend> viewAllRequest(int fndid) {
		return frd.viewAllRequest(fndid);
	}

	public User retriveFriend(int frdid) {
		return frd.retriveFriend(frdid);		
	}
}