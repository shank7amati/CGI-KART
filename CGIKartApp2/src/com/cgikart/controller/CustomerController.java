package com.cgikart.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cgikart.bean.Customer;
import com.cgikart.dao.CustomerDaoImpl;
//import com.cgikart.dao.CustomerDaoImpl;
//import com.cgikart.dao.CustomerDaoInterface;
import com.cgikart.dao.CustomerDaoInterface;

@Controller
public class CustomerController {
	@RequestMapping(value="/login")
	public String loginCustomer(@RequestParam("username") String username,
			@RequestParam("password") String password ,ModelMap model, HttpSession session) 
	{
		
		CustomerDaoInterface dao=new CustomerDaoImpl();
		boolean result=dao.loginCustomer(username, password);
		model.addAttribute("login_error",!result);           
		if(result)
			return "index";
		else
			return "login";
	}


	
	@RequestMapping(value="/createCustomer")
	public String createCustomer(@RequestParam("username") String username,@RequestParam("password") String password ,@RequestParam("name") String name,@RequestParam("mobile") Long mobile, @RequestParam("email") String email, @RequestParam("address") String address,ModelMap model) 
	{
		Customer c=new Customer();
		
		c.setAddress(address);
		c.setEmail(email);
		c.setMobile(mobile);
		c.setName(name);
		c.setPassword(password);
		c.setUsername(username);
		
		CustomerDaoInterface dao=new CustomerDaoImpl();
		int result=dao.createCustomer(c);
		
		model.addAttribute("result",result);
		return "customeradded";  
	}
	
	
	
	@RequestMapping(value="/adminlogin")
	public String adminLogin(@RequestParam("username") String username,@RequestParam("password") String password,ModelMap model)
	{
		//int temp=0;
		if(username.equals("admin")&&password.equals("admin"))
		{
			return "Adminpage";
			 //temp++;
		}
		
		else
     	{
//			String msg2=null;
//			model.addAttribute("invalid username or password", msg2);
			return "index";
			
		}
		//System.out.println(" inside login method");
		//return "customeradded";
	}
}
