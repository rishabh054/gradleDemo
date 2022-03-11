package com.example.repository;

import java.util.List;

import com.example.bean.Address;
import com.example.bean.Employee;

public interface IEmployeeRepository {
	Employee addEmployee(Employee employee);
	Employee deleteEmployeeById(int empId);
	Employee deleteEmployeeByName(String name);
	Employee deleteEmployee(Employee employee);
	Employee updateEmployee(int empId, Employee employee);
	List<Employee> getEmployeeByName(String name);
	Employee getEmployeeById(int empId);
	List<Employee> getAllEmployee();
	String geEmpEmail(int eId2);
	List<Address> getAddressesByEmpId(int eId);

}