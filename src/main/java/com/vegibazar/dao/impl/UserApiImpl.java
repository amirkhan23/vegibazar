package com.vegibazar.dao.impl;


import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vegibazar.dao.api.UserAPI;
import com.vegibazar.dao.entity.User;
import com.vegibazar.dao.model.Connect;


@Repository
@Transactional
public class UserApiImpl implements UserAPI {

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	Connect connect;
	List<User> list;

	

	@Override

	public boolean insertUser(User user) {
		Session session = sessionFactory.openSession();

		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			session.save(user);
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

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUser() {

		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		list = (List<User>) session.createQuery("FROM User").list();
		t.commit();
		session.close();
		return list;

	}

	@Override
	public boolean updateUserById(User user) {
		try {
			Session session = sessionFactory.openSession();
			Transaction t = session.beginTransaction();
			session.update(user);
			t.commit();
			session.close();
			return true;
		} catch (Exception e) {
			System.out.println("Exception(ADD): " + e);
			return false;
		}
	}

	@Override
	public boolean deleteUserById(User user) {
		try {
			Session session = sessionFactory.openSession();
			Transaction t = session.beginTransaction();
			session.delete(user);
			t.commit();
			session.close();
			return true;
		} catch (Exception e) {
			System.out.println("Exception(ADD): " + e);
			return false;
		}
	}

	@Override
	public User getUserById(int userId) {
		Session session = null;
        User user = null;
        try {
            session = sessionFactory.openSession();
            user =  (User) session.load(User.class,
                    userId);
            Hibernate.initialize(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return user;
		

	}

	
	@Override
	public User getUserByEmail(String email) {
		
		try {
			User user = new User();
			Statement st = connect.getStatement();
			ResultSet rs = st.executeQuery("select * from user where email='" + email + "'");
			while (rs.next()) {
				user.setName(rs.getString("name"));
				user.setGender(rs.getString("gender"));
				user.setDob(rs.getString("dob"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setUserId(rs.getInt("userId"));
				user.setContact(rs.getString("contact"));
				user.setAddress(rs.getString("address"));

			}
			return user;
		} catch (Exception exception) {

			exception.printStackTrace();
			return null;

		}
		
	}

}
