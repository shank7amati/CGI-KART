<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Product Name: ${product.prod_name}</h3>
<img width=100 height=100 src="${product.path }"/>
<h3>Price</h3>${product.prod_price}
<h3>Description</h3>${product.prod_desc}
<h3>Category</h3>${product.prod_category}
</body>
</html>