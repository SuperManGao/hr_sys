package com.chinasofti.entity;

public class Job {
	private int id;
	private String jName;
	private int jLow;
	private int jHig;
	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Job(int id, String jName, int jLow, int jHig) {
		super();
		this.id = id;
		this.jName = jName;
		this.jLow = jLow;
		this.jHig = jHig;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getjName() {
		return jName;
	}
	public void setjName(String jName) {
		this.jName = jName;
	}
	public int getjLow() {
		return jLow;
	}
	public void setjLow(int jLow) {
		this.jLow = jLow;
	}
	public int getjHig() {
		return jHig;
	}
	public void setjHig(int jHig) {
		this.jHig = jHig;
	}
	
}
