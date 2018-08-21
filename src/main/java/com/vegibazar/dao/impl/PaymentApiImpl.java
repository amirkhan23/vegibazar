package com.vegibazar.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vegibazar.dao.api.PaymentAPI;
import com.vegibazar.dao.entity.Payment;

@Repository
@Transactional
public class PaymentApiImpl implements PaymentAPI{

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	public boolean addPayment(Payment payment) {
		Session session = sessionFactory.openSession();

		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			session.save(payment);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}

}
