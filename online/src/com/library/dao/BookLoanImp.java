package com.library.dao;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Repository;

import com.library.constants.Master;
import com.library.exceptionHandling.GloabalExceptions;
import com.library.model.Book;
import com.library.model.Employee;
import com.library.model.Loan;
import com.library.model.Student;
@Repository
public class BookLoanImp implements IBookLoanDao {
	/*
	 * @Autowired SessionFactory sessionFactory;
	 */
	
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private MessageSource messageSource;

	@Override
	public boolean updateBookDetailsAsPerTheStudent(int studentId, int bookId)
			throws NoSuchMessageException, GloabalExceptions {

		Session session = sessionFactory.getCurrentSession();
		Loan loan = new Loan();
		Date date = new Date();
		boolean result = true;

		Book book = new Book();
		Student student = new Student();
		Employee employee = new Employee();

		Book book2 = (Book) session.get(Book.class, bookId);
		Student student2 = (Student) session.get(Student.class, studentId);

		if (student2 == null) {
			throw new GloabalExceptions(this.messageSource.getMessage("student.error.notfound", null, Locale.US));
		}
		if (book2 == null) {
			throw new GloabalExceptions(this.messageSource.getMessage("book.error.notfound", null, Locale.US));
		}
		int bookIssued = getAssignedBooksByPerStudent(studentId);
		if (bookIssued > 5) {
			throw new GloabalExceptions(this.messageSource.getMessage("book.error.morethanfive", null, Locale.US));
		}

		int numberofBooksAvailable = book2.getNoOfBooksAvailable() - 1;
		book2.setNoOfBooksAvailable(numberofBooksAvailable);
		Query query = session.createQuery(Master.UPDATE_NUMBER_OF_BOOKS);
		query.setParameter("numberOfBooksAvailable", numberofBooksAvailable);
		query.setParameter("bookId", bookId);
		query.executeUpdate();

		book.setBookId(bookId);
		student.setStudentId(studentId);
		employee.setEmployeeId(1);

		loan.setBook(book);
		loan.setStudent(student);
		loan.setDateOfIssue(date);
		loan.setEmployee(employee);
		loan.setReturned(false);
		session.save(loan);
		return result;
	}

	@Override
	public boolean updateUnAssignedBooks(int studentId, int bookId) throws NoSuchMessageException, GloabalExceptions {
		Session session = sessionFactory.getCurrentSession();

		boolean result = true;
		Book book2 = (Book) session.get(Book.class, bookId);
		Student student2 = (Student) session.get(Student.class, studentId);
		if (student2 == null) {
			throw new GloabalExceptions(this.messageSource.getMessage("student.error.notfound", null, Locale.US));
		}
		if (book2 == null) {
			throw new GloabalExceptions(this.messageSource.getMessage("book.error.notfound", null, Locale.US));
		}

		Query query = session.createQuery(Master.UN_ASSIGNED_BOOK_TO_STUDENT);
		query.setParameter("isReturned", true);
		query.setParameter("studentId", studentId);
		query.setParameter("bookId", bookId);
		query.executeUpdate();

		int numberofBooksAvailable = book2.getNoOfBooksAvailable() + 1;
		query = session.createQuery(Master.UPDATE_NUMBER_OF_BOOKS);
		query.setParameter("numberOfBooksAvailable", numberofBooksAvailable);
		query.setParameter("bookId", bookId);
		query.executeUpdate();
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Loan> getBooksPerStudent(int studentId) throws NoSuchMessageException, GloabalExceptions {

		Session session = sessionFactory.getCurrentSession();
		Student student2 = (Student) session.get(Student.class, studentId);
		if (student2 == null) {
			throw new GloabalExceptions(this.messageSource.getMessage("student.error.notfound", null, Locale.US));
		} else {
			Query query = session.createQuery(Master.GET_BOOKSBOOKSASSIGNED_PER_STUDENT);
			query.setParameter("studentId", studentId);
			return query.list();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> getAssignedAndUnAssignedBooks() {
		Session session = sessionFactory.getCurrentSession();
		Criteria bookCriteria = session.createCriteria(Book.class, "book").createAlias("book.loan", "bl")
				.createAlias("book.category", "bookcategory").createAlias("book.bookPublisherID", "bookpublisher")
				.add(Restrictions.eq("bl.isReturned", false));

		List<Book> bookList = bookCriteria.list();
		return bookList;
	}

	public int getAssignedBooksByPerStudent(final int studentId) {
		Session session = sessionFactory.getCurrentSession();
		/*
		 * Query query =
		 * session.createQuery(Master.COUNT_OF_BOOKS_ISSUED_PER_STUDENT);
		 * query.setParameter("studentId", studentId);
		 * query.setParameter("notReturned", false); Long count = (Long)
		 * query.list().get(0);
		 */
		Criteria criteria = session.createCriteria(Loan.class, "loan");
		criteria.add(Restrictions.eq("loan.student.studentId", studentId));
		criteria.add(Restrictions.eq("loan.isReturned", false));
		criteria.setProjection(Projections.rowCount());
		System.out.println(criteria);
		Long count = (Long) criteria.list().get(0);
		System.out.println(count);

		return count.intValue();

	}
}
