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
import model.payroll;
import model.register;

/**
 * Servlet implementation class PayHistory
 */
@WebServlet("/PayHistory")
public class PayHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayHistory() {
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
		

		HttpSession temp_session=request.getSession(); 
		List<payroll> temp_pay_history=new ArrayList<payroll>();
		
		int user_id = (int) temp_session.getAttribute("user_id");
		
		
		System.out.println("Payhistrycontroller"+user_id);
		payroll  pr = new payroll();
		pr.setUser_id(user_id);
		
		RegisterDao reg = new RegisterDao();
		
		try {
			temp_pay_history =reg.payHistory(pr);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		temp_session.setAttribute("temp_pay_history", temp_pay_history);
		response.sendRedirect("payhistory.jsp");

		
	}

}
