<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="<%=request.getContextPath() %>/LogoutAdmin" method="post">
<table align="right"><tr><td><input type="submit" value="Logout"></td></tr>

<tr>
<td>
<a href = "admin.jsp"><input type = "button" value="Home"></a>
</td>
</tr>
</table>
</form>

</body>
</html>