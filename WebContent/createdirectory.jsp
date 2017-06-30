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

<form action="CreateDirectory" method="post">  
        <table>
        <tr>
        <td>
        Directory Name:<input type="text" name="directoryname" />
        </td>
        </tr>
        <tr>
        <td>
<label>Permission Type</label>

<select name="permissiontype">
<option value="public">public</option>
<option value="private">private</option>
<option value="protected">protected</option>
<option value="default">default</option>


</select>

        </td>
        </tr>
       
        <tr>
        <td>
        <input type="submit" value="Create" />
        </td>
        </tr>
        </table>
        
        </form>






</body>
</html>