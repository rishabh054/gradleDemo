/*
 * JPA - Java Persistance API - specifcations
 *  Implementation - Object Relational Mapping(ORM) tools
 *    Hibernate 
 *    iBatis
 *    TopLink
 *    ORMLite
 *    
 *   -  helps to map Object state to database column
 *   
 */
package com.example.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.example.bean.Address;
import com.example.bean.Employee;

public class EmployeeRepositoryImpl implements IEmployeeRepository {
	
			
	@Override
	public Employee addEmployee(Employee employee) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		EntityManager em= emf.createEntityManager();
		
		em.getTransaction().begin();
		
		
		em.persist(employee);
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return employee;
		
	}

	@Override
	public Employee deleteEmployeeById(int empId) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		EntityManager em= emf.createEntityManager();
		
		em.getTransaction().begin();
		
		// Get emp by id
		
		Employee emp= em.find(Employee.class, empId);
		
		// remove employee
		if(emp!=null) {
			em.remove(emp);
		}
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		return emp;
	}

	@Override
	public Employee deleteEmployeeByName(String empName) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		EntityManager em= emf.createEntityManager();
		
		em.getTransaction().begin();
		// Get emp by id
		Employee e = (Employee)em.createQuery("select e from Employee e where e.name=:name").setParameter("name", empName).getSingleResult();
						
		if(e!=null) {
			System.out.println("inside if stmt");
			Query q = em.createQuery("delete from Employee e where e.name=:name");
			q.setParameter("name", empName );
			q.executeUpdate();
		}
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return e;
	}

	@Override
	public Employee deleteEmployee(Employee employee) {

		return null;
	}

	@Override
	public Employee updateEmployee(int empId, Employee employee) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		EntityManager em= emf.createEntityManager();
		
		em.getTransaction().begin();
		
		// Get emp by id
		Employee dbEmp= em.find(Employee.class, empId);
		
		// Update employee
		dbEmp.setName(employee.getName());
		dbEmp.setDesignation(employee.getDesignation());
		dbEmp.setSalary(employee.getSalary());
		dbEmp.setSkills(employee.getSkills());
		
		// save employee with updated details
		em.merge(dbEmp);
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return dbEmp;
		
	}

	@Override
	public List<Employee> getEmployeeByName(String empName) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		EntityManager em= emf.createEntityManager();
				
		// Get emp by name
		//Employee emp= em.find(Employee.class, empName);
		Query q = em.createQuery("select e from Employee e where e.name=:name"); // JPQL Query
		q.setParameter("name", empName);
		
		List<Employee> empList = q.getResultList();
		
		em.close();
		emf.close();
	
		return empList;
		
		
	}

	@Override
	public Employee getEmployeeById(int empId) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		EntityManager em= emf.createEntityManager();
		
		// Get emp by id
		Employee emp= em.find(Employee.class, empId);
		
		em.close();
		emf.close();
		
		return emp;
		
	}

	@Override
	public List<Employee> getAllEmployee() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		EntityManager em= emf.createEntityManager();
		
		//sql query - select * from employee;
		List<Employee> empList= em.createQuery("select e from Employee e").getResultList();
		
		em.close();
		emf.close();
		
		return empList;
	}

	@Override
	public String geEmpEmail(int eId2) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		EntityManager em= emf.createEntityManager();
		
		// Get email using emp id
		Query query = em.createQuery("select a.email from Employee e join e.account a where e.id=:id");//JPQL
		query.setParameter("id", eId2);
				
		// Execute query
		String email = (String)query.getSingleResult();
		
		return email;
	}

	@Override
	public List<Address> getAddressesByEmpId(int eId) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		EntityManager em= emf.createEntityManager();
		System.out.println(eId);
		//select addr.city, addr.state from Employee e join e.address addr where e.id=:id;
		Query query = em.createQuery("select a from Employee e join e.address a where e.id=:id");
		query.setParameter("id", eId);
		//System.out.println(query.getSingleResult());
		List<Address> addr = query.getResultList();
		System.out.println(addr);
		return addr;
	}

}