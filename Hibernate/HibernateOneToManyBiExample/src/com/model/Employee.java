package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eid;

	private String ename;

	private String eaddress;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "c_e_id")
	private List<CompanyDetails> companyDetails = new ArrayList<CompanyDetails>();

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEaddress() {
		return eaddress;
	}

	public void setEaddress(String eaddress) {
		this.eaddress = eaddress;
	}

	public List<CompanyDetails> getCompanyDetails() {
		return companyDetails;
	}

	public void setCompanyDetails(List<CompanyDetails> companyDetails) {
		this.companyDetails = companyDetails;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", eaddress=" + eaddress + ", companyDetails="
				+ companyDetails + "]";
	}
	
	
	
}
