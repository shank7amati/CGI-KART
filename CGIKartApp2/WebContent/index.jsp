<body>

<jsp:include page="header.jsp"></jsp:include>

<table cellspacing=100>
<tr>
<td align=left>
<h2> Login </h2>
<form method="post" name="login" action="LoginServlet"  onsubmit="return(validate());">

	<table  cell>
		<tr>
			<td>Enter Username: </td>
			<td><input type="text" name="username"/></td>
		</tr>
		<tr>
			<td>Enter Password:</td>
			<td> <input type="password" name="password"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="Login"/></td>
		</tr>	

</table>
</form>
</td>

<td align=right>
<h2>Admin Login </h2>
<form method="post" name="adminlogin" action="adminlogin" >

<table>
		<tr>
			<td>Enter Username: </td>
			<td><input type="text" name="username"/></td>
		</tr>
		<tr>
			<td>Enter Password:</td>
			<td> <input type="password" name="password"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="Login"/></td>
		</tr>	
		
		<font color=red>${msg2}</font>

</table>
</form>
</td>
</tr>
</table>

<form action="Signup.jsp">
<input type="submit" value="Register"/>
</form>
<font color=red>${msg}</font>
</body>
<script type="text/javascript">

function validate()
{
	if(document.login.username.value=="")
		{
		alert("Please provide a valid Username...");
		document.myform.name.focus();
		return false;
		}
    return( true );
	
	}

</script>


<!--  <a href="create"> create </a>-->


<%//@page import="com.cgikart.bean.*, com.cgikart.dao.*" %>
<%

/*


Customer c=new Customer();
	c.setAddress("Bangalre");
	c.setEmail("hello@gmail.com");
	c.setMobile(93939393993L);
	c.setName("mohan");
	c.setPassword("secret");
	c.setUsername("heljlonaffmhhjjke1");
	
	CustomerDaoInterface dao=new CustomerDaoImpl();
	out.println(dao.createCustomer(c));
	*/
	%>
	
	
	
	<img src="home.jpg" height= 300 width=300 alt="image is not able to display"/>
	
	<a href="bishal.jsp"> bishal</a>