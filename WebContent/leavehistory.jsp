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

	if(session.getAttribute("user_id")==null){
		request.setAttribute("msgSessionLogin", "Please Login To view that Page!!");

    	request.getRequestDispatcher("Sign-in.jsp").forward(request, response);
 	}
	
     if(null!=request.getAttribute("msg_temp"))
     {
         out.println(request.getAttribute("msg_temp"));
   }
     %>



<%@include file ="logout.jsp" %>


<table>
<tr><td>LeaveId</td><td>Totaldays</td><td>reason</td><td>Status</td></tr>

<c:forEach items="${sessionScope.temp_leavelist }" var="temp">

<tr><td>${temp.leave_id }</td><td>${temp.totaldays }</td><td>${temp.reason}</td><td>${temp.approve}</td></tr> 

</c:forEach>
</table>


</body>
</html>