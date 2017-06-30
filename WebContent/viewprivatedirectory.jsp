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



<table>
<tr><td>Directory_Id</td><td>Directory Name</td><td>View</td><td>Add</td></tr>

<c:forEach items="${sessionScope.privatedirectorylist }" var="temp">

<tr><td>${temp.d_id }</td><td>${temp.directory_name }</td><td> <a href="ViewPublicDirectory2?flag=view&d_id=${temp.d_id }&directory_name=${temp.directory_name }">View</td><td><a href="AddFilePublicDirectory?flag=add&d_id=${temp.d_id }&directory_name=${temp.directory_name }">Add</td></tr> 

</c:forEach>
</table>







</body>
</html>