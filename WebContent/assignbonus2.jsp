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


<form action = "Assign_BonusListStatus?flag=approve_status" method="post">
<label>FirstName:<%=request.getAttribute("firstname") %></label>
//<label><%=request.getAttribute("user_id") %></label>

<input type="hidden" name="user_id" value="<%=request.getAttribute("user_id") %>"/>
       
       
       <table>
       <tr>
       <td>
        Bonus:<input type="text" name="bonus" />

        comment:<input type="text" name="comment" />
        
        </td>
        </tr>
        <tr>
        <td>
        <label>Select Month</label>

<select name="monthselection">
<option value="Jan">Jan</option>
<option value="Feb">Feb</option>
<option value="Mar">Mar</option>
<option value="Apr">Apr</option>
<option value="May">May</option>
<option value="Jun">Jun</option>
<option value="Jul">Jul</option>
<option value="Aug">Aug</option>
<option value="Sep">Sep</option>
<option value="Oct">Oct</option>
<option value="Nov">Nov</option>
<option value="Des">Des</option>



</select>
        
        
        
</td>
</tr>
</table>

<input type="submit" value="Submit">
</form>










</body>
</html>