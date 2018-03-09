package com.library.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Category")
public class Category {

	@Id
	@GeneratedValue
	@Column(name = "categoryId", nullable = false, length = 10)
	@JsonIgnore
	private int id;

	@Column(name = "categoryName", length = 20, nullable = false)
	private String name;

	@JsonIgnore
	@OneToMany(mappedBy = "category")
	Set<Book> books;

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(int id, String name, Set<Book> books) {
		super();
		this.id = id;
		this.name = name;
		this.books = books;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
