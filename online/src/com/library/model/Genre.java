package com.library.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Genre")
public class Genre {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "genreId", nullable = false, length = 10)
	private int genreId;

	@Column(name = "genreName", nullable = false, length = 10)
	private String genreName;

	@JsonIgnore
	@OneToMany(mappedBy = "genre")
	Set<Book> books;

	public int getGenreId() {
		return genreId;
	}

	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

}
