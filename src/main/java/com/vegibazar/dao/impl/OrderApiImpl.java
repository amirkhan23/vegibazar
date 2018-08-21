package com.vegibazar.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vegibazar.dao.api.OrderAPI;
import com.vegibazar.dao.entity.Order;
import com.vegibazar.dao.model.Connect;
import com.vegibazar.dao.service.ProductService;

@Repository
@Transactional
public class OrderApiImpl implements OrderAPI {

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	Connect connect;
	@Autowired
	ProductService pService;
	List<Order> list;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean saveOrder(Order order) {
		Session session = sessionFactory.openSession();

		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			session.save(order);
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
	public boolean cancelOrder(int oId) {
		
		Statement st = connect.getStatement();
		String sql = "update DetailsOfOrder set orderCancel=1 where oId='" + oId + "'";
		boolean a = false;
		try {
			a = st.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return a;
	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getAllOrder() {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		list = (List<Order>) session.createQuery("FROM Order").list();
		t.commit();
		session.close();
		return list;
	}

	@Override
	public List<Order> getAllOrderByEmail(int uId) {

		List<Order> list1 = new ArrayList<Order>();
		String sql = "select * from DetailsOfOrder where uId='" + uId + "' AND orderCancel=0 ";
		try {
			Statement ps = connect.getStatement();
			ResultSet rs = ps.executeQuery(sql);
			System.out.println(rs);
			while (rs.next()) {
				Order order = new Order();
				order.setoId(rs.getInt(1));
				order.setDeliveryAddress(rs.getString(2));
				order.setOrderCancel(rs.getInt(3));
				System.out.println(rs.getInt(3));
				order.setOrderDate(rs.getString(4));
				order.setpId(rs.getInt(5));
				order.setQty(rs.getInt(6));
				order.setStatus(rs.getString(7));
				order.setTotalAmt(rs.getDouble(8));
				order.setuId(rs.getInt(9));
				System.out.println(order);
				list1.add(order);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list1;
	}
}
