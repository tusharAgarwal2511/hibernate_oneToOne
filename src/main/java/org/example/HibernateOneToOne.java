package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateOneToOne {
	public static void main(String[] args) {

		Configuration c = new Configuration();

		SessionFactory sf = c.configure("hbm.cfg.xml").buildSessionFactory();

		System.out.println(sf);

		Session session = sf.openSession();
		System.out.println("SESSION STARTED: " + session);
		Transaction tx = session.beginTransaction();

		CustomerTransaction customerTransaction = new CustomerTransaction();

		customerTransaction.setTotal(100);

		Customer customer = new Customer();
		customer.setName("Tushar");
		customer.setAddress("India");
		customer.setEmail("tushar@gmail.com");

		customerTransaction.setCustomer(customer);

		customer.setTransaction(customerTransaction);

		session.save(customerTransaction);

		session.flush();

		tx.commit();

	}
}