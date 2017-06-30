package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.bonus;
import model.leave_req;
import model.payroll;
import model.register;
import utils.DbConnection;

public class Leave_Apply_DeclineDao {

	public String leavereq(leave_req lq) throws SQLException {
		// TODO Auto-generated method stub
		
		

		DbConnection db = new DbConnection();
		Connection con = null;
		con= db.DBConnection();
		
		PreparedStatement ps=con.prepareStatement
	              ("insert into leave_req_apply(user_id,startdate,enddate,reason, totaldays, under_manager) values(?,?,?,?,?,?)");

	    ps.setInt(1, lq.getUser_id());
	    ps.setString(2, lq.getStartdate());
	    ps.setString(3, lq.getEnddate());
	    ps.setString(4, lq.getReason());
	    
	    ps.setInt(5, lq.getTotaldays());
	    ps.setString(6, lq.getUnder_manager());
	    

	    int i=ps.executeUpdate();
	   
	    return "true";
	    
	}

	public List<leave_req> leavlist(leave_req lq) throws SQLException {
		List<leave_req> temp_leavelist=new ArrayList<leave_req>();
		 DbConnection db = new DbConnection();
			Connection con = null;
			con= DbConnection.DBConnection();Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from leave_req_apply where  under_manager = '"+lq.getUser_id()+"' and approve='pending'");
			
			while(rs.next()){
				leave_req rg = new leave_req();
				rg.setUser_id(rs.getInt("user_id"));
				rg.setStartdate(rs.getString("startdate"));
				rg.setEnddate(rs.getString("enddate"));
				rg.setReason(rs.getString("reason"));
				rg.setTotaldays(rs.getInt("totaldays"));
				rg.setLeave_id(rs.getInt("leave_id"));
				temp_leavelist.add(rg);
				
				}
				
			
		return temp_leavelist;
		
	}

	public String approvedeclinestatus(String leavestatus, String empid,int leave_id) throws SQLException {
		// TODO Auto-generated method stub
		DbConnection db = new DbConnection();
		Connection con = null;
		con= DbConnection.DBConnection();
		Statement st=con.createStatement();
		System.out.println(leave_id);
		System.out.println(leavestatus);
		System.out.println(empid);

		
		st.executeUpdate(" UPDATE leave_req_apply SET approve = '"+leavestatus+"' WHERE leave_id = '"+leave_id+"' ");
		return empid;
	}

	public String approvedeclinestatuswithupdateregister(String leavestatus, String empid, int leave_id,
			int remaining_leaves) throws SQLException {
		// TODO Auto-generated method stub
		DbConnection db = new DbConnection();
		Connection con = null;
		con= DbConnection.DBConnection();
		Statement st=con.createStatement();
		System.out.println(leave_id);
		System.out.println(leavestatus);
		System.out.println(empid);

		
		st.executeUpdate(" UPDATE leave_req_apply SET approve = '"+leavestatus+"' WHERE leave_id = '"+leave_id+"' ");
		st.executeUpdate(" UPDATE register SET leaves_available = '"+remaining_leaves+"' WHERE user_id = '"+empid+"' ");

		return empid;
	}

	public void setCarryForward() throws SQLException {
		// TODO Auto-generated method stub
	
		DbConnection db = new DbConnection();
		Connection con = null;
		con= DbConnection.DBConnection();
		Statement st=con.createStatement();
		System.out.println("inside dao");

		st.executeUpdate(" UPDATE register SET leaves_available = leaves_available+4 ");

		
	}

	public List<leave_req > LeaveHistoryList(leave_req lq) throws SQLException {
		
	// TODO Auto-generated method stub
	
		
		List<leave_req > temp_leavelist=new ArrayList<leave_req>();
		 DbConnection db = new DbConnection();
			Connection con = null;
			con= DbConnection.DBConnection();Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from leave_req_apply where user_id ='"+lq.getUser_id()+"' ");
			System.out.println(lq.getUser_id());
			while(rs.next()){
				leave_req rg = new leave_req();
				rg.setLeave_id(rs.getInt("leave_id"));
				rg.setTotaldays(rs.getInt("totaldays"));
				rg.setReason(rs.getString("reason"));
				rg.setApprove(rs.getString("approve"));
				temp_leavelist.add(rg);
				
				}
				
			System.out.println(temp_leavelist);
		return temp_leavelist;
		
		
		
		
	}

	public void payRollinsert(payroll istore) throws SQLException {
		
// TODO Auto-generated method stub

		
		
		DbConnection db = new DbConnection();
		Connection con = null;
		con= db.DBConnection();
		PreparedStatement ps=con.prepareStatement
	              ("insert into payroll(user_id,month,Montly_Salary,bonus,totalsalary) values(?,?,?,?,?)");

	    ps.setInt(1, istore.getUser_id());
	    ps.setString(2, istore.getMonth());
	    ps.setInt(3, istore.getMontly_salary());
	    ps.setInt(4, istore.getBonus());
	    ps.setInt(5, istore.getTotalsalary());
	    


	    int i=ps.executeUpdate();
		
		
		
		
	}

	public void bonuinsert(bonus bns) throws SQLException {
		// TODO Auto-generated method stub
	
		
		DbConnection db = new DbConnection();
		Connection con = null;
		con= db.DBConnection();
		PreparedStatement ps=con.prepareStatement
	              ("insert into bonus(user_id,month,bonus,comment) values(?,?,?,?)");

	    ps.setInt(1, bns.getUser_id());
	    ps.setString(2, bns.getMonthofbonus());
	    ps.setInt(3, bns.getBonus());
	    ps.setString(4, bns.getComment());

	    


	    int i=ps.executeUpdate();
		
		
		
		
		
	}

	public int bonusreturn(bonus bns) throws SQLException {
		// TODO Auto-generated method stub
		
		
		DbConnection db = new DbConnection();
		Connection con = null;
		int bonus = 0;
		con= db.DBConnection();
		
		
			Statement st=(Statement) con.createStatement();
			ResultSet rs=st.executeQuery("select bonus from bonus where user_id ='"+bns.getUser_id()+"' and monthofbonus ='"+bns.getMonthofbonus()+"'");
			while(rs.next()){
				bonus=rs.getInt("bonus");
				System.out.println(bonus);

				return bonus;
		
		
		
		
	

	
		}
			return bonus;
		
	}
}

	
	
	
	
	
	
