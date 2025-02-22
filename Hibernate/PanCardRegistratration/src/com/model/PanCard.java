package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PanCard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String panNumber;
	
	private String panName;
	
	private String panAddress;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getPanName() {
		return panName;
	}

	public void setPanName(String panName) {
		this.panName = panName;
	}

	public String getPanAddress() {
		return panAddress;
	}

	public void setPanAddress(String panAddress) {
		this.panAddress = panAddress;
	}

	@Override
	public String toString() {
		return "PanCard [id=" + id + ", panNumber=" + panNumber + ", panName=" + panName + ", panAddress=" + panAddress
				+ "]";
	}
	
	

}
