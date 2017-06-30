package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import model.payroll;
import model.register;
import utils.DbConnection;

public class RegisterDao {
	public void Insert(register temp_store) throws SQLException
	{

		DbConnection db = new DbConnection();
		Connection con = null;
		con= db.DBConnection();
		PreparedStatement ps=con.prepareStatement
	              ("insert into register(firstname,lastname,address,phonenumber,email,username,password,sourcetype,isActive,leaves_available) values(?,?,?,?,?,?,?,'0','0','4')");

	    ps.setString(1, temp_store.getFirstname());
	    ps.setString(2, temp_store.getLastname());
	    ps.setString(3, temp_store.getAddress());
	    ps.setString(4, temp_store.getPhonenumber());
	    ps.setString(5, temp_store.getEmail());
	    ps.setString(6, temp_store.getUsername());
	    ps.setString(7, temp_store.getPassword());


	    int i=ps.executeUpdate();
		
		
}
	public String getUnderSupervision(register register){
		DbConnection db = new DbConnection();
		Connection con = null;
		String under_supervision=null;
		con= db.DBConnection();
		
		try {
			Statement st=(Statement) con.createStatement();
			ResultSet rs=st.executeQuery("select My_manager_under from register where user_id ='"+register.getUser_id()+"'");
			while(rs.next()){
				under_supervision=rs.getString("My_manager_under");
				return under_supervision;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return under_supervision;
		
	}
	public int getleavesAvailable(register register) {
		// TODO Auto-generated method stub
		
		
		DbConnection db = new DbConnection();
		Connection con = null;
		int leaves_available = 0;
		con= db.DBConnection();
		
		try {
			Statement st=(Statement) con.createStatement();
			ResultSet rs=st.executeQuery("select leaves_available from register where user_id ='"+register.getUser_id()+"'");
			while(rs.next()){
				leaves_available=rs.getInt("leaves_available");
				return leaves_available;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return leaves_available;

	}
	public int getSalary(register register) {
		// TODO Auto-generated method stub
		
		DbConnection db = new DbConnection();
		Connection con = null;
		int salary = 0;
		con= db.DBConnection();
		try {
			Statement st=(Statement) con.createStatement();
			ResultSet rs=st.executeQuery("select salary from register where user_id ='"+register.getUser_id()+"'");
			while(rs.next()){
				salary=rs.getInt("salary");
				System.out.print("dao"+salary);

				return salary;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return salary;
	}
	public List<register> undermagerlist(register rg) throws SQLException {
		// TODO Auto-generated method stub
		List<register> temp_undermanagerlist=new ArrayList<register>();
		 DbConnection db = new DbConnection();
			Connection con = null;
			con= DbConnection.DBConnection();
			Statement st=(Statement) con.createStatement();
			ResultSet rs=st.executeQuery("select * from register where My_manager_under ='"+rg.getUser_id()+"' ");
			
			while(rs.next()){
				register reg= new register();
				reg.setFirstname(rs.getString("firstname"));
				reg.setLastname(rs.getString("lastname"));
				reg.setEmail(rs.getString("email"));
			
				reg.setUser_id(rs.getInt("user_id"));
				
				temp_undermanagerlist.add(reg);
				
				}
				
			
		return temp_undermanagerlist;
		
	}
	public List<register> updateProfile(register rg) throws SQLException {
		// TODO Auto-generated method stub
		List<register> temp_undermanagerlist=new ArrayList<register>();
		 DbConnection db = new DbConnection();
			Connection con = null;
			con= DbConnection.DBConnection();
			Statement st=(Statement) con.createStatement();
			ResultSet rs=st.executeQuery("select * from register where user_id ='"+rg.getUser_id()+"' ");
			
			while(rs.next()){
				register reg= new register();
				reg.setFirstname(rs.getString("firstname"));
				reg.setLastname(rs.getString("lastname"));
				reg.setEmail(rs.getString("email"));
				reg.setAddress(rs.getString("address"));
				reg.setUser_id(rs.getInt("user_id"));
				
				temp_undermanagerlist.add(reg);
				
				}
				
			
		return temp_undermanagerlist;
		
	}
	public List<payroll> payHistory(payroll pr) throws SQLException {
		// TODO Auto-generated method stub
		List<payroll> temp_pay_history=new ArrayList<payroll>();
		 DbConnection db = new DbConnection();
			Connection con = null;
			con= DbConnection.DBConnection();
			Statement st=(Statement) con.createStatement();
			ResultSet rs=st.executeQuery("select * from payroll where user_id ='"+pr.getUser_id()+"' ");
			
			while(rs.next()){
				payroll py= new payroll();
				py.setPay_id(rs.getInt("pay_id"));
				py.setUser_id(rs.getInt("user_id"));
				py.setMonth(rs.getString("month"));
				py.setMontly_salary(rs.getInt("Montly_Salary"));
				py.setTotalsalary(rs.getInt("totalsalary"));
				py.setBonus(rs.getInt("bonus"));
			
				
				temp_pay_history.add(py);
				
				}
				
			
		return temp_pay_history;
	}
	public String getHirarchy(register reg) {
		// TODO Auto-generated method stub
		DbConnection db = new DbConnection();
		Connection con = null;
		String hierarchy = null;
		con= db.DBConnection();
		try {
			Statement st=(Statement) con.createStatement();
			ResultSet rs=st.executeQuery("select Directory_Man_Acees from register where user_id ='"+reg.getUser_id()+"'");
			while(rs.next()){
				hierarchy=rs.getString("Directory_Man_Acees");
				System.out.print("dao"+hierarchy);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hierarchy;
}
	public void updateProfileUser(register reg){
		DbConnection db = new DbConnection();
		Connection con = null;
		con= db.DBConnection();
		try {
			Statement st=(Statement) con.createStatement();
			st.executeUpdate("update register set firstname='"+reg.getFirstname()+"', lastname='"+reg.getLastname()+"',address='"+reg.getAddress()+"',email='"+reg.getEmail()+"' where user_id='"+reg.getUser_id()+"'");
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	public String getProtectedHierarchy(String passprotectedid) {
		// TODO Auto-generated method stub
		
		DbConnection db = new DbConnection();
		Connection con = null;
		String hir = null;
		con= db.DBConnection();
		try {
			Statement st=(Statement) con.createStatement();
			String sql = "select * from register where Directory_Man_Acees like '%"+passprotectedid+"%'";
			System.out.println(sql);
			ResultSet rs=st.executeQuery("select * from register where Directory_Man_Acees like '%"+passprotectedid+"%'");
			while(rs.next()){
				hir= hir + "\"" +(rs.getString("user_id"))+"\"";
				System.out.print("dao"+hir);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hir;
		}
	public String checkUser(register temp_store) {
		// TODO Auto-generated method stub
		DbConnection db = new DbConnection();
		Connection con = null;
		String under_supervision="possible";
		con= db.DBConnection();
		
		try {
			Statement st=(Statement) con.createStatement();
			ResultSet rs=st.executeQuery("select * from register where username ='"+temp_store.getUsername()+"'");
			while(rs.next()){
				under_supervision = "not possible";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return under_supervision;
	}
}
