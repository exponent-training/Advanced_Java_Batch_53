package com.Entity;

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
	
	private String name;
	
	private String address;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "employee")
	private List<CompanyDetails> listOfCompany;

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<CompanyDetails> getListOfCompany() {
		return listOfCompany;
	}

	public void setListOfCompany(List<CompanyDetails> listOfCompany) {
		this.listOfCompany = listOfCompany;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", name=" + name + ", address=" + address + ", listOfCompany=" + listOfCompany
				+ "]";
	}

	
	
}
