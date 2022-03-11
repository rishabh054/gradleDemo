package com.example.repository;

import java.util.List;

import com.example.bean.Student;

public interface IStudentRepository {

	Student addStudent(Student student);
	Student getStudentByRoll(int roll);
	Student getStudentbyName(String name);
	Student deleteStudentbyRoll(int roll);
	Student deleteStudentName(String name);
	Student updateStudent(int roll,Student student);
	List<Student> getAllStudent();
	
}
