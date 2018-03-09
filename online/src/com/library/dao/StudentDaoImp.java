package com.library.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.library.constants.Master;
import com.library.model.Student;

@Repository
public class StudentDaoImp implements IStudentDao {

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	@Override
	public Student checkLogin(Student student) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(Master.LOGIN_STUDENT);
		query.setParameter(0, student.getStudentEmailId());
		@SuppressWarnings("unchecked")
		List<Student> list = query.list();

		if ((list != null) && (list.size() > 0)) {
			student = list.get(0);
		}

		return student;
	}

	@Override
	public Student addStudentDetails(Student student) {

		Session session = sessionFactory.openSession();
		student.getStudentPassword();
		student.setStudentPassword(bcryptEncoder.encode(student.getStudentPassword()));
		session.save(student);
		return student;
	}
}
