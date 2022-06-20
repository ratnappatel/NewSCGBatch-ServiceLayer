package com.gl.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Not a regular java class hence put@Entity
@Entity
//@Table(name = "CustomerDetails") // when actual table name is different than the Entity classname
public class Customer {
	
	@Id // this annotation considers that id column in Customer table must be Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto_increment column
	//@Column(name="Customer_id")
	private int id;
	
	private String name;
	
	private String mobile;
	
	private int age;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Customer(String name, String mobile, int age, String address) {
		this.name = name;
		this.mobile = mobile;
		this.age = age;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public int hashCode() {
		return Objects.hash(age, id, mobile, name);
	}
	@Override
	public boolean equals(Object obj) {
		
		Customer other = (Customer) obj;
		return age == other.age && id == other.id && Objects.equals(mobile, other.mobile)
				&& Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", mobile=" + mobile + ", age=" + age + "]";
	}
	

}
