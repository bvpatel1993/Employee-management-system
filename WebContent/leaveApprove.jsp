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
	
	
     


	else if(session.getAttribute("temp_sourcetype")!= null && session.getAttribute("temp_sourcetype").equals("2"))
	{
		//response.sendRedirect("admin.jsp");
		request.setAttribute("msgNot", "You are Login as Admin!!");

    	request.getRequestDispatcher("admin.jsp").forward(request, response);
		
	}


	else if(session.getAttribute("temp_sourcetype")!= null && session.getAttribute("temp_sourcetype").equals("0"))
	{
		//response.sendRedirect("emphome.jsp");
		request.setAttribute("msgNot", "You are Login as employee!!");

    	request.getRequestDispatcher("emphome.jsp").forward(request, response);
		
	}




     %>

<%@include file ="logout.jsp" %>

<table>
<tr><td>User_id</td><td>Start Date</td><td>End Date</td><td>Reason</td><td>Totaldays</td><td>Approve/Disapprove</td></tr>

<c:forEach items="${sessionScope.temp_leavelist }" var="temp">
<tr><td>${temp.user_id }</td><td>${temp.startdate }</td><td>${temp.enddate}</td><td>${temp.reason}</td><td>${temp.totaldays}</td>

<td><a href="Leave_Approve_Status?flag=approve&user_id=${temp.user_id }&leave_id=${temp.leave_id}&totaldays=${temp.totaldays}">Approve/Decline</td>

</tr> 

</c:forEach>


</table>

</body>
</html>