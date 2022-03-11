package com.example.service;

import java.util.List;

import com.example.bean.Student;

public interface IStudentService {
	
	Student addStudent(Student student);
	Student getStudentByRoll(int roll);
	Student getStudentbyName(String name);
	Student deleteStudentbyRoll(int roll);
	Student deleteStudentName(String name);
	Student updateStudent(int roll,Student student);
	List<Student> getAllStudent();

}
