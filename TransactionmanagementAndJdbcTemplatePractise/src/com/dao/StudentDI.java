package com.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.model.Student;

public class StudentDI extends JdbcDaoSupport implements IStudentDao {

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public Student addStudentDetails(Student student) {

		try {
			String SQL = "INSERT INTO Student (studentEmailId,studentFirstName,studentLastName ,studentPassword, studentPhoneNum) VALUES (?,?,?,?,?)";
			getJdbcTemplate().update(
					SQL,
					new Object[] { student.getStudentEmailId(),
							student.getStudentFirstName(),
							student.getStudentLastName(),
							student.getStudentPassword(),
							student.getStudentPhoneNum() });
			throw new RuntimeException("simulate Error condition");

		} catch (Exception e) {
			System.out.println("Error in creating record, rolling back");
			throw e;
		}
	}

	@Override
	public Student getStudent(int studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer studentId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Integer studentId, String name) {
		// TODO Auto-generated method stub

	}

}
