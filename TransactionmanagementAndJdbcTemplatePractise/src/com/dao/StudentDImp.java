package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.model.Student;

public class StudentDImp extends JdbcDaoSupport implements IStudentDao {

	@Autowired
	private PlatformTransactionManager transactionManager;

	public void setTransactionManager(
			PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	@Override
	public Student addStudentDetails(Student student) {

		TransactionDefinition def = new DefaultTransactionDefinition();
		((DefaultTransactionDefinition) def)
				.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		TransactionStatus status = transactionManager.getTransaction(def);

		try {
			String SQL = "INSERT INTO Student (studentEmailId,studentFirstName,studentLastName ,studentPassword, studentPhoneNum) VALUES (?,?,?,?,?)";
			getJdbcTemplate().update(
					SQL,
					new Object[] { student.getStudentEmailId(),
							student.getStudentFirstName(),
							student.getStudentLastName(),
							student.getStudentPassword(),
							student.getStudentPhoneNum() });
			transactionManager.commit(status);
			throw new RuntimeException("simulate Error condition");

		} catch (Exception e) {
			System.out.println("Error in creating record, rolling back");
			transactionManager.rollback(status);
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