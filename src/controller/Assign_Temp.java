package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import dao.Assign_tempDao;
import model.register;

/**
 * Servlet implementation class Assign_Temp
 */
@WebServlet("/Assign_Temp")
public class Assign_Temp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Assign_Temp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession temp_session_assign=request.getSession(); 

		List<register> temp_assignmanagerlist=new ArrayList<register>();	

		try {
			temp_assignmanagerlist=Assign_tempDao.temp_assignManager();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		temp_session_assign.setAttribute("temp_assignmanagerlist", temp_assignmanagerlist);
		//response.sendRedirect("assignmanager.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		HttpSession temp_session_assign=request.getSession(); 
		List<register> temp_assignlist=new ArrayList<register>();	

		Assign_tempDao assign_temp = new Assign_tempDao();
		try {
			temp_assignlist=Assign_tempDao.temp_assignEmployee();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		temp_session_assign.setAttribute("temp_assignlist", temp_assignlist);
		response.sendRedirect("assignmanager.jsp");
		
		}

}
