package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDao;
import model.login;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		
		HttpSession session=request.getSession();
		response.setContentType("text/html");  
		String userName = request.getParameter("user_name");
		 String password = request.getParameter("password");
			

		 login lg = new login();
		    lg.setUsername(userName);
		    lg.setPassword(password);
			

		    LoginDao loginDao = new LoginDao();
		    
			

		    
		    String check = null;
			try {
				check = loginDao.authenticateUser(lg);
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int user_id=lg.getUser_id();
		    if(check.equals("Invalidate credentials"))
		    {
	            request.setAttribute("msg_temp", "invalid credentials");

		    	request.getRequestDispatcher("Sign-in.jsp").forward(request, response);
		    	

		    }
		    
		    else if (check.equals("0")){
	    	session.setAttribute("temp_sourcetype", check);
	    	String sourcetype = (String) request.getAttribute("temp_sourcetype");
	    
		    	session.setAttribute("user_id",user_id );
		    	
		    	// request.setAttribute("success", "suceessfully register");
		    	response.sendRedirect("emphome.jsp"); 
		    	//request.getRequestDispatcher("/emphome.jsp").forward(request, response);
	    	}
		    else if (check.equals("1")){
		    	session.setAttribute("user_id",user_id );

		    	session.setAttribute("temp_sourcetype", check);
		    	String sourcetype = (String) request.getAttribute("temp_sourcetype");
		    
			    	session.setAttribute("user_id",user_id  );
			    	// request.setAttribute("success", "suceessfully register");
			    	response.sendRedirect("managerhome.jsp"); 
			    	//request.getRequestDispatcher("/emphome.jsp").forward(request, response);
		    	}
		    else {
		    	response.sendRedirect("admin.jsp"); 
		    	session.setAttribute("user_id",user_id );
		    	session.setAttribute("temp_sourcetype", check);


		    }
		    
		    }
	}


