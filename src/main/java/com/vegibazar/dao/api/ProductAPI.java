package com.vegibazar.dao.api;

import java.util.List;

import com.vegibazar.dao.entity.Product;

public interface ProductAPI {

	public List<Product> getAllProducts();
	public boolean addProduct(Product product);
	public boolean deleteProduct(Product product);
	public boolean updateProduct(Product product);
	public Product getProductById(int pId);
	public List<Product> getProductByName(String name);
}
