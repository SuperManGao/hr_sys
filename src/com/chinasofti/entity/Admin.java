package com.chinasofti.entity;

public class Admin {

	private int id;
	private String userName;
	private String Password;
	private String adminLevel;
	public Admin(int id, String userName, String password, String adminLevel) {
		super();
		this.id = id;
		this.userName = userName;
		Password = password;
		this.adminLevel = adminLevel;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getAdminLevel() {
		return adminLevel;
	}
	public void setAdminLevel(String adminLevel) {
		this.adminLevel = adminLevel;
	}
	
	
}
