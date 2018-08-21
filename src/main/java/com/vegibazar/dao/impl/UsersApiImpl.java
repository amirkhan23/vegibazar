package com.vegibazar.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vegibazar.dao.api.UsersAPI;
import com.vegibazar.dao.entity.Users;

@Repository
@Transactional
public class UsersApiImpl implements UsersAPI {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	public boolean addToUsers(Users users) {
		Session session = sessionFactory.openSession();

		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			session.save(users);
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
	public boolean updateToUsers(Users users) {
		try {
			Session session = sessionFactory.openSession();
			Transaction t = session.beginTransaction();
			session.update(users);
			t.commit();
			session.close();
			return true;
		} catch (Exception e) {
			System.out.println("Exception(ADD): " + e);
			return false;
		}
	}

}
