package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_details")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	
	private String pname;
	
	private int stockDetails;
	
	private String supplierName;
	
	private String Status;
	
	private int price;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getStockDetails() {
		return stockDetails;
	}

	public void setStockDetails(int stockDetails) {
		this.stockDetails = stockDetails;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", stockDetails=" + stockDetails + ", supplierName="
				+ supplierName + ", Status=" + Status + ", price=" + price + "]";
	}

	
	

}
