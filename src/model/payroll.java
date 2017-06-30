package model;

import java.io.Serializable;

public class payroll implements Serializable {

	
	private int pay_id;
	private int user_id;
	private String month;
	private int totalsalary;
		private int montly_salary;
		public int getMontly_salary() {
			return montly_salary;
		}
		public void setMontly_salary(int montly_salary) {
			this.montly_salary = montly_salary;
		}
		private int bonus;
		
	public int getTotalsalary() {
		return totalsalary;
	}
	public void setTotalsalary(int totalsalary) {
		this.totalsalary = totalsalary;
	}
	
	
	public int getPay_id() {
		return pay_id;
	}
	public void setPay_id(int pay_id) {
		this.pay_id = pay_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	
	public int getBonus() {
		return bonus;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	
	
	
	
	
	
}
