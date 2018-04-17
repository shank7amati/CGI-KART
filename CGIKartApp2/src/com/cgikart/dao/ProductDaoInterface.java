package com.cgikart.dao;
import java.util.List;

import com.cgikart.bean.*;
public interface ProductDaoInterface {
public int createProduct(Product p);


public List<Product>  getProductByCategory(String category);

public Product searchProductByName(String prod_name);
}
