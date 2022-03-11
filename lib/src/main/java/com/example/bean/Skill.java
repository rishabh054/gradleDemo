package com.example.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Skill {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	
	@ManyToMany(mappedBy="skills")
	private List<Employee> employees;
	
	// Constructors
	public Skill() {}
	public Skill(String name) {
		super();
		this.name = name;
	}
	
	
	public Skill(String name, List<Employee> employees) {
		super();
		this.name = name;
		this.employees = employees;
	}
	// Getters & Setters
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
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	@Override
	public String toString() {
		return "Skills [id=" + id + ", name=" + name + "]";
	}
	
	
	
	

}