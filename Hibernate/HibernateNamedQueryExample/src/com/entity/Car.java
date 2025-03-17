package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.NamedNativeQuery;


@Entity(name = "cardata")
@NamedNativeQuery(name = "all",query = "select * from cardata",resultClass = Car.class)
public class Car {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ; 
	
	private String cname;
	
	private String cmodel;
	
	private String ctype;
	
	private String myear;
	
	private double price;
	
	private String cengnumber;
	
	@Transient
	private String cng;
	
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

	public String getCmodel() {
		return cmodel;
	}

	public void setCmodel(String cmodel) {
		this.cmodel = cmodel;
	}

	public String getCtype() {
		return ctype;
	}

	public void setCtype(String ctype) {
		this.ctype = ctype;
	}

	public String getMyear() {
		return myear;
	}

	public void setMyear(String myear) {
		this.myear = myear;
	}



	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}


	public String getCengnumber() {
		return cengnumber;
	}

	public void setCengnumber(String cengnumber) {
		this.cengnumber = cengnumber;
	}

	public String getCng() {
		return cng;
	}

	public void setCng(String cng) {
		this.cng = cng;
	}

	@Override
	public String toString() {
		return "CarData [id=" + id + ", cname=" + cname + ", cmodel=" + cmodel + ", ctype=" + ctype + ", myear=" + myear
				+ ", price=" + price + ", cengnumber=" + cengnumber + ", cng=" + cng + "]";
	}
}
