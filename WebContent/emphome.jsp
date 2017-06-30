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


	else if(session.getAttribute("temp_sourcetype")!= null && session.getAttribute("temp_sourcetype").equals("1"))
	{
		//response.sendRedirect("emphome.jsp");
		request.setAttribute("msgNot", "You are Login as Manager!!");

    	request.getRequestDispatcher("managerhome.jsp").forward(request, response);
		
	}




     %>
${msgNot} 


<%@include file ="logout.jsp" %>


<a href ="leaverequest.jsp">Leave Request</a>

<table>

<tr>
<td>

<form action="LeaveHistory" method="get">  
        <input type="submit" value="Leave History" />

</form>

<form action="PayHistory" method="post">  
        <input type="submit" value="Pay History" />

</form>
${msgSuccess}

</td>
</tr> 
<tr>
<td>
<form action="ViewDirectory" method="post">  
        <input type="submit" value="View Directory" />

</form>


</tr> 





</table>
</body>
</html>