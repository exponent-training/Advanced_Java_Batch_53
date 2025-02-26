package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Passport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String passNo;
	
	private String passportIssuedName;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Person person;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassNo() {
		return passNo;
	}

	public void setPassNo(String passNo) {
		this.passNo = passNo;
	}

	public String getPassportIssuedName() {
		return passportIssuedName;
	}

	public void setPassportIssuedName(String passportIssuedName) {
		this.passportIssuedName = passportIssuedName;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Passport [id=" + id + ", passNo=" + passNo + ", passportIssuedName=" + passportIssuedName + "]";
	}


}
