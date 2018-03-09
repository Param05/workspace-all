package com.bankapp.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class UserRole {

	@Override
	public String toString() {
		return "UserRole [userRoleId=" + userRoleId + ", role=" + role + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userRoleId")
	private int userRoleId;

	public UserRole() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String role;

	@ManyToOne
	private User user;

	public UserRole(int userRoleId, String role) {
		super();
		this.userRoleId = userRoleId;
		this.role = role;
	}

	public int getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
