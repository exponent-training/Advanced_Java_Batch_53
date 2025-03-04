package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String pname;
	
	private String puserid;
	
	private String puserpass;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPuserid() {
		return puserid;
	}

	public void setPuserid(String puserid) {
		this.puserid = puserid;
	}

	public String getPuserpass() {
		return puserpass;
	}

	public void setPuserpass(String puserpass) {
		this.puserpass = puserpass;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", pname=" + pname + ", puserid=" + puserid + ", puserpass=" + puserpass + "]";
	}
	
	

}
