<body>

<jsp:include page="header.jsp"></jsp:include>
<h2> Login </h2>

<form method="post" name="login" action="LoginServlet"  onsubmit="return(validate());">
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

</table>
</form>
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