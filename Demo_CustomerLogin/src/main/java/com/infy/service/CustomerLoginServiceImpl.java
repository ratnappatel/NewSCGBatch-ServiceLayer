package com.infy.service;

import com.infy.dto.CustomerLoginDTO;
import com.infy.exception.InfyBankException;
import com.infy.repository.CustomerLoginRepository;
import com.infy.repository.CustomerLoginRepositoryImpl;

public class CustomerLoginServiceImpl implements CustomerLoginService {

	//@Autowired = setter
	private CustomerLoginRepository customerLoginRepository;

	public CustomerLoginServiceImpl(CustomerLoginRepository customerLoginRepository) {
		this.customerLoginRepository=customerLoginRepository;
	}
	public String authenticateCustomer(CustomerLoginDTO customerLoginDTO) throws InfyBankException {
		String toReturn = null;
		//customerLoginRepository = new CustomerLoginRepositoryImpl();
		CustomerLoginDTO customerLoginFromRepository = 
				customerLoginRepository.getCustomerLoginByLoginName(customerLoginDTO.getLoginName());
		
		String actual=customerLoginFromRepository.getPassword();
		String input=customerLoginDTO.getPassword();
		
		if (actual.equals(input)) {
			toReturn = "SUCCESS";
		} else {
			throw new InfyBankException("Service.WRONG_CREDENTIALS");
		}
		return toReturn;
	}

	//public void m1() {System.out.println("M1 from Service IMPL Class");}
	//public void m2() {System.out.println("m2 from Service IMPL Class");};
	
}