package com.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.IStudentDao;
import com.model.Student;

public class StudentDetails {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"spring.xml");
		IStudentDao dao = (IStudentDao) applicationContext
				.getBean("employeeDaoImpl");

		Student student = new Student();
		student.setStudentEmailId("aman@gmail.com");
		student.setStudentFirstName("parampreet");
		student.setStudentLastName("preet");
		student.setStudentPassword("12345678");
		student.setStudentPhoneNum("111");

		dao.addStudentDetails(student);

		// dao.update(2, "P");
		// Student employee = dao.getStudent(2);
		// System.out.print(employee);

	}
}
