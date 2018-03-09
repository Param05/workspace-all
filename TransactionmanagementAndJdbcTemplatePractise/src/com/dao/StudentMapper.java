package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.model.Student;

public class StudentMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student();
		student.setStudentEmailId(rs.getString("studentEmailId"));
		student.setStudentFirstName(student.getStudentFirstName());
		student.setStudentLastName(student.getStudentLastName());
		return student;
	}

}
