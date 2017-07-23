package com.chinasofti.entity;

public class Dept {
	private int id;
	private String dName;
	private String dLoc;
	
	
	public Dept() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dept(int id, String dName, String dLoc) {
		super();
		this.id = id;
		this.dName = dName;
		this.dLoc = dLoc;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getdName() {
		return dName;
	}
	public void setdName(String dName) {
		this.dName = dName;
	}
	public String getdLoc() {
		return dLoc;
	}
	public void setdLoc(String dLoc) {
		this.dLoc = dLoc;
	}
	
}
