<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<% 

	if(session.getAttribute("user_id")==null){
		request.setAttribute("msgSessionLogin", "Please Login To view that Page!!");

    	request.getRequestDispatcher("Sign-in.jsp").forward(request, response);
 	}
	
     if(null!=request.getAttribute("msg_temp"))
     {
         out.println(request.getAttribute("msg_temp"));
   }
     %>


<table>
<tr>
<td>

<form action="ViewPublicDirectory" method="post">  
        <input type="submit" value="Public Directory" />

</form>
</td>
</tr>
<tr>
<td>
<form action="ViewPrivateDirectory" method="post">  
        <input type="submit" value="Private Directory" />

</form>

</td>
</tr>
<tr>
<td>
<form action="ViewProtectedDirectory" method="post">  
        <input type="submit" value="Protected Directory" />
</form>
</td>
</tr>
<tr>
<td>
<form action="ViewDefaultDirectory" method="post">  
        <input type="submit" value="Default Directory" />
</form>
</td>
</tr>
</table>
</body>
</html>