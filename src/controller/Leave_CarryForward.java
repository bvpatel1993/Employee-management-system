package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.InactiveEmployeeDao;
import dao.Leave_Apply_DeclineDao;
import model.leave_req;
import model.register;

/**
 * Servlet implementation class Leave_CarryForward
 */
@WebServlet("/Leave_CarryForward")
public class Leave_CarryForward extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Leave_CarryForward() {
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
		
		
//		Timer timer1 = new Timer();
//		   Calendar date = Calendar.getInstance();
//		   date.set(Calendar.DAY_OF_MONTH, 1);
//		   date.set(Calendar.HOUR_OF_DAY, 0);
//		   date.set(Calendar.MINUTE, 0);
//		   date.set(Calendar.SECOND, 0);
//		   date.set(Calendar.MILLISECOND, 0);
//		   System.out.println("testing");
//		   Schedule to run every Sunday in midnight
//		   timer1.schedule(
//		     new Leave_Apply_DeclineDao(),
//		     date.getTime(),
//		     1000 * 60 * 60 * 24 * 7
//		   );
		
		Leave_Apply_DeclineDao  lp= new Leave_Apply_DeclineDao();
		try {
			lp.setCarryForward();
			System.out.println("inside controller");
			request.setAttribute("msg", "Leave CarryForward Done ");
	    	request.getRequestDispatcher("/admin.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		

		

}
	}
