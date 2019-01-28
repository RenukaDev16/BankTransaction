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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=ISO-8859-1");
		PrintWriter pw=response.getWriter();
		String a=request.getParameter("email");
		String b=request.getParameter("password");
		//final String secretKey="hjllij";
	//	String enpass=AES.encrypt(b, secretKey);
	 
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","root");
			Statement st=con.createStatement();
			String s="select email ,password from customers where email='"+a+"' AND password='"+b+"'"; 
			ResultSet rs=st.executeQuery(s);
			 if(rs.next())
			 {
				 response.sendRedirect("home.jsp");
			 }
			 else
			 {
				 System.out.print("Sorry wrong email or password");
				RequestDispatcher  rd=request.getRequestDispatcher("index.jsp");
			  rd.include(request, response);
			 }
			con.close();
			
		}
 catch(Exception e)
		{
	 System.out.print("connection failed");
	 System.out.print(e);
		}
		doGet(request, response);
	}

}
