package com.cgikart.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cgikart.bean.Customer;
import com.cgikart.bean.Order;
import com.cgikart.bean.Product;
import com.cgikart.util.HibernateUtil;

public class OrderDaoImpl implements OrderDaoInterface{
	

	@Override
	public Order checkoutCart(ArrayList<Integer> prod_ids, int cust_id) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<Product> prodList=null;
		Order order=null;
		try {
			transaction = session.beginTransaction();
			String hql = "FROM Product  WHERE prod_id IN :prod_ids";
			Query query = session.createQuery(hql);  
			query.setParameter("cust_id", cust_id);
			query.setParameter("prod_ids", prod_ids);

			prodList=(List<Product>) query.getResultList();
			order.setCust_id(cust_id);
			order.setProduct(prod_ids);
			int sum=0;
			for(Product prd:prodList){
				sum=prd.getProd_price()+sum;
			}
			order.setTotalCost(sum);
			session.save(order);
		
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return order;
	}

	
	


}
