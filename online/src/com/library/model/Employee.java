package com.library.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7891883660641615742L;

	@Id
	@GeneratedValue
	@Column(name = "employeeId", nullable = false, length = 10)
	private int employeeId;

	@Column(name = "employeeEmailId", nullable = false, length = 10)
	private String employeeEmailId;

	@Column(name = "employeeFirstName", nullable = false, length = 20)
	private String employeeFirstName;

	@Column(name = "employeeLastName", nullable = false, length = 20)
	private String employeeLastName;

	@Column(name = "employeePassword", nullable = false, length = 20)
	private String employeePassword;

	@Column(name = "employeeRole", nullable = false, length = 10)
	private String employeeRole;

	@OneToMany(mappedBy = "employee")
	Set<Loan> loan;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeEmailId() {
		return employeeEmailId;
	}

	public void setEmployeeEmailId(String employeeEmailId) {
		this.employeeEmailId = employeeEmailId;
	}

	public String getEmployeeFirstName() {
		return employeeFirstName;
	}

	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}

	public String getEmployeeLastName() {
		return employeeLastName;
	}

	public void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
	}

	public String getEmployeePassword() {
		return employeePassword;
	}

	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}

	public String getEmployeeRole() {
		return employeeRole;
	}

	public void setEmployeeRole(String employeeRole) {
		this.employeeRole = employeeRole;
	}

}
