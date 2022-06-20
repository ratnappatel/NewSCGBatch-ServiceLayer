package com.gl.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gl.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

	public List<Employee> findBySalaryBetween(int salary1,int salary2);
	public Employee findByFname(String name);
	public List<Employee> findBySalaryGreaterThanEqual(int salary);
}
