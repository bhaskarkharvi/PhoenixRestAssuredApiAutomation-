package com.dataproviders.api.bean;

import com.opencsv.bean.CsvBindByName;
import com.poiji.annotation.ExcelCellName;

public class UserBean {
	//private String username;
	//private String password;
	
	@ExcelCellName("username")
	@CsvBindByName(column="username") 
	private String x;
	
	@ExcelCellName("password")
	@CsvBindByName(column="password") 
	private String y;
	
	
	public UserBean() {
		
	}
	public UserBean(String username , String password) {
		this.x=username;
		this.y=password;
	
	}
	public String getUsername() {
		return x;
	}
	public void setUsername(String username) {
		this.x = username;
	}
	public String getPassword() {
		return y;
	}
	public void setPassword(String password) {
		this.y = password;
	}
	@Override
	public String toString() {
		return "UserPOJO [username=" + x + ", password=" + y + "]";
	}
	
}
