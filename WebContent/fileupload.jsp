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



<form action="File_Upload" method="post" enctype="multipart/form-data">

<table>
<tr><td>Upload File to :"<%=session.getAttribute("directory_name")%>"</td></tr>


<tr><td>Upload File:<input type="file" name="fileupload" ></td></tr>
<tr><td colspan="2"><input type="submit" value="upload"></td></tr>

</table>

<%-- <input type = "text" name="d_id" value = "<%request.getAttribute("d_id");%>"> --%>
<%-- <input type = "hidden"  name ="directory_name" value = "<%request.getAttribute("directory_name");%>"> --%>

 <input type="hidden" name="d_id" value="<%=session.getAttribute("d_id")%>">
 
 <input type="hidden" name="directory_name" value="<%=session.getAttribute("directory_name")%>">


</form>


</body>
</html>