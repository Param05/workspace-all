package com.demo.secondlevelcache;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;

import com.demo.util.HibernateUtil;

public class HibernateEHCacheMain {
	public static void main(String[] args) {
		SessionFactory session = HibernateUtil.getSessionAnnotationFactory();
		Statistics statistics = session.getStatistics();

		System.out.println("stats" + statistics.isStatisticsEnabled());

		Session otherSession = session.openSession();
		statistics.setStatisticsEnabled(true);

		// Transaction otherTransaction = otherSession.beginTransaction();

		System.out.println("Fetch Count=" + statistics.getEntityFetchCount());

		System.out.println("Second Level Hit Count="
				+ statistics.getSecondLevelCacheHitCount());

		System.out.println("Second Level Miss Count="
				+ statistics.getSecondLevelCacheMissCount());

		Student student = (Student) otherSession.load(Student.class, 1);
		System.out.println(student.getStudentName());

		student = (Student) otherSession.load(Student.class, 1);
		System.out.println(student.getStudentName());

		// clear first level cache, so that second level cache is used
		otherSession.evict(student);

		Query query = otherSession
				.createQuery("update Student set studentName= :student_name where studentId= :id");
		query.setParameter("student_name", "Pankaj");
		query.setLong("id", 1);
		int result = query.executeUpdate();

		student = (Student) otherSession.load(Student.class, 1);
		System.out.println(student.getStudentName());

		student = (Student) otherSession.load(Student.class, 2);
		System.out.println(student.getStudentName());

		student = (Student) otherSession.load(Student.class, 1);
		System.out.println(student.getStudentName());

		session.close();

	}
}
