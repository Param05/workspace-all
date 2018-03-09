package com.demo.onetomany;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.demo.util.HibernateUtil;

public class NativeSqlExample {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionAnnotationFactory()
				.openSession();
		Transaction tx = session.beginTransaction();
	/*	SQLQuery query = session
				.createSQLQuery(
						"select {e.*}, {a.*} from Student e join Address a ON e.emp_id=a.emp_id")
				.addEntity("e", Student.class).addJoin("a", "e.address");*/
		 SQLQuery query = session.createSQLQuery("select * from Student"); 

		List<Object[]> rows = query.list();
		for (Object[] row : rows) {
			Student student = new Student();
			student.setStudentName(row[1].toString());
			System.out.println(student);
		}
	}
}
