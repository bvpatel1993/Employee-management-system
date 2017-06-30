package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	
	static  Connection con = null;

	
	 public static Connection DBConnection()
	    {
		 
		 
		 
	        if (con != null) return con;
	        
	        String url = "jdbc:mysql://localhost:3306/term_project?autoReconnect=true&useSSL=false";
			  String username = "root";
			  String password = "root";
	        return DBConnection(url, username, password);
	    }
	
	
	
	
	
	 private static Connection DBConnection(String url, String username, String password)
	  {
	 
	  try
	  {
	  try
	  {
	  Class.forName("com.mysql.jdbc.Driver");
	  } 
	  catch (ClassNotFoundException e)
	  {
	  e.printStackTrace();
	  }
	  System.out.println("checkDriverConnectionFor Singlton");
	   con = DriverManager.getConnection(url, username, password);
	  } 
	  catch (Exception e) 
	  {
	  e.printStackTrace();
	  }
	  return con; 
	  }
	 
	}


