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
import model.leave_req;
import model.register;

/**
 * Servlet implementation class Leave_Approve
 */
@WebServlet("/Leave_Approve")
public class Leave_Approve extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Leave_Approve() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		
		
		
	}
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		HttpSession session=request.getSession(); 
		int user_id = (int) session.getAttribute("user_id");
		
		
		

		List<leave_req> temp_leavelist=new ArrayList<leave_req>();
		leave_req lq = new leave_req();

		lq.setUser_id(user_id);	
		
		  Leave_Apply_DeclineDao lap = new Leave_Apply_DeclineDao();
		  try {
			temp_leavelist =lap.leavlist(lq);
			session.setAttribute("temp_leavelist", temp_leavelist);
			response.sendRedirect("leaveApprove.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
