package com.library.responsebean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.library.model.Loan;

public class LoanResponse {
	private int isbn;
	private String name;
	private String category;
	private String publisherName;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private Date dateOfIssue;

	public int getIsbn() {
		return isbn;
	}

	public LoanResponse(Loan loan) {
		super();
		this.isbn = loan.getBook().getBookId();
		this.name = loan.getBook().getBookName();
		this.category = loan.getBook().getCategory().getName();
		this.publisherName = loan.getBook().getBookPublisherID().getPublisherName();
		this.dateOfIssue = loan.getDateOfIssue();
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public Date getDateOfIssue() {
		return dateOfIssue;
	}

	public void setDateOfIssue(Date dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

}
