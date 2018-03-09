package com.model;

public class Student {

	private int studentId;

	private String studentEmailId;

	private String studentFirstName;

	private String studentLastName;

	private String studentPassword;

	private String studentPhoneNum;

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

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentEmailId="
				+ studentEmailId + ", studentFirstName=" + studentFirstName
				+ ", studentLastName=" + studentLastName + ", studentPassword="
				+ studentPassword + ", studentPhoneNum=" + studentPhoneNum
				+ "]";
	}

}
