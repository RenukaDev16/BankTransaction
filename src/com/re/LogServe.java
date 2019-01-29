package com.re;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class logserve
 */
@WebServlet("/logserve")
public class LogServe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogServe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("served at get");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id="";
		response.setContentType("text/html; charset=ISO-8859-1");
		PrintWriter pw=response.getWriter();
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String key="hello";
		String enpass=AES.encrypt(password,key);
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","root");
			Statement st=con.createStatement();
			String s="select email,password from customers where email='"+email+"' and password='"+enpass+"'";
			ResultSet rs=st.executeQuery(s);
			if(rs.next())
			{
				HttpSession session=request.getSession();
				session.setAttribute("user", email);
				response.sendRedirect("home.jsp");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	 
		doGet(request, response);
	}
	

}

