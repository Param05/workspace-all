package com.library.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Loan")
public class Loan implements Serializable {

	private static final long serialVersionUID = -7891883660641615742L;
	@Id
	@GeneratedValue
	@Column(name = "loanId", nullable = false, length = 10)
	private int id;

	@ManyToOne
	@JoinColumn(name = "employeeId", nullable = false)
	private Employee employee;

	@ManyToOne
	@JoinColumn(name = "studentId", nullable = false)
	private Student student;

	@ManyToOne
	@JoinColumn(name = "bookId", nullable = false)
	private Book book;

	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@JsonIgnore
	@Column(name = "bookIssuedDate", nullable = true)
	private Date dateOfIssue;

	@Column(name = "isReturned", nullable = false)
	public boolean isReturned;

	public boolean isReturned() {
		return isReturned;
	}

	public void setReturned(boolean isReturned) {
		this.isReturned = isReturned;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateOfIssue() {
		return dateOfIssue;
	}

	public void setDateOfIssue(Date dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}
