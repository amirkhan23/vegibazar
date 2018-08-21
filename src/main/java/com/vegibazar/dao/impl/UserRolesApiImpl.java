package com.vegibazar.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vegibazar.dao.api.UserRolesAPI;
import com.vegibazar.dao.entity.UserRoles;

@Repository
@Transactional
public class UserRolesApiImpl implements UserRolesAPI {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean setRole(UserRoles userRoles) {
		Session session = sessionFactory.openSession();

		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			session.save(userRoles);
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
	public boolean updateRole(UserRoles userRoles) {
		try {
			Session session = sessionFactory.openSession();
			Transaction t = session.beginTransaction();
			session.update(userRoles);
			t.commit();
			session.close();
			return true;
		} catch (Exception e) {
			System.out.println("Exception(ADD): " + e);
			return false;
		}
	}

}
