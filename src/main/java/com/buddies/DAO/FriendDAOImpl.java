package com.buddies.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.buddies.model.Friend;
import com.buddies.model.User;
import com.buddies.model.UserFriend;

@Repository("FriendDAO")
public class FriendDAOImpl implements FriendDAO 
{
	private Friend frd;
	
	@Autowired(required=true)
	private SessionFactory sf;
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public void addFriend(User uid, int frdid) 
	{
		System.out.println("ds");
		Session s=sf.getCurrentSession();
		Transaction t=s.beginTransaction();
		System.out.println("friend add");
		UserFriend uf=new UserFriend();
		System.out.println("user friend");
		uf.setStatus("Requested");
		System.out.println("request accepted");
		Friend f1=new Friend();
		System.out.println("gvh");
		f1.setUser(uid);
		System.out.println("set user");
		f1.setFrdid(frdid);
		System.out.println("set friend "+f1.getFrdid());
		uf.setFriend(f1);
		System.out.println("cushybc "+uf);
		s.save(uf);
		t.commit();
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	public void updateStatus(UserFriend uf)
	{
		Session s=sf.getCurrentSession();
		Transaction t=s.beginTransaction();
		System.out.println("status of friend");
		s.update(uf);
		t.commit();
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	public List<UserFriend> viewAllFriends() {
		Session s=sf.getCurrentSession();
		Transaction t=s.beginTransaction();
		Criteria c=sf.getCurrentSession().createCriteria(UserFriend.class);
		List<UserFriend> f=(List<UserFriend>)c.list();
		t.commit();
		return f;
	}
		
	@Transactional(propagation=Propagation.SUPPORTS)
	public List<UserFriend> viewAllRequest(int fndid) {
		Session s=sf.getCurrentSession();
		Transaction t=s.beginTransaction();
		System.out.println("sai");
		Criteria c=sf.getCurrentSession().createCriteria(UserFriend.class);
		List<UserFriend> f=(List<UserFriend>)c.list();
		t.commit();
		return f;
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	public User retriveFriend(int frdid) {
		Session s=sf.getCurrentSession();
		Transaction t=s.beginTransaction();
		System.out.println("friend retrived");
		Criteria c=sf.getCurrentSession().createCriteria(User.class);
		c.add(Restrictions.eq("userid", frdid));
		User u=(User)c.uniqueResult();
		t.commit();
		return u;
	}

}