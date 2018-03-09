package com.library.service;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.library.dao.IStudentDao;
import com.library.exceptionHandling.GloabalExceptions;
import com.library.model.Student;

@Service
public class StudentServiceImp implements IStudentService {

	@Autowired
	private IStudentDao studentDao;

	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	@Autowired
	private MessageSource messageSource;

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@Override
	public boolean checkLogin(Student student) throws GloabalExceptions {
		Student studentFromDatabase;
		boolean result = false;
		if (student.getStudentEmailId() == null || student.getStudentPassword() == null
				|| student.getStudentEmailId().equals("") || student.getStudentPassword().equals("")) {
			throw new GloabalExceptions(this.messageSource.getMessage("blankUserName", null, Locale.US));
		}

		studentFromDatabase = studentDao.checkLogin(student);
		if (studentFromDatabase == null) {
			throw new GloabalExceptions(this.messageSource.getMessage("emailId", null, Locale.US));
		} else {
			if (bcryptEncoder.matches(student.getStudentPassword(), studentFromDatabase.getStudentPassword())) {
				result = true;
			} else {
				result = false;
				throw new GloabalExceptions(this.messageSource.getMessage("password", null, Locale.US));
			}
		}
		return result;
	}

	@Override
	public Student addStudent(Student student) {

		return studentDao.addStudentDetails(student);
	}
}
