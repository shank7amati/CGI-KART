package com.cgikart.dao;

import com.cgikart.bean.Customer;

public class TestMain {
public static void main(String[] args) {
	
	Customer c=new Customer();
	c.setAddress("Bangalre");
	c.setEmail("hello@gmail.com");
	c.setMobile(93939393993L);
	c.setName("mohan");
	c.setPassword("secret");
	c.setUsername("heljlonamke1");
	
	CustomerDaoInterface dao=new CustomerDaoImpl();
	dao.createCustomer(c);
}
}
