
package com.example.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="emp")
public class Employee {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private Double salary;
	@Column(name="design")
	private String designation;
	@Column(name="scheme")
	private String insuranceScheme;
	
	// OneToOne
	@OneToOne
	@JoinColumn(name="accountId")
	private Account account;
	
	// OneToMany
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="addressId")
	private List<Address> address;
	
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(
        name = "employee_skills", 
        joinColumns = { @JoinColumn(name = "emp_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "skill_id") }
    )
	private List<Skill> skills;
	
	// Constructors
	public Employee() {}
	public Employee(int id, String name, Double salary, String designation) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.designation = designation;
		
	}
	
		
	public Employee(String name, Double salary, String designation, String insuranceScheme, Account account,
			List<Address> address, List<Skill> skills) {
		super();
		this.name = name;
		this.salary = salary;
		this.designation = designation;
		this.insuranceScheme = insuranceScheme;
		this.account = account;
		this.address = address;
		this.skills = skills;
	}
	public Employee(String name, Double salary, String designation, Account account) {
		super();
		this.name = name;
		this.salary = salary;
		this.designation = designation;
		this.account = account;
	}	
	
	public Employee(String name, Double salary, String designation, String insuranceScheme, Account account,
			List<Address> address) {
		super();
		this.name = name;
		this.salary = salary;
		this.designation = designation;
		this.insuranceScheme = insuranceScheme;
		this.account = account;
		this.address = address;
	}
	
	// Getter & Setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getInsuranceScheme() {
		return insuranceScheme;
	}
	public void setInsuranceScheme(String insuranceScheme) {
		this.insuranceScheme = insuranceScheme;
	}
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	
	public List<Skill> getSkills() {
		return skills;
	}
	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", designation=" + designation
				+ ", insuranceScheme=" + insuranceScheme + "]";
	}
	
	
	

}