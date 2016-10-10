package com.buddies.DAO;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.buddies.model.Comment;

@Repository("CommentDAO")
public class CommentDAOImpl implements CommentDAO
{
	private Comment c;
	
	@Autowired(required=true)
	private SessionFactory sf;

	@Transactional(propagation=Propagation.SUPPORTS)
	public void addComment(Comment comment)
	{
		Session s=sf.getCurrentSession();
		Transaction t=s.beginTransaction();
		System.out.println("add comment");
		comment.setDate(new Date());
		s.saveOrUpdate(comment);
		t.commit();
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	public boolean deleteComment(int id)
	{
		Session s=sf.getCurrentSession();
		Transaction t=s.beginTransaction();
		System.out.println("delete comment");
		Comment c1=(Comment)s.load(Comment.class, id);
		s.delete(c1);
		t.commit();
		if(c1!=null)
			return true;
		else 
			return false;
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	public void updateComment(Comment comment) 
	{
		Session s=sf.getCurrentSession();
		Transaction t=s.beginTransaction();
		System.out.println("update comment");
		s.update(comment);
		t.commit();
	}
}
