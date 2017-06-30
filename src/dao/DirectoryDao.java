package dao;

import java.io.InputStream; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import model.directory;
import model.directory_contain;
import model.directory_contain_dummy;

import model.leave_req;
import model.payroll;
import model.register;
import utils.DbConnection;

public class DirectoryDao {

	public List<directory> display(directory di) throws SQLException {
		// TODO Auto-generated method stub
		
		List<directory > publicdirectorylist=new ArrayList<directory>();
		 DbConnection db = new DbConnection();
			Connection con = null;
			con= DbConnection.DBConnection();Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from directory where directory_type ='public' ");
			while(rs.next()){
				directory rg = new directory();
				rg.setD_id(rs.getInt("d_id"));
				rg.setDirectory_name(rs.getString("directory_name"));
				
				publicdirectorylist.add(rg);
				
				}
				
			System.out.println(publicdirectorylist);
		return publicdirectorylist;
		
		
		
		
	}

	public void insertFile(directory_contain dac) throws SQLException {
		// TODO Auto-generated method stub
		InputStream inputStream = null;

		 DbConnection db = new DbConnection();
			Connection con = null;
			con= DbConnection.DBConnection();
			Statement st=con.createStatement();
			 String sql="INSERT INTO directory_contain(dir_id,user_id, filename,filetype,file) values(?,?,?,?,?)";
				PreparedStatement pst=(PreparedStatement) con.prepareStatement(sql);

		
				pst.setInt(1, dac.getDir_id());
				pst.setInt(2, dac.getUser_id());

				pst.setString(3, dac.getFilename());
				pst.setString(4, dac.getFiletype());
				pst.setBlob(5,dac.getFile());
				int temp_data=pst.executeUpdate();
		
		
		System.out.println("DoneSucces");
		
		
	}

	public List<directory_contain_dummy> getTempFile(directory_contain_dummy dm) throws SQLException {
		
		// TODO Auto-generated method stub
		List<directory_contain_dummy> temp_filelist=new ArrayList<directory_contain_dummy>();
		 DbConnection db = new DbConnection();
			Connection con = null;
			con= DbConnection.DBConnection();
			Statement st=(Statement) con.createStatement();
			ResultSet rs=st.executeQuery("select * from directory_contain where dir_id ='"+dm.getDir_id()+"' ");
			System.out.println("fromdao"+dm.getDir_id());
			while(rs.next()){
				directory_contain_dummy py= new directory_contain_dummy();
				py.setFile_id(rs.getInt("file_id"));
				py.setFilename(rs.getString("filename"));
			    py.setFiletype(rs.getString("filetype"));	
			    
				
			    temp_filelist.add(py);
				
				}
				
			
		return temp_filelist;
	
		
		
		
		
	}
	public static directory_contain_dummy getFiles(int displayid)throws ClassNotFoundException, SQLException
	{
		directory_contain_dummy temp_display = new directory_contain_dummy();
		
		 DbConnection db = new DbConnection();
			Connection con = null;
			con= DbConnection.DBConnection();
		Statement st=con.createStatement();
		System.out.println(displayid);
		ResultSet rs = st.executeQuery("select * from directory_contain where file_id ='"+displayid+"'");
		
		while(rs.next()){
		temp_display.setFile_id(rs.getInt("file_id"));
		temp_display.setFile(rs.getBlob("file"));
		temp_display.setFilename(rs.getString("filename"));
		}
		st.close();
		
		
	
		
		return temp_display;
	}

	public List<directory> displayPrivatedirectoryList(String user_id) throws SQLException {
		// TODO Auto-generated method stub
		List<directory > privatedirectorylist=new ArrayList<directory>();
		 DbConnection db = new DbConnection();
			Connection con = null;
			con= DbConnection.DBConnection();Statement st=con.createStatement();
			String sql ="select * from directory where directory_type ='private' and hierarrchy LIKE '%"+user_id+"%'";
			
			System.out.println(sql);
			
			ResultSet rs=st.executeQuery("select * from directory where directory_type ='private' and hierarrchy LIKE '%"+user_id+"%'");
			while(rs.next()){
				directory rg = new directory();
				rg.setD_id(rs.getInt("d_id"));
				rg.setDirectory_name(rs.getString("directory_name"));
				
				privatedirectorylist.add(rg);
				
				}
				
			System.out.println(privatedirectorylist);
		return privatedirectorylist;
		
		
	}

	public String protectedDefaultuserList(int user_id) {
		// TODO Auto-generated method stub
		
		
		
		DbConnection db = new DbConnection();
		Connection con = null;
		String hierarchy = null;
		con= db.DBConnection();
		try {
			Statement st=(Statement) con.createStatement();
			ResultSet rs=st.executeQuery("select * from register where user_id ='"+user_id+"'  ");
			while(rs.next()){
				hierarchy= rs.getString("Directory_Man_Acees");
				System.out.print("dao"+hierarchy);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hierarchy;
		
		
		
		
		
		
		
		
	}

	public void CreateProtectedDefault(directory dir) throws SQLException {
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

	public List<directory> displayProtectirectoryList(String user_id) throws SQLException {
		// TODO Auto-generated method stub
		
		List<directory > protectedirectorylist=new ArrayList<directory>();
		 DbConnection db = new DbConnection();
			Connection con = null;
			con= DbConnection.DBConnection();Statement st=con.createStatement();
			String sql ="select * from directory where directory_type ='protected' and hierarrchy LIKE '%"+user_id+"%'";
			
			System.out.println(sql);
			
			ResultSet rs=st.executeQuery("select * from directory where directory_type ='protected' and hierarrchy LIKE '%"+user_id+"%'");
			while(rs.next()){
				directory rg = new directory();
				rg.setD_id(rs.getInt("d_id"));
				rg.setDirectory_name(rs.getString("directory_name"));
				
				protectedirectorylist.add(rg);
				
				}
				
			System.out.println(protectedirectorylist);
		return protectedirectorylist;
		
		
	}

	public List<directory> displayDefaultDirectoryList(String user_id) throws SQLException {
		// TODO Auto-generated method stub
		List<directory > defaultdirectorylist=new ArrayList<directory>();
		 DbConnection db = new DbConnection();
			Connection con = null;
			con= DbConnection.DBConnection();
			Statement st=con.createStatement();
			String sql ="select * from directory where directory_type ='default' and hierarrchy LIKE '%"+user_id+"%'";
			
			System.out.println(sql);
			
			ResultSet rs=st.executeQuery("select * from directory where directory_type ='default' and hierarrchy LIKE '%"+user_id+"%'");
			while(rs.next()){
				directory rg = new directory();
				rg.setD_id(rs.getInt("d_id"));
				rg.setDirectory_name(rs.getString("directory_name"));
				
				defaultdirectorylist.add(rg);
				
				}
				
			System.out.println(defaultdirectorylist);
		return defaultdirectorylist;
	
	}

	public List<directory> atedisplaydirectoryList(String user_id) throws SQLException {
		// TODO Auto-generated method stub
		List<directory > atedirectorylist=new ArrayList<directory>();
		 DbConnection db = new DbConnection();
			Connection con = null;
			con= DbConnection.DBConnection();
			Statement st=con.createStatement();
			String sql ="select * from directory where directory_type ='protected' and user_id='"+user_id+"'";
			
			System.out.println(sql);
			
			ResultSet rs=st.executeQuery("select * from directory where directory_type ='protected' and user_id='"+user_id+"'");
			while(rs.next()){
				directory rg = new directory();
				rg.setD_id(rs.getInt("d_id"));
				rg.setDirectory_name(rs.getString("directory_name"));
				
				atedirectorylist.add(rg);
				
				}
				
			System.out.println(atedirectorylist);
		return atedirectorylist;
		
		
	}

	public List<register> acceslistchangeList(register register) throws SQLException {
		// TODO Auto-generated method stub
		List<register> allowacesslist=new ArrayList<register>();

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
				allowacesslist.add(rg);
				System.out.println("Accessslist"+allowacesslist);
				}
		return allowacesslist;

	
	
	}

	public String changeAccessRights(directory dd) throws SQLException {
		// TODO Auto-generated method stub
		
		
		 DbConnection db = new DbConnection();
			Connection con = null;
			con= DbConnection.DBConnection();
			Statement st=con.createStatement();
			String har = null;
			String sql = "select * from directory where d_id ='"+dd.getD_id()+"'";
			System.out.println(sql);
			ResultSet rs=st.executeQuery("select * from directory where d_id ='"+dd.getD_id()+"' ");
			while(rs.next()){
				
				har=rs.getString("hierarrchy");
				System.out.println("daohar"+har);
				return har;

				
				
			}
			return har;
		
		
		
	}

	public void updateAccessFinal(String fhar, int d_id) {
		// TODO Auto-generated method stub
		
		DbConnection db = new DbConnection();
		Connection con = null;
		con= db.DBConnection();
		try {
			
			String sql = "update directory set hierarrchy='"+fhar+"' where d_id ='"+d_id+"'";
			System.out.println(sql);
			Statement st=(Statement) con.createStatement();
			st.executeUpdate("update directory set hierarrchy='"+fhar+"' where d_id ='"+d_id+"'");
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

	public List<directory> publicCHangeDisplaydirectoryList(int user_id) throws SQLException {
		// TODO Auto-generated method stub
		List<directory > publicaccesschangelist=new ArrayList<directory>();
		 DbConnection db = new DbConnection();
			Connection con = null;
			con= DbConnection.DBConnection();
			Statement st=con.createStatement();
			String sql ="select * from directory where directory_type ='public' and user_id='"+user_id+"'";
			
			System.out.println(sql);
			
			ResultSet rs=st.executeQuery("select * from directory where directory_type ='public' and user_id='"+user_id+"'");
			while(rs.next()){
				directory rg = new directory();
				rg.setD_id(rs.getInt("d_id"));
				rg.setDirectory_name(rs.getString("directory_name"));
				
				publicaccesschangelist.add(rg);
				
				}
				
			System.out.println(publicaccesschangelist);
		return publicaccesschangelist;
		
		
	}

	public directory updatePublicToPrivate(directory di) {
		// TODO Auto-generated method stub
		
		DbConnection db = new DbConnection();
		Connection con = null;
		con= db.DBConnection();
		try {
			
			String sql = "update directory set directory_type='"+di.getDirectory_type()+"' where d_id ='"+di.getD_id()+"'";
			System.out.println(sql);
			Statement st=(Statement) con.createStatement();
			st.executeUpdate("update directory set directory_type='"+di.getDirectory_type()+"' where d_id ='"+di.getD_id()+"'");
		}
		catch(Exception e){
			System.out.println(e);
		}
		return di;
	}

	public String getProtectedfromregister(String temp_userid) {
		// TODO Auto-generated method stub
		DbConnection db = new DbConnection();
		Connection con = null;
		String hierarchy = null;
		con= db.DBConnection();
		try {
			Statement st=(Statement) con.createStatement();
			ResultSet rs=st.executeQuery("select Directory_Man_Acees from register where Directory_Man_Acees LIKE '%"+temp_userid+"%' ");
			while(rs.next()){
				hierarchy=hierarchy +"\"" +rs.getString("Directory_Man_Acees")+"\"";
				System.out.print("dao"+hierarchy);

				return hierarchy;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hierarchy;
		
		
		
		
		
		
		
		
	}

	public directory updatePublicToPROTECTEDORDEFAULT(directory di) {
		// TODO Auto-generated method stub
		DbConnection db = new DbConnection();
		Connection con = null;
		con= db.DBConnection();
		try {
			
			String sql = "update directory set directory_type='"+di.getDirectory_type()+"', hierarrchy='"+di.getHierarrchy()+"' where d_id ='"+di.getD_id()+"'";
			System.out.println(sql);
			Statement st=(Statement) con.createStatement();
			st.executeUpdate("update directory set directory_type='"+di.getDirectory_type()+"',hierarrchy ='"+di.getHierarrchy()+"' where d_id ='"+di.getD_id()+"'");
		}
		catch(Exception e){
			System.out.println(e);
		}
		return di;
	}

	public String getProtectedHierarchy(String pruserid) {
		// TODO Auto-generated method stub
		
		DbConnection db = new DbConnection();
		Connection con = null;
		String hir = null;
		con= db.DBConnection();
		try {
			Statement st=(Statement) con.createStatement();
			String sql = "select * from register where Directory_Man_Acees like '%"+pruserid+"%'";
			System.out.println(sql);
			ResultSet rs=st.executeQuery("select * from register where Directory_Man_Acees like '%"+pruserid+"%'");
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

	public String simpleUserID(int user_id) {
		// TODO Auto-generated method stub
		DbConnection db = new DbConnection();
		Connection con = null;
		String hierarchy = null;
		con= db.DBConnection();
		try {
			Statement st=(Statement) con.createStatement();
			ResultSet rs=st.executeQuery("select * from register where user_id ='"+user_id+"'  ");
			while(rs.next()){
				hierarchy= rs.getString("Directory_Man_Acees");
				System.out.print("dao"+hierarchy);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hierarchy;
		
		
		
		
		
	}
}
