package com.gl.service;

import com.gl.entity.Address;

public interface AddressService {
	
	public String removeAddress(int id);
	public Address updateAddress(Address a,int id)throws Exception;
	public Address findAddressByStreet(String street);
	public Address getAddressCityStreet(String regEx,String city);

}
