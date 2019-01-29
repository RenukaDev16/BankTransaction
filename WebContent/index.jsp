<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login</title>
</head>
<body>
<center>LOGIN</center><br><br>
<form action="<%= request.getContextPath() %>/logserve" method="post">  <%--getcontext is to get applicton and append to URI --%>
            <center>
            <table  width="30%" cellpadding="7">
                    <tr>
                        <td>Email</td>
                        <td><input type="text" name="email"  /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="password" /></td>
                    </tr>
                    <tr>
                    <td><input type="submit" value="Login"></td>
                    </tr>   <tr>
                        <td colspan="2">Yet Not Registered!! <a href="reg.jsp">Register Here</a></td>
                    </tr>              
            </table>
            </center>
 
        </form>
</body>
</html>
