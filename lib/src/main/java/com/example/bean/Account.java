package com.example.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Account {
	
	@Id
	@GeneratedValue
	private int id;
	@Column(unique=true, nullable=false)
	private String email;
	private String password;
	
	@OneToOne(mappedBy="account")
	private Employee employee;
	
	// Constructors
	public Account() {}
	public Account(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public Account(String email, String password, Employee employee) {
		super();
		this.email = email;
		this.password = password;
		this.employee = employee;
	}
	
	// Getter & Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", email=" + email + ", password=" + password + "]";
	}

	
}