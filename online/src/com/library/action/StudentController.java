package com.library.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.library.exceptionHandling.GloabalExceptions;
import com.library.model.Student;
import com.library.service.IStudentService;

@RestController
public class StudentController {

	@Autowired
	private IStudentService iStudentService;

	@RequestMapping(value = "/api/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> validateUser(@RequestBody Student student, Errors errors) throws GloabalExceptions {
		ResponseEntity<Student> result = null;
		if (iStudentService.checkLogin(student)) {
			result = new ResponseEntity<Student>(HttpStatus.OK);
		}
		return result;

	}

	@RequestMapping(value = "/api/addStudent", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		Student studentAdded = iStudentService.addStudent(student);
		return new ResponseEntity<Student>(studentAdded, HttpStatus.CREATED);
	}

}
