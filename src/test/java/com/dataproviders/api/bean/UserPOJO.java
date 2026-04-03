package com.dataproviders.api.bean;

import com.opencsv.bean.CsvBindByName;

public class UserPOJO {
	//private String username;
	//private String password;
	
	@CsvBindByName(column="username") 
	private String x;
	
	@CsvBindByName(column="password") 
	private String y;
	
	
	public UserPOJO() {
		
	}
	public UserPOJO(String username , String password) {
		this.x=username;
		this.y=password;
	
	}
	public String getUsername() {
		return y;
	}
	public void setUsername(String username) {
		this.y = username;
	}
	public String getPassword() {
		return x;
	}
	public void setPassword(String password) {
		this.x = password;
	}
	@Override
	public String toString() {
		return "UserPOJO [username=" + y + ", password=" + x + "]";
	}
	
}
