package com.library.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {

	@Id
	@GeneratedValue
	@Column(name = "studentId", nullable = false, length = 10)
	private int studentId;

	@Column(name = "studentEmailId", nullable = false, length = 20)
	private String studentEmailId;

	@Column(name = "studentFirstName", nullable = false, length = 20)
	private String studentFirstName;

	@Column(name = "studentLastName", nullable = false, length = 20)
	private String studentLastName;

	@Column(name = "studentPassword", nullable = false, length = 200)
	private String studentPassword;

	@Column(name = "studentPhoneNum", nullable = false, length = 10)
	private String studentPhoneNum;

	@OneToMany(mappedBy = "student")
	Set<Loan> loan;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentEmailId() {
		return studentEmailId;
	}

	public void setStudentEmailId(String studentEmailId) {
		this.studentEmailId = studentEmailId;
	}

	public String getStudentFirstName() {
		return studentFirstName;
	}

	public void setStudentFirstName(String studentFirstName) {
		this.studentFirstName = studentFirstName;
	}

	public String getStudentLastName() {
		return studentLastName;
	}

	public void setStudentLastName(String studentLastName) {
		this.studentLastName = studentLastName;
	}

	public String getStudentPassword() {
		return studentPassword;
	}

	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}

	public String getStudentPhoneNum() {
		return studentPhoneNum;
	}

	public void setStudentPhoneNum(String studentPhoneNum) {
		this.studentPhoneNum = studentPhoneNum;
	}

}
