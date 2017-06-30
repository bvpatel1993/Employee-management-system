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

import dao.DirectoryDao;
import model.directory;

/**
 * Servlet implementation class ViewProtectedDirectory
 */
@WebServlet("/ViewProtectedDirectory")
public class ViewProtectedDirectory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewProtectedDirectory() {
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
		HttpSession session= request.getSession();
		int iuser_id = (int) session.getAttribute("user_id");
	String user_id =Integer.toString(iuser_id);
		List<directory> protectedirectorylist=new ArrayList<directory>();
      directory di = new directory();
      
		DirectoryDao dir = new DirectoryDao();
		try {
			protectedirectorylist=dir.displayProtectirectoryList(user_id);
			session.setAttribute("protectedirectorylist", protectedirectorylist);
			response.sendRedirect("viewprotectededirectory.jsp");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
