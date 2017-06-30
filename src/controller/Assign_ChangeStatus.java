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
import model.register;
/**
 * Servlet implementation class Assign_ChangeStatus
 */
@WebServlet("/Assign_ChangeStatus")
public class Assign_ChangeStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Assign_ChangeStatus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession temp_session=request.getSession(); 
		
/*		List<register> temp_assignmanagerlist=new ArrayList<register>();

		//register register= new register();
		String empid = request.getParameter("flag");
		String assignmanager_name = request.getParameter("inactiveemployee");
		
	System.out.println(empid);
	System.out.println(assignmanager_name);
	
	 	Assign_ChangeStatusDao assign_ChangeStatusDao= new Assign_ChangeStatusDao();
	 	try {
			assign_ChangeStatusDao.changestatus(empid,assignmanager_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		temp_session.setAttribute("temp_assignmanagerlist", temp_assignmanagerlist);
		response.sendRedirect("assignmanager2.jsp");*/
		String flag = request.getParameter("flag");
		if(flag.equals("assign")){
			
			String user_id=(request.getParameter("user_id"));
			String firstname=request.getParameter("firstname");
			temp_session.setAttribute("temp_user_id", user_id);
			temp_session.setAttribute("firstname", firstname);
			List<register> temp_assignmanagerlist=new ArrayList<register>();
			register register=new register();
			register.setIsActive("1");
			Assign_ChangeStatusDao assign_ChangeStatusDao= new Assign_ChangeStatusDao();
			try {
				temp_assignmanagerlist=Assign_ChangeStatusDao.fetchList(register);
				temp_session.setAttribute("temp_assignmanagerlist1", temp_assignmanagerlist);
				response.sendRedirect("assignmanager2.jsp");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		HttpSession temp_session=request.getSession(); 
	String flag=request.getParameter("flag");
	if(flag.equals("assign_status")){
		String assignmanager_name=(request.getParameter("inactiveemployee"));
		int salary = Integer.parseInt((request.getParameter("salary")));
		String empid=(request.getParameter("temp_user_id"));
		System.out.println(request.getParameter("inactiveemployee"));
		System.out.println(request.getParameter("temp_user_id"));

		Assign_ChangeStatusDao assign_ChangeStatusDao= new Assign_ChangeStatusDao();

		try {
			assign_ChangeStatusDao.changestatus(empid,assignmanager_name,salary);
			response.sendRedirect("admin.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	}
	
}
