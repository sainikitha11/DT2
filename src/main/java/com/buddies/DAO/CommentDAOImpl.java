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
}
