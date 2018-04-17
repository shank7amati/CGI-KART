package com.cgikart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cgikart.bean.Product;
import com.cgikart.dao.ProductDaoImpl;
//import com.cgikart.dao.CustomerDaoImpl;
//import com.cgikart.dao.CustomerDaoInterface;
import com.cgikart.dao.ProductDaoInterface;

@Controller
public class ProductController {


	
	@RequestMapping(value="/createProduct")
	public String createCustomer(@RequestParam("prod_name") String prod_name,@RequestParam("prod_price") int prod_price ,@RequestParam("prod_desc") String prod_desc,@RequestParam("prod_category") String prod_category, @RequestParam("stock") int stock,@RequestParam("path") String path,ModelMap model) 
	{
		Product p=new Product();
		
		p.setProd_name(prod_name);
		p.setProd_price(prod_price);
		p.setProd_desc(prod_desc);
		p.setProd_category(prod_category);
		p.setStock(stock);
		p.setPath(path);
		
		ProductDaoInterface dao=new ProductDaoImpl();
		int result=dao.createProduct(p);
		
		model.addAttribute("result",result);
		return "productadded";  
	}
	
	
//	
//	@RequestMapping(value="/adminlogin")
//	public String adminLogin(@RequestParam("username") String username,@RequestParam("password") String password,ModelMap model)
//	{
//		if(username.equals("admin")&&password.equals("admin"))
//		{
//			return "Adminpage";
//			 //temp++;
//		}
//		
//		else
//     	{
////			String msg2=null;
////			model.addAttribute("invalid username or password", msg2);
//			return "index";
//			
//		}
//		//System.out.println(" inside login method");
//		//return "customeradded";
//	}
}
