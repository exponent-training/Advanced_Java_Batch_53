package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accountinfo")
public class AccountData {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "accountId",unique = true, nullable = false)
	private String acno;
	
	private String acHolderName;
	
	private String actype;
	
	private String acholdermobno;
	
	private double amount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAcno() {
		return acno;
	}

	public void setAcno(String acno) {
		this.acno = acno;
	}

	public String getAcHolderName() {
		return acHolderName;
	}

	public void setAcHolderName(String acHolderName) {
		this.acHolderName = acHolderName;
	}

	public String getActype() {
		return actype;
	}

	public void setActype(String actype) {
		this.actype = actype;
	}

	public String getAcholdermobno() {
		return acholdermobno;
	}

	public void setAcholdermobno(String acholdermobno) {
		this.acholdermobno = acholdermobno;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "AccountData [id=" + id + ", acno=" + acno + ", acHolderName=" + acHolderName + ", actype=" + actype
				+ ", acholdermobno=" + acholdermobno + ", amount=" + amount + "]";
	}
	
	

}
