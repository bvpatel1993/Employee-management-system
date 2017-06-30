<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 

	if(session.getAttribute("user_id")== null   ){
		request.setAttribute("msgSessionLogin", "Please Login To view that Page!!");

    	request.getRequestDispatcher("Sign-in.jsp").forward(request, response);
		}
	
	
     


	else if(session.getAttribute("temp_sourcetype")!= null && session.getAttribute("temp_sourcetype").equals("1"))
	{
		//response.sendRedirect("admin.jsp");
		request.setAttribute("msgNot", "You are Login as manager!!");
    	request.getRequestDispatcher("managerhome.jsp").forward(request, response);
		
	}


	else if(session.getAttribute("temp_sourcetype")!= null && session.getAttribute("temp_sourcetype").equals("0"))
	{
		//response.sendRedirect("emphome.jsp");
		request.setAttribute("msgNot", "You are Login as employee!!");

    	request.getRequestDispatcher("emphome.jsp").forward(request, response);
		
	}




     %>
<%@include file ="logoutadmin.jsp" %>

<table>
<tr><td>First Name</td><td>Last Name</td><td>Email</td><td>Status</td><td>Assign</td></tr>

<c:forEach items="${sessionScope.temp_assignlist }" var="temp">

<tr><td>${temp.firstname }</td><td>${temp.lastname }</td><td>${temp.email}</td><td>${temp.isActive}</td><td><a href="Assign_ChangeStatus?flag=assign&user_id=${temp.user_id }&firstname=${temp.firstname}">Assign</td></tr> 

</c:forEach>
</table>
</body>
</html>