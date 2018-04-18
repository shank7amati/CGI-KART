<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<form action="searchProduct">
		<input type="text" name="prod_name" >
		<input type="submit" value="search">
	</form>
     
    <div align="center">
        <table border="1" cellpadding="5">
            <caption>  
					<h2>List of Products</h2>
			</caption>
            <tr>
				<th>PRODUCT IMAGE</th>
                <th>ID</th>
                <th>Name</th>
                <th>PRICE</th>
				<th>DESCRIPTION</th>
				<th>CATEGORY</th>
				<th>STOCK</th>                
                
               
            </tr>
            <c:forEach items="${prod_list}" var="product" >
                <tr>
					<td><img width=100 height=100 src="${product.path }"/></td>
                    <td><c:out value="${product.prod_id}" /></td>
                    <td><c:out value="${product.prod_name}" /></td>
                    <td><c:out value="${product.prod_price}" /></td>
					<td><c:out value="${product.prod_desc}" /></td>
					<td><c:out value="${product.prod_category}" /></td>
					<td><c:out value="${product.stock}" /></td>                           

				</tr>
            </c:forEach>
        </table>
    </div>

</body>
</html>