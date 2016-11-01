package com.buddies.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buddies.DAO.FriendDAO;
import com.buddies.model.User;
import com.buddies.model.UserFriend;



@Service
public class FriendService implements IFriendService {

	@Autowired(required=true)
	private FriendDAO fn;
	
	public void addFriend(User Uid, Integer fndid) {
		System.out.println(Uid.getName());
		fn.addFriend(Uid, fndid);
		}

	public void updateFriend(int fndid) {
		
		 fn.updateFriend(fndid);
		
	}

	public List<UserFriend> viewAllFriends(User u) {
		
		return fn.viewAllFriends(u);
	}

	public List<UserFriend> viewAllRequest(int fndid) {
		System.out.println("sai");
		return fn.viewAllRequest(fndid);
	}

	public User retriveFriend(int fndid) {
		
		return fn.retriveFriend(fndid);
	}

	

}
