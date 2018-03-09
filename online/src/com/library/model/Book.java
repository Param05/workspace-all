package com.library.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "isbn", nullable = false, length = 10)
	private int bookId;

	@Column(name = "noOfBooksAvailable", nullable = false, length = 10)
	private int noOfBooksAvailable;

	@Column(name = "bookName", nullable = false, length = 100)
	private String bookName;

	@Column(name = "bookedision", nullable = false, length = 10)
	private int edision;

	@ManyToOne
	@JoinColumn(name = "publisherId", nullable = false)
	private Publisher bookPublisherID;

	@ManyToOne
	@JoinColumn(name = "categoryId", nullable = false)
	private Category category;

	@ManyToOne
	@JoinColumn(name = "authorId", nullable = false)
	private Author author;

	@ManyToOne
	@JoinColumn(name = "genreId", nullable = false)
	private Genre genre;

	@JsonIgnore
	@OneToMany(mappedBy = "book")
	private Set<Loan> loan;

	private transient int numberOfBooksIssued;

	public int getNumberOfBooksIssued() {
		return numberOfBooksIssued;
	}

	public void setNumberOfBooksIssued(int numberOfBooksIssued) {
		this.numberOfBooksIssued = numberOfBooksIssued;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public Book(int bookId, int noOfBooksAvailable, String bookName, int edision, Publisher bookPublisherID,
			Category category, Author author, Set<Loan> loan) {
		super();
		this.bookId = bookId;
		this.noOfBooksAvailable = noOfBooksAvailable;
		this.bookName = bookName;
		this.edision = edision;
		this.bookPublisherID = bookPublisherID;
		this.category = category;
		this.author = author;
		this.loan = loan;
	}

	public int getNoOfBooksAvailable() {
		return noOfBooksAvailable;
	}

	public void setNoOfBooksAvailable(int noOfBooksAvailable) {
		this.noOfBooksAvailable = noOfBooksAvailable;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getEdision() {
		return edision;
	}

	public void setEdision(int edision) {
		this.edision = edision;
	}

	public Publisher getBookPublisherID() {
		return bookPublisherID;
	}

	public void setBookPublisherID(Publisher bookPublisherID) {
		this.bookPublisherID = bookPublisherID;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;

	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Set<Loan> getLoan() {
		return loan;
	}

	public void setLoan(Set<Loan> loan) {
		this.loan = loan;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", noOfBooksAvailable=" + noOfBooksAvailable + ", bookName=" + bookName
				+ ", edision=" + edision + ", bookPublisherID=" + bookPublisherID + ", category=" + category
				+ ", author=" + author + ", genre=" + genre + ", loan=" + loan + ", getNumberOfBooksIssued()="
				+ getNumberOfBooksIssued() + ", getBookId()=" + getBookId() + ", getNoOfBooksAvailable()="
				+ getNoOfBooksAvailable() + ", getBookName()=" + getBookName() + ", getEdision()=" + getEdision()
				+ ", getBookPublisherID()=" + getBookPublisherID() + ", getCategory()=" + getCategory()
				+ ", getAuthor()=" + getAuthor() + ", getLoan()=" + getLoan() + "]";
	}

}
