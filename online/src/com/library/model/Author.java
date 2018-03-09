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
@Table(name = "Author")
public class Author {
	@Id
	@GeneratedValue
	@Column(name = "authorId", nullable = false, length = 10)
	private int authorId;

	@Column(name = "authorFirstName", nullable = false, length = 20)
	private String authorFirstName;

	@Column(name = "authorSecondName", nullable = false, length = 20)
	@JsonIgnore
	private String authorSecondName;

	@Column(name = "authorPenName", nullable = false, length = 20)
	@JsonIgnore
	private String authorPenName;

	@Column(name = "authorEmail", nullable = false, length = 20)
	@JsonIgnore
	private String authorEmail;

	@JsonIgnore
	@OneToMany(mappedBy = "author")
	private Set<Book> books;

	public Author() {
		super();
	}

	public Author(int authorId, String authorFirstName, String authorSecondName, String authorPenName,
			String authorEmail, Set<Book> books) {
		super();
		this.authorId = authorId;
		this.authorFirstName = authorFirstName;
		this.authorSecondName = authorSecondName;
		this.authorPenName = authorPenName;
		this.authorEmail = authorEmail;
		this.books = books;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getAuthorFirstName() {
		return authorFirstName;
	}

	public void setAuthorFirstName(String authorFirstName) {
		this.authorFirstName = authorFirstName;
	}

	public String getAuthorSecondName() {
		return authorSecondName;
	}

	public void setAuthorSecondName(String authorSecondName) {
		this.authorSecondName = authorSecondName;
	}

	public String getAuthorPenName() {
		return authorPenName;
	}

	public void setAuthorPenName(String authorPenName) {
		this.authorPenName = authorPenName;
	}

	public String getAuthorEmail() {
		return authorEmail;
	}

	public void setAuthorEmail(String authorEmail) {
		this.authorEmail = authorEmail;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

}
