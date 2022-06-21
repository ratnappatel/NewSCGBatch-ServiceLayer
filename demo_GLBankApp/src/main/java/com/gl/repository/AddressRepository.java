package com.gl.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.gl.entity.Address;

public interface AddressRepository extends CrudRepository<Address, Integer>{

	@Query("select a from Address a where a.street=:s")
	public Address getAddressByStreet(@Param("s")String street);
	
	@Query("select a from Address a  where street like :regEx and city=:city")
	public Address getAddressByCityAndStreet(@Param("regEx")String regEx,
			@Param("city")String city);
}
