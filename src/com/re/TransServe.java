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
 * Servlet implementation class transserve
 */
@WebServlet("/transserve")
public class TransServe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransServe() {
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
		String a=request.getParameter("faccno");
        String b=request.getParameter("laccno");
		String c=request.getParameter("amt");
		int d=Integer.parseInt(a);
		int e=Integer.parseInt(b);
		int f=Integer.parseInt(c);
		 try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","root");
				Statement st=con.createStatement();
				String s="update finals   set amount=amount-f where acc_no =d";
				String s1="update finals   set amount=amount+f where acc_no =e";
				int x=st.executeUpdate(s);
				int y=st.executeUpdate(s1);
				if(x==1&& y==1)
				{
					response.sendRedirect("success.jsp");
				}
				
	            
			}
			catch(Exception ex)
			{
				System.out.println(ex);
			}
		doGet(request, response);
	}

}
