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
<tr>
<td>
<form action="ActiveEmployeeList" method="post">  
<input type="submit" value="View ActiveEmployeeList">
</form>
</td>
</tr>
<tr>
<td>
<form action="InactiveEmployee" method="post">  
<input type="submit" value="View InactiveEmployee">
</form>

</td>
</tr>
<tr>
<td>
<form action="Assign_Temp" method="post">  
<input type="submit" value="Assign Manager To Employee">
</form>

</td>
</tr>
<tr>
<td>
<form action="Leave_CarryForward" method="post">  
<input type="submit" value="Leave Carry Forward">
</form>

</td>
</tr>



<td>
<form action="PayRollList" method="post">  
<input type="submit" value="Genrate_Payroll">
</form>

</td>
</tr>


<tr>
<td>
                ${msg}
</td>
</tr>

${msgNot}
</table>




</body>
</html>