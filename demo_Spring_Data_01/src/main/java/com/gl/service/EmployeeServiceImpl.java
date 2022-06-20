package com.gl.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl {

	@PersistenceContext
	EntityManager em;
	
	public void getNoOfEmployeesByDepartment()
	{
		Query query=em.createQuery("select count(e.id),e.departmentId "
				+ "from Employee e group by e.departmentId order by e.departmentId");
		List<Object[]> res=query.getResultList();
		for(Object obj[]:res)
			System.out.println("Department Id "+obj[1]+" has "+obj[0]+" Employees");
	}

	public void departmentWiseMaxSalary()
	{
		Query query=em.createQuery("select max(e.salary), e.departmentId "
				+ "from Employee e group by e.departmentId having e.departmentId in (20,40,90) order by e.departmentId desc");
		List<Object[]> res=query.getResultList();
		for(Object obj[]:res)
			System.out.println("Department Id "+obj[1]+" has Highest Salary as : "+obj[0]+" Employees");
	}
	
	public void updateDepartment(String name, int deptId)
	{
		Query query=em.createQuery
				("UPDATE Employee e SET e.departmentId=:id WHERE e.fname=:fname");
		query.setParameter("id", deptId);
		query.setParameter("fname", name);
		Integer ra=query.executeUpdate();
		if(ra>0)
			System.out.println("Record Updated successfully..");
		else
			System.out.println("Couldn't update the record.");
	}
	
}
