package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "driverinfo")
public class Driver {
	
	@Id
	private int id;
	
	private String name;
	
	private String address;
	
	private String batchNumber;
	
	private long contactNo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getBatchNumber() {
		return batchNumber;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	public long getContactNo() {
		return contactNo;
	}

	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}

	@Override
	public String toString() {
		return "Driver [id=" + id + ", name=" + name + ", address=" + address + ", batchNumber=" + batchNumber
				+ ", contactNo=" + contactNo + "]";
	}
	

}
