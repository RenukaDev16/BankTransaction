<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="check.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action=<%=request.getContextPath() %>/WithServe method="post">
<center>
<table width="30%" cellpadding="3">
<tr>
  <td>Account No</td><td> <input type="text" name="acc_no"></td>
</tr>
<tr>
   <td>Withdraw Amount</td><td><input type="text" name="withdraw"></td>
   </tr>
   <tr>
<td><input type="submit" value="withdraw"></td>
</tr>
</table>
</center>
</form>
</body>
</html>