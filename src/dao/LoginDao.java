package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.directory;
import model.login;
import utils.DbConnection;

public class LoginDao {

	 public String authenticateUser(login lg) throws SQLException
	 {
		 DbConnection db = new DbConnection();
			Connection con = null;
			con= db.DBConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from register");
			System.out.println(lg.getUsername());
			System.out.println(lg.getPassword());
			while(rs.next()){
				
				String temp_username=rs.getString("username");
				String temp_password=rs.getString("password");
				String temp_fname=rs.getString("firstname");
				String temp_sourcetype = rs.getString("sourcetype");
				String isActive = rs.getString("isActive");
				int temp_user_id = rs.getInt("user_id");
				
				lg.setUser_id(temp_user_id);
				
				if(temp_username.equals(lg.getUsername()) && temp_password.equals(lg.getPassword())&& isActive.equals("1")){
					//System.out.println("2");
					return temp_sourcetype;
					
				}
				
			}
		 
		
		 return "Invalidate credentials";
		 }

	public void createDirectory(directory dir) throws SQLException {
		// TODO Auto-generated method stub
		
		DbConnection db = new DbConnection();
		Connection con = null;
		con= db.DBConnection();
		PreparedStatement ps=con.prepareStatement
	              ("insert into directory(user_id,directory_name,directory_type,hierarrchy) values(?,?,?,?)");

	    ps.setInt(1, dir.getUser_id());
	    ps.setString(2, dir.getDirectory_name());
	    ps.setString(3, dir.getDirectory_type());
	    ps.setString(4, dir.getHierarrchy());
	   

	    int i=ps.executeUpdate();
		
		
		
		
		
		
	}   

	}

