package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DirectoryDao;
import dao.LoginDao;
import dao.RegisterDao;
import model.directory;
import model.register;

/**
 * Servlet implementation class CreateDirectory
 */
@WebServlet("/CreateDirectory")
public class CreateDirectory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateDirectory() {
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
		HttpSession session = request.getSession();
		int user_id = (int) session.getAttribute("user_id");
		String drname = request.getParameter("directoryname");
		String permissiontype = request.getParameter("permissiontype");
		
		
		register reg = new register();
		reg.setUser_id(user_id);
		RegisterDao rad = new RegisterDao();
		
		String hierarchy=rad.getHirarchy(reg);
		
	
		
		
		
		
		String passprotectedid = "\""+Integer.toString(user_id)+"\"";
	    System.out.println("answer"+passprotectedid);
		String protectedHir = rad.getProtectedHierarchy(passprotectedid);
		
		
		System.out.println("inside create protectedHir"+protectedHir);

		
		
		
		
	//	String muser_id = "\""+Integer.toString(user_id)+"\"";
		
	
	DirectoryDao dd = new DirectoryDao();
	 String hirList =  dd.protectedDefaultuserList(user_id);
		
	 String temp_finalusers = hirList + protectedHir;
	 System.out.println("hierarchycreated"+hierarchy);
	 System.out.println("hirlistcreated"+hirList);
	 System.out.println("temp final Userscreated"+temp_finalusers);
		if(permissiontype.equals("public") || permissiontype.equals("private") ){
		
		
		
		System.out.println(hierarchy);
		
		
		directory dir = new directory();
		dir.setDirectory_name(drname);
		dir.setDirectory_type(permissiontype);
		dir.setHierarrchy(hierarchy);
		dir.setUser_id(user_id);
		LoginDao lag = new LoginDao();
		try {
			lag.createDirectory(dir);
			
			request.setAttribute("msgSuccess", "Directory created...");
			request.getRequestDispatcher("/managerhome.jsp").forward(request, response);	
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		
		else{
			
			directory dir = new directory();
			dir.setDirectory_name(drname);
			dir.setDirectory_type(permissiontype);
			dir.setHierarrchy(temp_finalusers);
			dir.setUser_id(user_id);
			
			try {
				dd.CreateProtectedDefault(dir);
				request.setAttribute("msgSuccess", "Directory created...");
				request.getRequestDispatcher("/managerhome.jsp").forward(request, response);	
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}

}
