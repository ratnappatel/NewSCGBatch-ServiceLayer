package com.gl.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String street;
	private String city;
	private int zip;
	public Address() {
		// TODO Auto-generated constructor stub
	}
	public Address( String street, String city, int zip) {
		this.street = street;
		this.city = city;
		this.zip = zip;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	@Override
	public int hashCode() {
		return Objects.hash(city, id, street, zip);
	}
	@Override
	public boolean equals(Object obj) {
		Address other = (Address) obj;
		return Objects.equals(city, other.city) && id == other.id && Objects.equals(street, other.street)
				&& zip == other.zip;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", city=" + city + ", zip=" + zip + "]";
	}
}
