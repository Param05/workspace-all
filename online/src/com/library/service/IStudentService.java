package com.library.service;

import com.library.exceptionHandling.GloabalExceptions;
import com.library.model.Student;

public interface IStudentService {
	public boolean checkLogin(Student student) throws GloabalExceptions;

	public Student addStudent(Student student);
}
