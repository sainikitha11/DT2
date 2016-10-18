package com.buddies.DAO;

import java.util.Date;
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

import com.buddies.model.User;
import com.buddies.model.UserRole;


@Repository("UserDAO")
public class UserDAOImpl implements UserDAO
{
	private User u;
	
/*	@Autowired is used to autowire the  bean on setter methods,non-setter methods,constructors and properties*/
/*	If autowired annotation is used on properties, then it is coz of getting rid of setter methods..*/
	@Autowired
	private SessionFactory sf;
	
	User user;
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public void addUser(User user)
	{
		Session s=sf.getCurrentSession();
		Transaction t=s.beginTransaction();
		System.out.println("new user");
		user.setDate(new Date());
		s.saveOrUpdate(user);
		UserRole r=new UserRole();
		System.out.println("userid");
		//r.setUser_role_id(u.getUserid());
		System.out.println("roleuserid");
		r.setAuthority("ROLE_USER");
		s.saveOrUpdate(r);
		t.commit();
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	public User verifyMail(User u)
	{
		Session s=sf.getCurrentSession();
		Transaction t=s.beginTransaction();
		Criteria c=s.createCriteria(User.class);
		System.out.println("user verify");
		c.add(Restrictions.eq("mail",u.getMail()));
		c.add(Restrictions.eq("pwd",u.getPwd()));
		System.out.println("name pwd");
		user=(User) c.uniqueResult();
		System.out.println(user.getName());
		t.commit();
		return user;
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	public List<User> viewUsers() 
	{
		
		Session s=sf.getCurrentSession();
		Transaction t=s.beginTransaction();
		Criteria c=s.createCriteria(User.class);
		List<User> l1=(List<User>)c.list();
		t.commit();
		return l1;
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	public void deactivateUser(int id) 
	{
		Session s=sf.getCurrentSession();
		Transaction t=s.beginTransaction();
		Object o=s.load(User.class, new Integer(id));
		user=(User)o;
		user.setEnabled(false);
		t.commit();
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	public void activateUser(int id) 
	{
		Session s=sf.getCurrentSession();
		Transaction t=s.beginTransaction();
		Object o=s.load(User.class, new Integer(id));
		user=(User)o;
		user.setEnabled(true);
		t.commit();
	}

	public User getUser() {
		return user;
	}
}