package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.model.Student;

@Repository
public class StudentDaoImp implements IStudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplateObject;

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public void setNamedParameterJdbcTemplate(
			NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public void setJdbcTemplateObject(JdbcTemplate jdbcTemplateObject) {
		this.jdbcTemplateObject = jdbcTemplateObject;
	}

	@Override
	public Student addStudentDetails(Student student) {
		String SQL = "INSERT INTO Student (studentEmailId,studentFirstName,studentLastName ,studentPassword, studentPhoneNum) VALUES (?,?,?,?,?)";
		jdbcTemplateObject.update(
				SQL,
				new Object[] { student.getStudentEmailId(),
						student.getStudentFirstName(),
						student.getStudentLastName(),
						student.getStudentPassword(),
						student.getStudentPhoneNum() });
		return student;
	}

	@Override
	public Student getStudent(int studentId) {
		String SQL = "SELECT * FROM Student WHERE studentId = :studentId";
		SqlParameterSource namedParameters = new MapSqlParameterSource(
				"studentId", Integer.valueOf(studentId));
		Student student = (Student) namedParameterJdbcTemplate.queryForObject(
				SQL, namedParameters, new BeanPropertyRowMapper(Student.class));
		return student;
	}

	@Override
	public void delete(Integer studentId) {
		String SQL = "DELETE FROM Student WHERE studentId = ?";
		jdbcTemplateObject.update(SQL, new Object[] { studentId });
		System.out.println("Deleted Record with studentId = " + studentId);
	}

	@Override
	public void update(Integer studentId, String name) {
		String SQL = "UPDATE Student SET studentFirstName = ? WHERE studentId = ?";
		jdbcTemplateObject.update(SQL, new Object[] { name, studentId });
		System.out.println("Updated Record with studentId = " + studentId);
	}
}
