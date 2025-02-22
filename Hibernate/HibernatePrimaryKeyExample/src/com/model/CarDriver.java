package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CarDriver {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String carDriverName;
	
	private String  driverContactNo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCarDriverName() {
		return carDriverName;
	}

	public void setCarDriverName(String carDriverName) {
		this.carDriverName = carDriverName;
	}

	public String getDriverContactNo() {
		return driverContactNo;
	}

	public void setDriverContactNo(String driverContactNo) {
		this.driverContactNo = driverContactNo;
	}

	@Override
	public String toString() {
		return "CarDriver [id=" + id + ", carDriverName=" + carDriverName + ", driverContactNo=" + driverContactNo
				+ "]";
	}
	
	
}
