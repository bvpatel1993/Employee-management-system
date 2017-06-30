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


	else if(session.getAttribute("temp_sourcetype")!= null && session.getAttribute("temp_sourcetype").equals("0"))
	{
		//response.sendRedirect("emphome.jsp");
		request.setAttribute("msgNot", "You are Login as employee!!");

    	request.getRequestDispatcher("emphome.jsp").forward(request, response);
		
	}




     %>
<%@include file ="logout.jsp" %>

${msgNot} 

<table>
<tr>
<td>
<form action="Leave_Approve" method="post">  
<input type="submit" value="LeaveApprove/Decline" />

</form>
</td>
</tr>
<tr>
<td>
<a href ="leaverequest.jsp">Leave Request</a>
</td>
</tr>
<tr>
<td>
<form action="Assign_BonusList" method="post">  
        <input type="submit" value="Assign Bonus" />

</form>
</td>
</tr>
<tr>
<td>


<form action="PayHistory" method="post">  
        <input type="submit" value="Pay History" />

</form>


</td>
</tr>
<tr>
<td>
<form action="LeaveHistory" method="post">  
        <input type="submit" value="Leave History" />

</form>
</td>
</tr>
<tr>
<td>
<a href ="createdirectory.jsp">Create Directory</a>

</td>
</tr>
<tr>
<td>
<a href ="UpdateProfile">Update Profile</a>

</td>
</tr>

<tr>
<td>
<form action="ViewDirectory" method="post">  
        <input type="submit" value="View Directory" />

</form>
</td>
</tr>

<tr>
<td>
<form action="ATEchange" method="post">  
        <input type="submit" value="ATE" />

</form>


</td></tr>
<tr>
<td>
<form action="PUBLICCHANGE_directory" method="post">  
        <input type="submit" value="PUBLICCREATED Directory CHANGE" />

</form>
</table>
${msgSuccess} 
${msgSuccess2}
${msgPermissionChange}

</body>
</html>