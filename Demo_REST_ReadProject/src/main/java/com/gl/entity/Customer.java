package com.gl.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
// its called as Resource of my REST-webservice
public class Customer {

	@Id
	@Column(name="customer_id")
	private int id;
	@Column(name="emailid")
	private String emailId;
	private String name;
	
	@Column(name="date_of_birth")
	private Date dateOfBirth;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(int id, String emailId, String name, Date dateOfBirth) {
		super();
		this.id = id;
		this.emailId = emailId;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", emailId=" + emailId + ", name=" + name + ", dateOfBirth=" + dateOfBirth + "]";
	}
	
}
