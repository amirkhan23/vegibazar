package com.vegibazar.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vegibazar.dao.api.FeedbackAPI;
import com.vegibazar.dao.entity.Feedback;

@Repository
@Transactional
public class FeedbackApiImpl implements FeedbackAPI {

	@Autowired
	private SessionFactory sessionFactory;
	List<Feedback> list;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Feedback> getAllFeedbak() {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		list = (List<Feedback>) session.createQuery("FROM Feedback").list();
		t.commit();
		session.close();
		return list;
	}

	@Override
	public boolean addFeedback(Feedback feedback) {
		Session session = sessionFactory.openSession();

		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			session.save(feedback);
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

	@Override
	public boolean deleteFeedback(Feedback feedback) {
		try {
			Session session = sessionFactory.openSession();
			Transaction t = session.beginTransaction();
			session.delete(feedback);
			t.commit();
			session.close();
			return true;
		} catch (Exception e) {
			System.out.println("Exception(ADD): " + e);
			return false;
		}
	}

	@Override
	public boolean updateFeedback(Feedback feedback) {
		try {
			Session session = sessionFactory.openSession();
			Transaction t = session.beginTransaction();
			session.update(feedback);
			t.commit();
			session.close();
			return true;
		} catch (Exception e) {
			System.out.println("Exception(ADD): " + e);
			return false;
		}
	}

}
