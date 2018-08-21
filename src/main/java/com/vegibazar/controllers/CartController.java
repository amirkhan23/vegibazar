package com.vegibazar.controllers;

import java.security.Principal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vegibazar.dao.entity.Cart;
import com.vegibazar.dao.entity.Order;
import com.vegibazar.dao.entity.Payment;
import com.vegibazar.dao.entity.Product;
import com.vegibazar.dao.entity.User;
import com.vegibazar.dao.model.Connect;
import com.vegibazar.dao.service.CartService;
import com.vegibazar.dao.service.OrderService;
import com.vegibazar.dao.service.PaymentService;
import com.vegibazar.dao.service.ProductService;
import com.vegibazar.dao.service.UserService;

@Controller
public class CartController {

	@Autowired
	CartService cService;
	@Autowired
	ProductService pService;
	@Autowired
	Connect connect;
	@Autowired
	UserService service;
	@Autowired
	OrderService oService;
	@Autowired
	PaymentService ps;

	@RequestMapping(value = "/index/addCart")
	public ModelAndView getCart(HttpServletRequest request, Principal principal) {
		String id = request.getParameter("pId");
		String email = principal.getName();
		int pId = Integer.parseInt(id);
		System.out.println(pId);
		System.out.println(email);
		Cart cart = new Cart();
		cart.setEmail(email);
		cart.setpId(pId);
		cService.addCart(cart);

		Product p = pService.getProductById(pId);

		System.out.println(p.getpName());

		ModelAndView mv = new ModelAndView("home");
		mv.addObject("list", pService.getAllProduct());
		return mv;
	}

	@RequestMapping("/index/cart")
	public ModelAndView getHome(HttpServletResponse response, Principal principal) {
		ModelAndView mv = new ModelAndView("cart");
		String email = principal.getName();
		List<Cart> list1 = new ArrayList<Cart>();
		List<Product> list2 = new ArrayList<Product>();
		String sql = "select * from cart where email='" + email + "'";
		try {
			Statement ps = connect.getStatement();
			ResultSet rs = ps.executeQuery(sql);
			System.out.println(rs);
			while (rs.next()) {
				Cart cart = new Cart();
				cart.setCartId(rs.getInt(1));
				cart.setEmail(rs.getString(2));
				cart.setpId(rs.getInt(3));
				System.out.println(cart);
				list1.add(cart);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		for (Cart cart : list1) {
			Product p = pService.getProductById(cart.getpId());
			list2.add(p);
		}

		mv.addObject("list", list2);

		return mv;
	}

	@RequestMapping(value = "/index/removeCart")
	public ModelAndView getRemoveCart(HttpServletRequest request, Principal principal) {
		String id = request.getParameter("pId");
		String email = principal.getName();
		int pId = Integer.parseInt(id);
		System.out.println(pId);
		System.out.println(email);
		String sql = "select * from cart where pId='" + pId + "' AND email='"+email+"' ";
		try {
			Statement ps = connect.getStatement();
			ResultSet rs = ps.executeQuery(sql);
			System.out.println(rs);
			if (rs.next()) {
				Cart cart = new Cart();
				cart.setCartId(rs.getInt(1));
				cart.setEmail(rs.getString(2));
				cart.setpId(rs.getInt(3));
				System.out.println(cart);
				cService.removeCart(cart);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ModelAndView mv = new ModelAndView("cart");
		List<Cart> list1 = new ArrayList<Cart>();
		List<Product> list2 = new ArrayList<Product>();
		String sql1 = "select * from cart where email='" + email + "'";
		try {
			Statement ps = connect.getStatement();
			ResultSet rs = ps.executeQuery(sql1);
			System.out.println(rs);
			while (rs.next()) {
				Cart cart = new Cart();
				cart.setCartId(rs.getInt(1));
				cart.setEmail(rs.getString(2));
				cart.setpId(rs.getInt(3));
				System.out.println(cart);
				list1.add(cart);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		for (Cart cart : list1) {
			Product p = pService.getProductById(cart.getpId());
			list2.add(p);
		}

		mv.addObject("list", list2);
		return mv;
	}

	@RequestMapping("/index/order")
	public ModelAndView getOrderPage(HttpServletRequest request, Principal principal) {
		String email = principal.getName();
		String id = request.getParameter("pId");
		int pId = Integer.parseInt(id);
		Product product = pService.getProductById(pId);
		String p = product.getpPrice();
		int price = Integer.parseInt(p);
		User user = service.getUserByEmail(email);
		int uId = user.getUserId();
		int qty = 1;
		double amt = qty * price;

		// String totalAmount = ""+amt;
		System.out.println(amt);
		// DateAndTime date = new DateAndTime();

		Order o = new Order();
		o.setOrderCancel(0);
		o.setpId(pId);
		o.setuId(uId);
		o.setQty(qty);
		o.setTotalAmt(amt);
		o.setStatus("Processing");
		Date date = new Date();
		Date date1 = new Date();
		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
		// sdf.format(date);
		// sdf1.format(date1);
		String orderDate = "" + sdf.format(date) + sdf1.format(date1);
		o.setOrderDate(orderDate);
		o.setDeliveryAddress(user.getAddress());

		ModelAndView mv = new ModelAndView("order");
		mv.addObject("order", o);
		mv.addObject("product", product);

		return mv;
	}

	@RequestMapping(value = "/index/addOrder", method = RequestMethod.POST)
	public ModelAndView getAddOder(Order order, Principal principal) {
		// String email = principal.getName();
		// User user = service.getUserByEmail(email);
		// int uId = user.getUserId();
		// List<Order> list1 = oService.getAllOrderByEmail(uId);
		ModelAndView mv = new ModelAndView("orderSummary");
		oService.saveOrder(order);
		mv.addObject("msg", "Order Success");
		mv.addObject("list", order);
		return mv;

	}

	@RequestMapping(value = "/index/myOrder")
	public ModelAndView getMyOder(Principal principal) {
		String email = principal.getName();
		User user = service.getUserByEmail(email);
		int uId = user.getUserId();
		List<Order> list1 = oService.getAllOrderByEmail(uId);
		ModelAndView mv = new ModelAndView("myOrder");
		mv.addObject("list", list1);
		return mv;

	}

	@RequestMapping("/index/cancelOrder")
	public ModelAndView deleteOrder(HttpServletRequest request, Principal principal) {
		String id = request.getParameter("oId");
		int oId = Integer.parseInt(id);
		oService.cancelOrder(oId);
		String email = principal.getName();
		User user = service.getUserByEmail(email);
		int uId = user.getUserId();
		List<Order> list1 = oService.getAllOrderByEmail(uId);
		ModelAndView mv = new ModelAndView("myOrder");
		mv.addObject("list", list1);
		mv.addObject("msg", "Cancel Order");
		return mv;

	}

	@RequestMapping(value = "/index/payment/{pId}/{uId}/{oId}/{totalAmt}")
	public ModelAndView getPayment(HttpServletRequest request, @PathVariable("pId") int pId,
			@PathVariable("uId") int uId, @PathVariable("totalAmt") int totalAmt, @PathVariable("oId") int oId) {

		Payment p = new Payment();
		Date date = new Date();
		Date date1 = new Date();
		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
		String payDate = "" + sdf.format(date) + sdf1.format(date1);

		p.setBillAmt(totalAmt);
		p.setPaydate(payDate);
		p.setpId(pId);
		p.setuId(uId);
		p.setoId(oId);

		ps.addPayment(p);

		ModelAndView mv = new ModelAndView("bill");
		mv.addObject("list", p);
		return mv;

	}

}
