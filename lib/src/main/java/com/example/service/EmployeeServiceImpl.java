package com.example.service;

import java.util.List;

import com.example.bean.Address;
import com.example.bean.Employee;
import com.example.bean.Skill;
import com.example.repository.AccountRepositoryImpl;
import com.example.repository.AddressRepositoryImpl;
import com.example.repository.EmployeeRepositoryImpl;
import com.example.repository.IAccountRepository;
import com.example.repository.IAddressRepository;
import com.example.repository.IEmployeeRepository;
import com.example.repository.ISkillRepository;
import com.example.repository.SkillRepositoryImpl;

public class EmployeeServiceImpl implements IEmployeeService {
	
	IEmployeeRepository empRepo = new EmployeeRepositoryImpl();
	IAccountRepository accRepo = new AccountRepositoryImpl();
	IAddressRepository addrRepo = new AddressRepositoryImpl();
	ISkillRepository skillRepo = new SkillRepositoryImpl();

	@Override
	public Employee addEmployee(Employee employee) {
		List<Address> addresses= employee.getAddress();
		for(Address addr: addresses) {
			addrRepo.addAddress(addr);
		}
		List<Skill> skills= employee.getSkills();
		for(Skill skill: skills) {
			skillRepo.addSkill(skill);
		}
		accRepo.addAccount(employee.getAccount());
		return empRepo.addEmployee(employee);
	}

	@Override
	public Employee deleteEmployeeById(int empId) {
		return empRepo.deleteEmployeeById(empId);
	}

	@Override
	public Employee deleteEmployeeByName(String name) {
		
		return empRepo.deleteEmployeeByName(name);
	}

	@Override
	public Employee deleteEmployee(Employee employee) {
		
		return null;
	}

	@Override
	public Employee updateEmployee(int empId, Employee employee) {
			
		Employee emp = empRepo.updateEmployee(empId, employee);	
		
		return emp;
	}

	@Override
	public List<Employee> getEmployeeByName(String name) {
		return empRepo.getEmployeeByName(name);
	}

	@Override
	public Employee getEmployeeById(int empId) {
		Employee emp = empRepo.getEmployeeById(empId);
		return emp;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> empList= empRepo.getAllEmployee();
		return empList;
	}

	@Override
	public String getEmpEmail(int eId2) {
		
		return empRepo.geEmpEmail(eId2);
	}

	@Override
	public List<Address> getAddressesByEmpId(int eId) {
		
		return empRepo.getAddressesByEmpId(eId);
	}

}