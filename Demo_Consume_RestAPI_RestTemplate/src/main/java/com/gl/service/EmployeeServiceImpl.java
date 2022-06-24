package com.gl.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.dto.EmployeeDTO;
import com.gl.entity.Employee;
import com.gl.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired EmployeeRepository repository;
	@Override
	public EmployeeDTO getEmployeeDetails(int id)throws Exception {
	
		Optional<Employee> res=repository.findById(id);
		Employee e=res.orElseThrow(()-> new Exception("The Provided Id Does Not Exists"));
		
		EmployeeDTO emp=new EmployeeDTO();
		emp.setId(e.getId());
		emp.setFname(e.getFname());
		emp.setSalary(e.getSalary());
		emp.setDepartmentId(e.getDepartmentId());
		
		return emp;
	}
	@Override
	public List<EmployeeDTO> getAllEmployees() {
		Iterable<Employee> result=repository.findAll();
		
		List<EmployeeDTO> employees=new ArrayList<EmployeeDTO>();
		
		result.forEach(emp ->{
			EmployeeDTO employeeDTO=new EmployeeDTO();
			employeeDTO.setId(emp.getId());
			employeeDTO.setFname(emp.getFname());
			employeeDTO.setSalary(emp.getSalary());
			employeeDTO.setDepartmentId(emp.getDepartmentId());
			
			employees.add(employeeDTO);
		});
		return employees;
	}
	@Override
	public Employee addEmployee(Employee e) {
		return repository.save(e);
	}
	@Override
	public String updateEmployeeDetails(int id, Employee e) {
	
		Employee existingEmp=repository.findById(id).get();
		existingEmp.setDepartmentId(e.getDepartmentId());
		existingEmp.setFname(e.getFname());
		existingEmp.setSalary(e.getSalary());
		repository.save(existingEmp);
		return "Success";
	}
	@Override
	public String removeEmployeeDetails(int id) {
		repository.deleteById(id);
		return "Success";
	}

}
