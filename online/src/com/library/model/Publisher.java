package com.library.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Publisher")
public class Publisher {

	@Id
	@GeneratedValue
	@JsonIgnore
	@Column(name = "id", nullable = false, length = 10)
	private int id;

	@Column(name = "publisherName", nullable = false, length = 10)
	private String publisherName;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@JsonIgnore
	@Column(name = "createdDate", nullable = true)
	private Date date;

	@JsonIgnore
	@OneToMany(mappedBy = "bookPublisherID")
	Set<Book> books;

	public Publisher() {
		super();
	}

	public Publisher(int id, String publisherName, Date date, Set<Book> books) {
		super();
		this.id = id;
		this.publisherName = publisherName;
		this.date = date;
		this.books = books;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
