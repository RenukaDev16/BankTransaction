<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="transserve" method="post">
 <center> Transfer Transaction</centre>
            <table  width="30%" cellpadding="7">
                    <tr>
                        <td>From Accno</td>
                        <td><input type="text" name="faccno"  /></td>
                    </tr>
                    <tr>
                        <td>To Accno</td>
                        <td><input type="text" name="laccno" /></td>
                    </tr>
                    <tr>
                    <tr>
                        <td>Amount</td>
                        <td><input type="text" name="amt" /></td>
                    </tr>
                    <tr>
                    <td><input type="submit" value="Transfer"></td>
                    </tr>            
            </table>
            </center>
            </form>
 
</body>
</html>