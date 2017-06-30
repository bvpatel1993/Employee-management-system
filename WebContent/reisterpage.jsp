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
    if(null!=request.getAttribute("msg_temp"))
    {
        out.println(request.getAttribute("msg_temp"));
    }
%>
<form action="Register" method="post">  
        <table>
        <tr>
        <td>
        First Name:<input type="text" name="First_Name" />
        </td>
        </tr>
        <tr>
        <td>
        Last Name:<input type="text" name="Last_Name" />
        </td>
        </tr>
        <tr>
        <td>
        Address : <input type="text" name ="Address" /> 
        </td>
        </tr>
        <tr>
        <td>
        phone number:<input type="text" name="Phone_Number" />
        </td>
        </tr>
         <tr>
        <td>
        Email:<input type="text" name="Email" />
        </td>
        </tr>
        <tr>
        <td>
        username:<input type="text" name="username" />
        
        </td>
        </tr>
         <tr>
        <td>
        Password:<input type="password" name="password" />
        </td>
        </tr>
        <tr>
        <td>
        <input type="submit" value="register" />
        </td>
        </tr>
        </table>
        
        </form>
</body>
</html>