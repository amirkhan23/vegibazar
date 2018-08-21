package com.vegibazar.dao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vegibazar.dao.entity.Product;
import com.vegibazar.dao.impl.ProductApiImpl;

@Service
@Transactional
public class ProductService {

	@Autowired
	ProductApiImpl productDAOImpl;

	public List<Product> getAllProduct()
	{
		return productDAOImpl.getAllProducts();
	}
	
	public boolean addProduct(Product product)
	{
		return productDAOImpl.addProduct(product);
	}
	
	public boolean deleteProduct(Product pId)
	{
		return productDAOImpl.deleteProduct(pId);
	}
	
	public boolean updateProduct(Product product)
	{
		return productDAOImpl.updateProduct(product);
	}
	
	public Product getProductById(int pId){
		return productDAOImpl.getProductById(pId);
		
	}
	
}
