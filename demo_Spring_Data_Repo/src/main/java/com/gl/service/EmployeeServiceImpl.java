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
	@Override
	public Employee addEmployee(Employee e) {
		return repository.save(e);
		
	}
	@Override
	public Employee updateEmployee(Employee e, int id) {
		Employee existing=getByID(id);
		existing.setId(e.getId());
		existing.setFname(e.getFname());
		existing.setSalary(e.getSalary());
		existing.setDepartmentId(e.getDepartmentId());
		repository.save(existing);
		return existing;
	}
	@Override
	public String removeEmployee(int id) {
		repository.deleteById(id);
		return "Success";
		
	}
	@Override
	public List<Employee> getBySalaryRange(int s1, int s2) {
		List<Employee> emps=repository.findBySalaryBetween(s1,s2);
		return emps;
	}
	@Override
	public Employee employeeByName(String name) {
		return repository.findByFname(name);
	}
	@Override
	public List<Employee> employeeSalaryMoreThan(int salary) {
		return repository.findBySalaryGreaterThanEqual(salary);
	}

}
