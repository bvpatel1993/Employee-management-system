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

import org.apache.catalina.Session;

import dao.DirectoryDao;
import model.directory_contain;
import model.directory_contain_dummy;
import model.payroll;

/**
 * Servlet implementation class ViewPublicDirectory2
 */
@WebServlet("/ViewPublicDirectory2")
public class ViewPublicDirectory2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewPublicDirectory2() {
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
	String flag =  request.getParameter("flag");
	System.out.println(flag);
	if(flag.equals("view")){
		
		int d_id = Integer.parseInt(request.getParameter("d_id"));
		String directory_name = request.getParameter("directory_name");
		
		
		System.out.println("d2"+d_id);
		System.out.println("d2name"+directory_name);

		
		
		
		//directory_contain dad = new directory_contain();
		

		directory_contain_dummy dm =new directory_contain_dummy();
		
		dm.setDir_id(d_id);

		List<directory_contain_dummy> temp_filelist=new ArrayList<directory_contain_dummy>();

		System.out.println(d_id);
		
		DirectoryDao dto = new DirectoryDao();
		
		try {
			temp_filelist = dto.getTempFile(dm);
			System.out.println("Size of list is " +temp_filelist.size());
			session.setAttribute("temp_filelist", temp_filelist);
			response.sendRedirect("viewfilelist.jsp");
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
		doGet(request, response);
	}

}
