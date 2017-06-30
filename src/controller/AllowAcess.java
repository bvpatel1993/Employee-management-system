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

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import dao.DirectoryDao;
import model.directory;
import model.register;

/**
 * Servlet implementation class AllowAcess
 */
@WebServlet("/AllowAcess")
public class AllowAcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllowAcess() {
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
		String directory_name = request.getParameter("directory_name");
		
		String flag = request.getParameter("flag");
		if (flag.equals("change"))
		{
			List<register> allowacesslist=new ArrayList<register>();	
			register register=new register();

			register.setIsActive("1");
			DirectoryDao dad = new DirectoryDao();
			try {
				allowacesslist = dad.acceslistchangeList(register);
				session.setAttribute("allowacesslist", allowacesslist);
				session.setAttribute("d_id", d_id);
			//	session.setAttribute(arg0, arg1);
				session.setAttribute("directory_name", directory_name);
				response.sendRedirect("ate2.jsp");
				
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
		
        HttpSession session = request.getSession();
        int d_id = (int) session.getAttribute("d_id");
        String uid = request.getParameter("ateemployee");
      //  int u_id = Integer.parseInt(uid);
         System.out.println("conroller first"+uid);
         
        directory dd = new directory();
        
         dd.setD_id(d_id);
        // dd.setUser_id(u_id);
         
         DirectoryDao dad = new DirectoryDao();
         
         try {
			String har =dad.changeAccessRights(dd);
			
String fhar = har + "\"" +uid +"\"";		


System.out.println("final send combine"+fhar);
dad.updateAccessFinal(fhar,d_id);

request.setAttribute("msgSuccess2", "ATE DONE!!!");
request.getRequestDispatcher("/managerhome.jsp").forward(request, response);	


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
