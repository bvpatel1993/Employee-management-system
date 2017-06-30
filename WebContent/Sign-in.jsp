<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<form action="Login" method="post">  


<% 

	if(session.getAttribute("user_id")!=null){
 		response.sendRedirect("already-logged.jsp");
 	}
	
     if(null!=request.getAttribute("msg_temp"))
     {
         out.println(request.getAttribute("msg_temp"));
   }
     %>
<table>
<tr>
<td>
Username:<input type="text" name="user_name"/></td>
</tr>
<tr>
<td>
Password:<input type="password" name="password"/>  
</td>
</tr>
<tr>
<td>
<input type="submit" value="login"/>  
</td>
</tr>
<tr>
<td>
${success}
</td>
</tr>

</table>
<a href ="reisterpage.jsp">Register Here</a>

</form>  
${ msgSessionLogin}
</body>
</html>