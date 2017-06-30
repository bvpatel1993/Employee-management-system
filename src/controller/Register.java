package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.Validation;
import dao.RegisterDao;
import model.register;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String First_Name=request.getParameter("First_Name");  
	    String Last_Name=request.getParameter("Last_Name");
	    String Address = request.getParameter("Address");
	    String Phone_number = request.getParameter("Phone_Number");
	     String Email=request.getParameter("Email");
	    String User_Id=request.getParameter("username");
	    String password=request.getParameter("password");
	    
	    
	    register temp_store = new register();
	    temp_store.setFirstname(First_Name);
	    temp_store.setLastname(Last_Name);
	    temp_store.setAddress(Address);
	    temp_store.setPhonenumber(Phone_number);
	    temp_store.setEmail(Email);
	    temp_store.setUsername(User_Id);
	    temp_store.setPassword(password);
	    
	    Validation val=new Validation();
		  String check=  val.Validate(temp_store);
		    if(check.equals("all fields are mandatory")){
		    	request.setAttribute("msg_temp", check);
	            RequestDispatcher rd=request.getRequestDispatcher("reisterpage.jsp");  
	            rd.forward(request, response);
		    	
		    }
		    
    else if(check.equals("invalid Credentials")){
		    	request.setAttribute("msg_temp", check);
	            RequestDispatcher rd=request.getRequestDispatcher("reisterpage.jsp");  
	            rd.forward(request, response);
		    }
		    
		    else{
		    	RegisterDao regdao = new RegisterDao();
		    
		    	String status = regdao.checkUser(temp_store);
		    if(status.equals("possible"))
		    {
		    try {
				regdao.Insert(temp_store);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   //response.sendRedirect("Sign-in.jsp");
		    request.setAttribute("success", "suceessfully register");
		 request.getRequestDispatcher("/Sign-in.jsp").forward(request, response);
		    }
		    else
		    {
		    	request.setAttribute("msg_temp", "username not available");
	            RequestDispatcher rd=request.getRequestDispatcher("reisterpage.jsp");  
	            rd.forward(request, response);
		    }
		    }
		    
		    }
}
