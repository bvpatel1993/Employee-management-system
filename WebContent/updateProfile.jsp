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



<form action="UpdateProfile" method="post">  
        <c:forEach items="${sessionScope.registerUpdate }" var="temp">
        <input type="hidden" name="user_id" value="${temp.user_id }">
        <table>
        <tr>
        <td>
        First Name:<input type="text" name="First_Name" value="${temp.firstname }"/>
        </td>
        </tr>
        <tr>
        <td>
        Last Name:<input type="text" name="Last_Name" value="${temp.lastname }" />
        </td>
        </tr>
        <tr>
        <td>
        Address : <input type="text" name ="Address" value="${temp.address }" /> 
        </td>
        </tr>
        <tr>
        <td>
        Email Id : <input type="email" name ="email" value="${temp.email }" /> 
        </td>
        </tr>
        <tr>
        <td>
        <input type="submit" value="Update"> 
        </td>
        </tr>
        </table></c:forEach>
        </form>
</body>
</html>