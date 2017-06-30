<%@page import="dao.DirectoryDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*"%>
    <%@page import="model.*" %>

<%@ page import="java.io.*"%>
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


<% Blob image = null;
byte[ ] imgData = null ;
try {
directory_contain_dummy display = DirectoryDao.getFiles(Integer.parseInt(request.getParameter("displayid")));	
image = display.getFile();
imgData = image.getBytes(1,(int)image.length());
response.setContentType(display.getFiletype());
OutputStream temp_o = response.getOutputStream();
temp_o.write(imgData);
temp_o.flush();
temp_o.close();
} catch (Exception e) {

out.println(e);
return;

} 



%>
</body>
</html>