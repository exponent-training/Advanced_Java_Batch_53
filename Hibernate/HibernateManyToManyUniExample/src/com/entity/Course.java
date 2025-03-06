package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String cname;
	
	private String cmode;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCmode() {
		return cmode;
	}

	public void setCmode(String cmode) {
		this.cmode = cmode;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", cname=" + cname + ", cmode=" + cmode + "]";
	}

	
	
}
