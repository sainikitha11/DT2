package com.niit.cart.DAO;

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

import com.niit.cart.model.Category;


@Repository("CategoryDAO")
public  class CategoryDAOImpl implements CategoryDAO
{
	@Autowired
	private SessionFactory sf;

	@Transactional(propagation = Propagation.SUPPORTS)
	public void addCategory(Category c)
	{
		Session s = sf.getCurrentSession();
		Transaction t = s.beginTransaction();
		s.save(c);
		t.commit();
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public List<Category> viewAllCategory() 
	{
		Session s = sf.getCurrentSession();
		Transaction t = s.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Category> l1 = (List<Category>) sf.getCurrentSession().createCriteria(Category.class).list();
		t.commit();
		return l1;
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public void deleteCategory(int cid)
	{
		Session s = sf.getCurrentSession();
		Transaction t = s.beginTransaction();
        Category c1=(Category) s.load(Category.class,cid);
        s.delete(c1);
		t.commit();
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public Category editCategory(int cid)
	{
		Session s = sf.getCurrentSession();
		Transaction t = s.beginTransaction();
		Category c=(Category)s.get(Category.class,cid);
		System.out.println(c.getCid());
		t.commit();
		return c;
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public void updateCategory(Category c)
	{
		Session s = sf.getCurrentSession();
		Transaction t = s.beginTransaction();
		System.out.println(c.getCname());
		System.out.println(c.getCdesc());
		System.out.println(c.getCid());
		s.update(c);
		t.commit();
	}
	@Transactional(propagation = Propagation.SUPPORTS)
	public Category viewCategory(int cid) {
		Session s = sf.getCurrentSession();
		Transaction t = s.beginTransaction();
        Criteria cr=s.createCriteria(Category.class);
        cr.add(Restrictions.eq("cid", cid));
		
		return (Category)cr.uniqueResult();
	}
}
