package com.re;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DepServe
 */
@WebServlet("/DepServe")
public class DepServe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepServe() {
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
	
		response.setContentType("text/html; charset=ISO-8859-1");
		PrintWriter pw=response.getWriter();
	 String a=request.getParameter("acc_no");
	 String b="d";
	 String c=request.getParameter("deposit");
	 try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","root");
			Statement st=con.createStatement();
			String s="insert into transactions(acc_no,type,amount)values('"+a+"','"+b+"','"+c+"')";
			int x=st.executeUpdate(s);
			if(x==1){
				response.sendRedirect("success.jsp");
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		doGet(request, response);
	}

}
