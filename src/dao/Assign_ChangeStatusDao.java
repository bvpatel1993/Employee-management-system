package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.register;
import utils.DbConnection;

public class Assign_ChangeStatusDao {

	public static  List<register> assign_manager() throws SQLException{
		List<register> temp_assignmanagerlist=new ArrayList<register>();

		 DbConnection db = new DbConnection();
			Connection con = null;
			con= DbConnection.DBConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from register where isActive ='1' ");
			while(rs.next()){
				register rg = new register();
				rg.setFirstname(rs.getString("firstname"));
				rg.setLastname(rs.getString("lastname"));
				rg.setEmail(rs.getString("email"));
				rg.setIsActive(rs.getString("isActive"));
				rg.setUser_id(rs.getInt("user_id"));
				temp_assignmanagerlist.add(rg);
				
				}
		return temp_assignmanagerlist;

	
	
	}

	public static  List<register> fetchList(register register) throws SQLException{
		List<register> temp_assignmanagerlist=new ArrayList<register>();

		 DbConnection db = new DbConnection();
			Connection con = null;
			con= DbConnection.DBConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from register where isActive ='"+register.getIsActive()+"' AND sourcetype!='2' ");
			while(rs.next()){
				register rg = new register();
				rg.setFirstname(rs.getString("firstname"));
				rg.setUser_id(rs.getInt("user_id"));
				temp_assignmanagerlist.add(rg);
				
				}
		return temp_assignmanagerlist;

	
	
	}
	public void changestatus(String empid, String assignmanager_name,int salary) throws SQLException {
		// TODO Auto-generated method stub
		DbConnection db = new DbConnection();
		Connection con = null;
		con= DbConnection.DBConnection();
		Statement st=con.createStatement();
		String my_hirarchy = null;
		ResultSet rs=st.executeQuery("select * from register where user_id ='"+assignmanager_name+"'");
		while(rs.next()){
			 my_hirarchy = rs.getString("Directory_Man_Acees");
			my_hirarchy=my_hirarchy +"\"" +  empid + "\"";
			System.out.println(my_hirarchy);
			}
		
		st.executeUpdate("UPDATE register SET isActive = '1', salary ='"+salary+"', My_manager_under='"+assignmanager_name+"',Directory_Man_Acees='"+my_hirarchy+"' WHERE user_id = '"+empid+"' ");
		st.executeUpdate("UPDATE register SET sourcetype = '1' WHERE user_id = '"+assignmanager_name+"'");
		System.out.println("successfully changed");
		
	}
	
}
