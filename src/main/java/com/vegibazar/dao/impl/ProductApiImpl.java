package com.vegibazar.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.DistinctRootEntityResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vegibazar.dao.api.ProductAPI;
import com.vegibazar.dao.entity.Product;
import com.vegibazar.dao.entity.User;

@Repository
@Transactional
public class ProductApiImpl implements ProductAPI {

	@Autowired
	SessionFactory sessionFactory;
	List<Product> p;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public List<Product> getAllProducts() {

		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		p = (List<Product>) session.createQuery("FROM Product").list();
		t.commit();
		session.close();
		return p;
	}

	public boolean addProduct(Product product) {
		try {
			Session session = sessionFactory.openSession();
			Transaction t = session.beginTransaction();
			session.save(product);
			t.commit();
			session.close();
			return true;
		} catch (Exception e) {
			System.out.println("Exception(ADD): " + e);
			return false;
		}
	}

	public boolean deleteProduct(Product product) {
		try {
			Session session = sessionFactory.openSession();
			Transaction t = session.beginTransaction();
			session.delete(product);
			t.commit();
			session.close();
			return true;
		} catch (Exception e) {
			System.out.println("Exception(ADD): " + e);
			return false;
		}
	}

	public boolean updateProduct(Product product) {
		try {
			Session session = sessionFactory.openSession();
			Transaction t = session.beginTransaction();
			session.update(product);
			t.commit();
			session.close();
			return true;
		} catch (Exception e) {
			System.out.println("Exception(ADD): " + e);
			return false;
		}
	}

	@Override
	public Product getProductById(int pId) {
		Session session = null;
		Product user = null;
		try {
			session = sessionFactory.openSession();
			user = (Product) session.load(Product.class, pId);
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getProductByName(String name) {
		List<Product> results = null;
		try {
			Session session = sessionFactory.openSession();
			Criteria crit = session.createCriteria(User.class);
			@SuppressWarnings("unused")
			Criterion details = Restrictions.idEq(name);
			crit.setResultTransformer(DistinctRootEntityResultTransformer.INSTANCE);
			results = crit.list();

		} catch (HibernateException e) {
			e.printStackTrace();

		}
		return results;
	}

}
