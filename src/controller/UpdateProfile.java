package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RegisterDao;
import model.register;

/**
 * Servlet implementation class UpdateProfile
 */
@WebServlet("/UpdateProfile")
public class UpdateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		
		int user_id = (Integer)session.getAttribute("user_id");
		List<register> registerUpdate=new ArrayList<register>();
		register register=new register();
		register.setUser_id(user_id);
		
		RegisterDao rad= new RegisterDao();
		try {
			registerUpdate=rad.updateProfile(register);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		session.setAttribute("registerUpdate", registerUpdate);
		response.sendRedirect("updateProfile.jsp");
		
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		int user_id=Integer.parseInt(request.getParameter("user_id"));
		String First_Name=request.getParameter("First_Name");
		String Last_Name=request.getParameter("Last_Name");
		String Address=request.getParameter("Address");
		String email=request.getParameter("email");
		
		register reg=new register();
		reg.setUser_id(user_id);
		reg.setFirstname(First_Name);
		reg.setLastname(Last_Name);
		reg.setAddress(Address);
		reg.setEmail(email);
		
		RegisterDao rdo = new RegisterDao();
		rdo.updateProfileUser(reg);
		response.sendRedirect("emphome.jsp");

	}	

}
