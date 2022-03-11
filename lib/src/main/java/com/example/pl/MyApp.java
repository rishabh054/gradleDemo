/*
 * Relationships
 *  OneToOne
 *  OneToMany
 *  ManyToOne
 *  ManyToMany
 *  
 *  Employee & Department
 *  One Employee One Depart - OneToOne - ManyToOne
 *  One Department Many Employees - OneToMany
 *  
 *  
 *  Employee & Account - OneToOne
 *  One Employee One Account
 *  One Account One Employee
 *  
 *   Employee & Address 
 *   One Employee - Many Addresses - OneToMany
 *   One Address - One Employee  - ManyToOne
 *   
 *   
 *   Employee & Profile - OneToOne
 *   One Employee - One Profile
 *   One Profile - One Employee
 *   
 *   Employee & Skills - ManyToMany
 *   One Employee - Many Skills 
 *   One Skill - Many Employees 
 *   
 *   Author & Book - ManyToMany - New table will be created to keep mapping information
 *   One Author - Many Book
 *   One Book - Many Author 
 *   
 *  Directions
 *   Unidirectional
 *   Bidirectional 
 *   
 *  
 *  
 *  
 */
package com.example.pl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.bean.Account;
import com.example.bean.Address;
import com.example.bean.Employee;
import com.example.bean.Skill;
import com.example.service.EmployeeServiceImpl;
import com.example.service.IEmployeeService;
import com.example.service.ISkillService;
import com.example.service.SkillServiceImpl;

public class MyApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int id = 1000;
		
		IEmployeeService empServ = new EmployeeServiceImpl();
		ISkillService skillServ = new SkillServiceImpl();

		System.out.println("Select option from below: ");
		System.out.println("1. Add Employee");
		System.out.println("2. Update Employee");
		System.out.println("3. Delete Employee By Id");
		System.out.println("4. Search Employee By Id");
		System.out.println("5. Search Employee By Name");
		System.out.println("6. Get All Employees");
		System.out.println("7. Delete Employee By Name");
		System.out.println("8. Delete Employee By Employee Obj");
		System.out.println("9. Get emp mail address");
		System.out.println("10. Get Address details");
		System.out.println("11. Add Skill");
		System.out.println("12. Get Skill By Id");
		
		
		int selectedOption = sc.nextInt();
		
		// byte, short, int, String, Enum, Wrapper objects
		switch(selectedOption) {
		case 1:
			System.out.println("Enter employee name");
			String empName = sc.next();
			System.out.println("Enter employee salary");
			double empSalary = sc.nextDouble();
			System.out.println("Enter employee designation");
			String empDesignation = sc.next();
			
			// Get Account details
			System.out.println("Enter email address");
			String email = sc.next();
			System.out.println("Enter password");
			String password = sc.next();
			
			// Create Account obj
			Account account = new Account(email, password);
			
			// Get Address details
			System.out.println("Enter 1st city");
			String city1 = sc.next();
			System.out.println("Enter 1st state");
			String state1 = sc.next();
			Address addr1 = new Address(city1, state1);
			
			System.out.println("Enter 2nd city");
			String city2 = sc.next();
			System.out.println("Enter 2nd state");
			String state2 = sc.next();
			Address addr2 = new Address(city2, state2);
			
			List<Address> addrList = new ArrayList<>();
			addrList.add(addr1);
			addrList.add(addr2);
	
			
			
			// create emp obj and update properties using constructor
//			Employee emp = new Employee(++id, empName, empSalary, empDesignation);
//			System.out.println(emp);
//			Employee newEmp = empServ.addEmployee(emp);
//			System.out.println("Added "+newEmp.getName()+" successfully!");
		
			// Create emp obj and update properties using setter methods
			Employee emp = new Employee();
			emp.setName(empName);
			emp.setSalary(empSalary);
			emp.setDesignation(empDesignation);
			emp.setAccount(account);
			emp.setAddress(addrList);
			
			
			// Add emp in the db.
			Employee newEmp = empServ.addEmployee(emp);
			System.out.println(newEmp);
			System.out.println("Added "+newEmp.getName()+" successfully!");	
			
			break;
		case 2:
			// get input from user
			System.out.println("Enter employee id");
			int eId = sc.nextInt();
			System.out.println("Enter employee name");
			String eName = sc.next();
			System.out.println("Enter employee salary");
			double eSalary = sc.nextDouble();
			System.out.println("Enter employee designation");
			String eDesignation = sc.next();
			
			System.out.println("Enter number of skills to be added");
			int noOfSkills = sc.nextInt();
			
			List<Skill> skills = new ArrayList<>();
			for(int i=0; i<noOfSkills;i++) {;//2
				System.out.println("Enter Skill id"); //16- Java
				int skillId= sc.nextInt();
				Skill skill= skillServ.getSkillById(skillId);
				skills.add(skill);
			}
		
			// create emp 
			Employee updateEmp = new Employee();
			
			// Update emp details
			updateEmp.setName(eName);
			updateEmp.setSalary(eSalary);
			updateEmp.setDesignation(eDesignation);
			updateEmp.setSkills(skills);
			
			// call service method to update emp details
			Employee uEmp= empServ.updateEmployee(eId, updateEmp);
			System.out.println(uEmp);
			
			break;
		
		case 3:
			System.out.println("Enter employee id to delete");
			int dEmpId= sc.nextInt();
			Employee deletedEmp = empServ.deleteEmployeeById(dEmpId);
			System.out.println("Deleted "+deletedEmp.getName()+" successfully!");
			break;
		
		case 4:
			// search emp based on id
			System.out.println("Enter employee id");
			int searchId = sc.nextInt();
			Employee searchEmp = empServ.getEmployeeById(searchId);
			System.out.println(searchEmp);
			
			break;
		
		case 5:
			System.out.println("Enter employee name to search");
			String searchName= sc.next();
			List<Employee> sEmp = empServ.getEmployeeByName(searchName);
			System.out.println(sEmp);
			break;
		
		case 6:
			// Get all employees
			List<Employee> empList = empServ.getAllEmployees();
			System.out.println(empList);
			for(Employee e:empList) {
				System.out.println(e);
			}
			break;
		
		case 7:
			System.out.println("Enter employee name to delete");
			String e = sc.next();
			Employee emp1 = empServ.deleteEmployeeByName(e);
			System.out.println(emp1.getName()+" deleted successfully!");
			break;
			
		case 8:
			break;
		case 9:
			// get email using emp id
			System.out.println("Enter emp id");
			int eId2= sc.nextInt();
			String email1 = empServ.getEmpEmail(eId2);
			System.out.println(email1);
			
			break;
		case 10:
			// Get address details
			System.out.println("Enter emp id");
			int empId2= sc.nextInt();
			List<Address> addresses= empServ.getAddressesByEmpId(empId2);
			for(Address addr: addresses) {
				System.out.println(addr);
			}
			break;
		case 11:
			// add skill
			System.out.println("Enter skill name");
			String skillName = sc.next();
			Skill skill = new Skill(skillName);
			Skill newSkill = skillServ.addSkill(skill);
			System.out.println(newSkill.getName()+" added successfully!" );
			break;
		case 12:
			// Get skill by id
			System.out.println("Enter skill id");
			int skillId = sc.nextInt();
			Skill skill1 = skillServ.getSkillById(skillId);
			System.out.println(skill1);
			break;
		default:
				System.out.println("Enter any number between 1-8");
		
		}
		
	}

}