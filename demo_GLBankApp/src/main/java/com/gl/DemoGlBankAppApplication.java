package com.gl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gl.entity.Address;
import com.gl.entity.Customer;
import com.gl.service.AddressService;
import com.gl.service.CustomerService;

@SpringBootApplication
public class DemoGlBankAppApplication implements CommandLineRunner {

	@Autowired CustomerService service;
	@Autowired AddressService aService;
	public static void main(String[] args) {
		SpringApplication.run(DemoGlBankAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		 * Address a1=new Address("2/1 Transit Hostel", "Gandhi Nagar",209474); Customer
		 * c=new Customer( "Uttam", "7976694711", a1); Customer
		 * added=service.addCustomer(c);
		 * 
		 * int cid=added.getId(); int aid=added.getAddress().getId();
		 * System.out.println("Customer Details added succefully \nCustomer ID : "
		 * +cid+"\n Address ID : "+aid);;
		 * 
		 * Customer temp=service.findCustomer(added.getId()); System.out.println(temp);
		 */
		
		/*
		 * String res=aService.removeAddress(1);
		 * System.out.println("Address Removed : "+res);
		 */
		
		/*
		 * List<Customer> cust=service.getAllCustomer(); System.out.println(cust);
		 */
		/*
		 * Address a=new Address(); a.setId(22); a.setCity("abc"); a.setStreet("xyz");
		 * a.setZip(123456); System.out.println(aService.updateAddress(a, 2));
		 */
		
		/*Method-Name Query Formation
		 * System.out.println("Customer Details For Mobile No :9529216356"); Customer
		 * c=service.getCustomerByMobile("9529216356"); System.out.println(c);
		 */
		
		// Using @Query & @Param annotation to form a custom query in repository
		Address found=aService.findAddressByStreet("xyz");
		System.out.println(found);
		
		Address found1=aService.getAddressCityStreet("%Flats%", "Jaipur");
		System.out.println(found1);
	}

}
