package com.chinasofti.entity;

public class Emp {
	private int id;
	private String email;
	private String eName;
	private String eTel;
	private String eDate;
	private int eSal;
	private int did;
	private int jid;
	
	
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Emp(int id, String email, String eName, String eTel, String eDate,
			int eSal, int did, int jid) {
		super();
		this.id = id;
		this.email = email;
		this.eName = eName;
		this.eTel = eTel;
		this.eDate = eDate;
		this.eSal = eSal;
		this.did = did;
		this.jid = jid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public String geteTel() {
		return eTel;
	}
	public void seteTel(String eTel) {
		this.eTel = eTel;
	}
	public String geteDate() {
		return eDate;
	}
	public void seteDate(String eDate) {
		this.eDate = eDate;
	}
	public int geteSal() {
		return eSal;
	}
	public void seteSal(int eSal) {
		this.eSal = eSal;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public int getJid() {
		return jid;
	}
	public void setJid(int jid) {
		this.jid = jid;
	}
	
	
}
