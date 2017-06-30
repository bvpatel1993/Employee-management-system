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
 * Servlet implementation class Assign_Bonus
 */
@WebServlet("/Assign_BonusList")
public class Assign_BonusList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Assign_BonusList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
       HttpSession session=request.getSession(); 
		
		int user_id = (int) session.getAttribute("user_id");
		List<register> temp_undermangerlist=new ArrayList<register>();
		register rg = new register();
		rg.setUser_id(user_id);
		RegisterDao reg = new RegisterDao();
		try {
			temp_undermangerlist =reg.undermagerlist(rg);
			session.setAttribute("temp_undermanagerlist", temp_undermangerlist);
			response.sendRedirect("assignbonus.jsp");

		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	}
