package com.library.constants;

public interface Master {
	String FETCH_BOOKS = "from Book WHERE author.authorId= :authorid";

	String LOGIN_STUDENT = "from Student as o where o.studentEmailId=?";

	String COUNT_NUMBER_OF_BOOKS = "SELECT sum(E.noOfBooksAvailable) FROM Book E where author.authorId=:authorId";

	String GET_ALL_AUTHROID = "from Book";

	/*
	 * String COUNT_OF_BOOKS_ISSUED_PER_STUDENT =
	 * "select count(*) from Loan loan" +
	 * " where loan.student.studentId=:studentId and loan.isReturned=:notReturned"
	 * ;
	 */

	String UN_ASSIGNED_BOOK_TO_STUDENT = "UPDATE Loan loan set isReturned = :isReturned "
			+ "WHERE loan.student.studentId= :studentId and loan.book.bookId=:bookId";

	String UPDATE_NUMBER_OF_BOOKS = "UPDATE Book book set noOfBooksAvailable= :numberOfBooksAvailable "
			+ "WHERE book.bookId= :bookId ";

	String BOOKS_ASSIGNED_AND_UNASSIGNED_RESPONSE = "from Book";

	/*
	 * String GET_BOOKSBOOKSASSIGNED_PER_STUDENT = "select" + " book.bookId," +
	 * "book.bookName," + "book.category.name," +
	 * "book.bookPublisherID.publisherName," + "loan.dateOfIssue from " +
	 * "Loan loan " + "where loan.student.studentId=:studentId";
	 */

	String GET_BOOKSBOOKSASSIGNED_PER_STUDENT = "FROM Loan loan where loan.student.studentId=:studentId";

	String BORROWED_BOOKS = "from Loan";

}
