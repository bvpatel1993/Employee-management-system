package model;

import java.io.Serializable;

public class directory implements Serializable{
	
	
	private int d_id;
	private int user_id;
	private String directory_name;
	private String directory_type;
	private String hierarrchy;
	public int getD_id() {
		return d_id;
	}
	public void setD_id(int d_id) {
		this.d_id = d_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getDirectory_name() {
		return directory_name;
	}
	public void setDirectory_name(String directory_name) {
		this.directory_name = directory_name;
	}
	public String getDirectory_type() {
		return directory_type;
	}
	public void setDirectory_type(String directory_type) {
		this.directory_type = directory_type;
	}
	public String getHierarrchy() {
		return hierarrchy;
	}
	public void setHierarrchy(String hierarrchy) {
		this.hierarrchy = hierarrchy;
	}

}
