package model;

import java.io.InputStream;
import java.io.Serializable;
import java.sql.Blob;

public class directory_contain implements Serializable{
	
	private int file_id;
	private int dir_id;
	private int user_id;
	private String  filename;

	
	private InputStream file;
	private String filetype;
	public int getFile_id() {
		return file_id;
	}
	public void setFile_id(int file_id) {
		this.file_id = file_id;
	}
	public int getDir_id() {
		return dir_id;
	}
	public void setDir_id(int dir_id) {
		this.dir_id = dir_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public InputStream getFile() {
		return file;
	}
	public void setFile(InputStream file) {
		this.file = file;
	}
	public String getFiletype() {
		return filetype;
	}
	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}
	
	
	
	
	
	
	
	
	

}
