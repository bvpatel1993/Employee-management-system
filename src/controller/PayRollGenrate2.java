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
import model.payroll;

/**
 * Servlet implementation class PayRollGenrate2
 */
@WebServlet("/PayRollGenrate2")
public class PayRollGenrate2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayRollGenrate2() {
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

		
		
		
		int user_id = Integer.parseInt(request.getParameter("temp_user_id"));
		int salary = (int) temp_session.getAttribute("salary");
		String month = (String) temp_session.getAttribute("month");
		int bonus = (int) temp_session.getAttribute("bonus");
		int totalsalary = (int) temp_session.getAttribute("totalsalary");
		
		
		payroll istore = new payroll();
	    istore.setUser_id(user_id);
	    istore.setMontly_salary(salary);
	    istore.setMonth(month);
	    istore.setBonus(bonus);
	    istore.setTotalsalary(totalsalary);
	    
	     
	    Leave_Apply_DeclineDao lad1 = new Leave_Apply_DeclineDao();
	    
	    try {
			lad1.payRollinsert(istore);
			request.setAttribute("msgSuccess", "Pay genrated...");
			request.getRequestDispatcher("/payroll.jsp").forward(request, response);			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
