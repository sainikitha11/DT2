package com.niit.cart.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.niit.cart.model.Supplier;

@Repository("SupplierDAO")
public class SupplierDAOImpl implements SupplierDAO 
{
	@Autowired
	private SessionFactory sf;
	
   @Transactional(propagation=Propagation.SUPPORTS)
	public void addSupplier(Supplier s)
   {
	   System.out.println("supplier added");
		Session s1=sf.getCurrentSession();
		Transaction t=s1.beginTransaction();
		System.out.println("add sup");
		s1.saveOrUpdate(s);
		t.commit();
	}

   @Transactional(propagation=Propagation.SUPPORTS)
	public List<Supplier> viewAllSuppliers() {
		Session s=sf.getCurrentSession();
		Transaction t=s.beginTransaction();
		System.out.println("view suppliers");
		List<Supplier> l1=(List<Supplier>)sf.getCurrentSession().createCriteria(Supplier.class).list();
		System.out.println("list of suppliers added....");
		t.commit();
		return l1;
	}

   @Transactional(propagation=Propagation.SUPPORTS)
	public void deleteSupplier(int sid) {
		Session s=sf.getCurrentSession();
		Transaction t=s.beginTransaction();
		Supplier s1=(Supplier)s.load(Supplier.class, sid);
		s.delete(s1);
		t.commit();
	}

	public void updateSupplier(Supplier s1) {
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		s.update(s1);
		t.commit();
	}

	public Supplier editSupplier(int sid) {
		Session s=sf.getCurrentSession();
		Transaction t=s.beginTransaction();
		Supplier s1=(Supplier)s.get(Supplier.class, sid);
		t.commit();
		return s1;
	}
}
