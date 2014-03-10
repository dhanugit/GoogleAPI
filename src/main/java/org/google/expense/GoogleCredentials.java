package org.google.expense;

public class GoogleCredentials {
	private final String USRENAME;
	private final String PASSWORD;
	
	public GoogleCredentials(String username,String passWord){
		this.USRENAME = username;
		this.PASSWORD = passWord;
	}
	
	public String getUserName(){
		return USRENAME;
	}
	
	public String getPassWord(){
		return PASSWORD;
	}
	
}
