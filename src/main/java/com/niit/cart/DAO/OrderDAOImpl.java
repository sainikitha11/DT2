package com.niit.cart.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.niit.cart.model.UserOrder;

@Repository
@Transactional

public class OrderDAOImpl implements OrderDAO
{
	@Autowired
    private SessionFactory sf;
	
	@Transactional(propagation = Propagation.SUPPORTS)
    public void addOrder(UserOrder order) 
    {
    	Session s = sf.getCurrentSession();
        Transaction t=s.beginTransaction();
        System.out.println("addorder");
        s.save(order);
        System.out.println("save order");
        t.commit();
    }
}