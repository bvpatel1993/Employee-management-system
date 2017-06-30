package model;

import java.io.Serializable;

public class bonus implements Serializable {

	
	private int bonus_id;
	private int user_id;
	private String monthofbonus;
	private int bonus;
	private String comment;
	public String getMonthofbonus() {
		return monthofbonus;
	}
	public void setMonthofbonus(String monthofbonus) {
		this.monthofbonus = monthofbonus;
	}
	public int getBonus_id() {
		return bonus_id;
	}
	public void setBonus_id(int bonus_id) {
		this.bonus_id = bonus_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	public int getBonus() {
		return bonus;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}