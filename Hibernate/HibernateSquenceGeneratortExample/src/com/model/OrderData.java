package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Type;

@Entity
public class OrderData {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "myseq")
	@SequenceGenerator(name = "myseq", initialValue = 1000,allocationSize = 10)
	private int id;
	
	private String orderName;
	
	private String orderid;
	
	private String orderdate;
	
	@Type(type = "yes_no")
	private boolean isDelivered;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}

	public boolean isDelivered() {
		return isDelivered;
	}

	public void setDelivered(boolean isDelivered) {
		this.isDelivered = isDelivered;
	}

	@Override
	public String toString() {
		return "OrderData [id=" + id + ", orderName=" + orderName + ", orderid=" + orderid + ", orderdate=" + orderdate
				+ ", isDelivered=" + isDelivered + "]";
	}
	
	

}
