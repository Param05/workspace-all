package com.bankapp.user.model;

import java.util.HashSet;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQuery;


@NamedQuery(name = "findUserByUsername", query = "from User s where s.username = :username")
@Entity
@Table(name = "user")
public class User {

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username
				+ ", password=" + password + ", userRole=" + userRole + "]";
	}

	public User(int user_id, String username, String password,
			Set<UserRole> userRole) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.userRole = userRole;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int user_id;
	private String username;
	private String password;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private Set<UserRole> userRole = new HashSet<UserRole>();

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<UserRole> getUserRole() {
		return userRole;
	}

	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}

}
