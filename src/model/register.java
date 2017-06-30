package model;

import java.io.Serializable;

public class register implements Serializable {
	
	private int user_id;
	private String firstname;
	private String lastname;
	private String address;
	private String phonenumber;
	private String email;
	private String username;
	private String password;
	private String sourcetype;
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	private int leaves_available;
	private int salary;
	public int getLeaves_available() {
		return leaves_available;
	}
	public void setLeaves_available(int leaves_available) {
		this.leaves_available = leaves_available;
	}
	public String getDirectoy_Man_Acees() {
		return Directoy_Man_Acees;
	}
	public void setDirectoy_Man_Acees(String directoy_Man_Acees) {
		Directoy_Man_Acees = directoy_Man_Acees;
	}
	public String getMy_manager_under() {
		return My_manager_under;
	}
	public void setMy_manager_under(String my_manager_under) {
		My_manager_under = my_manager_under;
	}
	private String isActive;
	private String Directoy_Man_Acees;
	private String My_manager_under;
	
	
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSourcetype() {
		return sourcetype;
	}
	public void setSourcetype(String sourcetype) {
		this.sourcetype = sourcetype;
	}
	
	
}
