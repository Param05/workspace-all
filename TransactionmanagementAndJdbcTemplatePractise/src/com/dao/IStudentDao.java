package com.dao;

import com.model.Student;

public interface IStudentDao {
	public Student addStudentDetails(Student student);

	Student getStudent(int studentId);

	public void delete(Integer studentId);


	void update(Integer studentId, String name);
}
