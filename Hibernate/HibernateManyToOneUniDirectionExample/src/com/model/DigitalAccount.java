package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class DigitalAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String daccountname;
	
	private String daccounttype;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "d_p_id")
	private Person person;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDaccountname() {
		return daccountname;
	}

	public void setDaccountname(String daccountname) {
		this.daccountname = daccountname;
	}

	public String getDaccounttype() {
		return daccounttype;
	}

	public void setDaccounttype(String daccounttype) {
		this.daccounttype = daccounttype;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "DigitalAccount [id=" + id + ", daccountname=" + daccountname + ", daccounttype=" + daccounttype
				+ ", person=" + person + "]";
	}
	
	

}
