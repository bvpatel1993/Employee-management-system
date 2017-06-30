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

import dao.Assign_ChangeStatusDao;
import dao.Leave_Apply_DeclineDao;
import dao.RegisterDao;
import model.bonus;
import model.payroll;
import model.register;

/**
 * Servlet implementation class PayRollGenrate
 */
@WebServlet("/PayRollGenrate")
public class PayRollGenrate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayRollGenrate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession temp_session=request.getSession(); 

		String flag = request.getParameter("flag");
		if(flag.equals("assign")){
			
			String abc=(request.getParameter("user_id"));
			String firstname=request.getParameter("firstname");
			System.out.println(firstname);

			System.out.println("string"+abc);
			
			int fuser_id = Integer.parseInt(abc);
			System.out.println("afterint"+fuser_id);
			register register=new register();
			register.setUser_id(fuser_id);
			
			RegisterDao RegisterDao=new RegisterDao();
			
			int salary = RegisterDao.getSalary(register);
			
			
			
			
			
			System.out.print(salary);
			temp_session.setAttribute("temp_user_id", fuser_id);
			temp_session.setAttribute("firstname", firstname);
			temp_session.setAttribute("salary", salary);

			
				response.sendRedirect("payroll2.jsp");
			}
	//	HttpSession temp_session=request.getSession(); 

//		String flag = request.getParameter("flag");
		if(flag.equals("assign_status")){
		
			
			int user_id = Integer.parseInt(request.getParameter("temp_user_id"));
			int salary = (int) temp_session.getAttribute("salary");
			String month = request.getParameter("monthselection");
		
			
		   bonus bns = new bonus();
		   bns.setUser_id(user_id);
		   bns.setMonthofbonus(month);
		    
		    Leave_Apply_DeclineDao lad = new Leave_Apply_DeclineDao();

		   try {
			int bonus = lad.bonusreturn(bns);
			int totalsalary = salary+ bonus;
			temp_session.setAttribute("bonus", bonus);
			temp_session.setAttribute("salary", salary);
			temp_session.setAttribute("month", month);
			temp_session.setAttribute("totalsalary", totalsalary);

			response.sendRedirect("payroll3.jsp");

			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}
		}
		
	
	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		   
		    
//			payroll istore = new payroll();
//		    istore.setUser_id(user_id);
//		    istore.setMonthly_salary(salary);
//		    istore.setMonth(month);
//		     
//		    Leave_Apply_DeclineDao lad1 = new Leave_Apply_DeclineDao();
//		    
//		    try {
//				lad1.payRollinsert(istore);
//				request.setAttribute("msgSuccess", "Pay genrated...");
//				request.getRequestDispatcher("/payroll.jsp").forward(request, response);			
//				} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
		
		}
		
	

}
