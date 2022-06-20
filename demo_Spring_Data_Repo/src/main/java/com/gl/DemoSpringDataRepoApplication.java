package com.gl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gl.entity.Employee;
import com.gl.service.EmployeeService;

@SpringBootApplication
// Acting as User-Interface
public class DemoSpringDataRepoApplication implements CommandLineRunner{

	@Autowired EmployeeService service;
	public static void main(String[] args) {
		SpringApplication.run(DemoSpringDataRepoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		 * List<Employee> emps=service.getAllEmployee(); for(Employee e:emps)
		 * System.out.println(e);
		 */
		
		//System.out.println(service.getByID(120));
		
		  /*Employee e1=new Employee(240, "Uttam",45000, 30); Employee
		  added=service.addEmployee(e1); System.out.println(added);*/
		 
		/*
		 * Employee e1=new Employee(240, "Uttam Patel",67000, 90); Employee
		 * updated=service.updateEmployee(e1, 240); System.out.println(updated);
		 */
		
		/*
		 * String res=service.removeEmployee(240); if(res.equals("Success"))
		 * System.out.println("Record Deleted Successfully.."); else
		 * System.out.println("Record Couldn't deleted..");
		 */
		  
		/*
		 * List<Employee> emps=service.getBySalaryRange(15000, 25000);
		 * System.out.println(emps);
		 * System.out.println("-----------------------------------------"); Employee
		 * e=service.employeeByName("Uttam"); System.out.println(e);
		 */
		
		  List<Employee> employees=service.employeeSalaryMoreThan(18000);
		  System.out.println(employees);
		
	}

}
