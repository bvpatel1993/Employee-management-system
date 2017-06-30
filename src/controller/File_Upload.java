package controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.ResponseCache;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.DirectoryDao;
import model.directory_contain;


/**
 * Servlet implementation class File_Upload
 */
@WebServlet("/File_Upload")
@MultipartConfig(maxFileSize = 428496729)

public class File_Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public File_Upload() {
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
		String dirname = (String) session.getAttribute("directory_name");
		System.out.println("from file upload"+dirname);

		int dir_id = (int) session.getAttribute("d_id");
		
		System.out.println("from file upload"+dir_id);
		
		
		
		Part filePart = request.getPart("fileupload");
		
		InputStream inputStream = null;
		String file_name =getFilename(filePart);
	    String	file_type=filePart.getContentType();
		
		
	    
	    if (filePart != null) {
            inputStream = filePart.getInputStream();
    		
		}
	    
	    
	    
	    directory_contain dac = new directory_contain();
	    dac.setDir_id(dir_id);
	    dac.setFilename(file_name);
	    dac.setFiletype(file_type);
	    dac.setFile(inputStream);
	    dac.setUser_id(user_id);
	    
	    DirectoryDao dd = new DirectoryDao();
		//List<directory_contain> fileadddlist = new ArrayList<directory_contain>();

	    try {
			dd.insertFile(dac);
response.sendRedirect("viewdirectory.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	
	
	}
	private String getFilename(Part filePart) {
		
		
		// TODO Auto-generated method stub
		final String partHeader = filePart.getHeader("content-disposition");
	    //LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
	    for (String content : filePart.getHeader("content-disposition").split(";")) {
	        if (content.trim().startsWith("filename")) {
	            return content.substring(
	                    content.indexOf('=') + 1).trim().replace("\"", "");
	        }
	    }

	
	
	
	
	// TODO Auto-generated method stub
	return null;
}

}
