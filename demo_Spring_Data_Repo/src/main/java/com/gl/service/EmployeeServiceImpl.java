package com.gl.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.entity.Employee;
import com.gl.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired EmployeeRepository repository;
	@Override
	public List<Employee> getAllEmployee() {
	
		List<Employee> emps=(List<Employee>) repository.findAll();
		return emps;
	}
	@Override
	public Employee getByID(int id) {
		Optional res=repository.findById(id);
		Employee e=null;
		if(res.isPresent())
		{
			e=(Employee)res.get();
		}
		return e;
	}

}
