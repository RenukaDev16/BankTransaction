<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>register</title>
</head>
<body>
<form action="regserve" method="post">
            <center><b>REGISTERATION</b><br><br>
            <table  width="30%" cellpadding="5">
            <tr>
                        <td>Account No</td>
                        <td><input type="text" name="account_no" value="" /></td>
                    </tr>
                    <tr>
                        <td>Name</td>
                        <td><input type="text" name="name" value="" /></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><input type="text" name="email" value="" /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="password" value="" /></td>
                    </tr>
 
                    <tr>
                        <td><input type="submit" value="Register" /></td>
                    </tr>
                    <tr>
                        <td colspan="2">Already user!!<a href="index.jsp">Login Here</a></td>
                   </tr>               
            </table>
            </center>
        </form>
</body>
</html>