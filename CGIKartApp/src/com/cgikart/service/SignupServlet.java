package com.cgikart.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignupServlet
 */
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		//out.println("signup resp");
		
		String id=request.getParameter("id");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		String mobile=request.getParameter("mobile");
		
		
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		
		Connection con=null;
		try
	 	{
	
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			String usernamedb="HR";
			String passworddb="HR";
		
		con=DriverManager.getConnection(url,usernamedb,passworddb);
		
		String query="insert into customerdetails values(?,?,?,?,?,?,?)";
		PreparedStatement ps= con.prepareStatement(query);
		ps.setString(1,id);
		ps.setString(2,username);
		ps.setString(3,password);
		ps.setString(4,name);
		ps.setString(5,mobile);
		ps.setString(6,email);
		ps.setString(7,address);
		int result=ps.executeUpdate();
		if(result>0)			
			out.println("<h1>Sign up completed. You can <a href='index.jsp'>login now</a></h1> ");
		else
			out.println("<h1>Id is already in use.<br>Select different Id</h1> ");		
			
		
	  
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("class");
		}
		catch(SQLException e)
		{
			out.println("sql exception ");				}
		finally
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
