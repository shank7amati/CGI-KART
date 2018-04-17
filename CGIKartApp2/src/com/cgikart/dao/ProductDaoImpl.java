package com.cgikart.dao;
import com.cgikart.util.*;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import com.cgikart.util.HibernateUtil;
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
		
		
//		// select * from Product where category=?
//		String hql = "FROM Employee E WHERE E.id = 10";
//		Query query = session.createQuery(hql);
//		List results = query.list();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
			transaction = session.beginTransaction();
			String hql = "FROM Product  WHERE prod_category =:cat";
			Query query = session.createQuery(hql);
			query.setParameter("cat", category);//    setParameter("cat", category);   
			
		List<Product> results=query.getResultList();
		return results;
		
	}
	

}
