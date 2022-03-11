package com.example.service;

import java.util.List;

import com.example.bean.Student;
import com.example.repository.IStudentRepository;
import com.example.repository.StudentRepository;

public class StudentServiceImpl implements IStudentService {
	
	IStudentRepository studrepo = new StudentRepository();

	@Override
	public Student addStudent(Student student) {
		Student newstud = studrepo.addStudent(student);
		return newstud;
	}

	@Override
	public Student getStudentByRoll(int roll) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student getStudentbyName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student deleteStudentbyRoll(int roll) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student deleteStudentName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student updateStudent(int roll, Student student) {
		Student updateStudent= studrepo.updateStudent(roll, student);
		return updateStudent;
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return null;
	}

}
