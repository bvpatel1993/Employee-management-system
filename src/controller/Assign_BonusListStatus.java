package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Leave_Apply_DeclineDao;
import model.bonus;

/**
 * Servlet implementation class Assign_BonusListStatus
 */
@WebServlet("/Assign_BonusListStatus")
public class Assign_BonusListStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Assign_BonusListStatus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		String flag = request.getParameter("flag");
		if (flag.equals("approve")){
			
			
			int user_id = Integer.parseInt( request.getParameter("user_id"));
			String firstname = request.getParameter("firstname");

			request.setAttribute("user_id", user_id);
			request.setAttribute("firstname", firstname);
			
	    	request.getRequestDispatcher("/assignbonus2.jsp").forward(request, response);

			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String flag=request.getParameter("flag");
		if(flag.equals("approve_status")){
		
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		int bonus = Integer.parseInt(request.getParameter("bonus"));
		String comment = request.getParameter("comment");
		String month = request.getParameter("monthselection");
		
		bonus bns = new bonus();
		bns.setUser_id(user_id);
		bns.setBonus(bonus);
		bns.setComment(comment);
		bns.setMonthofbonus(month);
		
		Leave_Apply_DeclineDao lad = new Leave_Apply_DeclineDao();
	    
	    try {
			lad.bonuinsert(bns);
			request.setAttribute("msgSuccess", "Bonus genrated...");
			request.getRequestDispatcher("/assignbonus.jsp").forward(request, response);			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
		}
		
		
		
	}


