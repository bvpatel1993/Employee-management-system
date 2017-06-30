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





<form action = "Assign_ChangeStatus?flag=assign_status" method="post">
<label><%=session.getAttribute("firstname") %></label>
<input type="hidden" name="temp_user_id" value="<%=session.getAttribute("temp_user_id")%>">
<select name="inactiveemployee">
<c:forEach items="${sessionScope.temp_assignmanagerlist1}" var="temp">
<option value="${temp.user_id}">${temp.firstname}</option>
</c:forEach>
</select>
<table></table>
 <tr>
        <td>
        Enter Salary:<input type="text" name="salary" />
        </td>
        </tr>
</table>
<input type="submit" value="Assign_ChangeStatus">
</form>

</body>
</html>