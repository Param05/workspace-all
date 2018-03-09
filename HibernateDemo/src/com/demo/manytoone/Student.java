package com.demo.manytoone;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue
	@Column(name = "student_id")
	private int studentId;

	@Column(name = "student_name", nullable = false, length = 100)
	private String studentName;

	@ManyToOne(cascade = CascadeType.ALL)
	private Address addresses;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Address getAddresses() {
		return addresses;
	}

	public void setAddresses(Address addresses) {
		this.addresses = addresses;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String studentName, Address address1) {
		super();
		this.studentName = studentName;
		this.addresses = address1;
	}
}
