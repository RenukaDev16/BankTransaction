package com.re;
import java.sql.*;
import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class regserve
 */
@WebServlet("/regserve")
public class RegServe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
		response.setContentType("text/html; charset=ISO-8859-1");
		PrintWriter pw=response.getWriter();
		String a=request.getParameter("account_no");
		String b=request.getParameter("name");
		String c=request.getParameter("email");
		String d=request.getParameter("password");
		String key="hello";
		String enpass=AES.encrypt(d,key);
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","root");
			Statement st=con.createStatement();
			String s="insert into customers(account_no,name,email,password)values('"+a+"','"+b+"','"+c+"','"+enpass+"')";
		int x=st.executeUpdate(s);
		if(x==1)
		{
			response.sendRedirect("index.jsp");
		}
			
		else
		{
			response.sendRedirect("reg.jsp");
		}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		doGet(request, response);
	}

}
