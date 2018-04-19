package com.cgikart.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	public String createProduct(@RequestParam("prod_name") String prod_name,@RequestParam("prod_price") int prod_price ,@RequestParam("prod_desc") String prod_desc,@RequestParam("prod_category") String prod_category, @RequestParam("stock") int stock,@RequestParam("path") String path,ModelMap model) 
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
		return "redirect:/viewAllProduct";  
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
	
	@RequestMapping(value="/viewProduct")

	public String viewProduct(@RequestParam("prod_category") String prod_category,ModelMap model)

	{
		ProductDaoInterface dao=new ProductDaoImpl();
		List <Product>l=dao.getProductByCategory(prod_category);
		model.addAttribute("prod_list",l);
		
		return "vprod";
	}
	@RequestMapping(value="/viewAllProduct")

	public String viewAllProduct(ModelMap model,HttpServletRequest request)

	{
		ProductDaoInterface dao=new ProductDaoImpl();
		List <Product>l=dao.getAllProduct();
		model.addAttribute("prod_list",l);
		HttpSession session= request.getSession();
		String role=(String) session.getAttribute("role");
		model.addAttribute("role",role);
		System.out.println(role);
		return "vprod";
	}


	@RequestMapping(value="/searchProduct")
	public String searchProduct(@RequestParam("prod_name") String prod_name,ModelMap model)
	{
		ProductDaoInterface dao=new ProductDaoImpl();
		Product prd=dao.searchProductByName(prod_name);
				
		model.addAttribute("product",prd);
		
		return "product_details";
	}
	
	@RequestMapping(value="/deleteProduct")
	public String deleteProduct(@RequestParam("prod_id") String prod_id,ModelMap model)
	{
		ProductDaoInterface dao=new ProductDaoImpl();
		int result=dao.deleteProductById(Integer.parseInt(prod_id));
		model.addAttribute("result_delete",result);
		return "redirect:/viewAllProduct";
	}
	@RequestMapping(value="/searchProductById")
	public String searchProductById(@RequestParam("prod_id") String prod_id,ModelMap model)
	{
		ProductDaoInterface dao=new ProductDaoImpl();
		Product prd=dao.searchProductById(Integer.parseInt(prod_id));
		model.addAttribute("product",prd);
		
		return "updateproduct";
	}

	@RequestMapping(value="/updateProduct")
	public String updateProduct(@RequestParam("prod_id") int prod_id ,@RequestParam("prod_name") String prod_name,
			@RequestParam("prod_price") int prod_price ,@RequestParam("prod_desc") String prod_desc,
			@RequestParam("prod_category") String prod_category,
			@RequestParam("stock") int stock,@RequestParam("path") String path,
			ModelMap model, HttpServletRequest request) 
	{
		
		Product p=new Product();
		p.setProd_id(prod_id);
		p.setProd_name(prod_name);
		p.setProd_price(prod_price);
		p.setProd_desc(prod_desc);
		p.setProd_category(prod_category);
		p.setStock(stock);
		p.setPath(path);
		
		ProductDaoInterface dao=new ProductDaoImpl();
		int result=dao.updateProductById(p);
		model.addAttribute("result_update",result);
		return "redirect:/viewAllProduct";
	}


}

	
