package com.library.dao;

import com.library.model.Student;

public interface IStudentDao {

	public Student checkLogin(Student student);

	public Student addStudentDetails(Student student);

}
