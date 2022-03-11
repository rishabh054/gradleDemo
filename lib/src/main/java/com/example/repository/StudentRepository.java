package com.example.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.bean.Employee;
import com.example.bean.Student;

public class StudentRepository implements IStudentRepository {

	@Override
	public Student addStudent(Student student) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		EntityManager em= emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(student);
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return student;
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
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		EntityManager em= emf.createEntityManager();
		
		em.getTransaction().begin();
		
		// Get Student by roll
		Student dbStud= em.find(Student.class, roll);
		
		// Update student
		dbStud.setName(student.getName());
		dbStud.setMname(student.getMname());;
		dbStud.setFname(student.getFname());
		
		// save Student with updated details
		em.merge(dbStud);
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return dbStud;
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return null;
	}

}
