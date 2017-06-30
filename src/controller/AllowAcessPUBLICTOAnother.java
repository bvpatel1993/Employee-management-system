package controller;

import java.awt.image.RescaleOp;
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

import dao.DirectoryDao;
import model.directory;
import model.register;

/**
 * Servlet implementation class AllowAcessPUBLICTOAnother
 */
@WebServlet("/AllowAcessPUBLICTOAnother")
public class AllowAcessPUBLICTOAnother extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllowAcessPUBLICTOAnother() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
HttpSession session = request.getSession();
		
		int user_id = (Integer)session.getAttribute("user_id");
		int d_id =  Integer.parseInt(request.getParameter("d_id"));
	
		System.out.println("ALLOW ACCESS CONTROLLER"+d_id);
		String directory_name = request.getParameter("directory_name");
		
		String flag = request.getParameter("flag");
		if (flag.equals("change"))
		{
			
				//allowacesslist = dad.acceslistchangeList(register);
				//session.setAttribute("allowacesslist", allowacesslist);
				session.setAttribute("d_id", d_id);
			//	session.setAttribute(arg0, arg1);
				session.setAttribute("directory_name", directory_name);
				response.sendRedirect("publicchangelist2.jsp");
				
			
			
			
			
		}
		
		
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		HttpSession session = request.getSession();
		
		int user_id = (Integer)session.getAttribute("user_id");
		int d_id =  (int) session.getAttribute("d_id");
		String directory_name = (String) session.getAttribute("directory_name");
		String directory_type = request.getParameter("permissiontype");

		String temp_userid = Integer.toString(user_id);
		
		
		DirectoryDao dad = new DirectoryDao();

		String pruserid = "\""+Integer.toString(user_id)+"\"";
	    System.out.println("answer"+pruserid);
		String tempprotectedHir = dad.getProtectedHierarchy(pruserid);
		String fprotectedhir =dad.simpleUserID(user_id);
		String finaltogetList = tempprotectedHir + fprotectedhir;
		
		
		
		
		
		System.out.println("ALLOW CONTROLLER BEFORE UPDATE"+finaltogetList);
		
		
		
		if (directory_type.equals("private"))
		{
		directory di = new directory();
		di.setD_id(d_id);
		di.setDirectory_name(directory_name);
		di.setDirectory_type(directory_type);
		di.setUser_id(user_id);
		
			di=dad.updatePublicToPrivate(di);
			
			request.setAttribute("msgPermissionChange", "Directory permission type changed!!!...");
			request.getRequestDispatcher("/managerhome.jsp").forward(request, response);	
			
		}
		
		else 
		{
			
			
			directory di = new directory();
			di.setD_id(d_id);
			di.setDirectory_name(directory_name);
			di.setDirectory_type(directory_type);
			di.setHierarrchy(finaltogetList);
		
			di.setUser_id(user_id);
				di=dad.updatePublicToPROTECTEDORDEFAULT(di);
				
				request.setAttribute("msgPermissionChange", "Directory permission type changed!!!...");
				request.getRequestDispatcher("/managerhome.jsp").forward(request, response);
			
			
		}
		
		
		
		
		
	}

}
