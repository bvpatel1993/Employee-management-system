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



<form action="Leave_Request" method="post">


 <table>
        <tr>
        <td>
        Start Date:<input type="date" name="Start_Date" />
        </td>
        </tr>
        <tr>
        <td>
        End Date:<input type="date" name="End_Date" />
        </td>
        </tr>
        <tr>
        <td>
        Reason:<input type ="text" name = "Reason" />
        </td>
        </tr>
        <tr>
        <td>
        <input type="submit" value="Leave_Request" />
        </td>
        </tr>
        <tr>
        <td>
        
                ${msg}
      </td>
      </tr>  
        </table>
        </form>
</body>
</html>