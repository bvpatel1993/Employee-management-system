package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.register;
import utils.DbConnection;

public class Assign_tempDao {

	public static  List<register> temp_assignEmployee() throws SQLException{
		List<register> temp_assignlist=new ArrayList<register>();
		 DbConnection db = new DbConnection();
			Connection con = null;
			con= DbConnection.DBConnection();Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from register where isActive ='0' ");
			
			while(rs.next()){
				register rg = new register();
				rg.setFirstname(rs.getString("firstname"));
				rg.setLastname(rs.getString("lastname"));
				rg.setEmail(rs.getString("email"));
				rg.setIsActive(rs.getString("isActive"));
				rg.setUser_id(rs.getInt("user_id"));
				temp_assignlist.add(rg);
				
				}
				
			//System.out.println(rs.getInt("user_id"));
		return temp_assignlist;
		
	}
	public static  List<register> temp_assignManager() throws SQLException{
		
		List<register> temp_assignmanagerlist=new ArrayList<register>();
		 DbConnection db = new DbConnection();
			Connection con = null;
			con= DbConnection.DBConnection();Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from register where isActive ='1' AND sourcetype!='2'");
			
			while(rs.next()){
				register rg = new register();
				rg.setFirstname(rs.getString("firstname"));
				rg.setLastname(rs.getString("lastname"));
				rg.setEmail(rs.getString("email"));
				rg.setUser_id(rs.getInt("user_id"));
								
		
			}
		return temp_assignmanagerlist;

}
}
