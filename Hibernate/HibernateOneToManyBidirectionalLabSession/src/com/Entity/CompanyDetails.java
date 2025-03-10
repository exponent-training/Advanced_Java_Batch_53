package com.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CompanyDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;
	
	private String cname;
	
	private String joiningdate;
	
	private String experience;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_id_fk")
	private Employee employee;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getJoiningdate() {
		return joiningdate;
	}

	public void setJoiningdate(String joiningdate) {
		this.joiningdate = joiningdate;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "CompanyDetails [cid=" + cid + ", cname=" + cname + ", joiningdate=" + joiningdate + ", experience="
				+ experience + "]";
	}
	
	
}
