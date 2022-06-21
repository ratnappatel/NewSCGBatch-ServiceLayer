package com.gl.entity;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Customer_Details")
public class Customer {
	
	@Id
	@Column(name="customer_id")
	//@TableGenerator
	//@GeneratedValue(strategy=GenerationType.AUTO)// Persistence-Provider[Hibernate] 
	//creating additional table called hibernate_sequence to manage Primary key Generation
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	/*
	 * @TableGenerator( name="pkgen", table="id_gen", pkColumnName="gen_key",
	 * valueColumnName="gen_value", pkColumnValue="cust_id", allocationSize=1 )
	 * 
	 * @GeneratedValue(generator="pkgen",strategy=GenerationType.TABLE)
	 */
	
	private int id;
	
	private String name;
	private String mobile;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "address_id",unique=true)
	private Address address;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(String name, String mobile, Address address) {
		this.name = name;
		this.mobile = mobile;
		this.address = address;
	}

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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(address, id, mobile, name);
	}

	@Override
	public boolean equals(Object obj) {
		
		Customer other = (Customer) obj;
		return Objects.equals(address, other.address) && id == other.id && Objects.equals(mobile, other.mobile)
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", mobile=" + mobile + ", \naddress=" + address.toString() + "]";
	}

	
	
	

}
