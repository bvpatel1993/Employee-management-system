package model;

import java.io.Serializable;

public class leave_req implements Serializable{
	private int user_id;
	private String startdate;
	private String enddate;
	private String under_manager;
	private int leave_id;
	

	public String getUnder_manager() {
		return under_manager;
	}

	public void setUnder_manager(String under_manager) {
		this.under_manager = under_manager;
	}

	public int getTotaldays() {
		return totaldays;
	}

	public void setTotaldays(int totaldays) {
		this.totaldays = totaldays;
	}
	private int totaldays;
	

	public String getStartdate() {
		return startdate;
	}
	
	public int getLeave_id() {
		return leave_id;
	}

	public void setLeave_id(int leave_id) {
		this.leave_id = leave_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	private String reason;
	
	
	
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getApprove() {
		return approve;
	}
	public void setApprove(String approve) {
		this.approve = approve;
	}
	private String approve;
}
