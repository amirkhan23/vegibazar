package com.vegibazar.controllers;

import java.security.Principal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vegibazar.dao.entity.Feedback;
import com.vegibazar.dao.entity.Product;
import com.vegibazar.dao.entity.User;
import com.vegibazar.dao.entity.UserRoles;
import com.vegibazar.dao.entity.Users;
import com.vegibazar.dao.model.Connect;
import com.vegibazar.dao.service.FeedbackService;
import com.vegibazar.dao.service.ProductService;
import com.vegibazar.dao.service.UserRolesService;
import com.vegibazar.dao.service.UserService;
import com.vegibazar.dao.service.UsersService;

@Controller
public class BaseController {

	@Autowired
	UserService service;
	@Autowired
	FeedbackService fService;
	@Autowired
	UsersService uService;
	@Autowired
	UserRolesService urService;
	@Autowired
	ProductService pService;
	@Autowired
	Connect connect;
	@Autowired
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@RequestMapping("/")
	public ModelAndView getIndexPage() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("user", new User());
		return mv;
	}

	@RequestMapping("/registration")
	public ModelAndView getRegisterPage(HttpServletResponse response) {
		ModelAndView model = new ModelAndView("registration");
		User user = new User();
		user.setGender("Male");
		model.addObject("user", user);
		return model;
	}

	@RequestMapping("/logfail")
	public ModelAndView getFail(HttpServletResponse response) {
		ModelAndView model = new ModelAndView("login");
		
		model.addObject("msg","Input correct Email And Password ");
		return model;
	}

	@RequestMapping("/index/logout")
	public ModelAndView getlogout(HttpServletRequest request) {

		try {

			request.logout();
		} catch (ServletException e) {
			System.out.println("did not logout");
			e.printStackTrace();
		}

		ModelAndView mv = new ModelAndView("index");
		return mv;
	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public ModelAndView getSaveUser(@Valid @ModelAttribute("user") User user, BindingResult res) {

		if (res.hasErrors()) {
			ModelAndView mv = new ModelAndView("registration");
			return mv;
		} else {

			boolean bool = service.insertUser(user);
			if (bool) {

				Users users = new Users();
				users.setEnabled(1);
				users.setUserEmail(user.getEmail());
				users.setPassword(user.getPassword());
				uService.addToUsers(users);
				UserRoles userRoles = new UserRoles();
				userRoles.setUserEmail(user.getEmail());
				userRoles.setRole("ROLE_USER");
				urService.setRole(userRoles);
				ModelAndView mv = new ModelAndView("login");
				mv.addObject("msg", "Add Successfully in database");
				return mv;
			} else {
				ModelAndView mv = new ModelAndView("registration");
				mv.addObject("msg", "Dulicate email");
				mv.addObject("user", new User());
				return mv;
			}

		}

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView getLoginPage() {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}

	@RequestMapping(value = "/index/profile", method = RequestMethod.GET)
	public ModelAndView printWelcome(ModelMap model, Principal principal) {

		ModelAndView mv = new ModelAndView("profile");
		String email = principal.getName();

		
		User u = null;
		
		try {

			u = service.getUserByEmail(email);

		} catch (Exception e) {
			e.printStackTrace();

		}
		
		System.out.println(u.getEmail());
		System.out.println(u.getUserId());
		System.out.println(email);
		model.addAttribute("user",u);
		return mv;

	}

	@RequestMapping(value = "/index/updateUser", method = RequestMethod.POST)
	public ModelAndView getUpdateUser(@ModelAttribute("user") User user, BindingResult res, Principal principal) {
		if (res.hasErrors()) {
			ModelAndView mv = new ModelAndView("home");
			return mv;
		} else {

			boolean bool = service.updateUserById(user);
			if (bool) {
				Users users = new Users();
				users.setEnabled(1);
				users.setUserEmail(user.getEmail());
				users.setPassword(user.getPassword());
				uService.updateToUsers(users);
				UserRoles userRoles = new UserRoles();
				userRoles.setUserEmail(user.getEmail());
				userRoles.setRole("ROLE_USER");
				urService.updateRole(userRoles);

				ModelAndView mv = new ModelAndView("profile");
				String email = principal.getName();
				User u = null;
				try {

					u = service.getUserByEmail(email);

				} catch (HibernateException e) {
					e.printStackTrace();

				}
               
				System.out.println(email);
				mv.addObject("user", u);
				mv.addObject("msg", "Update Successfully in database");
				return mv;
			} else {
				ModelAndView mv = new ModelAndView("profile");
				String email = principal.getName();

				
				User u = null;
				try {

					u = service.getUserByEmail(email);

				} catch (HibernateException e) {
					e.printStackTrace();

				}
                  
				System.out.println(email);
				mv.addObject("user", u);

				mv.addObject("msg", "Not Update Successful please fill gender");
				return mv;
			}

		}

	}

	@RequestMapping("/index/home")
	public ModelAndView getHome(HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("list", pService.getAllProduct());
		return mv;
	}
	@RequestMapping("/index/feedback")
	public ModelAndView getFeedback(HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("feedback");
		mv.addObject("feedback", new Feedback());
		return mv;
	}
	@RequestMapping(value = "/index/addFeedback", method = RequestMethod.POST)
	public ModelAndView getAddFeedBack(@Valid @ModelAttribute("feedback") Feedback feedback, BindingResult res) {

		if (res.hasErrors()) {
			ModelAndView mv = new ModelAndView("home");
			return mv;
		} else {
            if(!feedback.getEmail().isEmpty()){
			boolean bool = fService.addFeedback(feedback);
			if (bool) {
				ModelAndView mv = new ModelAndView("feedback");
				mv.addObject("msg", "Add Successfully in database");
				mv.addObject("feedback", new Feedback());
				mv.addObject("feed", feedback);
				return mv;
			} else {
				ModelAndView mv = new ModelAndView("feedback");
				mv.addObject("msg", "Retry Again");
				mv.addObject("feedback", new Feedback());
				return mv;
			}
			
            }
            else {
            	ModelAndView mv = new ModelAndView("feedback");
				mv.addObject("msg", "Retry Again");
				mv.addObject("feedback", new Feedback());
				return mv;
			}
            
            
            

		}
	}

	

	@Transactional
	@RequestMapping(value = "/index/searchProduct", method = RequestMethod.GET)
	public ModelAndView getSearchProduct(HttpServletRequest request, HttpServletResponse response) {
		String pName = request.getParameter("pName");
		Product product = null;
		List<Product> list = null;
		String sql = "select * from Product where pName='" + pName + "'";
		try {
			Statement ps = connect.getStatement();

			ResultSet rs = ps.executeQuery(sql);
			System.out.println(rs);
			if (rs.next()) {
				product = new Product();
				list = new ArrayList<Product>();
				product.setpId(rs.getInt(1));
				product.setpName(rs.getString(2));
				product.setpPrice(rs.getString(3));
				product.setStock(rs.getString(4));
				System.out.println(product);
				list.add(product);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		 
		
		

		ModelAndView mv = new ModelAndView("searchProduct");
		mv.addObject("list", list);
		
		return mv;

	}

}
