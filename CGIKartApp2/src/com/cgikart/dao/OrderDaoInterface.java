package com.cgikart.dao;

import java.util.ArrayList;
import java.util.List;

import com.cgikart.bean.Order;
import com.cgikart.bean.Product;

public interface OrderDaoInterface {


	public Order checkoutCart(ArrayList<Integer> cart_prd_ids, int attribute);
	
}
