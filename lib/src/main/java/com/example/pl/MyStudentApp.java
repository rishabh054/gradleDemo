package com.example.pl;

import java.util.Scanner;

import com.example.bean.Student;
import com.example.service.IStudentService;
import com.example.service.StudentServiceImpl;

public class MyStudentApp {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int roll=1;
		
		IStudentService studSer=new StudentServiceImpl();
		
		System.out.println("Select option from below: ");
		System.out.println("1. Add Student");
		System.out.println("2. Update Student");
		System.out.println("3. Delete Student By Id");
		System.out.println("4. Search Student By Id");
		System.out.println("5. Search Student By Name");
		System.out.println("6. Get All Students");
		System.out.println("7. Delete Student By Name");
		
		
		int selectedOption = sc.nextInt();
		
		switch(selectedOption) {
		case 1: 
			System.out.println("Roll No will Be Auto generate\n");
			System.out.println("Enter Name");
			String name= sc.next();
			System.out.println("Enter Father Name");
			String fname= sc.next();
			System.out.println("Enter Mother Name");
			String mname= sc.next();
			Student student =new Student(name,fname,mname);
			System.out.println(student);
			Student newstud = studSer.addStudent(student);
			System.out.println("Added "+ newstud.getName() +" Successfully");
			break;
		case 2: 
			System.out.println("Enter student roll");
			int sRoll = sc.nextInt();
			System.out.println("Enter student name");
			String sName = sc.next();
			System.out.println("Enter student mother name");
			String sMname = sc.next();
			System.out.println("Enter student father name");
			String sFname = sc.next();
			
			Student updateStudent = new Student();
			updateStudent.setRoll(sRoll);
			updateStudent.setName(sName);
			updateStudent.setMname(sMname);
			updateStudent.setFname(sFname);
			
			Student upStudent= studSer.updateStudent(sRoll, updateStudent);
			System.out.println(upStudent);
			
			break;
		case 3: 
			break;
		case 4: 
			break;
		case 5: 
			break;
		case 6: 
			break;
		case 7: 
			break;
		default:
			System.out.println("Please Enter valid number between 1-7");
		}

	}

}
