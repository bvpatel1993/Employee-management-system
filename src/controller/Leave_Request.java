package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Leave_Apply_DeclineDao;
import dao.RegisterDao;
import model.leave_req;
import model.register;

/**
 * Servlet implementation class Leave_Request
 */
@WebServlet("/Leave_Request")
public class Leave_Request extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Leave_Request() {
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
		HttpSession htp = request.getSession();
		int user_id = (int) htp.getAttribute("user_id");
		System.out.println(user_id);
		register register=new register();
		register.setUser_id(user_id);
		
		RegisterDao RegisterDao=new RegisterDao();
		
		String under_supervision=RegisterDao.getUnderSupervision(register);
		int leaves_available = RegisterDao.getleavesAvailable(register);
		
		System.out.print(leaves_available);
		
		
		String strtdate = request.getParameter("Start_Date");
		String enddate = request.getParameter("End_Date");
		String reason = request.getParameter("Reason");
		//String total_days = "";
		SimpleDateFormat smp = new SimpleDateFormat("yyyy-MM-dd");
		Date str = null;
		Date end = null;
		long dayscount;
		int d;
		try {
			str=smp.parse(strtdate);
			end=smp.parse(enddate);
			System.out.println("strdate"+str);
			System.out.println("enddate"+end);

} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		dayscount = end.getTime() - str.getTime();
		long days = TimeUnit.MILLISECONDS.toDays(dayscount);
		System.out.println(days);
 d = (int) days + 1;
		
		if(days > leaves_available)
		{
			request.setAttribute("msg", "your available leaves are: "+leaves_available+" ");
	    	request.getRequestDispatcher("/leaverequest.jsp").forward(request, response);

		}
		
		else if(days<= 0)
		{
			request.setAttribute("msg", "pls check your date selection");
	    	request.getRequestDispatcher("/leaverequest.jsp").forward(request, response);
		}
		
		
		else{
		
leave_req lq = new leave_req();
lq.setStartdate(strtdate);	
lq.setEnddate(enddate);
lq.setReason(reason);
lq.setUser_id(user_id);	
lq.setTotaldays(d);
lq.setUnder_manager(under_supervision);
lq.setApprove("pending");
	Leave_Apply_DeclineDao lap = new Leave_Apply_DeclineDao();
	try {
		String message = lap.leavereq(lq);
		System.out.println(message);
		if(message.equals("true")){
			System.out.println("successfully entered to leave table");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	request.setAttribute("msgSuccess", "Your request successfully send");
	request.getRequestDispatcher("/emphome.jsp").forward(request, response);
	}
	}
}
