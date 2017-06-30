package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Assign_ChangeStatusDao;
import dao.Leave_Apply_DeclineDao;
import dao.RegisterDao;
import model.register;

/**
 * Servlet implementation class Leave_Approve_Status
 */
@WebServlet("/Leave_Approve_Status")
public class Leave_Approve_Status extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Leave_Approve_Status() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session=request.getSession(); 
		String flag=request.getParameter("flag");
		if(flag.equals("approve")){
			String empid=(request.getParameter("user_id"));
			int leave_id=Integer.parseInt(request.getParameter("leave_id"));
			int totaldays =Integer.parseInt(request.getParameter("totaldays"));

			System.out.println(request.getParameter(empid));
			session.setAttribute("user_id", empid);
			session.setAttribute("leave_id",leave_id);
			session.setAttribute("totaldays",totaldays);

			response.sendRedirect("leaveApprove2.jsp");
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		HttpSession temp_session=request.getSession(); 
		String flag=request.getParameter("flag");
		if(flag.equals("approve_status")){
			String leavestatus=request.getParameter("statusvalue");
			String empid=(request.getParameter("user_id"));
			int leave_id=(Integer)temp_session.getAttribute("leave_id");
			
			int totaldays=(Integer)temp_session.getAttribute("totaldays");

			int passempid = (Integer.parseInt(empid));
			register register=new register();
			register.setUser_id(passempid);

			RegisterDao RegisterDao=new RegisterDao();
			int leaves_available = RegisterDao.getleavesAvailable(register);

			int remaining_leaves = leaves_available - totaldays;

			
			System.out.println("Your leave id is " +leave_id);
			System.out.println("status" +leavestatus);
			System.out.println("id"+empid);
			System.out.println(("Your totaldays id is " +totaldays));
			System.out.println(("Your leaves_available id is " +leaves_available));
			System.out.println(("Your remaining_leaves id is " +remaining_leaves));

			Leave_Apply_DeclineDao  lp= new Leave_Apply_DeclineDao();
			
			
			 if(leavestatus.equals("Approve")  ){
			
			try {
				lp.approvedeclinestatuswithupdateregister(leavestatus,empid,leave_id,remaining_leaves);
				System.out.println("inside approve status");
				response.sendRedirect("leaveApprove.jsp"); 				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		}
		else{
			try {
				lp.approvedeclinestatus(leavestatus,empid,leave_id);
				response.sendRedirect("leaveApprove.jsp"); 				

				System.out.println("inside decline status");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}}

}
	}
