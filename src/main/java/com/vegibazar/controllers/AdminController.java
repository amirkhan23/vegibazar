package com.vegibazar.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.vegibazar.dao.entity.Feedback;
import com.vegibazar.dao.entity.Product;
import com.vegibazar.dao.service.FeedbackService;
import com.vegibazar.dao.service.OrderService;
import com.vegibazar.dao.service.ProductService;
import com.vegibazar.dao.service.UserService;

@Controller
public class AdminController {

	@Autowired
	UserService service;
	@Autowired
	ProductService pService;
	@Autowired
	ServletContext context;
	@Autowired
	OrderService oai;
	@Autowired
	FeedbackService fai;
	@Autowired
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@RequestMapping("/admin/adminHome")
	public ModelAndView getAdminHomePage(HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("adminHome");
		mv.addObject("product", new Product());
		return mv;
	}

	@RequestMapping("/admin/viewUser")
	public ModelAndView getListOfUsersPage(HttpServletResponse response) {

		ModelAndView mv = new ModelAndView("allUser");
		mv.addObject("product", new Product());
		mv.addObject("list", service.getAllUser());
		return mv;
	}

	@RequestMapping("/admin/viewProduct")
	public ModelAndView getListOfProductPage(HttpServletResponse response, HttpServletRequest request) {

		ModelAndView mv = new ModelAndView("product");
		mv.addObject("list", pService.getAllProduct());
		return mv;
	}

	@RequestMapping("/admin/addProduct")
	public ModelAndView getAddProductPage(HttpServletResponse response) {

		ModelAndView mv = new ModelAndView("addProduct");
		mv.addObject("list", pService.getAllProduct());
		mv.addObject("product", new Product());
		return mv;
	}

	@RequestMapping(value = "admin/saveProduct", method = RequestMethod.POST)
	public ModelAndView fileUpload(@Valid @ModelAttribute("product") Product product, BindingResult result,
			ModelMap model, HttpServletRequest request) throws IOException {
		ModelAndView mv = new ModelAndView("addProduct");
		boolean res = false;
		if (result.hasErrors()) {
			System.out.println("validation errors");
			mv.addObject("product", new Product());
			mv.addObject("msg", "un upload");
			return mv;
		} else {
			try {
				res = pService.addProduct(product);
			} catch (Exception e) {
				System.out.println(e);
			}

			context = request.getServletContext();
			if (res) {

				String imagePath = "C:/project/vegibazar/src/main/webapp/resources/images/" + product.getpName()
						+ ".jpg";

				System.out.println(imagePath);
				MultipartFile m = product.getImg();
				System.out.println(m);

				File dir = new File(imagePath);

				if (!m.isEmpty()) {
					try {

						byte[] bytes = product.getImg().getBytes();
						BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(dir));
						stream.write(bytes);
						stream.close();
						System.out.println("Image uploaded");
						System.out.println("Data Inserted");

						mv.addObject("product", new Product());
						mv.addObject("msg", "Upload Image Sucessfully");
						mv.addObject("list", pService.getAllProduct());
						return mv;

					} catch (Exception ex) {
						System.out.println(ex.getMessage());
					}

				}

			} else {
				mv.addObject("duplicate", "Duplicate Name");
				mv.addObject("list", pService.getAllProduct());
				return mv;
			}

		}

		mv.addObject("product", new Product());
		mv.addObject("msg", "Un Upload Image Sucessfully");
		mv.addObject("list", pService.getAllProduct());
		return mv;
	}

	@RequestMapping("/admin/deleteProduct")
	public ModelAndView deleteProduct(@ModelAttribute("product") Product product, BindingResult result,
			ModelMap model) {
		boolean res = pService.deleteProduct(product);
		if (res) {
			
			String imagePath = "C:/project/vegibazar/src/main/webapp/resources/images/" + product.getpName()
			+ ".jpg";
			File dir = new File(imagePath);
			dir.delete();
			
			ModelAndView mv = new ModelAndView("addProduct");
			mv.addObject("list", pService.getAllProduct());
			mv.addObject("delete", "Delete sucessfully");
			return mv;
		} else {
			ModelAndView mv = new ModelAndView("addProduct");
			mv.addObject("list", pService.getAllProduct());
			mv.addObject("delete", "Delete Unsucessfully");
			return mv;
		}

	}

	@RequestMapping("/admin/updateProduct")
	public ModelAndView updateProduct(@ModelAttribute("product") Product product, BindingResult result,
			ModelMap model) {
		boolean res = false;
		try {
			System.out.println(product.getpId());
			System.out.println(product.getpName());
			System.out.println(product.getpPrice());
			System.out.println(product.getpPrice());
			res = pService.updateProduct(product);
		} catch (Exception e) {
			System.out.println(e);
		}
		if (res) {
			ModelAndView mv = new ModelAndView("product");
			mv.addObject("list", pService.getAllProduct());
			mv.addObject("edit", "edit sucessfully");
			return mv;
		} else {
			ModelAndView mv = new ModelAndView("product");
			mv.addObject("list", pService.getAllProduct());
			mv.addObject("edit", "edit Unsucessfully");
			return mv;
		}

	}
	
	@RequestMapping("/admin/logout")
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

	@RequestMapping("/admin/orderList")
	public ModelAndView getOrderList(HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("orderList");
		mv.addObject("list", oai.getAllOrder());
		return mv;
	}

	@RequestMapping("/admin/feedbackManage")
	public ModelAndView getManagefeed(HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("manageFeedback");
		mv.addObject("list", fai.getAllFeedbak());
		return mv;
	}
	
	@RequestMapping("/admin/deleteFeedback")
	public ModelAndView deleteFeed(@ModelAttribute("feedback") Feedback feedback, BindingResult result,
			ModelMap model) {
		boolean res = fai.deleteFeedback(feedback);
		if (res) {
			ModelAndView mv = new ModelAndView("manageFeedback");
			mv.addObject("list", fai.getAllFeedbak());
			mv.addObject("delete", "Delete sucessfully");
			return mv;
		} else {
			ModelAndView mv = new ModelAndView("manageFeedback");
			mv.addObject("list", fai.getAllFeedbak());
			mv.addObject("delete", "Delete Unsucessfully");
			return mv;
		}

	}
	
	@RequestMapping("/admin/updateFeedback")
	public ModelAndView updateFeed(@ModelAttribute("feedback") Feedback feedback, BindingResult result,
			ModelMap model) {
		boolean res = fai.updateFeedback(feedback);
		if (res) {
			ModelAndView mv = new ModelAndView("manageFeedback");
			mv.addObject("list", fai.getAllFeedbak());
			mv.addObject("edit", "Edit sucessfully");
			return mv;
		} else {
			ModelAndView mv = new ModelAndView("manageFeedback");
			mv.addObject("list", fai.getAllFeedbak());
			mv.addObject("edit", "Edit Unsucessfully");
			return mv;
		}

	}
	
}
