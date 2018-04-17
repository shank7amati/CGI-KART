package com.cgikart.dao;
import com.cgikart.util.*;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import com.cgikart.bean.Customer;
import com.cgikart.bean.Product;

public class CustomerDaoImpl implements CustomerDaoInterface {

	@Override
	public int createCustomer(Customer c) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		int id = 0;
		try {
			transaction = session.beginTransaction();
			
			id = (int) session.save(c);
			transaction.commit();
			
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		
		
		
		return id;
		}

	

}
