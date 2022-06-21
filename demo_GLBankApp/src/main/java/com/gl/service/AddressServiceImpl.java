package com.gl.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.entity.Address;
import com.gl.repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired AddressRepository repository;
	@Override
	public String removeAddress(int id) {
		repository.deleteById(id);
		return "Success";
	}
	@Override
	public Address updateAddress(Address a, int id)throws Exception{
		Optional<Address> address=repository.findById(id);
		Address ad=address.orElseThrow(()->new Exception("Address Doesn't exists"));
		ad.setId(a.getId());
		ad.setCity(a.getCity());
		ad.setStreet(a.getStreet());
		ad.setZip(a.getZip());
		repository.save(ad);
		return ad;
	}
	@Override
	public Address findAddressByStreet(String street) {
		return repository.getAddressByStreet(street);
		
	}
	@Override
	public Address getAddressCityStreet(String regEx, String city) {
		return repository.getAddressByCityAndStreet(regEx, city);
	}
	

}
