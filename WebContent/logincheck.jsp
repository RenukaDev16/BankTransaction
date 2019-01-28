<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*"%>
  <%@page import="com.re.AES" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String a=request.getParameter("email");
String b=request.getParameter("password");
final String secretKey="hjllij";
String enpass=AES.encrypt(b, secretKey);
try
{
	Class.forName("com.mysql.jdbc.Driver");
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root", "admin");
	Statement st=con.createStatement();
	String s="select email ,password from customers where email='"+a+"' AND password='"+enpass+"'"; 
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
System.out.print(e);
}

%>

</body>
</html>