package com.api.request.model;

public class loginUserDetails {
	
	private String username;
	private String password;
	
	
	public loginUserDetails() {
    }
	
	//This default constructor is created because used in ObjectMappeDemo class readervalue(). So it was generating exception
	//Exception in thread "main" com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Cannot construct instance of `com.api.request.model.loginUserDetails` (no Creators, like default constructor, exist): 
	//Above exception says that no default constructor in loginUserDetails class ,after creating a default constructor it worked.

	
	
	public loginUserDetails(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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
	@Override
	public String toString() {
		return "loginUserDetails [username=" + username + ", password=" + password + "]";
	}
	
	

}
