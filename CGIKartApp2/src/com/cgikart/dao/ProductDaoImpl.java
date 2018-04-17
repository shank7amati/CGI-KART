package com.cgikart.dao;
import com.cgikart.util.*;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import com.cgikart.bean.*;

public class ProductDaoImpl implements ProductDaoInterface {

	@Override
	public int createProduct(Product p) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		int id = 0;
		try {
			transaction = session.beginTransaction();
			
			id = (int) session.save(p);
			transaction.commit();
			
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return id;
		}
	
	
	
	public List<Product>  getProductByCategory(String category)
	{
		
		
		
		
		
		
		
	}
	

}
