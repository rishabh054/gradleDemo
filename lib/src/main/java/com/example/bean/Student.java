package com.example.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	@GeneratedValue
	private int roll;
	private String name;
	private String fname;
	private String mname;
	
	public Student() {}
	
	public Student(int roll, String name, String fname, String mname) {
		super();
		this.roll = roll;
		this.name = name;
		this.fname = fname;
		this.mname = mname;
	}
	
	
	
	public Student(String name, String fname, String mname) {
		super();
		this.name = name;
		this.fname = fname;
		this.mname = mname;
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	@Override
	public String toString() {
		return "Student [roll=" + roll + ", name=" + name + ", fname=" + fname + ", mname=" + mname + "]";
	}
	
	
	
	
	

}
