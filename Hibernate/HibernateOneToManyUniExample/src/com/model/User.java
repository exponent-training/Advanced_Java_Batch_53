package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;

@Entity
public class User {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String uname;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "u_a_id")
	private List<AddToCart> addToCarts = new ArrayList<AddToCart>();

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

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public List<AddToCart> getAddToCart() {
		return addToCarts;
	}

	public void setAddToCart(List<AddToCart> addToCart) {
		this.addToCarts = addToCart;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", uname=" + uname + ", addToCart=" + addToCarts + "]";
	}

	
}
